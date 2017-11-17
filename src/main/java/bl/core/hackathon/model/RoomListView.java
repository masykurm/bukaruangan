package bl.core.hackathon.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({  
	"building_name", 
	"room_name", 
	"room_capacity", 
	"facilities", 
	"location",
	"booked_start_date",
	"booked_end_date"})
public class RoomListView {
	

	@JsonProperty("building_name")
	private String buildingName;
	

	@JsonProperty("room_id")
	private Integer roomId;
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	@JsonProperty("room_name")
	private String roomName;
	@JsonProperty("room_capacity")
	private Integer roomCapacity;

	@JsonProperty("facilities")
	private String facilities;

	@JsonProperty("location")
	private String location;

	@JsonProperty("booked_start_date")
	private List<Date> bookedStartDate;

	@JsonProperty("booked_end_date")
	private List<Date> bookedEndDate;
	
	public String getBuildingName() { 
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Date> getBookedStartDate() {
		return bookedStartDate;
	}
	public void setBookedStartDate(List<Date> bookedStartDate) {
		this.bookedStartDate = bookedStartDate;
	}
	public List<Date> getBookedEndDate() {
		return bookedEndDate;
	}
	public void setBookedEndDate(List<Date> bookedEndDate) {
		this.bookedEndDate = bookedEndDate;
	}
	
}
