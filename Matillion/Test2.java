package com.Massimo.Matillion.Test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/* Test 2
 * For this test, you are supplied a .sql file (test_two.sql) and expected to run it
 * on a MySQL database. This should then give you three tables, populated with
 * data.
 * You are to write a SQL query that returns the full name, birth date, hire date
 * and gender of all employees who work in the department ‘Temp Stockers’, are
 * paid hourly, and have an education level of ‘Graduate Degree’.
 * Your results should be ordered alphabetically on the full name of the
 * employee.
 * Once this has been done, you are to then write a Java based menu that
 * allows the user to choose a department, pay type and education level, and
 * then runs the query with those options on the database. The program should
 * then display the results of the query.
 * To connect to the database you should use a connector jar such as the one
 * located here:
 * http://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.21
 */
/**
 * This class is a JFrame window, that will connect to a localhost database, performing
 * a query with the parameters selected via JComboBoxes and will show the result in a JTable
 * 
 * @author Massimo
 *
 */
public class Test2 extends JFrame{

	private static final long serialVersionUID = -7180688940345372923L;
	private static final String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
	private static final String serverName = "localhost";
	private static final String mydatabase = "foodmart";
	private static final String jdbcURL = "jdbc:mysql://" + serverName +  "/" + mydatabase; // a JDBC url
	private static final String username = "massimo";
	private static final String password = "vf500fii";
	private static final String queryFormat = 
			"SELECT e.full_name, e.birth_date, e.hire_date, e.gender \r\n" + 
					"FROM employee e \r\n" + 
					"LEFT OUTER JOIN department d \r\n" + 
					"ON e.department_id = d.department_id \r\n" + 
					"LEFT OUTER JOIN position p \r\n" + 
					"ON e.position_id = p.position_id \r\n" + 
					"WHERE d.department_description = '%s' \r\n" + 
					"AND e.education_level = '%s' \r\n" + 
					"AND p.pay_type = '%s' \r\n" + 
					"ORDER BY e.full_name;";

	private Vector<String> departments = null;
	private Vector<String> payTypes = null;
	private Vector<String> edLevels = null;

	private String selDepartment = null;
	private String selPayType = null;
	private String selEdLevel = null;

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	private DefaultTableModel tableModel = null;

	/**
	 * Default constructor: connects to the DB, sets up the UI
	 */
	public Test2() {

		connectDB();

		departments = getRows("department_description", "department");
		payTypes = getRows("pay_type", "position");
		edLevels = getRows("education_level", "employee");

		initGUI();
	}
	
