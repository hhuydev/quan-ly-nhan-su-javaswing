package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Dao.EmployeeDAO;
import Entity.Employee;
import Test.Main;

public class MasterLayout extends javax.swing.JFrame {

	private Employee curEmp = null;

	/** Tạo mới from MainFrame */
	public MasterLayout(Employee curEmp) {
		this.curEmp = curEmp;

		initComponents();
		setFrameStyle();

		if (curEmp.isSystemAdmin()) {
			setAdminLayout();
		} // Nếu người dùng là Admin
		else {
			setUserLayout();
		} // Người dùng bình thường

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		scrlPaneLeftUser = new javax.swing.JScrollPane();
		pnlLeftEmp = new javax.swing.JPanel();
		btnEmpMyProfile = new javax.swing.JButton();
		btnLogout1 = new javax.swing.JButton();
		btnEmpTransferManage = new javax.swing.JButton();
		btnExit = new javax.swing.JButton();
		btnSeachChart = new javax.swing.JButton();
		btnStatisticChart = new javax.swing.JButton();
		btnRequestTransfer = new javax.swing.JButton();
		btnHomeEmp = new javax.swing.JButton();
		btnDepartmentList = new javax.swing.JButton();
		btnProjectList = new javax.swing.JButton();
		btnLocationList = new javax.swing.JButton();
		spltPane = new javax.swing.JSplitPane();
		scrlpaneLeftAdmin = new javax.swing.JScrollPane();
		pnlLeft = new javax.swing.JPanel();
		btnProjectManage = new javax.swing.JButton();
		btnDepartmentManage = new javax.swing.JButton();
		btnLocationManage = new javax.swing.JButton();
		btnEmployeeManage = new javax.swing.JButton();
		pnlHome = new javax.swing.JPanel();
		menuBarMain = new javax.swing.JMenuBar();
		menuFile = new javax.swing.JMenu();
		mnuiLogout = new javax.swing.JMenuItem();
		mnuiExit = new javax.swing.JMenuItem();

		scrlPaneLeftUser.setMaximumSize(null);
		scrlPaneLeftUser.setMinimumSize(null);
		scrlPaneLeftUser.setPreferredSize(new java.awt.Dimension(225, 235));

		pnlLeftEmp.setMaximumSize(new java.awt.Dimension(185, 539));
		pnlLeftEmp.setMinimumSize(new java.awt.Dimension(185, 539));
		pnlLeftEmp.setPreferredSize(new java.awt.Dimension(185, 539));

//		btnEmpMyProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/project_open.png"))); // NOI18N
//		btnEmpMyProfile.setText("My Profile");
//		btnEmpMyProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//		btnEmpMyProfile.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnEmpMyProfileActionPerformed(evt);
//			}
//		});

		btnLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
		btnLogout1.setText("Logout");
		btnLogout1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnLogout1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLogout1ActionPerformed(evt);
			}
		});

//		btnEmpTransferManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Transfermanage.png"))); // NOI18N
//		btnEmpTransferManage.setText("Transfers Manage");
//		btnEmpTransferManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//		btnEmpTransferManage.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnEmpTransferManageActionPerformed(evt);
//			}
//		});

//        btnRequestTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transferNew.png"))); // NOI18N
//        btnRequestTransfer.setText("Request New Transfer");
//        btnRequestTransfer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//        btnRequestTransfer.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnRequestTransferActionPerformed(evt);
//            }
//        });

//		btnHomeEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
//		btnHomeEmp.setText("Home");
//		btnHomeEmp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//		btnHomeEmp.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnHomeEmpActionPerformed(evt);
//			}
//		});

		btnDepartmentList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Department.png"))); // NOI18N
		btnDepartmentList.setText("Departments List");
		btnDepartmentList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnDepartmentList.setMaximumSize(new java.awt.Dimension(101, 41));
		btnDepartmentList.setMinimumSize(new java.awt.Dimension(101, 41));
		btnDepartmentList.setPreferredSize(new java.awt.Dimension(79, 25));
		btnDepartmentList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDepartmentListActionPerformed(evt);
			}
		});

