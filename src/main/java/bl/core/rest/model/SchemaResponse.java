package bl.core.rest.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(content = Include.NON_EMPTY)
@JsonPropertyOrder({ "data", "message","errors","meta" })
public class SchemaResponse {

	@JsonProperty("data")
	private Object data;
	
	@JsonProperty("message")
	private String message;

	@JsonProperty("errors")
	private List<SchemaMetaErrors> metaErrors;


	@JsonProperty("meta")
	private SchemaMetaResponse metaResponse;


	public SchemaResponse() {
		ArrayList<SchemaMetaErrors> m =new ArrayList<SchemaMetaErrors>();
		m.add(new SchemaMetaErrors("ok", 200));
		setMetaErrors(m);
	}
	public List<SchemaMetaErrors> getMetaErrors() {
		return metaErrors;
	}

	public void setMetaErrors(List<SchemaMetaErrors> metaErrors) {
		this.metaErrors = metaErrors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public SchemaMetaResponse getMetaResponse() {
		return metaResponse;
	}

	public void setMetaResponse(SchemaMetaResponse metaResponse) {
		this.metaResponse = metaResponse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
