package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Class.Personel;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;

public class HKUpdatePanel extends JFrame {

	public JPanel contentPane;
	private Connection c;
	private Statement s;
	public JTextField txtHKPAd;
	public JTextField txtHKPDogYeri;
	public JTextField txtHKPDogYili;
	public JTextField txtHKPCinsiyet;
	public JTextField txtHKPTc;
	private JTextField txtHKPBoy;
	private JTextField txtHKPKilo;
	private JTextField txtHKPTedaviSekli;
	private JTextField txtHKPEkg;
	private JTextField txtHKPKanGrubu;
	private JTextField txtHKPSigortaTuru;
	private JTextField txtHKPPolikinlik;
	private JTextField txtHKPYakinlikDerecesi;
	private JTextField txtHKPRefAdi;
	private JTextField txtHKPSicilNo;
	private JTextField txtHKPAdres;
	private JTextField txtHKPTelefon;
	private JTextField txtHKPKullanilanIlac;
	private JTextField txtHKPHastalikGecmisi;
	LocalDateTime dd=LocalDateTime.now();
	private JTextField txtHKUSonGuncelleme;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HKUpdatePanel frame = new HKUpdatePanel();
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
	public void GelenVeri(String Gelveri) {
		try {			
		    String GelenSql="SELECT \"Ad\", \"Tc\", \"DogYer\", \"Cinsiyet\", \"Adres\", \"Telefon\", \"SigortaTuru\", \"SicilNo\", \"RefAdi\", \"RefYakinlik\", \"Boy\", \"Kilo\", \"KanGrubu\", \"Ekg\", \"TedaviSekli\", \"KullanilanIlac\", \"SonGuncelleme\", \"GecmisHastalik\", \"PolId\", \"DogTar\" FROM public.\"Patient\" where \"Ad\"='"+Gelveri+"';";
		    ResultSet rs=s.executeQuery(GelenSql);
		    while(rs.next()) {
		    	txtHKPAd.setText(rs.getString("Ad"));
		    	txtHKPTc.setText(rs.getString("Tc"));
		    	txtHKPDogYeri.setText(rs.getString("DogYer"));
		    	txtHKPCinsiyet.setText(rs.getString("Cinsiyet"));
		    	txtHKPSigortaTuru.setText(rs.getString("SigortaTuru"));
		    	txtHKPSicilNo.setText(rs.getString("SicilNo"));
		    	txtHKPRefAdi.setText(rs.getString("RefAdi"));
		    	txtHKPYakinlikDerecesi.setText(rs.getString("RefYakinlik"));
		    	txtHKPBoy.setText(String.valueOf(rs.getInt("Boy")));
		    	txtHKPKilo.setText(rs.getString("Kilo"));
		    	txtHKPKanGrubu.setText(rs.getString("KanGrubu"));
		    	txtHKPEkg.setText(rs.getString("Ekg"));
		    	txtHKPTedaviSekli.setText(rs.getString("TedaviSekli"));
		    	txtHKPDogYili.setText(String.valueOf(rs.getInt("DogTar")));
		    	txtHKPPolikinlik.setText(String.valueOf(rs.getString("PolId")));
		    	txtHKPTelefon.setText(rs.getString("Telefon"));
		    	txtHKPAdres.setText(rs.getString("Adres"));
		    	txtHKPKullanilanIlac.setText(rs.getString("KullanilanIlac"));
		    	txtHKPHastalikGecmisi.setText(rs.getString("GecmisHastalik"));
		    	txtHKUSonGuncelleme.setText(rs.getString("SonGuncelleme"));
		    }
		} catch (Exception e) {
			System.out.println("Hata: "+e.getMessage());
		}
	}
	public HKUpdatePanel() {
		setTitle("Hasta Güncelle");
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 811, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 802, 324);
		contentPane.add(panel_1);
		
