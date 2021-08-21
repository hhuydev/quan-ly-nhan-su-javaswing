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
import Entity.Role;

public class RoleDAO {
	/*
	 * selectAllRole get all of Role from Roles table, after that insert all record
	 * into List<Role>
	 */

	public static List<Role> selectAllRole() throws ClassNotFoundException, SQLException {
		List<Role> RoleList = null;
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();
		query.append(
				" SELECT Roles.RoleID, Roles.RoleName,Roles.RoleAllowance, COUNT(Employees.EmployeeID) AS NumOfEmployee");
		query.append(" FROM Roles, Employees");
		query.append(" WHERE Roles.RoleID = Employees.RoleID");
		query.append(" GROUP BY Roles.RoleID, Roles.RoleName,Roles.RoleAllowance");
		query.append(" UNION");
		query.append(" SELECT Roles.RoleID, Roles.RoleName,Roles.RoleAllowance, 0 AS NumOfEmployee");
		query.append(" FROM Roles,Employees");
		query.append(" WHERE Roles.RoleID not in(SELECT Employees.RoleID FROM Employees )");
		query.append(" GROUP BY Roles.RoleID, Roles.RoleName,Roles.RoleAllowance");

		PreparedStatement pStmt = conn.prepareStatement(query.toString());
		ResultSet resultSet = pStmt.executeQuery();

		RoleList = new ArrayList<Role>();
		while (resultSet.next()) {
			Role role = new Role();
			role.setRoleID(resultSet.getInt("RoleID"));
			role.setRoleName(resultSet.getNString("RoleName"));
			role.setRoleAllowance(resultSet.getDouble("RoleAllowance"));
			role.setNumberOfEmloyees(resultSet.getInt("NumOfEmployee"));
			RoleList.add(role);
		}
		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
		return RoleList;
	}

	/* insertRole insert a new RoleRecord */
	public static int insertRole(Role role) throws SQLException, ClassNotFoundException {
		int result = 0;
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();
		query.append(" INSERT INTO  [dbo].[Roles] ([RoleName],[RoleAllowance] )");
		query.append(" VALUES(?,?)");

		PreparedStatement pStmt = conn.prepareStatement(query.toString());
		pStmt.setNString(1, role.getRoleName());
		pStmt.setDouble(2, role.getRoleAllowance());
		pStmt.executeUpdate();

		// Get New ID
		pStmt = conn.prepareStatement("SELECT MAX(RoleId) AS MaxID FROM Roles");
		ResultSet rs = pStmt.executeQuery();
		rs.next();
		result = rs.getInt("MaxID");

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
		return result;
	}

	/* updateRole was created for editing each Role from Roles table */
	public static void updateRole(Role role) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();

		query.append(" UPDATE  [dbo].[Roles]");
		query.append(" SET [RoleName] = ?,[RoleAllowance] = ?");
		query.append(" WHERE [RoleID] = ?");

		PreparedStatement pStmt = conn.prepareStatement(query.toString());
		pStmt.setNString(1, role.getRoleName());
		pStmt.setDouble(2, role.getRoleAllowance());
		pStmt.setInt(3, role.getRoleID());
		pStmt.executeUpdate();

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
	}

	/* deleteRole delete a specify Role */
	public static void deleteRole(int RoleID) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionConfig.getConnection();

		PreparedStatement pStmt = conn.prepareStatement("DELETE FROM roles WHERE RoleID = " + RoleID);
		pStmt.execute();

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		List<Role> roleList = RoleDAO.selectAllRole();
//
//        /*Test get All role form Roles Table*/
//        for (Role role : roleList)
//        {
//            System.out.print(role.getRoleID() + " ");
//            System.out.print(role.getRoleName() + " " );
//            System.out.print(role.getRoleAllowance() + " ");
//            System.out.print(role.getNumberOfEmloyees() + " ");
//            System.out.print("\n");
//        }
		/* Test insert a role into Roles Table */
//        System.out.print(RoleDAO.insertRole(new Role(0,"New Role", 550)));
//
//        /*Test update a role from Roles Table*/
		RoleDAO.updateRole(new Role(7, "Code", 99.9));
//
//        /*Test Delete a role from Roles Talbe*/
//        roleDAO.deleteRole(8);

	}
}
