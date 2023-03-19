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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panel_2.setBounds(0, 0, 815, 376);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hasta Kayıt", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kimlik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(185, 0, 276, 167);
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
		lblDoumTarihi.setBounds(10, 71, 124, 22);
		panel_5.add(lblDoumTarihi);
		
		JLabel lblDoumYeri = new JLabel("Doğum Yeri");
		lblDoumYeri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri.setBounds(10, 96, 124, 22);
		panel_5.add(lblDoumYeri);
		
		JLabel lblCinsiyeti = new JLabel("Cinsiyeti");
		lblCinsiyeti.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCinsiyeti.setBounds(10, 125, 124, 14);
		panel_5.add(lblCinsiyeti);
		
		JComboBox cboxHKCinsiyet = new JComboBox();
		cboxHKCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Bilinmiyor", "Erkek", "Kadın"}));
		cboxHKCinsiyet.setBounds(144, 122, 106, 22);
		panel_5.add(cboxHKCinsiyet);
		
		txtHKAdSoyad = new JTextField();
		txtHKAdSoyad.setBounds(144, 23, 106, 20);
		panel_5.add(txtHKAdSoyad);
		txtHKAdSoyad.setColumns(10);
		
		txtHKTcNo = new JTextField();
		txtHKTcNo.setColumns(10);
		txtHKTcNo.setBounds(144, 48, 106, 20);
		panel_5.add(txtHKTcNo);
		
		txtHKDogumTar = new JTextField();
		txtHKDogumTar.setColumns(10);
		txtHKDogumTar.setBounds(144, 73, 106, 20);
		panel_5.add(txtHKDogumTar);
		
		txtHKDogumYeri = new JTextField();
		txtHKDogumYeri.setColumns(10);
		txtHKDogumYeri.setBounds(144, 98, 106, 20);
		panel_5.add(txtHKDogumYeri);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hasta Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_2.setBounds(724, 0, 276, 167);
		panel_1.add(panel_5_2);
		panel_5_2.setLayout(null);
		
		JLabel lblSigortaTr = new JLabel("Sigorta Türü");
		lblSigortaTr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSigortaTr.setBounds(10, 25, 124, 14);
		panel_5_2.add(lblSigortaTr);
		
		JLabel lblSicilNo = new JLabel("Sicil No");
		lblSicilNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSicilNo.setBounds(10, 60, 124, 14);
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
		txtHKRefAdi.setBounds(144, 89, 106, 20);
		panel_5_2.add(txtHKRefAdi);
		
		JLabel lblHKRefDerece = new JLabel("Yakınlık Derecesi");
		lblHKRefDerece.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHKRefDerece.setBounds(10, 127, 124, 14);
		panel_5_2.add(lblHKRefDerece);
		
		txtHKYakinlik = new JTextField();
		txtHKYakinlik.setColumns(10);
		txtHKYakinlik.setBounds(144, 120, 106, 20);
		panel_5_2.add(txtHKYakinlik);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1.setBounds(455, 0, 276, 167);
		panel_1.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres.setBounds(10, 25, 124, 14);
		panel_5_1.add(lblAdres);
		
		JLabel lblTelefonNumaras = new JLabel("Telefon No");
		lblTelefonNumaras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefonNumaras.setBounds(10, 101, 85, 22);
		panel_5_1.add(lblTelefonNumaras);
		
		txtHKTel = new JTextField();
		txtHKTel.setColumns(10);
		txtHKTel.setBounds(105, 103, 145, 20);
		panel_5_1.add(txtHKTel);
		
		JTextArea txtHKAdres = new JTextArea();
		txtHKAdres.setBounds(105, 26, 145, 66);
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
		lblBoy.setBounds(10, 67, 124, 14);
		panel_5_3.add(lblBoy);
		
		txtHKBoy = new JTextField();
		txtHKBoy.setColumns(10);
		txtHKBoy.setBounds(144, 65, 106, 20);
		panel_5_3.add(txtHKBoy);
		
		JLabel lblKilo = new JLabel("Kilo");
		lblKilo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKilo.setBounds(10, 112, 124, 14);
		panel_5_3.add(lblKilo);
		
		txtHKKilo = new JTextField();
		txtHKKilo.setColumns(10);
		txtHKKilo.setBounds(144, 110, 106, 20);
		panel_5_3.add(txtHKKilo);
		
		JLabel lblEkg = new JLabel("Kan Grubu");
		lblEkg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEkg.setBounds(286, 27, 124, 14);
		panel_5_3.add(lblEkg);
		
		JLabel lblSonGncelleme = new JLabel("Son Güncelleme");
		lblSonGncelleme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSonGncelleme.setBounds(553, 27, 124, 14);
		panel_5_3.add(lblSonGncelleme);
		
		txtHKUpdateTarih = new JTextField();
		txtHKUpdateTarih.setEnabled(false);
		txtHKUpdateTarih.setColumns(10);
		txtHKUpdateTarih.setBounds(687, 25, 106, 20);
		panel_5_3.add(txtHKUpdateTarih);
		
		JLabel lblEkg_1 = new JLabel("EKG");
		lblEkg_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEkg_1.setBounds(286, 69, 124, 14);
		panel_5_3.add(lblEkg_1);
		
		txtHKEkg = new JTextField();
		txtHKEkg.setColumns(10);
		txtHKEkg.setBounds(420, 67, 106, 20);
		panel_5_3.add(txtHKEkg);
		
		JLabel lblHKGecmisHastalklar = new JLabel("Geçmiş Hastalıklar");
		lblHKGecmisHastalklar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHKGecmisHastalklar.setBounds(553, 63, 124, 14);
		panel_5_3.add(lblHKGecmisHastalklar);
		
		JTextArea txtHKHastaliklar = new JTextArea();
		txtHKHastaliklar.setBounds(553, 83, 240, 66);
		panel_5_3.add(txtHKHastaliklar);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Tedavi \u015Eekli", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(286, 94, 240, 55);
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
		cboxHKKanGrub.setBounds(420, 22, 106, 22);
		panel_5_3.add(cboxHKKanGrub);
		
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
		btnHasAra_1_1.setBounds(95, 0, 89, 23);
		panel_8.add(btnHasAra_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 0, 99, 23);
		panel_8.add(textField);
		
		JTree tree_1_2 = new JTree();
		tree_1_2.setBounds(0, 21, 184, 355);
		panel_8.add(tree_1_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Doktor Kayıt", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_5_4 = new JPanel();
		panel_5_4.setLayout(null);
		panel_5_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kimlik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4.setBounds(185, 0, 276, 182);
		panel_3.add(panel_5_4);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 25, 124, 14);
		panel_5_4.add(lblNewLabel_1);
		
		JLabel lblTcKimlik_1 = new JLabel("T.C. Kimlik Numarası");
		lblTcKimlik_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik_1.setBounds(10, 50, 124, 14);
		panel_5_4.add(lblTcKimlik_1);
		
		JLabel lblDoumTarihi_1 = new JLabel("Doğum Tarihi");
		lblDoumTarihi_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumTarihi_1.setBounds(10, 71, 124, 22);
		panel_5_4.add(lblDoumTarihi_1);
		
		JLabel lblDoumYeri_1 = new JLabel("Doğum Yeri");
		lblDoumYeri_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri_1.setBounds(10, 96, 124, 22);
		panel_5_4.add(lblDoumYeri_1);
		
		JLabel lblCinsiyeti_1 = new JLabel("Cinsiyeti");
		lblCinsiyeti_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCinsiyeti_1.setBounds(10, 125, 124, 14);
		panel_5_4.add(lblCinsiyeti_1);
		
		JComboBox cboxDKCinsiyet = new JComboBox();
		cboxDKCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Bilinmiyor", "Erkek", "Kadın"}));
		cboxDKCinsiyet.setBounds(144, 122, 106, 22);
		panel_5_4.add(cboxDKCinsiyet);
		
		txtDKAdSoyad = new JTextField();
		txtDKAdSoyad.setColumns(10);
		txtDKAdSoyad.setBounds(144, 23, 106, 20);
		panel_5_4.add(txtDKAdSoyad);
		
		txtDkTc = new JTextField();
		txtDkTc.setColumns(10);
		txtDkTc.setBounds(144, 48, 106, 20);
		panel_5_4.add(txtDkTc);
		
		txtDKDogTar = new JTextField();
		txtDKDogTar.setColumns(10);
		txtDKDogTar.setBounds(144, 73, 106, 20);
		panel_5_4.add(txtDKDogTar);
		
		txtDKDogYeri = new JTextField();
		txtDKDogYeri.setColumns(10);
		txtDKDogYeri.setBounds(144, 98, 106, 20);
		panel_5_4.add(txtDKDogYeri);
		
		JPanel panel_5_5 = new JPanel();
		panel_5_5.setLayout(null);
		panel_5_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Akademik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_5.setBounds(455, 0, 276, 182);
		panel_3.add(panel_5_5);
		
		JLabel lblNewLabel_2 = new JLabel("Lisans");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 25, 124, 14);
		panel_5_5.add(lblNewLabel_2);
		
		JLabel lblTcKimlik_2 = new JLabel("Yüksek Lisans");
		lblTcKimlik_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik_2.setBounds(10, 50, 124, 14);
		panel_5_5.add(lblTcKimlik_2);
		
		JLabel lblDoumTarihi_2 = new JLabel("Doktora");
		lblDoumTarihi_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumTarihi_2.setBounds(10, 71, 124, 22);
		panel_5_5.add(lblDoumTarihi_2);
		
		JLabel lblDoumYeri_2 = new JLabel("Alanı");
		lblDoumYeri_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoumYeri_2.setBounds(10, 96, 124, 22);
		panel_5_5.add(lblDoumYeri_2);
		
		txtDKLisans = new JTextField();
		txtDKLisans.setColumns(10);
		txtDKLisans.setBounds(144, 23, 106, 20);
		panel_5_5.add(txtDKLisans);
		
		txtDKYLisans = new JTextField();
		txtDKYLisans.setColumns(10);
		txtDKYLisans.setBounds(144, 48, 106, 20);
		panel_5_5.add(txtDKYLisans);
		
		txtDKDoktora = new JTextField();
		txtDKDoktora.setColumns(10);
		txtDKDoktora.setBounds(144, 73, 106, 20);
		panel_5_5.add(txtDKDoktora);
		
		txtDKAlan = new JTextField();
		txtDKAlan.setColumns(10);
		txtDKAlan.setBounds(144, 98, 106, 20);
		panel_5_5.add(txtDKAlan);
		
		JPanel panel_5_6 = new JPanel();
		panel_5_6.setLayout(null);
		panel_5_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_6.setBounds(724, 0, 276, 182);
		panel_3.add(panel_5_6);
		
		JLabel lblAdres_1 = new JLabel("Adres");
		lblAdres_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres_1.setBounds(10, 26, 124, 14);
		panel_5_6.add(lblAdres_1);
		
		JTextArea txtDKAdres = new JTextArea();
		txtDKAdres.setBounds(105, 27, 145, 66);
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
		btnGncelleDoktor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGncelleDoktor.setBounds(665, 338, 123, 27);
		panel_3.add(btnGncelleDoktor);
		
		JPanel panel_5_3_1 = new JPanel();
		panel_5_3_1.setLayout(null);
		panel_5_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hastal\u0131k Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		txtDKKullanIzin.setEnabled(false);
		txtDKKullanIzin.setColumns(10);
		txtDKKullanIzin.setBounds(157, 62, 106, 20);
		panel_5_3_1.add(txtDKKullanIzin);
		
		txtDKKullanilmisIzin = new JTextField();
		txtDKKullanilmisIzin.setEnabled(false);
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
		btnHasAra_1_1_1.setBounds(95, 0, 89, 23);
		panel_8_1.add(btnHasAra_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(0, 0, 99, 23);
		panel_8_1.add(textField_1);
		
		JTree tree_1_2_1 = new JTree();
		tree_1_2_1.setBounds(0, 21, 184, 355);
		panel_8_1.add(tree_1_2_1);
		
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
		lblTcKimlik_1_1.setBounds(10, 62, 124, 14);
		panel_5_4_1.add(lblTcKimlik_1_1);
		
		JLabel lblDoumTarihi_1_1 = new JLabel("Hasta T.C");
		lblDoumTarihi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumTarihi_1_1.setBounds(10, 101, 124, 22);
		panel_5_4_1.add(lblDoumTarihi_1_1);
		
		JLabel lblDoumYeri_1_1 = new JLabel("Tarih");
		lblDoumYeri_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1.setBounds(10, 146, 124, 22);
		panel_5_4_1.add(lblDoumYeri_1_1);
		
		txtRSAlDokAdi = new JTextField();
		txtRSAlDokAdi.setColumns(10);
		txtRSAlDokAdi.setBounds(157, 61, 179, 22);
		panel_5_4_1.add(txtRSAlDokAdi);
		
		txtRSALHastaTc = new JTextField();
		txtRSALHastaTc.setColumns(10);
		txtRSALHastaTc.setBounds(157, 104, 179, 20);
		panel_5_4_1.add(txtRSALHastaTc);
		
		dcRSALTarih = new JDateChooser();
		dcRSALTarih.setBounds(157, 146, 179, 21);
		panel_5_4_1.add(dcRSALTarih);
		
		JLabel lblDoumYeri_1_1_2 = new JLabel("Randevu Kodu");
		lblDoumYeri_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumYeri_1_1_2.setBounds(10, 201, 124, 22);
		panel_5_4_1.add(lblDoumYeri_1_1_2);
		
		txtRSALRanKodu = new JTextField();
		txtRSALRanKodu.setColumns(10);
		txtRSALRanKodu.setBounds(157, 204, 179, 20);
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
		lblDoumYeri_1_1_1.setBounds(10, 199, 124, 22);
		panel_5_4_1_1.add(lblDoumYeri_1_1_1);
		
		txtRSGRTc = new JTextField();
		txtRSGRTc.setEnabled(false);
		txtRSGRTc.setColumns(10);
		txtRSGRTc.setBounds(144, 149, 179, 20);
		panel_5_4_1_1.add(txtRSGRTc);
		
		JLabel lblDoumTarihi_1_1_1 = new JLabel("Hasta T.C");
		lblDoumTarihi_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoumTarihi_1_1_1.setBounds(10, 146, 124, 22);
		panel_5_4_1_1.add(lblDoumTarihi_1_1_1);
		
		JLabel lblTcKimlik_1_1_1 = new JLabel("Doktor Adı");
		lblTcKimlik_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTcKimlik_1_1_1.setBounds(10, 112, 124, 14);
		panel_5_4_1_1.add(lblTcKimlik_1_1_1);
		
		txtRSGRDokAdi = new JTextField();
		txtRSGRDokAdi.setEnabled(false);
		txtRSGRDokAdi.setColumns(10);
		txtRSGRDokAdi.setBounds(144, 111, 179, 20);
		panel_5_4_1_1.add(txtRSGRDokAdi);
		
		txtRSGRPolik = new JTextField();
		txtRSGRPolik.setEnabled(false);
		txtRSGRPolik.setColumns(10);
		txtRSGRPolik.setBounds(144, 62, 179, 20);
		panel_5_4_1_1.add(txtRSGRPolik);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Polikinlik");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(10, 63, 124, 14);
		panel_5_4_1_1.add(lblNewLabel_1_1_2);
		
		txtRSGRTarih = new JTextField();
		txtRSGRTarih.setEnabled(false);
		txtRSGRTarih.setColumns(10);
		txtRSGRTarih.setBounds(144, 202, 179, 20);
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
		btnHasAra_1_1_2.setBounds(95, 0, 89, 23);
		panel_8_2.add(btnHasAra_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(0, 0, 99, 23);
		panel_8_2.add(textField_2);
		
		JTree tree_1_2_2 = new JTree();
		tree_1_2_2.setBounds(0, 21, 184, 355);
		panel_8_2.add(tree_1_2_2);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Acil Servis", null, panel_7, null);
		panel_7.setLayout(null);
	}
}
