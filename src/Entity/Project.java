/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

public class Project {

	private int projectID;
	private String projectName;
	private int numberOfEmployees;
	private int toTransferCount;
	private int fromTransferCount;

	public Project(int projectID, String projectName, int numberOfEmployee) {
		this.projectID = projectID;
		this.projectName = projectName;
		this.numberOfEmployees = numberOfEmployee;
	}

	public Project(int projectID, String projectName, int numberOfEmployees, int toTransferCount,
			int fromTransferCount) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.numberOfEmployees = numberOfEmployees;
		this.toTransferCount = toTransferCount;
		this.fromTransferCount = fromTransferCount;
	}

	public Project(int projectID) {
		super();
		this.projectID = projectID;
	}

	public Project() {
	}

	public Project(int projectID, String projectName) {
		this.projectID = projectID;
		this.projectName = projectName;
	}

	public Project(String projectName) {
		this.projectName = projectName;
	}

	public void setFromTransferCount(int fromTransferCount) {
		this.fromTransferCount = fromTransferCount;
	}

	public void setToTransferCount(int toTransferCount) {
		this.toTransferCount = toTransferCount;
	}

	public int getFromTransferCount() {
		return fromTransferCount;
	}

	public int getToTransferCount() {
		return toTransferCount;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public int getProjectID() {
		return projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
