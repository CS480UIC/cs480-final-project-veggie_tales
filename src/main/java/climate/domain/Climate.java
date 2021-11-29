package entity1.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Climate {
	/*
	 * Correspond to the user table
	 */
	
	private String climate;
	private	String rainfall; 
	private String humidity;
	
	
	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getRainfall() {
		return rainfall;
	}

	public void setRainfall(String rainfall) {
		this.rainfall = rainfall;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "User [ climate=" + climate + ", rainfall="
				+ rainfall + ", humidity=" + humidity +"]";
	}
}
