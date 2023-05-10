package WebQ2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import WebQ2.model.Data;

@Document("employee1")
public class Employee {
	
	@Id
	private int id;
	private String employeeName;
	private int employeeSalary;
	private long employeeAge;
	private String profileImage;
	private Boolean eligibleForLoan;
	
	@Autowired
	Data data;
	
	public Employee() {
		super();
	}
	
	public Employee(Data data) {
		this.id=data.getId();
		this.employeeName=data.getEmployeeName();
		this.employeeSalary=data.getEmployeeSalary();
		this.employeeAge=data.getEmployeeAge();
		this.profileImage=data.getProfileImage();
	}
	
	public Employee(int id, String employeeName, int employeeSalary, long employeeAge, String profileImage, Boolean eligibleForLoan) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.profileImage = profileImage;
		this.eligibleForLoan=eligibleForLoan;
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
	public long getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(long employeeAge) {
		this.employeeAge = employeeAge;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public Boolean getEligibleForLoan() {
		return eligibleForLoan;
	}

	public void setEligibleForLoan(Boolean eligibleForLoan) {
		this.eligibleForLoan = eligibleForLoan;
	}
}
