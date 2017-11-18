package bl.core.hackathon.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

	public List<Room> getRoomsByBuildingId(Integer buildingId) {
		String query ="SELECT * from room where building_id="+buildingId;
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

		String query = "select c.name 'building_name',a.id 'room_id', a.room_name, a.room_capacity, a.facilities, c.location,bb.meeting_name, bb.booked_by, DATE_FORMAT(bb.booked_start_date,'%Y-%m-%d %H:%i') 'booked_start_date', DATE_FORMAT(bb.booked_end_date,'%Y-%m-%d %H:%i') 'booked_end_date' \n" + 
				"from room a\n" + 
				"left join (\n" + 
				"	select b.*\n" + 
				"    from booked_room b\n" + 
				"    where b.booked_start_date between '"+meetingDate+"' and '"+meetingDate+" 23:59:59'\n" + 
				") bb on (a.id = bb.room_id)\n" + 
				"left join building c on (a.building_id = c.id) "
				+ " where c.id = "+ buildingId
				+ " order by c.name"; 
		
		List<Map<String,Object>> rows = c3p0JdbcTemplate.queryForList(query);
		List<RoomListView> result = new ArrayList<RoomListView>();
		
		Integer roomId= Integer.valueOf(rows.get(0).get("room_id").toString());
		Map<String, Object> row = rows.get(0);
		RoomListView room = new RoomListView();
		room.setBuildingName(row.get("building_name").toString());
		room.setFacilities(row.get("facilities").toString());
		room.setLocation(row.get("location").toString());
		room.setRoomCapacity(Integer.valueOf(row.get("room_capacity").toString()));
		room.setRoomId(Integer.valueOf(row.get("room_id").toString()));
		room.setRoomName(row.get("room_name").toString());
		room.setMeetings(new ArrayList<BookedRoom>());
	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		for(int i=0;i<rows.size();i++) {
			row = rows.get(i);
			Integer currentRoomId = Integer.valueOf(row.get("room_id").toString());

			BookedRoom  meeting = new BookedRoom();
			if(roomId != currentRoomId) {
				result.add(room);
				
				room = new RoomListView();
				room.setBuildingName(row.get("building_name").toString());
				room.setFacilities(row.get("facilities").toString());
				room.setLocation(row.get("location").toString());
				room.setRoomCapacity(Integer.valueOf(row.get("room_capacity").toString()));
				room.setRoomId(Integer.valueOf(row.get("room_id").toString()));
				room.setRoomName(row.get("room_name").toString());
				room.setMeetings(new ArrayList<BookedRoom>());
				Object o =row.get("booked_start_date");
				if (o != null) {
					meeting.setBookedStartDate(LocalDateTime.parse(o.toString(),formatter));
					meeting.setMeetingName(row.get("meeting_name").toString());
				}
				
				Object o1 =row.get("booked_end_date");
				if (o1 != null) {
					meeting.setBookedEndDate(LocalDateTime.parse(o1.toString(),formatter));
					meeting.setMeetingName(row.get("meeting_name").toString());
				}
				roomId = room.getRoomId();
				room.getMeetings().add(meeting);
			} else {
				Object o =row.get("booked_start_date");
				if (o != null) {
					meeting.setBookedStartDate(LocalDateTime.parse(o.toString(),formatter));
					meeting.setBookedBy(row.get("booked_by").toString());
					meeting.setMeetingName(row.get("meeting_name").toString());
				}
				
				Object o1 =row.get("booked_end_date");
				if (o1 != null) {
					meeting.setBookedEndDate(LocalDateTime.parse(o1.toString(),formatter));
					meeting.setBookedBy(row.get("booked_by").toString());
					meeting.setMeetingName(row.get("meeting_name").toString());
				}
				room.getMeetings().add(meeting);
			}
		} 

		//add the last object
		result.add(room);

		
		return result;
	}
	
	public List<RoomListView> getBookedRoomByUser(String bookedBy) {

		String query = "select c.name 'building_name',a.id 'room_id', a.room_name, a.room_capacity, a.facilities, c.location,bb.meeting_name,bb.booked_by, DATE_FORMAT(bb.booked_start_date,'%Y-%m-%d %H:%i') 'booked_start_date', DATE_FORMAT(bb.booked_end_date,'%Y-%m-%d %H:%i') 'booked_end_date' \n" + 
				"from room a\n" + 
				"left join (\n" + 
				"	select b.*\n" + 
				"    from booked_room b\n" +  
				") bb on (a.id = bb.room_id)\n" + 
				"left join building c on (a.building_id = c.id) "
				+"where bb.booked_by = '"+bookedBy+"' "
				+"order by c.name "; 
		
		List<Map<String,Object>> rows = c3p0JdbcTemplate.queryForList(query);
		List<RoomListView> result = new ArrayList<RoomListView>();
		
		Integer roomId= Integer.valueOf(rows.get(0).get("room_id").toString());
		Map<String, Object> row = rows.get(0);
		RoomListView room = new RoomListView();
		room.setBuildingName(row.get("building_name").toString());
		room.setFacilities(row.get("facilities").toString());
		room.setLocation(row.get("location").toString());
		room.setRoomCapacity(Integer.valueOf(row.get("room_capacity").toString()));
		room.setRoomId(Integer.valueOf(row.get("room_id").toString()));
		room.setRoomName(row.get("room_name").toString());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		for(int i=0;i<rows.size();i++) {
			row = rows.get(i);
			Integer currentRoomId = Integer.valueOf(row.get("room_id").toString());
			BookedRoom  meeting = new BookedRoom();
			if(roomId != currentRoomId) {
				result.add(room);
				
				room = new RoomListView();
				room.setBuildingName(row.get("building_name").toString());
				room.setFacilities(row.get("facilities").toString());
				room.setLocation(row.get("location").toString());
				room.setRoomCapacity(Integer.valueOf(row.get("room_capacity").toString()));
				room.setRoomId(Integer.valueOf(row.get("room_id").toString()));
				room.setRoomName(row.get("room_name").toString());
				room.setMeetings(new ArrayList<BookedRoom>());
				Object o =row.get("booked_start_date");
				if (o != null) {
					meeting.setBookedBy(row.get("booked_by").toString());
					meeting.setBookedStartDate(LocalDateTime.parse(o.toString(),formatter));
					meeting.setMeetingName(row.get("meeting_name").toString());
				}
				
				Object o1 =row.get("booked_end_date");
				if (o1 != null) {
					meeting.setBookedBy(row.get("booked_by").toString());
					meeting.setBookedEndDate(LocalDateTime.parse(o1.toString(),formatter));
					meeting.setMeetingName(row.get("meeting_name").toString());
				}
				room.getMeetings().add(meeting);
				roomId = room.getRoomId();
			} else {

				Object o =row.get("booked_start_date");
				
				
				if (o != null) {
					meeting.setBookedBy(row.get("booked_by").toString());
					meeting.setBookedStartDate(LocalDateTime.parse(o.toString(),formatter));
					meeting.setMeetingName(row.get("meeting_name").toString());
				}
				
				Object o1 =row.get("booked_end_date");
				if (o1 != null) {
					meeting.setBookedBy(row.get("booked_by").toString());
					meeting.setBookedEndDate(LocalDateTime.parse(o1.toString(),formatter));
					meeting.setMeetingName(row.get("meeting_name").toString());
				}
				room.getMeetings().add(meeting);
			}
		}
		result.add(room);

		return result;
	}
	public int bookRoom(BookedRoom room) {
		String query = 
				"INSERT INTO booked_room (building_id,room_id, building_name, room_name, booked_start_date, booked_end_date, booked_by, meeting_name) "+
			    "VALUES (?,?,?,?,?,?,?,?)";
		int result = c3p0JdbcTemplate.update(query,
				room.getBuildingId(),
				room.getRoomId(),
				room.getBuildingName(),
				room.getRoomName(),
				room.getBookedStartDate(),
				room.getBookedEndDate(),
				room.getBookedBy(),
				room.getMeetingName()
				);

		return result;
	}

	public List<BookedRoom> getNearestMeeting(){
		String query = "select * \n" + 
				"from booked_room\n" + 
				"where booked_start_date >= NOW() - Interval 15 minute";
		List<BookedRoom> result =  c3p0JdbcTemplate.query(query, 
				(rs,rowNum ) -> new BookedRoom(

						rs.getInt("id"),
						rs.getInt("room_id"),
						rs.getInt("building_id"),
						rs.getString("building_name"),
						rs.getString("room_name"),
						LocalDateTime.ofInstant(rs.getDate("booked_start_date").toInstant(),ZoneId.systemDefault()),
						LocalDateTime.ofInstant(rs.getDate("booked_end_date").toInstant(),ZoneId.systemDefault()),
						rs.getString("booked_by"),
						rs.getString("meeting_name")
						));
		return result;
	}
}
