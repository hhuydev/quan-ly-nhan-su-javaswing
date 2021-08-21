/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class ConnectionConfig {

	private static String readConnectionString() {
		String str = "";
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("connection.data"));
			String server = reader.readLine();
			String port = reader.readLine();
			String user = reader.readLine();
			reader.close();

			StringBuilder connStr = new StringBuilder();
			connStr.append("jdbc:sqlserver://");
			connStr.append(server);
			connStr.append(":");
			connStr.append(port);
			connStr.append(";databaseName=QLNS_SK;user=sa");

			connStr.append(";password=123456789aa");

			str = connStr.toString();
		} catch (IOException ex) {
			Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
		}

		return str;
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection oConn = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		oConn = DriverManager.getConnection(readConnectionString());
		// oConn =
		// DriverManager.getConnection("jdbc:sqlserver://abcxzy:1659;databaseName=EmployeeTransferManagement2010;user=sa;password=1234567");
		return oConn;
	}

	public static void closeConnection(Connection oConn) throws SQLException {
		if (oConn != null) {
			oConn.close();
		}
	}

	public static boolean testConnection() {
		Connection oConn = null;
		try {
			oConn = ConnectionConfig.getConnection();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (oConn != null) {
			try {
				ConnectionConfig.closeConnection(oConn);
				return true;
			} catch (SQLException ex) {
				Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return false;
	}

	public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
	}

	public static void closeCallableStatement(CallableStatement callableStatement) throws SQLException {
		if (callableStatement != null) {
			callableStatement.close();
		}
	}

	public static void main(String[] args) {
//        try {
//            Connection oConn = getConnection();
//            if(oConn != null)
//            {
//                System.out.println("Connected");
//            }
//            closeConnection(oConn);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } catch (ClassNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
		System.out.println(readConnectionString());
		System.out.println(testConnection());
	}
}
