package com.learnwithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
	final static byte MONTHS_IN_YEAR = 12;
	 final static byte PERCENT = 100;

public static void main(String[] args) {
		int principal =(int)readNumber("Enter Principal:",1000,1000000);
		float annualInterest =(float)readNumber("Enter Annual Interset Rate :",1,30);
		byte years =(byte)readNumber("Enter Payment Years:",1,30);
	    		
		double mortgage = calculateMortgage(principal, annualInterest, years);
		
		String formatedMortgage=NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println();
		System.out.println("MORTGAGE");
		System.out.println("---------");
		System.out.println("Monthly Payments=" + formatedMortgage) ;
		
		System.out.println();
		System.out.println("PAYMENT SCHEDULE");
		System.out.println("----------------");
		
		for(short month=1; month< years* MONTHS_IN_YEAR; month++) {
			short numbersOfPaymentsMade=month;
		double balance = calculateBalance (principal, annualInterest, years, numbersOfPaymentsMade); 
				System.out.println(NumberFormat.getCurrencyInstance().format(balance));	
		}
		
}

public static double readNumber( String prompt, double min, double max) {
	Scanner scanner = new Scanner(System.in);
	double value;
	
	while(true) {
		System.out.print(prompt);
		value= scanner.nextFloat();
		if (value >= min && value <=max)
		break;
		System.out.println("Enter value between "+ min + "and "+ max);
		}
	return value;
}

public static double calculateBalance (
		int principal, 
		float annualInterest, 
		byte years,
		short numbersOfPaymentsMade )
{   
	
	float monthlyInterest= annualInterest/MONTHS_IN_YEAR/PERCENT;
    float numbersOfPayments= years * MONTHS_IN_YEAR;
    numbersOfPaymentsMade=0;
    double balance = principal * ((Math.pow((1+monthlyInterest), numbersOfPayments)- Math.pow((1+monthlyInterest), numbersOfPaymentsMade))
    		/(Math.pow((1+monthlyInterest), numbersOfPayments)-1));
    
    return balance;
	}

public static double calculateMortgage (
		int principal, 
		float annualInterest, 
		byte years  ) {
	    
	    float monthlyInterest= annualInterest/PERCENT/MONTHS_IN_YEAR;
	    int numbersOfPayments= years * MONTHS_IN_YEAR;
	   
	    double mortgage = principal/((Math.pow((1+ monthlyInterest), numbersOfPayments) -1)/(monthlyInterest*(Math.pow((1+ monthlyInterest), numbersOfPayments)))) ;
		
	   return mortgage;
   }
	
	
}
