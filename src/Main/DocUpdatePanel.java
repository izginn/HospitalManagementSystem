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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DocUpdatePanel extends JFrame {

	private JPanel contentPane;
	private Connection c;
	private Statement s;
	private JTextField txtDUPAd;
	private JTextField txtDUPTc;
	private JTextField txtDUPDogYili;
	private JTextField txtDUPDogYeri;
	private JTextField txtDUPAlan;
	private JTextField txtDUPTelefon;
	private JTextField txtDUPMail;
	private JTextField txtDUPYoplamIzin;
	private JTextField txtDUPCalSaati;
	private JTextField txtDUPCinsiyet;
	private JTextField txtDUPPolikinlik;
	private JTextField txtDUPOgrenimSeviyesi;
	private JTextField txtDUPAdres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocUpdatePanel frame = new DocUpdatePanel();
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
		    String GelenSql="SELECT \"Id\", \"Ad\", \"Tc\", \"DogYer\", \"Cinsiyet\", \"Adres\", \"Telefon\", \"Mail\", \"OgrenimSeviyesi\", \"Alan\", \"ToplamIzin\", \"CalSaati\", \"PolId\", \"DogTar\" FROM public.\"Doctor\" Where \"Ad\"='"+Gelveri+"';";
		    ResultSet rs=s.executeQuery(GelenSql);
		    while(rs.next()) {
				txtDUPAd.setText(rs.getString("Ad"));
				txtDUPAdres.setText(rs.getString("Adres"));
				txtDUPAlan.setText(rs.getString("Alan"));
				txtDUPCalSaati.setText(rs.getString("CalSaati"));
				txtDUPCinsiyet.setText(rs.getString("Cinsiyet"));
				txtDUPDogYili.setText(String.valueOf(rs.getInt("DogTar")));
				txtDUPDogYeri.setText(rs.getString("DogYer"));
				txtDUPMail.setText(rs.getString("Mail"));
				txtDUPOgrenimSeviyesi.setText(rs.getString("OgrenimSeviyesi"));
				txtDUPPolikinlik.setText(String.valueOf(rs.getInt("PolId")));
				txtDUPTc.setText(rs.getString("Tc"));
				txtDUPTelefon.setText(rs.getString("Telefon"));
				txtDUPYoplamIzin.setText(String.valueOf(rs.getInt("ToplamIzin")));
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
	public DocUpdatePanel() {
		setTitle("Doktor Güncelle");
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 808, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 802, 350);
		contentPane.add(panel_1);
		
		JPanel panel_5_4 = new JPanel();
		panel_5_4.setLayout(null);
		panel_5_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kimlik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4.setBounds(0, 0, 270, 182);
		panel_1.add(panel_5_4);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 25, 124, 14);
		panel_5_4.add(lblNewLabel_1);
		
		JLabel lblTcKimlik_1 = new JLabel("T.C. Kimlik Numarası");
		lblTcKimlik_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik_1.setBounds(10, 55, 124, 14);
		panel_5_4.add(lblTcKimlik_1);
		
		JLabel lblDoumTarihi_1 = new JLabel("Doğum Yılı");
		lblDoumTarihi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumTarihi_1.setBounds(10, 85, 124, 22);
		panel_5_4.add(lblDoumTarihi_1);
		
		JLabel lblDoumYeri_1 = new JLabel("Doğum Yeri");
		lblDoumYeri_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri_1.setBounds(10, 115, 124, 17);
		panel_5_4.add(lblDoumYeri_1);
		
		JLabel lblCinsiyeti_1 = new JLabel("Cinsiyeti");
		lblCinsiyeti_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCinsiyeti_1.setBounds(10, 145, 124, 14);
		panel_5_4.add(lblCinsiyeti_1);
		
		txtDUPAd = new JTextField();
		txtDUPAd.setColumns(10);
		txtDUPAd.setBounds(144, 23, 106, 20);
		panel_5_4.add(txtDUPAd);
		
		txtDUPTc = new JTextField();
		txtDUPTc.setEnabled(false);
		txtDUPTc.setEditable(false);
		txtDUPTc.setColumns(10);
		txtDUPTc.setBounds(144, 55, 106, 20);
		panel_5_4.add(txtDUPTc);
		
		txtDUPDogYili = new JTextField();
		txtDUPDogYili.setColumns(10);
		txtDUPDogYili.setBounds(144, 85, 106, 20);
		panel_5_4.add(txtDUPDogYili);
		
		txtDUPDogYeri = new JTextField();
		txtDUPDogYeri.setColumns(10);
		txtDUPDogYeri.setBounds(144, 115, 106, 20);
		panel_5_4.add(txtDUPDogYeri);
		
		txtDUPCinsiyet = new JTextField();
		txtDUPCinsiyet.setColumns(10);
		txtDUPCinsiyet.setBounds(144, 143, 106, 20);
		panel_5_4.add(txtDUPCinsiyet);
		
		JPanel panel_5_5 = new JPanel();
		panel_5_5.setLayout(null);
		panel_5_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Akademik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_5.setBounds(270, 0, 270, 182);
		panel_1.add(panel_5_5);
		
		JLabel lblDoumYeri_2 = new JLabel("Alanı");
		lblDoumYeri_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri_2.setBounds(10, 145, 124, 22);
		panel_5_5.add(lblDoumYeri_2);
		
		txtDUPAlan = new JTextField();
		txtDUPAlan.setColumns(10);
		txtDUPAlan.setBounds(144, 145, 106, 20);
		panel_5_5.add(txtDUPAlan);
		
		JLabel lblDoumYeri_2_1 = new JLabel("Polikinlik");
		lblDoumYeri_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri_2_1.setBounds(10, 85, 124, 22);
		panel_5_5.add(lblDoumYeri_2_1);
		
		JLabel lblOgrSev = new JLabel("Öğrenim Seviyesi");
		lblOgrSev.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOgrSev.setBounds(10, 30, 124, 22);
		panel_5_5.add(lblOgrSev);
		
		txtDUPPolikinlik = new JTextField();
		txtDUPPolikinlik.setColumns(10);
		txtDUPPolikinlik.setBounds(144, 87, 106, 20);
		panel_5_5.add(txtDUPPolikinlik);
		
		txtDUPOgrenimSeviyesi = new JTextField();
		txtDUPOgrenimSeviyesi.setColumns(10);
		txtDUPOgrenimSeviyesi.setBounds(144, 32, 106, 20);
		panel_5_5.add(txtDUPOgrenimSeviyesi);
		
		JPanel panel_5_6 = new JPanel();
		panel_5_6.setLayout(null);
		panel_5_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_6.setBounds(539, 0, 253, 182);
		panel_1.add(panel_5_6);
		
		JLabel lblAdres_1 = new JLabel("Adres");
		lblAdres_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres_1.setBounds(10, 25, 124, 14);
		panel_5_6.add(lblAdres_1);
		
		JLabel lblTelefonNumaras_1 = new JLabel("Telefon No");
		lblTelefonNumaras_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras_1.setBounds(10, 84, 85, 22);
		panel_5_6.add(lblTelefonNumaras_1);
		
		txtDUPTelefon = new JTextField();
		txtDUPTelefon.setColumns(10);
		txtDUPTelefon.setBounds(105, 86, 138, 20);
		panel_5_6.add(txtDUPTelefon);
		
		JLabel lblTelefonNumaras_1_1 = new JLabel("E Mail");
		lblTelefonNumaras_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras_1_1.setBounds(10, 145, 85, 22);
		panel_5_6.add(lblTelefonNumaras_1_1);
		
		txtDUPMail = new JTextField();
		txtDUPMail.setColumns(10);
		txtDUPMail.setBounds(105, 147, 138, 20);
		panel_5_6.add(txtDUPMail);
		
		txtDUPAdres = new JTextField();
		txtDUPAdres.setColumns(10);
		txtDUPAdres.setBounds(105, 23, 138, 20);
		panel_5_6.add(txtDUPAdres);
		
		JPanel panel_5_3_1 = new JPanel();
		panel_5_3_1.setLayout(null);
		panel_5_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130\u015F Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_3_1.setBounds(0, 181, 792, 108);
		panel_1.add(panel_5_3_1);
		
		JLabel lblizin = new JLabel("Toplam İzin Günü");
		lblizin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblizin.setBounds(43, 48, 137, 14);
		panel_5_3_1.add(lblizin);
		
		txtDUPYoplamIzin = new JTextField();
		txtDUPYoplamIzin.setColumns(10);
		txtDUPYoplamIzin.setBounds(191, 46, 106, 20);
		panel_5_3_1.add(txtDUPYoplamIzin);
		
		JLabel lblIzinKullan_1 = new JLabel("Çalışma Saatleri");
		lblIzinKullan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzinKullan_1.setBounds(478, 47, 100, 14);
		panel_5_3_1.add(lblIzinKullan_1);
		
		txtDUPCalSaati = new JTextField();
		txtDUPCalSaati.setColumns(10);
		txtDUPCalSaati.setBounds(588, 42, 106, 20);
		panel_5_3_1.add(txtDUPCalSaati);
		
		JButton btnHKPGuncelle = new JButton("Güncelle");
		btnHKPGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc=txtDUPTc.getText();
				try {
					int reply = JOptionPane.showConfirmDialog(panel_1, ""+tc+" Kimlik numaralı kişiyi güncellemek istiyorsunuz Emin misiniz?", "Emin misiniz?", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						String SqlSil="DELETE FROM public.\"Doctor\" WHERE \"Tc\"='"+tc+"';";
						int rs= s.executeUpdate(SqlSil);
						String SqlEkle="INSERT INTO public.\"Doctor\"(\"Ad\", \"Tc\", \"DogYer\", \"Cinsiyet\", \"Adres\", \"Telefon\", \"Mail\", \"OgrenimSeviyesi\", \"Alan\", \"ToplamIzin\", \"CalSaati\", \"PolId\", \"DogTar\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement prep =c.prepareStatement(SqlEkle);
						prep.setString(1,txtDUPAd.getText());
						prep.setString(2,txtDUPTc.getText());
						prep.setString(3, txtDUPDogYeri.getText());
						prep.setString(4, txtDUPCinsiyet.getText());
						prep.setString(5, txtDUPAdres.getText());
						prep.setString(6, txtDUPTelefon.getText());
						prep.setString(7, txtDUPMail.getText());
						prep.setString(8, txtDUPOgrenimSeviyesi.getText());
						prep.setString(9, txtDUPAlan.getText());
						prep.setInt(10, Integer.parseInt(txtDUPYoplamIzin.getText()));
						prep.setString(11, txtDUPCalSaati.getText());
						prep.setInt(12, Integer.parseInt(txtDUPPolikinlik.getText()));
						prep.setInt(13,Integer.parseInt(txtDUPDogYili.getText()));	
						int den=prep.executeUpdate();
						if (den==1 && rs==1) {
							JOptionPane.showMessageDialog(panel_1,"Güncelleme Başarılı");
						}else {
							JOptionPane.showMessageDialog(panel_1,"Güncelleme Başarısız");
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnHKPGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHKPGuncelle.setBounds(332, 312, 123, 27);
		panel_1.add(btnHKPGuncelle);
	}

}