//		btnProjectList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/project_open.png"))); // NOI18N
//		btnProjectList.setText("Projects List");
//		btnProjectList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//		btnProjectList.setMaximumSize(new java.awt.Dimension(101, 41));
//		btnProjectList.setMinimumSize(new java.awt.Dimension(101, 41));
//		btnProjectList.setPreferredSize(new java.awt.Dimension(79, 25));
//		btnProjectList.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnProjectListActionPerformed(evt);
//			}
//		});

		btnLocationList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Location.png"))); // NOI18N
		btnLocationList.setText("Locations List");
		btnLocationList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnLocationList.setMaximumSize(new java.awt.Dimension(101, 41));
		btnLocationList.setMinimumSize(new java.awt.Dimension(101, 41));
		btnLocationList.setPreferredSize(new java.awt.Dimension(79, 25));
		btnLocationList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLocationListActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlLeftEmpLayout = new javax.swing.GroupLayout(pnlLeftEmp);
		pnlLeftEmp.setLayout(pnlLeftEmpLayout);
		pnlLeftEmpLayout.setHorizontalGroup(pnlLeftEmpLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlLeftEmpLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlLeftEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//								.addComponent(btnHomeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
//										javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(btnRequestTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(btnEmpTransferManage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										pnlLeftEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//										.addComponent(btnProjectList, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
//												javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnDepartmentList, javax.swing.GroupLayout.PREFERRED_SIZE,
														180, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnLocationList,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 180,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(pnlLeftEmpLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlLeftEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//								.addComponent(btnEmpMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
//										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLogout1, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(33, Short.MAX_VALUE)));

		pnlLeftEmpLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { btnDepartmentList, btnLocationList, btnLogout1 });

		pnlLeftEmpLayout
				.setVerticalGroup(pnlLeftEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlLeftEmpLayout.createSequentialGroup().addContainerGap()
//								.addComponent(btnHomeEmp)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
//                .addComponent(btnRequestTransfer)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
//                .addComponent(btnEmpTransferManage)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//								.addComponent(btnProjectList, javax.swing.GroupLayout.PREFERRED_SIZE,
//										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
								.addComponent(btnDepartmentList, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
								.addComponent(btnLocationList, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
//								.addComponent(btnEmpMyProfile)
//								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnLogout1).addContainerGap(258, Short.MAX_VALUE)));

		pnlLeftEmpLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { btnDepartmentList, btnLocationList, btnLogout1 });

		scrlPaneLeftUser.setViewportView(pnlLeftEmp);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Employee Transfer Management");
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		spltPane.setDividerLocation(220);
		spltPane.setDividerSize(0);
		spltPane.setEnabled(false);
		spltPane.setMaximumSize(null);
		spltPane.setPreferredSize(new java.awt.Dimension(1024, 543));

		scrlpaneLeftAdmin.setMaximumSize(null);
		scrlpaneLeftAdmin.setMinimumSize(null);
		scrlpaneLeftAdmin.setPreferredSize(new java.awt.Dimension(219, 541));

		pnlLeft.setMaximumSize(new java.awt.Dimension(185, 539));
		pnlLeft.setMinimumSize(new java.awt.Dimension(185, 539));
		pnlLeft.setPreferredSize(new java.awt.Dimension(185, 539));

		btnProjectManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/project_open.png"))); // NOI18N
		btnProjectManage.setText("Manage Project");
		btnProjectManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnProjectManage.setMaximumSize(new java.awt.Dimension(101, 41));
		btnProjectManage.setMinimumSize(new java.awt.Dimension(101, 41));
		btnProjectManage.setPreferredSize(new java.awt.Dimension(79, 25));
		btnProjectManage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnProjectManageActionPerformed(evt);
			}
		});

		btnDepartmentManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Department.png"))); // NOI18N
		btnDepartmentManage.setText("Manage Department");
		btnDepartmentManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnDepartmentManage.setMaximumSize(new java.awt.Dimension(101, 41));
		btnDepartmentManage.setMinimumSize(new java.awt.Dimension(101, 41));
		btnDepartmentManage.setPreferredSize(new java.awt.Dimension(79, 25));
		btnDepartmentManage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDepartmentManageActionPerformed(evt);
			}
		});

		btnEmpTransferManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Transfermanage.png"))); // NOI18N
		btnEmpTransferManage.setText("Manager Transfer");
		btnEmpTransferManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnEmpTransferManage.setMaximumSize(new java.awt.Dimension(101, 41));
		btnEmpTransferManage.setMinimumSize(new java.awt.Dimension(101, 41));
		btnEmpTransferManage.setPreferredSize(new java.awt.Dimension(79, 25));
		btnEmpTransferManage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEmpTransferManageActionPerformed(evt);
			}
		});

		btnLocationManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Location.png"))); // NOI18N
		btnLocationManage.setText("Manager Location");
		btnLocationManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnLocationManage.setMaximumSize(new java.awt.Dimension(101, 41));
		btnLocationManage.setMinimumSize(new java.awt.Dimension(101, 41));
		btnLocationManage.setPreferredSize(new java.awt.Dimension(79, 25));
		btnLocationManage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLocationManageActionPerformed(evt);
			}
		});

		btnEmployeeManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee.png"))); // NOI18N
		btnEmployeeManage.setText("Manager Employee");
		btnEmployeeManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnEmployeeManage.setMaximumSize(new java.awt.Dimension(101, 41));
		btnEmployeeManage.setMinimumSize(new java.awt.Dimension(101, 41));
		btnEmployeeManage.setPreferredSize(new java.awt.Dimension(79, 25));
		btnEmployeeManage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEmployeeManageActionPerformed(evt);
			}
		});

		btnSeachChart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pie-chart.png"))); // NOI18N
		btnSeachChart.setText("Employee in Project");
		btnSeachChart.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnSeachChart.setMaximumSize(new java.awt.Dimension(101, 41));
		btnSeachChart.setMinimumSize(new java.awt.Dimension(101, 41));
		btnSeachChart.setPreferredSize(new java.awt.Dimension(79, 25));
		btnSeachChart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnSeachCharttActionPerformed(evt);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnStatisticChart
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pie-chart.png"))); // NOI18N
		btnStatisticChart.setText("Employee in Department");
		btnStatisticChart.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnStatisticChart.setMaximumSize(new java.awt.Dimension(101, 41));
		btnStatisticChart.setMinimumSize(new java.awt.Dimension(101, 41));
		btnStatisticChart.setPreferredSize(new java.awt.Dimension(79, 25));
		btnStatisticChart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnStatisticChartActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
		btnExit.setText("Exit");
		btnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		btnExit.setMaximumSize(new java.awt.Dimension(101, 41));
		btnExit.setMinimumSize(new java.awt.Dimension(101, 41));
		btnExit.setPreferredSize(new java.awt.Dimension(79, 25));
		btnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
		pnlLeft.setLayout(pnlLeftLayout);
		pnlLeftLayout.setHorizontalGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlLeftLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnProjectManage, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDepartmentManage, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLocationManage, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEmployeeManage, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEmpTransferManage, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSeachChart, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnStatisticChart, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(27, Short.MAX_VALUE)));
		pnlLeftLayout.setVerticalGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlLeftLayout.createSequentialGroup().addGap(85, 85, 85)
						.addComponent(btnEmployeeManage, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGap(18, 18, 18)
//						.addGap(18, 18, 18)
						.addComponent(btnProjectManage, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
						.addComponent(btnDepartmentManage, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
						.addComponent(btnLocationManage, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
						.addComponent(btnEmpTransferManage, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
						.addComponent(btnSeachChart, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
						.addComponent(btnStatisticChart, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
						.addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(833, Short.MAX_VALUE)

				));

		pnlLeftLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btnDepartmentManage,
				btnEmployeeManage, btnLocationManage, btnProjectManage, btnEmpTransferManage });

		scrlpaneLeftAdmin.setViewportView(pnlLeft);

		spltPane.setLeftComponent(scrlpaneLeftAdmin);

		pnlHome.setMaximumSize(null);
		pnlHome.setPreferredSize(new java.awt.Dimension(50, 50));

		javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
		pnlHome.setLayout(pnlHomeLayout);
		pnlHomeLayout.setHorizontalGroup(pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 803, Short.MAX_VALUE));
		pnlHomeLayout.setVerticalGroup(pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 1055, Short.MAX_VALUE));

		spltPane.setRightComponent(pnlHome);

		getContentPane().add(spltPane, java.awt.BorderLayout.CENTER);

		menuFile.setText("File");

		mnuiLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
		mnuiLogout.setText("Logout");
		mnuiLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnuiLogoutActionPerformed(evt);
			}
		});
		menuFile.add(mnuiLogout);

		mnuiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
		mnuiExit.setText("Exit Application");
		mnuiExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnuiExitActionPerformed(evt);
			}
		});
		menuFile.add(mnuiExit);

		menuBarMain.add(menuFile);

		setJMenuBar(menuBarMain);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	protected void btnStatisticChartActionPerformed(ActionEvent evt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		dataset.setValue(0, "Employees", "Department 1");
		List<Employee> EmployeeListByDepartment1 = new EmployeeDAO().getEmployeeByDepartment(1);
		List<Employee> EmployeeListByDepartment2 = new EmployeeDAO().getEmployeeByDepartment(2);
		List<Employee> EmployeeListByDepartment3 = new EmployeeDAO().getEmployeeByDepartment(5);
		dataset.setValue(EmployeeListByDepartment1.size(), "Number Of Employee", "Accounting");
		dataset.setValue(EmployeeListByDepartment2.size(), "Number Of Employee", "Administration");
		dataset.setValue(EmployeeListByDepartment3.size(), "Number Of Employee", "Manager");
		JFreeChart chart = ChartFactory.createBarChart("Number Of Employees", "Department's Name", "Employees", dataset,
				PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeMinorGridlinePaint(Color.BLACK);
		ChartFrame frame = new ChartFrame("Bar Chart Number Of Employees", chart);
		setTitle("Bar Chart");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	protected void btnSeachCharttActionPerformed(ActionEvent evt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		PnlAdminChart pnlAdminChart = new PnlAdminChart();
//		spltPane.setRightComponent(pnlAdminChart);

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		List<Employee> EmployeeListByProject1 = new EmployeeDAO().getEmployeeByProject(1);
		List<Employee> EmployeeListByProject2 = new EmployeeDAO().getEmployeeByProject(2);
		List<Employee> EmployeeListByProject3 = new EmployeeDAO().getEmployeeByProject(3);
		List<Employee> EmployeeListByProject4 = new EmployeeDAO().getEmployeeByProject(4);
		List<Employee> EmployeeListByProject5 = new EmployeeDAO().getEmployeeByProject(12);
		int sum = EmployeeListByProject1.size() + EmployeeListByProject2.size() + EmployeeListByProject4.size();
//		 List<Employee> EmployeeListByProject4 = new EmployeeDAO().getEmployeeByProject(1);
//		 List<Employee> EmployeeListByProject1 = new EmployeeDAO().getEmployeeByProject(1);
		pieDataset.setValue("Project ID 1", EmployeeListByProject1.size());
		pieDataset.setValue("Project ID 2", EmployeeListByProject2.size());
		pieDataset.setValue("Project ID 3", EmployeeListByProject3.size());
		pieDataset.setValue("Project ID 4", EmployeeListByProject4.size());
		pieDataset.setValue("Project ID 5", EmployeeListByProject5.size());
		JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
		PiePlot p = (PiePlot) chart.getPlot();
////		p.setForegroundAlpha(TOP_ALIGNMENT);
		ChartFrame frame = new ChartFrame("Pie Chart", chart);
		setTitle("Pie Chart");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(450, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		frame.setVisible(true);

//		spltPane.setRightComponent(frame);

	}

	protected void btnExitActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(this, "Do you want to close?", "Confirm", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
			System.exit(1);
		}
	}

	private void btnLocationManageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLocationManageActionPerformed
		PnlAdminLocationManage pnlLocationManage = new PnlAdminLocationManage();
		spltPane.setRightComponent(pnlLocationManage);
	}// GEN-LAST:event_btnLocationManageActionPerformed

	private void btnDepartmentManageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDepartmentManageActionPerformed
		PnlAdminDepartmentManage pnlDepartmentManage = new PnlAdminDepartmentManage();
		spltPane.setRightComponent(pnlDepartmentManage);
	}// GEN-LAST:event_btnDepartmentManageActionPerformed

	private void mnuiLogoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mnuiLogoutActionPerformed
		logOut();
	}// GEN-LAST:event_mnuiLogoutActionPerformed

	// Thoát khỏi ứng dụng
	private void mnuiExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mnuiExitActionPerformed
		if (JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Log out",
				JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}// GEN-LAST:event_mnuiExitActionPerformed

	private void btnEmployeeManageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEmployeeManageActionPerformed
		PnlAdminEmployeeManage pnlEmp = new PnlAdminEmployeeManage();
		spltPane.setRightComponent(pnlEmp);
	}// GEN-LAST:event_btnEmployeeManageActionPerformed

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		Main.frmLogin.setVisible(true);

	}// GEN-LAST:event_formWindowClosing

	private void btnProjectManageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnProjectManageActionPerformed
		PnlAdminProjectManage pnlPrj = new PnlAdminProjectManage();
		spltPane.setRightComponent(pnlPrj);
	}// GEN-LAST:event_btnProjectManageActionPerformed

	private void btnEmpTransferManageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEmpTransferManageActionPerformed
		PnlAdminTransferManager pnlAdminTransferManage = new PnlAdminTransferManager();
		spltPane.setRightComponent(pnlAdminTransferManage);

	}// GEN-LAST:event_btnEmpTransferManageActionPerformed

	private void btnRequestTransferActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRequestTransferActionPerformed

	}// GEN-LAST:event_btnRequestTransferActionPerformed

