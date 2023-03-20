
public class Company {

	// Attributes
	String Cname;
	Address Caddress;
	Phone Cphone;
	Team team;

	// Constructor
	public Company(String cname, Address caddress, Phone cphone, Team team) {
		super();
		Cname = cname;
		Caddress = caddress;
		Cphone = cphone;
		this.team = team;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public Address getCaddress() {
		return Caddress;
	}

	public void setCaddress(Address caddress) {
		Caddress = caddress;
	}

	public Phone getCphone() {
		return Cphone;
	}

	public void setCphone(Phone cphone) {
		Cphone = cphone;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}