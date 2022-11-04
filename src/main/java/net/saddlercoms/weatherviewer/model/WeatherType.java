package net.saddlercoms.weatherviewer.model;

public class WeatherType {
	
	/** Weather condition id
	 *  e.g. 800
	 */ 
	private Integer id;
	/**
	 * Group of weather parameters (Rain, Snow, Extreme etc.)
	 * e.g. "Clear"
	 */
	private String main;
	/**
	 * Weather condition within the group. 
	 * e.g. "clear sky"
	 */ 
	private String description;
	
	public WeatherType() { }
	
	/** Weather condition id
	 *  e.g. 800
	 */ 
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	/** 
	 * Group of weather parameters (Rain, Snow, Extreme etc.)
	 * e.g. "Clear"
	 */
	public String getMain() { return main; }
	public void setMain(String main) { this.main = main; }

	/** 
	 * Weather condition within the group. 
	 * e.g. "clear sky" 
	 */	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description=" + description + "]";
	} 
	
	
}
