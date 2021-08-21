/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

public class Department {

	private int departmentID;
	private String departmentName;
	private int numOfEmployee;
	private int toDepartmentCount;
	private int fromDepartmentCount;

	public Department() {
	}

	public Department(int departmentID) {
		super();
		this.departmentID = departmentID;
	}

	public Department(int departmentID, String departmentName, int numOfEmployee, int toDepartmentCount,
			int fromDepartmentCount) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.numOfEmployee = numOfEmployee;
		this.toDepartmentCount = toDepartmentCount;
		this.fromDepartmentCount = fromDepartmentCount;
	}

	public Department(int departmentID, String departmentName) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}

	public Department(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public int getFromDepartmentCount() {
		return fromDepartmentCount;
	}

	public int getNumOfEmployee() {
		return numOfEmployee;
	}

	public int getToDepartmentCount() {
		return toDepartmentCount;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setFromDepartmentCount(int fromLocationCount) {
		this.fromDepartmentCount = fromLocationCount;
	}

	public void setNumOfEmployee(int numOfEmployee) {
		this.numOfEmployee = numOfEmployee;
	}

	public void setToDepartmentCount(int toLocationCount) {
		this.toDepartmentCount = toLocationCount;
	}
}
