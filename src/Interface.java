import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.ItemSelectable;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;




public class Interface extends JFrame implements ActionListener/*,MouseListener*/ {


	static Interface instance;
	
	JButton btnFinalForm,btnValid =new JButton("GENERER HTML");
	JLabel LTextField=new JLabel("Text Field");
	
	JPanel dataBasePanel;
	JTabbedPane rightTabs,addedItemsTab,itemsTab;
	static Formulaire Form=new Formulaire();
	int X=0,Y=0;
	JToolBar tbTop = new JToolBar();
//	MyModel model = new MyModel(Test.connexion.rs);
	
//	JTable jt = new JTable(model);
	
	static MaConnexion CON;
	
	JPopupMenu popMenu=new JPopupMenu();
	JSplitPane rightSP, centerSP;
	JMenuItem del=new JMenuItem("Supprimer");

	static Object[]t;
	static int nbObject=0;
	
	static JPanel leftSide = new JPanel();
	static JPanel rightSide = new JPanel();
	static GeneralSettings generalSettings = new GeneralSettings();
	static JPanel helpPanel = new JPanel();
	JPanel formPanel;

	String[] itemNames = {" Description"," TextField"," Password"," ComboBox"," RadioButton"," Checkbox"," Image"," List"," E-mail"," File"};
	//JList<ItemEntry> itemList;
	
	JMenuBar  menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem newFile = new JMenuItem("Nouveau fichier");
	JMenuItem saveFile = new JMenuItem("Enregistrer");
	JMenuItem saveFileAs = new JMenuItem("Enregistrer sous");
	JMenuItem exit = new JMenuItem("Quitter");
	JMenuItem html = new JMenuItem("Generer fichier HTML");
	
	JMenu viewMenu = new JMenu("Affichage");
	JMenuItem settings = new JMenuItem("Propritétés");
	JMenuItem elts = new JMenuItem("Barre d'outils");
	JMenuItem frm = new JMenuItem("Formulaire");
	
	static boolean addedDescription;
	public static DefaultListModel<FormElement> addedItems = new DefaultListModel<FormElement>(); 
//	DefaultListModel<ItemEntry> itemModel = new DefaultListModel<ItemEntry>();
	JList<FormElement> addedItemsList = new JList(addedItems);
	
	static Vector<FormElement> addedItemsVector = new Vector<FormElement>();
	
	
	static FormElement selectedElement;
	
		public Interface() {
			
		
		//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
			instance = this;

		/*	SetupItemList();
			 itemList = new JList<ItemEntry>(itemModel);*/
	
			this.setLayout(new BorderLayout());
			this.setSize(1920,1080);

			
			popMenu.add(del);
			del.addActionListener(this);

			fileMenu.add(newFile);
			fileMenu.add(saveFile);
			fileMenu.add(saveFileAs);
			fileMenu.add(html);
			fileMenu.add(new JSeparation());
			fileMenu.add(exit);

			viewMenu.add(settings);
			viewMenu.add(frm);
			viewMenu.add(elts);
			
			menuBar.add(fileMenu);
			menuBar.add(viewMenu);	
			
			setJMenuBar(menuBar);
			
			LTextField.setBounds(30,30,100,50);
			
			
			leftSide.setPreferredSize(new Dimension(60,1080));
			leftSide.setBackground(Constants.EDITOR_BACKGROUND);
	/*		itemList.setPreferredSize(new Dimension(50,1080));
			itemList.setFixedCellHeight(50);
			itemList.setSelectionBackground(Constants.EDITOR_SELECTION_BACKGROUND);
			*/
			addedItemsList.setPreferredSize(new Dimension(200,1080*3/4 + 100));
			
			
			addedItemsList.setBackground(Constants.EDITOR_BACKGROUND);
			
			addedItemsList.setSelectionBackground(Constants.EDITOR_SELECTION_BACKGROUND);
			
		/*	itemList.setBackground(Constants.EDITOR_BACKGROUND);
			itemList.setCellRenderer(new ItemListRenderer());
			itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			itemList.addMouseListener(this);
			addedItemsList.addMouseListener(this);
			addedItemsList.setFocusable(false);*/
			rightSide.setPreferredSize(new Dimension(200,1080));
			rightSide.setLayout(null);
			rightSide.setBackground(Constants.EDITOR_BACKGROUND);
			
			itemsTab = new JTabbedPane();	
	
		//	itemsTab.add(itemList,"Elements");
			
			leftSide.add(new ToolBar());
		
			addedItemsTab = new JTabbedPane();	
			addedItemsTab.add(addedItemsList,"Elements ajoutés");

			
			btnValid.addActionListener(this);	
			
			this.add(leftSide,BorderLayout.WEST);

		    generalSettings.setBackground(Constants.EDITOR_BACKGROUND);
			
		    
		    rightTabs = new JTabbedPane();
		    
		    rightTabs.add(rightSide,"Propritétés");
		    rightTabs.add(generalSettings,"Parametres generaux");
		    rightTabs.setSelectedIndex(1);
		    
			rightSP =  new JSplitPane(JSplitPane.VERTICAL_SPLIT,
					rightTabs, addedItemsTab); // na77it el table bch ma n7elech el easyphp every time

			rightSP.setMinimumSize(new Dimension(400,1080));
			centerSP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
					Form,rightSP);
			

