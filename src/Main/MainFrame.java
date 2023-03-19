package Main;

import java.awt.EventQueue;
import com.toedter.calendar.JDateChooser;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.border.CompoundBorder;
import javax.swing.JList;
import javax.swing.JFormattedTextField;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDateChooser dcRSALTarih;
	private JTextField txtHKAdSoyad;
	private JTextField txtHKTcNo;
	private JTextField txtHKDogumTar;
	private JTextField txtHKDogumYeri;
	private JTextField txtHKTel;
	private JTextField txtHkSicil;
	private JTextField txtHKRefAdi;
	private JTextField txtHKYakinlik;
	private JTextField txtHKYas;
	private JTextField txtHKBoy;
	private JTextField txtHKKilo;
	private JTextField txtHKUpdateTarih;
	private JTextField txtHKEkg;
	private ButtonGroup bg = new ButtonGroup();
	private ButtonGroup bg2 = new ButtonGroup();
	private JTextField txtDKAdSoyad;
	private JTextField txtDkTc;
	private JTextField txtDKDogTar;
	private JTextField txtDKDogYeri;
	private JTextField txtDKLisans;
	private JTextField txtDKYLisans;
	private JTextField txtDKDoktora;
	private JTextField txtDKAlan;
	private JTextField txtDKTel;
	private JTextField txtDKMail;
	private JTextField txtRSAlDokAdi;
	private JTextField txtRSALHastaTc;
	private JTextField txtDKTotalIzin;
	private JTextField txtDKKullanIzin;
	private JTextField txtDKKullanilmisIzin;
	private JTextField txtDKIzinKullan;
	private JTextField txtDKCalSaatleri;
	private JTextField txtRSALRanKodu;
	private JTextField txtRSGRTc;
	private JTextField txtRSGRDokAdi;
	private JTextField txtRSGRPolik;
	private JTextField txtRSGRTarih;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtAShastaAdi;
	private JTextField txtASsuur;
	private JTextField txtASates;
	private JTextField txtASnabiz;
	private JTextField txtASekg;
	private JTextField txtAShkodu;
	private JTextField textField_3;
	private JTextField txtPKadsoyad;
	private JTextField txtPKtc;
	private JTextField txtPKDogTar;
	private JTextField txtPKDogYer;
	private JTextField txtPKTel;
	private JTextField txtPKMail;
	private JTextField txtPKTotalIzin;
	private JTextField txtPKkullanIzin;
	private JTextField txtPKKullanilmisIzin;
	private JTextField txtPKIzinKullan;
	private JTextField txtPKCalSaatleri;
	private JTextField textField_19;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Hastane Otomasyon Sistemi");
		setBounds(100, 100, 1019, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1005, 404);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1000, 376);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hasta Kayıt", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kimlik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(185, 0, 270, 167);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad Soyad");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 25, 124, 14);
		panel_5.add(lblNewLabel);
		
		JLabel lblTcKimlik = new JLabel("T.C. Kimlik Numarası");
		lblTcKimlik.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik.setBounds(10, 50, 124, 14);
		panel_5.add(lblTcKimlik);
		
		JLabel lblDoumTarihi = new JLabel("Doğum Tarihi");
		lblDoumTarihi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumTarihi.setBounds(10, 75, 124, 17);
		panel_5.add(lblDoumTarihi);
		
		JLabel lblDoumYeri = new JLabel("Doğum Yeri");
		lblDoumYeri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri.setBounds(10, 100, 124, 15);
		panel_5.add(lblDoumYeri);
		
		JLabel lblCinsiyeti = new JLabel("Cinsiyeti");
		lblCinsiyeti.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCinsiyeti.setBounds(10, 125, 124, 14);
		panel_5.add(lblCinsiyeti);
		
		JComboBox cboxHKCinsiyet = new JComboBox();
		cboxHKCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Bilinmiyor", "Erkek", "Kadın"}));
		cboxHKCinsiyet.setBounds(144, 125, 106, 22);
		panel_5.add(cboxHKCinsiyet);
		
		txtHKAdSoyad = new JTextField();
		txtHKAdSoyad.setBounds(144, 23, 106, 20);
		panel_5.add(txtHKAdSoyad);
		txtHKAdSoyad.setColumns(10);
		
		txtHKTcNo = new JTextField();
		txtHKTcNo.setColumns(10);
		txtHKTcNo.setBounds(144, 50, 106, 20);
		panel_5.add(txtHKTcNo);
		
		txtHKDogumTar = new JTextField();
		txtHKDogumTar.setColumns(10);
		txtHKDogumTar.setBounds(144, 75, 106, 20);
		panel_5.add(txtHKDogumTar);
		
		txtHKDogumYeri = new JTextField();
		txtHKDogumYeri.setColumns(10);
		txtHKDogumYeri.setBounds(144, 100, 106, 20);
		panel_5.add(txtHKDogumYeri);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hasta Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_2.setBounds(724, 0, 270, 167);
		panel_1.add(panel_5_2);
		panel_5_2.setLayout(null);
		
		JLabel lblSigortaTr = new JLabel("Sigorta Türü");
		lblSigortaTr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSigortaTr.setBounds(10, 25, 124, 17);
		panel_5_2.add(lblSigortaTr);
		
		JLabel lblSicilNo = new JLabel("Sicil No");
		lblSicilNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSicilNo.setBounds(10, 58, 124, 14);
		panel_5_2.add(lblSicilNo);
		
		txtHkSicil = new JTextField();
		txtHkSicil.setColumns(10);
		txtHkSicil.setBounds(144, 58, 106, 20);
		panel_5_2.add(txtHkSicil);
		
		JComboBox cboxHKSigTur = new JComboBox();
		cboxHKSigTur.setModel(new DefaultComboBoxModel(new String[] {"Bilinmiyor", "SGK", "BAĞKUR"}));
		cboxHKSigTur.setBounds(144, 22, 106, 22);
		panel_5_2.add(cboxHKSigTur);
		
		JLabel lblRefakatBilgileri = new JLabel("Refakatçı Adı");
		lblRefakatBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRefakatBilgileri.setBounds(10, 91, 124, 14);
		panel_5_2.add(lblRefakatBilgileri);
		
		txtHKRefAdi = new JTextField();
		txtHKRefAdi.setColumns(10);
		txtHKRefAdi.setBounds(144, 91, 106, 20);
		panel_5_2.add(txtHKRefAdi);
		
		JLabel lblHKRefDerece = new JLabel("Yakınlık Derecesi");
		lblHKRefDerece.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHKRefDerece.setBounds(10, 125, 124, 14);
		panel_5_2.add(lblHKRefDerece);
		
		txtHKYakinlik = new JTextField();
		txtHKYakinlik.setColumns(10);
		txtHKYakinlik.setBounds(144, 120, 106, 20);
		panel_5_2.add(txtHKYakinlik);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1.setBounds(455, 0, 270, 167);
		panel_1.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres.setBounds(10, 25, 124, 14);
		panel_5_1.add(lblAdres);
		
		JLabel lblTelefonNumaras = new JLabel("Telefon No");
		lblTelefonNumaras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras.setBounds(10, 125, 85, 22);
		panel_5_1.add(lblTelefonNumaras);
		
		txtHKTel = new JTextField();
		txtHKTel.setColumns(10);
		txtHKTel.setBounds(105, 125, 145, 20);
		panel_5_1.add(txtHKTel);
		
		JTextArea txtHKAdres = new JTextArea();
		txtHKAdres.setBounds(105, 26, 145, 80);
		panel_5_1.add(txtHKAdres);
		
		JPanel panel_5_3 = new JPanel();
		panel_5_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hastal\u0131k Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_3.setBounds(185, 167, 815, 160);
		panel_1.add(panel_5_3);
		panel_5_3.setLayout(null);
		
		JLabel lblYas = new JLabel("Yaş");
		lblYas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYas.setBounds(10, 25, 124, 14);
		panel_5_3.add(lblYas);
		
		txtHKYas = new JTextField();
		txtHKYas.setColumns(10);
		txtHKYas.setBounds(144, 23, 106, 20);
		panel_5_3.add(txtHKYas);
		
		JLabel lblBoy = new JLabel("Boy");
		lblBoy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBoy.setBounds(10, 50, 124, 14);
		panel_5_3.add(lblBoy);
		
		txtHKBoy = new JTextField();
		txtHKBoy.setColumns(10);
		txtHKBoy.setBounds(144, 50, 106, 20);
		panel_5_3.add(txtHKBoy);
		
		JLabel lblKilo = new JLabel("Kilo");
		lblKilo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKilo.setBounds(10, 75, 124, 14);
		panel_5_3.add(lblKilo);
		
		txtHKKilo = new JTextField();
		txtHKKilo.setColumns(10);
		txtHKKilo.setBounds(144, 75, 106, 20);
		panel_5_3.add(txtHKKilo);
		
		JLabel lblEkg = new JLabel("Kan Grubu");
		lblEkg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEkg.setBounds(10, 100, 124, 14);
		panel_5_3.add(lblEkg);
		
		JLabel lblSonGncelleme = new JLabel("Son Güncelleme");
		lblSonGncelleme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSonGncelleme.setBounds(553, 25, 124, 14);
		panel_5_3.add(lblSonGncelleme);
		
		txtHKUpdateTarih = new JTextField();
		txtHKUpdateTarih.setEditable(false);
		txtHKUpdateTarih.setColumns(10);
		txtHKUpdateTarih.setBounds(687, 25, 106, 20);
		panel_5_3.add(txtHKUpdateTarih);
		
		JLabel lblEkg_1 = new JLabel("EKG");
		lblEkg_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEkg_1.setBounds(10, 125, 124, 14);
		panel_5_3.add(lblEkg_1);
		
		txtHKEkg = new JTextField();
		txtHKEkg.setColumns(10);
		txtHKEkg.setBounds(144, 125, 106, 20);
		panel_5_3.add(txtHKEkg);
		
		JLabel lblHKGecmisHastalklar = new JLabel("Geçmiş Hastalıklar");
		lblHKGecmisHastalklar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHKGecmisHastalklar.setBounds(553, 70, 124, 14);
		panel_5_3.add(lblHKGecmisHastalklar);
		
		JTextArea txtHKHastaliklar = new JTextArea();
		txtHKHastaliklar.setBounds(553, 94, 240, 45);
		panel_5_3.add(txtHKHastaliklar);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Tedavi \u015Eekli", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(284, 17, 240, 52);
		panel_5_3.add(panel_6);
		
		JRadioButton rdbtnAyakta = new JRadioButton("Ayakta");
		
		JRadioButton rdbtnYatarak = new JRadioButton("Yatarak");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(rdbtnAyakta, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(rdbtnYatarak, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnAyakta)
						.addComponent(rdbtnYatarak)))
		);
		bg.add(rdbtnYatarak);
		bg.add(rdbtnAyakta);
		panel_6.setLayout(gl_panel_6);
		
		JComboBox cboxHKKanGrub = new JComboBox();
		cboxHKKanGrub.setModel(new DefaultComboBoxModel(new String[] {"Bilinmiyor", "A+", "A-", "B+", "B-", "AB+", "AB-", "0+", "0-"}));
		cboxHKKanGrub.setBounds(144, 100, 106, 22);
		panel_5_3.add(cboxHKKanGrub);
		
		JLabel lblKullandIlalar = new JLabel("Kullandığı İlaçlar");
		lblKullandIlalar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullandIlalar.setBounds(284, 70, 124, 17);
		panel_5_3.add(lblKullandIlalar);
		
		JTextArea txtHKilaclar = new JTextArea();
		txtHKilaclar.setBounds(284, 94, 240, 45);
		panel_5_3.add(txtHKilaclar);
		
		JButton btnGuncelleHasta = new JButton("Güncelle");
		btnGuncelleHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuncelleHasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuncelleHasta.setBounds(642, 338, 123, 27);
		panel_1.add(btnGuncelleHasta);
		
		JButton btnKaydetHasta = new JButton("Kaydet");
		btnKaydetHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnKaydetHasta.setBounds(443, 338, 123, 27);
		panel_1.add(btnKaydetHasta);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 0, 188, 376);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		
		JButton btnHasAra_1_1 = new JButton("Ara");
		btnHasAra_1_1.setBounds(95, 0, 88, 23);
		panel_8.add(btnHasAra_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 0, 100, 23);
		panel_8.add(textField);
		
		JTree tree_1_2 = new JTree();
		tree_1_2.setBounds(0, 22, 188, 355);
		panel_8.add(tree_1_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Doktor Kayıt", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_5_4 = new JPanel();
		panel_5_4.setLayout(null);
		panel_5_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kimlik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4.setBounds(185, 0, 270, 182);
		panel_3.add(panel_5_4);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 25, 124, 14);
		panel_5_4.add(lblNewLabel_1);
		
		JLabel lblTcKimlik_1 = new JLabel("T.C. Kimlik Numarası");
		lblTcKimlik_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik_1.setBounds(10, 55, 124, 14);
		panel_5_4.add(lblTcKimlik_1);
		
		JLabel lblDoumTarihi_1 = new JLabel("Doğum Tarihi");
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
		
		JComboBox cboxDKCinsiyet = new JComboBox();
		cboxDKCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Bilinmiyor", "Erkek", "Kadın"}));
		cboxDKCinsiyet.setBounds(144, 145, 106, 22);
		panel_5_4.add(cboxDKCinsiyet);
		
		txtDKAdSoyad = new JTextField();
		txtDKAdSoyad.setColumns(10);
		txtDKAdSoyad.setBounds(144, 23, 106, 20);
		panel_5_4.add(txtDKAdSoyad);
		
		txtDkTc = new JTextField();
		txtDkTc.setColumns(10);
		txtDkTc.setBounds(144, 55, 106, 20);
		panel_5_4.add(txtDkTc);
		
		txtDKDogTar = new JTextField();
		txtDKDogTar.setColumns(10);
		txtDKDogTar.setBounds(144, 85, 106, 20);
		panel_5_4.add(txtDKDogTar);
		
		txtDKDogYeri = new JTextField();
		txtDKDogYeri.setColumns(10);
		txtDKDogYeri.setBounds(144, 115, 106, 20);
		panel_5_4.add(txtDKDogYeri);
		
		JPanel panel_5_5 = new JPanel();
		panel_5_5.setLayout(null);
		panel_5_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Akademik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_5.setBounds(455, 0, 270, 182);
		panel_3.add(panel_5_5);
		
		JLabel lblNewLabel_2 = new JLabel("Lisans");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 25, 124, 14);
		panel_5_5.add(lblNewLabel_2);
		
		JLabel lblTcKimlik_2 = new JLabel("Yüksek Lisans");
		lblTcKimlik_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik_2.setBounds(10, 65, 124, 14);
		panel_5_5.add(lblTcKimlik_2);
		
		JLabel lblDoumTarihi_2 = new JLabel("Doktora");
		lblDoumTarihi_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumTarihi_2.setBounds(10, 105, 124, 22);
		panel_5_5.add(lblDoumTarihi_2);
		
		JLabel lblDoumYeri_2 = new JLabel("Alanı");
		lblDoumYeri_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri_2.setBounds(10, 145, 124, 22);
		panel_5_5.add(lblDoumYeri_2);
		
		txtDKLisans = new JTextField();
		txtDKLisans.setColumns(10);
		txtDKLisans.setBounds(144, 23, 106, 20);
		panel_5_5.add(txtDKLisans);
		
		txtDKYLisans = new JTextField();
		txtDKYLisans.setColumns(10);
		txtDKYLisans.setBounds(144, 65, 106, 20);
		panel_5_5.add(txtDKYLisans);
		
		txtDKDoktora = new JTextField();
		txtDKDoktora.setColumns(10);
		txtDKDoktora.setBounds(144, 105, 106, 20);
		panel_5_5.add(txtDKDoktora);
		
		txtDKAlan = new JTextField();
		txtDKAlan.setColumns(10);
		txtDKAlan.setBounds(144, 145, 106, 20);
		panel_5_5.add(txtDKAlan);
		
		JPanel panel_5_6 = new JPanel();
		panel_5_6.setLayout(null);
		panel_5_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_6.setBounds(724, 0, 270, 182);
		panel_3.add(panel_5_6);
		
		JLabel lblAdres_1 = new JLabel("Adres");
		lblAdres_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres_1.setBounds(10, 25, 124, 14);
		panel_5_6.add(lblAdres_1);
		
		JTextArea txtDKAdres = new JTextArea();
		txtDKAdres.setBounds(105, 25, 145, 68);
		panel_5_6.add(txtDKAdres);
		
		JLabel lblTelefonNumaras_1 = new JLabel("Telefon No");
		lblTelefonNumaras_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras_1.setBounds(10, 102, 85, 22);
		panel_5_6.add(lblTelefonNumaras_1);
		
		txtDKTel = new JTextField();
		txtDKTel.setColumns(10);
		txtDKTel.setBounds(105, 104, 145, 20);
		panel_5_6.add(txtDKTel);
		
		JLabel lblTelefonNumaras_1_1 = new JLabel("E Mail");
		lblTelefonNumaras_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras_1_1.setBounds(10, 145, 85, 22);
		panel_5_6.add(lblTelefonNumaras_1_1);
		
		txtDKMail = new JTextField();
		txtDKMail.setColumns(10);
		txtDKMail.setBounds(105, 147, 145, 20);
		panel_5_6.add(txtDKMail);
		
		JButton btnKaydetDoktor = new JButton("Kaydet");
		btnKaydetDoktor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnKaydetDoktor.setBounds(415, 338, 123, 27);
		panel_3.add(btnKaydetDoktor);
		
		JButton btnGncelleDoktor = new JButton("Güncelle");
		btnGncelleDoktor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGncelleDoktor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGncelleDoktor.setBounds(665, 338, 123, 27);
		panel_3.add(btnGncelleDoktor);
		
		JPanel panel_5_3_1 = new JPanel();
		panel_5_3_1.setLayout(null);
		panel_5_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130\u015F Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_3_1.setBounds(185, 181, 815, 149);
		panel_3.add(panel_5_3_1);
		
		JLabel lblizin = new JLabel("Toplam İzin Günü");
		lblizin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblizin.setBounds(10, 25, 137, 14);
		panel_5_3_1.add(lblizin);
		
		JLabel lblKullanlabilirIzinGn = new JLabel("Kullanılabilir İzin Günü");
		lblKullanlabilirIzinGn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullanlabilirIzinGn.setBounds(10, 64, 137, 14);
		panel_5_3_1.add(lblKullanlabilirIzinGn);
		
		JLabel lblKullanlmIzinGn = new JLabel("Kullanılmış İzin Günü");
		lblKullanlmIzinGn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullanlmIzinGn.setBounds(305, 25, 137, 14);
		panel_5_3_1.add(lblKullanlmIzinGn);
		
		txtDKTotalIzin = new JTextField();
		txtDKTotalIzin.setColumns(10);
		txtDKTotalIzin.setBounds(158, 23, 106, 20);
		panel_5_3_1.add(txtDKTotalIzin);
		
		txtDKKullanIzin = new JTextField();
		txtDKKullanIzin.setEditable(false);
		txtDKKullanIzin.setColumns(10);
		txtDKKullanIzin.setBounds(157, 62, 106, 20);
		panel_5_3_1.add(txtDKKullanIzin);
		
		txtDKKullanilmisIzin = new JTextField();
		txtDKKullanilmisIzin.setEditable(false);
		txtDKKullanilmisIzin.setColumns(10);
		txtDKKullanilmisIzin.setBounds(452, 23, 106, 20);
		panel_5_3_1.add(txtDKKullanilmisIzin);
		
		JLabel lblIzinKullan = new JLabel("İzin Kullan");
		lblIzinKullan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzinKullan.setBounds(305, 65, 137, 14);
		panel_5_3_1.add(lblIzinKullan);
		
		txtDKIzinKullan = new JTextField();
		txtDKIzinKullan.setColumns(10);
		txtDKIzinKullan.setBounds(452, 62, 106, 20);
		panel_5_3_1.add(txtDKIzinKullan);
		
		JButton btnDKIzinKullan = new JButton("İzin Kullan");
		btnDKIzinKullan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDKIzinKullan.setBounds(345, 111, 123, 27);
		panel_5_3_1.add(btnDKIzinKullan);
		
		JLabel lblIzinKullan_1 = new JLabel("Çalışma Saatleri");
		lblIzinKullan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzinKullan_1.setBounds(568, 25, 100, 14);
		panel_5_3_1.add(lblIzinKullan_1);
		
		txtDKCalSaatleri = new JTextField();
		txtDKCalSaatleri.setColumns(10);
		txtDKCalSaatleri.setBounds(678, 20, 106, 20);
		panel_5_3_1.add(txtDKCalSaatleri);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setLayout(null);
		panel_8_1.setBounds(0, 0, 188, 376);
		panel_3.add(panel_8_1);
		
		JButton btnHasAra_1_1_1 = new JButton("Ara");
		btnHasAra_1_1_1.setBounds(95, 0, 88, 23);
		panel_8_1.add(btnHasAra_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(0, 0, 100, 23);
		panel_8_1.add(textField_1);
		
		JTree tree_1_2_1 = new JTree();
		tree_1_2_1.setBounds(0, 22, 188, 355);
		panel_8_1.add(tree_1_2_1);
		
		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("Personel Kayıt", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(0, 0, 1000, 376);
		panel_9.add(panel_3_1);
		
		JPanel panel_5_4_2 = new JPanel();
		panel_5_4_2.setLayout(null);
		panel_5_4_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kimlik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4_2.setBounds(185, 0, 407, 182);
		panel_3_1.add(panel_5_4_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ad Soyad");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(10, 25, 124, 14);
		panel_5_4_2.add(lblNewLabel_1_2);
		
		JLabel lblTcKimlik_1_2 = new JLabel("T.C. Kimlik Numarası");
		lblTcKimlik_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik_1_2.setBounds(10, 55, 124, 14);
		panel_5_4_2.add(lblTcKimlik_1_2);
		
		JLabel lblDoumTarihi_1_2 = new JLabel("Doğum Tarihi");
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
		
		JComboBox cboxPKCinsiyet = new JComboBox();
		cboxPKCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Bilinmiyor", "Erkek", "Kadın"}));
		cboxPKCinsiyet.setBounds(144, 145, 179, 22);
		panel_5_4_2.add(cboxPKCinsiyet);
		
		txtPKadsoyad = new JTextField();
		txtPKadsoyad.setColumns(10);
		txtPKadsoyad.setBounds(144, 23, 179, 20);
		panel_5_4_2.add(txtPKadsoyad);
		
		txtPKtc = new JTextField();
		txtPKtc.setColumns(10);
		txtPKtc.setBounds(144, 55, 179, 20);
		panel_5_4_2.add(txtPKtc);
		
		txtPKDogTar = new JTextField();
		txtPKDogTar.setColumns(10);
		txtPKDogTar.setBounds(144, 85, 179, 20);
		panel_5_4_2.add(txtPKDogTar);
		
		txtPKDogYer = new JTextField();
		txtPKDogYer.setColumns(10);
		txtPKDogYer.setBounds(144, 115, 179, 20);
		panel_5_4_2.add(txtPKDogYer);
		
		JPanel panel_5_6_1 = new JPanel();
		panel_5_6_1.setLayout(null);
		panel_5_6_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_6_1.setBounds(590, 0, 407, 182);
		panel_3_1.add(panel_5_6_1);
		
		JLabel lblAdres_1_1 = new JLabel("Adres");
		lblAdres_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres_1_1.setBounds(10, 25, 124, 14);
		panel_5_6_1.add(lblAdres_1_1);
		
		JTextArea txtPKAdres = new JTextArea();
		txtPKAdres.setBounds(105, 25, 179, 68);
		panel_5_6_1.add(txtPKAdres);
		
		JLabel lblTelefonNumaras_1_2 = new JLabel("Telefon No");
		lblTelefonNumaras_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras_1_2.setBounds(10, 102, 85, 22);
		panel_5_6_1.add(lblTelefonNumaras_1_2);
		
		txtPKTel = new JTextField();
		txtPKTel.setColumns(10);
		txtPKTel.setBounds(105, 104, 179, 20);
		panel_5_6_1.add(txtPKTel);
		
		JLabel lblTelefonNumaras_1_1_1 = new JLabel("E Mail");
		lblTelefonNumaras_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras_1_1_1.setBounds(10, 145, 85, 22);
		panel_5_6_1.add(lblTelefonNumaras_1_1_1);
		
		txtPKMail = new JTextField();
		txtPKMail.setColumns(10);
		txtPKMail.setBounds(105, 147, 179, 20);
		panel_5_6_1.add(txtPKMail);
		
		JButton btnPKKaydet = new JButton("Kaydet");
		btnPKKaydet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPKKaydet.setBounds(415, 338, 123, 27);
		panel_3_1.add(btnPKKaydet);
		
		JButton btnPKGuncelle = new JButton("Güncelle");
		btnPKGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPKGuncelle.setBounds(665, 338, 123, 27);
		panel_3_1.add(btnPKGuncelle);
		
		JPanel panel_5_3_1_1 = new JPanel();
		panel_5_3_1_1.setLayout(null);
		panel_5_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130\u015F Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_3_1_1.setBounds(185, 181, 815, 149);
		panel_3_1.add(panel_5_3_1_1);
		
		JLabel lblizin_1 = new JLabel("Toplam İzin Günü");
		lblizin_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblizin_1.setBounds(10, 25, 137, 14);
		panel_5_3_1_1.add(lblizin_1);
		
		JLabel lblKullanlabilirIzinGn_1 = new JLabel("Kullanılabilir İzin Günü");
		lblKullanlabilirIzinGn_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullanlabilirIzinGn_1.setBounds(10, 64, 137, 14);
		panel_5_3_1_1.add(lblKullanlabilirIzinGn_1);
		
		JLabel lblKullanlmIzinGn_1 = new JLabel("Kullanılmış İzin Günü");
		lblKullanlmIzinGn_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullanlmIzinGn_1.setBounds(305, 25, 137, 14);
		panel_5_3_1_1.add(lblKullanlmIzinGn_1);
		
		txtPKTotalIzin = new JTextField();
		txtPKTotalIzin.setColumns(10);
		txtPKTotalIzin.setBounds(158, 23, 106, 20);
		panel_5_3_1_1.add(txtPKTotalIzin);
		
		txtPKkullanIzin = new JTextField();
		txtPKkullanIzin.setEditable(false);
		txtPKkullanIzin.setColumns(10);
		txtPKkullanIzin.setBounds(157, 62, 106, 20);
		panel_5_3_1_1.add(txtPKkullanIzin);
		
		txtPKKullanilmisIzin = new JTextField();
		txtPKKullanilmisIzin.setEditable(false);
		txtPKKullanilmisIzin.setColumns(10);
		txtPKKullanilmisIzin.setBounds(452, 23, 106, 20);
		panel_5_3_1_1.add(txtPKKullanilmisIzin);
		
		JLabel lblIzinKullan_2 = new JLabel("İzin Kullan");
		lblIzinKullan_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzinKullan_2.setBounds(305, 65, 137, 14);
		panel_5_3_1_1.add(lblIzinKullan_2);
		
		txtPKIzinKullan = new JTextField();
		txtPKIzinKullan.setColumns(10);
		txtPKIzinKullan.setBounds(452, 62, 106, 20);
		panel_5_3_1_1.add(txtPKIzinKullan);
		
		JButton btnPKIzinKullan = new JButton("İzin Kullan");
		btnPKIzinKullan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPKIzinKullan.setBounds(345, 111, 123, 27);
		panel_5_3_1_1.add(btnPKIzinKullan);
		
		JLabel lblIzinKullan_1_1 = new JLabel("Çalışma Saatleri");
		lblIzinKullan_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzinKullan_1_1.setBounds(568, 25, 100, 14);
		panel_5_3_1_1.add(lblIzinKullan_1_1);
		
		txtPKCalSaatleri = new JTextField();
		txtPKCalSaatleri.setColumns(10);
		txtPKCalSaatleri.setBounds(678, 20, 106, 20);
		panel_5_3_1_1.add(txtPKCalSaatleri);
		
		JPanel panel_8_1_1 = new JPanel();
		panel_8_1_1.setLayout(null);
		panel_8_1_1.setBounds(0, 0, 188, 376);
		panel_3_1.add(panel_8_1_1);
		
		JButton btnHasAra_1_1_1_1 = new JButton("Ara");
		btnHasAra_1_1_1_1.setBounds(95, 0, 88, 23);
		panel_8_1_1.add(btnHasAra_1_1_1_1);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(0, 0, 100, 23);
		panel_8_1_1.add(textField_19);
		
		JTree tree_1_2_1_1 = new JTree();
		tree_1_2_1_1.setBounds(0, 22, 188, 355);
		panel_8_1_1.add(tree_1_2_1_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Randevu Sistemi", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(185, 0, 815, 376);
		panel_4.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JPanel panel_5_4_1 = new JPanel();
		panel_5_4_1.setLayout(null);
		panel_5_4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Randevu Al", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4_1.setBounds(0, 0, 407, 293);
		panel_2_1.add(panel_5_4_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Polikinlik");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 25, 124, 14);
		panel_5_4_1.add(lblNewLabel_1_1);
		
		JLabel lblTcKimlik_1_1 = new JLabel("Doktor Adı");
		lblTcKimlik_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTcKimlik_1_1.setBounds(10, 71, 124, 14);
		panel_5_4_1.add(lblTcKimlik_1_1);
		
		JLabel lblDoumTarihi_1_1 = new JLabel("Hasta T.C");
		lblDoumTarihi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumTarihi_1_1.setBounds(10, 122, 124, 22);
		panel_5_4_1.add(lblDoumTarihi_1_1);
		
		JLabel lblDoumYeri_1_1 = new JLabel("Tarih");
		lblDoumYeri_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1.setBounds(10, 173, 124, 22);
		panel_5_4_1.add(lblDoumYeri_1_1);
		
		txtRSAlDokAdi = new JTextField();
		txtRSAlDokAdi.setColumns(10);
		txtRSAlDokAdi.setBounds(157, 71, 179, 22);
		panel_5_4_1.add(txtRSAlDokAdi);
		
		txtRSALHastaTc = new JTextField();
		txtRSALHastaTc.setColumns(10);
		txtRSALHastaTc.setBounds(157, 122, 179, 20);
		panel_5_4_1.add(txtRSALHastaTc);
		
		dcRSALTarih = new JDateChooser();
		dcRSALTarih.setBounds(157, 173, 179, 21);
		panel_5_4_1.add(dcRSALTarih);
		
		JLabel lblDoumYeri_1_1_2 = new JLabel("Randevu Kodu");
		lblDoumYeri_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_2.setBounds(10, 230, 124, 22);
		panel_5_4_1.add(lblDoumYeri_1_1_2);
		
		txtRSALRanKodu = new JTextField();
		txtRSALRanKodu.setEditable(false);
		txtRSALRanKodu.setColumns(10);
		txtRSALRanKodu.setBounds(157, 230, 179, 20);
		panel_5_4_1.add(txtRSALRanKodu);
		
		JComboBox cboxRSALPolikinlik = new JComboBox();
		cboxRSALPolikinlik.setBounds(157, 22, 179, 22);
		panel_5_4_1.add(cboxRSALPolikinlik);

		JPanel panel_5_4_1_1 = new JPanel();
		panel_5_4_1_1.setLayout(null);
		panel_5_4_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "G\u00FCncel Randevular\u0131m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4_1_1.setBounds(408, 0, 407, 293);
		panel_2_1.add(panel_5_4_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Randevu Kodlarım");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 25, 124, 14);
		panel_5_4_1_1.add(lblNewLabel_1_1_1);
		
		JComboBox cboxRSGRRendavuKodlari = new JComboBox();
		cboxRSGRRendavuKodlari.setBounds(144, 22, 179, 22);
		panel_5_4_1_1.add(cboxRSGRRendavuKodlari);
		
		JLabel lblDoumYeri_1_1_1 = new JLabel("Tarih");
		lblDoumYeri_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_1.setBounds(10, 230, 124, 22);
		panel_5_4_1_1.add(lblDoumYeri_1_1_1);
		
		txtRSGRTc = new JTextField();
		txtRSGRTc.setEditable(false);
		txtRSGRTc.setColumns(10);
		txtRSGRTc.setBounds(144, 173, 179, 20);
		panel_5_4_1_1.add(txtRSGRTc);
		
		JLabel lblDoumTarihi_1_1_1 = new JLabel("Hasta T.C");
		lblDoumTarihi_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumTarihi_1_1_1.setBounds(10, 173, 124, 22);
		panel_5_4_1_1.add(lblDoumTarihi_1_1_1);
		
		JLabel lblTcKimlik_1_1_1 = new JLabel("Doktor Adı");
		lblTcKimlik_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTcKimlik_1_1_1.setBounds(10, 122, 124, 14);
		panel_5_4_1_1.add(lblTcKimlik_1_1_1);
		
		txtRSGRDokAdi = new JTextField();
		txtRSGRDokAdi.setEditable(false);
		txtRSGRDokAdi.setColumns(10);
		txtRSGRDokAdi.setBounds(144, 122, 179, 20);
		panel_5_4_1_1.add(txtRSGRDokAdi);
		
		txtRSGRPolik = new JTextField();
		txtRSGRPolik.setEditable(false);
		txtRSGRPolik.setColumns(10);
		txtRSGRPolik.setBounds(144, 71, 179, 20);
		panel_5_4_1_1.add(txtRSGRPolik);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Polikinlik");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(10, 71, 124, 14);
		panel_5_4_1_1.add(lblNewLabel_1_1_2);
		
		txtRSGRTarih = new JTextField();
		txtRSGRTarih.setEditable(false);
		txtRSGRTarih.setColumns(10);
		txtRSGRTarih.setBounds(144, 230, 179, 20);
		panel_5_4_1_1.add(txtRSGRTarih);
		
		JButton btnRSAl = new JButton("Randevu Al");
		btnRSAl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRSAl.setBounds(261, 323, 123, 27);
		panel_2_1.add(btnRSAl);
		
		JButton btnRSSil = new JButton("Randevu Sil");
		btnRSSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRSSil.setBounds(433, 323, 123, 27);
		panel_2_1.add(btnRSSil);
		
		JPanel panel_8_2 = new JPanel();
		panel_8_2.setLayout(null);
		panel_8_2.setBounds(0, 0, 188, 376);
		panel_4.add(panel_8_2);
		
		JButton btnHasAra_1_1_2 = new JButton("Ara");
		btnHasAra_1_1_2.setBounds(95, 0, 88, 23);
		panel_8_2.add(btnHasAra_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(0, 0, 100, 23);
		panel_8_2.add(textField_2);
		
		JTree tree_1_2_2 = new JTree();
		tree_1_2_2.setBounds(0, 22, 188, 355);
		panel_8_2.add(tree_1_2_2);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Acil Servis", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(185, 0, 815, 376);
		panel_7.add(panel_2_1_1);
		
		JPanel panel_5_4_1_2 = new JPanel();
		panel_5_4_1_2.setLayout(null);
		panel_5_4_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5_4_1_2.setBounds(0, 0, 270, 246);
		panel_2_1_1.add(panel_5_4_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Hasta Adı");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_3.setBounds(24, 11, 81, 14);
		panel_5_4_1_2.add(lblNewLabel_1_1_3);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Acil Rengi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6_1.setBounds(24, 90, 229, 55);
		panel_5_4_1_2.add(panel_6_1);
		
		JRadioButton rdbtnKrmz = new JRadioButton("Kırmızı");
		rdbtnKrmz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnKrmz.setForeground(new Color(255, 0, 0));
		bg2.add(rdbtnKrmz);
		
		JRadioButton rdbtnSar = new JRadioButton("Sarı");
		rdbtnSar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnSar.setForeground(new Color(255, 204, 0));
		bg2.add(rdbtnSar);
		
		JRadioButton rdbtnYesil = new JRadioButton("Yeşil");
		rdbtnYesil.setForeground(new Color(0, 204, 0));
		rdbtnYesil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bg2.add(rdbtnYesil);
		
		GroupLayout gl_panel_6_1 = new GroupLayout(panel_6_1);
		gl_panel_6_1.setHorizontalGroup(
			gl_panel_6_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6_1.createSequentialGroup()
					.addComponent(rdbtnKrmz, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnSar, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(rdbtnYesil)
					.addGap(40))
		);
		gl_panel_6_1.setVerticalGroup(
			gl_panel_6_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6_1.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel_6_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnKrmz)
						.addComponent(rdbtnSar)
						.addComponent(rdbtnYesil)))
		);
		panel_6_1.setLayout(gl_panel_6_1);
		
		txtAShastaAdi = new JTextField();
		txtAShastaAdi.setBounds(115, 11, 130, 20);
		panel_5_4_1_2.add(txtAShastaAdi);
		txtAShastaAdi.setColumns(10);
		
		JLabel lblDoumYeri_1_1_3_3_1 = new JLabel("Şuur");
		lblDoumYeri_1_1_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_3_1.setBounds(24, 155, 81, 22);
		panel_5_4_1_2.add(lblDoumYeri_1_1_3_3_1);
		
		txtASsuur = new JTextField();
		txtASsuur.setColumns(10);
		txtASsuur.setBounds(115, 155, 130, 20);
		panel_5_4_1_2.add(txtASsuur);
		
		JLabel lblDoumYeri_1_1_3_3_1_1 = new JLabel("Ateş");
		lblDoumYeri_1_1_3_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_3_1_1.setBounds(24, 185, 81, 22);
		panel_5_4_1_2.add(lblDoumYeri_1_1_3_3_1_1);
		
		txtASates = new JTextField();
		txtASates.setColumns(10);
		txtASates.setBounds(115, 186, 130, 20);
		panel_5_4_1_2.add(txtASates);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Hasta Kodu");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_3_1.setBounds(24, 51, 81, 14);
		panel_5_4_1_2.add(lblNewLabel_1_1_3_1);
		
		txtAShkodu = new JTextField();
		txtAShkodu.setEditable(false);
		txtAShkodu.setColumns(10);
		txtAShkodu.setBounds(115, 50, 130, 20);
		panel_5_4_1_2.add(txtAShkodu);
		
		JPanel panel_5_4_1_2_1 = new JPanel();
		panel_5_4_1_2_1.setLayout(null);
		panel_5_4_1_2_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5_4_1_2_1.setBounds(270, 0, 270, 246);
		panel_2_1_1.add(panel_5_4_1_2_1);
		
		JTextArea txtASgecmis = new JTextArea();
		txtASgecmis.setBounds(10, 141, 227, 70);
		panel_5_4_1_2_1.add(txtASgecmis);
		
		JLabel lblDoumYeri_1_1_3_3 = new JLabel("Hastalık / Ameliyat Geçmişi");
		lblDoumYeri_1_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_3.setBounds(10, 108, 242, 22);
		panel_5_4_1_2_1.add(lblDoumYeri_1_1_3_3);
		
		txtASekg = new JTextField();
		txtASekg.setBounds(107, 51, 130, 20);
		panel_5_4_1_2_1.add(txtASekg);
		txtASekg.setColumns(10);
		
		JLabel lblDoumYeri_1_1_3_3_1_3 = new JLabel("EKG");
		lblDoumYeri_1_1_3_3_1_3.setBounds(16, 51, 81, 22);
		panel_5_4_1_2_1.add(lblDoumYeri_1_1_3_3_1_3);
		lblDoumYeri_1_1_3_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblDoumYeri_1_1_3_3_1_2 = new JLabel("Nabız");
		lblDoumYeri_1_1_3_3_1_2.setBounds(16, 11, 81, 22);
		panel_5_4_1_2_1.add(lblDoumYeri_1_1_3_3_1_2);
		lblDoumYeri_1_1_3_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtASnabiz = new JTextField();
		txtASnabiz.setBounds(107, 11, 130, 20);
		panel_5_4_1_2_1.add(txtASnabiz);
		txtASnabiz.setColumns(10);
		
		JPanel panel_5_4_1_2_2 = new JPanel();
		panel_5_4_1_2_2.setLayout(null);
		panel_5_4_1_2_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5_4_1_2_2.setBounds(545, 0, 270, 246);
		panel_2_1_1.add(panel_5_4_1_2_2);
		
		JTextArea txtAStani = new JTextArea();
		txtAStani.setBounds(10, 145, 227, 70);
		panel_5_4_1_2_2.add(txtAStani);
		
		JLabel lblDoumYeri_1_1_3_2_1 = new JLabel("İlk Tanı");
		lblDoumYeri_1_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_3_2_1.setBounds(10, 112, 124, 22);
		panel_5_4_1_2_2.add(lblDoumYeri_1_1_3_2_1);
		
		JTextArea txtASilac = new JTextArea();
		txtASilac.setBounds(10, 41, 227, 60);
		panel_5_4_1_2_2.add(txtASilac);
		
		JLabel lblDoumYeri_1_1_3_1 = new JLabel("Kullandığı İlcaçlar");
		lblDoumYeri_1_1_3_1.setBounds(10, 11, 124, 22);
		panel_5_4_1_2_2.add(lblDoumYeri_1_1_3_1);
		lblDoumYeri_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnASKaydet = new JButton("Kaydet");
		btnASKaydet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnASKaydet.setBounds(193, 307, 123, 27);
		panel_2_1_1.add(btnASKaydet);
		
		JButton btnASGuncelle = new JButton("Güncelle");
		btnASGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnASGuncelle.setBounds(352, 307, 123, 27);
		panel_2_1_1.add(btnASGuncelle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSil.setBounds(513, 307, 123, 27);
		panel_2_1_1.add(btnSil);
		
		JPanel panel_8_3 = new JPanel();
		panel_8_3.setLayout(null);
		panel_8_3.setBounds(0, 0, 188, 376);
		panel_7.add(panel_8_3);
		
		JButton btnHasAra_1_1_3 = new JButton("Ara");
		btnHasAra_1_1_3.setBounds(95, 0, 88, 23);
		panel_8_3.add(btnHasAra_1_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(0, 0, 100, 23);
		panel_8_3.add(textField_3);
		
		JTree tree_1_2_3 = new JTree();
		tree_1_2_3.setBounds(0, 22, 188, 355);
		panel_8_3.add(tree_1_2_3);
	}
}
