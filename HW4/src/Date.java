
public class Date {
	
	int day;
	int month;
	int year;
	
	Date(int inputDay,int inputMonth,int inputYear){
		day=inputDay;
		month=inputMonth;
		year=inputYear;
	}
	
	//Getters
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	
	//Setters
	public void setDay(int inputDay) {
		day=inputDay;
	}
	public void setMonth(int inputMonth) {
		month=inputMonth;
	}
	public void setYear(int inputYear) {
		year=inputYear;
	}
	
}
