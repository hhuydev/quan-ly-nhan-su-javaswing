package Entity;

public class Role {

	private int roleID;
	private String roleName;
	private double roleAllowance;
	private int numberOfEmloyees;

	public Role() {
	}

	public Role(int roleID) {
		super();
		this.roleID = roleID;
	}

	public Role(int RoleID, String RoleName, double RoleAllowance) {
		this.roleID = RoleID;
		this.roleName = RoleName;
		this.roleAllowance = RoleAllowance;
	}

	public double getRoleAllowance() {
		return roleAllowance;
	}

	public int getRoleID() {
		return roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public int getNumberOfEmloyees() {
		return numberOfEmloyees;
	}

	public void setRoleAllowance(double RoleAllowance) {
		this.roleAllowance = RoleAllowance;
	}

	public void setRoleID(int RoleID) {
		this.roleID = RoleID;
	}

	public void setRoleName(String RoleName) {
		this.roleName = RoleName;
	}

	public void setNumberOfEmloyees(int numberOfEmloyees) {
		this.numberOfEmloyees = numberOfEmloyees;
	}
}
