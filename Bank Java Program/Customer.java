package Lab3;

public class Customer {

	//variables
	protected String name;
	protected String address;
	protected String phone;
	protected int creditRating;
	protected String contactName;
	protected String contactPhone;
	protected String workPhone;
	
	//constructors
	public Customer() {}
	
	public Customer(String name, String address, String phone, String work) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		workPhone = work;
	}
	public Customer(String business, String address, String phone,
			int credit, String contact, String contactPhone) {
		name = business;
		this.address = address;
		this.phone = phone;
		creditRating = credit;
		contactName = contact;
		this.contactPhone = contactPhone;
		
	}
	
	//getter and setter methods
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return  phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRating() {
		return creditRating;
	}
	public String getContact() {
		return contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setRating(int rating) {
		creditRating = rating;
	}
	public void setContact(String contact) {
		contactName = contact;
	}
	public void setContactPhone(String phone) {
		contactPhone = phone;
	}
	public void setWork(String work) {
		workPhone = work;
	}
	public String getWork() {
		return workPhone;
	}
	

	public String toString() {
		return "Account Holder: "+name+
				"\nAccount Address: "+address+
				"\nAccount Phone: "+phone+
				"\nCredit Rating: "+creditRating+
				"\nContact Name: "+contactName+
				"\nContact Phone: "+contactPhone+
				"\nWork Phone: "+workPhone;
	}
}
