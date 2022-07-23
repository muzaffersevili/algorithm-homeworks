public class Coach {
	
	//Attributes
	String name;
	Address coachAddress;
	Phone coachPhone;
	Team coachTeam;
	Date coachStartd;
	Date coachEndd;
	int salary;
	
	//Constructor
	public Coach(String name, Address coachAddress, Phone coachPhone, Team coachTeam, Date coachStartd, Date coachEndd,int salary) {
		this.name = name;
		this.coachAddress = coachAddress;
		this.coachPhone = coachPhone;
		this.coachTeam = coachTeam;
		this.coachStartd = coachStartd;
		this.coachEndd = coachEndd;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Address getCoachAddress() {
		return coachAddress;
	}

	public void setCoachAddress(Address coachAddress) {
		this.coachAddress = coachAddress;
	}

	public Phone getCoachPhone() {
		return coachPhone;
	}

	public void setCoachPhone(Phone coachPhone) {
		this.coachPhone = coachPhone;
	}

	public Team getCoachTeam() {
		return coachTeam;
	}

	public void setCoachTeam(Team coachTeam) {
		this.coachTeam = coachTeam;
	}

	public Date getCoachStartd() {
		return coachStartd;
	}

	public void setCoachStartd(Date coachStartd) {
		this.coachStartd = coachStartd;
	}

	public Date getCoachEndd() {
		return coachEndd;
	}

	public void setCoachEndd(Date coachEndd) {
		this.coachEndd = coachEndd;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
