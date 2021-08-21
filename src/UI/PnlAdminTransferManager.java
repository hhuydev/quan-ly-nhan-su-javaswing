package UI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.TransferDAO;
import Entity.Department;
import Entity.Employee;
import Entity.Location;
import Entity.Project;
import Entity.Transfer;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class PnlAdminTransferManager extends JPanel implements ActionListener, MouseListener {
	private JTable table;
	private DefaultTableModel de;

	/**
	 * Create the panel.
	 */
	public PnlAdminTransferManager() {
		setLayout(null);

		JButton btnGetAllTransfer = new JButton("Get All Transfer");
		btnGetAllTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferDAO transferDAO = new TransferDAO();
				List<Transfer> listTransfers = transferDAO.getAllListTransfers();
				for (Transfer transfer : listTransfers) {
					String[] row = { String.valueOf(transfer.getTransferID()).trim(),
							String.valueOf(transfer.getEmployee().getEmployeeID()).trim(),
							Boolean.valueOf(transfer.isApproved()).toString(), transfer.getReason().trim(),
							String.valueOf(transfer.getFromProject().getProjectID()).trim(),
							String.valueOf(transfer.getToProject().getProjectID()).trim(),
							String.valueOf(transfer.getFromDepartment().getDepartmentID()).trim(),
							String.valueOf(transfer.getToDepartment().getDepartmentID()).trim(),
							String.valueOf(transfer.getFromLocation().getLocationID()).trim(),
							String.valueOf(transfer.getToLocation().getLocationID()).trim(),
							transfer.getTransferRelievingDate().trim(), transfer.getTransferJoiningDate().trim(),
							String.valueOf(transfer.getTotalAllowance()).trim() };
					de.addRow(row);
				}
				table.setModel(de);
			}
		});
		btnGetAllTransfer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGetAllTransfer.setBounds(102, 334, 144, 31);
		add(btnGetAllTransfer);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferDAO transferDAO = new TransferDAO();
				int row = table.getSelectedRow();
				if (row >= 0) {
					int transferID = Integer.parseInt((String) table.getValueAt(row, 0));
					System.out.println(transferID);
					try {

						if (transferDAO.deleteTransfer(transferID)) {
							transferDAO.deleteTransfer(transferID);
							de.removeRow(row);
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(333, 334, 126, 31);
		add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 114, 705, 184);
		add(scrollPane);

		table = new JTable();
		de = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Employee ID", "IsApproved", "Reason", "FromProjectID", "ToProjectID",
						"FromDepartmentID", "ToDepartmentID", "FromLocationID", "ToLocationID", "TransferRelievingDate",
						"TransferJoiningDate", "TotalAllowance" });
		table.setModel(de);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setEnabled(false);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferDAO transferDAO = new TransferDAO();
				int row = table.getSelectedRow();
				if (row >= 0) {
					int transferID = Integer.parseInt((String) table.getValueAt(row, 0));
					System.out.println(transferID);

					try {
						Employee employee = new Employee(Integer.parseInt((String) table.getValueAt(row, 1)));
						boolean isApproved = Boolean.parseBoolean((String) table.getValueAt(row, 2));
						String reason = String.valueOf(table.getValueAt(row, 3));
						Project fromProject = new Project(Integer.parseInt((String) table.getValueAt(row, 4)));
						Project toProject = new Project(Integer.parseInt((String) table.getValueAt(row, 5)));
						Department fromDepartment = new Department(Integer.parseInt((String) table.getValueAt(row, 6)));
						Department toDepartment = new Department(Integer.parseInt((String) table.getValueAt(row, 7)));
						Location fromLocation = new Location(Integer.parseInt((String) table.getValueAt(row, 8)));
						Location toLocation = new Location(Integer.parseInt((String) table.getValueAt(row, 9)));
						String transferRelievingDate = String.valueOf(table.getValueAt(row, 10));
						String transferJoingDate = String.valueOf(table.getValueAt(row, 11));
						double totalAllowance = Double.parseDouble((String) table.getValueAt(row, 12));
						Transfer transfer = new Transfer(transferID, employee, isApproved, reason, fromProject,
								toProject, fromDepartment, toDepartment, fromLocation, toLocation,
								transferRelievingDate, transferJoingDate, totalAllowance);

						if (transferDAO.updateTransfer(transfer)) {
							table.setValueAt(employee.getEmployeeID(), row, 1);
							table.setValueAt(isApproved, row, 2);
							table.setValueAt(reason, row, 3);
							table.setValueAt(fromProject.getProjectID(), row, 4);
							table.setValueAt(toProject.getProjectID(), row, 5);
							table.setValueAt(fromDepartment.getDepartmentID(), row, 6);
							table.setValueAt(toDepartment.getDepartmentID(), row, 7);
							table.setValueAt(fromLocation.getLocationID(), row, 8);
							table.setValueAt(toLocation.getLocationID(), row, 9);
							table.setValueAt(transferRelievingDate, row, 10);
							table.setValueAt(transferJoingDate, row, 11);
							table.setValueAt(totalAllowance, row, 12);
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Has an error! Cannot transfer!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Has an error! Cannot transfer!");
					}
				}
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirm.setBounds(545, 334, 135, 30);
		add(btnConfirm);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
