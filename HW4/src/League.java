
public class League {

	Team[] teams;
	Referee[] referees;
	Match[] matches;
	Stadium[] stadiums;
	private static int teams_count;
	private static int referee_count;
	private static int match_count;
	private static int stadium_count;
	
	League() {
		teams = new Team[21];
		referees = new Referee[100];
		matches = new Match[100];
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
			r.setRefereeID(referee_count+1);
			referee_count++;
		}	
		
	// AddStadium
		public void AddStadium(Stadium s) {
			stadiums[stadium_count] = s;
			s.setStadiumID(stadium_count+1);
			stadium_count++;
		}
		
	// AddTeam
	public void AddTeam(Team t) {
		teams[teams_count] = t;
		teams_count++;
	}
	
	// ListStadium
	public void listS() {
		
		for (int i = 0; i < stadium_count; i++) {
			if (stadiums[i] != null) {
				System.out.println("----------------------");
				System.out.println((i + 1) + " - Office");
				System.out.println("PhoneNumber : " + stadiums[i].getCity());
				System.out.println("PhoneNumber : " + stadiums[i].getCapacity());
				System.out.println("PhoneNumber : " + stadiums[i].getName());
				System.out.println("PhoneNumber : " + stadiums[i].getStadiumID());
				System.out.println("----------------------");
			}
		}

	}
	
	//FindReferee
	public Referee FindReferee(int ID) {
		Referee referee=null;
		for (int i = 0; i < referees.length; i++) {
			if(referees[i]!=null) {
				if(ID==referees[i].getRefereeID()) {
					referee=referees[i];
					return referee;
				}
			}
		}
		return null;
	}
	
	
	//FindStadium
		public Stadium FindStadium(int ID) {
			Stadium stadium=null;
			for (int i = 0; i < stadiums.length; i++) {
				if(stadiums[i]!=null) {
					if(ID==stadiums[i].getStadiumID()) {
						stadium=stadiums[i];
						return stadium;
					}
				}
			}
			return null;
		}
		
	//FindTeam
		public Team FindTeam(String name) {
			Team team=null;
			for (int i = 0; i < teams.length; i++) {
				if(teams[i]!=null) {
					if(name.equals(teams[i].getName())) {
						team=teams[i];
						return team;
					}
				}
			}
			return null;
		}
		
}
