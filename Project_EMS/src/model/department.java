package model;

public class Department {
	// POJO, the java bean for department
	private int did; //read only
	private String dName;
	
	public int getDid() {
		return did;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
}
