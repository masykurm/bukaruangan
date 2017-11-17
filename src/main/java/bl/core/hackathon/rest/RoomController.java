package bl.core.hackathon.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import bl.core.hackathon.model.BookedRoom;
import bl.core.hackathon.model.Building;
import bl.core.hackathon.model.Room;
import bl.core.hackathon.model.RoomListView;
import bl.core.rest.model.SchemaMetaResponse;
import bl.core.rest.model.SchemaResponse;

@RestController
public class RoomController {

	@Autowired
	private RoomService roomService;

	// TODO: 
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/rooms/book")
	public ResponseEntity<?> bookRoom(@RequestBody BookedRoom bookedRoom) {

		int code = roomService.bookRoom(bookedRoom);

		SchemaResponse response = new SchemaResponse();
		response.setMessage(String.valueOf(code >= 1));
		if (code >= 1) {
			response.setMetaResponse(new SchemaMetaResponse(HttpStatus.OK.toString(), code));
		} else {
			response.setMetaResponse(new SchemaMetaResponse(HttpStatus.EXPECTATION_FAILED.toString(), code));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// TODO: 
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/rooms/available/{buildingId}/{meetingDate}")
	public ResponseEntity<?> getAvailableRooms(
			@PathVariable(name = "buildingId") Integer buildingId,
			@PathVariable(name="meetingDate") String meetingDateString) throws JsonProcessingException  {

		List<RoomListView> out = roomService.getAvailableRooms(buildingId, meetingDateString);
		
		 
		SchemaResponse response = new SchemaResponse();
		response.setData(out);
		response.setMetaResponse(new SchemaMetaResponse(HttpStatus.OK.toString(), out.size()));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// TODO: 
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/buildings/{buildingId}")
	public ResponseEntity<?> getBuildingById(@PathVariable(name = "buildingId") Integer buildingId) {

		Building out = roomService.getBuilding(buildingId);

		SchemaResponse response = new SchemaResponse();
		response.setData(out);
		response.setMetaResponse(new SchemaMetaResponse(HttpStatus.OK.toString(), 1));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// TODO: 
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/buildings")
	public ResponseEntity<?> getBuildings() {

		List<Building> out = roomService.getBuildings();

		SchemaResponse response = new SchemaResponse();
		response.setData(out);
		response.setMetaResponse(new SchemaMetaResponse(HttpStatus.OK.toString(), 1));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// TODO: 
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/rooms/{roomId}")
	public ResponseEntity<?> getRoomById(@PathVariable(name = "roomId") Integer roomId) {

		Room out = roomService.getRoom(roomId);

		SchemaResponse response = new SchemaResponse();
		response.setData(out);
		response.setMetaResponse(new SchemaMetaResponse(HttpStatus.OK.toString(), 1));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// TODO: 
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/rooms")
	public ResponseEntity<?> getRooms() {

		List<Room> out = roomService.getRooms();

		SchemaResponse response = new SchemaResponse();
		response.setData(out);
		response.setMetaResponse(new SchemaMetaResponse(HttpStatus.OK.toString(), 1));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
