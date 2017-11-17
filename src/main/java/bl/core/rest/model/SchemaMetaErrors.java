package bl.core.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(content = Include.NON_EMPTY)
@JsonPropertyOrder({ "message", "code" })
public class SchemaMetaErrors {

	public SchemaMetaErrors(String message, int code) {
		super();
		setMessage(message);
		setCode(code);
	}

	@JsonProperty("message")
	private String message;

	@JsonProperty("code")
	private int code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
