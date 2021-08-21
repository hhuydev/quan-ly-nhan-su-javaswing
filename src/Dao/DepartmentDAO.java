/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Config.ConnectionConfig;
import Entity.Department;

public class DepartmentDAO {
	/* selectAllDepartment method get all record from Departments Table */

	public static List<Department> selectAllDepartment() throws ClassNotFoundException, SQLException {
		/* Init Components */
		List<Department> departmentList = null;
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();
		PreparedStatement pStmt = null;
		ResultSet resultSet1, resultSet2, resultSet3;

		/* Select Department ID, Department Name and Number Of Employees belong to */
		query.append(
				" SELECT dbo.Departments.DepartmentID, dbo.Departments.DepartmentName, COUNT(dbo.Employees.EmployeeID) AS NumOfEmployee");
		query.append(" FROM dbo.Departments, dbo.Employees");
		query.append(" WHERE dbo.Departments.DepartmentID = dbo.Employees.DepartmentID");
		query.append(" GROUP BY dbo.Departments.DepartmentID, dbo.Departments.DepartmentName");
		query.append(" UNION");
		query.append(" SELECT dbo.Departments.DepartmentID, dbo.Departments.DepartmentName,0 AS NumOfEmployee");
		query.append(" FROM dbo.Departments,dbo.Employees");
		query.append(
				" WHERE dbo.Departments.DepartmentID not in(select dbo.Employees.DepartmentID from dbo.Employees )");
		query.append(" GROUP BY dbo.Departments.DepartmentID, dbo.Departments.DepartmentName");

		pStmt = conn.prepareStatement(query.toString());
		resultSet1 = pStmt.executeQuery();// result(DepartmentID,DepartmentName,FromDepartmentCount)

		/* Select number of TO transfer which has respective DepartmentID */
		query = new StringBuilder();
		query.append(" SELECT dbo.Departments.DepartmentID,COUNT(dbo.Transfers.ToDepartmentID) AS ToDepartmentCount");
		query.append(" FROM dbo.Departments,dbo.Transfers");
		query.append(" WHERE Transfers.ToDepartmentID = Departments.DepartmentID");
		query.append(" GROUP BY dbo.Departments.DepartmentID");
		query.append(" UNION");
		query.append(" SELECT dbo.Departments.DepartmentID,0 AS ToDepartmentCount");
		query.append(" FROM dbo.Departments,dbo.Transfers");
		query.append(" WHERE Departments.DepartmentID not in(select Transfers.ToDepartmentID from Transfers )");

		pStmt = conn.prepareStatement(query.toString());
		resultSet2 = pStmt.executeQuery();// result(DepartmentID,ToDepartmentCount)

		/* Select number of FROM transfer which has respective DepartmentID */
		query = new StringBuilder();
		query.append(" SELECT dbo.Departments.DepartmentID,COUNT(dbo.Transfers.ToDepartmentID) AS FromDepartmentCount");
		query.append(" FROM dbo.Departments,dbo.Transfers");
		query.append(" WHERE Transfers.FromDepartmentID = Departments.DepartmentID");
		query.append(" GROUP BY dbo.Departments.DepartmentID");
		query.append(" UNION");
		query.append(" SELECT dbo.Departments.DepartmentID,0 AS FromDepartmentCount");
		query.append(" FROM dbo.Departments,dbo.Transfers");
		query.append(" WHERE Departments.DepartmentID not in(select Transfers.FromDepartmentID from Transfers )");
		pStmt = conn.prepareStatement(query.toString());
		resultSet3 = pStmt.executeQuery();// result(DepartmentID,FromDepartmentCount)

		/* Push Data to BEAN OBJECTs */
		departmentList = new ArrayList<Department>();
		while (resultSet1.next()) {
			resultSet2.next();
			resultSet3.next();
			Department department = new Department();
			department.setDepartmentID(resultSet1.getInt("DepartmentID"));//
			department.setDepartmentName(resultSet1.getNString("DepartmentName"));
			department.setNumOfEmployee(resultSet1.getInt("NumOfEmployee"));
			department.setToDepartmentCount(resultSet2.getInt("ToDepartmentCount"));
			department.setFromDepartmentCount(resultSet3.getInt("FromDepartmentCount"));
			departmentList.add(department);
		}
		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
		return departmentList;
	}
	/* insertDepartment method insert a new record into Deparments table */

	public static int insertDepartment(Department department) throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO  [dbo].[Departments]( [DepartmentName] ) VALUES(?) ");

		PreparedStatement pStmt = conn.prepareStatement(query.toString());
		pStmt.setNString(1, department.getDepartmentName());
		pStmt.executeUpdate();

		// Get Max ID and Return
		pStmt = conn.prepareStatement("SELECT MAX(DepartmentID) AS MaxID FROM Departments");
		ResultSet rs = pStmt.executeQuery();
		rs.next();
		result = rs.getInt("MaxID");

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
		return result;
	}

	/*
	 * Update Department method was created for Update a record from Department,
	 * folowing DepartmentID
	 */
	public static void updateDepartment(Department department) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();
		query.append("UPDATE [dbo].[Departments] SET [DepartmentName] = ?");
		query.append(" WHERE [DepartmentID] = ?");

		PreparedStatement pStmt = conn.prepareStatement(query.toString());

		pStmt.setNString(1, department.getDepartmentName());
		pStmt.setInt(2, department.getDepartmentID());

		pStmt.executeUpdate();

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);

	}

	/* deleteDepartment delete a Department */
	public static void deleteDepartment(int DepartmentID) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement pStmt = conn.prepareStatement("DELETE FROM Departments WHERE DepartmentID = " + DepartmentID);
		pStmt.executeUpdate();
		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);

	}

	/* TEST CASE */

//      public static void main(String[] args) throws ClassNotFoundException, SQLException
//      {
//          /*Test get All Department in Departments table*/
//          for (Department department : DepartmentList)
//          {
//              System.out.print(department.getDepartmentID() + " ");
//              System.out.print(department.getDepartmentName());
//              System.out.print("\n");
//          }
	/* Test Insert Department */
//          System.out.println(departmentDAO.insertDepartment(new Department("dasd")));
	/* Test Delete Department */
//          departmentDAO.deleteDepartment(6);
	/* Test Update Deparment */
//         departmentDAO.updateDepartment(new Department(3, "Alô lét gét ít tặc"));
	/* Test Count Employee by Department */
//         System.out.println(departmentDAO.countEmployeeByDepartment(5));
//      }
//
}
