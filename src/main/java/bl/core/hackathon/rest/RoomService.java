package bl.core.hackathon.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bl.core.hackathon.database.DatabaseService;
import bl.core.hackathon.model.BookedRoom;
import bl.core.hackathon.model.Building;
import bl.core.hackathon.model.Room;
import bl.core.hackathon.model.RoomListView;

public class RoomService {

	@Autowired
	private DatabaseService service;

	public List<Building> getBuildings() {
		return service.getBuildings();
	}

	public Building getBuilding(Integer buildingId) {

		return service.getBuilding(buildingId);
	}

	public List<Room> getRooms() {

		return service.getRooms();
	}

	public Room getRoom(Integer roomId) {

		return service.getRoom(roomId);
	}

	public List<RoomListView> getAvailableRooms(Integer buildingId, String meetingDate) {

		return service.getAvailableRooms(buildingId,meetingDate);
	}

	public int bookRoom(BookedRoom room) {

		return service.bookRoom(room);
	}
}
