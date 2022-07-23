
public class Match {
	
	//Attributes
	Team home_team;
	int home_numberofGoals;
	Team away_team;
	int away_numberofGoals;
	Referee[] match_referees;
	
	//Constructor
	public Match(Team home_team, int home_numberofGoals, Team away_team, int away_numberofGoals,
			Referee[] match_referees) {
		super();
		this.home_team = home_team;
		this.home_numberofGoals = home_numberofGoals;
		this.away_team = away_team;
		this.away_numberofGoals = away_numberofGoals;
		this.match_referees = match_referees;
	}

	public Team getHome_team() {
		return home_team;
	}

	public void setHome_team(Team home_team) {
		this.home_team = home_team;
	}

	public int getHome_numberofGoals() {
		return home_numberofGoals;
	}

	public void setHome_numberofGoals(int home_numberofGoals) {
		this.home_numberofGoals = home_numberofGoals;
	}

	public Team getAway_team() {
		return away_team;
	}

	public void setAway_team(Team away_team) {
		this.away_team = away_team;
	}

	public int getAway_numberofGoals() {
		return away_numberofGoals;
	}

	public void setAway_numberofGoals(int away_numberofGoals) {
		this.away_numberofGoals = away_numberofGoals;
	}

	public Referee[] getMatch_referees() {
		return match_referees;
	}

	public void setMatch_referees(Referee[] match_referees) {
		this.match_referees = match_referees;
	}
	
}
