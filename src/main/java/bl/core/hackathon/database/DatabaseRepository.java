package bl.core.hackathon.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import bl.core.hackathon.model.BookedRoom;
import bl.core.hackathon.model.Building;
import bl.core.hackathon.model.Room;
import bl.core.hackathon.model.RoomListView;

@Repository
public class DatabaseRepository {
	
	@Autowired
	private JdbcTemplate c3p0JdbcTemplate;
	
	public List<Building> getBuildings() {
		String query ="SELECT * from building";
		List<Building> result = c3p0JdbcTemplate.query(query, 
				(rs,rowNum ) -> new Building(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("location")
						));
		return result;
	}

	public Building getBuilding(Integer buildingId) {
		
		String query = String.format("SELECT * FROM building WHERE id=%d", buildingId);
		Building result = null;
		try {
		result = c3p0JdbcTemplate.query(query,
				new ResultSetExtractor<Building>() {

					@Override
					public Building extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						rs.next();
						return new Building(
								rs.getInt("id"),
								rs.getString("name"),
								rs.getString("location")
								);
					}
			
				});
		} catch(Exception ex) {
			
		}
		return result;
	} 

	public List<Room> getRooms() {
		String query ="SELECT * from room";
		List<Room> result = c3p0JdbcTemplate.query(query, 
				(rs,rowNum ) -> new Room(
						rs.getInt("id"),
						rs.getInt("building_id"),
						rs.getString("room_name"),
						rs.getInt("room_capacity"),
						rs.getString("room_location")
						));
		return result;
	}

	public Room getRoom(Integer roomId) {

		String query = String.format("SELECT * FROM room WHERE id=%d", roomId);
		Room result = null;
		try {
			result = c3p0JdbcTemplate.query(query,
					new ResultSetExtractor<Room>() {
	
						@Override
						public Room extractData(ResultSet rs) throws SQLException, DataAccessException {
							// TODO Auto-generated method stub
							rs.next();
							return new Room(
									rs.getInt("id"),
									rs.getInt("building_id"),
									rs.getString("room_name"),
									rs.getInt("room_capacity"),
									rs.getString("room_location")
									);
						}
				
					});

		} catch(Exception ex) {
			
		}
		return result;
	}

	public List<RoomListView> getAvailableRooms(Integer buildingId, String meetingDate) {

		String query = "select c.name 'building_name',a.id 'room_id', a.room_name, a.room_capacity, a.facilities, c.location, DATE_FORMAT(bb.booked_start_date,'%d-%m-%Y %H:%i:%s') 'booked_start_date', DATE_FORMAT(bb.booked_end_date,'%d-%m-%Y %H:%i:%s') 'booked_end_date' \n" + 
				"from room a\n" + 
				"left join (\n" + 
				"	select b.*\n" + 
				"    from booked_room b\n" + 
				"    where b.booked_start_date between '"+meetingDate+"' and '"+meetingDate+" 23:59:59'\n" + 
				") bb on (a.id = bb.room_id)\n" + 
				"left join building c on (a.building_id = c.id)"; 
		
		System.out.println("query : "+query);
		List<Map<String,Object>> rows = c3p0JdbcTemplate.queryForList(query);
		List<RoomListView> result = new ArrayList<RoomListView>();
		
		Integer roomId= -99;

		RoomListView room = new RoomListView();
		List<Date> bookedStartDate = new ArrayList<Date>();
		List<Date> bookedEndDate = new ArrayList<Date>();
		for(int i=0;i<rows.size();i++) {
			Map row = rows.get(i);
			Integer currentRoomId = Integer.valueOf(row.get("room_id").toString());
			if(roomId != currentRoomId) {
				
				if(roomId != -99) {
					room.setBookedStartDate(bookedStartDate);
					room.setBookedEndDate(bookedEndDate);
					result.add(room);
				}
				
				room = new RoomListView();
				room.setBuildingName(row.get("building_name").toString());
				room.setFacilities(row.get("facilities").toString());
				room.setLocation(row.get("location").toString());
				room.setRoomCapacity(Integer.valueOf(row.get("room_capacity").toString()));
				room.setRoomId(Integer.valueOf(row.get("room_id").toString()));
				room.setRoomName(row.get("room_name").toString());
				
				bookedStartDate.clear();
				bookedEndDate.clear();
				roomId = room.getRoomId();
			} else {
				
				Object o =row.get("booked_start_date");
				if (o != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY hh:mi:ss");
					
					try {
						Date d1 = sdf.parse(o.toString());
						bookedStartDate.add(d1);

						Object o1 =row.get("booked_end_date");
						if(o1 != null) {
							Date d2 = sdf.parse(o1.toString());
							bookedEndDate.add(d2);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return result;
	}
	 
	public int bookRoom(BookedRoom room) {
		
		return 1;
	}

}
