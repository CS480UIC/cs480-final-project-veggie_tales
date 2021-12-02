package plant.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Plant {
	/*
	 * Correspond to the user table
	 */

	private String plant_name; // crop
	private String measurement;
	private String classification; // password
	private String growth_season; // allergen
	private String plant_discoverer;
	private String photo_id;
	private String plant_predator;

	public String getPlantName() {
		return plant_name;
	}

	public void setPlantName(String plant_name) {
		this.plant_name = plant_name;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getGrowthSeason() {
		return growth_season;
	}

	public void setGrowthSeason(String growth_season) {
		this.growth_season = growth_season;
	}

	public String getPlantDiscoverer() {
		return plant_discoverer;
	}

	public void setPlantDiscoverer(String plant_discoverer) {
		this.plant_discoverer = plant_discoverer;
	}

	public String getPhotoId() {
		return photo_id;
	}

	public void setPhotoId(String id) {
		this.photo_id = id;
	}

	public String getPlantPredator() {
		return plant_predator;
	}

	public void setPlantPredator(String plant_predator) {
		this.plant_predator = plant_predator;
	}

	@Override
	public String toString() {
		return "User [ plant_name=" + plant_name + ", classification="
				+ classification + ", growth_season=" + growth_season + ", " +
				"plant_discoverer=" + plant_discoverer + ", photo_id=" + 
				photo_id + ", plant_predator=" + plant_predator + " ]";
	}
}
