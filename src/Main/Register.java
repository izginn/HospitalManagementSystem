package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtTc;
	private JTextField txtAd;
	private JTextField txtPassw;
	private JTextField txtPasscheck;
	private Connection conn;
	private Statement s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void getConnection() throws ClassNotFoundException, SQLException {		
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbHospitalManagementSystem", "postgres", "bdroomay6715");
		s = conn.createStatement();
		System.out.println("Opened database successfully");
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(20, 41, 487, 214);
		contentPane.add(panel);
		
		JLabel lbl_Tc_2 = new JLabel("T.C. Kimlik Numarası");
		lbl_Tc_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_2.setBounds(10, 43, 205, 20);
		panel.add(lbl_Tc_2);
		
		txtTc = new JTextField();
		txtTc.setColumns(10);
		txtTc.setBounds(241, 43, 224, 20);
		panel.add(txtTc);
		
		JLabel lbl_Tc_1_1 = new JLabel("Şifre");
		lbl_Tc_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_1_1.setBounds(10, 73, 205, 20);
		panel.add(lbl_Tc_1_1);
		
		JLabel lbl_Tc_1_1_1 = new JLabel("Şifre Doğrula");
		lbl_Tc_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_1_1_1.setBounds(10, 103, 205, 20);
		panel.add(lbl_Tc_1_1_1);
		
		JLabel lbl_Tc_2_1 = new JLabel("Ad");
		lbl_Tc_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_2_1.setBounds(10, 13, 205, 14);
		panel.add(lbl_Tc_2_1);
		
		txtAd = new JTextField();
		txtAd.setColumns(10);
		txtAd.setBounds(241, 13, 224, 20);
		panel.add(txtAd);
		
		txtPassw = new JTextField();
		txtPassw.setColumns(10);
		txtPassw.setBounds(241, 73, 224, 20);
		panel.add(txtPassw);
		
		txtPasscheck = new JTextField();
		txtPasscheck.setColumns(10);
		txtPasscheck.setBounds(241, 103, 224, 20);
		panel.add(txtPasscheck);
		
		JLabel lblUnvan = new JLabel("Unvan");
		lblUnvan.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUnvan.setBounds(10, 133, 205, 20);
		panel.add(lblUnvan);
		
		JComboBox cboxUnvan = new JComboBox();
		cboxUnvan.setModel(new DefaultComboBoxModel(new String[] {"Personel", "Doktor"}));
		cboxUnvan.setBounds(241, 133, 224, 22);
		panel.add(cboxUnvan);
		
		JButton btnyeOl = new JButton("Üye Ol");
		btnyeOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String unv = (String)cboxUnvan.getSelectedItem(); 
				String ad=txtAd.getText();
				String tc=txtTc.getText();
				String ps=txtPassw.getText();
				try {
					String sql1 = "INSERT INTO public.\"Member\"(\"Ad\", \"Tc\", \"Password\", \"Unvan\") VALUES (?, ?, ?, ?);";
					PreparedStatement prep =conn.prepareStatement(sql1);
					prep.setString(1, ad);
					prep.setString(2, tc);
					prep.setString(3, ps);
					prep.setString(4, unv.toLowerCase());
					int a=prep.executeUpdate();
					if (a==1) {
						JOptionPane.showMessageDialog(btnyeOl,"Tebrikler! Kayıt Başarılı.");
						txtAd.setText("");
						txtPasscheck.setText("");
						txtPassw.setText("");
						txtTc.setText("");
					}
					else {
						JOptionPane.showConfirmDialog(null, "Kayıt Başarısız", "Hata", JOptionPane.CLOSED_OPTION,
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (SQLException e1) {				
					e1.printStackTrace();
					System.out.println("Deneme "+e1.toString());
				}
			}
		});
		btnyeOl.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnyeOl.setBounds(11, 178, 454, 36);
		panel.add(btnyeOl);
		
	
	}
}
