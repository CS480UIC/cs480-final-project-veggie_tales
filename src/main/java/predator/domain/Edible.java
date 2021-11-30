package edible.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Edible {
	/*
	 * Correspond to the user table
	 */

	private String crop; // crop
	private String dishes; // password
	private String allergen; // allergen

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public String getDishes() {
		return dishes;
	}

	public void setDishes(String dishes) {
		this.dishes = dishes;
	}

	public String getAllergen() {
		return allergen;
	}

	public void setAllergen(String allergen) {
		this.allergen = allergen;
	}

	@Override
	public String toString() {
		return "User [ crop=" + crop + ", dishes="
				+ dishes + ", allergen=" + allergen + "]";
	}
}
