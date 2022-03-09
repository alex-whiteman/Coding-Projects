package Lab3;

import java.util.ArrayList;

public class Bank {
	
	public static void main(String[]args) {
		
		//part a
		ArrayList<Account> accounts = new ArrayList<>();
		accounts.add(0, new checkingAccount("AutoZone","1234 S Main", "7651111111",720,
				"Brian","7651234567",1,1000,"11/05/2019", "Kokomo", "Business Check", 10));
		
		//part b
		System.out.println("Before deposit: \n");
		System.out.println(accounts.get(0).toString());
		
		//part c
		accounts.get(0).makeDeposit(100);
		System.out.println("\nAfter deposit: ");
		System.out.println("\n"+accounts.get(0).toString());
		
		//part d
		accounts.add(1, new savingsAccount("Billy Bob", "1234 N Washington",
				"7659876543", "3171012345", 2, 100,"11/01/18", "Texarcana", .1));
	
		//part e
		System.out.println("\nBefore interest and deposit calculation: ");
		System.out.println("\n"+accounts.get(1).toString());
		
		//part f
		accounts.get(1).makeDeposit(100);
		accounts.get(1).calculateInterest();
		System.out.println("\n"+accounts.get(1).toString());
		
	
		//part g
		System.out.println("\nWithdraw from account 1: ");
		accounts.get(0).makeWithdrawal(2000);
		System.out.println("\n"+accounts.get(0).toString());
	}
}
