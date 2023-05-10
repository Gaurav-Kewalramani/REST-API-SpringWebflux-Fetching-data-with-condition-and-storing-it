package WebQ2.model;

import com.google.gson.annotations.SerializedName;

public class Data {
	int id;
	
	@SerializedName("employee_name")
	String employeeName;
	
	@SerializedName("employee_salary")
	int employeeSalary;
	
	@SerializedName("employee_age")
	int employeeAge;
	
	@SerializedName("profile_image")
	String profileImage;

	
	public Data(int id, String employeeName, int employeeSalary, int employeeAge, String profileImage) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.profileImage = profileImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	public Data() {
	}

}
