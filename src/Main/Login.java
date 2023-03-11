package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtGirisTc;
	private JTextField txtUyeTc;
	private JPasswordField txtGirisSifre;
	private JPasswordField txtUyeSifre;
	private JPasswordField txtUyeSifreTkrr;

	/**
	 * Launch the application.
	 */
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoşgeldiniz");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 30, 200, 33);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 97, 492, 204);
		contentPane.add(tabbedPane);
		
		JPanel Giris_Ekran = new JPanel();
		tabbedPane.addTab("Giriş Ekranı", null, Giris_Ekran, null);
		Giris_Ekran.setLayout(null);
		
		JLabel lbl_Tc = new JLabel("T.C. Kimlik Numarası");
		lbl_Tc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc.setBounds(20, 49, 194, 14);
		Giris_Ekran.add(lbl_Tc);
		
		txtGirisTc = new JTextField();
		txtGirisTc.setBounds(224, 49, 240, 20);
		Giris_Ekran.add(txtGirisTc);
		txtGirisTc.setColumns(10);
		
		JLabel lbl_Tc_1 = new JLabel("Şifre");
		lbl_Tc_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_1.setBounds(20, 92, 176, 14);
		Giris_Ekran.add(lbl_Tc_1);
		
		JButton btnGiris = new JButton("Giriş Yap");
		btnGiris.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnGiris.setBounds(20, 133, 444, 32);
		Giris_Ekran.add(btnGiris);
		
		txtGirisSifre = new JPasswordField();
		txtGirisSifre.setBounds(224, 92, 240, 20);
		Giris_Ekran.add(txtGirisSifre);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Üye Ol", null, panel, null);
		panel.setLayout(null);
		
		JLabel lbl_Tc_2 = new JLabel("T.C. Kimlik Numarası");
		lbl_Tc_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_2.setBounds(10, 38, 205, 14);
		panel.add(lbl_Tc_2);
		
		txtUyeTc = new JTextField();
		txtUyeTc.setColumns(10);
		txtUyeTc.setBounds(241, 36, 224, 20);
		panel.add(txtUyeTc);
		
		JLabel lbl_Tc_1_1 = new JLabel("Şifre");
		lbl_Tc_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_1_1.setBounds(10, 69, 205, 14);
		panel.add(lbl_Tc_1_1);
		
		JButton btnyeOl = new JButton("Üye Ol");
		btnyeOl.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnyeOl.setBounds(10, 129, 454, 36);
		panel.add(btnyeOl);
		
		JLabel lbl_Tc_1_1_1 = new JLabel("Şifre Doğrula");
		lbl_Tc_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_1_1_1.setBounds(10, 94, 205, 28);
		panel.add(lbl_Tc_1_1_1);
		
		txtUyeSifre = new JPasswordField();
		txtUyeSifre.setBounds(241, 69, 224, 20);
		panel.add(txtUyeSifre);
		
		txtUyeSifreTkrr = new JPasswordField();
		txtUyeSifreTkrr.setBounds(241, 101, 224, 20);
		panel.add(txtUyeSifreTkrr);
	}
}
