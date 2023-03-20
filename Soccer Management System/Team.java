
public class Team {

	// Attributes
	private String name;
	private int year;
	private int cups;
	private String colors;
	private static int player_count;
	Player[] players;
	Company team_sponsor;
	int score;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// Constructor
	Team(String inputName, int inputYear, int inputCups, String inputColors) {
		name = inputName;
		year = inputYear;
		cups = inputCups;
		colors = inputColors;
		players = new Player[630];
		player_count = 0;
		score=0;
	}

	Team(String inputName) {
		name = inputName;
	}

	public Company getTeam_sponsor() {
		return team_sponsor;
	}

	public void setTeam_sponsor(Company team_sponsor) {
		this.team_sponsor = team_sponsor;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public int getCups() {
		return cups;
	}

	public String getColors() {
		return colors;
	}

	// Setters
	public void setName(String inputName) {
		name = inputName;
	}

	public void setYear(int inputYear) {
		year = inputYear;
	}

	public void setCups(int inputCups) {
		cups = inputCups;
	}

	public void setColors(String inputColors) {
		colors = inputColors;
	}

	public Team.Coach getCoach() {
		return coach;
	}

	public void setCoach(Team.Coach coach) {
		this.coach = coach;
	}

	private Team.Coach coach;

	public class Coach {

		// Attributes
		String name;
		Address coachAddress;
		Phone coachPhone;
		Team coachTeam;
		Date coachStartd;
		Date coachEndd;
		int salary;

		// Constructor
		public Coach(String name, Address coachAddress, Phone coachPhone, Team coachTeam, Date coachStartd,
				Date coachEndd, int salary) {
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

	// AddPlayer
	public void AddPlayer(Player p) {
		players[player_count] = p;
		player_count++;
	}

	// ListPlayer
	public void listPlayer() {
		if (player_count == 0)
			System.out.println("There are no player available");
		else {
			for (int i = 0; i < player_count; i++) {
				if (players[i] != null) {
					System.out.println("----------------------");
					System.out.println("-Player Informations-\n");
					System.out.println("License Number : " + players[i].getLicense_number());
					System.out.println("Name : " + players[i].getName_sname());
					System.out.println("Team : " + players[i].getP_team().getName());
					System.out.println("Birthdate : " + players[i].getBirth_date().getDay() + "."
							+ players[i].getBirth_date().getMonth() + "." + players[i].getBirth_date().getYear());
					System.out.println("Nationality : " + players[i].getNationality());
					System.out.println("Positional Role: " + players[i].getPositional_role());
				}
			}
		}
	}

}
