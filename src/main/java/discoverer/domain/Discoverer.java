package discoverer.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Discoverer {
	/*
	 * Correspond to the user table
	 */
	private String discoverer_name;
	private String date; // crop
	private String discovered_location; // password

	/**
	 * @return the discoverer_name
	 */
	public String getDiscovererName() {
		return discoverer_name;
	}

	/**
	 * @param discoverer_name the discoverer_name to set
	 */
	public void setDiscovererName(String discoverer_name) {
		this.discoverer_name = discoverer_name;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the discovered_location
	 */
	public String getDiscoveredLocation() {
		return discovered_location;
	}

	/**
	 * @param discovered_location the discovered_location to set
	 */
	public void setDiscoveredLocation(String discovered_location) {
		this.discovered_location = discovered_location;
	}

	@Override
	public String toString() {
		return "User [ discoverer_name=" + discoverer_name+ ", date="
				+ date + ", discovered_location="
						+ discovered_location + "]";
	}
}
