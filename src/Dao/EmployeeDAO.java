package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Config.ConnectionConfig;
import Entity.Employee;

public class EmployeeDAO {
	/* Select All By condition */

	public static List<Employee> selectAllEmployeeByCondition(String condition)
			throws ClassNotFoundException, SQLException {
		List<Employee> employeeList = null;
		Connection conn = ConnectionConfig.getConnection();

		StringBuilder query = new StringBuilder();
		query.append(" SELECT Employees.*,Departments.DepartmentName,");
		query.append(" Locations.LocationName,Projects.ProjectName,Roles.RoleName,Roles.RoleAllowance,");
		query.append(" Count(Transfers.TransferID) as NumberOfTransfer");
		query.append(" FROM Employees,Departments,Locations,Projects,Roles,Transfers");
		query.append(" WHERE Departments.DepartmentID = Employees.DepartmentID ");
		query.append(" AND Locations.LocationID = Employees.LocationID");
		query.append(" AND Projects.ProjectID = Employees.ProjectID ");
		query.append(" AND Roles.RoleID = Employees.RoleID");
		query.append(" AND Transfers.EmployeeID = Employees.EmployeeID");
		if (condition.compareTo("") != 0) {
			query.append(" AND ");
			query.append(condition);
		}
		query.append(
				" GROUP BY Employees.EmployeeID, Employees.EmployeeName, Employees.[Password],Employees.[Username],");
		query.append(" Employees.RoleID, Employees.IsSystemAdmin, Employees.ProjectID,");
		query.append(" Employees.DepartmentID, Employees.LocationID,");
		query.append(" Departments.DepartmentName,Locations.LocationName,");
		query.append(" Projects.ProjectName,Roles.RoleName,Roles.RoleAllowance");
		query.append(" union");
		query.append(" SELECT Employees.*,Departments.DepartmentName,");
		query.append(" Locations.LocationName,Projects.ProjectName,Roles.RoleName,Roles.RoleAllowance,");
		query.append("  0 as NumberOfTransfer");
		query.append(" FROM Employees,Departments,Locations,Projects,Roles");
		query.append(" WHERE Departments.DepartmentID = Employees.DepartmentID ");
		query.append(" AND Locations.LocationID = Employees.LocationID");
		query.append(" AND Projects.ProjectID = Employees.ProjectID ");
		query.append(" AND Roles.RoleID = Employees.RoleID");
		query.append(" AND EmployeeID not in (Select EmployeeId from transfers)");
		if (condition.compareTo("") != 0) {
			query.append(" AND ");
			query.append(condition);
		}
		// System.out.println(query.toString());

		PreparedStatement pStmt = conn.prepareStatement(query.toString());
		ResultSet rs = pStmt.executeQuery();

		employeeList = new ArrayList<Employee>();
		while (rs.next()) {
			Employee employee = new Employee();

			employee.setEmployeeID(rs.getInt("EmployeeID"));
			employee.setEmployeeName(rs.getNString("EmployeeName"));
			employee.setPassword(rs.getNString("Password"));
			employee.setUsername(rs.getNString("Username"));

			employee.getLocation().setLocationID(rs.getInt("LocationID"));
			employee.getLocation().setLocationName(rs.getNString("LocationName"));

			employee.getDepartment().setDepartmentID(rs.getInt("DepartmentID"));
			employee.getDepartment().setDepartmentName(rs.getNString("DepartmentName"));

			employee.getProject().setProjectID(rs.getInt("ProjectID"));
			employee.getProject().setProjectName(rs.getNString("ProjectName"));

			employee.getRole().setRoleID(rs.getInt("RoleID"));
			employee.getRole().setRoleName(rs.getNString("RoleName"));
			employee.getRole().setRoleAllowance(rs.getDouble("RoleAllowance"));

			employee.setIsSystemAdmin(rs.getBoolean("IsSystemAdmin"));
			employee.setNumberOfTransfer(rs.getInt("NumberOfTransfer"));

			// add Employee object into EmployeeList
			employeeList.add(employee);
		}

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
		return employeeList;
	}

	/* Get All Employee record */
	public static List<Employee> selectAllEmployee() throws ClassNotFoundException, SQLException {
		List<Employee> employeeList = selectAllEmployeeByCondition("");
		return employeeList;
	}

