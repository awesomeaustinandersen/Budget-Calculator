import java.util.Scanner;
import java.lang.Math;

/**
 * @author Austin Andersen
 * @date 14 September 2021
 * The purpose of this class is to calculate how much money Tasha and I make, how much we can save,
 * how big of a loan we could afford, and how long it will take to save for a downpayment
 */
public class MoneyCalculator {

	
	
	public static void main(String[] args) {
		
		double myPayCheck = 750;
		double myCarInsurance = 110;
		double additionalExpenses = 0;
		double tuition = 350;
		double livingAmount = 400; //Amount of money we can live off of for two weeks (Groceries, gas, etc)
		
		//My girlfriend's financial info. It was unknown at the time
		double tashaPayCheck = 0;
		double tashaCarInsurance = 0;
		double tashaCarPayment = 0;
		double tashaCostLiving = 0;
		double tashaCounseling = 222;
		
		double rent = 600;
		double down = 12000;
		double apr = 0.03;
		double mortgage = 400000;
		double years = 30;
		
		//Calculates the monthly interest rate
		double monthlyApr = apr/12;
		
		//Assigns the monthly payment derived by this function to mortgageRate
		double mortgageRate = (mortgage*monthlyApr*(Math.pow(1 + monthlyApr, years*12)))/(Math.pow(1+monthlyApr, years*12)-1);
		
		double mySavings = 0;
		double tashaSavings = 0;
		
		Scanner inputScan = new Scanner(System.in);
		String input = "";
		
		System.out.println(mortgageRate);
		
		System.out.print("Hello there Austin! Welcome to your financial calculator\nLets Begin! It looks"
				+ "like your biweekly paycheck averages at $" + myPayCheck + ". Is this still the case? "
						+ "(Y/N) ");
		
		input = inputScan.nextLine();
		
		if(input.toLowerCase().equals("y")) {
			System.out.print("\nExcellent. ");
		} else if(input.toLowerCase().equals("n")) {
			System.out.println("What is your new average paycheck amount? (Leave off the '$'): ");
			myPayCheck = Double.parseDouble(inputScan.nextLine());
		} else {
			System.out.println("\nInvalid input, moving on. ");
		}
		
		System.out.print("It looks like your current car insurance amount is $" + myCarInsurance + "/month. "
				+ "Is this still correct? (Y/N) ");
		
		input = inputScan.nextLine();
		
		if(input.toLowerCase().equals("y")) {
			System.out.print("\nExcellent. ");
		} else if(input.toLowerCase().equals("n")) {
			System.out.println("What is your new car insurance amount? (Leave off the '$'): ");
			myCarInsurance = Double.parseDouble(inputScan.nextLine());
		} else {
			System.out.println("\nInvalid input, moving on. ");
		}
		
		System.out.print("Are there any additional payments that need to be included? (Y/N) ");
		
		input = inputScan.nextLine();
		
		if(input.toLowerCase().equals("n")) {
			System.out.println();
		} else if(input.toLowerCase().equals("y")) {
			System.out.println("Please enter in the amount (Leave off the '$'): ");
			additionalExpenses = Double.parseDouble(inputScan.nextLine());
		} else {
			System.out.println("\nInvalid input, moving on. ");
		}
		
		System.out.println("\n=======================================================");
		System.out.println("\nAustin's pay check: $" + myPayCheck + "\nAustin's car insurance: $"
				+ myCarInsurance + "\nAdditional Expenses: $" + additionalExpenses);
		
		//-------------------------------------------------------------------------------
		
		System.out.print("\nNow we need Tasha's information. First we are going to need her biweekly"
				+ " average paycheck: (Leave off the '$': ");
		
		tashaPayCheck = Double.parseDouble(inputScan.nextLine());
		
		System.out.print("\nWhat is Tasha's current car insurance payment? ");
		
		tashaCarInsurance = Double.parseDouble(inputScan.nextLine());
		
		System.out.print("\nWhat is Tasha's current car payment? ");
		
		tashaCarPayment = Double.parseDouble(inputScan.nextLine());
		
		System.out.print("\nWhat is Tasha's cost of living? ");
		
		tashaCostLiving = Double.parseDouble(inputScan.nextLine());
		
		System.out.println("\n=======================================================");
		System.out.println("\nTasha's pay check: $" + tashaPayCheck + "\nTasha's car insurance: $" +
		tashaCarInsurance + "\nTasha's car payment: $" + tashaCarPayment + "\nTasha's cost of living: $"
		+ tashaCostLiving + "\nTasha's counseling: $" + tashaCounseling);
		
		//-------------------------------------------------------------------------------
		
		System.out.print("\nWhat are Austin's savings? ");
		
		mySavings = Double.parseDouble(inputScan.nextLine());
		
		System.out.print("What are Tasha's savings? ");
		
		tashaSavings = Double.parseDouble(inputScan.nextLine());
		
		double yearlyPayment = (myPayCheck * 24) + 600 + (tashaPayCheck * 24);
		
		double yearlyExpenses = ((myCarInsurance + tashaCarInsurance + tashaCostLiving + tashaCarPayment
				+ additionalExpenses + tashaCounseling + rent + tuition + (livingAmount * 2)) * 12);
		
		double yearlySavings = yearlyPayment - yearlyExpenses;
		
		double yearsForDown = (down - mySavings - tashaSavings)/yearlySavings;
		
		System.out.println("\n\nHow much we make: " + yearlyPayment/12 + " per month");
		System.out.println("How much we spend: " + yearlyExpenses/12 + " per month");
		System.out.println("How much we can pay monthly: " + ((yearlySavings/12)+rent));
		System.out.println("\nWe will assume we are going to have a $400,000 Mortgage. For a 3% downpayment of 12,000, \nit would take us " + yearsForDown*12 + " months to save enough money");
		System.out.println("\nOur monthly payment would be " + mortgageRate + " plus 170 for utilities, compared to the " + ((yearlySavings/12)+rent) + " we save");
		System.out.println("\nAfter our monthly payment and utilities (170/month), we would have $" + (((yearlySavings/12)+rent)-mortgageRate-170));
		
	}

}
