package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class OffDay extends JFrame {

	private JPanel contentPane;
	private JTextField txtKullanilabilirIzin;
	private JTextField txtodDoktorTc;
	private Connection c;
	private ResultSet rs;
	private Statement s;
	
	
	//DB Connection Start
	public void getConnection() throws ClassNotFoundException, SQLException {		
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbHospitalManagementSystem", "postgres", "bdroomay6715");
			s = c.createStatement();
			System.out.println("Opened database successfully");
		}
	//DB Connection End

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OffDay frame = new OffDay();
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

	public OffDay() {
		setTitle("Doktor İzin");
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 332, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtodDoktorTc = new JTextField();
		txtodDoktorTc.setColumns(10);
		txtodDoktorTc.setBounds(122, 60, 90, 20);
		contentPane.add(txtodDoktorTc);
		
		JSpinner spinnerIzin = new JSpinner();
		spinnerIzin.setBounds(179, 166, 106, 20);
		contentPane.add(spinnerIzin);
		
		
		int Spizin=(int) spinnerIzin.getValue();
		
		JButton btnAra = new JButton("Ara");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc=txtodDoktorTc.getText();
				try {
					String sql3="SELECT \"ToplamIzin\"	FROM public.\"Doctor\" where \"Tc\" = '"+tc+"';";
					rs=s.executeQuery(sql3);
					 while (rs.next()) {
						 int ToplamIzin=rs.getInt("ToplamIzin");
						 System.out.println(ToplamIzin);
						 int KullanilabilirIzin=ToplamIzin-Spizin;
						 txtKullanilabilirIzin.setText(String.valueOf(KullanilabilirIzin));
					 }
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnAra.setBounds(208, 59, 77, 23);
		contentPane.add(btnAra);
		

		
		JButton btnIzinKullanOn = new JButton("İzin Kullan");
		btnIzinKullanOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kr=Integer.parseInt(txtKullanilabilirIzin.getText());
				int ik = (Integer) spinnerIzin.getValue();
				if (ik > kr) {
					JOptionPane.showMessageDialog(btnIzinKullanOn,"Izin Hakkınız Yetmemektedir.");
				}
				else {
					int kalan=kr-ik;
					String tc=txtodDoktorTc.getText();
					try {
						String Sql="UPDATE public.\"Doctor\" SET \"ToplamIzin\"="+kalan+" WHERE \"Tc\"='"+tc+"';";
						PreparedStatement prep =c.prepareStatement(Sql);
						int a=prep.executeUpdate();
						if (a==1) {
							JOptionPane.showMessageDialog(btnIzinKullanOn,"Izniniz Başarılı Bir Şekilde Kullanıldı.");
							txtKullanilabilirIzin.setText(String.valueOf(kalan));
						}
						else {
							System.out.println("Hata");
						}
						 
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
					
				}
				
			}
		});
		btnIzinKullanOn.setBounds(86, 267, 137, 28);
		contentPane.add(btnIzinKullanOn);
		
		JLabel lblKullanlabilirIzinGn = new JLabel("Kullanılabilir İzin Günü");
		lblKullanlabilirIzinGn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullanlabilirIzinGn.setBounds(32, 116, 137, 14);
		contentPane.add(lblKullanlabilirIzinGn);
		
		txtKullanilabilirIzin = new JTextField();
		txtKullanilabilirIzin.setEditable(false);
		txtKullanilabilirIzin.setColumns(10);
		txtKullanilabilirIzin.setBounds(179, 114, 106, 20);
		contentPane.add(txtKullanilabilirIzin);
		
		JLabel lblIzinKullan = new JLabel("İzin Kullan");
		lblIzinKullan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzinKullan.setBounds(32, 168, 137, 14);
		contentPane.add(lblIzinKullan);
		
		JLabel lblDoktorTc = new JLabel("Doktor Tc");
		lblDoktorTc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoktorTc.setBounds(32, 62, 77, 14);
		contentPane.add(lblDoktorTc);
		

		
		
	}
}
