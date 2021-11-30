package visitor_location.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class VisitorLocation {
	/*
	 * Correspond to the user table
	 */

	private String zip_code;
	private String country;
	private String continent;
	private String city;

	public String getZip() {
		return zip_code;
	}

	public void setZip(String zip) {
		this.zip_code = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContinent() {
		return continent
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String c) {
		this.city = c;
	}

	@Override
	public String toString() {
		return "User [zip_code = " + zip_code + ", continent = "
				+ continent + ", country = "
				+ country + ", city = " + city + "]";
	}
}
