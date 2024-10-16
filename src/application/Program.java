package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int payers = sc.nextInt();
		
		for (int i = 0; i < payers; i++) {
			System.out.println();
			System.out.printf("Digite os dados do %dº contribuinte:\n", (i + 1));
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			
			TaxPayer tp = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
			list.add(tp);
					
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			System.out.printf("Resumo do %dº contribuinte:%n", (i + 1));
			System.out.println(list.get(i));
		}
		
		sc.close();
		

	}

}
