
public class Stadium {
	
	//Attributes
	String name;
	Address city;
	int capacity;
	boolean lightning;
	String surface;
	private int stadiumID;
	
	//Constructor
	Stadium(String inputName,Address inputCity,int inputCapacity,boolean inLightning,String inputSurface){
		name=inputName;
		city=inputCity;
		capacity=inputCapacity;
		lightning=inLightning;
		surface=inputSurface;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public Address getCity() {
		return city;
	}
	public int getCapacity() {
		return capacity;
	}
	public boolean isLightning() {
		return lightning;
	}
	public String getSurface() {
		return surface;
	}
	public int getStadiumID() {
		return stadiumID;
	}
	
	//Setters
	public void setName(String inputName) {
		name = inputName;
	}
	public void setCity(Address inputCity) {
		city = inputCity;
	}
	public void setCapacity(int inputCapacity) {
		capacity = inputCapacity;
	}
	public void setLightning(boolean inLightning) {
		lightning = inLightning;
	}
	public void setSurface(String inputSurface) {
		surface = inputSurface;
	}

	public void setStadiumID(int stadiumID) {
		this.stadiumID = stadiumID;
	}
	
}
