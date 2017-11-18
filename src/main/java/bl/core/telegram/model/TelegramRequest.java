package bl.core.telegram.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "update_id", "message" })
public class TelegramRequest {

	@JsonProperty("update_id")
	private Integer updateId;
	@JsonProperty("message")
	private Message message;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("update_id")
	public Integer getUpdateId() {
		return updateId;
	}

	@JsonProperty("update_id")
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	public TelegramRequest withUpdateId(Integer updateId) {
		this.updateId = updateId;
		return this;
	}

	@JsonProperty("message")
	public Message getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(Message message) {
		this.message = message;
	}

	public TelegramRequest withMessage(Message message) {
		this.message = message;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public TelegramRequest withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}