package com.learnwithmosh;


/*
import java.text.NumberFormat;
import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter you name:");
		String name = scanner.nextLine().trim();
		System.out.println("Your name is " + name);
		
	      String result =NumberFormat.getPercentInstance().format(0.1);
		System.out.println(result);
		
	//	int income = 190_000;
//		boolean hasHighIncome = (income> 100_000);
//					
//		System.out.println(hasHighIncome);
		
		String className ="Economy";
		if(income > 100_000)
		className="First";
		System.out.println(className);
		
	//the Ternary operation.
		String className = (income > 100_000) ? "First": "Economy" ;
		
		System.out.println(className);
		
// Switch statements
		
		//String role ="visitor";
	//	Scanner scanner = new Scanner(System.in);
		switch(role) {
		case "admin":
			System.out.println(" You are an adminstrator");
			break;
			
		case "moderator":
			System.out.println(" You are a moderator");
			break;
		case "manager":
			System.out.println(" You are a manager");
			break;
		default:
			System.out.println(" You are a guest");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the role:");
		String  role = scanner.nextLine();
		
		
		switch(role) {
		case "admin":
			System.out.println(" You are an adminstrator");
			break;
			
		case "moderator":
			System.out.println(" You are a moderator");
			break;
		case "manager":
			System.out.println(" You are a manager");
			break;
		default:
			System.out.println(" You are a guest"); 
		}
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Number:");
		String  number = scanner.nextInt();
		 * 
		 * 
		 * if (number % 5 == 0 && number % 3 ==0)
			System.out.println(" buzzfizz");
		else if (number % 5 == 0)
			System.out.println(" buzz");
		else if (number % 3 == 0)
			System.out.println(" fizz");
		else 
			System.out.println(" number");
		
// loop statements
// for loop
		
		for (int i=0; i<5; i++) {
				System.out.println("Hello world");
				System.out.println("Namaste nepal");
	}
		
		for (int i=5; i>0; i--) {
			System.out.println("Hello world" + i);
			System.out.println("Namaste nepal");
}

	// while loop
		
		String input= "";
		Scanner scanner = new Scanner(System.in);
		
		while (!input.equals("quit")) {
		
			System.out.print("Enter a value:");
			input = scanner.next().toLowerCase();
			System.out.println(input);
	// do while loop
			
			String input= "";
			Scanner scanner = new Scanner(System.in);
			
			do {
			
				System.out.print("Enter a value:");
				input = scanner.next().toLowerCase();
				System.out.println(input);
			

			
		}while (!input.equals("quit"));		
		
		
		//break and continue 
		
		String input= "";
		Scanner scanner = new Scanner(System.in);
		
		while (!input.equals("quit")) {
		
			System.out.print("Enter a value:");
			input = scanner.next().toLowerCase();
			if(input.equals("pass"))
				continue;
			if(input.equals("quit"))
				break;
			System.out.println(input);
		
// while true and break combination
		
		String input= "";
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
		
			System.out.print("Enter a value:");
			input = scanner.next().toLowerCase();
			if(input.equals("pass"))
				continue;
			if(input.equals("quit"))
				break;
			System.out.println(input);
		}
		
// For-Each Loop
		
		String[] fruits = {"Apple","Mango","Orange"};
		
		for ( int i = fruits.length; i > 0; i--  )
			System.out.println(fruits[i]);
		
		for (String fruitcount : fruits )
			
		int a =5;
		int b=2;
		double c = Math.pow(a, b);
		
		System.out.println(c);
	
	String message1 = greetUser ("Madhu","Gyawali");
	String message2 = greetUser ("Pramsu","Gyawali");
	System.out.println(message1);
	System.out.println(message2);
	}//end of main method
	
	public static String greetUser(String firstName, String lastName) {
	
	return ("Hello "+ firstName +" "+lastName);
	}
		
}
*/


import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateBalance(
            int principal,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade
    ) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }
}
