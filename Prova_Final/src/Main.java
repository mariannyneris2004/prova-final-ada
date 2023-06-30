import java.util.Scanner;

public class Main {
    public static double[][] descontos(double salariosBrutos[]){
        double salarioLiquido, descontoInss, descontoImpostoDeRenda, totalInss, totalImpostoDeRenda;
        double[][] descontos = new double[5][4];

        for (int i = 0; i < salariosBrutos.length; i++) {
            if (salariosBrutos[i] <= 1212){
                descontoInss = 0.075;
            } else if (salariosBrutos[i] > 1212 && salariosBrutos[i] <= 2427.35){
                descontoInss = 0.09;
            } else if (salariosBrutos[i] > 2427.35 && salariosBrutos[i] <= 3641.03){
                descontoInss = 0.12;
            } else {
                descontoInss = 0.14;
            }

            if (salariosBrutos[i] <= 1903.98){
                descontoImpostoDeRenda = 0;
            } else if (salariosBrutos[i] > 1903.99 && salariosBrutos[i] <= 2826.65){
                descontoImpostoDeRenda = 0.075;
            } else if (salariosBrutos[i] > 2826.65 && salariosBrutos[i] <= 3751.05){
                descontoImpostoDeRenda = 0.15;
            } else if (salariosBrutos[i] > 3751.05 && salariosBrutos[i] <= 4664.68){
                descontoImpostoDeRenda = 0.225;
            } else {
                descontoImpostoDeRenda = 0.275;
            }

            totalInss = salariosBrutos[i]*descontoInss;
            totalImpostoDeRenda = salariosBrutos[i]*descontoImpostoDeRenda;

            salarioLiquido = salariosBrutos[i] - totalInss - totalImpostoDeRenda;

            for (int j = 0; j < salariosBrutos.length - 1; j++) {
                switch (j){
                    case 0:
                        descontos[i][j] = salariosBrutos[i];
                        break;
                    case 1:
                        descontos[i][j] = totalInss;
                        break;
                    case 2:
                        descontos[i][j] = totalImpostoDeRenda;
                        break;
                    case 3:
                        descontos[i][j] = salarioLiquido;
                        break;
                }
            }
        }

        return descontos;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salariosBrutos = new double[5];
        double[][] descontos = new double[5][4];

        System.out.println("CÁLCULO DE SALÁRIO");
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print("Escreva o " + (i +1) + "º salário: R$");
            salariosBrutos[i] = scanner.nextDouble();
            System.out.println();
        }

        System.out.println("RESULTADOS: ");
        for (int i = 0; i < 5; i++) {
            descontos = descontos(salariosBrutos);
            System.out.println((i + 1) + "º salário:");
            System.out.printf("O salário bruto é de R$%.2f", descontos[i][0]);
            System.out.printf("\nO valor pago ao INSS é de R$%.2f", descontos[i][1]);
            System.out.printf("\nO valor pago de Imposto de Renda é de R$%.2f", descontos[i][2]);
            System.out.printf("\nO salário líquido é de R$%.2f", descontos[i][3]);

            System.out.println("\n");
        }

        scanner.close();
    }
}