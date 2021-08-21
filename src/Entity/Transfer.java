package Entity;

public class Transfer {
	private int TransferID;
	private Employee employee;
	private boolean isApproved;
	private String reason;
	private Project fromProject;
	private Project toProject;
	private Department fromDepartment;
	private Department toDepartment;
	private Location fromLocation;
	private Location toLocation;
	private String transferRelievingDate;
	private String transferJoiningDate;
	private double totalAllowance;

	public int getTransferID() {
		return TransferID;
	}

	public void setTransferID(int transferID) {
		TransferID = transferID;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Project getFromProject() {
		return fromProject;
	}

	public void setFromProject(Project fromProject) {
		this.fromProject = fromProject;
	}

	public Project getToProject() {
		return toProject;
	}

	public void setToProject(Project toProject) {
		this.toProject = toProject;
	}

	public Department getFromDepartment() {
		return fromDepartment;
	}

	public void setFromDepartment(Department fromDepartment) {
		this.fromDepartment = fromDepartment;
	}

	public Department getToDepartment() {
		return toDepartment;
	}

	public void setToDepartment(Department toDepartment) {
		this.toDepartment = toDepartment;
	}

	public Location getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(Location fromLocation) {
		this.fromLocation = fromLocation;
	}

	public Location getToLocation() {
		return toLocation;
	}

	public void setToLocation(Location toLocation) {
		this.toLocation = toLocation;
	}

	public String getTransferRelievingDate() {
		return transferRelievingDate;
	}

	public void setTransferRelievingDate(String transferRelievingDate) {
		this.transferRelievingDate = transferRelievingDate;
	}

	public String getTransferJoiningDate() {
		return transferJoiningDate;
	}

	public void setTransferJoiningDate(String transferJoiningDate) {
		this.transferJoiningDate = transferJoiningDate;
	}

	public double getTotalAllowance() {
		return totalAllowance;
	}

	public void setTotalAllowance(double totalAllowance) {
		this.totalAllowance = totalAllowance;
	}

	@Override
	public String toString() {
		return "Transfer [TransferID=" + TransferID + ", employee=" + employee + ", isApproved=" + isApproved
				+ ", reason=" + reason + ", fromProject=" + fromProject + ", toProject=" + toProject
				+ ", fromDepartment=" + fromDepartment + ", toDepartment=" + toDepartment + ", fromLocation="
				+ fromLocation + ", toLocation=" + toLocation + ", transferRelievingDate=" + transferRelievingDate
				+ ", transferJoiningDate=" + transferJoiningDate + ", totalAllowance=" + totalAllowance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TransferID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		if (TransferID != other.TransferID)
			return false;
		return true;
	}

	public Transfer(int transferID, Employee employee, boolean isApproved, String reason, Project fromProject,
			Project toProject, Department fromDepartment, Department toDepartment, Location fromLocation,
			Location toLocation, String transferRelievingDate, String transferJoiningDate, double totalAllowance) {
		super();
		TransferID = transferID;
		this.employee = employee;
		this.isApproved = isApproved;
		this.reason = reason;
		this.fromProject = fromProject;
		this.toProject = toProject;
		this.fromDepartment = fromDepartment;
		this.toDepartment = toDepartment;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.transferRelievingDate = transferRelievingDate;
		this.transferJoiningDate = transferJoiningDate;
		this.totalAllowance = totalAllowance;
	}

	public Transfer(Employee employee, boolean isApproved, String reason, Project fromProject, Project toProject,
			Department fromDepartment, Department toDepartment, Location fromLocation, Location toLocation,
			String transferRelievingDate, String transferJoiningDate, double totalAllowance) {
		super();
		this.employee = employee;
		this.isApproved = isApproved;
		this.reason = reason;
		this.fromProject = fromProject;
		this.toProject = toProject;
		this.fromDepartment = fromDepartment;
		this.toDepartment = toDepartment;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.transferRelievingDate = transferRelievingDate;
		this.transferJoiningDate = transferJoiningDate;
		this.totalAllowance = totalAllowance;
	}

	public Transfer(int transferID) {
		super();
		TransferID = transferID;
	}

	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
