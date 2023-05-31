package Main;

import java.awt.EventQueue;

import Class.Appointment;
import Class.Doctor;
import Class.EmergencyPatient;
import Class.Member;
import Class.Patient;
import Class.Personel;
import Class.Policlinic;

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
import java.awt.Panel;
import java.awt.TextField;
import java.time.*;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bg = new ButtonGroup();
	private ButtonGroup bg2 = new ButtonGroup();
	private ArrayList<Member> member = new ArrayList<Member>();
	private ArrayList<Policlinic> policlinic = new ArrayList<Policlinic>();
	private JTextField txtRSALHastaTc;
	private JTextField txtHKArama;
	private JTextField txtAShastaAdi;
	private JTextField txtASsuur;
	private JTextField txtASates;
	private JTextField txtASnabiz;
	private JTextField txtASekg;
	private JTextField txtAStc;
	private final JPanel panel_5_4_1_1 = new JPanel();
	private JTextField txtRsSilTc;
	private JTextField txtRSGunTc;
	private Connection c;
	private Statement s;
	private JTextField txtgirisTc;
	private JPasswordField txtGirisPassword;
	private JTextField txtHKAdSoyad;
	private JTextField txtHKTc;
	private JTextField txtHKDogYer;
	private JTextField txtHKTelNo;
	private JTextField txtHKSicilNo;
	private JTextField txtHKRefAdi;
	private JTextField txtHKYakinlik;
	private JTextField txtHKBoy;
	private JTextField txtHKKilo;
	private JTextField txtHKEkg;
	private JTextField txtdkAd;
	private JTextField txtDkTc;
	private JTextField txtDkDogYıl;
	private JTextField txtDkDogYer;
	private JTextField txtDkAlan;
	private JTextField txtDkTel;
	private JTextField txtDkMail;
	private JTextField txtDkTopIzin;
	private JTextField txtdkCalsaati;
	private JTextField textField_30;
	private JTextField textField_19;
	private JTextField txtPkAd;
	private JTextField txtPkTc;
	private JTextField txtPkDogYil;
	private JTextField txtPkDogYer;
	private JTextField txtPkTel;
	private JTextField txtPkMail;
	private JTextField txtPkToplamIzin;
	private JTextField txtPkCalSaati;
	private JTextField textField_3;
	private JTextField txtHkSonGun;
	private JTextField txtHkDogTar;
	private JTextField txtRsAlTarih;
	private JTextField txtRsGunTarih;
//DB Connection Start
	public void getConnection() throws ClassNotFoundException, SQLException {		
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DbHospitalManagementSystem", "postgres", "bdroomay6715");
		s = c.createStatement();
		System.out.println("Opened database successfully");
	}
