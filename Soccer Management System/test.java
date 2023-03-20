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
			int count2 =1;
			while (scan.hasNextLine()) {
				String str = scan.nextLine();

				if (str.startsWith("AddTeam") == true) {

					String[] i = str.split(";");
					new_team[count] = new Team(i[1], Integer.parseInt(i[2]), Integer.parseInt(i[3]), i[4]);
					superlig.AddTeam(new_team[count]);
					count++;

				} 
				else if (str.startsWith("AddCoach") == true) {

					String[] i = str.split(";");

					Address c_address = new Address(i[2], i[3], i[4], i[5]);
					Phone p_phone = new Phone(Integer.parseInt(i[6]), Integer.parseInt(i[7]), Integer.parseInt(i[8]));
					Team coach_team = superlig.FindTeam(i[9]);
					Date startd = new Date(Integer.parseInt(i[10]), Integer.parseInt(i[11]), Integer.parseInt(i[12]));
					startd.DateControl(startd);
					Date endd = new Date(Integer.parseInt(i[13]), Integer.parseInt(i[14]), Integer.parseInt(i[15]));
					endd.DateControl(endd);
					
					
					if (!startd.DateControl(startd)) {
						System.out.println("According to date standards, for the player named" + i[2]
								+ ", cannot be such a contract start date!"+"(Line "+ count2+")");
					} 
					else if (!endd.DateControl(endd)) {
						System.out.println("According to date standards, for the player named" + i[2]
								+ ", cannot be such a contract end date!"+"(Line "+ count2+")");
					}
					else {
						
					for (int j = 0; j < new_team.length; j++) {
						if (new_team[j] != null && new_team[j].getName().equalsIgnoreCase(i[9])) {
							
							Team.Coach new_coach = coach_team.new Coach(i[1], c_address, p_phone, coach_team, startd,
									endd, Integer.parseInt(i[16]));
							
							if (startd.getYear() == endd.getYear()) {
								
								if ((startd.getMonth() == endd.getMonth() && startd.getDay() > endd.getDay()) || startd.getMonth() > endd.getMonth()) {
									System.out.println("For the player named " + i[2]
											+ " contract end date must be later than contract start date!"+"(Line "+ count2+")");
								}
								else {
									coach_team.setCoach(new_coach);
								}
							}
							else if (startd.getYear() > endd.getYear()) {
								System.out.println("For the player named " + i[2]
										+ " contract end date must be later than contract start date!"+"(Line "+ count2+")");
							}
							else {
								coach_team.setCoach(new_coach);
							}
						}
					}
				}
				}
				
				else if (str.startsWith("AddPlayer") == true) {

					String[] i = str.split(";");
					Team p_team = superlig.FindTeam(i[14]);
					Date bdate = new Date(Integer.parseInt(i[3]), Integer.parseInt(i[4]), Integer.parseInt(i[5]));
					bdate.DateControl(bdate);
					Address p_address = new Address(i[7], i[8], i[9], i[10]);
					Phone p_phone = new Phone(Integer.parseInt(i[11]), Integer.parseInt(i[12]),
							Integer.parseInt(i[13]));
					Date startd = new Date(Integer.parseInt(i[15]), Integer.parseInt(i[16]), Integer.parseInt(i[17]));
					startd.DateControl(startd);
					Date endd = new Date(Integer.parseInt(i[18]), Integer.parseInt(i[19]), Integer.parseInt(i[20]));
					endd.DateControl(endd);

					if (!bdate.DateControl(bdate)) {
						System.out.println("According to date standards, for the player named" + i[2]
								+ ",cannot be such a birthdate!"+"(Line "+ count2+")");
					} else if (!startd.DateControl(startd)) {
						System.out.println("According to date standards, for the player named" + i[2]
								+ ", cannot be such a start date!"+"(Line "+ count2+")");
					} else if (!endd.DateControl(endd)) {
						System.out.println("According to date standards, for the player named" + i[2]
								+ ", cannot be such a end date!"+"(Line "+ count2+")");
					}
					else {

						for (int j = 0; j < new_team.length; j++) {
							if (new_team[j] != null && new_team[j].getName().equals(i[14])) {

								Player new_player = new Player(Integer.parseInt(i[1]), i[2], bdate, i[6], p_address,
										p_phone, p_team, startd, endd, Integer.parseInt(i[21]), i[22]);

								if (startd.getYear() == endd.getYear()) {
									
									if ((startd.getMonth() == endd.getMonth() && startd.getDay() > endd.getDay()) || startd.getMonth() > endd.getMonth()) {
										System.out.println("For the player named " + i[2]
												+ " contract end date must be later than contract start date!"+"(Line "+ count2+")");
									}
									else {
										new_team[j].AddPlayer(new_player);
									}
									
								}
								else if (startd.getYear() > endd.getYear()) {
									System.out.println("For the player named " + i[2]
											+ " contract end date must be later than contract start date!"+"(Line "+ count2+")");
								}
								else {
									new_team[j].AddPlayer(new_player);
								}
							}
						}
					}
				}

				else if (str.startsWith("AddStadium") == true) {

					String[] i = str.split(";");
					Address s_address = new Address("", "", i[2], "");
					Stadium new_stadium = new Stadium(i[1], s_address, Integer.parseInt(i[3]), Boolean.valueOf(i[4]),
							i[5]);
					superlig.AddStadium(new_stadium);

				} 
				else if (str.startsWith("AddReferee") == true) {
					String[] i = str.split(";");

					Address r_address = new Address(i[2], i[3], i[4], i[5]);
					Phone r_phone = new Phone(Integer.parseInt(i[6]), Integer.parseInt(i[7]), Integer.parseInt(i[8]));

					Referee new_referee = new Referee(i[1], r_address, r_phone, Integer.parseInt(i[9]));
					superlig.AddReferee(new_referee);

				}
				else if (str.startsWith("AddCompany") == true) {
					String[] i = str.split(";");

					Address comp_address = new Address(i[2], i[3], i[4], i[5]);
					Phone comp_phone = new Phone(Integer.parseInt(i[6]), Integer.parseInt(i[7]),
							Integer.parseInt(i[8]));
					Team comp_team = superlig.FindTeam(i[9]);

					for (int j = 0; j < new_team.length; j++) {
						if (new_team[j].getName().equalsIgnoreCase(i[9])) {
							Company new_company = new Company(i[1], comp_address, comp_phone, comp_team);
							new_team[j].setTeam_sponsor(new_company);
						}
					}
				}
				
				else if (str.startsWith("AddMatch") == true) {
					String[] i = str.split(";");
					Team home_team = superlig.FindTeam(i[1]);
					Team away_team = superlig.FindTeam(i[3]);
					Referee r1 = superlig.FindReferee(Integer.parseInt(i[5]));
					Referee r2 = superlig.FindReferee(Integer.parseInt(i[6]));
					Referee r3 = superlig.FindReferee(Integer.parseInt(i[7]));
					Referee[] referees = { r1, r2, r3 };

					Match new_match = new Match(home_team, Integer.parseInt(i[2]), away_team, Integer.parseInt(i[4]),
							referees, Integer.parseInt(i[8]));

					if (!superlig.StadiumExist(new_match.getStadium())) {
						System.out.println("Stadium with ID " + i[8] + " does not exist!"+"(Line "+ count2+")");
					} 
					else if(Integer.parseInt(i[2])<0 || Integer.parseInt(i[4])<0) {
						System.out.println("Goal numbers cannot be negative! ("+"Line "+ count2+")");
					}
					else
						superlig.AddMatch(new_match);
				}
				
				else if (str.startsWith("DeletePlayer") == true) {
					String[] i = str.split(";");

					for (int j = 0; j < new_team.length; j++) {

						for (int k = 0; k < new_team[j].players.length; k++) {

							if (new_team[j].players[k] != null
									&& new_team[j].players[k].getLicense_number() == Integer.parseInt(i[1]))
								new_team[j].players[k] = null;
						}
					}
				}
				count2++;
			}

			scan.close();
			// List
			superlig.listTeam();

			for (int j = 0; j < new_team.length; j++) {
				new_team[j].listPlayer();
			}
			superlig.listSponsors();

			// Statistics
			superlig.CreateScoreboard();
			superlig.PrintBiggestStadium();

			// Operations
			superlig.IncreaseSalaries();
			superlig.listReferee();

		}

		catch (IOException e) {
			e.printStackTrace();

		}
	}

}