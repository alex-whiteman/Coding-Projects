package Lab3;


public class Account extends Customer implements Branch{
	
	private int accountNumber;
	protected double balance;
	private String dateOpened;
	private String branch;
	
	public Account() {}
	
	public Account(String name, String address, String phone, String work, int account, double money, String date, String branch) {
		super(name, address, phone, work);
		accountNumber = account;
		balance = money;
		dateOpened = date;
		this.branch = branch;
	}
	public Account(String business, String address, String phone,
			int credit, String contact, String contactPhone,
			int account, double money, String date, String branch) {
		super(business, address, phone, credit, contact, contactPhone);
		accountNumber = account;
		balance = money;
		dateOpened = date;
		this.branch = branch;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public String getOpenDate() {
		return dateOpened;
	}
	public String getBranchName() {
		return branch;
	}
	public void setAccountNumber(int number) {
		accountNumber = number;
	}
	public void setBalance(double money) {
		balance = money;
	}
	public void setOpenDate(String date) {
		dateOpened = date;
	}
	public void setBranchName(String branch) {
		this.branch = branch;
	}
	
	public void makeDeposit(double amount) {
		balance = balance+amount;
	}
	public void makeWithdrawal(double amount) {
		balance = balance-amount;
	}
	public void calculateInterest() {
		double temp = balance;
		balance = balance*.1;
		balance = temp+balance;
	}

	
	public String toString() {
		return  super.toString()+
				"\nAccount Number: " + accountNumber + 
				"\nBalance: " + balance + 
				"\nDate Opened: " + dateOpened+ 
				"\nBranch: " + branch;
	}

}
