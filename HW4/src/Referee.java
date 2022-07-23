
public class Referee {

	// Attributes
	String name;
	Address r_address;
	Phone r_phone;
	int salary;
	int refereeID;
	
	// Constructor
	public Referee(String name, Address r_address, Phone r_phone, int salary) {

		this.name = name;
		this.r_address = r_address;
		this.r_phone = r_phone;
		this.salary = salary;
	}

	
	public void setRefereeID(int refereeID) {
		this.refereeID = refereeID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getR_address() {
		return r_address;
	}

	public void setR_address(Address r_address) {
		this.r_address = r_address;
	}

	public Phone getR_phone() {
		return r_phone;
	}

	public void setR_phone(Phone r_phone) {
		this.r_phone = r_phone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getRefereeID() {
		return refereeID;
	}

}
