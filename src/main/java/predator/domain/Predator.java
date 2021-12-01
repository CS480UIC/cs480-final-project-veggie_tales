package predator.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Predator {
	/*
	 * Correspond to the user table
	 */

	private String species; // primary key
	private String name; // attribute 1
	private String vore_type; // attribute 2


	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}


	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the vore_type
	 */
	public String getVoreType() {
		return vore_type;
	}


	/**
	 * @param vore_type the vore_type to set
	 */
	public void setVoreType(String vore_type) {
		this.vore_type = vore_type;
	}


	@Override
	public String toString() {
		return "User [ species=" + species+ ", name="
				+ name + ", vore_type=" + vore_type + "]";
	}
}
