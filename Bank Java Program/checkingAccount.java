package Lab3;

public class checkingAccount extends Account{
	
	private String checkStyle;
	private double minimumBalance;
	
	public checkingAccount() {}
	
	public checkingAccount(String name, String address, String phone, String work,
			int account, double money, String date, String branch, String style, double minimum) {
		super(name, address, phone, work, account, money, date, branch);
		checkStyle = style;
		minimumBalance = minimum;
	}
	public checkingAccount(String business, String address, String phone,
			int credit, String contact, String contactPhone,
			int account, double money, String date, String branch,
			String style, double minimum) {
		super(business, address, phone, credit, contact, contactPhone, account, money, date, branch);
		checkStyle = style;
		minimumBalance = minimum;
	}
	
	public String getCheckStyle() {
		return checkStyle;
	}
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setCheckStyle(String checkStyle) {
		this.checkStyle = checkStyle;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public String toString() {
		return super.toString()+
				"\nCheck Style: "+checkStyle+
				"\nMinimum Balance: "+minimumBalance;
				
	}

}
