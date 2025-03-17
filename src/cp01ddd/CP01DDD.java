package cp01ddd;

import java.util.Scanner;

public class CP01DDD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String placa = null;
        int horasEstacionado = 0;
        double valorTotal;
        boolean carroRegistrado = false;

        boolean sistemaAtivo = true;
        while (sistemaAtivo) {
            System.out.println("\n--- Sistema de Estacionamento ---");
            System.out.println("1. Consultar carro");
            System.out.println("2. Saída de carro");
            System.out.println("3. Registrar carro");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (carroRegistrado) {
                        System.out.println("Placa: " + placa);
                        System.out.println("Tempo de estacionamento: " + horasEstacionado + " horas");
                        System.out.println("Valor a pagar: R$ " + (horasEstacionado * 15.0));
                    } else {
                        System.out.println("Carro não encontrado no estacionamento.");
                    }
                    break;

                case 2:
                    if (carroRegistrado) {
                        carroRegistrado = false;
                        System.out.println("Carro com placa " + placa + " removido do estacionamento.");
                        placa = null;
                        horasEstacionado = 0;
                    } else {
                        System.out.println("Carro não encontrado no estacionamento.");
                    }
                    break;

                case 3:
                    if (carroRegistrado) {
                        System.out.println("Carro já registrado.");
                        break;
                    }

                    System.out.print("Digite a placa do carro: ");
                    placa = sc.nextLine();
                    System.out.print("Digite o número de horas que o carro ficou estacionado: ");
                    horasEstacionado = sc.nextInt();
                    sc.nextLine();

                    valorTotal = horasEstacionado * 15.0;
                    carroRegistrado = true;

                    System.out.println("Placa do carro: " + placa);
                    System.out.println("Tempo de estacionamento: " + horasEstacionado + " horas");
                    System.out.println("Valor a pagar: R$ " + valorTotal);
                    break;

                case 4:
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
