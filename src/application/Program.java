package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payer: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char resp = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual Income: ");
			double annualIncome = sc.nextDouble();
			if(resp == 'i') {
				System.out.print("Health Expenditures: ");
				double health = sc.nextDouble();
				
				list.add(new Individual(name, annualIncome, health));
			}
			else {
				System.out.print("Number of employees: ");
				int numberEmployee = sc.nextInt();
				
				list.add(new Company(name, annualIncome, numberEmployee));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		for(TaxPayer tx : list) {
			System.out.println(tx.getName() + ": $ " + String.format("%.2f", tx.tax()));
		}
		
		System.out.println();
		double sum = 0.0;
		for(TaxPayer tx : list) {
			sum += tx.tax();
		}
		
		System.out.print("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}

}
