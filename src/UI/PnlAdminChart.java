package UI;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import Dao.EmployeeDAO;
import Entity.Employee;

public class PnlAdminChart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PnlAdminChart frame = new PnlAdminChart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public PnlAdminChart() throws ClassNotFoundException, SQLException {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		List<Employee> EmployeeListByProject1 = new EmployeeDAO().getEmployeeByProject(1);
		List<Employee> EmployeeListByProject2 = new EmployeeDAO().getEmployeeByProject(2);
		List<Employee> EmployeeListByProject4 = new EmployeeDAO().getEmployeeByProject(4);
//		 List<Employee> EmployeeListByProject4 = new EmployeeDAO().getEmployeeByProject(1);
//		 List<Employee> EmployeeListByProject1 = new EmployeeDAO().getEmployeeByProject(1);
		pieDataset.setValue("One", EmployeeListByProject1.size());
		pieDataset.setValue("Two", EmployeeListByProject2.size());
		pieDataset.setValue("Three", EmployeeListByProject4.size());
//		pieDataset.setValue("Four", new Integer(40));
		JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
		PiePlot p = (PiePlot) chart.getPlot();
//		p.setForegroundAlpha(TOP_ALIGNMENT);
		ChartFrame frame = new ChartFrame("Pie Chart", chart);
		setTitle("Chart");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(450, 500);
		frame.setLocationRelativeTo(null);
		setResizable(false);
	}

}
