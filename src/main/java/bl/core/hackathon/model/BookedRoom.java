package bl.core.hackathon.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"id", 
	"building_id",
	"room_id",
	"building_name", 
	"room_name", 
	"meeting_name", 
	"booked_date", 
	"booked_by" })
public class BookedRoom {

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
	
	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	@JsonProperty("room_id")
	private Integer roomId;
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@JsonProperty("building_name")
	private String buildingName;

	@JsonProperty("building_name")
	public String getBuildingName() {
		return buildingName;
	}

	@JsonProperty("building_name")
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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

	@JsonProperty("booked_start_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime bookedStartDate;

	@JsonProperty("booked_start_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	public LocalDateTime getBookedStartDate() {
		return bookedStartDate;
	}

	@JsonProperty("booked_start_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	public void setBookedStartDate(LocalDateTime bookedStartDate) {
		this.bookedStartDate = bookedStartDate;
	}
	
	@JsonProperty("booked_end_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime bookedEndDate;

	@JsonProperty("booked_end_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	public LocalDateTime getBookedEndDate() {
		return bookedEndDate;
	}

	@JsonProperty("booked_end_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	public void setBookedEndDate(LocalDateTime bookedEndDate) {
		this.bookedEndDate = bookedEndDate;
	}

	@JsonProperty("booked_by")
	private String bookedBy;

	@JsonProperty("booked_by")
	public String getBookedBy() {
		return bookedBy;
	}

	@JsonProperty("booked_by")
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}

	@JsonProperty("meeting_name")
	private String meetingName;

	@JsonProperty("meeting_name")
	public String getMeetingName() {
		return meetingName;
	}

	@JsonProperty("meeting_name")
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

}
