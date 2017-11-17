package bl.core.hackathon.database;

import java.util.List;

import bl.core.hackathon.model.BookedRoom;
import bl.core.hackathon.model.Building;
import bl.core.hackathon.model.Room;

public interface DatabaseServiceInterface {
	
	public List<Building> getBuildings();

	public Building getBuilding(Integer buildingId);

	public List<Room> getRooms();

	public Room getRoom(Integer roomId);

	public int bookRoom(BookedRoom room);
}
