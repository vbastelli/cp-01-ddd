package cp01ddd;

import java.util.Scanner;

public class CP01DDD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variáveis para armazenar os dados
        String placa = null;
        int horasEstacionado = 0;
        double valorTotal;
        boolean carroRegistrado = false;

        // Loop principal do menu
        boolean sistemaAtivo = true;
        while (sistemaAtivo) {
            // Exibe o menu para o usuário
            System.out.println("\n--- Sistema de Estacionamento ---");
            System.out.println("1. Consultar carro");
            System.out.println("2. Saída de carro");
            System.out.println("3. Registrar carro");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();  // Limpar o buffer de entrada

            switch (opcao) {
                case 1:  // Consultar carro
                    if (carroRegistrado) {
                        System.out.println("Placa: " + placa);
                        System.out.println("Tempo de estacionamento: " + horasEstacionado + " horas");
                        System.out.println("Valor a pagar: R$ " + (horasEstacionado * 15.0));
                    } else {
                        System.out.println("Carro não encontrado no estacionamento.");
                    }
                    break;

                case 2:  // Saída de carro
                    if (carroRegistrado) {
                        carroRegistrado = false;
                        System.out.println("Carro com placa " + placa + " removido do estacionamento.");
                        placa = null;
                        horasEstacionado = 0;
                    } else {
                        System.out.println("Carro não encontrado no estacionamento.");
                    }
                    break;

                case 3:  // Registrar carro
                    if (carroRegistrado) {
                        System.out.println("Carro já registrado.");
                        break;
                    }

                    System.out.print("Digite a placa do carro: ");
                    placa = sc.nextLine();
                    System.out.print("Digite o número de horas que o carro ficou estacionado: ");
                    horasEstacionado = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer

                    valorTotal = horasEstacionado * 15.0;
                    carroRegistrado = true;

                    // Exibe as informações
                    System.out.println("Placa do carro: " + placa);
                    System.out.println("Tempo de estacionamento: " + horasEstacionado + " horas");
                    System.out.println("Valor a pagar: R$ " + valorTotal);
                    break;

                case 4:  // Sair
                    sistemaAtivo = false;
                    System.out.println("Sistema de Estacionamento encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }
}