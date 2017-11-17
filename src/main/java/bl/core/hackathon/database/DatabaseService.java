package bl.core.hackathon.database;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import bl.core.hackathon.model.BookedRoom;
import bl.core.hackathon.model.Building;
import bl.core.hackathon.model.Room;
import bl.core.hackathon.model.RoomListView;


@EnableAutoConfiguration
@Service
public class DatabaseService implements DatabaseServiceInterface {

    @Autowired
	private DatabaseRepository repository;

	public List<Building> getBuildings() {

		return repository.getBuildings();
	}

	public Building getBuilding(Integer buildingId) {

		return repository.getBuilding(buildingId);
	}

	public List<Room> getRooms() {

		return repository.getRooms();
	}

	public Room getRoom(Integer roomId) {

		return repository.getRoom(roomId);
	}


	public List<RoomListView> getAvailableRooms(Integer buildingId, String meetingDate) {

		return repository.getAvailableRooms(buildingId, meetingDate);
	}

	public int bookRoom(BookedRoom room) {

		return repository.bookRoom(room);
	}

}

