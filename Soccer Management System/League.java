
public class League {

	Team[] teams;
	Referee[] referees;
	Match[] matches;
	Stadium[] stadiums;
	private static int teams_count;
	private static int referee_count;
	private static int match_count;
	private static int stadium_count;
	Stadium biggest_stadium=new Stadium(0);
	
	League() {
		teams = new Team[21];
		referees = new Referee[50];
		matches = new Match[800];
		stadiums = new Stadium[60];
		teams_count = 0;
		referee_count = 0;
		match_count = 0;
		stadium_count = 0;
	}

	// AddMatch
	public void AddMatch(Match m) {
		matches[match_count] = m;
		match_count++;
	}

	// AddReferee
	public void AddReferee(Referee r) {
		referees[referee_count] = r;
		r.setRefereeID(referee_count + 1);
		referee_count++;
	}

	// AddStadium
	public void AddStadium(Stadium s) {
		stadiums[stadium_count] = s;
		s.setStadiumID(stadium_count + 1);
		stadium_count++;
	}

	// AddTeam
	public void AddTeam(Team t) {
		teams[teams_count] = t;
		teams_count++;
	}

	// ListTeam
	public void listTeam() {
		if (teams_count == 0)
			System.out.println("There are no team available");
		for (int i = 0; i < teams_count; i++) {
			if (teams[i] != null) {
				System.out.println("----------------------");
				System.out.println((i + 1) + " - Team");
				System.out.println("Name : " + teams[i].getName());
				System.out.println("Coach Name: " + teams[i].getCoach().getName());
				System.out.println("Foundation Year : " + teams[i].getYear());
				System.out.println("Number Of Cups: " + teams[i].getCups());
				System.out.println("Colors : " + teams[i].getColors());
			}
		}
	}
	
	// ListReferee
		public void listReferee() {
			if (referee_count == 0)
				System.out.println("There are no referee available");
			for (int i = 0; i < referee_count; i++) {
				if (referees[i] != null) {
					System.out.println("----------------------");
					System.out.println((i + 1) + " - Referee");
					System.out.println("Name : " + referees[i].getName());
					System.out.println("Address: " + referees[i].getR_address().getStreet()+" / "+referees[i].getR_address().getTown()+
							" / "+referees[i].getR_address().getCity()+" / "+ referees[i].getR_address().getCountry());
					System.out.println("Phone Number: +" + referees[i].getR_phone().getCcode()+" ("+referees[i].getR_phone().getAreaCode()+") "
							+referees[i].getR_phone().getNumber());
					System.out.println("Salary: " + referees[i].getSalary());
				}
			}
		}
		

	// ListSponsors

	public void listSponsors() {
		System.out.println("----------------------");
		System.out.println("---Sponsor Companies---");
		if (teams_count == 0)
			System.out.println("There are no sponsor company available");

		for (int i = 0; i < teams_count; i++) {
			if (teams[i] != null) {
				System.out.println((i + 1) + " - Team");
				System.out.println("	Team Name : " + teams[i].getName());
				System.out.println("	Company Name : " + teams[i].getTeam_sponsor().getCname());
			}
		}
	}

	// FindReferee
	public Referee FindReferee(int ID) {
		Referee referee = null;
		for (int i = 0; i < referees.length; i++) {
			if (referees[i] != null) {
				if (ID == referees[i].getRefereeID()) {
					referee = referees[i];
					return referee;
				}
			}
		}
		return null;
	}

	// FindStadium
	public Stadium FindStadium(int ID) {
		Stadium stadium = null;
		for (int i = 0; i < stadiums.length; i++) {
			if (stadiums[i] != null) {
				if (ID == stadiums[i].getStadiumID()) {
					stadium = stadiums[i];
					return stadium;
				}
			}
		}
		return null;
	}

	// FindTeam
	public Team FindTeam(String name) {
		Team team = null;
		for (int i = 0; i < teams.length; i++) {
			if (teams[i] != null) {
				if (name.equals(teams[i].getName())) {
					team = teams[i];
					return team;
				}
			}
		}
		return null;
	}

