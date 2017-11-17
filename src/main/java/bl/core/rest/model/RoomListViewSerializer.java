package bl.core.rest.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import bl.core.hackathon.model.RoomListView;

public class RoomListViewSerializer extends JsonDeserializer<RoomListView> {

	@Override
	public RoomListView deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		System.out.println("deserialize");

		RoomListView rls = new RoomListView();

		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);
		// userAccountAuthentication.setAuthenticated(node.get("authenticated").booleanValue());

		rls.setBuildingName(node.get("building_name").asText());
		rls.setFacilities(node.get("facilities").asText());
		rls.setLocation(node.get("location").asText());
		rls.setRoomCapacity(node.get("room_capacity").intValue());
		rls.setRoomId(node.get("room_id").intValue());
		rls.setRoomName(node.get("room_name").asText());
		rls.setBookedStartDate(new ArrayList<>());
		rls.setBookedEndDate(new ArrayList<>());
		Iterator<JsonNode> elements = node.get("bookedStartDate").elements();
		System.out.println("elements : "+elements);
		
		while (elements.hasNext()) {
			JsonNode next = elements.next();
			System.out.println("adding 1  "+next);
			rls.getBookedStartDate().add(next.asText());
		}
		elements = node.get("bookedEndDate").elements();
		while (elements.hasNext()) {
			JsonNode next = elements.next();
			System.out.println("adding 2 "+next);
			rls.getBookedEndDate().add(next.asText());
		}
		return rls;
	}
}