package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class OffDayPersonel extends JFrame {

	private JPanel contentPane;
	private JTextField txtPersonelTc;
	private JTextField txtKullanilabilirIzin;
	private Connection c;
	private ResultSet rs;
	private Statement s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OffDayPersonel frame = new OffDayPersonel();
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
	//DB Connection Start
	public void getConnection() throws ClassNotFoundException, SQLException {		
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbHospitalManagementSystem", "postgres", "bdroomay6715");
			s = c.createStatement();
			System.out.println("Opened database successfully");
		}
	//DB Connection End
	public OffDayPersonel() {
		setTitle("Personel İzin");
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 324, 377);
		contentPane.add(contentPane_1);
		
		txtPersonelTc = new JTextField();
		txtPersonelTc.setColumns(10);
		txtPersonelTc.setBounds(126, 59, 90, 20);
		contentPane_1.add(txtPersonelTc);
		
		JSpinner spinnerIzin = new JSpinner();
		spinnerIzin.setBounds(183, 165, 106, 20);
		contentPane_1.add(spinnerIzin);
		
		int Spizin=(int) spinnerIzin.getValue();
		
		JButton btnAra = new JButton("Ara");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc=txtPersonelTc.getText();
				try {
					String sql3="SELECT \"ToplamIzin\"	FROM public.\"Personel\" where \"Tc\" = '"+tc+"';";
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
		btnAra.setBounds(212, 58, 77, 23);
		contentPane_1.add(btnAra);
		
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
					String tc=txtPersonelTc.getText();
					try {
						String Sql="UPDATE public.\"Personel\" SET \"ToplamIzin\"="+kalan+" WHERE \"Tc\"='"+tc+"';";
						PreparedStatement prep =c.prepareStatement(Sql);
						int a=prep.executeUpdate();
						if (a==1) {
							JOptionPane.showMessageDialog(contentPane_1,"Izniniz Başarılı Bir Şekilde Kullanıldı.");
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
		btnIzinKullanOn.setBounds(90, 266, 137, 28);
		contentPane_1.add(btnIzinKullanOn);
		
		JLabel lblKullanlabilirIzinGn = new JLabel("Kullanılabilir İzin Günü");
		lblKullanlabilirIzinGn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullanlabilirIzinGn.setBounds(36, 115, 137, 14);
		contentPane_1.add(lblKullanlabilirIzinGn);
		
		txtKullanilabilirIzin = new JTextField();
		txtKullanilabilirIzin.setEditable(false);
		txtKullanilabilirIzin.setColumns(10);
		txtKullanilabilirIzin.setBounds(183, 113, 106, 20);
		contentPane_1.add(txtKullanilabilirIzin);
		
		JLabel lblIzinKullan = new JLabel("İzin Kullan");
		lblIzinKullan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzinKullan.setBounds(36, 167, 137, 14);
		contentPane_1.add(lblIzinKullan);
		
		JLabel lblPersonelTc = new JLabel("Personel Tc");
		lblPersonelTc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPersonelTc.setBounds(36, 61, 77, 14);
		contentPane_1.add(lblPersonelTc);
	}
}
