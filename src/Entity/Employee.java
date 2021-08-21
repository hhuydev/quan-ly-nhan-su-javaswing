package Entity;

public class Employee {

	private int employeeID;
	private String employeeName;
	private String password;
	private boolean isSystemAdmin;
	private String username;
	private int numberOfTransfer;
	private Role role;
	private Project project;
	private Department department;
	private Location location;

	public Employee() {
		this.role = new Role();
		this.project = new Project();
		this.department = new Department();
		this.location = new Location();
	}

	public Employee(String EmployeeName, String Password, Role role, boolean IsSystemAdmin, Project project,
			Department department, Location location) {
		this.employeeName = EmployeeName;
		this.password = Password;
		this.role = role;
		this.isSystemAdmin = IsSystemAdmin;
		this.project = project;
		this.department = department;
		this.location = location;
	}

	public Employee(int employeeID) {
		super();
		this.employeeID = employeeID;
	}

	public Employee(int employeeID, String employeeName, String password, boolean isSystemAdmin, String username,
			int numberOfTransfer, Role role, Project project, Department department, Location location) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.password = password;
		this.isSystemAdmin = isSystemAdmin;
		this.username = username;
		this.numberOfTransfer = numberOfTransfer;
		this.role = role;
		this.project = project;
		this.department = department;
		this.location = location;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public boolean isSystemAdmin() {
		return isSystemAdmin;
	}

	public String getPassword() {
		return password;
	}

	public Department getDepartment() {
		return department;
	}

	public Location getLocation() {
		return location;
	}

	public Project getProject() {
		return project;
	}

	public Role getRole() {
		return role;
	}

	public void setEmployeeID(int EmployeeID) {
		this.employeeID = EmployeeID;
	}

	public void setEmployeeName(String EmployeeName) {
		this.employeeName = EmployeeName;
	}

	public void setIsSystemAdmin(boolean IsSystemAdmin) {
		this.isSystemAdmin = IsSystemAdmin;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setNumberOfTransfer(int numberOfTransfer) {
		this.numberOfTransfer = numberOfTransfer;
	}

	public int getNumberOfTransfer() {
		return numberOfTransfer;
	}
}
