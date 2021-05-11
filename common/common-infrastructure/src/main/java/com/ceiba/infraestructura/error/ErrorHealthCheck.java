package com.ceiba.infraestructura.error;


public class ErrorHealthCheck {
	
	private String name;
	private String status;

	
	
	public ErrorHealthCheck(String name) {
		this.name = name;
		this.status = "DOWN";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
