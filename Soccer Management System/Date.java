
public class Date {
	
	int day;
	int month;
	int year;
	
	private int[] days_of_months = {31,28,31,30,31,30,31,31,30,31,31,31};
	private int[] leapyear_days_of_months = {31,29,31,30,31,30,31,31,30,31,31,31};
	
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
	
	public boolean DateControl(Date date) {
		
	        boolean date_control=true;
	        
	        if(date.getYear()%4==0) {
	        	if (date.getDay()<0 || date.getDay()>leapyear_days_of_months[date.month-1]) {
		            date_control=false;
		            }
	        	return date_control;
	        }
	        else {
	        	if (date.getDay()<0 ||date.getDay()>days_of_months[date.month-1]) {
		            date_control=false;
		            }
		        return date_control;
	        }
	        
	    }
	
}