			centerSP.setOneTouchExpandable(true);
			centerSP.setDividerLocation(1470);
			rightSP.setOneTouchExpandable(true);
			rightSP.setDividerLocation(800);
			add(centerSP);
			//NEW STUFF
			btnFinalForm=new JButton("Generer le formulaire");
			btnFinalForm.addActionListener(this);
			helpPanel.setPreferredSize(new Dimension(1920,20));
			helpPanel.setBackground(Constants.EDITOR_BACKGROUND);
			add(btnFinalForm,BorderLayout.SOUTH);
			add(tbTop,BorderLayout.NORTH);
		
			saveFile.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==del){
				int H=Integer.parseInt(JOptionPane.showInputDialog("Height"));
				int W=Integer.parseInt(JOptionPane.showInputDialog("Width"));
				
				JTextField A=new JTextField("kkkkk");
				A.setBounds(X,Y,H,W);
				
				this.add(A);
			}
			
			if(e.getSource()==btnValid){
				GenerateHTML();
			}
			if(e.getSource()==btnFinalForm){
				
				new ExportWindow();
					
				}
				
			}
				/*try{
		
					CON=new MaConnexion();
					CON.Driver();
					CON.Connect();
					CON.CreateDataBase();
					CON.ConnectDataBase();
					CON.CreateTable();
					String req="Select * From formulaire";
				
					ResultSet rs=CON.Select(req);
					Formulaire.model=new MonModel(rs);
					Formulaire.jt=new JTable();
					Formulaire.jt.setModel(Formulaire.model);
				}catch(ClassNotFoundException a){
					System.out.println("ERR DRIVER"+a.getMessage());
				}
			catch(SQLException a){
					System.out.println("ERR Connection"+a.getMessage());
				}	
				FinalForm F=new FinalForm();
				F.setVisible(true);
				for(int i=0;i<addedItems.size();i++)addedItems.elementAt(i).setEnabled();
				Formulaire.accept.setEnabled(true);
				

			}
			
			
			if(e.getSource() == saveFile) {
				
				for(int i = 0 ; i<addedItems.size();i++) {
					
					System.out.println(addedItems.getElementAt(i).getXmlNode().getCode());
					
				}
				
			}}	*/
		
	
		/*
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			if(e.getSource() == itemList) {
			  JList list = (JList)e.getSource();

		        if (e.getClickCount() == 2) {

		      
		            int index = list.locationToIndex(e.getPoint());
		        	itemList.clearSelection();  
		            if(index == 0 && !addedDescription) {
		            	
		            	FormElement fe = new FormElement("DESC", "DESCRIPTION", "");
		        
		            	addedDescription=true;
		            	
		            	if(addedItemsVector.size() > 0)
		            	Form.wrapper.removeAll();
		            	
		            	Form.wrapper.add(fe);
		            	

		            	if(addedItemsVector.size() > 0)
			            	for(FormElement el : addedItemsVector) {
			            		
			            		Form.wrapper.add(el);			
			            		
			            	}
			            	
		            	Form.revalidate(); // to update the form
		            	addedItems.addElement(fe);
		             	addedItemsVector.add(fe);
			    		rightSide.removeAll(); 
		            	DF_SP T =new DF_SP(rightSide,fe);	
		    			rightSide.revalidate(); // to update the setting panel
		    		//	repaint(); // to update the interface
		            }	
		            

		            
		            if(index == 1) {
		            	
		            	FormElement fe = new FormElement("TF", "NEW TEXT FIELD", "");
		            	Form.wrapper.add(fe);
		            	Form.revalidate(); // to update the form
		            	addedItems.addElement(fe);
		            	rightSide.removeAll(); 
		            	TF_SP T =new TF_SP(rightSide,fe);	
		            	addedItemsVector.add(fe);
		    			rightSide.revalidate(); // to update the setting panel
		    		//	repaint(); // to update the interface
		            }	
		            

		            if(index == 2) {
		            	
		            	FormElement fe = new FormElement("PSWD", "NEW PASSWORD FIELD", "000000");
		            	Form.wrapper.add(fe);
		            	Form.revalidate(); // to update the form
		            	addedItems.addElement(fe);
		             	addedItemsVector.add(fe);
			    		rightSide.removeAll(); 
		            	PF_SP T =new PF_SP(rightSide,fe);	
		    			rightSide.revalidate(); // to update the setting panel
		    		//	repaint(); // to update the interface			
		            }	
		            
		            if(index == 3) {
		            	
		            	FormElement fe = new FormElement("CB", "NEW COMBO BOX", "");
		            	Form.wrapper.add(fe);
		            	Form.revalidate(); // to update the form
		            	addedItems.addElement(fe);
		             	addedItemsVector.add(fe);
			    		rightSide.removeAll(); 
		            	CB_SP T =new CB_SP(rightSide,fe);	
		    			rightSide.revalidate(); // to update the setting panel
		    			//repaint(); // to update the interface			
		            }
		            if(index == 4) {
		            	
		            	FormElement fe = new FormElement("RB", "NEW RADIO GROUP", "");
		            	Form.wrapper.add(fe);
		            	Form.revalidate(); // to update the form
		            	addedItems.addElement(fe);
		             	addedItemsVector.add(fe);
			    		rightSide.removeAll(); 
		            	RB_SP T =new RB_SP(rightSide,fe);	
		    			rightSide.revalidate(); // to update the setting panel
		    		//	repaint(); // to update the interface			
		            }


		        }
		      }else if(e.getSource() == addedItemsList) {
		    	  
				  JList list = (JList)e.getSource();

			        if (e.getClickCount() == 1) {

			            // Double-click detected
			            int index = list.locationToIndex(e.getPoint());
			            
			        	rightSide.removeAll();
			        	
			            switch(addedItems.getElementAt(index).type) {
			            
			            case "TF": new TF_SP(rightSide,addedItems.getElementAt(index));	break;
			            case "PSWD": new PF_SP(rightSide,addedItems.getElementAt(index));	break;
			            case "CB": new CB_SP(rightSide,addedItems.getElementAt(index));	break;
			            case "DESC": new DF_SP(rightSide,addedItems.getElementAt(index));	break;
			            case "CHB": new CHB_SP(rightSide,addedItems.getElementAt(index));	break;   
			            }
			            
			            	//T =new SettingsPanel(rightSide,addedItems.getElementAt(index));	
			            	
							//rightSide.add(T);
							rightSide.revalidate();
						//	repaint();
				
			         

			        }
			        

			        
			      }
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		*/
		void GenerateHTML() {
			
			String divs = new String();
			
			for(int i =0 ;i < addedItems.size();i++) {
				
				FormElement fe = addedItems.getElementAt(i);
				
				divs += "\r\n" + 
						"<div class=\"element\">\r\n" + 
						"  <div class=\"content\">\r\n" + 
						"      <h3> "+ fe.labelName +" </h3>  <br/>"  ;
				
			
				
				switch(fe.type) {
				
				case "TF":
					
					divs+="  <input type=\"text\">";
					
					break;
				
				
				
				
				
				case "PSWD":
				
				divs+="  <input type=\"password\">";
				
				break;
				
			
			}
			
				divs += "  </div>\r\n" + 
						"</div>\r\n" + 
						"\r\n" + 
						"</br>\r\n" + 
						"" 	 ;
			}
			
			System.out.println(divs);
		/*	
			String data = new String("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<title>"+user.pseudo+"</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<div>\r\n" + 
					"   <fieldset>\r\n" + 
					"      <legend>Informations personnelles</legend>\r\n" + 
					"      Nom:	\r\n" + user.nom +
					"      </br>Prenom:	\r\n" +  user.prenom +
					"      </br>Pseudo:	\r\n" +  user.pseudo +
					"   </fieldset>\r\n" + 
					"   <fieldset>\r\n" + 
					"      <legend>Configuration</legend>\r\n" + 
					"	   <fieldset>\r\n" + 
					"    		  <legend>Difficulté : "+ difficulte +"</legend>\r\n" + 
					"	          	\r\n" + cats +
					"   	   </fieldset>\r\n" + 
					"\r\n" + 
					"	   <fieldset>\r\n" + 
					"    		  <legend>Options</legend>\r\n" + 
					"     		  Son:\r\n" +  user.config[0] +
					"     		  </br>Affichage score:\r\n" + user.config[1] +
					"    		  </br>Plein ecran:\r\n" +  user.config[2] +
					"		  </br>Ombre:	\r\n" +  user.config[3] +
					"   	   </fieldset>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"   </fieldset>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</div>\r\n" + 
					"</body>\r\n" + 
					"</html>");*/
			
		}
		
		
		void NewFile() {
			
			addedItems.removeAllElements();
			

		}
		
		void generateHtml() {
			
		}
		
		/*
		void SetupItemList() {
			
			itemModel.addElement(new ItemEntry("Description", new ImageIcon(("Images/Desc.png"))));
			itemModel.addElement(new ItemEntry("TextField", new ImageIcon("Images/TF.png")));
			itemModel.addElement(new ItemEntry("Password", new ImageIcon("Images/pass.png")));
			itemModel.addElement(new ItemEntry("ComboBox", new ImageIcon("Images/Combo.png")));
			itemModel.addElement(new ItemEntry("RadioButton", new ImageIcon("Images/RAD.png")));
			itemModel.addElement(new ItemEntry("Checkbox", new ImageIcon("Images/CHECK.png")));
			itemModel.addElement(new ItemEntry("Image", new ImageIcon("Images/dot.png")));
			itemModel.addElement(new ItemEntry("List", new ImageIcon("Images/dot.png")));
			itemModel.addElement(new ItemEntry("mail", new ImageIcon("Images/dot.png")));
			itemModel.addElement(new ItemEntry("File", new ImageIcon("Images/dot.png")));

			
			
		}//{" Description"," TextField"," Password"," ComboBox"," RadioButton"," Checkbox"," Image"," List"," E-mail"," File"};
		*/
		
}

