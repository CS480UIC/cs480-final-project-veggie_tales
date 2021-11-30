package terrain.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Terrain {
	/*
	 * Correspond to the user table
	 */

	private String terrain_type; // crop
	private String minerals; // password
	private String soil; // allergen
	private String fertilizer;

	public String getTerraintype() {
		return terrain_type;
	}

	public void setTerraintype(String terrain_type) {
		this.terrain_type = terrain_type;
	}

	public String getMinerals() {
		return minerals;
	}

	public void setMinerals(String minerals) {
		this.minerals = minerals;
	}

	public String getSoil() {
		return soil;
	}

	public void setSoil(String soil) {
		this.soil = soil;
	}

	public String getFertilizer() {
		return fertilizer;
	}

	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}

	@Override
	public String toString() {
		return "User [ terrain_type=" + terrain_type + ", minerals="
				+ minerals + ", soil=" + soil + ", fertilizer=" + fertilizer + "]";
	}
}