	// BiggestStadium
	private void FindBiggestStadium() {
		
		for (int i = 0; i < stadiums.length; i++) {
			if (stadiums[i]!=null &&biggest_stadium.getCapacity()<stadiums[i].getCapacity()) {
				biggest_stadium.setCapacity(stadiums[i].getCapacity());
				biggest_stadium.setCity(stadiums[i].getCityName());
				biggest_stadium.setLightning(stadiums[i].isLightning());
				biggest_stadium.setStadiumID(stadiums[i].getStadiumID());
				biggest_stadium.setSurface(stadiums[i].getSurface());
				biggest_stadium.setName(stadiums[i].getName());
			}
		}
	}
	
	//PrintBiggestStadium
	public void PrintBiggestStadium() {
		FindBiggestStadium();
		System.out.println("--------------------------------------------");
		System.out.print("Biggest Stadium ");
		System.out.println(" Name: "+ biggest_stadium.getName());
		System.out.println("		 City: "+ biggest_stadium.getCityName().getCity());
		System.out.println("		 Capacity: "+ biggest_stadium.getCapacity());
	}
	
	//SalaryIncrease
	public void IncreaseSalaries() {
			System.out.println("------------------------------------");
			System.out.println("Salaries Has been increased!");
			for(int i=0;i<referees.length;i++) {
				if(referees[i]==null) break;
				else {
					System.out.println("	Name: "+referees[i].getName()+"\n		Salary Before: "+String.format("%,.2f", referees[i].getSalary()));
					referees[i].setSalary(referees[i].getSalary()*1.1);
					String.valueOf(referees[i].getSalary());
					System.out.println("		Salary After:  "+String.format("%,.2f", referees[i].getSalary()));
				}
			}
		}
	
	//StadiumControl
	public boolean StadiumExist(int stadiumID) {
		
		for (int i = 0; i < stadiums.length; i++) {
			if(stadiums[i]!=null && stadiums[i].getStadiumID()==stadiumID) {
				return true;
			}
		}
		return false;
	}
	
	public void Winner() {
		for(int i=0;i<matches.length;i++) {
			
			if(matches[i]!=null) {
				for(int j=0;j<teams.length;j++) {
					
					if(teams[j]!=null) {
						if(matches[i].getAway_team().equals(teams[j]) && matches[i].getAway_numberofGoals()> matches[i].getHome_numberofGoals()) {
							teams[j].setScore(teams[j].getScore()+3);
							break;
						}
						
						else if(matches[i].getHome_team().equals(teams[j]) && matches[i].getAway_numberofGoals()< matches[i].getHome_numberofGoals()) {
							teams[j].setScore(teams[j].getScore()+3);
							break;
						}
						else {
							if(teams[j].equals(matches[i].getAway_team()) && matches[i].getAway_numberofGoals()==matches[i].getHome_numberofGoals()) {
								teams[j].setScore(teams[j].getScore()+1);
							}
							else if(teams[j].equals(matches[i].getHome_team()) && matches[i].getAway_numberofGoals()==matches[i].getHome_numberofGoals()) {
								teams[j].setScore(teams[j].getScore()+1);
								
							}
						}
					}
					
				}
			}
		}
	}
	
	public void CreateScoreboard() {
		Winner();
		for(int i=0;i<teams.length;i++) {
			for(int j=0;j<teams.length;j++) {
				
				if(teams[i]!=null && teams[j]!=null) {
					if(teams[i].getScore()>teams[j].getScore()) {
						Team temp_team=new Team(teams[i].getName(),teams[i].getYear(),teams[i].getCups(),teams[i].getColors());
						temp_team.setScore(teams[i].getScore());
						
						teams[i].setName(teams[j].getName());
						teams[i].setYear(teams[j].getYear());
						teams[i].setCups(teams[j].getCups());
						teams[i].setColors(teams[j].getColors());
						teams[i].setScore(teams[j].getScore());
						
						teams[j].setName(temp_team.getName());
						teams[j].setYear(temp_team.getYear());
						teams[j].setCups(temp_team.getCups());
						teams[j].setColors(temp_team.getColors());
						teams[j].setScore(temp_team.getScore());
					}
				}
				
			}
			
		}
		System.out.println("Scores:");
		for(int i=0;i<teams.length;i++) {
			if(teams[i]==null) break;
			else {
				System.out.println(teams[i].getName()+" "+ teams[i].getScore());
			}
		}
		System.out.println("\n\nWinner: "+ teams[0].getName());
	}
}