	/**
	 * Inits the User Interface with JPanels, JComboBoxes JButtons, JTable
	 */
	private void initGUI(){

		/* --------------- TOP SECTION ---------------*/

		JPanel top = new JPanel();
		top.setAlignmentY(CENTER_ALIGNMENT);
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));

		JComboBox<String> departmentsBox = new JComboBox<String>(departments);
		departmentsBox.setToolTipText("Select Department");
		departmentsBox.setSelectedIndex(-1);
		departmentsBox.setPreferredSize(new Dimension(140, 22));
		departmentsBox.setMaximumSize(new Dimension(200, 22));
		departmentsBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					@SuppressWarnings("rawtypes")
					JComboBox combo = (JComboBox) e.getSource();
					selDepartment = (String) combo.getSelectedItem();
				}				
			}
		});

		JComboBox<String> payTypeBox = new JComboBox<String>(payTypes); 
		payTypeBox.setToolTipText("Select Pay Type");
		payTypeBox.setSelectedIndex(-1);
		payTypeBox.setPreferredSize(new Dimension(140, 22));
		payTypeBox.setMaximumSize(new Dimension(200, 22));
		payTypeBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					@SuppressWarnings("rawtypes")
					JComboBox combo = (JComboBox) e.getSource();
					selPayType = (String) combo.getSelectedItem();
				}				
			}
		});

		JComboBox<String> edLevelBox = new JComboBox<String>(edLevels); 
		edLevelBox.setToolTipText("Select Education Level");
		edLevelBox.setSelectedIndex(-1);
		edLevelBox.setPreferredSize(new Dimension(140, 22));
		edLevelBox.setMaximumSize(new Dimension(200, 22));
		edLevelBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					@SuppressWarnings("rawtypes")
					JComboBox combo = (JComboBox) e.getSource();
					selEdLevel = (String) combo.getSelectedItem();
				}				
			}
		});

		/* --------------- TABLE SECTION ---------------*/

		JTable resultTable = new JTable();
		tableModel = new DefaultTableModel(new Object[] {"full_name", "birth_date", "hire_date", "gender"}, 0);
		resultTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(resultTable);

		/* --------------- BOTTOM SECTION ---------------*/

		JPanel bottom = new JPanel();
		bottom.setAlignmentX(1f);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));

		JButton queryButton = new JButton("Go!");
		queryButton.setToolTipText("Perform query with selected parameters");

		queryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//				System.exit(0);
				try {
					for (int i = tableModel.getRowCount()-1; i >= 0 ; i--){
						tableModel.removeRow(i);
					}
					
					resultSet = statement.executeQuery(String.format(queryFormat, selDepartment, selEdLevel, selPayType));
					
					while (resultSet.next()) {
						tableModel.addRow(writeResultSet(resultSet));
					}
				} catch (SQLException e) {
					// Could not connect to the database
					System.out.println("Could not connect to the database " + e.getMessage());
				}

			}
		});

		JButton quitButton = new JButton("Quit");
		quitButton.setToolTipText("Quit program");

		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					connect.close();
				} catch (SQLException e) {
					// Could not connect to the database
					System.out.println("Could not connect to the database " + e.getMessage());
					//					e.printStackTrace();
				}
				System.exit(0);
			}
		});

		/* --------------- ADD COMPONENTS TO JFRAME ---------------*/
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		top.add(departmentsBox);
		top.add(edLevelBox);
		top.add(payTypeBox);

		add(top, BorderLayout.NORTH);

		bottom.add(queryButton);
		bottom.add(Box.createRigidArea(new Dimension(5, 0)));

		bottom.add(quitButton);
		bottom.add(Box.createRigidArea(new Dimension(15, 0)));

		panel.add(scrollPane);
		panel.add(Box.createRigidArea(new Dimension(0, 5)));

		panel.add(Box.createVerticalGlue());

		panel.add(bottom);
		panel.add(Box.createRigidArea(new Dimension(0, 15)));

		add(panel, BorderLayout.CENTER);

		setTitle("Test 2");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Performs DB connection with a java.sql.Connection object, using com.mysql.jdbc.Driver Driver
	 * and creates a java.sql.Statement object to perform queries to the DB
	 */
	private void connectDB(){
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName(driverName);
			// setup the connection with the DB.
			connect = DriverManager.getConnection(jdbcURL, username, password);
			statement = connect.createStatement();
		} catch (ClassNotFoundException e) {
			// Could not find the database driver
			System.out.println("Could not find the database driver " + e.getMessage());
			//			e.printStackTrace();
		} catch (SQLException e) {
			// Could not connect to the database
			System.out.println("Could not connect to the database " + e.getMessage());
			//			e.printStackTrace();
		}
	}

	/**
	 * Returns a Vector of String, containing the rows of a given column, in the given table.
	 * This function is used to fill in the JComboBox dynamically with DB data
	 * 
	 * @param column The column to SELECT in the query
	 * @param table  The table to SELECT the column from in the query
	 * @return a Vector<String> containing the rows in the given column
	 */
	private Vector<String> getRows (String column, String table){

		Vector<String> result = new Vector<String>();
		try {
			resultSet = statement.executeQuery("SELECT DISTINCT " + column + " FROM " + table + ";");

			while (resultSet.next()) {
				result.add(resultSet.getString(1));
				//		    	System.out.println("department: " + resultSet.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Could not connect to the database " + e.getMessage());
			//			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Gets the result of a query as input, parses a single row and returns a Vector 
	 * of String, each element representing one column value.
	 * 
	 * @param  resultSet the result of a query, the first line will be parsed
	 * @return a Vector<String>, each element is a column value
	 * @throws SQLException
	 */
	private Vector<String> writeResultSet(ResultSet resultSet) throws SQLException {

		Vector<String> vector = new Vector<String>();
		vector.add(resultSet.getString("full_name"));
		vector.add(resultSet.getDate("birth_date").toString());
		vector.add(resultSet.getDate("hire_date").toString());
		vector.add(resultSet.getString("gender"));

		return vector;
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Test2 ex = new Test2();
				ex.setVisible(true);
			}
		});
	}
}
