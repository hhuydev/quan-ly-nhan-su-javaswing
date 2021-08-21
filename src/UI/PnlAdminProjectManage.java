package UI;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Dao.ProjectDAO;
import Entity.Project;
import Util.ValidateFormTools;

public class PnlAdminProjectManage extends javax.swing.JPanel {

	/** Creates new form ProjectUIPanel */
	public PnlAdminProjectManage() {
		initComponents();
		tblModel = new DefaultTableModel();

		loadTableData();
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

		pnlTop = new javax.swing.JPanel();
		pnlAddNew = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		tfAddNewProjectID = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		tfAddNewProjectName = new javax.swing.JTextField();
		btnAddNew = new javax.swing.JButton();
		pnlEdit = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		tfEditProjectID = new javax.swing.JTextField();
		tfEditProjectName = new javax.swing.JTextField();
		btnUpdate = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		pnlBottom = new javax.swing.JPanel();
		sclPaneData = new javax.swing.JScrollPane();
		sclPaneData1 = new javax.swing.JScrollPane();
		tblData = new org.jdesktop.swingx.JXTable();

		setMaximumSize(new java.awt.Dimension(791, 655));
		setMinimumSize(new java.awt.Dimension(791, 655));
		setPreferredSize(new java.awt.Dimension(600, 600));
		setLayout(new java.awt.BorderLayout());

		pnlTop.setPreferredSize(new java.awt.Dimension(671, 160));
		pnlTop.setRequestFocusEnabled(false);
		pnlTop.setLayout(new java.awt.BorderLayout());

		pnlAddNew.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Project",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Calibri", 1, 12))); // NOI18N
		pnlAddNew.setPreferredSize(new java.awt.Dimension(671, 80));

		jLabel1.setText("Project ID:");

		tfAddNewProjectID.setEditable(false);
		tfAddNewProjectID.setEnabled(false);

		jLabel2.setText("Project Name:");

		btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_add.png"))); // NOI18N
		btnAddNew.setText("Add");
		btnAddNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddNewActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlAddNewLayout = new javax.swing.GroupLayout(pnlAddNew);
		pnlAddNew.setLayout(pnlAddNewLayout);
		pnlAddNewLayout
				.setHorizontalGroup(pnlAddNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlAddNewLayout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(tfAddNewProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(tfAddNewProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(28, 28, 28).addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(178, Short.MAX_VALUE)));
		pnlAddNewLayout
				.setVerticalGroup(pnlAddNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlAddNewLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(pnlAddNewLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
								.addComponent(tfAddNewProjectID, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)
								.addComponent(tfAddNewProjectName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddNew)).addContainerGap(18, Short.MAX_VALUE)));

		pnlTop.add(pnlAddNew, java.awt.BorderLayout.NORTH);

		pnlEdit.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Project",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Calibri", 1, 15))); // NOI18N
		pnlEdit.setPreferredSize(new java.awt.Dimension(671, 80));

		jLabel4.setText("Project ID:");

		jLabel3.setText("Project Name:");

		tfEditProjectID.setEditable(false);
		tfEditProjectID.setEnabled(false);

		btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png"))); // NOI18N
		btnUpdate.setText("Update");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});

		btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
		btnDelete.setText("Delete");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
		pnlEdit.setLayout(pnlEditLayout);
		pnlEditLayout
				.setHorizontalGroup(
						pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnlEditLayout.createSequentialGroup().addContainerGap()
										.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(tfEditProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(tfEditProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(28, 28, 28)
										.addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(72, Short.MAX_VALUE)));
		pnlEditLayout
				.setVerticalGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlEditLayout.createSequentialGroup().addContainerGap().addGroup(pnlEditLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
								.addComponent(tfEditProjectID, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3)
								.addComponent(tfEditProjectName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate).addComponent(btnDelete))
								.addContainerGap(31, Short.MAX_VALUE)));

		pnlTop.add(pnlEdit, java.awt.BorderLayout.CENTER);

		add(pnlTop, java.awt.BorderLayout.NORTH);

		pnlBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Project",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Calibri", 1, 12))); // NOI18N
		pnlBottom.setLayout(new java.awt.BorderLayout());

		sclPaneData.setBorder(null);

		sclPaneData1.setBorder(null);

		tblData.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		tblData.setFont(new java.awt.Font("Calibri", 1, 14));
		tblData.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblDataMouseClicked(evt);
			}
		});
		tblData.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tblDataKeyReleased(evt);
			}
		});
		sclPaneData1.setViewportView(tblData);

		sclPaneData.setViewportView(sclPaneData1);

		pnlBottom.add(sclPaneData, java.awt.BorderLayout.CENTER);

		add(pnlBottom, java.awt.BorderLayout.CENTER);
	}// </editor-fold>//GEN-END:initComponents

	private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddNewActionPerformed
		if (validateAddNew()) {
			Project proj = new Project(tfAddNewProjectName.getText());
			try {
				ProjectDAO.insertProject(proj);
				tfAddNewProjectName.setText("");
				loadTableData();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Cannot insert new Project in database!", "Error",
						JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(PnlAdminProjectManage.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "Cannot insert new Project in database!", "Error",
						JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(PnlAdminProjectManage.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}// GEN-LAST:event_btnAddNewActionPerformed

	private void tblDataKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_tblDataKeyReleased
		loadEditData();
	}// GEN-LAST:event_tblDataKeyReleased

	private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblDataMouseClicked
		loadEditData();
	}// GEN-LAST:event_tblDataMouseClicked

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
		if (tblData.getSelectedRow() != -1) {
			if (validateUpdate()) {
				int rowI = tblData.getSelectedRow();
				Project proj = projectList.get(rowI);
				proj.setProjectName(tfEditProjectName.getText());
				try {
					ProjectDAO.updateProject(proj);
					tfEditProjectID.setText("");
					tfEditProjectName.setText("");
					loadTableData();
				} catch (SQLException ex) {
					Logger.getLogger(PnlAdminProjectManage.class.getName()).log(Level.SEVERE, null, ex);
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(PnlAdminProjectManage.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "You must select a row!", "No row selected",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}// GEN-LAST:event_btnUpdateActionPerformed

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
		System.out.println(tblData.getSelectedRow());
		if (tblData.getSelectedRow() != -1) {
			if (validateDelete()) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to delete this project?", "Confirm delete",
						JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					try {
						ProjectDAO.deleteProject(Integer.parseInt(tfEditProjectID.getText()));
						tfEditProjectID.setText("");
						tfEditProjectName.setText("");
						loadTableData();
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "Delete failed!", "Error", JOptionPane.ERROR_MESSAGE);
					} catch (ClassNotFoundException ex) {
						JOptionPane.showMessageDialog(null, "Delete failed!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		}
	}// GEN-LAST:event_btnDeleteActionPerformed

	private boolean validateAddNew()// Validate to add new Project
	{
		StringBuilder msg = new StringBuilder();
		if (!ValidateFormTools.isFilledTextField(tfAddNewProjectName, true)) {
			msg.append("\n - Project's Name cannot be blank!");
		}

		if (msg.toString().compareTo("") != 0) {
			JOptionPane.showMessageDialog(null, "Has an error " + msg, "Can not add", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	private boolean validateDelete() // Ensure there are no Transfer or Employee link to this Project
	{
		int rowI = tblData.getSelectedRow();
		Project proj = projectList.get(rowI);

		if (proj.getFromTransferCount() == 0 && proj.getToTransferCount() == 0 && proj.getNumberOfEmployees() == 0) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "You can not delete this Project! Epmloyee working in there!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;

		}
	}

	private boolean validateUpdate() // Validate to edit an Project
	{
		StringBuilder msg = new StringBuilder();
		if (!ValidateFormTools.isFilledTextField(tfEditProjectName, true)) {
			msg.append("\n - Project's Name can not be blank!");
		}

		if (msg.toString().compareTo("") != 0) {
			JOptionPane.showMessageDialog(null, "Has an error " + msg, "Error edit", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	private void loadEditData()// Load data to edit form, when user click or press up/down key on table
	{
		if (tblData.getSelectedRow() != -1) {
			int rowI = tblData.getSelectedRow();
			Project proj = projectList.get(rowI);
			tfEditProjectID.setText(String.valueOf(proj.getProjectID()));
			tfEditProjectName.setText(String.valueOf(proj.getProjectName()));
		}
	}

	private void loadTableData()// Load data from database to table
	{
		try {
			projectList = ProjectDAO.selectAllProject();
			tblModel = new DefaultTableModel();
			tblModel.addColumn("Project ID");
			tblModel.addColumn("Project Name");
			tblModel.addColumn("Number Employee");
			for (Project project : projectList) {
				Vector<String> row = new Vector<String>();
				row.addElement(String.valueOf(project.getProjectID()));
				row.addElement(project.getProjectName());
				row.addElement(String.valueOf(project.getNumberOfEmployees()));
				tblModel.addRow(row);
			}
			tblData.setModel(tblModel);
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Can not load Project's data from database!", "Error",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Can not load Project's data from database!", "Error",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}

	}

	DefaultTableModel tblModel;
	List<Project> projectList;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAddNew;
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnUpdate;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel pnlAddNew;
	private javax.swing.JPanel pnlBottom;
	private javax.swing.JPanel pnlEdit;
	private javax.swing.JPanel pnlTop;
	private javax.swing.JScrollPane sclPaneData;
	private javax.swing.JScrollPane sclPaneData1;
	private org.jdesktop.swingx.JXTable tblData;
	private javax.swing.JTextField tfAddNewProjectID;
	private javax.swing.JTextField tfAddNewProjectName;
	private javax.swing.JTextField tfEditProjectID;
	private javax.swing.JTextField tfEditProjectName;
	// End of variables declaration//GEN-END:variables
}
