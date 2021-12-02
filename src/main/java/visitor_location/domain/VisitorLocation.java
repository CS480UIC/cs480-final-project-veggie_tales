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
	private String climate;
	private String terrain;

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
		return continent;
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

	/**
	 * @return the climate
	 */
	public String getClimate() {
		return climate;
	}

	/**
	 * @param climate the climate to set
	 */
	public void setClimate(String climate) {
		this.climate = climate;
	}

	/**
	 * @return the terrain
	 */
	public String getTerrain() {
		return terrain;
	}

	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	@Override
	public String toString() {
		return "User [zip_code = " + zip_code + ", continent = "
				+ continent + ", country = "
				+ country + ", city = " + city + ", climate = " + climate+ ", terrain = " + terrain + "]";
	}
}