		JPanel panel_5_4 = new JPanel();
		panel_5_4.setLayout(null);
		panel_5_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hasta Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4.setBounds(0, 0, 792, 262);
		panel_1.add(panel_5_4);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 25, 124, 14);
		panel_5_4.add(lblNewLabel_1);
		
		JLabel lblTcKimlik_1 = new JLabel("T.C. Kimlik Numarası");
		lblTcKimlik_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik_1.setBounds(10, 64, 124, 14);
		panel_5_4.add(lblTcKimlik_1);
		
		JLabel lblDoumTarihi_1 = new JLabel("Doğum Yılı");
		lblDoumTarihi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumTarihi_1.setBounds(10, 93, 124, 17);
		panel_5_4.add(lblDoumTarihi_1);
		
		JLabel lblDoumYeri_1 = new JLabel("Doğum Yeri");
		lblDoumYeri_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri_1.setBounds(10, 123, 124, 15);
		panel_5_4.add(lblDoumYeri_1);
		
		JLabel lblCinsiyeti_1 = new JLabel("Cinsiyeti");
		lblCinsiyeti_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCinsiyeti_1.setBounds(10, 154, 124, 14);
		panel_5_4.add(lblCinsiyeti_1);
		txtHKPAd = new JTextField();
		txtHKPAd.setColumns(10);
		txtHKPAd.setBounds(144, 23, 106, 20);
		panel_5_4.add(txtHKPAd);
		
		txtHKPDogYeri = new JTextField();
		txtHKPDogYeri.setColumns(10);
		txtHKPDogYeri.setBounds(144, 123, 106, 20);
		panel_5_4.add(txtHKPDogYeri);
		
		txtHKPDogYili = new JTextField();
		txtHKPDogYili.setColumns(10);
		txtHKPDogYili.setBounds(144, 92, 106, 20);
		panel_5_4.add(txtHKPDogYili);
		
		txtHKPCinsiyet = new JTextField();
		txtHKPCinsiyet.setColumns(10);
		txtHKPCinsiyet.setBounds(144, 152, 106, 20);
		panel_5_4.add(txtHKPCinsiyet);
		
		txtHKPTc = new JTextField();
		txtHKPTc.setEditable(false);
		txtHKPTc.setBounds(144, 62, 106, 20);
		panel_5_4.add(txtHKPTc);
		txtHKPTc.setColumns(10);
		
		JLabel lblBoy_1 = new JLabel("Boy");
		lblBoy_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBoy_1.setBounds(280, 19, 124, 14);
		panel_5_4.add(lblBoy_1);
		
		txtHKPBoy = new JTextField();
		txtHKPBoy.setColumns(10);
		txtHKPBoy.setBounds(414, 17, 106, 20);
		panel_5_4.add(txtHKPBoy);
		
		txtHKPKilo = new JTextField();
		txtHKPKilo.setColumns(10);
		txtHKPKilo.setBounds(414, 52, 106, 20);
		panel_5_4.add(txtHKPKilo);
		
		JLabel lblKilo_1 = new JLabel("Kilo");
		lblKilo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKilo_1.setBounds(280, 54, 124, 14);
		panel_5_4.add(lblKilo_1);
		
		JLabel lblEkg_2 = new JLabel("Kan Grubu");
		lblEkg_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEkg_2.setBounds(280, 83, 124, 14);
		panel_5_4.add(lblEkg_2);
		
		JLabel lblEkg_1_1 = new JLabel("EKG");
		lblEkg_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEkg_1_1.setBounds(280, 115, 124, 14);
		panel_5_4.add(lblEkg_1_1);
		
		JLabel lblTedaviekli_1 = new JLabel("Tedavi Şekli");
		lblTedaviekli_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTedaviekli_1.setBounds(280, 149, 113, 14);
		panel_5_4.add(lblTedaviekli_1);
		
		txtHKPTedaviSekli = new JTextField();
		txtHKPTedaviSekli.setColumns(10);
		txtHKPTedaviSekli.setBounds(414, 146, 106, 20);
		panel_5_4.add(txtHKPTedaviSekli);
		
		txtHKPEkg = new JTextField();
		txtHKPEkg.setColumns(10);
		txtHKPEkg.setBounds(414, 115, 106, 20);
		panel_5_4.add(txtHKPEkg);
		
		txtHKPKanGrubu = new JTextField();
		txtHKPKanGrubu.setColumns(10);
		txtHKPKanGrubu.setBounds(414, 79, 106, 20);
		panel_5_4.add(txtHKPKanGrubu);
		
		txtHKPSigortaTuru = new JTextField();
		txtHKPSigortaTuru.setColumns(10);
		txtHKPSigortaTuru.setBounds(683, 15, 99, 20);
		panel_5_4.add(txtHKPSigortaTuru);
		
		JLabel lblSigortaTr_1 = new JLabel("Sigorta Türü");
		lblSigortaTr_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSigortaTr_1.setBounds(549, 16, 124, 17);
		panel_5_4.add(lblSigortaTr_1);
		
		JLabel lblSicilNo_1 = new JLabel("Sicil No");
		lblSicilNo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSicilNo_1.setBounds(549, 41, 124, 14);
		panel_5_4.add(lblSicilNo_1);
		
		JLabel lblRefakatBilgileri_1 = new JLabel("Refakatçı Adı");
		lblRefakatBilgileri_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRefakatBilgileri_1.setBounds(549, 66, 124, 14);
		panel_5_4.add(lblRefakatBilgileri_1);
		
		JLabel lblHKRefDerece_1 = new JLabel("Yakınlık Derecesi");
		lblHKRefDerece_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHKRefDerece_1.setBounds(549, 94, 124, 14);
		panel_5_4.add(lblHKRefDerece_1);
		
		JLabel lblPolikinlik_1 = new JLabel("Polikinlik");
		lblPolikinlik_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPolikinlik_1.setBounds(549, 119, 106, 22);
		panel_5_4.add(lblPolikinlik_1);
		
		txtHKPPolikinlik = new JTextField();
		txtHKPPolikinlik.setColumns(10);
		txtHKPPolikinlik.setBounds(683, 123, 99, 20);
		panel_5_4.add(txtHKPPolikinlik);
		
		txtHKPYakinlikDerecesi = new JTextField();
		txtHKPYakinlikDerecesi.setColumns(10);
		txtHKPYakinlikDerecesi.setBounds(683, 92, 99, 20);
		panel_5_4.add(txtHKPYakinlikDerecesi);
		
		txtHKPRefAdi = new JTextField();
		txtHKPRefAdi.setColumns(10);
		txtHKPRefAdi.setBounds(683, 66, 99, 20);
		panel_5_4.add(txtHKPRefAdi);
		
		txtHKPSicilNo = new JTextField();
		txtHKPSicilNo.setColumns(10);
		txtHKPSicilNo.setBounds(683, 41, 99, 20);
		panel_5_4.add(txtHKPSicilNo);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres.setBounds(10, 187, 124, 14);
		panel_5_4.add(lblAdres);
		
		txtHKPAdres = new JTextField();
		txtHKPAdres.setColumns(10);
		txtHKPAdres.setBounds(144, 185, 233, 20);
		panel_5_4.add(txtHKPAdres);
		
		JLabel lblTedaviekli_1_1 = new JLabel("Telefon");
		lblTedaviekli_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTedaviekli_1_1.setBounds(549, 154, 113, 14);
		panel_5_4.add(lblTedaviekli_1_1);
		
		txtHKPTelefon = new JTextField();
		txtHKPTelefon.setColumns(10);
		txtHKPTelefon.setBounds(683, 154, 99, 20);
		panel_5_4.add(txtHKPTelefon);
		
		JLabel lblSonGncelleme_1_1 = new JLabel("Kullanilan İlaç");
		lblSonGncelleme_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSonGncelleme_1_1.setBounds(414, 187, 124, 14);
		panel_5_4.add(lblSonGncelleme_1_1);
		
		txtHKPKullanilanIlac = new JTextField();
		txtHKPKullanilanIlac.setColumns(10);
		txtHKPKullanilanIlac.setBounds(549, 185, 233, 20);
		panel_5_4.add(txtHKPKullanilanIlac);
		
		JLabel lblHastalkGemii = new JLabel("Hastalık Geçmişi");
		lblHastalkGemii.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHastalkGemii.setBounds(10, 220, 124, 14);
		panel_5_4.add(lblHastalkGemii);
		
		txtHKPHastalikGecmisi = new JTextField();
		txtHKPHastalikGecmisi.setColumns(10);
		txtHKPHastalikGecmisi.setBounds(144, 218, 233, 20);
		panel_5_4.add(txtHKPHastalikGecmisi);
		
		JLabel lblTcKimlik_1_1 = new JLabel("Son Guncelleme");
		lblTcKimlik_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik_1_1.setBounds(414, 222, 124, 14);
		panel_5_4.add(lblTcKimlik_1_1);
		
		txtHKUSonGuncelleme = new JTextField();
		txtHKUSonGuncelleme.setEditable(false);
		txtHKUSonGuncelleme.setColumns(10);
		txtHKUSonGuncelleme.setBounds(548, 220, 234, 20);
		panel_5_4.add(txtHKUSonGuncelleme);
		
		
		JButton btnHKPGuncelle = new JButton("Güncelle");
		btnHKPGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tc=txtHKPTc.getText();
					int reply = JOptionPane.showConfirmDialog(panel_1, ""+tc+" Kimlik numaralı kişiyi güncellemek istiyorsunuz Emin misiniz?", "Emin misiniz?", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						String SqlSil="DELETE FROM public.\"Patient\" WHERE \"Tc\"='"+tc+"';";
						int rs= s.executeUpdate(SqlSil);
						String SqlEkle="INSERT INTO public.\"Patient\"(\"Ad\", \"Tc\", \"DogYer\", \"Cinsiyet\", \"Adres\", \"Telefon\", \"SigortaTuru\", \"SicilNo\", \"RefAdi\", \"RefYakinlik\", \"Boy\", \"Kilo\", \"KanGrubu\", \"Ekg\", \"TedaviSekli\", \"KullanilanIlac\", \"SonGuncelleme\", \"GecmisHastalik\", \"PolId\", \"DogTar\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement prep =c.prepareStatement(SqlEkle);
						prep.setString(1,txtHKPAd.getText());
						prep.setString(2,txtHKPTc.getText());
						prep.setString(3, txtHKPDogYeri.getText());
						prep.setString(4, txtHKPCinsiyet.getText());
						prep.setString(5, txtHKPAdres.getText());
						prep.setString(6, txtHKPTelefon.getText());
						prep.setString(7, txtHKPSigortaTuru.getText());
						prep.setString(8, txtHKPSicilNo.getText());
						prep.setString(9, txtHKPRefAdi.getText());
						prep.setString(10, txtHKPYakinlikDerecesi.getText());
						prep.setInt(11, Integer.parseInt(txtHKPBoy.getText()));
						prep.setInt(12, Integer.parseInt(txtHKPKilo.getText()));
						prep.setString(13, txtHKPKanGrubu.getText());
						prep.setString(14, txtHKPEkg.getText());
						prep.setString(15, txtHKPTedaviSekli.getText());
						prep.setString(16, txtHKPKullanilanIlac.getText());
						prep.setObject(17, dd);
						prep.setObject(18, txtHKPHastalikGecmisi.getText());
						prep.setInt(19,  Integer.parseInt(txtHKPPolikinlik.getText()));
						prep.setInt(20, Integer.parseInt(txtHKPDogYili.getText()));
						int den=prep.executeUpdate();
						if (den==1 && rs==1) {
							JOptionPane.showMessageDialog(panel_1,"Güncelleme Başarılı");
						}else {
							JOptionPane.showMessageDialog(panel_1,"Güncelleme Başarısız");
						}
					}
				} catch (Exception e2) {
					System.out.println("Hata: "+ e2.getMessage());
				}
			}
		});
		btnHKPGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHKPGuncelle.setBounds(340, 286, 123, 27);
		panel_1.add(btnHKPGuncelle);
	}
}
