package mbanse2740ex3f;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField empIdTextField;
	private JTextField empNameTextField;
	private JTextField positionTextField;
	private JList employeeList;
	private JComboBox deptComboBox;
	private JButton noArgConstructorButton;
	private JButton twoArgConstructorButton;
	private JButton fourArgConstructorButton;
	private DefaultListModel employeeListModel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeForm() {
		setTitle("Exercise 3F: Overload Constructors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 490, 193);
		contentPane.add(scrollPane);
		
		employeeListModel = new DefaultListModel();
		employeeList = new JList(employeeListModel);
		employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(employeeList);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(12, 230, 90, 16);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(12, 259, 103, 16);
		contentPane.add(lblEmployeeName);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(12, 291, 90, 16);
		contentPane.add(lblDepartment);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(12, 320, 76, 16);
		contentPane.add(lblPosition);
		
		empIdTextField = new JTextField();
		lblEmployeeId.setLabelFor(empIdTextField);
		empIdTextField.setText("101");
		empIdTextField.setBounds(156, 227, 81, 22);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		empNameTextField = new JTextField();
		lblEmployeeName.setLabelFor(empNameTextField);
		empNameTextField.setText("Mitch Banse");
		empNameTextField.setBounds(156, 256, 144, 22);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"Business Office", "Human Resources", "Manufacturing", "Shipping", "Maitenance"}));
		lblDepartment.setLabelFor(deptComboBox);
		deptComboBox.setBounds(156, 288, 201, 22);
		contentPane.add(deptComboBox);
		
		positionTextField = new JTextField();
		lblPosition.setLabelFor(positionTextField);
		positionTextField.setText("Software Engineer");
		positionTextField.setBounds(156, 317, 144, 22);
		contentPane.add(positionTextField);
		positionTextField.setColumns(10);
		
		noArgConstructorButton = new JButton("No Arg");
		noArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_noArgConstructorButton_actionPerformed(arg0);
			}
		});
		noArgConstructorButton.setBounds(36, 354, 97, 25);
		contentPane.add(noArgConstructorButton);
		
		twoArgConstructorButton = new JButton("2 Arg");
		twoArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_twoArgConstructorButton_actionPerformed(e);
			}
		});
		twoArgConstructorButton.setBounds(156, 354, 97, 25);
		contentPane.add(twoArgConstructorButton);
		
		fourArgConstructorButton = new JButton("4 Arg");
		fourArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_fourArgConstructorButton_actionPerformed(e);
			}
		});
		fourArgConstructorButton.setBounds(278, 354, 97, 25);
		contentPane.add(fourArgConstructorButton);
	}
	
	protected void do_noArgConstructorButton_actionPerformed(ActionEvent arg0) {
		Employee emp = new Employee();
		employeeListModel.addElement(emp);
	}
	
	protected void do_twoArgConstructorButton_actionPerformed(ActionEvent e) {
		int idNumber = Integer.parseInt(empIdTextField.getText());
		Employee emp = new Employee(empNameTextField.getText(), idNumber);
		employeeListModel.addElement(emp);
	}
	
	protected void do_fourArgConstructorButton_actionPerformed(ActionEvent e) {
		int idNumber = Integer.parseInt(empIdTextField.getText());
		String dept = (String)deptComboBox.getSelectedItem();
		Employee emp = new Employee(empNameTextField.getText(), idNumber, dept, positionTextField.getText());
		employeeListModel.addElement(emp);
	}
}
