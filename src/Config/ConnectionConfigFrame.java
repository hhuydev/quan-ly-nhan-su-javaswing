/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConnectionConfigFrame.java
 *
 * Created on 06-05-2010, 14:18:59
 */

package Config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 *  
 */
public class ConnectionConfigFrame extends javax.swing.JFrame {

	/** Creates new form ConnectionConfigFrame */
	public ConnectionConfigFrame() {

		initComponents();
		setIconImage((new ImageIcon("wire_transfer.png")).getImage());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		setTitle("CONNECTION CONFIGURATOR");
		pnlConfig = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		tfServer = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		tfPort = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		tfUser = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		tfPassword = new javax.swing.JPasswordField();
		btnTestConnection = new javax.swing.JButton();
		btnSave = new javax.swing.JButton();
		btnClear = new javax.swing.JButton();
		pnlTop = new javax.swing.JPanel();
		lblWarning = new javax.swing.JLabel();

//		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnlConfig.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Connection Configuration",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Calibri", 1, 14))); // NOI18N

		jLabel1.setText("Server");

		jLabel2.setText("Port");

		jLabel3.setText("User");

		jLabel4.setText("Password");

		btnTestConnection
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connection-established.png"))); // NOI18N
		btnTestConnection.setText("Test Connection");
		btnTestConnection.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTestConnectionActionPerformed(evt);
			}
		});

		btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png"))); // NOI18N
		btnSave.setText("Save");
		btnSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSaveActionPerformed(evt);
			}
		});

		btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-clear.png"))); // NOI18N
		btnClear.setText("Clear");
		btnClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClearActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlConfigLayout = new javax.swing.GroupLayout(pnlConfig);
		pnlConfig.setLayout(pnlConfigLayout);
		pnlConfigLayout.setHorizontalGroup(pnlConfigLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlConfigLayout.createSequentialGroup().addContainerGap().addGroup(pnlConfigLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(pnlConfigLayout.createSequentialGroup().addComponent(btnTestConnection)
								.addGap(18, 18, 18).addComponent(btnSave))
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlConfigLayout.createSequentialGroup()
								.addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel4).addComponent(jLabel1).addComponent(jLabel3))
								.addGap(18, 18, 18)
								.addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(tfServer, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
										.addComponent(tfUser, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
										.addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 225,
												Short.MAX_VALUE))))
						.addGap(18, 18, 18)
						.addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnlConfigLayout.createSequentialGroup().addComponent(jLabel2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, 69,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(btnClear))
						.addGap(12, 12, 12)));

		pnlConfigLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { btnClear, btnSave, btnTestConnection });

		pnlConfigLayout.setVerticalGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlConfigLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(tfServer, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2).addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnSave).addComponent(btnTestConnection).addComponent(btnClear))
						.addContainerGap(19, Short.MAX_VALUE)));

		getContentPane().add(pnlConfig, java.awt.BorderLayout.CENTER);

		pnlTop.setMaximumSize(null);

		lblWarning.setFont(new java.awt.Font("Calibri", 1, 14));
		lblWarning.setForeground(new java.awt.Color(0, 51, 255));
		lblWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblWarning.setText(
				"<html>Please enter your appropiate configuration and click Save.You can also test new connection by click Test Connection button.<html>");
		lblWarning.setMinimumSize(new java.awt.Dimension(200, 200));
		lblWarning.setPreferredSize(new java.awt.Dimension(200, 200));

		javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
		pnlTop.setLayout(pnlTopLayout);
		pnlTopLayout.setHorizontalGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlTopLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblWarning, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
						.addContainerGap()));
		pnlTopLayout.setVerticalGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlTopLayout
						.createSequentialGroup().addContainerGap().addComponent(lblWarning,
								javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(16, Short.MAX_VALUE)));

		lblWarning.getAccessibleContext().setAccessibleName("");

		getContentPane().add(pnlTop, java.awt.BorderLayout.NORTH);

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	// Clear the form
	private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClearActionPerformed
		tfPassword.setText("");
		tfPort.setText("");
		tfUser.setText("");
		tfServer.setText("");
	}// GEN-LAST:event_btnClearActionPerformed

	private Connection getConnection() {
		Connection oConn = null;
		try {
			// Get JDBC
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create connection String
			StringBuilder connStr = new StringBuilder();
			connStr.append("jdbc:sqlserver://");
			connStr.append(tfServer.getText().trim() + ":");
			connStr.append(tfPort.getText().trim());
			connStr.append(";databaseName=QLNS_SK;user=");
			connStr.append(tfUser.getText().trim());
			connStr.append(
					";password=" + String.valueOf(tfPassword.getPassword(), 0, tfPassword.getPassword().length).trim());

			// get connection
			oConn = DriverManager.getConnection(connStr.toString());
			return oConn; // return a connection
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"Cannot connect to database. Please check your configuration that you have input.", "Connect Fail",
					JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null,
					"Cannot connect to database. Please check your configuration that you have input.", "Connect Fail",
					JOptionPane.ERROR_MESSAGE);
		}
		return oConn; // return null if go here
	}

	// Close connection in configurator
	private void closeConnection(Connection oConn) {
		if (oConn != null) {
			try {
				oConn.close();
			} catch (SQLException ex) {
				Logger.getLogger(ConnectionConfigFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	// Test connection
	private void btnTestConnectionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTestConnectionActionPerformed
		Connection oConn = getConnection();
		if (oConn != null) {
			JOptionPane.showMessageDialog(null,
					"Configuration is working now. You should click Save, close this window and try to login .",
					"Connect Successfully", JOptionPane.INFORMATION_MESSAGE);
		}
		closeConnection(oConn);
	}// GEN-LAST:event_btnTestConnectionActionPerformed

	// Save connection to file connection.data
	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed
		Connection oConn = getConnection();

		if (oConn != null) {
			BufferedWriter writer;
			try {
				String pass = tfPassword.getPassword().toString();
				StringBuilder data = new StringBuilder();
				data.append(tfServer.getText());
				data.append("\n");
				data.append(tfPort.getText());
				data.append("\n");
				data.append(tfUser.getText());
				data.append("\n");
				data.append(pass);

				// JOptionPane.showMessageDialog(null, data.toString());

				writer = new BufferedWriter(new FileWriter("connection.data"));
				writer.write(data.toString());
				writer.flush();
				writer.close();
				JOptionPane.showMessageDialog(null,
						"Your configuration is saved successfully. You should close this window and try to login .",
						"Save Configuration Successfully", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Cannot write data to \"connection.data\" file. Please try later.",
						"File write failed", JOptionPane.ERROR_MESSAGE);
			}
		}
	}// GEN-LAST:event_btnSaveActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ConnectionConfigFrame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnClear;
	private javax.swing.JButton btnSave;
	private javax.swing.JButton btnTestConnection;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel lblWarning;
	private javax.swing.JPanel pnlConfig;
	private javax.swing.JPanel pnlTop;
	private javax.swing.JPasswordField tfPassword;
	private javax.swing.JTextField tfPort;
	private javax.swing.JTextField tfServer;
	private javax.swing.JTextField tfUser;
	// End of variables declaration//GEN-END:variables

}