package javaCrashCourse;

import java.text.NumberFormat;
import java.util.Scanner;


//mortgage calculator
public class Main {

	public static void main(String[] args) {
		mortgageCalculator();
	
	}

	public static void mortgageCalculator() {
		final byte MONTHS_IN_YEARS = 12;
		final byte PERCENT = 100;
		double mortgage;
		double monthlyInterest;
		float principal;
		Scanner scanner = new Scanner(System.in);
		
		do {
		System.out.print("Principal (1k-1m): ");
		principal = scanner.nextFloat();
		if (principal<1000 || principal >1000000) {
			System.out.println("Enter a value between 1000 and 1000000");
			continue;
			}
		break;
		}while (true);
		
		do {
		System.out.print("Annual Interest Rate: ");
		Float annualInterest = scanner.nextFloat();
		monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEARS;
		if (annualInterest < 0 || annualInterest > 100) {
			System.out.println("Enter a value between 0 and 100");
			continue;
		}
		break;
		} while (true);
		
		
		
		do {
		System.out.print("Period (Years): ");
		byte paymentYears = scanner.nextByte();
		if (paymentYears < 10 || paymentYears > 50) {
			System.out.println("Enter a value between 10 and 50");
			continue;
		}
		float paymentMonths = (paymentYears * MONTHS_IN_YEARS);
		
		mortgage = principal * ((monthlyInterest * (Math.pow(1 + monthlyInterest, paymentMonths)))
				/ (Math.pow(1 + monthlyInterest, paymentMonths) - 1));
		break;
		} while(true);
		
		

		System.out.print("Mortage: " + NumberFormat.getCurrencyInstance().format(mortgage));
		scanner.close();
	}

	public static void fizzbuzz() {
		//if it is divisible by 5 return fizz
		//if it is divisible by 3 return buzz
		//if it is divisible by both return fizzbuzz
		//if it is not divisible by 5 or 3 return same number
		
		//get input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a number: ");
		byte number = scanner.nextByte();
		
		
		if (number%5==0 && number%3==0) 
			System.out.println("fizzbuzz");
		else if (number%5==0)
			System.out.println("fizz");
		else if (number%3==0)
			System.out.println("buzz");
		else
			System.out.println(number);
		scanner.close();
		
	}
}
