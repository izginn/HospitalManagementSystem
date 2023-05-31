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

public class PerUpdatePanel extends JFrame {

	private JPanel contentPane;
	private Connection c;
	private Statement s;
	private JTextField txtPUPAd;
	private JTextField txtPUPTc;
	private JTextField txtPUPDogYili;
	private JTextField txtPUPDogYeri;
	private JTextField txtPUPTelefon;
	private JTextField txtPUPMail;
	private JTextField txtPUPTopIzin;
	private JTextField txtPUPCalSaati;
	private JTextField txtPUPCinsiyet;
	private JTextField txtPUPGorevTanimi;
	private JTextField txtPUPAdres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerUpdatePanel frame = new PerUpdatePanel();
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
		    String GelenSql="SELECT \"Ad\", \"Tc\", \"DogYer\", \"Cinsiyet\", \"Adres\", \"Telefon\", \"Mail\", \"ToplamIzin\", \"CalSaati\", \"GorevId\", \"DogYil\" FROM public.\"Personel\" where \"Ad\"='"+Gelveri+"';";
		    ResultSet rs=s.executeQuery(GelenSql);
		    while(rs.next()) {
		    	txtPUPAd.setText(rs.getString("Ad"));
		    	txtPUPAdres.setText(rs.getString("Adres"));
		    	txtPUPCalSaati.setText(rs.getString("CalSaati"));
		    	txtPUPCinsiyet.setText(rs.getString("Cinsiyet"));
		    	txtPUPDogYeri.setText(rs.getString("DogYer"));
		    	txtPUPDogYili.setText(String.valueOf(rs.getInt("DogYil")));
		    	txtPUPGorevTanimi.setText(String.valueOf(rs.getInt("GorevId")));
		    	txtPUPMail.setText(rs.getString("Mail"));
		    	txtPUPTc.setText(rs.getString("Tc"));
		    	txtPUPTelefon.setText(rs.getString("Telefon"));
		    	txtPUPTopIzin.setText(String.valueOf(rs.getInt("ToplamIzin")));
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
	public PerUpdatePanel() {
		setTitle("Personel Güncelle");
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 808, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 802, 376);
		contentPane.add(panel_3);
		
		JPanel panel_5_4_2 = new JPanel();
		panel_5_4_2.setLayout(null);
		panel_5_4_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kimlik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4_2.setBounds(0, 0, 407, 182);
		panel_3.add(panel_5_4_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ad Soyad");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(10, 25, 124, 14);
		panel_5_4_2.add(lblNewLabel_1_2);
		
		JLabel lblTcKimlik_1_2 = new JLabel("T.C. Kimlik Numarası");
		lblTcKimlik_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik_1_2.setBounds(10, 55, 124, 14);
		panel_5_4_2.add(lblTcKimlik_1_2);
		
		JLabel lblDoumTarihi_1_2 = new JLabel("Doğum Yılı");
		lblDoumTarihi_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumTarihi_1_2.setBounds(10, 85, 124, 22);
		panel_5_4_2.add(lblDoumTarihi_1_2);
		
		JLabel lblDoumYeri_1_2 = new JLabel("Doğum Yeri");
		lblDoumYeri_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri_1_2.setBounds(10, 115, 124, 17);
		panel_5_4_2.add(lblDoumYeri_1_2);
		
		JLabel lblCinsiyeti_1_1 = new JLabel("Cinsiyeti");
		lblCinsiyeti_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCinsiyeti_1_1.setBounds(10, 145, 124, 14);
		panel_5_4_2.add(lblCinsiyeti_1_1);
		
		txtPUPAd = new JTextField();
		txtPUPAd.setColumns(10);
		txtPUPAd.setBounds(144, 23, 179, 20);
		panel_5_4_2.add(txtPUPAd);
		
		txtPUPTc = new JTextField();
		txtPUPTc.setEnabled(false);
		txtPUPTc.setEditable(false);
		txtPUPTc.setColumns(10);
		txtPUPTc.setBounds(144, 55, 179, 20);
		panel_5_4_2.add(txtPUPTc);
		
		txtPUPDogYili = new JTextField();
		txtPUPDogYili.setColumns(10);
		txtPUPDogYili.setBounds(144, 85, 179, 20);
		panel_5_4_2.add(txtPUPDogYili);
		
		txtPUPDogYeri = new JTextField();
		txtPUPDogYeri.setColumns(10);
		txtPUPDogYeri.setBounds(144, 115, 179, 20);
		panel_5_4_2.add(txtPUPDogYeri);
		
		txtPUPCinsiyet = new JTextField();
		txtPUPCinsiyet.setColumns(10);
		txtPUPCinsiyet.setBounds(144, 143, 179, 20);
		panel_5_4_2.add(txtPUPCinsiyet);
		
		JPanel panel_5_6_1 = new JPanel();
		panel_5_6_1.setLayout(null);
		panel_5_6_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_6_1.setBounds(405, 0, 390, 182);
		panel_3.add(panel_5_6_1);
		
		JLabel lblAdres_1_1 = new JLabel("Adres");
		lblAdres_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres_1_1.setBounds(10, 25, 124, 14);
		panel_5_6_1.add(lblAdres_1_1);
		
		JLabel lblTelefonNumaras_1_2 = new JLabel("Telefon No");
		lblTelefonNumaras_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras_1_2.setBounds(10, 79, 85, 22);
		panel_5_6_1.add(lblTelefonNumaras_1_2);
		
		txtPUPTelefon = new JTextField();
		txtPUPTelefon.setColumns(10);
		txtPUPTelefon.setBounds(105, 81, 179, 20);
		panel_5_6_1.add(txtPUPTelefon);
		
		JLabel lblTelefonNumaras_1_1_1 = new JLabel("E Mail");
		lblTelefonNumaras_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras_1_1_1.setBounds(10, 145, 85, 22);
		panel_5_6_1.add(lblTelefonNumaras_1_1_1);
		
		txtPUPMail = new JTextField();
		txtPUPMail.setColumns(10);
		txtPUPMail.setBounds(105, 147, 179, 20);
		panel_5_6_1.add(txtPUPMail);
		
		txtPUPAdres = new JTextField();
		txtPUPAdres.setColumns(10);
		txtPUPAdres.setBounds(105, 25, 179, 20);
		panel_5_6_1.add(txtPUPAdres);
		
		JPanel panel_5_3_1_1 = new JPanel();
		panel_5_3_1_1.setLayout(null);
		panel_5_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130\u015F Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_3_1_1.setBounds(0, 182, 792, 109);
		panel_3.add(panel_5_3_1_1);
		
		JLabel lblizin_1 = new JLabel("Toplam İzin Günü");
		lblizin_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblizin_1.setBounds(10, 43, 137, 14);
		panel_5_3_1_1.add(lblizin_1);
		
		txtPUPTopIzin = new JTextField();
		txtPUPTopIzin.setColumns(10);
		txtPUPTopIzin.setBounds(158, 41, 106, 20);
		panel_5_3_1_1.add(txtPUPTopIzin);
		
		JLabel lblIzinKullan_1_1 = new JLabel("Çalışma Saatleri");
		lblIzinKullan_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzinKullan_1_1.setBounds(568, 43, 100, 14);
		panel_5_3_1_1.add(lblIzinKullan_1_1);
		
		txtPUPCalSaati = new JTextField();
		txtPUPCalSaati.setColumns(10);
		txtPUPCalSaati.setBounds(678, 38, 106, 20);
		panel_5_3_1_1.add(txtPUPCalSaati);
		
		JLabel lblKullanlabilirIzinGn_1_1 = new JLabel("Görev Tanımı");
		lblKullanlabilirIzinGn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullanlabilirIzinGn_1_1.setBounds(303, 43, 100, 14);
		panel_5_3_1_1.add(lblKullanlabilirIzinGn_1_1);
		
		txtPUPGorevTanimi = new JTextField();
		txtPUPGorevTanimi.setColumns(10);
		txtPUPGorevTanimi.setBounds(411, 41, 106, 20);
		panel_5_3_1_1.add(txtPUPGorevTanimi);
		
		JButton btnHKPGuncelle = new JButton("Güncelle");
		btnHKPGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc=txtPUPTc.getText();
				try {
					int reply = JOptionPane.showConfirmDialog(panel_3, ""+tc+" Kimlik numaralı kişiyi güncellemek istiyorsunuz Emin misiniz?", "Emin misiniz?", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						String SqlSil="DELETE FROM public.\"Personel\" WHERE \"Tc\"='"+tc+"';";
						int rs= s.executeUpdate(SqlSil);
						String SqlEkle="INSERT INTO public.\"Personel\"(\"Ad\", \"Tc\", \"DogYer\", \"Cinsiyet\", \"Adres\", \"Telefon\", \"Mail\", \"ToplamIzin\", \"CalSaati\", \"GorevId\", \"DogYil\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
						PreparedStatement prep =c.prepareStatement(SqlEkle);
						prep.setString(1,txtPUPAd.getText());
						prep.setString(2,txtPUPTc.getText());
						prep.setString(3, txtPUPDogYeri.getText());
						prep.setString(4, txtPUPCinsiyet.getText());
						prep.setString(5, txtPUPAdres.getText());
						prep.setString(6, txtPUPTelefon.getText());
						prep.setString(7, txtPUPMail.getText());
						prep.setInt(8, Integer.parseInt(txtPUPTopIzin.getText()));
						prep.setString(9, txtPUPCalSaati.getText());
						prep.setInt(10,Integer.parseInt(txtPUPGorevTanimi.getText()));
						prep.setInt(11, Integer.parseInt(txtPUPDogYili.getText()));
						int den=prep.executeUpdate();
						if (den==1 && rs==1) {
							JOptionPane.showMessageDialog(panel_3,"Güncelleme Başarılı");
						}else {
							JOptionPane.showMessageDialog(panel_3,"Güncelleme Başarısız");
						}
					}
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		btnHKPGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHKPGuncelle.setBounds(331, 302, 123, 27);
		panel_3.add(btnHKPGuncelle);
	}

}
