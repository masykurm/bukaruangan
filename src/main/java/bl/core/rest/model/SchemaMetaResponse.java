package bl.core.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(content = Include.NON_EMPTY)
@JsonPropertyOrder({ "http_status", "offset", "limit", "total", "facets" })
public class SchemaMetaResponse {

	@JsonProperty("http_status")
	private String httpStatus;
	private long offset;
	private long limit;
	private long total;
	private long facets;
	
	public SchemaMetaResponse(String httpStatus) {
		super();
		this.httpStatus = httpStatus;
	}
	public SchemaMetaResponse(String httpStatus, long total) {
		super();
		setHttpStatus(httpStatus);
		setTotal(total);
		setFacets(0);
		setLimit(0);
		setOffset(0);
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getFacets() {
		return facets;
	}

	public void setFacets(long facets) {
		this.facets = facets;
	}

}
