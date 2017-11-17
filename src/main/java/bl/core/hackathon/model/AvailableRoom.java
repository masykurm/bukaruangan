package bl.core.hackathon.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvailableRoom extends Room {

	@JsonProperty("available_date")
	private List<Date> availableDate;

	@JsonProperty("available_date")
	public List<Date> getAvailableDate() {
		return availableDate;
	}

	@JsonProperty("available_date")
	public void setAvailableDate(List<Date> availableDate) {
		this.availableDate = availableDate;
	}
	
	
}
