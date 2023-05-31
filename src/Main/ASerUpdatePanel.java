package Main;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ASerUpdatePanel extends JFrame {

	private JPanel contentPane;
	private Connection c;
	private Statement s;
	private JTextField txtASUPAd;
	private JTextField txtASUPSuur;
	private JTextField txtASUPAtes;
	private JTextField txtASUPTc;
	private JTextField txtASUPEkg;
	private JTextField txtASUPNabiz;
	private JTextField txtASUPSeviye;
	private JTextField txtASUPHGecmisi;
	private JTextField txtASUPKulilac;
	private JTextField txtASUPIlkTani;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ASerUpdatePanel frame = new ASerUpdatePanel();
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
	public void GelenVeri(String Gelveri) {
		try {			
		    String GelenSql="SELECT \"Id\", \"Adi\", \"Tc\", \"RenkId\", \"Suur\", \"Ates\", \"Nabiz\", \"Ekg\", \"HastaGecmisi\", \"KullanilanIlac\", \"OnTani\" FROM public.\"EmergencyPatient\" where \"Adi\"='"+Gelveri+"';";
		    ResultSet rs=s.executeQuery(GelenSql);
		    while(rs.next()) {
		    	txtASUPAd.setText(rs.getString("Adi"));
		    	txtASUPAtes.setText(String.valueOf(rs.getString("Ates")));
		    	txtASUPEkg.setText(rs.getString("Ekg"));
		    	txtASUPHGecmisi.setText(rs.getString("HastaGecmisi"));
		    	txtASUPIlkTani.setText(rs.getString("OnTani"));
		    	txtASUPKulilac.setText(rs.getString("KullanilanIlac"));
		    	txtASUPNabiz.setText(String.valueOf(rs.getString("Nabiz")));
		    	txtASUPSeviye.setText(String.valueOf(rs.getString("RenkId")));
		    	txtASUPSuur.setText(rs.getString("Suur"));
		    	txtASUPTc.setText(rs.getString("Tc"));
		    	
		    	
		    }
		} catch (Exception e) {
			System.out.println("Hata: "+e.getMessage());
		}
	}
	
	
	//DB Connection Start
	public void getConnection() throws ClassNotFoundException, SQLException {		
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbHospitalManagementSystem", "postgres", "bdroomay6715");
		s = c.createStatement();
		System.out.println("Opened database successfully");
	}

//DB Connection End
	public ASerUpdatePanel() {
		setTitle("Acil Servis Güncelle");
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_5_4_1_2 = new JPanel();
		panel_5_4_1_2.setLayout(null);
		panel_5_4_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5_4_1_2.setBounds(0, 0, 270, 246);
		contentPane.add(panel_5_4_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Hasta Adı");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_3.setBounds(24, 11, 81, 14);
		panel_5_4_1_2.add(lblNewLabel_1_1_3);
		
		txtASUPAd = new JTextField();
		txtASUPAd.setColumns(10);
		txtASUPAd.setBounds(115, 11, 130, 20);
		panel_5_4_1_2.add(txtASUPAd);
		
		JLabel lblDoumYeri_1_1_3_3_1 = new JLabel("Şuur");
		lblDoumYeri_1_1_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_3_1.setBounds(24, 140, 81, 22);
		panel_5_4_1_2.add(lblDoumYeri_1_1_3_3_1);
		
		txtASUPSuur = new JTextField();
		txtASUPSuur.setColumns(10);
		txtASUPSuur.setBounds(115, 140, 130, 20);
		panel_5_4_1_2.add(txtASUPSuur);
		
		JLabel lblDoumYeri_1_1_3_3_1_1 = new JLabel("Ateş");
		lblDoumYeri_1_1_3_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_3_1_1.setBounds(24, 185, 81, 22);
		panel_5_4_1_2.add(lblDoumYeri_1_1_3_3_1_1);
		
		txtASUPAtes = new JTextField();
		txtASUPAtes.setColumns(10);
		txtASUPAtes.setBounds(115, 186, 130, 20);
		panel_5_4_1_2.add(txtASUPAtes);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Hasta Tc");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_3_1.setBounds(24, 54, 81, 14);
		panel_5_4_1_2.add(lblNewLabel_1_1_3_1);
		
		txtASUPTc = new JTextField();
		txtASUPTc.setColumns(10);
		txtASUPTc.setBounds(115, 54, 130, 20);
		panel_5_4_1_2.add(txtASUPTc);
		
		JLabel lblRenkId = new JLabel("Acil Seviyesi");
		lblRenkId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRenkId.setBounds(24, 97, 81, 14);
		panel_5_4_1_2.add(lblRenkId);
		
		txtASUPSeviye = new JTextField();
		txtASUPSeviye.setColumns(10);
		txtASUPSeviye.setBounds(115, 96, 130, 20);
		panel_5_4_1_2.add(txtASUPSeviye);
		
		JPanel panel_5_4_1_2_1 = new JPanel();
		panel_5_4_1_2_1.setLayout(null);
		panel_5_4_1_2_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5_4_1_2_1.setBounds(270, 0, 270, 246);
		contentPane.add(panel_5_4_1_2_1);
		
		JLabel lblDoumYeri_1_1_3_3 = new JLabel("Hastalık / Ameliyat Geçmişi");
		lblDoumYeri_1_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_3.setBounds(10, 108, 242, 22);
		panel_5_4_1_2_1.add(lblDoumYeri_1_1_3_3);
		
		txtASUPEkg = new JTextField();
		txtASUPEkg.setColumns(10);
		txtASUPEkg.setBounds(107, 51, 130, 20);
		panel_5_4_1_2_1.add(txtASUPEkg);
		
		JLabel lblDoumYeri_1_1_3_3_1_3 = new JLabel("EKG");
		lblDoumYeri_1_1_3_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_3_1_3.setBounds(16, 51, 81, 22);
		panel_5_4_1_2_1.add(lblDoumYeri_1_1_3_3_1_3);
		
		JLabel lblDoumYeri_1_1_3_3_1_2 = new JLabel("Nabız");
		lblDoumYeri_1_1_3_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_3_1_2.setBounds(16, 11, 81, 22);
		panel_5_4_1_2_1.add(lblDoumYeri_1_1_3_3_1_2);
		
		txtASUPNabiz = new JTextField();
		txtASUPNabiz.setColumns(10);
		txtASUPNabiz.setBounds(107, 11, 130, 20);
		panel_5_4_1_2_1.add(txtASUPNabiz);
		
		txtASUPHGecmisi = new JTextField();
		txtASUPHGecmisi.setColumns(10);
		txtASUPHGecmisi.setBounds(10, 141, 227, 20);
		panel_5_4_1_2_1.add(txtASUPHGecmisi);
		
		JLabel lblDoumYeri_1_1_3_1 = new JLabel("Kullandığı İlcaçlar");
		lblDoumYeri_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_1.setBounds(10, 171, 124, 22);
		panel_5_4_1_2_1.add(lblDoumYeri_1_1_3_1);
		
		txtASUPKulilac = new JTextField();
		txtASUPKulilac.setColumns(10);
		txtASUPKulilac.setBounds(10, 204, 227, 20);
		panel_5_4_1_2_1.add(txtASUPKulilac);
		
		JPanel panel_5_4_1_2_2 = new JPanel();
		panel_5_4_1_2_2.setLayout(null);
		panel_5_4_1_2_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5_4_1_2_2.setBounds(545, 0, 251, 246);
		contentPane.add(panel_5_4_1_2_2);
		
		JLabel lblDoumYeri_1_1_3_2_1 = new JLabel("İlk Tanı");
		lblDoumYeri_1_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_2_1.setBounds(10, 11, 124, 22);
		panel_5_4_1_2_2.add(lblDoumYeri_1_1_3_2_1);
		
		txtASUPIlkTani = new JTextField();
		txtASUPIlkTani.setColumns(10);
		txtASUPIlkTani.setBounds(10, 41, 227, 20);
		panel_5_4_1_2_2.add(txtASUPIlkTani);
		
		JButton btnHKPGuncelle = new JButton("Güncelle");
		btnHKPGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc=txtASUPTc.getText();
				int reply = JOptionPane.showConfirmDialog(panel_5_4_1_2_1, ""+tc+" Kimlik numaralı kişiyi güncellemek istiyorsunuz Emin misiniz?", "Emin misiniz?", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					try {
						String SqlSil="DELETE FROM public.\"EmergencyPatient\" WHERE \"Tc\"='"+tc+"';";
						int rs= s.executeUpdate(SqlSil);
						String SqlEkle="INSERT INTO public.\"EmergencyPatient\"(\"Adi\", \"Tc\", \"RenkId\", \"Suur\", \"Ates\", \"Nabiz\", \"Ekg\", \"HastaGecmisi\", \"KullanilanIlac\", \"OnTani\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement prep =c.prepareStatement(SqlEkle);
						prep.setString(1,txtASUPAd.getText() );
						prep.setString(2,txtASUPTc.getText() );
						prep.setInt(3,Integer.parseInt(txtASUPSeviye.getText()));
						prep.setString(4, txtASUPSuur.getText());
						prep.setFloat(5, Float.parseFloat(txtASUPAtes.getText()));
						prep.setInt(6, Integer.parseInt(txtASUPNabiz.getText()));
						prep.setString(7, txtASUPEkg.getText());
						prep.setString(8, txtASUPHGecmisi.getText());
						prep.setString(9, txtASUPKulilac.getText());
						prep.setString(10, txtASUPIlkTani.getText());
						int den=prep.executeUpdate();
						if (den==1 && rs==1) {
							JOptionPane.showMessageDialog(panel_5_4_1_2_1,"Güncelleme Başarılı");
						}else {
							JOptionPane.showMessageDialog(panel_5_4_1_2_1,"Güncelleme Başarısız");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnHKPGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHKPGuncelle.setBounds(335, 272, 123, 27);
		contentPane.add(btnHKPGuncelle);
	}
}
