package projetopedrapapeltesoura;
// @author Filipe e Luis Felipe

import java.util.Scanner;

public class ProjetoPedraPapeltesoura {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner para capturar a entrada do jogador
        boolean manterJogo = true; // Controla se o jogo continua ou não
        int vitorias = 0;
        int derrotas = 0;
        int empates = 0;

        // Loop principal do jogo
        while (manterJogo) {

            // Exibe o menu com as opções
            System.out.println("==== MENU ==== ");
            System.out.println("o 0 → Pedra\n"
                    + "o 1 → Papel\n"
                    + "o 2 → Tesoura\n"
                    + "o 9 → Sair do jogo");

            int escolha = input.nextInt(); // Lê a escolha do jogador

            // Verifica se a escolha é válida (pedra, papel ou tesoura)
            if (escolha == 0 || escolha == 1 || escolha == 2) {

                // Gera jogada aleatória da IA (0 a 2)
                int jogadaIa = (int) (0 + Math.random() * 3);

                // Mostra o que a IA escolheu
                switch (jogadaIa) {
                    case 0:
                        System.out.println("Eu escolhi pedra!");
                        break;
                    case 1:
                        System.out.println("Eu escolhi papel!");
                        break;
                    case 2:
                        System.out.println("Eu escolhi tesoura!");
                        break;
                }

                // Verifica o resultado do jogo
                if (escolha == jogadaIa) {
                    // Empate
                    System.out.println("Resultado: Empate!");
                    System.out.println("Empatou? Heh, estamos no mesmo nível… por enquanto!");
                    empates++;
                } else if (
                    // Condições em que o jogador vence
                    (escolha == 0 && jogadaIa == 2) ||
                    (escolha == 1 && jogadaIa == 0) ||
                    (escolha == 2 && jogadaIa == 1)
                ) {
                    System.out.println("Resultado: Você venceu!");
                    System.out.println("Tá, foi sorte... mas na próxima eu volto pra ganhar!");
                    vitorias++;
                } else {
                    // Caso contrário, o jogador perdeu
                    System.out.println("Resultado: Você perdeu!");
                    System.out.println("Pedra, papel ou tesoura... tanto faz, eu sempre ganho! ✌");
                    derrotas++;
                }

                // Se já houve pelo menos uma rodada, pergunta se quer revanche
                if (vitorias > 0 || derrotas > 0 || empates > 0) {
                    System.out.println("Revanche?");
                    System.out.println("0 → Sim!");
                    System.out.println("1 → Não!");

                    int escolhaRevanche = input.nextInt();

                    if (escolhaRevanche == 0) {
                        continue; // Continua o jogo
                    } else if (escolhaRevanche == 1) {
                        // Mostra o placar final e encerra o jogo
                        System.out.println("====Placar Final ====");
                        System.out.println("Vitórias: " + vitorias);
                        System.out.println("Derrotas: " + derrotas);
                        System.out.println("Empates: " + empates);
                        System.out.println("Tchau!");
                        manterJogo = false;
                    } else {
                        // Entrada inválida na revanche
                        System.out.println("Inválido");
                        System.out.println("Tente novamente!");
                        continue;
                    }
                }

            } else if (escolha == 9) {
                // Sai do jogo
                System.out.println("Tchau!");
                manterJogo = false;
            } else {
                // Entrada inválida no menu principal
                System.out.println("Inválido");
                System.out.println("Tente novamente");
                continue;
            }
        }
    }
}