import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		try {
			FileInputStream file = new FileInputStream("D:\\input.txt");
			FileInputStream file2 = new FileInputStream("D:\\input.txt");

			Scanner scan = new Scanner(file, "UTF-8");
			Scanner scan2 = new Scanner(file2, "UTF-8");
			int team_count = 0;
			
			while (scan2.hasNextLine()) {
				String str2 = scan2.nextLine();
				if (str2.startsWith("AddTeam"))
					team_count++;

			}
			scan2.close();

			Team[] new_team = new Team[team_count];
			int count = 0;
			League superlig = new League();
			
			while (scan.hasNextLine()) {
				String str = scan.nextLine();
				
				if (str.startsWith("AddTeam") == true) {

					String[] i = str.split(";");
					new_team[count] = new Team(i[1], Integer.parseInt(i[2]), Integer.parseInt(i[3]), i[4]);
					superlig.AddTeam(new_team[count]);
					count++;
					
				} else if (str.startsWith("AddCoach") == true) {
					
					String[] i = str.split(";");
					Address c_address=new Address(i[2],i[3],i[4],i[5]);
					Phone p_phone=new Phone(Integer.parseInt(i[6]),Integer.parseInt(i[7]),Integer.parseInt(i[8]));
					Team c_team=superlig.FindTeam(i[9]);
					Date startd=new Date(Integer.parseInt(i[10]),Integer.parseInt(i[11]),Integer.parseInt(i[12]));
					Date endd=new Date(Integer.parseInt(i[13]),Integer.parseInt(i[14]),Integer.parseInt(i[15]));
					
					for (int j = 0; j < new_team.length; j++) {
						if (new_team[j] != null && new_team[j].getName().equalsIgnoreCase(i[9])) {
							Coach new_coach = new Coach(i[1], c_address, p_phone, c_team, startd,endd, Integer.parseInt(i[16]));
							new_team[j].AddCoach(new_coach);
						}
					}
				}

				else if (str.startsWith("AddPlayer") == true) {

					String[] i = str.split(";");
					Team p_team=superlig.FindTeam(i[14]);
					Date bdate=new Date(Integer.parseInt(i[3]),Integer.parseInt(i[4]),Integer.parseInt(i[5]));
			        Address p_address=new Address(i[7],i[8],i[9],i[10]);
			        Phone p_phone=new Phone(Integer.parseInt(i[11]),Integer.parseInt(i[12]),Integer.parseInt(i[13]));
			        Date startd=new Date(Integer.parseInt(i[15]),Integer.parseInt(i[16]),Integer.parseInt(i[17]));
			        Date endd=new Date(Integer.parseInt(i[18]),Integer.parseInt(i[19]),Integer.parseInt(i[20]));
			        
					for (int j = 0; j < new_team.length; j++) {
						if (new_team[j] != null && new_team[j].getName().equals(i[14])) {
					           Player new_player=new Player(Integer.parseInt(i[1]),i[2],bdate,i[6],p_address,p_phone,p_team,startd,endd,
					        		   Integer.parseInt(i[21]),i[22]);
							new_team[j].AddPlayer(new_player);
						}
					}
				}

				else if (str.startsWith("AddStadium") == true) {

					String[] i = str.split(";");
					Address s_address=new Address("","",i[2],"");
					Stadium new_stadium = new Stadium(i[1], s_address, Integer.parseInt(i[3]), Boolean.valueOf(i[4]), i[5]);
					superlig.AddStadium(new_stadium);
					//System.out.println(new_stadium.getCapacity());

				} else if (str.startsWith("AddReferee") == true) {
					String[] i = str.split(";");
					
					Address r_address=new Address(i[2],i[3],i[4],i[5]);
					Phone r_phone=new Phone(Integer.parseInt(i[6]),Integer.parseInt(i[7]),Integer.parseInt(i[8]));
					
					Referee new_referee = new Referee(i[1], r_address, r_phone, Integer.parseInt(i[9]));
					superlig.AddReferee(new_referee);
					// System.out.println(new_referee.getName());

				}

				else if (str.startsWith("AddCompany") == true) {
					String[] i = str.split(";");

					Address comp_address=new Address(i[2],i[3],i[4],i[5]);
			        Phone comp_phone=new Phone(Integer.parseInt(i[6]),Integer.parseInt(i[7]),Integer.parseInt(i[8]));
			        Team comp_team=superlig.FindTeam(i[9]);
			        
					for (int j = 0; j < new_team.length; j++) {
						if (new_team[j].getName().equalsIgnoreCase(i[9])) {
							Company new_company = new Company(i[1], comp_address , comp_phone, comp_team);
							new_team[j].AddCompany(new_company);
							// System.out.println(new_company.getCname());
						}
					}
				} 
				else if (str.startsWith("AddMatch") == true) {
					String[] i = str.split(";");
					Team home_team=superlig.FindTeam(i[1]);
					Team away_team=superlig.FindTeam(i[3]);
					Referee r1=superlig.FindReferee(Integer.parseInt(i[5]));
					Referee r2=superlig.FindReferee(Integer.parseInt(i[6]));
					Referee r3=superlig.FindReferee(Integer.parseInt(i[7]));
					Referee [] referees= {r1,r2,r3};
					Match new_match = new Match(home_team, Integer.parseInt(i[2]), away_team, Integer.parseInt(i[4]),referees);
					superlig.AddMatch(new_match);
					
					//System.out.println(new_match.away_numberofGoals);
				}

				else if (str.startsWith("DeletePlayer") == true) 
				{
					String[] i = str.split(";");
					
					for (int j = 0; j < new_team.length; j++) {
						
						for(int k=0; k< new_team[j].players.length;k++) {
							
							if(new_team[j].players[k]!=null &&new_team[j].players[k].getLicense_number()==Integer.parseInt(i[1]))
							new_team[j].players[k]=null;
						}
						}					
					}
				}
			
			scan.close();
			
			for(int j=0;j<new_team.length;j++) {
				new_team[j].listPlayer();
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
		
}