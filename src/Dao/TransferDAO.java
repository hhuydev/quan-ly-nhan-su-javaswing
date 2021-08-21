package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Config.ConnectionConfig;
import Entity.Department;
import Entity.Employee;
import Entity.Location;
import Entity.Project;
import Entity.Transfer;

public class TransferDAO {
	private ArrayList<Transfer> listTransfers = null;

	public TransferDAO() {
		listTransfers = new ArrayList<Transfer>();
	}

	public ArrayList<Transfer> getAllListTransfers() {
		try {
			Connection connection = ConnectionConfig.getConnection();
			String sql = "select * from Transfers";
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			while (rs.next()) {

				int id = rs.getInt(1);
				Employee emp = new Employee(rs.getInt(2));
				boolean isApproved = rs.getBoolean(3);
				String reason = rs.getString(4);
				Project fromProject = new Project(rs.getInt(5));
				Project toProject = new Project(rs.getInt(6));
				Department fromDepartment = new Department(rs.getInt(7));
				Department toDepartment = new Department(rs.getInt(8));
				Location fromLocation = new Location(rs.getInt(9));
				Location toLocation = new Location(rs.getInt(10));
				String relievingDate = rs.getString(11);
				String joiningDate = rs.getString(12);
				float totalAllowance = rs.getFloat(13);

//				Transfer transfer = new Transfer();
//				transfer.setTransferID(rs.getInt(1));
//				transfer.getEmployee().setEmployeeID(rs.getInt(2));
//				transfer.setApproved(rs.getBoolean(3));
//				transfer.setReason(rs.getString(4));
//				transfer.getFromProject().setProjectID(rs.getInt(5));
//				transfer.getToProject().setProjectID(rs.getInt(6));
//				transfer.getFromDepartment().setDepartmentID(rs.getInt(7));
//				transfer.getToDepartment().setDepartmentID(rs.getInt(8));
//				transfer.getFromLocation().setLocationID(rs.getInt(9));
//				transfer.getToLocation().setLocationID(rs.getInt(10));
//				transfer.setTransferRelievingDate(rs.getString(11));
//				transfer.setTransferJoiningDate(rs.getString(12));
//				transfer.setTotalAllowance(rs.getDouble(13));
//				listTransfers.add(transfer);

				Transfer transfer = new Transfer(id, emp, isApproved, reason, fromProject, toProject, fromDepartment,
						toDepartment, fromLocation, toLocation, relievingDate, joiningDate, totalAllowance);
				listTransfers.add(transfer);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listTransfers;
	}

	public Transfer getTransfersByID(int transferID) {
		Transfer transfer = null;
		try {
			Connection connection = ConnectionConfig.getConnection();
			String sql = "select * from Transfers where [TransferID] = " + transferID;
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			while (rs.next()) {

				int id = rs.getInt(1);
				Employee emp = new Employee(rs.getInt(2));
				boolean isApproved = rs.getBoolean(3);
				String reason = rs.getString(4);
				Project fromProject = new Project(rs.getInt(5));
				Project toProject = new Project(rs.getInt(6));
				Department fromDepartment = new Department(rs.getInt(7));
				Department toDepartment = new Department(rs.getInt(8));
				Location fromLocation = new Location(rs.getInt(9));
				Location toLocation = new Location(rs.getInt(10));
				String relievingDate = rs.getString(11);
				String joiningDate = rs.getString(12);
				float totalAllowance = rs.getFloat(13);

				transfer = new Transfer(id, emp, isApproved, reason, fromProject, toProject, fromDepartment,
						toDepartment, fromLocation, toLocation, relievingDate, joiningDate, totalAllowance);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return transfer;
	}

	public boolean deleteTransfer(int transferID) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement pStmt = null;
		int n = 0;
		try {
			pStmt = conn.prepareStatement("DELETE FROM Transfers WHERE TransferID = ?");
			pStmt.setInt(1, transferID);
			n = pStmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		pStmt.executeUpdate();
//		EmpConnection.closePreparedStatement(pStmt);
//		EmpConnection.closeConnection(conn);
		return n > 0;
	}

	public boolean insertTransfer(Transfer transfer) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionConfig.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("insert into Transfers values (?,?,?,?,?,?,?,?,?,?,?,?)");
			stm.setInt(1, transfer.getEmployee().getEmployeeID());
			stm.setBoolean(2, transfer.isApproved());
			stm.setNString(3, transfer.getReason());
			stm.setInt(4, transfer.getFromProject().getProjectID());
			stm.setInt(5, transfer.getToProject().getProjectID());
			stm.setInt(6, transfer.getFromDepartment().getDepartmentID());
			stm.setInt(7, transfer.getToDepartment().getDepartmentID());
			stm.setInt(8, transfer.getFromLocation().getLocationID());
			stm.setInt(9, transfer.getToLocation().getLocationID());
			stm.setString(10, transfer.getTransferRelievingDate());
			stm.setString(11, transfer.getTransferJoiningDate());
			stm.setDouble(12, transfer.getTotalAllowance());
			n = stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n > 0;
	}

	public boolean updateTransfer(Transfer transfer) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionConfig.getConnection();
		StringBuilder query = new StringBuilder();
		int n = 0;
		try {
			query.append("UPDATE [Transfers] SET");
			query.append(
					" [EmployeeID] = ?, set [IsApproved]]= ?, set [Reason] = ?, set [FromProjectID] = ?, set [ToProjectID] = ?,");
			query.append(" set [FromDepartmentID] = ?, set [ToDepartmentID] = ?, set [FromLocationID] = ?,");
			query.append(" set [ToLocationID] = ?, set [TransferRelievingDate] = ?, set [TransferJoiningDate] = ?,");
			query.append(" set [TotalAllowance] = ?");
			query.append(" WHERE [TransferID] = ?");

			PreparedStatement pStmt = conn.prepareStatement(query.toString());
			pStmt.setInt(1, transfer.getEmployee().getEmployeeID());
			pStmt.setBoolean(2, transfer.isApproved());
			pStmt.setNString(3, transfer.getReason());
			pStmt.setInt(4, transfer.getFromProject().getProjectID());
			pStmt.setInt(5, transfer.getToProject().getProjectID());
			pStmt.setInt(6, transfer.getFromDepartment().getDepartmentID());
			pStmt.setInt(7, transfer.getToDepartment().getDepartmentID());
			pStmt.setInt(8, transfer.getFromLocation().getLocationID());
			pStmt.setInt(9, transfer.getToLocation().getLocationID());
			pStmt.setString(10, transfer.getTransferRelievingDate());
			pStmt.setString(11, transfer.getTransferJoiningDate());
			pStmt.setDouble(12, transfer.getTotalAllowance());
			pStmt.setInt(13, transfer.getTransferID());
			n = pStmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Has an error! Cannot transfer!");
		}

		return n > 0;
//		EmpConnection.closePreparedStatement(pStmt);
//		EmpConnection.closeConnection(conn);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Transfer transfer = new Transfer(new Employee().setEmployeeID(99);, true, "thử thách mới", 1, 2, 2, 1, 2, 1, "2020-5-5", "2020-6-12",
//				3000);
//		System.out.println(new TransferDAO().insertTransfer());
		System.out.println(new TransferDAO().getTransfersByID(10));
//		new TransferDAO().updateTransfer(new TransferDAO().getTransfersByID(10));
	}
}
