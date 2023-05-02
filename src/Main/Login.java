package Main;

import java.sql.Connection;
import Class.Member;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import org.postgresql.util.ServerErrorMessage;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private Connection c;
	private Statement s;
	private ArrayList<Member> ii = new ArrayList<Member>();
	private ButtonGroup bg3 = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public void getConnection() throws ClassNotFoundException, SQLException {		
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbHospitalManagementSystem", "postgres", "bdroomay6715");
		s = c.createStatement();
		System.out.println("Opened database successfully");
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Hoşgeldiniz");
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MainFrame mf = new MainFrame();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(15, 44, 487, 214);
		contentPane.add(panel);
		
		JLabel lbl_Tc_2 = new JLabel("T.C. Kimlik Numarası");
		lbl_Tc_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_2.setBounds(10, 43, 205, 20);
		panel.add(lbl_Tc_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(241, 43, 224, 20);
		panel.add(textField);
		
		JLabel lbl_Tc_1_1 = new JLabel("Şifre");
		lbl_Tc_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_1_1.setBounds(10, 73, 205, 20);
		panel.add(lbl_Tc_1_1);
		
		JButton btnyeOl = new JButton("Üye Ol");
		btnyeOl.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnyeOl.setBounds(11, 178, 454, 36);
		panel.add(btnyeOl);
		
		JLabel lbl_Tc_1_1_1 = new JLabel("Şifre Doğrula");
		lbl_Tc_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_1_1_1.setBounds(10, 103, 205, 28);
		panel.add(lbl_Tc_1_1_1);
		
		JLabel lbl_Tc_2_1 = new JLabel("Ad");
		lbl_Tc_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_2_1.setBounds(10, 13, 205, 14);
		panel.add(lbl_Tc_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(241, 13, 224, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(241, 73, 224, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(241, 103, 224, 20);
		panel.add(textField_3);
		
		JRadioButton rdbtnDoktor = new JRadioButton("Doktor");
		rdbtnDoktor.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnDoktor.setBounds(75, 148, 111, 23);
		panel.add(rdbtnDoktor);
		
		JRadioButton rdbtnPersonel = new JRadioButton("Personel");
		rdbtnPersonel.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnPersonel.setBounds(271, 148, 111, 23);
		panel.add(rdbtnPersonel);
	}
}
