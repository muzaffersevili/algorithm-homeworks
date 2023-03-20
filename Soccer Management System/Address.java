
public class Address {

	// Attributes
	String street;
	String town;
	String city;
	String country;

	// Constructor
	public Address(String inputStreet, String inputTown, String inputCity, String inputCountry) {
		street = inputStreet;
		town = inputTown;
		city = inputCity;
		country = inputCountry;
	}
	
	
	// Getters
	public String getStreet() {
		return street;
	}

	public String getTown() {
		return town;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	// Setters
	public void setStreet(String inputStreet) {
		street = inputStreet;
	}

	public void setTown(String inputTown) {
		town = inputTown;
	}

	public void setCity(String inputCity) {
		city = inputCity;
	}

	public void setCountry(String inputCountry) {
		country = inputCountry;
	}
}
