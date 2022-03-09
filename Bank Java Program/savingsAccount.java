package Lab3;


public class savingsAccount extends Account {
	
	private double interestRate;

	public savingsAccount() {}
	
	public savingsAccount(String name, String address, String phone, String work,
			int account, double money, String date, String branch, double interestRate) {
		super(name, address, phone, work, account, money, date, branch);
		this.interestRate = interestRate;
	}
	public savingsAccount(String business, String address, String phone,
			int credit, String contact, String contactPhone,
			int account, double money, String date, String branch, double interestRate) {
		super(business, address, phone, credit, contact, contactPhone, account, money, date, branch);
		this.interestRate = interestRate;
	}
	

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void calculateInterest() {
		double temp = balance;
		balance = balance*interestRate;
		balance = temp+balance;
	}
	
	public String toString() {
		return super.toString()+
				"\nInterest Rate: "+interestRate;				
	}
	
}