//DB Connection End
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

	public void listCombo(JComboBox comboBox,String str) {
		String sql1 = "SELECT \"RandevuKodu\",\"DoktorAdi\", \"Tarih\" FROM public.\"Appointment\" where \"Tc\"='"+str+"';";
		ResultSet rs;		
		try {
			rs = s.executeQuery(sql1);
			int rc = 0;
			ArrayList<String> a=new ArrayList<>();
			while (rs.next()) {
				int rkodu = rs.getInt("RandevuKodu");
				String dadi = rs.getString("DoktorAdi");
				String tarih = rs.getString("Tarih");
				a.add(dadi+" "+tarih);				
				rc++;
			}
			Object s[]=a.toArray();
			comboBox.setModel(new DefaultComboBoxModel(s));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listJtreePersonel(JPanel panel) {
		try {
            // SQL sorgusu
	    	String sql="SELECT \"Ad\", \"Tc\",\"GorevId\" FROM public.\"Personel\";";

            // Sorguyu çalıştırma
            ResultSet resultSet = s.executeQuery(sql);

            // JTree kök düğümü
            DefaultMutableTreeNode rootPersonel = new DefaultMutableTreeNode("Personeller");

            // Verileri JTree'e ekleme
            while (resultSet.next()) {
            	String Tc= resultSet.getString("Tc");
                int GorevId = resultSet.getInt("GorevId");
                String ad = resultSet.getString("Ad");
             // Veriyi ilgili klasöre yerleştirme
                DefaultMutableTreeNode klasorNode;
                switch (GorevId) {
                    case 1:
                        klasorNode = findOrCreateFolder(rootPersonel, "Güvenlik Görevlisi");
                        break;
                    case 2:
                        klasorNode = findOrCreateFolder(rootPersonel, "Hasta Bakıcı");
                        break;
                    case 3:
                        klasorNode = findOrCreateFolder(rootPersonel,"Temizlik Görevlisi");
                        break; 
                    case 4:
                        klasorNode = findOrCreateFolder(rootPersonel,"İdari İşler");
                        break; 
                    default:
                        continue;
                }

                DefaultMutableTreeNode veriNode = new DefaultMutableTreeNode(ad);
                klasorNode.add(veriNode);
            }

            // JTree'i oluşturma ve gösterme
            JTree tree_1_2_2 = new JTree(rootPersonel);
    		tree_1_2_2.setBounds(0, 22, 188, 355);
    		panel.add(tree_1_2_2);
            
            JButton btnPersonelAra = new JButton("Ara");
            btnPersonelAra.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		TreePath selectionPath = tree_1_2_2.getSelectionPath();
    	    		if (selectionPath != null) {
    	    		    // Seçilen düğüm varsa, düğümü alabilirsiniz
    	    		    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
    	    		    
    	    		    // Düğümün değerini veya adını almak için kullanabilirsiniz
    	    		    String selectedNodeName = selectedNode.toString();
    	    		    
    	    		    // Alınan bilgileri kullanabilirsiniz
    	    		    PerUpdatePanel pup = new PerUpdatePanel();
    		    		pup.GelenVeri(selectedNodeName);
    			    	pup.setVisible(true);
    	    		} else {
    	    		    // Hiçbir düğüm seçilmemişse veya seçim yoksa
    	    		    System.out.println("Hiçbir düğüm seçilmedi.");
    	    		}
            	}
            });
    		btnPersonelAra.setBounds(102, 0, 86, 21);
    		panel.add(btnPersonelAra);
    		
    		
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void listJtreeDoctor(JPanel panel) {
		try {
            // SQL sorgusu
	    	String sql="SELECT \"Ad\", \"Tc\",\"PolId\" FROM public.\"Doctor\";";

            // Sorguyu çalıştırma
            ResultSet resultSet = s.executeQuery(sql);

            // JTree kök düğümü
            DefaultMutableTreeNode rootDoktor = new DefaultMutableTreeNode("Doktorlar");

            // Verileri JTree'e ekleme
            while (resultSet.next()) {
            	String Tc= resultSet.getString("Tc");
                int PolId = resultSet.getInt("PolId");
                String ad = resultSet.getString("Ad");
             // Veriyi ilgili klasöre yerleştirme
                DefaultMutableTreeNode klasorNode;
                switch (PolId) {
                    case 1:
                        klasorNode = findOrCreateFolder(rootDoktor, "Fiziksel Tıp ve Rahabilitasyon");
                        break;
                    case 2:
                        klasorNode = findOrCreateFolder(rootDoktor, "Kalp ve Damar Cerrahisi");
                        break;
                    case 3:
                        klasorNode = findOrCreateFolder(rootDoktor,"Kardiyoloji");
                        break;
                    case 4:
                        klasorNode = findOrCreateFolder(rootDoktor, "Kulak Burun Boğaz");
                        break;
                    case 5:
                        klasorNode = findOrCreateFolder(rootDoktor, "Radyoloji");
                        break;
                    case 6:
                        klasorNode = findOrCreateFolder(rootDoktor, "Üroloji");
                        break;
                    case 7:
                        klasorNode = findOrCreateFolder(rootDoktor, "Beyin ve Sinir Cerrahisi");
                        break;
                    case 8:
                        klasorNode = findOrCreateFolder(rootDoktor, "Gastroenteroloji");
                        break;
                    case 9:
                        klasorNode = findOrCreateFolder(rootDoktor, "Genel Cerrahi");
                        break;
                    case 10:
                        klasorNode = findOrCreateFolder(rootDoktor, "Göz Hastalıkları");
                        break;
                    case 11:
                        klasorNode = findOrCreateFolder(rootDoktor, "Psikiyatri");
                        break;
                    default:
                        continue;
                }
                DefaultMutableTreeNode veriNode = new DefaultMutableTreeNode(ad);
                klasorNode.add(veriNode);
            }
    		
    		JTree tree_1_2 = new JTree(rootDoktor);
    		tree_1_2.setBounds(0, 22, 188, 355);
    		panel.add(tree_1_2);
            // JTree'i oluşturma ve gösterme
    		JButton btnDKAra = new JButton("Ara");
    		btnDKAra.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				TreePath selectionPath = tree_1_2.getSelectionPath();
    	    		if (selectionPath != null) {
    	    		    // Seçilen düğüm varsa, düğümü alabilirsiniz
    	    		    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
    	    		    
    	    		    // Düğümün değerini veya adını almak için kullanabilirsiniz
    	    		    String selectedNodeName = selectedNode.toString();
    	    		    
    	    		    // Alınan bilgileri kullanabilirsiniz
    	    		    DocUpdatePanel doc = new DocUpdatePanel();
    		    		doc.GelenVeri(selectedNodeName);
    			    	doc.setVisible(true);
    	    		} else {
    	    		    // Hiçbir düğüm seçilmemişse veya seçim yoksa
    	    		    System.out.println("Hiçbir düğüm seçilmedi.");
    	    		}
    			}
    		});
    		btnDKAra.setBounds(102, 0, 86, 20);
    		panel.add(btnDKAra);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void listjtreePatient(JPanel panel) {
		//Jtree Patient
				try {
		            // SQL sorgusu
			    	String sql="SELECT \"Ad\",\"Tc\",\"PolId\" FROM PUBLIC.\"Patient\"";

		            // Sorguyu çalıştırma
		            ResultSet resultSet = s.executeQuery(sql);

		            // JTree kök düğümü
		            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Hastalar");

		            // Verileri JTree'e ekleme
		            while (resultSet.next()) {
		            	String Tc= resultSet.getString("Tc");
		                int PolId = resultSet.getInt("PolId");
		                String ad = resultSet.getString("Ad");
		             // Veriyi ilgili klasöre yerleştirme
		                DefaultMutableTreeNode klasorNode;
		                switch (PolId) {
		                    case 1:
		                        klasorNode = findOrCreateFolder(root, "Fiziksel Tıp ve Rahabilitasyon");
		                        break;
		                    case 2:
		                        klasorNode = findOrCreateFolder(root, "Kalp ve Damar Cerrahisi");
		                        break;
		                    case 3:
		                        klasorNode = findOrCreateFolder(root,"Kardiyoloji");
		                        break;
		                    case 4:
		                        klasorNode = findOrCreateFolder(root, "Kulak Burun Boğaz");
		                        break;
		                    case 5:
		                        klasorNode = findOrCreateFolder(root, "Radyoloji");
		                        break;
		                    case 6:
		                        klasorNode = findOrCreateFolder(root, "Üroloji");
		                        break;
		                    case 7:
		                        klasorNode = findOrCreateFolder(root, "Beyin ve Sinir Cerrahisi");
		                        break;
		                    case 8:
		                        klasorNode = findOrCreateFolder(root, "Gastroenteroloji");
		                        break;
		                    case 9:
		                        klasorNode = findOrCreateFolder(root, "Genel Cerrahi");
		                        break;
		                    case 10:
		                        klasorNode = findOrCreateFolder(root, "Göz Hastalıkları");
		                        break;
		                    case 11:
		                        klasorNode = findOrCreateFolder(root, "Psikiyatri");
		                        break;
		                    default:
		                        continue;
		                }

		                DefaultMutableTreeNode veriNode = new DefaultMutableTreeNode(ad);
		                klasorNode.add(veriNode);
		            }

		            // JTree'i oluşturma ve gösterme
		       		JTree tree_1_2 = new JTree(root);
		    		tree_1_2.setBounds(0, 22, 188, 355);						
		    		panel.add(tree_1_2);

		    		JButton btnHKAra = new JButton("Ara");
		    		btnHKAra.addActionListener(new ActionListener() {
		    			public void actionPerformed(ActionEvent e) {
		    				TreePath selectionPath = tree_1_2.getSelectionPath();
		    	    		if (selectionPath != null) {
		    	    		    // Seçilen düğüm varsa, düğümü alabilirsiniz
		    	    		    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
		    	    		    
		    	    		    // Düğümün değerini veya adını almak için kullanabilirsiniz
		    	    		    String selectedNodeName = selectedNode.toString();
		    	    		    
		    	    		    // Alınan bilgileri kullanabilirsiniz
	        		    		HKUpdatePanel hkp = new HKUpdatePanel();
	        		    		hkp.GelenVeri(selectedNodeName);
	        			    	hkp.setVisible(true);
		    	    		} else {
		    	    		    // Hiçbir düğüm seçilmemişse veya seçim yoksa
		    	    		    System.out.println("Hiçbir düğüm seçilmedi.");
		    	    		}
		    			}
		    		});
		    		btnHKAra.setBounds(102, 0, 86, 20);
		    		panel.add(btnHKAra);
				} catch (Exception e) {
					// TODO: handle exception
				}
		       	
				//Jtree Patient end
	}
	public void listJtreeEmergencyPatient(JPanel panel) {
		//Jtree Patient
				try {
		            // SQL sorgusu
			    	String sql="SELECT \"Adi\", \"Tc\", \"RenkId\" FROM public.\"EmergencyPatient\";";

		            // Sorguyu çalıştırma
		            ResultSet resultSet = s.executeQuery(sql);

		            // JTree kök düğümü
		            DefaultMutableTreeNode Acilroot = new DefaultMutableTreeNode("Acil Hastalar");

		            // Verileri JTree'e ekleme
		            while (resultSet.next()) {
		            	String Tc= resultSet.getString("Tc");
		                int RenkId = resultSet.getInt("RenkId");
		                String ad = resultSet.getString("Adi");
		             // Veriyi ilgili klasöre yerleştirme
		                DefaultMutableTreeNode klasorNode;
		                switch (RenkId) {
		                    case 1:
		                        klasorNode = findOrCreateFolder(Acilroot, "Kırmızı");
		                        break;
		                    case 2:
		                        klasorNode = findOrCreateFolder(Acilroot, "Sarı");
		                        break;
		                    case 3:
		                        klasorNode = findOrCreateFolder(Acilroot,"Yeşil");
		                        break;
		                   
		                    default:
		                        continue;
		                }

		                DefaultMutableTreeNode Verinodes = new DefaultMutableTreeNode(ad);
		                klasorNode.add(Verinodes); 
		            }
		            JTree tree_1_2_2_1 = new JTree(Acilroot);
		    		tree_1_2_2_1.setBounds(0, 22, 188, 355);
		    		panel.add(tree_1_2_2_1);
		    		
		    		JButton btnHasAra_1_1_2_1 = new JButton("Ara");
		    		btnHasAra_1_1_2_1.addActionListener(new ActionListener() {
		    			public void actionPerformed(ActionEvent e) {
		    				TreePath selectionPath = tree_1_2_2_1.getSelectionPath();
		    	    		if (selectionPath != null) {
		    	    		    // Seçilen düğüm varsa, düğümü alabilirsiniz
		    	    		    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
		    	    		    
		    	    		    // Düğümün değerini veya adını almak için kullanabilirsiniz
		    	    		    String selectedNodeName = selectedNode.toString();
		    	    		    
		    	    		    // Alınan bilgileri kullanabilirsiniz
	        		    		ASerUpdatePanel asp = new ASerUpdatePanel();
	        		    		asp.GelenVeri(selectedNodeName);
	        			    	asp.setVisible(true);
		    	    		}else {
		    	    		    // Hiçbir düğüm seçilmemişse veya seçim yoksa
		    	    		    System.out.println("Hiçbir düğüm seçilmedi.");
		    	    		}
		    			}
		    		});
		    		btnHasAra_1_1_2_1.setBounds(102, 0, 86, 21);
		    		panel.add(btnHasAra_1_1_2_1);
		            }catch (Exception e) {
						// TODO: handle exception
					
		            }
	}
	public void listDoktor(JComboBox cbox,Integer ab) {
		String sql1 = "SELECT \"Ad\" FROM public.\"Doctor\" Where \"PolId\" = "+ab+";";
		ResultSet rs;		
		try {
			rs = s.executeQuery(sql1);
			int rc = 0;
			ArrayList<String> a=new ArrayList<>();
			while (rs.next()) {
				String name = rs.getString("Ad");
				a.add(name);				
				rc++;
			}
			Object s[]=a.toArray();
			cbox.setModel(new DefaultComboBoxModel(s));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	public void searchNodeRecursive(DefaultMutableTreeNode node, String searchQuery) {
	    // Düğüm adını arama sorgusuyla karşılaştır
	    if (node.toString().equalsIgnoreCase(searchQuery)) {
	        System.out.println("Eşleşen düğüm bulundu: " + node.toString());
	        
	    }

	    // Alt düğümleri kontrol etmek için döngü kullan
	    int childCount = node.getChildCount();
	    for (int i = 0; i < childCount; i++) {
	        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
	        searchNodeRecursive(childNode, searchQuery);
	    }
	}

	public void searchNode(JTree tree, String searchQuery) {
	    DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) tree.getModel().getRoot();
	    searchNodeRecursive(rootNode, searchQuery);
	}

    private static DefaultMutableTreeNode findOrCreateFolder(DefaultMutableTreeNode parent, String folderName) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) parent.getChildAt(i);
            if (child.getUserObject().equals(folderName)) {
                return child;
            }
        }
        DefaultMutableTreeNode newFolder = new DefaultMutableTreeNode(folderName);
        parent.add(newFolder);
        return newFolder;
    }
	
    public void Delete(JPanel panel,String TabloAdi) {
    	String DelTc=JOptionPane.showInputDialog(panel,"Silmek istediğiniz kişinin Tc Kimlik numarasını Giriniz");
		if(DelTc!=null) {
			int reply = JOptionPane.showConfirmDialog(panel, ""+DelTc+" Kimlik numaralı kişiyi silmek istiyorsunuz Emin misiniz?", "Emin misiniz?", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				try {
					String Sql1="DELETE FROM public.\""+TabloAdi+"\" WHERE \"Tc\"= '"+DelTc+"';";
					int rs= s.executeUpdate(Sql1);
					if (rs==1) {
						JOptionPane.showMessageDialog(panel, "Kişi başarılı bir şekilde silindi");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			} 
		}
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
				member = new ArrayList<Member>();
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


								
								txtHKArama = new JTextField();
								txtHKArama.setToolTipText("");
								txtHKArama.setColumns(10);
								txtHKArama.setBounds(0, 0, 101, 21);
								panel_8.add(txtHKArama);
								listjtreePatient(panel_8);
								

								JPanel panel = new JPanel();
								panel.setBounds(198, 0, 802, 376);
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
								
								JLabel lblDoumTarihi = new JLabel("Doğum Yılı");
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
								cboxHKCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Erkek", "Kadın"}));
								cboxHKCinsiyet.setBounds(144, 125, 106, 22);
								panel_5.add(cboxHKCinsiyet);
								
								txtHKAdSoyad = new JTextField();
								txtHKAdSoyad.setColumns(10);
								txtHKAdSoyad.setBounds(144, 23, 106, 20);
								panel_5.add(txtHKAdSoyad);
								
								txtHKTc = new JTextField();
								txtHKTc.setColumns(10);
								txtHKTc.setBounds(144, 50, 106, 20);
								panel_5.add(txtHKTc);
								
								txtHKDogYer = new JTextField();
								txtHKDogYer.setColumns(10);
								txtHKDogYer.setBounds(144, 100, 106, 20);
								panel_5.add(txtHKDogYer);
								
								txtHkDogTar = new JTextField();
								txtHkDogTar.setColumns(10);
								txtHkDogTar.setBounds(144, 74, 106, 20);
								panel_5.add(txtHkDogTar);
								
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
								
								txtHKTelNo = new JTextField();
								txtHKTelNo.setColumns(10);
								txtHKTelNo.setBounds(105, 125, 145, 20);
								panel_5_1.add(txtHKTelNo);
								
								JTextArea txthkAdres = new JTextArea();
								txthkAdres.setBounds(105, 26, 145, 88);
								panel_5_1.add(txthkAdres);
								
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
								
								txtHKSicilNo = new JTextField();
								txtHKSicilNo.setColumns(10);
								txtHKSicilNo.setBounds(144, 50, 106, 20);
								panel_5_2.add(txtHKSicilNo);
								
								JComboBox cboxHKSigTur = new JComboBox();
								cboxHKSigTur.setModel(new DefaultComboBoxModel(new String[] {"Sgk", "Bagkur"}));
								cboxHKSigTur.setBounds(144, 22, 106, 22);
								panel_5_2.add(cboxHKSigTur);
								
								JLabel lblRefakatBilgileri = new JLabel("Refakatçı Adı");
								lblRefakatBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblRefakatBilgileri.setBounds(10, 75, 124, 14);
								panel_5_2.add(lblRefakatBilgileri);
								
								txtHKRefAdi = new JTextField();
								txtHKRefAdi.setColumns(10);
								txtHKRefAdi.setBounds(144, 75, 106, 20);
								panel_5_2.add(txtHKRefAdi);
								
								JLabel lblHKRefDerece = new JLabel("Yakınlık Derecesi");
								lblHKRefDerece.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblHKRefDerece.setBounds(10, 103, 124, 14);
								panel_5_2.add(lblHKRefDerece);
								
								txtHKYakinlik = new JTextField();
								txtHKYakinlik.setColumns(10);
								txtHKYakinlik.setBounds(144, 101, 106, 20);
								panel_5_2.add(txtHKYakinlik);
								
								JLabel lblPolikinlik = new JLabel("Polikinlik");
								lblPolikinlik.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblPolikinlik.setBounds(10, 128, 106, 22);
								panel_5_2.add(lblPolikinlik);
								
								JComboBox cboxHKPol = new JComboBox();
								cboxHKPol.setModel(new DefaultComboBoxModel(new String[] {"Fiziksel Tıp ve Rehabilitasyon", "Kalp ve Damar Cerrahisi", "Kardiyoloji", "Kulak Burun Boğaz", "Radyoloji", "Üroloji", "Beyin ve Sinir Cerrahisi", "Gastroenteroloji", "Genel Cerrahi", "Göz Hastalıkları", "Psikiyatri"}));
								cboxHKPol.setBounds(144, 129, 106, 22);
								panel_5_2.add(cboxHKPol);
								
								JPanel panel_5_3 = new JPanel();
								panel_5_3.setLayout(null);
								panel_5_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hastal\u0131k Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_3.setBounds(0, 167, 815, 160);
								panel.add(panel_5_3);
								
								JLabel lblBoy = new JLabel("Boy");
								lblBoy.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblBoy.setBounds(10, 25, 124, 14);
								panel_5_3.add(lblBoy);
								
								txtHKBoy = new JTextField();
								txtHKBoy.setColumns(10);
								txtHKBoy.setBounds(144, 23, 106, 20);
								panel_5_3.add(txtHKBoy);
								
								JLabel lblKilo = new JLabel("Kilo");
								lblKilo.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblKilo.setBounds(10, 60, 124, 14);
								panel_5_3.add(lblKilo);
								
								txtHKKilo = new JTextField();
								txtHKKilo.setColumns(10);
								txtHKKilo.setBounds(144, 58, 106, 20);
								panel_5_3.add(txtHKKilo);
								
								JLabel lblEkg = new JLabel("Kan Grubu");
								lblEkg.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblEkg.setBounds(10, 93, 124, 14);
								panel_5_3.add(lblEkg);
								
								JLabel lblSonGncelleme = new JLabel("Son Güncelleme");
								lblSonGncelleme.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblSonGncelleme.setBounds(553, 25, 124, 14);
								panel_5_3.add(lblSonGncelleme);
								
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
								
								JComboBox cboxHKKanGrub = new JComboBox();
								cboxHKKanGrub.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "0+", "0-"}));
								cboxHKKanGrub.setBounds(144, 89, 106, 22);
								panel_5_3.add(cboxHKKanGrub);
								
								JLabel lblKullandIlalar = new JLabel("Kullandığı İlaçlar");
								lblKullandIlalar.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblKullandIlalar.setBounds(284, 70, 124, 17);
								panel_5_3.add(lblKullandIlalar);
								
								JTextArea txtHKilaclar = new JTextArea();
								txtHKilaclar.setBounds(284, 94, 240, 45);
								panel_5_3.add(txtHKilaclar);
								
								txtHkSonGun = new JTextField();
								txtHkSonGun.setEditable(false);
								txtHkSonGun.setEnabled(false);
								txtHkSonGun.setColumns(10);
								txtHkSonGun.setBounds(687, 23, 106, 20);
								panel_5_3.add(txtHkSonGun);
								
								JLabel lblTedaviekli = new JLabel("Tedavi Şekli");
								lblTedaviekli.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblTedaviekli.setBounds(284, 26, 124, 14);
								panel_5_3.add(lblTedaviekli);
								
								JComboBox cboxHKTedaviSekli = new JComboBox();
								cboxHKTedaviSekli.setModel(new DefaultComboBoxModel(new String[] {"Ayakta", "Yatarak"}));
								cboxHKTedaviSekli.setBounds(418, 22, 106, 22);
								panel_5_3.add(cboxHKTedaviSekli);
								//Hasta Delete Start
								JButton btnHKSil = new JButton("Sil");
								btnHKSil.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										Delete(HastaKayitPanel,"Patient");
										listjtreePatient(panel_8);
									}
								});
								btnHKSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnHKSil.setBounds(441, 338, 123, 27);
								panel.add(btnHKSil);
								//Hasta Kayıt Action Start
								JButton btnKaydetHasta = new JButton("Kaydet");
								btnKaydetHasta.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										LocalDate dd=LocalDate.now();
										Patient p = new Patient();
										p.Ad=txtHKAdSoyad.getText();
										p.Tc=txtHKTc.getText();
										p.DogYeri=txtHKDogYer.getText();
										p.DogTar=Integer.parseInt(txtHkDogTar.getText());
										p.Cinsiyet = cboxHKCinsiyet.getSelectedItem().toString();
										p.Adres=txthkAdres.getText();
										p.Telefon=txtHKTelNo.getText();
										p.Boy= Integer.parseInt(txtHKBoy.getText());
										p.Kilo = Integer.parseInt(txtHKKilo.getText());
										p.KanGrubu = (String) cboxHKKanGrub.getSelectedItem();
										p.Ekg=txtHKEkg.getText();
										p.TedaviSekli= (String) cboxHKTedaviSekli.getSelectedItem();
										p.SonGuncelleme=dd;
										p.KullanilanIlac=txtHKilaclar.getText();
										p.GecmisHastalik=txtHKHastaliklar.getText();
										p.SicilNo=txtHKSicilNo.getText();
										p.SigortaTuru= (String) cboxHKSigTur.getSelectedItem();
										p.RefAdi=txtHKRefAdi.getText();
										p.RefYakinlik=txtHKYakinlik.getText();
										p.PolId= cboxHKPol.getSelectedIndex()+1;
										
										try {
											String sql1 = "INSERT INTO public.\"Patient\"(\"Ad\", \"Tc\", \"DogTar\", \"DogYer\", \"Cinsiyet\", \"Adres\", \"Telefon\", \"SigortaTuru\", \"SicilNo\", \"RefAdi\", \"RefYakinlik\",\"Boy\", \"Kilo\", \"KanGrubu\", \"Ekg\", \"TedaviSekli\", \"KullanilanIlac\", \"SonGuncelleme\", \"GecmisHastalik\", \"PolId\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
											PreparedStatement prep =c.prepareStatement(sql1);
											prep.setString(1,p.Ad);
											prep.setString(2,p.Tc);
											prep.setInt(3, p.DogTar);
											prep.setString(4, p.DogYeri);
											prep.setString(5, p.Cinsiyet);
											prep.setString(6, p.Adres);
											prep.setString(7, p.Telefon);
											prep.setString(8, p.SigortaTuru);
											prep.setString(9, p.SicilNo);
											prep.setString(10, p.RefAdi);
											prep.setString(11, p.RefYakinlik);
											prep.setInt(12, p.Boy);
											prep.setInt(13, p.Kilo);
											prep.setString(14, p.KanGrubu);
											prep.setString(15, p.Ekg);
											prep.setString(16, p.TedaviSekli);
											prep.setString(17, p.KullanilanIlac);
											prep.setObject(18, dd);
											prep.setString(19, p.GecmisHastalik);
											prep.setInt(20, p.PolId);
											int den=prep.executeUpdate();
											if (den==1) {
												JOptionPane.showMessageDialog(HomePanel,"Kayıt Başarılı");
												listjtreePatient(panel_8);
											}
										} catch (SQLException e3) {
											// TODO Auto-generated catch block
											e3.printStackTrace();
										}
									}
								});

								//Hasta Kayıt Action End
								btnKaydetHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnKaydetHasta.setBounds(236, 338, 123, 27);
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
								
								txtAShastaAdi = new JTextField();
								txtAShastaAdi.setBounds(115, 11, 130, 20);
								panel_5_4_1_2.add(txtAShastaAdi);
								txtAShastaAdi.setColumns(10);
								
								JLabel lblDoumYeri_1_1_3_3_1 = new JLabel("Şuur");
								lblDoumYeri_1_1_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumYeri_1_1_3_3_1.setBounds(24, 140, 81, 22);
								panel_5_4_1_2.add(lblDoumYeri_1_1_3_3_1);
								
								txtASsuur = new JTextField();
								txtASsuur.setColumns(10);
								txtASsuur.setBounds(115, 140, 130, 20);
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
								lblNewLabel_1_1_3_1.setBounds(24, 54, 81, 14);
								panel_5_4_1_2.add(lblNewLabel_1_1_3_1);
								
								txtAStc = new JTextField();
								txtAStc.setColumns(10);
								txtAStc.setBounds(115, 54, 130, 20);
								panel_5_4_1_2.add(txtAStc);
								
								JLabel lblRenkId = new JLabel("Acil Seviyesi");
								lblRenkId.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblRenkId.setBounds(24, 97, 81, 14);
								panel_5_4_1_2.add(lblRenkId);
								
								JComboBox cboxASRenkId = new JComboBox();
								cboxASRenkId.setModel(new DefaultComboBoxModel(new String[] {"Kırmızı", "Sarı", "Yeşil"}));
								cboxASRenkId.setBounds(115, 97, 130, 22);
								panel_5_4_1_2.add(cboxASRenkId);
								
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
								
								JPanel panel_8_4_1 = new JPanel();
								panel_8_4_1.setLayout(null);
								panel_8_4_1.setBounds(0, 0, 188, 376);
								AcilServisPanel.add(panel_8_4_1);
								
								listJtreeEmergencyPatient(panel_8_4_1);
								
								//Acil Servis Kaydet Start
								JButton btnASKaydet = new JButton("Kaydet");
								btnASKaydet.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										EmergencyPatient ep = new EmergencyPatient();
										ep.Adi=txtAShastaAdi.getText();
										ep.Ates=Float.parseFloat(txtASates.getText());
										ep.Ekg=txtASekg.getText();
										ep.HastaGecmisi=txtASgecmis.getText();
										ep.KullanilanIlac=txtASilac.getText();
										ep.Nabiz=Integer.parseInt(txtASnabiz.getText());
										ep.OnTani=txtAStani.getText();
										ep.RenkId=cboxASRenkId.getSelectedIndex()+1;
										ep.Suur=txtASsuur.getText();
										ep.Tc=txtAStc.getText();
										
										try {
											String sql1 = "INSERT INTO public.\"EmergencyPatient\"(\"Adi\", \"Tc\", \"RenkId\", \"Suur\", \"Ates\", \"Nabiz\", \"Ekg\", \"HastaGecmisi\", \"KullanilanIlac\", \"OnTani\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
											PreparedStatement prep =c.prepareStatement(sql1);
											prep.setString(1,ep.Adi);
											prep.setString(2,ep.Tc);
											prep.setInt(3, ep.RenkId);
											prep.setString(4, ep.Suur);
											prep.setFloat(5, ep.Ates);
											prep.setInt(6, ep.Nabiz);
											prep.setString(7, ep.Ekg);
											prep.setString(8, ep.HastaGecmisi);
											prep.setString(9, ep.KullanilanIlac);
											prep.setString(10, ep.OnTani);
										
											int den=prep.executeUpdate();
											if (den==1) {
												JOptionPane.showMessageDialog(HomePanel,"Kayıt Başarılı");
												txtASgecmis.setText("");
												txtASilac.setText("");
												txtAStani.setText("");
												txtASates.setText("");
												txtASekg.setText("");
												txtAShastaAdi.setText("");
												txtASnabiz.setText("");
												txtASsuur.setText("");
												txtAStc.setText("");
												cboxASRenkId.setSelectedIndex(0);
												listJtreeEmergencyPatient(panel_8_4_1);
											}
										} catch (SQLException e3) {
											// TODO Auto-generated catch block
											e3.printStackTrace();
										}
									}
								});
								
								btnASKaydet.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnASKaydet.setBounds(260, 307, 123, 27);
								panel_2_1_1.add(btnASKaydet);
								//Acil Servis Hasta Silme Start
								JButton btnSil = new JButton("Sil");
								btnSil.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										Delete(AcilServisPanel,"EmergencyPatient");
										listJtreeEmergencyPatient(panel_8_4_1);
									}
								});
								btnSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnSil.setBounds(456, 307, 123, 27);
								panel_2_1_1.add(btnSil);
								//Acil Servis Hasta Silme End

								
								textField_3 = new JTextField();
								textField_3.setColumns(10);
								textField_3.setBounds(0, 0, 101, 21);
								panel_8_4_1.add(textField_3);
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
								
								JComboBox cboxDKCinsiyet = new JComboBox();
								cboxDKCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Erkek", "Kadın"}));
								cboxDKCinsiyet.setBounds(144, 145, 106, 22);
								panel_5_4.add(cboxDKCinsiyet);
								
								txtdkAd = new JTextField();
								txtdkAd.setColumns(10);
								txtdkAd.setBounds(144, 23, 106, 20);
								panel_5_4.add(txtdkAd);
								
								txtDkTc = new JTextField();
								txtDkTc.setColumns(10);
								txtDkTc.setBounds(144, 55, 106, 20);
								panel_5_4.add(txtDkTc);
								
								txtDkDogYıl = new JTextField();
								txtDkDogYıl.setColumns(10);
								txtDkDogYıl.setBounds(144, 85, 106, 20);
								panel_5_4.add(txtDkDogYıl);
								
								txtDkDogYer = new JTextField();
								txtDkDogYer.setColumns(10);
								txtDkDogYer.setBounds(144, 115, 106, 20);
								panel_5_4.add(txtDkDogYer);
								
								
								JPanel panel_8_1 = new JPanel();
								panel_8_1.setLayout(null);
								panel_8_1.setBounds(0, 0, 188, 376);
								DoktorKayitPanel.add(panel_8_1);
								
								textField_30 = new JTextField();
								textField_30.setColumns(10);
								textField_30.setBounds(0, 0, 101, 21);
								panel_8_1.add(textField_30);
								
								listJtreeDoctor(panel_8_1);
								
								JPanel panel_5_5 = new JPanel();
								panel_5_5.setLayout(null);
								panel_5_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Akademik Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_5.setBounds(270, 0, 270, 182);
								panel_1.add(panel_5_5);
								
								JLabel lblDoumYeri_2 = new JLabel("Alanı");
								lblDoumYeri_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblDoumYeri_2.setBounds(10, 145, 124, 22);
								panel_5_5.add(lblDoumYeri_2);
								
								txtDkAlan = new JTextField();
								txtDkAlan.setColumns(10);
								txtDkAlan.setBounds(144, 145, 106, 20);
								panel_5_5.add(txtDkAlan);
								
								JLabel lblDoumYeri_2_1 = new JLabel("Polikinlik");
								lblDoumYeri_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblDoumYeri_2_1.setBounds(10, 85, 124, 22);
								panel_5_5.add(lblDoumYeri_2_1);
								
								JComboBox cboxDKPol = new JComboBox();
								cboxDKPol.setModel(new DefaultComboBoxModel(new String[] {"Fiziksel Tıp ve Rehabilitasyon", "Kalp ve Damar Cerrahisi", "Kardiyoloji", "Kulak Burun Boğaz", "Radyoloji", "Üroloji", "Beyin ve Sinir Cerrahisi", "Gastroenteroloji", "Genel Cerrahi", "Göz Hastalıkları", "Psikiyatri"}));
								cboxDKPol.setBounds(144, 86, 106, 22);
								panel_5_5.add(cboxDKPol);
								
								JLabel lblOgrSev = new JLabel("Öğrenim Seviyesi");
								lblOgrSev.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblOgrSev.setBounds(10, 30, 124, 22);
								panel_5_5.add(lblOgrSev);
								
								JComboBox cboxDkOgrSev = new JComboBox();
								cboxDkOgrSev.setModel(new DefaultComboBoxModel(new String[] {"Lisans", "Yüksek Lisans", "Doktora"}));
								cboxDkOgrSev.setBounds(144, 31, 106, 22);
								panel_5_5.add(cboxDkOgrSev);
								
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
								
								txtDkTel = new JTextField();
								txtDkTel.setColumns(10);
								txtDkTel.setBounds(105, 104, 138, 20);
								panel_5_6.add(txtDkTel);
								
								JLabel lblTelefonNumaras_1_1 = new JLabel("E Mail");
								lblTelefonNumaras_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblTelefonNumaras_1_1.setBounds(10, 145, 85, 22);
								panel_5_6.add(lblTelefonNumaras_1_1);
								
								txtDkMail = new JTextField();
								txtDkMail.setColumns(10);
								txtDkMail.setBounds(105, 147, 138, 20);
								panel_5_6.add(txtDkMail);
								
								JPanel panel_5_3_1 = new JPanel();
								panel_5_3_1.setLayout(null);
								panel_5_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130\u015F Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_3_1.setBounds(0, 181, 792, 108);
								panel_1.add(panel_5_3_1);
								
								JLabel lblizin = new JLabel("Toplam İzin Günü");
								lblizin.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblizin.setBounds(43, 48, 137, 14);
								panel_5_3_1.add(lblizin);
								
								txtDkTopIzin = new JTextField();
								txtDkTopIzin.setColumns(10);
								txtDkTopIzin.setBounds(191, 46, 106, 20);
								panel_5_3_1.add(txtDkTopIzin);
								
								JLabel lblIzinKullan_1 = new JLabel("Çalışma Saatleri");
								lblIzinKullan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblIzinKullan_1.setBounds(478, 47, 100, 14);
								panel_5_3_1.add(lblIzinKullan_1);
								
								txtdkCalsaati = new JTextField();
								txtdkCalsaati.setColumns(10);
								txtdkCalsaati.setBounds(588, 42, 106, 20);
								panel_5_3_1.add(txtdkCalsaati);
								
								JButton btnKaydetDoktor = new JButton("Kaydet");
								btnKaydetDoktor.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										Doctor d = new Doctor();
										d.Ad=txtdkAd.getText();
										d.Adres=txtDKAdres.getText();
										d.Alan=(String) cboxDkOgrSev.getSelectedItem();
										d.CalSaati=txtdkCalsaati.getText();
										d.Cinsiyet=txtdkCalsaati.getText();
										d.DogYer=txtDkDogYer.getText();
										d.Mail=txtDkMail.getText();
										d.OgrenimSeviyesi=(String)cboxDkOgrSev.getSelectedItem();
										d.PolId=(cboxDKPol.getSelectedIndex()+1);
										d.Tc=txtDkTc.getText();
										d.Telefon=txtDkTel.getText();
										d.ToplamIzin=Integer.parseInt(txtDkTopIzin.getText());
										d.DogTar=Integer.parseInt(txtDkDogYıl.getText());
										
										try {
											String sql1 = "INSERT INTO public.\"Doctor\"(\"Ad\", \"Tc\", \"DogTar\", \"DogYer\", \"Cinsiyet\", \"Adres\", \"Telefon\", \"Mail\", \"OgrenimSeviyesi\", \"Alan\", \"ToplamIzin\", \"CalSaati\", \"PolId\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
											PreparedStatement prep =c.prepareStatement(sql1);
											prep.setString(1,d.Ad);
											prep.setString(2, d.Tc);
											prep.setInt(3, d.DogTar);
											prep.setString(4, d.DogYer);
											prep.setString(5, d.Cinsiyet);
											prep.setString(6, d.Adres);
											prep.setString(7, d.Telefon);
											prep.setString(8, d.Mail);
											prep.setString(9, d.OgrenimSeviyesi);
											prep.setString(10, d.Alan);
											prep.setInt(11, d.ToplamIzin);
											prep.setString(12, d.CalSaati);
											prep.setInt(13, d.PolId);
										
											int den=prep.executeUpdate();
											if (den==1) {
												JOptionPane.showMessageDialog(HomePanel,"Kayıt Başarılı");
												
												listJtreeDoctor(panel_8_1);
											}
										} catch (SQLException e3) {
											// TODO Auto-generated catch block
											e3.printStackTrace();
										}
									}
								});
								btnKaydetDoktor.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnKaydetDoktor.setBounds(212, 321, 123, 27);
								panel_1.add(btnKaydetDoktor);
								//Doktor Sil Start
								JButton btnDKSil = new JButton("Sil");
								btnDKSil.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										Delete(DoktorKayitPanel,"Doctor");
										listJtreeDoctor(panel_8_1);
									}
								});
								btnDKSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnDKSil.setBounds(401, 321, 123, 27);
								panel_1.add(btnDKSil);
								//Doktor Sil End
								JButton btnDKIzinKullan = new JButton("İzin Kullan");
								btnDKIzinKullan.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										OffDay od = new OffDay();
										od.setVisible(true);
									}
								});
								btnDKIzinKullan.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnDKIzinKullan.setBounds(562, 321, 123, 27);
								panel_1.add(btnDKIzinKullan);
								
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
								
								
								
								textField_19 = new JTextField();
								textField_19.setColumns(10);
								textField_19.setBounds(0, 0, 101, 21);
								panel_8_4.add(textField_19);
								
								listJtreePersonel(panel_8_4);
								
								
								
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
								
								JComboBox cboxPKCinsiyet = new JComboBox();
								cboxPKCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Erkek", "Kadın"}));
								cboxPKCinsiyet.setBounds(144, 145, 179, 22);
								panel_5_4_2.add(cboxPKCinsiyet);
								
								txtPkAd = new JTextField();
								txtPkAd.setColumns(10);
								txtPkAd.setBounds(144, 23, 179, 20);
								panel_5_4_2.add(txtPkAd);
								
								txtPkTc = new JTextField();
								txtPkTc.setColumns(10);
								txtPkTc.setBounds(144, 55, 179, 20);
								panel_5_4_2.add(txtPkTc);
								
								txtPkDogYil = new JTextField();
								txtPkDogYil.setColumns(10);
								txtPkDogYil.setBounds(144, 85, 179, 20);
								panel_5_4_2.add(txtPkDogYil);
								
								txtPkDogYer = new JTextField();
								txtPkDogYer.setColumns(10);
								txtPkDogYer.setBounds(144, 115, 179, 20);
								panel_5_4_2.add(txtPkDogYer);
								
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
								
								txtPkTel = new JTextField();
								txtPkTel.setColumns(10);
								txtPkTel.setBounds(105, 104, 179, 20);
								panel_5_6_1.add(txtPkTel);
								
								JPanel panel_5_3_1_1 = new JPanel();
								panel_5_3_1_1.setLayout(null);
								panel_5_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0130\u015F Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_5_3_1_1.setBounds(0, 182, 792, 109);
								panel_3.add(panel_5_3_1_1);
								
								JLabel lblizin_1 = new JLabel("Toplam İzin Günü");
								lblizin_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblizin_1.setBounds(10, 43, 137, 14);
								panel_5_3_1_1.add(lblizin_1);
								
								txtPkToplamIzin = new JTextField();
								txtPkToplamIzin.setColumns(10);
								txtPkToplamIzin.setBounds(158, 41, 106, 20);
								panel_5_3_1_1.add(txtPkToplamIzin);
								
								JLabel lblIzinKullan_1_1 = new JLabel("Çalışma Saatleri");
								lblIzinKullan_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblIzinKullan_1_1.setBounds(568, 43, 100, 14);
								panel_5_3_1_1.add(lblIzinKullan_1_1);
								
								txtPkCalSaati = new JTextField();
								txtPkCalSaati.setColumns(10);
								txtPkCalSaati.setBounds(678, 38, 106, 20);
								panel_5_3_1_1.add(txtPkCalSaati);
								
								JLabel lblKullanlabilirIzinGn_1_1 = new JLabel("Görev Tanımı");
								lblKullanlabilirIzinGn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblKullanlabilirIzinGn_1_1.setBounds(303, 43, 100, 14);
								panel_5_3_1_1.add(lblKullanlabilirIzinGn_1_1);
								
								JComboBox cboxpkGTanimi = new JComboBox();
								cboxpkGTanimi.setModel(new DefaultComboBoxModel(new String[] {"Güvenlik Görevlisi", "Hasta Bakıcı", "Temizlik Görevlisi"}));
								cboxpkGTanimi.setBounds(413, 40, 106, 22);
								panel_5_3_1_1.add(cboxpkGTanimi);
								
								JLabel lblTelefonNumaras_1_1_1 = new JLabel("E Mail");
								lblTelefonNumaras_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								lblTelefonNumaras_1_1_1.setBounds(10, 145, 85, 22);
								panel_5_6_1.add(lblTelefonNumaras_1_1_1);
								
								txtPkMail = new JTextField();
								txtPkMail.setColumns(10);
								txtPkMail.setBounds(105, 147, 179, 20);
								panel_5_6_1.add(txtPkMail);
								//Personel Kayıt Action start
								JButton btnPKKaydet = new JButton("Kaydet");
								btnPKKaydet.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										Personel p = new Personel();
										p.Ad=txtPkAd.getText();
										p.Adres=txtPKAdres.getText();
										p.CalSaati=txtPkCalSaati.getText();
										p.Cinsiyet=(String)cboxPKCinsiyet.getSelectedItem();
										p.DogYer=txtPkDogYer.getText();
										p.DogYil=Integer.parseInt(txtPkDogYil.getText());
										p.GorevId=cboxpkGTanimi.getSelectedIndex()+1;
										p.Mail=txtPkMail.getText();
										p.Tc=txtPkTc.getText();
										p.Telefon=txtPkTel.getText();
										p.ToplamIzin=Integer.parseInt(txtPkToplamIzin.getText());
										
										try {
											String sql1 = "INSERT INTO public.\"Personel\"(\"Ad\", \"Tc\", \"DogYer\", \"Cinsiyet\", \"Adres\", \"Telefon\", \"Mail\", \"ToplamIzin\", \"CalSaati\", \"GorevId\", \"DogYil\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
											PreparedStatement prep =c.prepareStatement(sql1);
											prep.setString(1,p.Ad);
											prep.setString(2, p.Tc);
											prep.setString(3, p.DogYer);
											prep.setString(4, p.Cinsiyet);
											prep.setString(5, p.Adres);
											prep.setString(6, p.Telefon);
											prep.setString(7, p.Mail);
											prep.setInt(8, p.ToplamIzin);
											prep.setString(9, p.CalSaati);
											prep.setInt(10, p.GorevId);
											prep.setInt(11, p.DogYil);

											int den=prep.executeUpdate();
											if (den==1) {
												JOptionPane.showMessageDialog(HomePanel,"Kayıt Başarılı");
												listJtreePersonel(panel_8_4);
											}
										} catch (SQLException e3) {

											e3.printStackTrace();
										}
									}
								});
								btnPKKaydet.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnPKKaydet.setBounds(245, 317, 123, 27);
								panel_3.add(btnPKKaydet);
								//Personel Kayıt Action end
								
								
								JButton btnPKIzinKullan = new JButton("İzin Kullan");
								btnPKIzinKullan.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										OffDayPersonel ofp = new OffDayPersonel();
										ofp.setVisible(true);
												
									}
								});
								btnPKIzinKullan.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnPKIzinKullan.setBounds(565, 317, 123, 27);
								panel_3.add(btnPKIzinKullan);
								
								JButton btnPKSil = new JButton("Sil");
								btnPKSil.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										Delete(PersonelKayitPanel,"Personel");
										listJtreePersonel(panel_8_4);
									}
								});
								btnPKSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnPKSil.setBounds(405, 317, 123, 27);
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
								
								JLabel lblDoumYeri_1_1 = new JLabel("Tarih ve Saat");
								lblDoumYeri_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumYeri_1_1.setBounds(10, 173, 94, 22);
								panel_5_4_1.add(lblDoumYeri_1_1);
								
								txtRSALHastaTc = new JTextField();
								txtRSALHastaTc.setColumns(10);
								txtRSALHastaTc.setBounds(112, 125, 179, 20);
								panel_5_4_1.add(txtRSALHastaTc);
								
								JComboBox cboxRSALPolikinlik = new JComboBox();
								cboxRSALPolikinlik.setModel(new DefaultComboBoxModel(new String[] {"Fiziksel Tıp ve Rehabilitasyon", "Kalp ve Damar Cerrahisi", "Kardiyoloji", "Kulak Burun Boğaz", "Radyoloji", "Üroloji", "Beyin ve Sinir Cerrahisi", "Gastroenteroloji", "Genel Cerrahi", "Göz Hastalıkları", "Psikiyatri"}));
								cboxRSALPolikinlik.setBounds(114, 23, 112, 22);
								panel_5_4_1.add(cboxRSALPolikinlik);
								
								JComboBox cboxRSALDoktorAdi = new JComboBox();
								cboxRSALDoktorAdi.setBounds(112, 69, 179, 22);
								panel_5_4_1.add(cboxRSALDoktorAdi);
								panel_5_4_1_1.setBounds(327, 0, 333, 376);
								panel_2_1.add(panel_5_4_1_1);
								panel_5_4_1_1.setLayout(null);
								panel_5_4_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Randevu Sil", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								
								JLabel lblDoumTarihi_1_1_1 = new JLabel("Hasta T.C");
								lblDoumTarihi_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumTarihi_1_1_1.setBounds(10, 25, 88, 22);
								panel_5_4_1_1.add(lblDoumTarihi_1_1_1);
								
								txtRsSilTc = new JTextField();
								txtRsSilTc.setColumns(10);
								txtRsSilTc.setBounds(112, 25, 103, 20);
								panel_5_4_1_1.add(txtRsSilTc);
								
								JComboBox cboxRSSilRandevular = new JComboBox();
								cboxRSSilRandevular.setBounds(112, 107, 179, 22);
								panel_5_4_1_1.add(cboxRSSilRandevular);
								
								JLabel lblNewLabel_1_1_1 = new JLabel("Randevular");
								lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblNewLabel_1_1_1.setBounds(10, 107, 96, 14);
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
								
								txtRSGunTc = new JTextField();
								txtRSGunTc.setColumns(10);
								txtRSGunTc.setBounds(112, 25, 103, 20);
								panel_5_4_1_1_1.add(txtRSGunTc);
								
								
								
								JComboBox cboxRSSGuncelleRandevular_1 = new JComboBox();
								cboxRSSGuncelleRandevular_1.setBounds(112, 67, 179, 22);
								panel_5_4_1_1_1.add(cboxRSSGuncelleRandevular_1);
								
								JLabel lblNewLabel_1_1_1_1 = new JLabel("Randevular");
								lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblNewLabel_1_1_1_1.setBounds(10, 69, 96, 14);
								panel_5_4_1_1_1.add(lblNewLabel_1_1_1_1);
								
								JLabel lblDoumYeri_1_1_1 = new JLabel("Tarih ve Saat");
								lblDoumYeri_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblDoumYeri_1_1_1.setBounds(10, 173, 96, 22);
								panel_5_4_1_1_1.add(lblDoumYeri_1_1_1);
								
								JLabel lblTcKimlik_1_1_1 = new JLabel("Doktor");
								lblTcKimlik_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								lblTcKimlik_1_1_1.setBounds(10, 120, 87, 14);
								panel_5_4_1_1_1.add(lblTcKimlik_1_1_1);
								
								txtRsGunTarih = new JTextField();
								txtRsGunTarih.setColumns(10);
								txtRsGunTarih.setBounds(112, 176, 179, 20);
								panel_5_4_1_1_1.add(txtRsGunTarih);
								
								JComboBox cboxRSGuncelleDoktorAdi_1 = new JComboBox();
								cboxRSGuncelleDoktorAdi_1.setBounds(112, 118, 179, 22);
								panel_5_4_1_1_1.add(cboxRSGuncelleDoktorAdi_1);
								
								JButton btnAra_1 = new JButton("Ara");
								btnAra_1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String str=txtRSGunTc.getText(); 
										String sql = "SELECT \"RandevuKodu\",\"DoktorAdi\", \"Tarih\" FROM public.\"Appointment\" where \"Tc\"='"+str+"';";
										ResultSet rs;		
										try {
											rs = s.executeQuery(sql);
											int rc = 0;
											ArrayList<String> a=new ArrayList<>();
											ArrayList<String> tarihler=new ArrayList<>();
											while (rs.next()) {
												int rkodu = rs.getInt("RandevuKodu");
												String dadi = rs.getString("DoktorAdi");
												String tarih = rs.getString("Tarih");
												a.add(dadi+" "+tarih);	
												tarihler.add(tarih);
												rc++;
											}
											int aa=cboxRSSGuncelleRandevular_1.getSelectedIndex()+1;
											String tarih=tarihler.get(aa);
											txtRsGunTarih.setText(tarih);
											Object s[]=a.toArray();
											cboxRSSGuncelleRandevular_1.setModel(new DefaultComboBoxModel(s));
										} catch (SQLException e2) {
											// TODO Auto-generated catch block
											e2.printStackTrace();
										}	
										try {
											String sql1 = "SELECT \"Ad\" FROM public.\"Doctor\";";
											rs = s.executeQuery(sql1);
											int rc = 0;
											ArrayList<String> ab=new ArrayList<>();
											while (rs.next()) {
												String name = rs.getString("Ad");
												ab.add(name);				
												rc++;
											}
											Object s[]=ab.toArray();
											cboxRSGuncelleDoktorAdi_1.setModel(new DefaultComboBoxModel(s));
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
											}
									}
								});
								btnAra_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnAra_1.setBounds(225, 24, 69, 20);
								panel_5_4_1_1_1.add(btnAra_1);
								
								//Randevu Sil Start
										JButton btnRSSil = new JButton("Randevu Sil");
										btnRSSil.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												String Delrandevu=(String) cboxRSSilRandevular.getSelectedItem();
												if(Delrandevu!=null) {
													int reply = JOptionPane.showConfirmDialog(panel_5_4_1_1_1, ""+Delrandevu+" randevuyu silmek istiyorsunuz Emin misiniz?", "Emin misiniz?", JOptionPane.YES_NO_OPTION);
													if (reply == JOptionPane.YES_OPTION) {
														try {
															String Sql1="DELETE FROM public.\""+Delrandevu+"\" WHERE \"Tc\"= '"+Delrandevu+"';";
															int rs= s.executeUpdate(Sql1);
															if (rs==1) {
																JOptionPane.showMessageDialog(panel_5_4_1_1_1, "Randevu başarılı bir şekilde silindi");
															}
														} catch (Exception e2) {
															// TODO: handle exception
														}
													} 
												}
											}
										});
										btnRSSil.setBounds(112, 314, 123, 27);
										panel_5_4_1_1.add(btnRSSil);
										btnRSSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
								//Randevu Sil End
								
								txtRsAlTarih = new JTextField();
								txtRsAlTarih.setColumns(10);
								txtRsAlTarih.setBounds(112, 176, 179, 20);
								panel_5_4_1.add(txtRsAlTarih);
								
								JButton btnAra = new JButton("Ara");
								btnAra.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String str=txtRsSilTc.getText();
										listCombo(cboxRSSilRandevular,str);
									}
								});
								btnAra.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnAra.setBounds(222, 25, 69, 20);
								panel_5_4_1_1.add(btnAra);
								
								JPanel panel_8_2 = new JPanel();
								panel_8_2.setLayout(null);
								panel_8_2.setBounds(0, 0, 188, 376);
								RandevuPanel.add(panel_8_2);
								
								JButton btnRSAl = new JButton("Randevu Al");
								btnRSAl.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										Appointment ap = new Appointment();
										ap.DoktorAdi=(String)cboxRSALDoktorAdi.getSelectedItem();
										ap.PolId=cboxRSALPolikinlik.getSelectedIndex()+1;
										ap.Tarih=txtRsAlTarih.getText();
										ap.Tc=txtRSALHastaTc.getText();
										try {
											String sql1 = "INSERT INTO public.\"Appointment\"(\"PolId\", \"DoktorAdi\", \"Tc\", \"Tarih\") VALUES (?, ?, ?, ?);";
											PreparedStatement prep =c.prepareStatement(sql1);
											prep.setInt(1,ap.PolId);
											prep.setString(2, ap.DoktorAdi);
											prep.setString(3, ap.Tc);
											prep.setString(4, ap.Tarih);
											int den=prep.executeUpdate();
											if (den==1) {
												JOptionPane.showMessageDialog(HomePanel,"Randevu Başarılı Bir Şekilde Alındı");
											}
										} catch (SQLException e3) {

											e3.printStackTrace();
										}
									}
								});
								btnRSAl.setBounds(112, 314, 123, 27);
								panel_5_4_1.add(btnRSAl);
								btnRSAl.setFont(new Font("Tahoma", Font.PLAIN, 13));
								
								JButton btnRsAlAra = new JButton("Ara");
								btnRsAlAra.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										int ab=cboxRSALPolikinlik.getSelectedIndex()+1;
										listDoktor(cboxRSALDoktorAdi,ab);
									}
								});
								btnRsAlAra.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnRsAlAra.setBounds(236, 23, 69, 20);
								panel_5_4_1.add(btnRsAlAra);
								
								JButton btnRandevuGncelle = new JButton("Randevu Güncelle");
								btnRandevuGncelle.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
//										Appointment ap =new Appointment();
//										ap.Tc=txtRSGunTc.getText();
//										ap.DoktorAdi=(String)cboxRSGuncelleDoktorAdi_1.getSelectedItem();
//										ap.PolId=cboxRSALPolikinlik.getSelectedIndex()+1;
//										ap.Tarih=txtRsGunTarih.getText();
//										try {
//											String SqlGun="UPDATE public.\"Appointment\" SET \"Id\"=?, \"RandevuKodu\"=?, \"PolId\"=?, \"DoktorAdi\"=?, \"Tc\"=?, \"Tarih\"=? WHERE \"Tc\"='';";
//										} catch (Exception e2) {
//											// TODO: handle exception
//										}
									}
								});
								btnRandevuGncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
								btnRandevuGncelle.setBounds(97, 314, 169, 27);
								panel_5_4_1_1_1.add(btnRandevuGncelle);
								
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
				Register reg = new Register();
				reg.setVisible(true);
				txtGirisPassword.setText("");
				txtgirisTc.setText("");
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
