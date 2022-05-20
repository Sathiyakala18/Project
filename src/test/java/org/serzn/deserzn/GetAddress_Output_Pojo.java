package org.serzn.deserzn;

import java.util.ArrayList;

public class GetAddress_Output_Pojo {
    private int status;
    private String message;
    public GetAddress_Output_Pojo(int status, String message, ArrayList<Datum> data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	private ArrayList<Datum> data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Datum> getData() {
		return data;
	}
	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}
    
}