	public List<Employee> getEmployeeByProject(int projectID) throws ClassNotFoundException, SQLException {
		List<Employee> employeeList = selectAllEmployeeByCondition("Employees.ProjectID = " + projectID);
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return null;
		}
	}

	public List<Employee> getEmployeeByDepartment(int departmentID) throws ClassNotFoundException, SQLException {
		List<Employee> employeeList = selectAllEmployeeByCondition("Employees.DepartmentID = " + departmentID);
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return null;
		}
	}

	/* Get One Employee record */
	public static Employee selectOneEmployeeByID(int empId) throws ClassNotFoundException, SQLException {
		List<Employee> employeeList = selectAllEmployeeByCondition("Employees.EmployeeID=" + empId);
		if (employeeList.size() > 0) {
			return employeeList.get(0);
		} else {
			return null;
		}
	}

	/* Delete Employee */
	public static void deleteEmployee(int EmployeeID) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement pStmt = conn.prepareStatement("DELETE FROM Employees WHERE EmployeeID = " + EmployeeID);
		pStmt.executeUpdate();
		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
	}

	/* use for Login Process */
	public static Employee isValidUser(String userName, String password) throws ClassNotFoundException, SQLException {
		List<Employee> empLst = EmployeeDAO
				.selectAllEmployeeByCondition("Username = '" + userName + "' AND Password='" + password + "'");
		if (empLst.size() > 0) {
			return empLst.get(0);
		} else {
			return null;
		}
	}

	/* isAvaiableUsername */
	public static boolean isAvaiableUsername(String username) throws ClassNotFoundException, SQLException {
		List<Employee> empLst = EmployeeDAO.selectAllEmployeeByCondition("[Username] = '" + username + "'");
		if (empLst.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**/
	public static int insertEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		int empID = 0;
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();
		query.append(" INSERT INTO  [dbo].[Employees]");
		query.append(
				" ([EmployeeName],[Username],[Password],[IsSystemAdmin],[RoleID],[ProjectID],[DepartmentID],[LocationID] )");
		query.append(" VALUES(?,?,?,?,?,?,?,?)");
		PreparedStatement pStmt = conn.prepareStatement(query.toString());
		pStmt.setNString(1, employee.getEmployeeName());
		pStmt.setNString(2, employee.getUsername());
		pStmt.setNString(3, employee.getPassword());
		pStmt.setBoolean(4, employee.isSystemAdmin());
		pStmt.setInt(5, employee.getRole().getRoleID());
		pStmt.setInt(6, employee.getProject().getProjectID());
		pStmt.setInt(7, employee.getDepartment().getDepartmentID());
		pStmt.setInt(8, employee.getLocation().getLocationID());
		pStmt.executeUpdate();

		pStmt = conn.prepareStatement("SELECT Max(EmployeeID)AS [MaxID] FROM Employees ");
		ResultSet rs = pStmt.executeQuery();
		rs.next();
		empID = rs.getInt("MaxID");

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
		return empID;
	}

	/* Update Employee */
	public static void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();

		query.append(" UPDATE [Employees] SET");
		query.append(" [EmployeeName] = ?,[Username]=?,[Password] = ?,[IsSystemAdmin] = ?,[RoleID] = ?,");
		query.append(" [ProjectID] = ?,[DepartmentID] = ?,[LocationID] = ?");
		query.append(" WHERE [EmployeeID] = ?");

		PreparedStatement pStmt = conn.prepareStatement(query.toString());
		pStmt.setNString(1, employee.getEmployeeName());
		pStmt.setNString(2, employee.getUsername());
		pStmt.setNString(3, employee.getPassword());
		pStmt.setBoolean(4, employee.isSystemAdmin());
		pStmt.setInt(5, employee.getRole().getRoleID());
		pStmt.setInt(6, employee.getProject().getProjectID());
		pStmt.setInt(7, employee.getDepartment().getDepartmentID());
		pStmt.setInt(8, employee.getLocation().getLocationID());
		pStmt.setInt(9, employee.getEmployeeID());
		pStmt.executeUpdate();

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/* Test Insert OK Update */
//        Employee newEmp = new Employee();
//        newEmp.setEmployeeID(13);
//        newEmp.setEmployeeName("New Name 13");
//        newEmp.setIsSystemAdmin(true);
//        newEmp.setUsername("newname");
//        newEmp.setPassword("ACjB22sOjjw=");
//        newEmp.getDepartment().setDepartmentID(1);
//        newEmp.getRole().setRoleID(2);
//        newEmp.getLocation().setLocationID(2);
//        newEmp.getProject().setProjectID(2);
//
//        //EmployeeDAO.insertEmployee(newEmp);
//        EmployeeDAO.updateEmployee(newEmp);
//
//        //EmployeeDAO employeeDAO = new EmployeeDAO();

		/* Delete OK */
//        EmployeeDAO.deleteEmployee(13);

		/* Test Select by Condition */
//        List<Employee> EmployeeList = EmployeeDAO.selectAllEmployee();
//        for (Employee employee : EmployeeList)
//        {
//            Location location = employee.getLocation();
//            Department department = employee.getDepartment();
//            Role role = employee.getRole();
//            Project project = employee.getProject();
//
//            System.out.println("-----------------------------------------------");
//            System.out.println("Emp ID: " + employee.getEmployeeID());
//            System.out.println("Emp Name: " + employee.getEmployeeName());
//            System.out.println("Username: " + employee.getUsername());
//            System.out.println("Emp Password: " + employee.getPassword());
//            System.out.println("Emp isSystemAdmin: " + employee.isSystemAdmin());
//            System.out.println("LocationID: " + location.getLocationID());
//            System.out.println("Location Name: " + location.getLocationName());
//            System.out.println("Location Allowance: " + location.getLocationAllowance());
//            System.out.println("DepartmentID: " + department.getDepartmentID());
//            System.out.println("Department Name: " + department.getDepartmentName());
//            System.out.println("Role ID: " + role.getRoleID());
//            System.out.println("Role Name: " + role.getRoleName());
//            System.out.println("Role Allowance: " + role.getRoleAllowance());
//            System.out.println("Project ID: " + project.getProjectID());
//            System.out.println("Project Name: " + project.getProjectName());
//            System.out.println("Number Of Transfer: " + employee.getNumberOfTransfer());
//        }
//        /*Test select one and isValidUser*/
//            Employee employee = EmployeeDAO.isValidUser("", null)
//            System.out.println("-----------------------------------------------");
//            System.out.println("Emp ID: " + employee.getEmployeeID());
//            System.out.println("Emp Name: " + employee.getEmployeeName());
//            System.out.println("Username: " + employee.getUsername());
//            System.out.println("Emp Password: " + employee.getPassword());
//            System.out.println("Emp isSystemAdmin: " + employee.isSystemAdmin());
//            System.out.println("LocationID: " + location.getLocationID());
//            System.out.println("Location Name: " + location.getLocationName());
//            System.out.println("Location Allowance: " + location.getLocationAllowance());
//            System.out.println("DepartmentID: " + department.getDepartmentID());
//            System.out.println("Department Name: " + department.getDepartmentName());
//            System.out.println("Role ID: " + role.getRoleID());
//            System.out.println("Role Name: " + role.getRoleName());
//            System.out.println("Role Allowance: " + role.getRoleAllowance());
//            System.out.println("Project ID: " + project.getProjectID());
//            System.out.println("Project Name: " + project.getProjectName());
//            System.out.println("Number Of Transfer: " + employee.getNumberOfTransfer());
		/* Test getEmployeeByRoles */
//        List<Employee> EmployeeListByRole = new EmployeeDAO().getEmployeeByRole(1);
//        for (Employee employee : EmployeeListByRole)
//        {
//            Location location = employee.getLocation();
//            Department department = employee.getDepartment();
//            Role role = employee.getRole();
//            Project project = employee.getProject();
//
//            System.out.print("-----------------------------------------------------------");
//            System.out.println("Emp ID: " + employee.getEmployeeID());
//            System.out.println("Emp Name: " + employee.getEmployeeName());
//            System.out.println("Emp Password: " + employee.getPassword());
//            System.out.println("Emp isSystemAdmin: " + employee.isSystemAdmin());
//            System.out.println("LocationID: " + location.getLocationID());
//            System.out.println("Location Name: " + location.getLocationName());
//            System.out.println("Location Allowance: " + location.getLocationAllowance());
//            System.out.println("DepartmentID: " + department.getDepartmentID());
//            System.out.println("Department Name: " + department.getDepartmentName());
//            System.out.println("Role ID: " + role.getRoleID());
//            System.out.println("Role Name: " + role.getRoleName());
//            System.out.println("Role Allowance: " + role.getRoleAllowance());
//            System.out.println("Project ID: " + project.getProjectID());
//            System.out.println("Project Name: " + project.getProjectName());
//        }

		/* Test getEmployeeByProject */
//        List<Employee> EmployeeListByProject = new EmployeeDAO().getEmployeeByProject(2);
//        for (Employee employee : EmployeeListByProject)
//        {
//            Location location = employee.getLocation();
//            Department department = employee.getDepartment();
//            Role role = employee.getRole();
//            Project project = employee.getProject();
//
//            System.out.print("-----------------------------------------------------------");
//            System.out.println("Emp ID: " + employee.getEmployeeID());
//            System.out.println("Emp Name: " + employee.getEmployeeName());
//            System.out.println("Emp Password: " + employee.getPassword());
//            System.out.println("Emp isSystemAdmin: " + employee.isSystemAdmin());
//            System.out.println("LocationID: " + location.getLocationID());
//            System.out.println("Location Name: " + location.getLocationName());
//            System.out.println("Location Allowance: " + location.getLocationAllowance());
//            System.out.println("DepartmentID: " + department.getDepartmentID());
//            System.out.println("Department Name: " + department.getDepartmentName());
//            System.out.println("Role ID: " + role.getRoleID());
//            System.out.println("Role Name: " + role.getRoleName());
//            System.out.println("Role Allowance: " + role.getRoleAllowance());
//            System.out.println("Project ID: " + project.getProjectID());
//            System.out.println("Project Name: " + project.getProjectName());
//        }

		/* Test getEmployeeByDepartment */
//        List<Employee> EmployeeListByDepartment = new EmployeeDAO().getEmployeeByDepartment(10);
//        for (Employee employee : EmployeeListByDepartment)
//        {
//            Location location = employee.getLocation();
//            Department department = employee.getDepartment();
//            Role role = employee.getRole();
//            Project project = employee.getProject();
//
//            System.out.print("-----------------------------------------------------------");
//            System.out.println("Emp ID: " + employee.getEmployeeID());
//            System.out.println("Emp Name: " + employee.getEmployeeName());
//            System.out.println("Emp Password: " + employee.getPassword());
//            System.out.println("Emp isSystemAdmin: " + employee.isSystemAdmin());
//            System.out.println("LocationID: " + location.getLocationID());
//            System.out.println("Location Name: " + location.getLocationName());
//            System.out.println("Location Allowance: " + location.getLocationAllowance());
//            System.out.println("DepartmentID: " + department.getDepartmentID());
//            System.out.println("Department Name: " + department.getDepartmentName());
//            System.out.println("Role ID: " + role.getRoleID());
//            System.out.println("Role Name: " + role.getRoleName());
//            System.out.println("Role Allowance: " + role.getRoleAllowance());
//            System.out.println("Project ID: " + project.getProjectID());
//            System.out.println("Project Name: " + project.getProjectName());
//
//        }

		/* Test getEmployeeByLocation */
//        List<Employee> EmployeeListByLocation = new EmployeeDAO().getEmployeeByLocation(1);
//        for (Employee employee : EmployeeListByLocation)
//        {
//            Location location = employee.getLocation();
//            Department department = employee.getDepartment();
//            Role role = employee.getRole();
//            Project project = employee.getProject();
//
//            System.out.print("-----------------------------------------------------------");
//            System.out.println("Emp ID: " + employee.getEmployeeID());
//            System.out.println("Emp Name: " + employee.getEmployeeName());
//            System.out.println("Emp Password: " + employee.getPassword());
//            System.out.println("Emp isSystemAdmin: " + employee.isSystemAdmin());
//            System.out.println("LocationID: " + location.getLocationID());
//            System.out.println("Location Name: " + location.getLocationName());
//            System.out.println("Location Allowance: " + location.getLocationAllowance());
//            System.out.println("DepartmentID: " + department.getDepartmentID());
//            System.out.println("Department Name: " + department.getDepartmentName());
//            System.out.println("Role ID: " + role.getRoleID());
//            System.out.println("Role Name: " + role.getRoleName());
//            System.out.println("Role Allowance: " + role.getRoleAllowance());
//            System.out.println("Project ID: " + project.getProjectID());
//            System.out.println("Project Name: " + project.getProjectName());
//        }

		/* Test Get all Employee */
//        List<Employee> EmployeeList = new EmployeeDAO().selectAllEmployee();
//        for (Employee employee : EmployeeList)
//        {
//            Location location = employee.getLocation();
//            Department department = employee.getDepartment();
//            Role role = employee.getRole();
//            Project project = employee.getProject();
//
//            System.out.println("Emp ID: " + employee.getEmployeeID());
//            System.out.println("Emp Name: " + employee.getEmployeeName());
//            System.out.println("Emp Password: " + employee.getPassword());
//            System.out.println("Emp isSystemAdmin: " + employee.isSystemAdmin());
//            System.out.println("LocationID: " + location.getLocationID());
//            System.out.println("Location Name: " + location.getLocationName());
//            System.out.println("Location Allowance: " + location.getLocationAllowance());
//            System.out.println("DepartmentID: " + department.getDepartmentID());
//            System.out.println("Department Name: " + department.getDepartmentName());
//            System.out.println("Role ID: " + role.getRoleID());
//            System.out.println("Role Name: " + role.getRoleName());
//            System.out.println("Role Allowance: " + role.getRoleAllowance());
//            System.out.println("Project ID: " + project.getProjectID());
//            System.out.println("Project Name: " + project.getProjectName());
//        }

		/* Test get a Employee record - get by ID */
//        Employee employee = employeeDAO.selectEmployeeByID(1);
//        Location location = employee.getLocation();
//        Department department = employee.getDepartment();
//        Role role = employee.getRole();
//        Project project = employee.getProject();
//
//        System.out.println("Emp ID: " + employee.getEmployeeID());
//        System.out.println("Emp Name: " + employee.getEmployeeName());
//        System.out.println("Emp Password: " + employee.getPassword());
//        System.out.println("Emp isSystemAdmin: " + employee.isSystemAdmin());
//        System.out.println("LocationID: " + location.getLocationID());
//        System.out.println("Location Name: " + location.getLocationName());
//        System.out.println("Location Allowance: " + location.getLocationAllowance());
//        System.out.println("DepartmentID: " + department.getDepartmentID());
//        System.out.println("Department Name: " + department.getDepartmentName());
//        System.out.println("Role ID: " + role.getRoleID());
//        System.out.println("Role Name: " + role.getRoleName());
//        System.out.println("Role Allowance: " + role.getRoleAllowance());
//        System.out.println("Project ID: " + project.getProjectID());
//        System.out.println("Project Name: " + project.getProjectName());

		/* Test Update a recod */
//        Employee employee = new Employee();
//        employee.setEmployeeID(4);
//        employee.setEmployeeName("Lương Trứng Kiền");
//        employee.setIsSystemAdmin(true);
//        employee.setPassword("1234567");
//        employee.setDepartment(new Department(1, "Ha Noi"));
//        employee.setLocation(new Location(1, "HĂ  Ná»™i", 100.00));
//        employee.setProject(new Project(1, "Java"));
//        employee.setRole(new Role(1, "CEO", 1000.00));
//        employeeDAO.updateEmployee(employee);

		/* Delete a record */
//        employeeDAO.deleteEmployee(10);

		/* Insert a record */
//        Employee employee = new Employee();
//        employee.setEmployeeName("Phan Diá»…m My");
//        employee.setIsSystemAdmin(true);
//        employee.setPassword("1234567");
//        employee.setDepartment(new Department(1, "Ha Noi"));
//        employee.setLocation(new Location(1, "HĂ  Ná»™i", 100.00));
//        employee.setProject(new Project(1, "Java"));
//        employee.setRole(new Role(1, "CEO", 1000.00));
//        System.out.print(employeeDAO.insertEmployee(employee));

		/* Test Test is Valid User */
//        Employee employee = null;
//        employee =employeeDAO.isValidUser(1, "dfgểtt");
//        if ( employee != null)
//        {
//            Location location = employee.getLocation();
//            Department department = employee.getDepartment();
//            Role role = employee.getRole();
//            Project project = employee.getProject();
//
//            System.out.println("Emp ID: " + employee.getEmployeeID());
//            System.out.println("Emp Name: " + employee.getEmployeeName());
//            System.out.println("Emp Password: " + employee.getPassword());
//            System.out.println("Emp isSystemAdmin: " + employee.isSystemAdmin());
//            System.out.println("LocationID: " + location.getLocationID());
//            System.out.println("Location Name: " + location.getLocationName());
//            System.out.println("Location Allowance: " + location.getLocationAllowance());
//            System.out.println("DepartmentID: " + department.getDepartmentID());
//            System.out.println("Department Name: " + department.getDepartmentName());
//            System.out.println("Role ID: " + role.getRoleID());
//            System.out.println("Role Name: " + role.getRoleName());
//            System.out.println("Role Allowance: " + role.getRoleAllowance());
//            System.out.println("Project ID: " + project.getProjectID());
//            System.out.println("Project Name: " + project.getProjectName());
//        }
//        else
//        {
//            System.out.print("Error");
//        }
		/* Test Count number of Transfer following Employee record */
//        System.out.print(employeeDAO.countTransferByEmployeeID(1));
	}

}
