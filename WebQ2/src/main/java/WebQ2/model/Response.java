package WebQ2.model;

import java.util.List;

import WebQ2.entity.Employee;

public class Response {
	
	private String status;
	private List<Employee> data;
	private String message;
	
	

	public Response(String status, List<Employee> data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Response() {
	}
}
