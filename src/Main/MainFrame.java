package Main;

import java.awt.EventQueue;

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

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
		tabbedPane.setBounds(185, 0, 820, 404);
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
		panel_5.setBounds(0, 0, 276, 167);
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
		panel_5_2.setBounds(539, 0, 276, 167);
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
		panel_5_1.setBounds(270, 0, 276, 167);
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
		panel_5_3.setBounds(0, 167, 815, 160);
		panel_1.add(panel_5_3);
		panel_5_3.setLayout(null);
		
		JLabel lblYa = new JLabel("Yaş");
		lblYa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYa.setBounds(10, 25, 124, 14);
		panel_5_3.add(lblYa);
		
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
		
		JLabel lblHastalklar = new JLabel("Hastalıklar");
		lblHastalklar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHastalklar.setBounds(553, 63, 124, 14);
		panel_5_3.add(lblHastalklar);
		
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
		
		JButton btnGuncelle = new JButton("Güncelle");
		btnGuncelle.setBounds(457, 338, 123, 27);
		panel_1.add(btnGuncelle);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(258, 338, 123, 27);
		panel_1.add(btnKaydet);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Doktor Kayıt", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Randevu Sistemi", null, panel_4, null);
		panel_4.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(0, 23, 184, 381);
		contentPane.add(tree);
		
		JButton btnAra = new JButton("Ara");
		btnAra.setBounds(93, 0, 91, 23);
		contentPane.add(btnAra);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 1, 96, 23);
		contentPane.add(textField);
	}
}