//	private void btnHomeEmpActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHomeEmpActionPerformed
//
//	}// GEN-LAST:event_btnHomeEmpActionPerformed

	private void btnDepartmentListActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDepartmentListActionPerformed
		PnlUserDepartmentList deptEmpPnl = new PnlUserDepartmentList();
		spltPane.setRightComponent(deptEmpPnl);
	}// GEN-LAST:event_btnDepartmentListActionPerformed

//	private void btnProjectListActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnProjectListActionPerformed
//
//	}// GEN-LAST:event_btnProjectListActionPerformed

	private void btnLocationListActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLocationListActionPerformed
		PnlUserLocationList empLocLst = new PnlUserLocationList();
		spltPane.setRightComponent(empLocLst);
	}// GEN-LAST:event_btnLocationListActionPerformed

	private void btnLogout1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogout1ActionPerformed
		logOut();
	}// GEN-LAST:event_btnLogout1ActionPerformed

//	private void btnEmpMyProfileActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEmpMyProfileActionPerformed
//
//	}// GEN-LAST:event_btnEmpMyProfileActionPerformed

	/* Xác nhận và đăng nhập hệ thống */
	private void logOut() {
		if (JOptionPane.showConfirmDialog(null, "Do you want to exit ?", "Exit", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
			curEmp = null;
			Main.frmLogin.setVisible(true);
			this.dispose();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new MasterLayout(null).setVisible(true);
			}
		});
	}

	/* Quản trị */
	private void setAdminLayout() {
		scrlPaneLeftUser.setVisible(false);// ẩn bảng người dùng

		scrlpaneLeftAdmin.setVisible(true);// hiện và thêm của người dùng
		spltPane.setLeftComponent(scrlpaneLeftAdmin);

		this.setTitle(this.getTitle() + " - SYSTEM ADMINISTRATOR");
	}

	/* Phong cửa sổ bình thường */
	private void setUserLayout() {
		scrlpaneLeftAdmin.setVisible(false);// ẩn bảng Admin

		scrlPaneLeftUser.setVisible(true);
		spltPane.setLeftComponent(this.scrlPaneLeftUser);// hiện và thêm bảng người dùng

		this.setTitle(this.getTitle() + " - NORMAL USER");
	}

