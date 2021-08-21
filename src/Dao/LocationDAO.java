package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Config.ConnectionConfig;
import Entity.Location;

public class LocationDAO {
	/*
	 * selectAllLocation is a method for doing select all record form Locations
	 * table
	 */

	public static List<Location> selectAllLocation() throws SQLException, ClassNotFoundException {
		/* Init Components */
		List<Location> projectList = null;
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();
		PreparedStatement pStmt = null;
		ResultSet resultSet1, resultSet2, resultSet3;

		/* Select Location ID, Location Name and Number Of Employees belong to */
		query.append(" SELECT Locations.*,COUNT(Employees.EmployeeID) AS NumOfEmployee");
		query.append(" FROM Locations, Employees");
		query.append(" WHERE Locations.LocationID = Employees.LocationID");
		query.append(" GROUP BY Locations.LocationID, Locations.LocationName,Locations.LocationAllowance");
		query.append(" UNION");
		query.append(" SELECT Locations.*,0 AS NumOfEmployee");
		query.append(" FROM Locations,Employees");
		query.append(" WHERE Locations.LocationID not in(SELECT Employees.LocationID FROM Employees )");
		query.append(" GROUP BY Locations.LocationID, Locations.LocationName,Locations.LocationAllowance");

		pStmt = conn.prepareStatement(query.toString());
		resultSet1 = pStmt.executeQuery();// result(ProjectID,ProjectName,NumOfEmployee)

		/* Select number of TO transfer which has respective LocationID */
		query = new StringBuilder();
		query.append(" SELECT Locations.LocationID, COUNT(Transfers.TransferID) AS ToLocationCount");
		query.append(" FROM Locations, Transfers");
		query.append(" WHERE Locations.LocationID = Transfers.ToLocationID");
		query.append(" GROUP BY Locations.LocationID");
		query.append(" UNION");
		query.append(" SELECT Locations.LocationID,0 AS ToLocationCount");
		query.append(" FROM Locations,Transfers");
		query.append(" WHERE Locations.LocationID not in(SELECT Transfers.ToLocationID FROM Transfers )");

		pStmt = conn.prepareStatement(query.toString());
		resultSet2 = pStmt.executeQuery();// result(LocationID,ToLocationCount)

		/* Select number of FROM transfer which has respective LocationID */
		query = new StringBuilder();
		query.append(" SELECT Locations.LocationID, COUNT(Transfers.TransferID) AS FromLocationCount");
		query.append(" FROM Locations, Transfers");
		query.append(" WHERE Locations.LocationID = Transfers.FromLocationID");
		query.append(" GROUP BY Locations.LocationID");
		query.append(" UNION");
		query.append(" SELECT Locations.LocationID,0 AS FromLocationCount");
		query.append(" FROM Locations,Transfers");
		query.append(" WHERE Locations.LocationID not in(SELECT Transfers.FromLocationID FROM Transfers )");
		pStmt = conn.prepareStatement(query.toString());
		resultSet3 = pStmt.executeQuery();// result(TransferID,FromLocationCount)

		/* Push Data to BEAN OBJECTs */
		projectList = new ArrayList<Location>();
		while (resultSet1.next()) {
			resultSet2.next();
			resultSet3.next();

			Location project = new Location();

			project.setLocationID(resultSet1.getInt("LocationID"));//
			project.setLocationName(resultSet1.getNString("LocationName"));
			project.setLocationAllowance(resultSet1.getDouble("LocationAllowance"));
			project.setNumberOfEmployees(resultSet1.getInt("NumOfEmployee"));

			project.setToTransferCount(resultSet2.getInt("ToLocationCount"));

			project.setFromTransferCount(resultSet3.getInt("FromLocationCount"));

			projectList.add(project);
		}
		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
		return projectList;
	}

	/*
	 * insertLocation method use to insert a new record into Locations table, it
	 * comprise Location ID and it's details.
	 */
	public static int insertLocation(Location location) throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();

		query.append(" INSERT INTO  [dbo].[Locations] ([LocationName],[LocationAllowance]) ");
		query.append(" VALUES (?,?)");
		PreparedStatement pStmt = conn.prepareStatement(query.toString());

		pStmt.setNString(1, location.getLocationName());
		pStmt.setDouble(2, location.getLocationAllowance());
		pStmt.executeUpdate();

		pStmt = conn.prepareStatement("SELECT MAX(LocationId) AS MaxId FROM Locations");
		ResultSet rs = pStmt.executeQuery();
		rs.next();
		result = rs.getInt("MaxId");

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
		return result;
	}
	/*
	 * updateLocation method was created for updating each location record which was
	 * passed into by Location ID
	 */

	public static void updateLocation(Location location) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();

		query.append(" UPDATE  [dbo].[Locations]");
		query.append(" SET [LocationName] = ?,[LocationAllowance] = ?");
		query.append(" WHERE [LocationID] = ?");

		PreparedStatement pStmt = conn.prepareStatement(query.toString());

		pStmt.setNString(1, location.getLocationName());
		pStmt.setDouble(2, location.getLocationAllowance());
		pStmt.setInt(3, location.getLocationID());
		pStmt.executeUpdate();

		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);

	}
	/*
	 * deleteLocation medthod was created for deleting a Location following
	 * LocationID
	 */

	public static void deleteLocation(int LocationID) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement pStmt = conn.prepareStatement("DELETE FROM Locations WHERE LocationID = " + LocationID);
		pStmt.executeUpdate();
		ConnectionConfig.closePreparedStatement(pStmt);
		ConnectionConfig.closeConnection(conn);
	}

	/* Creating Main Method for Testing all method were created */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		/* Test Get all Location form Locations Table */
//       List<Location> locationList = LocationDAO.selectAllLocation();
//       for (Location location : locationList)
//            {
//                System.out.print(location.getLocationID() + " ");
//                System.out.print(location.getLocationName() + " ");
//                System.out.print(location.getLocationAllowance() + " ");
//                System.out.print(location.getFromTransferCount() + " ");
//                System.out.print(location.getToTransferCount() + "\n");
//                System.out.print(location.getNumberOfEmployees() + "\n");
//            }

		/* Test insert a Location record into Locations table */
//        System.out.print(LocationDAO.insertLocation(new Location("HongKong", 102.9)));
//        /*Test update a Location record fron Location table */
//         LocationDAO.updateLocation(new Location(6, "Moscow", 115.1));
//        /*Test delete a Location form Location table*/
//        LocationDAO.deleteLocation(7);
	}
}
