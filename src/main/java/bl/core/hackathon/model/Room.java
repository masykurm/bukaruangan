package bl.core.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "building_id", "room_name" ,"room_capacity" })
public class Room {
	public Room() {
		
	}
	public Room(Integer id, Integer buildingId, String roomName, Integer roomCapacity, String facilities) {
		super();
		this.id = id;
		this.buildingId = buildingId;
		this.roomName = roomName;
		this.roomCapacity = roomCapacity;
		this.facilities = facilities;
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

	@JsonProperty("building_id")
	private Integer buildingId;
	@JsonProperty("building_id")
	public Integer getBuildingId() {
		return buildingId;
	}
	@JsonProperty("building_id")
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	
	@JsonProperty("room_name")
	private String roomName;
	@JsonProperty("room_name")
	public String getRoomName() {
		return roomName;
	}
	@JsonProperty("room_name")
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@JsonProperty("room_capacity")
	private Integer roomCapacity;

	@JsonProperty("room_capacity")
	public Integer getRoomCapacity() {
		return roomCapacity;
	}
	
	@JsonProperty("room_capacity")
	public void setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
	}	
	
	@JsonProperty("facilities")
	private String facilities;
	@JsonProperty("facilities")
	public String getFacilities() {
		return facilities;
	}
	@JsonProperty("facilities")
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	
	
	
}
