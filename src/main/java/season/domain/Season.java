package season.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Season {
	/*
	 * Correspond to the user table
	 */
	
	private String season;
	private String temperature; 
	private String duration;
	
	
	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "User [ season=" + season + ", temperature="
				+ temperature + ", duration=" + duration +"]";
	}
}
