package Main;

import java.awt.EventQueue;
import com.toedter.calendar.JDateChooser;

import Class.Member;

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
import javax.swing.JOptionPane;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.border.CompoundBorder;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDateChooser dcRSALTarih;
	private ButtonGroup bg = new ButtonGroup();
	private ButtonGroup bg2 = new ButtonGroup();
	private ArrayList<Member> ii = new ArrayList<Member>();
	private JTextField txtRSALHastaTc;
	private JTextField textField;
	private JTextField txtAShastaAdi;
	private JTextField txtASsuur;
	private JTextField txtASates;
	private JTextField txtASnabiz;
	private JTextField txtASekg;
	private JTextField txtAStc;
	private final JPanel panel_5_4_1_1 = new JPanel();
	private JTextField textField_4;
	private JTextField textField_2;
	private Connection c;
	private Statement s;
	private JTextField txtgirisTc;
	private JPasswordField txtGirisPassword;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_1;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_19;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_3;

	public void getConnection() throws ClassNotFoundException, SQLException {		
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbHospitalManagementSystem", "postgres", "bdroomay6715");
		s = c.createStatement();
		System.out.println("Opened database successfully");
	}
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

	public MainFrame() {
		setBackground(new Color(196, 196, 196));
		setFont(new Font("Dialog", Font.PLAIN, 9));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\EclipseProje\\HospitalManagementSystem\\icons\\icon.png"));
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("Hastane Otomasyon Sistemi");
		setBounds(100, 100, 1014, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(196, 196, 196));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBounds(0, 0, 1005, 404);
		contentPane.add(tabbedPane);
		
		JPanel HomePanel = new JPanel();
		tabbedPane.addTab("Giriş", null, HomePanel, null);
		HomePanel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1000, 376);
		HomePanel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel GirisPanel = new JPanel();
		GirisPanel.setBackground(new Color(196, 196, 196));
		GirisPanel.setBounds(0, 0, 500, 376);
		panel_2.add(GirisPanel);
		GirisPanel.setLayout(null);
		
		JLabel lbl_Tc = new JLabel("T.C. Kimlik Numarası");
		lbl_Tc.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc.setBounds(28, 149, 194, 14);
		GirisPanel.add(lbl_Tc);
		
		txtgirisTc = new JTextField();
		txtgirisTc.setColumns(10);
		txtgirisTc.setBounds(232, 149, 240, 20);
		GirisPanel.add(txtgirisTc);
		
		JLabel lbl_Tc_1 = new JLabel("Şifre");
		lbl_Tc_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Tc_1.setBounds(28, 192, 176, 20);
		GirisPanel.add(lbl_Tc_1);
		
		txtGirisPassword = new JPasswordField();
		txtGirisPassword.setBounds(232, 192, 240, 20);
		GirisPanel.add(txtGirisPassword);
		
		JButton btnGiris = new JButton("Giriş Yap");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String girp = new String(txtGirisPassword.getPassword());
				String girt=txtgirisTc.getText();
				String PF;
				ii = new ArrayList<Member>();
				String sql1 = "SELECT \"Id\", \"Ad\", \"Tc\", \"Password\", \"Unvan\" FROM public.\"Member\" where \"Tc\"='"+girt+"' and \"Password\" = '"+girp+"';";
				ResultSet rs;
				try {
					rs = s.executeQuery(sql1);
					
					if (rs.next()) {
						Member mm = new Member();
						mm.Unvan= rs.getString("Unvan");
						String unv=mm.Unvan;
							if(unv.equals("doktor")) {
								
								//Hasta Kayit Panel Start
								JPanel HastaKayitPanel = new JPanel();
								tabbedPane.addTab("Hasta Kayıt", null, HastaKayitPanel, null);
								HastaKayitPanel.setLayout(null);
								
								JPanel panel_8 = new JPanel();
								panel_8.setBounds(0, 0, 188, 376);
								HastaKayitPanel.add(panel_8);
								panel_8.setLayout(null);
								
								JButton btnHasAra_1_1 = new JButton("Ara");
								btnHasAra_1_1.setBounds(102, 0, 86, 21);
								panel_8.add(btnHasAra_1_1);
								
								textField = new JTextField();
								textField.setColumns(10);
								textField.setBounds(0, 0, 101, 21);
								panel_8.add(textField);
								
								JTree tree_1_2 = new JTree();
								tree_1_2.setBounds(0, 22, 188, 355);
								panel_8.add(tree_1_2);
								
								JPanel panel = new JPanel();
								panel.setBounds(198, 0, 835, 376);
								HastaKayitPanel.add(panel);
								panel.setLayout(null);
								
								JPanel panel_5 = new JPanel();
								panel_5.setLayout(null);
								panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kimlik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5.setBounds(0, 0, 270, 167);
								panel.add(panel_5);
								
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
								cboxHKCinsiyet.setBounds(144, 125, 106, 22);
								panel_5.add(cboxHKCinsiyet);
								
								textField_6 = new JTextField();
								textField_6.setColumns(10);
								textField_6.setBounds(144, 23, 106, 20);
								panel_5.add(textField_6);
								
								textField_7 = new JTextField();
								textField_7.setColumns(10);
								textField_7.setBounds(144, 50, 106, 20);
								panel_5.add(textField_7);
								
								textField_8 = new JTextField();
								textField_8.setColumns(10);
								textField_8.setBounds(144, 75, 106, 20);
								panel_5.add(textField_8);
								
								textField_9 = new JTextField();
								textField_9.setColumns(10);
								textField_9.setBounds(144, 100, 106, 20);
								panel_5.add(textField_9);
								
								JPanel panel_5_1 = new JPanel();
								panel_5_1.setLayout(null);
								panel_5_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_1.setBounds(270, 0, 270, 167);
								panel.add(panel_5_1);
								
								JLabel lblAdres = new JLabel("Adres");
								lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblAdres.setBounds(10, 25, 124, 14);
								panel_5_1.add(lblAdres);
								
								JLabel lblTelefonNumaras = new JLabel("Telefon No");
								lblTelefonNumaras.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblTelefonNumaras.setBounds(10, 125, 85, 22);
								panel_5_1.add(lblTelefonNumaras);
								
								textField_10 = new JTextField();
								textField_10.setColumns(10);
								textField_10.setBounds(105, 125, 145, 20);
								panel_5_1.add(textField_10);
								
								JTextArea txtHKAdres = new JTextArea();
								txtHKAdres.setBounds(105, 26, 145, 88);
								panel_5_1.add(txtHKAdres);
								
								JPanel panel_5_2 = new JPanel();
								panel_5_2.setLayout(null);
								panel_5_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hasta Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_2.setBounds(539, 0, 270, 167);
								panel.add(panel_5_2);
								
								JLabel lblSigortaTr = new JLabel("Sigorta Türü");
								lblSigortaTr.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblSigortaTr.setBounds(10, 25, 124, 17);
								panel_5_2.add(lblSigortaTr);
								
								JLabel lblSicilNo = new JLabel("Sicil No");
								lblSicilNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblSicilNo.setBounds(10, 50, 124, 14);
								panel_5_2.add(lblSicilNo);
								
								textField_11 = new JTextField();
								textField_11.setColumns(10);
								textField_11.setBounds(144, 50, 106, 20);
								panel_5_2.add(textField_11);
								
								JComboBox cboxHKSigTur = new JComboBox();
								cboxHKSigTur.setBounds(144, 22, 106, 22);
								panel_5_2.add(cboxHKSigTur);
								
								JLabel lblRefakatBilgileri = new JLabel("Refakatçı Adı");
								lblRefakatBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblRefakatBilgileri.setBounds(10, 75, 124, 14);
								panel_5_2.add(lblRefakatBilgileri);
								
								textField_12 = new JTextField();
								textField_12.setColumns(10);
								textField_12.setBounds(144, 75, 106, 20);
								panel_5_2.add(textField_12);
								
								JLabel lblHKRefDerece = new JLabel("Yakınlık Derecesi");
								lblHKRefDerece.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblHKRefDerece.setBounds(10, 125, 124, 14);
								panel_5_2.add(lblHKRefDerece);
								
								textField_13 = new JTextField();
								textField_13.setColumns(10);
								textField_13.setBounds(144, 125, 106, 20);
								panel_5_2.add(textField_13);
								
								JLabel lblPolikinlik = new JLabel("Polikinlik");
								lblPolikinlik.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblPolikinlik.setBounds(10, 100, 106, 22);
								panel_5_2.add(lblPolikinlik);
								
								JComboBox cboxHKPol = new JComboBox();
								cboxHKPol.setBounds(144, 100, 106, 22);
								panel_5_2.add(cboxHKPol);
								
								JPanel panel_5_3 = new JPanel();
								panel_5_3.setLayout(null);
								panel_5_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hastal\u0131k Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_3.setBounds(0, 167, 815, 160);
								panel.add(panel_5_3);
								
								JLabel lblYas = new JLabel("Yaş");
								lblYas.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblYas.setBounds(10, 25, 124, 14);
								panel_5_3.add(lblYas);
								
								textField_14 = new JTextField();
								textField_14.setColumns(10);
								textField_14.setBounds(144, 23, 106, 20);
								panel_5_3.add(textField_14);
								
								JLabel lblBoy = new JLabel("Boy");
								lblBoy.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblBoy.setBounds(10, 50, 124, 14);
								panel_5_3.add(lblBoy);
								
								textField_15 = new JTextField();
								textField_15.setColumns(10);
								textField_15.setBounds(144, 50, 106, 20);
								panel_5_3.add(textField_15);
								
								JLabel lblKilo = new JLabel("Kilo");
								lblKilo.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblKilo.setBounds(10, 75, 124, 14);
								panel_5_3.add(lblKilo);
								
								textField_16 = new JTextField();
								textField_16.setColumns(10);
								textField_16.setBounds(144, 75, 106, 20);
								panel_5_3.add(textField_16);
								
								JLabel lblEkg = new JLabel("Kan Grubu");
								lblEkg.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblEkg.setBounds(10, 100, 124, 14);
								panel_5_3.add(lblEkg);
								
								JLabel lblSonGncelleme = new JLabel("Son Güncelleme");
								lblSonGncelleme.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblSonGncelleme.setBounds(553, 25, 124, 14);
								panel_5_3.add(lblSonGncelleme);
								
								textField_17 = new JTextField();
								textField_17.setEditable(false);
								textField_17.setColumns(10);
								textField_17.setBounds(687, 25, 106, 20);
								panel_5_3.add(textField_17);
								
								JLabel lblEkg_1 = new JLabel("EKG");
								lblEkg_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblEkg_1.setBounds(10, 125, 124, 14);
								panel_5_3.add(lblEkg_1);
								
								textField_18 = new JTextField();
								textField_18.setColumns(10);
								textField_18.setBounds(144, 125, 106, 20);
								panel_5_3.add(textField_18);
								
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
										.addGap(0, 240, Short.MAX_VALUE)
										.addGroup(gl_panel_6.createSequentialGroup()
											.addComponent(rdbtnAyakta, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
											.addGap(42)
											.addComponent(rdbtnYatarak, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								);
								gl_panel_6.setVerticalGroup(
									gl_panel_6.createParallelGroup(Alignment.LEADING)
										.addGap(0, 52, Short.MAX_VALUE)
										.addGroup(gl_panel_6.createSequentialGroup()
											.addGap(7)
											.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbtnAyakta)
												.addComponent(rdbtnYatarak)))
								);
								panel_6.setLayout(gl_panel_6);
								
								JComboBox cboxHKKanGrub = new JComboBox();
								cboxHKKanGrub.setBounds(144, 100, 106, 22);
								panel_5_3.add(cboxHKKanGrub);
								
								JLabel lblKullandIlalar = new JLabel("Kullandığı İlaçlar");
								lblKullandIlalar.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblKullandIlalar.setBounds(284, 70, 124, 17);
								panel_5_3.add(lblKullandIlalar);
								
								JTextArea txtHKilaclar = new JTextArea();
								txtHKilaclar.setBounds(284, 94, 240, 45);
								panel_5_3.add(txtHKilaclar);
								
								JButton btnHKSil = new JButton("Sil");
								btnHKSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnHKSil.setBounds(524, 338, 123, 27);
								panel.add(btnHKSil);
								
								JButton btnGuncelleHasta = new JButton("Güncelle");
								btnGuncelleHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnGuncelleHasta.setBounds(356, 338, 123, 27);
								panel.add(btnGuncelleHasta);
								
								JButton btnKaydetHasta = new JButton("Kaydet");
								btnKaydetHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnKaydetHasta.setBounds(181, 338, 123, 27);
								panel.add(btnKaydetHasta);
								//Hasta Kayit Panel End
								//Acil Servis Panel Start
								
								JPanel AcilServisPanel = new JPanel();
								tabbedPane.addTab("Acil Servis", null, AcilServisPanel, null);
								AcilServisPanel.setLayout(null);
								
								JPanel panel_2_1_1 = new JPanel();
								panel_2_1_1.setLayout(null);
								panel_2_1_1.setBounds(194, 0, 806, 376);
								AcilServisPanel.add(panel_2_1_1);
								
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
								
								JLabel lblNewLabel_1_1_3_1 = new JLabel("Hasta Tc");
								lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblNewLabel_1_1_3_1.setBounds(24, 51, 81, 14);
								panel_5_4_1_2.add(lblNewLabel_1_1_3_1);
								
								txtAStc = new JTextField();
								txtAStc.setEditable(false);
								txtAStc.setColumns(10);
								txtAStc.setBounds(115, 50, 130, 20);
								panel_5_4_1_2.add(txtAStc);
								
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
								panel_5_4_1_2_2.setBounds(545, 0, 251, 246);
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
								
								JPanel panel_8_4_1 = new JPanel();
								panel_8_4_1.setLayout(null);
								panel_8_4_1.setBounds(0, 0, 188, 376);
								AcilServisPanel.add(panel_8_4_1);
								
								JButton btnHasAra_1_1_2_1 = new JButton("Ara");
								btnHasAra_1_1_2_1.setBounds(102, 0, 86, 21);
								panel_8_4_1.add(btnHasAra_1_1_2_1);
								
								textField_3 = new JTextField();
								textField_3.setColumns(10);
								textField_3.setBounds(0, 0, 101, 21);
								panel_8_4_1.add(textField_3);
								
								JTree tree_1_2_2_1 = new JTree();
								tree_1_2_2_1.setBounds(0, 22, 188, 355);
								panel_8_4_1.add(tree_1_2_2_1);
								//Acil Servis Panel End
															
							}
							else if(unv.equals("personel")) {
								//Doktor Kayit Panel Start
								JPanel DoktorKayitPanel = new JPanel();
								tabbedPane.addTab("Doktor Kayıt", null, DoktorKayitPanel, null);
								DoktorKayitPanel.setLayout(null);
								
								JPanel panel_1 = new JPanel();
								panel_1.setBounds(198, 0, 802, 376);
								DoktorKayitPanel.add(panel_1);
								panel_1.setLayout(null);
								
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
								cboxDKCinsiyet.setBounds(144, 145, 106, 22);
								panel_5_4.add(cboxDKCinsiyet);
								
								textField_1 = new JTextField();
								textField_1.setColumns(10);
								textField_1.setBounds(144, 23, 106, 20);
								panel_5_4.add(textField_1);
								
								textField_20 = new JTextField();
								textField_20.setColumns(10);
								textField_20.setBounds(144, 55, 106, 20);
								panel_5_4.add(textField_20);
								
								textField_21 = new JTextField();
								textField_21.setColumns(10);
								textField_21.setBounds(144, 85, 106, 20);
								panel_5_4.add(textField_21);
								
								textField_22 = new JTextField();
								textField_22.setColumns(10);
								textField_22.setBounds(144, 115, 106, 20);
								panel_5_4.add(textField_22);
								
								JPanel panel_5_5 = new JPanel();
								panel_5_5.setLayout(null);
								panel_5_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Akademik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_5.setBounds(270, 0, 270, 182);
								panel_1.add(panel_5_5);
								
								JLabel lblDoumYeri_2 = new JLabel("Alanı");
								lblDoumYeri_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblDoumYeri_2.setBounds(10, 145, 124, 22);
								panel_5_5.add(lblDoumYeri_2);
								
								textField_23 = new JTextField();
								textField_23.setColumns(10);
								textField_23.setBounds(144, 145, 106, 20);
								panel_5_5.add(textField_23);
								
								JPanel panel_6_1_1 = new JPanel();
								panel_6_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "E\u011Fitim Derecesi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_6_1_1.setBounds(10, 25, 240, 70);
								panel_5_5.add(panel_6_1_1);
								
								JRadioButton rdbtnYksekLisans = new JRadioButton("Yüksek Lisans");
								rdbtnYksekLisans.setForeground(Color.BLACK);
								rdbtnYksekLisans.setFont(new Font("Tahoma", Font.PLAIN, 14));
								
								JRadioButton rdbtnDoctora = new JRadioButton("Doktora");
								rdbtnDoctora.setForeground(Color.BLACK);
								rdbtnDoctora.setFont(new Font("Tahoma", Font.PLAIN, 14));
								GroupLayout gl_panel_6_1_1 = new GroupLayout(panel_6_1_1);
								gl_panel_6_1_1.setHorizontalGroup(
									gl_panel_6_1_1.createParallelGroup(Alignment.LEADING)
										.addGap(0, 240, Short.MAX_VALUE)
										.addGroup(gl_panel_6_1_1.createSequentialGroup()
											.addComponent(rdbtnYksekLisans, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(rdbtnDoctora)
											.addGap(32))
								);
								gl_panel_6_1_1.setVerticalGroup(
									gl_panel_6_1_1.createParallelGroup(Alignment.LEADING)
										.addGap(0, 70, Short.MAX_VALUE)
										.addGroup(gl_panel_6_1_1.createSequentialGroup()
											.addGap(7)
											.addGroup(gl_panel_6_1_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(rdbtnYksekLisans)
												.addComponent(rdbtnDoctora))
											.addContainerGap(26, Short.MAX_VALUE))
								);
								panel_6_1_1.setLayout(gl_panel_6_1_1);
								
								JLabel lblDoumYeri_2_1 = new JLabel("Polikinlik");
								lblDoumYeri_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblDoumYeri_2_1.setBounds(10, 106, 124, 22);
								panel_5_5.add(lblDoumYeri_2_1);
								
								JComboBox cboxDKPol = new JComboBox();
								cboxDKPol.setBounds(144, 107, 106, 22);
								panel_5_5.add(cboxDKPol);
								
								JPanel panel_5_6 = new JPanel();
								panel_5_6.setLayout(null);
								panel_5_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_6.setBounds(539, 0, 253, 182);
								panel_1.add(panel_5_6);
								
								JLabel lblAdres_1 = new JLabel("Adres");
								lblAdres_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblAdres_1.setBounds(10, 25, 124, 14);
								panel_5_6.add(lblAdres_1);
								
								JTextArea txtDKAdres = new JTextArea();
								txtDKAdres.setBounds(105, 25, 138, 68);
								panel_5_6.add(txtDKAdres);
								
								JLabel lblTelefonNumaras_1 = new JLabel("Telefon No");
								lblTelefonNumaras_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblTelefonNumaras_1.setBounds(10, 102, 85, 22);
								panel_5_6.add(lblTelefonNumaras_1);
								
								textField_24 = new JTextField();
								textField_24.setColumns(10);
								textField_24.setBounds(105, 104, 138, 20);
								panel_5_6.add(textField_24);
								
								JLabel lblTelefonNumaras_1_1 = new JLabel("E Mail");
								lblTelefonNumaras_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblTelefonNumaras_1_1.setBounds(10, 145, 85, 22);
								panel_5_6.add(lblTelefonNumaras_1_1);
								
								textField_25 = new JTextField();
								textField_25.setColumns(10);
								textField_25.setBounds(105, 147, 138, 20);
								panel_5_6.add(textField_25);
								
								JPanel panel_5_3_1 = new JPanel();
								panel_5_3_1.setLayout(null);
								panel_5_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130\u015F Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_3_1.setBounds(0, 181, 792, 108);
								panel_1.add(panel_5_3_1);
								
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
								
								textField_26 = new JTextField();
								textField_26.setColumns(10);
								textField_26.setBounds(158, 23, 106, 20);
								panel_5_3_1.add(textField_26);
								
								textField_27 = new JTextField();
								textField_27.setEditable(false);
								textField_27.setColumns(10);
								textField_27.setBounds(157, 62, 106, 20);
								panel_5_3_1.add(textField_27);
								
								textField_28 = new JTextField();
								textField_28.setEditable(false);
								textField_28.setColumns(10);
								textField_28.setBounds(452, 23, 106, 20);
								panel_5_3_1.add(textField_28);
								
								JLabel lblIzinKullan_1 = new JLabel("Çalışma Saatleri");
								lblIzinKullan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblIzinKullan_1.setBounds(568, 25, 100, 14);
								panel_5_3_1.add(lblIzinKullan_1);
								
								textField_29 = new JTextField();
								textField_29.setColumns(10);
								textField_29.setBounds(678, 20, 106, 20);
								panel_5_3_1.add(textField_29);
								
								JButton btnKaydetDoktor = new JButton("Kaydet");
								btnKaydetDoktor.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnKaydetDoktor.setBounds(147, 321, 123, 27);
								panel_1.add(btnKaydetDoktor);
								
								JButton btnGncelleDoktor = new JButton("Güncelle");
								btnGncelleDoktor.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnGncelleDoktor.setBounds(301, 321, 123, 27);
								panel_1.add(btnGncelleDoktor);
								
								JButton btnDKSil = new JButton("Sil");
								btnDKSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnDKSil.setBounds(457, 321, 123, 27);
								panel_1.add(btnDKSil);
								
								JButton btnDKIzinKullan = new JButton("İzin Kullan");
								btnDKIzinKullan.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnDKIzinKullan.setBounds(618, 321, 123, 27);
								panel_1.add(btnDKIzinKullan);
								
								JPanel panel_8_1 = new JPanel();
								panel_8_1.setLayout(null);
								panel_8_1.setBounds(0, 0, 188, 376);
								DoktorKayitPanel.add(panel_8_1);
								
								JButton btnHasAra_1_1_1 = new JButton("Ara");
								btnHasAra_1_1_1.setBounds(102, 0, 86, 21);
								panel_8_1.add(btnHasAra_1_1_1);
								
								textField_30 = new JTextField();
								textField_30.setColumns(10);
								textField_30.setBounds(0, 0, 101, 21);
								panel_8_1.add(textField_30);
								
								JTree tree_1_2_1 = new JTree();
								tree_1_2_1.setBounds(0, 22, 188, 355);
								panel_8_1.add(tree_1_2_1);
								
								//Doktor Kayıt Panel End
								//Personel Kayıt Panel Start
								JPanel PersonelKayitPanel = new JPanel();
								tabbedPane.addTab("Personel Kayıt", null, PersonelKayitPanel, null);
								PersonelKayitPanel.setLayout(null);
								
								JPanel panel_3_1 = new JPanel();
								panel_3_1.setLayout(null);
								panel_3_1.setBounds(0, 0, 1000, 376);
								PersonelKayitPanel.add(panel_3_1);
								
								JPanel panel_8_4 = new JPanel();
								panel_8_4.setLayout(null);
								panel_8_4.setBounds(0, 0, 188, 376);
								panel_3_1.add(panel_8_4);
								
								JButton btnHasAra_1_1_2 = new JButton("Ara");
								btnHasAra_1_1_2.setBounds(102, 0, 86, 21);
								panel_8_4.add(btnHasAra_1_1_2);
								
								textField_19 = new JTextField();
								textField_19.setColumns(10);
								textField_19.setBounds(0, 0, 101, 21);
								panel_8_4.add(textField_19);
								
								JTree tree_1_2_2 = new JTree();
								tree_1_2_2.setBounds(0, 22, 188, 355);
								panel_8_4.add(tree_1_2_2);
								
								JPanel panel_3 = new JPanel();
								panel_3.setBounds(198, 0, 802, 376);
								panel_3_1.add(panel_3);
								panel_3.setLayout(null);
								
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
								cboxPKCinsiyet.setBounds(144, 145, 179, 22);
								panel_5_4_2.add(cboxPKCinsiyet);
								
								textField_31 = new JTextField();
								textField_31.setColumns(10);
								textField_31.setBounds(144, 23, 179, 20);
								panel_5_4_2.add(textField_31);
								
								textField_32 = new JTextField();
								textField_32.setColumns(10);
								textField_32.setBounds(144, 55, 179, 20);
								panel_5_4_2.add(textField_32);
								
								textField_33 = new JTextField();
								textField_33.setColumns(10);
								textField_33.setBounds(144, 85, 179, 20);
								panel_5_4_2.add(textField_33);
								
								textField_34 = new JTextField();
								textField_34.setColumns(10);
								textField_34.setBounds(144, 115, 179, 20);
								panel_5_4_2.add(textField_34);
								
								JPanel panel_5_6_1 = new JPanel();
								panel_5_6_1.setLayout(null);
								panel_5_6_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130leti\u015Fim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_6_1.setBounds(405, 0, 390, 182);
								panel_3.add(panel_5_6_1);
								
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
								
								textField_35 = new JTextField();
								textField_35.setColumns(10);
								textField_35.setBounds(105, 104, 179, 20);
								panel_5_6_1.add(textField_35);
								
								JLabel lblTelefonNumaras_1_1_1 = new JLabel("E Mail");
								lblTelefonNumaras_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblTelefonNumaras_1_1_1.setBounds(10, 145, 85, 22);
								panel_5_6_1.add(lblTelefonNumaras_1_1_1);
								
								textField_36 = new JTextField();
								textField_36.setColumns(10);
								textField_36.setBounds(105, 147, 179, 20);
								panel_5_6_1.add(textField_36);
								
								JButton btnPKKaydet = new JButton("Kaydet");
								btnPKKaydet.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnPKKaydet.setBounds(145, 317, 123, 27);
								panel_3.add(btnPKKaydet);
								
								JButton btnPKGuncelle = new JButton("Güncelle");
								btnPKGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnPKGuncelle.setBounds(311, 317, 123, 27);
								panel_3.add(btnPKGuncelle);
								
								JPanel panel_5_3_1_1 = new JPanel();
								panel_5_3_1_1.setLayout(null);
								panel_5_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130\u015F Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_3_1_1.setBounds(0, 181, 792, 111);
								panel_3.add(panel_5_3_1_1);
								
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
								
								textField_37 = new JTextField();
								textField_37.setColumns(10);
								textField_37.setBounds(158, 23, 106, 20);
								panel_5_3_1_1.add(textField_37);
								
								textField_38 = new JTextField();
								textField_38.setEditable(false);
								textField_38.setColumns(10);
								textField_38.setBounds(157, 62, 106, 20);
								panel_5_3_1_1.add(textField_38);
								
								textField_39 = new JTextField();
								textField_39.setEditable(false);
								textField_39.setColumns(10);
								textField_39.setBounds(452, 23, 106, 20);
								panel_5_3_1_1.add(textField_39);
								
								JLabel lblIzinKullan_1_1 = new JLabel("Çalışma Saatleri");
								lblIzinKullan_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblIzinKullan_1_1.setBounds(568, 25, 100, 14);
								panel_5_3_1_1.add(lblIzinKullan_1_1);
								
								textField_40 = new JTextField();
								textField_40.setColumns(10);
								textField_40.setBounds(678, 20, 106, 20);
								panel_5_3_1_1.add(textField_40);
								
								JLabel lblKullanlabilirIzinGn_1_1 = new JLabel("Görev Tanımı");
								lblKullanlabilirIzinGn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblKullanlabilirIzinGn_1_1.setBounds(305, 66, 137, 14);
								panel_5_3_1_1.add(lblKullanlabilirIzinGn_1_1);
								
								JComboBox cboxPKGTanimi = new JComboBox();
								cboxPKGTanimi.setBounds(452, 61, 106, 22);
								panel_5_3_1_1.add(cboxPKGTanimi);
								
								JButton btnPKIzinKullan = new JButton("İzin Kullan");
								btnPKIzinKullan.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnPKIzinKullan.setBounds(638, 317, 123, 27);
								panel_3.add(btnPKIzinKullan);
								
								JButton btnPKSil = new JButton("Sil");
								btnPKSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnPKSil.setBounds(478, 317, 123, 27);
								panel_3.add(btnPKSil);
								//Personel Kayıt Panel End
								//Randevu Panel Start		
								JPanel RandevuPanel = new JPanel();
								tabbedPane.addTab("Randevu Sistemi", null, RandevuPanel, null);
								RandevuPanel.setLayout(null);
								
								JPanel panel_2_1 = new JPanel();
								panel_2_1.setBounds(0, 0, 1000, 376);
								RandevuPanel.add(panel_2_1);
								panel_2_1.setLayout(null);
								
								JPanel panel_5_4_1 = new JPanel();
								panel_5_4_1.setLayout(null);
								panel_5_4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Randevu Al", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_4_1.setBounds(0, 0, 333, 376);
								panel_2_1.add(panel_5_4_1);
								
								JLabel lblNewLabel_1_1 = new JLabel("Polikinlik");
								lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblNewLabel_1_1.setBounds(10, 25, 94, 14);
								panel_5_4_1.add(lblNewLabel_1_1);
								
								JLabel lblTcKimlik_1_1 = new JLabel("Doktor");
								lblTcKimlik_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblTcKimlik_1_1.setBounds(10, 71, 87, 14);
								panel_5_4_1.add(lblTcKimlik_1_1);
								
								JLabel lblDoumTarihi_1_1 = new JLabel("Hasta T.C");
								lblDoumTarihi_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumTarihi_1_1.setBounds(10, 122, 80, 22);
								panel_5_4_1.add(lblDoumTarihi_1_1);
								
								JLabel lblDoumYeri_1_1 = new JLabel("Tarih");
								lblDoumYeri_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumYeri_1_1.setBounds(10, 173, 68, 22);
								panel_5_4_1.add(lblDoumYeri_1_1);
								
								txtRSALHastaTc = new JTextField();
								txtRSALHastaTc.setColumns(10);
								txtRSALHastaTc.setBounds(112, 125, 179, 20);
								panel_5_4_1.add(txtRSALHastaTc);
								
								dcRSALTarih = new JDateChooser();
								dcRSALTarih.setBounds(112, 173, 179, 21);
								panel_5_4_1.add(dcRSALTarih);
								
								JComboBox cboxRSALPolikinlik = new JComboBox();
								cboxRSALPolikinlik.setBounds(112, 23, 179, 22);
								panel_5_4_1.add(cboxRSALPolikinlik);
								
								JButton btnRSAl = new JButton("Randevu Al");
								btnRSAl.setBounds(112, 314, 123, 27);
								panel_5_4_1.add(btnRSAl);
								btnRSAl.setFont(new Font("Tahoma", Font.PLAIN, 13));
								
								JComboBox cboxRSALDoktorAdi = new JComboBox();
								cboxRSALDoktorAdi.setBounds(112, 69, 179, 22);
								panel_5_4_1.add(cboxRSALDoktorAdi);
								
								JLabel lblDoumYeri_1_1_2 = new JLabel("Saat");
								lblDoumYeri_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumYeri_1_1_2.setBounds(10, 227, 68, 22);
								panel_5_4_1.add(lblDoumYeri_1_1_2);
								
								JComboBox cboxRSALSaat = new JComboBox();
								cboxRSALSaat.setBounds(112, 229, 179, 22);
								panel_5_4_1.add(cboxRSALSaat);
								panel_5_4_1_1.setBounds(327, 0, 333, 376);
								panel_2_1.add(panel_5_4_1_1);
								panel_5_4_1_1.setLayout(null);
								panel_5_4_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Randevu Sil", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								
								JLabel lblDoumTarihi_1_1_1 = new JLabel("Hasta T.C");
								lblDoumTarihi_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumTarihi_1_1_1.setBounds(10, 25, 88, 22);
								panel_5_4_1_1.add(lblDoumTarihi_1_1_1);
								
								textField_4 = new JTextField();
								textField_4.setColumns(10);
								textField_4.setBounds(112, 25, 103, 20);
								panel_5_4_1_1.add(textField_4);
								
								JButton btnRSSil = new JButton("Randevu Sil");
								btnRSSil.setBounds(112, 314, 123, 27);
								panel_5_4_1_1.add(btnRSSil);
								btnRSSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
								
								JButton btnAra = new JButton("Ara");
								btnAra.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnAra.setBounds(222, 25, 69, 20);
								panel_5_4_1_1.add(btnAra);
								
								JComboBox cboxRSSilRandevular = new JComboBox();
								cboxRSSilRandevular.setBounds(112, 71, 179, 22);
								panel_5_4_1_1.add(cboxRSSilRandevular);
								
								JLabel lblNewLabel_1_1_1 = new JLabel("Randevular");
								lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblNewLabel_1_1_1.setBounds(10, 71, 96, 14);
								panel_5_4_1_1.add(lblNewLabel_1_1_1);
								
								JPanel panel_5_4_1_1_1 = new JPanel();
								panel_5_4_1_1_1.setLayout(null);
								panel_5_4_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Randevu G\u00FCncelle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_4_1_1_1.setBounds(657, 0, 333, 376);
								panel_2_1.add(panel_5_4_1_1_1);
								
								JLabel lblDoumTarihi_1_1_1_1 = new JLabel("Hasta T.C");
								lblDoumTarihi_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumTarihi_1_1_1_1.setBounds(10, 25, 96, 22);
								panel_5_4_1_1_1.add(lblDoumTarihi_1_1_1_1);
								
								textField_2 = new JTextField();
								textField_2.setColumns(10);
								textField_2.setBounds(112, 25, 103, 20);
								panel_5_4_1_1_1.add(textField_2);
								
								JButton btnRandevuGncelle = new JButton("Randevu Güncelle");
								btnRandevuGncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnRandevuGncelle.setBounds(97, 314, 169, 27);
								panel_5_4_1_1_1.add(btnRandevuGncelle);
								
								JButton btnAra_1 = new JButton("Ara");
								btnAra_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnAra_1.setBounds(225, 24, 69, 20);
								panel_5_4_1_1_1.add(btnAra_1);
								
								JComboBox cboxRSSGuncelleRandevular_1 = new JComboBox();
								cboxRSSGuncelleRandevular_1.setBounds(112, 67, 179, 22);
								panel_5_4_1_1_1.add(cboxRSSGuncelleRandevular_1);
								
								JLabel lblNewLabel_1_1_1_1 = new JLabel("Randevular");
								lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblNewLabel_1_1_1_1.setBounds(10, 69, 96, 14);
								panel_5_4_1_1_1.add(lblNewLabel_1_1_1_1);
								
								JDateChooser dcRSALTarih_1 = new JDateChooser();
								dcRSALTarih_1.setBounds(115, 173, 179, 21);
								panel_5_4_1_1_1.add(dcRSALTarih_1);
								
								JLabel lblDoumYeri_1_1_1 = new JLabel("Tarih");
								lblDoumYeri_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumYeri_1_1_1.setBounds(10, 173, 68, 22);
								panel_5_4_1_1_1.add(lblDoumYeri_1_1_1);
								
								JLabel lblTcKimlik_1_1_1 = new JLabel("Doktor");
								lblTcKimlik_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblTcKimlik_1_1_1.setBounds(10, 120, 87, 14);
								panel_5_4_1_1_1.add(lblTcKimlik_1_1_1);
								
								JComboBox cboxRSGuncelleDoktorAdi_1 = new JComboBox();
								cboxRSGuncelleDoktorAdi_1.setBounds(112, 118, 179, 22);
								panel_5_4_1_1_1.add(cboxRSGuncelleDoktorAdi_1);
								
								JComboBox cboxRSGuncelleSaat_1 = new JComboBox();
								cboxRSGuncelleSaat_1.setBounds(112, 227, 179, 22);
								panel_5_4_1_1_1.add(cboxRSGuncelleSaat_1);
								
								JLabel lblDoumYeri_1_1_2_1 = new JLabel("Saat");
								lblDoumYeri_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumYeri_1_1_2_1.setBounds(10, 225, 68, 22);
								panel_5_4_1_1_1.add(lblDoumYeri_1_1_2_1);
								
								JPanel panel_8_2 = new JPanel();
								panel_8_2.setLayout(null);
								panel_8_2.setBounds(0, 0, 188, 376);
								RandevuPanel.add(panel_8_2);
								//Randevu Panel End
							}
						}
						
					else {
						txtgirisTc.setText("");
						txtGirisPassword.setText("");
						 JOptionPane.showMessageDialog(HomePanel,"Böyle bir kullanıcı bulunmuyor.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGiris.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnGiris.setBounds(28, 233, 221, 32);
		GirisPanel.add(btnGiris);
		
		JLabel lblNewLabel_3 = new JLabel("Hoşgeldiniz");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(137, 79, 200, 33);
		GirisPanel.add(lblNewLabel_3);
		
		JButton btnKaytOl = new JButton("Kayıt Ol");
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login ll = new Login();
				ll.setVisible(true);
			}
		});
		btnKaytOl.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnKaytOl.setBounds(251, 233, 221, 32);
		GirisPanel.add(btnKaytOl);
		
		JPanel FotoPanel = new JPanel();
		FotoPanel.setBackground(new Color(196, 196, 196));
		FotoPanel.setForeground(new Color(255, 255, 255));
		FotoPanel.setBounds(500, 0, 500, 376);
		panel_2.add(FotoPanel);
		FotoPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\EclipseProje\\HospitalManagementSystem\\icons\\Saglikbakanligi_logo.png"));
		lblNewLabel_2.setBounds(116, 42, 308, 300);
		FotoPanel.add(lblNewLabel_2);
		
		
	}
}
