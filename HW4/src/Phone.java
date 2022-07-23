public class Phone {
	
	//Attributes
	int countryCode;
	int areaCode;
	int number;
	
	//Constructor
	Phone(int inputCcode,int inputAreaCode, int inputNumber){
		countryCode=inputCcode;
		areaCode=inputAreaCode;
		number=inputNumber;
	}
	
	//Getters
	public int getCcode() {
		return countryCode;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public int getNumber() {
		return number;
	}
	
	//Setters
	public void setCcode(int inputCcode) {
		countryCode=inputCcode;
	}
	public void setCityCode(int inputAreaCode) {
		areaCode=inputAreaCode;
	}
	public void setNumber(int inputNumber) {
		number=inputNumber;
	}
	
	//Display
	public void display() {
		System.out.println("+"+this.countryCode+" ("+this.areaCode+") "+ this.number);
	}
}