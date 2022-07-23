
public class Team {
	
	//Attributes
	private String name;
	private int year;
	private int cups;
	private String colors;
	private static int player_count;
	private static int coach_count;
	private static int company_count;
	Player[] players;
	Coach[] coaches;
	Company[] companies;
	
	//Constructor
	Team(String inputName,int inputYear,int inputCups,String inputColors){
		name=inputName;
		year=inputYear;
		cups=inputCups;
		colors=inputColors;
		players=new Player[630];
		coaches=new Coach[21];
		companies=new Company[100];
		player_count=0;
		coach_count=0;
		company_count=0;
	}
	Team(String inputName){
		name=inputName;
	}
	//Getters
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

	//Setters
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
	
	
	//AddPlayer
		public void AddPlayer(Player p) {
			players[player_count] = p;
			player_count++;
		}
		
	//AddCoach
		public void AddCoach(Coach c) {
			coaches[coach_count] = c;
			coach_count++;
		}
		
		//ListPlayer
		public void listPlayer() {
				if (player_count == 0)
					System.out.println("There are no player available");
				else {
					for (int i = 0; i < player_count; i++) {
						if(players[i]!=null) {
							System.out.println("----------------------");
							System.out.println((i + 1) + ". - Player");
							System.out.println("Name : " + players[i].getName_sname());
							System.out.println("Team : " + players[i].getP_team().getName());
							System.out.println("License Number : " + players[i].getLicense_number());
						}
					}			
				}
		}
		
	//AddCompany
		public void AddCompany(Company comp) {
			companies[company_count] = comp;
			company_count++;
		}
}
