package photo.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Photo {
	/*
	 * Correspond to the user table
	 */

	private String photo_id; // photo id
	private String date_taken; // date the photo was taken
	private String photo_url; // directory of photo

	public String getPhotoId() {
		return photo_id;
	}

	public void setPhotoId(String id) {
		this.photo_id = id;
	}

	public String getDateTaken() {
		return date_taken;
	}

	public void setDateTaken(String date) {
		this.date_taken = date;
	}

	public String getPhotoDir() {
		return photo_url;
	}

	public void setPhotoDir(String dir) {
		this.photo_url = dir;
	}

	@Override
	public String toString() {
		return "User [photo_id = " + photo_id + ", date_taken = "
				+ date_taken + ", photo_url = " + photo_url + "]";
	}
}
