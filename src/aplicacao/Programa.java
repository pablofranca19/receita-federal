package aplicacao;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        List<Pessoa> list = new ArrayList<>();
        Pessoa pessoa;

        System.out.print("Insira o número de dividendos: ");
        int dividendos = read.nextInt();
        read.nextLine();

        for (int i = 0; i < dividendos; i++) {
            System.out.println("Dados do dividendo #" + (i+1) + ":");
            System.out.print("Individual ou empresa (i/c)? ");
            char input = read.next().toLowerCase().charAt(0);
            read.nextLine();
            if (input == 'i') {
                System.out.print("Nome: ");
                String nome = read.nextLine();
                System.out.print("Anual income: ");
                Double annualIncome = read.nextDouble();
                read.nextLine();
                System.out.print("Expedição de saúde: ");
                Double expedicaoSaude = read.nextDouble();
                read.nextLine();
                list.add(new PessoaFisica(nome, annualIncome, expedicaoSaude));
            } else {
                System.out.print("Nome: ");
                String nome = read.nextLine();
                System.out.print("Anual income: ");
                Double annualIncome = read.nextDouble();
                read.nextLine();
                System.out.print("Número de empregados: ");
                Integer nmrEmpregados = read.nextInt();
                read.nextLine();
                list.add(new PessoaJuridica(nome, annualIncome, nmrEmpregados));
            }
        }

        System.out.println();
        System.out.println("IMPOSTOS PAGOS: ");
        for (Pessoa pes : list) {
            System.out.println(pes.getNome() + ": $" + String.format("%.2f", pes.impostoArrecadado()));
        }
        System.out.println();

        Double total = 0.0;

        for (Pessoa pes : list) {
            total += pes.impostoArrecadado();
        }
        System.out.printf("IMPOSTOS TOTAIS: $ %.2f", total);

    }
}
