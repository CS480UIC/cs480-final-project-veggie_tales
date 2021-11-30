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
	private int measurement;
	private String classification; // password
	private String growth_season; // allergen
	private String plant_discoverer;
	private int photo_id;
	private String plant_predator;

	public String getPlant_name() {
		return plant_name;
	}

	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}

	public int getMeasurement() {
		return measurement;
	}

	public void setMeasurement(int measurement) {
		this.measurement = measurement;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getGrowthseason() {
		return growth_season;
	}

	public void setGrowthseason(String growth_season) {
		this.growth_season = growth_season
	}

	public String getPlantdiscoverer() {
		return plant_discoverer;
	}

	public void setPlantdiscoverer(String plant_discoverer {
		this.plant_discoverer = plant_discoverer;
	}

	public int setPhotoid() {
		return photo_id;
	}

	public void setPhotoid(String photo_id) {
		this.photo_id = photo_id;
	}

	public String getPlantpredator() {
		return plant_predator;
	}

	public void setPlantpredator(String plant_predator) {
		this.plant_predator = plant_predator;
	}

	@Override
	public String toString() {
		return "User [ plant_name=" + plant_name + ", classification="
				+ classification + ", growth_season=" + growth_season + ", 
				plant_discoverer=" + plant_discoverer + ", photo_id=" + photo_id + ", plant_predator=" + plant_predator + " ]";
	}
}
