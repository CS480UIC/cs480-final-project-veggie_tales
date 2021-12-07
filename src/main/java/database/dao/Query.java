/**
 * 
 */
package database.dao;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author benit
 *
 */
public class Query {
	
	/**
	 * String to Initialize DB
	 */
	public String createTables() {
		String query = "call veggietales_db.create_tables()";
		
		return query;
	}
	
	/**
	 * String to add values to the database
	 * @return
	 */
	public ArrayList<String> initializeDatabase() {
//		String query = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-climate.csv'" 
//				+ "INTO TABLE climate " + "FIELDS TERMINATED BY ',' " +  "ENCLOSED BY '\"' " + 
//				"LINES TERMINATED BY '\\n'" + "IGNORE 1 ROWS;";
		
		String edible_csv = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-edible.csv' "
				+ "INTO TABLE edible "
				+ "FIELDS TERMINATED BY ',' "
				+ "ENCLOSED BY '\"' "
				+ "LINES TERMINATED BY '\\n' "
				+ "IGNORE 1 ROWS; ";
		
		String climate_csv = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-climate.csv' "
				+ "INTO TABLE climate "
				+ "FIELDS TERMINATED BY ',' "
				+ "ENCLOSED BY '\"' "
				+ "LINES TERMINATED BY '\\n' "
				+ "IGNORE 1 ROWS; ";
		
		String discoverer_csv = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-discoverer.csv' "
				+ "INTO TABLE discoverer "
				+ "FIELDS TERMINATED BY ',' "
				+ "ENCLOSED BY '\"' "
				+ "LINES TERMINATED BY '\\n' "
				+ "IGNORE 1 ROWS; ";
		
		String photo_csv = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-photo.csv' "
				+ "INTO TABLE photo "
				+ "FIELDS TERMINATED BY ',' "
				+ "ENCLOSED BY '\"' "
				+ "LINES TERMINATED BY '\\n' "
				+ "IGNORE 1 ROWS; ";
		
		String predator_csv = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-predator.csv' "
				+ "INTO TABLE predator "
				+ "FIELDS TERMINATED BY ',' "
				+ "ENCLOSED BY '\"' "
				+ "LINES TERMINATED BY '\\n' "
				+ "IGNORE 1 ROWS; ";
		
		String terrain_csv = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-terrain.csv' "
				+ "INTO TABLE terrain "
				+ "FIELDS TERMINATED BY ',' "
				+ "ENCLOSED BY '\"' "
				+ "LINES TERMINATED BY '\\n' "
				+ "IGNORE 1 ROWS; ";
		
		String visitor_location_csv = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-visitor_location.csv' "
				+ "INTO TABLE visitor_location "
				+ "FIELDS TERMINATED BY ',' "
				+ "ENCLOSED BY '\"' "
				+ "LINES TERMINATED BY '\\n' "
				+ "IGNORE 1 ROWS; ";
		
		String season_csv = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-season.csv' "
				+ "INTO TABLE season "
				+ "FIELDS TERMINATED BY ',' "
				+ "ENCLOSED BY '\"' "
				+ "LINES TERMINATED BY '\\n' "
				+ "IGNORE 1 ROWS; ";
		
		String plants_csv = "LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/veggie_tales-plants.csv' "
				+ "INTO TABLE plant "
				+ "FIELDS TERMINATED BY ',' "
				+ "ENCLOSED BY '\"' "
				+ "LINES TERMINATED BY '\\n' "
				+ "IGNORE 1 ROWS; ";
		
		
		
		ArrayList<String> csv_files = new ArrayList<>(Arrays.asList(edible_csv, climate_csv,discoverer_csv,photo_csv,predator_csv,terrain_csv,visitor_location_csv,season_csv,plants_csv));
		return csv_files;
	}
	
	
	/**
	 * String to Delete DB
	 */
	public String dropTables() {
		
		String query = "call veggietales_db.drop_tables()";
		return query;
	}

}
