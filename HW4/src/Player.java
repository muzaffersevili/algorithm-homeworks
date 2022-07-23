
public class Player {

	// Attributes
	int license_number;
	String name_sname;
	Date birth_date;
	String nationality;
	Address p_address;
	Phone p_phone;
	Team p_team;
	Date start_date;
	Date end_date;
	int salary;
	String positional_role;
	
	public Player(int license_number, String name_sname, Date birth_date, String nationality, Address p_address,
			Phone p_phone, Team p_team, Date start_date, Date end_date, int salary, String positional_role) {
		this.license_number = license_number;
		this.name_sname = name_sname;
		this.birth_date = birth_date;
		this.nationality = nationality;
		this.p_address = p_address;
		this.p_phone = p_phone;
		this.p_team = p_team;
		this.start_date = start_date;
		this.end_date = end_date;
		this.salary = salary;
		this.positional_role = positional_role;
	}

	public int getLicense_number() {
		return license_number;
	}

	public void setLicense_number(int license_number) {
		this.license_number = license_number;
	}

	public String getName_sname() {
		return name_sname;
	}

	public void setName_sname(String name_sname) {
		this.name_sname = name_sname;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Address getP_address() {
		return p_address;
	}

	public void setP_address(Address p_address) {
		this.p_address = p_address;
	}

	public Phone getP_phone() {
		return p_phone;
	}

	public void setP_phone(Phone p_phone) {
		this.p_phone = p_phone;
	}

	public Team getP_team() {
		return p_team;
	}

	public void setP_team(Team p_team) {
		this.p_team = p_team;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPositional_role() {
		return positional_role;
	}

	public void setPositional_role(String positional_role) {
		this.positional_role = positional_role;
	}
	
}