//kích thước frame
	private void setFrameStyle() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;

		setBounds((width - 1024) / 2, (height - 768) / 2, 1024, 768);

		setIconImage((new ImageIcon("wire_transfer.png")).getImage());

		setFont(new Font("Verdana", Font.BOLD, 10));
		spltPane.setRightComponent(pnlHome);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnDepartmentList;
	private javax.swing.JButton btnDepartmentManage;
	private javax.swing.JButton btnEmpMyProfile;
	private javax.swing.JButton btnEmpTransferManage;
	private javax.swing.JButton btnEmployeeManage;
	private javax.swing.JButton btnExit;
	private javax.swing.JButton btnSeachChart;
	private javax.swing.JButton btnStatisticChart;
	private javax.swing.JButton btnHomeEmp;
	private javax.swing.JButton btnLocationList;
	private javax.swing.JButton btnLocationManage;
	private javax.swing.JButton btnLogout1;
	private javax.swing.JButton btnProjectList;
	private javax.swing.JButton btnProjectManage;
	private javax.swing.JButton btnRequestTransfer;
	private javax.swing.JMenuBar menuBarMain;
	private javax.swing.JMenu menuFile;
	private javax.swing.JMenuItem mnuiExit;
	private javax.swing.JMenuItem mnuiLogout;
	private javax.swing.JPanel pnlHome;
	private javax.swing.JPanel pnlLeft;
	private javax.swing.JPanel pnlLeftEmp;
	private javax.swing.JScrollPane scrlPaneLeftUser;
	private javax.swing.JScrollPane scrlpaneLeftAdmin;
	private javax.swing.JSplitPane spltPane;
	// End of variables declaration//GEN-END:variables
	private int EmployeeId;
}
