package bl.core.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "location" })
public class Building {

	public Building() {
		
	}
	public Building(Integer id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("location")
	private String location;
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}
	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}



}
