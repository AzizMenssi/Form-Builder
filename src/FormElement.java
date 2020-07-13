import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;

import XmlUtils.XmlNode;
import XmlUtils.XmlUtils;
import javafx.stage.FileChooser;

public class FormElement extends JPanel implements MouseListener {

	String labelName,elementContent, type;
	
	JLabel label;
	JComponent c;
	Color color;
	ButtonGroup group;
	Vector<JRadio> radioButtons;	Vector<JCheck> checkButtons;
	JComboBox comboBoxs;
	String nom;
	JTextField TF;
	JTextField TF2;
	static JText DF = new JText();	DatePicker DP;
	JTextArea TA;
	JPasswordField PF;
	TimePicker TP;
	JTextField PRGF;
	int minlength=0;
	boolean isRequired;
	ModernJLabel fileName ;

	Vector<String> choices = new Vector<String>();
	
	DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>(choices);
	DefaultListModel<String> rbModel = new DefaultListModel<String>();
	
	
	String imagePath ="Images/NoImage.png";
	static Vector<String> listElements =new Vector<String>();
	public FormElement(String elementType , String name, String content ) {
		

		setBackground(Color.white);
		
		WrapLayout wl = new WrapLayout(FlowLayout.LEADING,10,10);
	
	
		setLayout(wl);
		labelName = name;
		elementContent = content;
		type = elementType;

		if(type!="DESC") {
			
			if(type == "IMG") {
				label = new JLabel();
				label.setIcon(new ImageIcon(imagePath));
			}else {
				label = new JLabel( "<html><FONT SIZE=4 COLOR="+GeneralSettings.labelColor+">"+labelName+"</FONT> <FONT COLOR=RED>"+ (isRequired? "*" : "") +"</FONT></html>");		
				label.setPreferredSize(new Dimension(500,30));
			}
		
		}
		else 
		{	
			label = new JLabel("<html><FONT SIZE=6 COLOR="+GeneralSettings.titleColor+">"+Interface.Form.formName+"</FONT> <FONT COLOR=RED>");	
			label.setPreferredSize(new Dimension(1000,30));			
		}
			add(label);
		
		label.addMouseListener(this);
		switch(elementType) {

		case "DESC": 
			
			JText des = new JText("DESCRIPTION",92);
			setPreferredSize(new Dimension(1030,200));
			des.setEditable(false);
			DF = des;
			DF.addMouseListener(this);
			add(des);
			break;
			
		case "TF": 
			
			ModernJTextField tf = new ModernJTextField("Votre réponse");
			tf.setPreferredSize(new Dimension(500,30));
			tf.setEditable(false);
			TF = tf;
			TF.addMouseListener(this);
			add(TF);
		
			break;
	case "MF": 
			
			ModernJTextField mf = new ModernJTextField("Votre réponse");
			mf.setPreferredSize(new Dimension(500,30));
			mf.setEditable(false);
			TF = mf;
			TF.addMouseListener(this);
			add(TF);
		
			break;
			
		case "FF": 
			 fileName = new ModernJLabel("Fichier");
			JButton ff = new JButton("Parcourir...");
			ff.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JFileChooser fchooser = new JFileChooser();
					int status = fchooser.showOpenDialog(FormElement.this);
					  if (status == JFileChooser.APPROVE_OPTION) {
						  fileName.setText(fchooser.getSelectedFile().getName());
					}
				}
			});
			fileName.setPreferredSize(new Dimension(402,30));
			add(fileName);
			add(ff);
			break;
			
		case "CB": 
			choices.add("Choix");
			JComboBox<String> cb = new JComboBox<String>(cbModel);
			cb.setPreferredSize(new Dimension(500,30));
			comboBoxs = cb;
			cb.setSelectedIndex(0);
			add(comboBoxs);
			break;
			
		case "PSWD": 
			
			minlength = 6;
			ModernJPassField pswdf = new ModernJPassField(content);
			pswdf.setPreferredSize(new Dimension(500,30));
			pswdf.setEditable(false);
			PF = pswdf;
			PF.addMouseListener(this);
			add(PF);
			break;
			
		case "RB": 
			choices.add("Nouvel element");
			radioButtons = new Vector<JRadio>();	
			group = new ButtonGroup();
			JRadio rb = new JRadio("Nouvel element");
			rb.setEnabled(false);
			rb.setBackground(color.white);
			radioButtons.add(rb);
			group.add(rb);

			rb.addMouseListener(this);
			//RB_SP.ComboRB=new JComboBox<String>();
			//RB_SP.ComboRB.setEditable(true);
			//RB_SP.ComboRB.addItem(rb.getText());
			add(rb);

		//	RB_SP.nbRB++;
			break;
			
		case "CHB": 
			choices.add("Nouvel element");
			checkButtons = new Vector<JCheck>();	
			group = new ButtonGroup();
			JCheck chr = new JCheck("new choice");
			chr.setEnabled(false);
			chr.setBackground(color.white);
			checkButtons.add(chr);

			chr.addMouseListener(this);
			add(chr);
			break;
			
		case "DP": 
			
			DatePicker dp = new DatePicker();
			dp.setPreferredSize(new Dimension(500,30));
		
			DP = dp;
			DP.addMouseListener(this);
			add(DP);
		
			break;
			
		case "TP": 
			
			TimePicker tp = new TimePicker();
			tp.setPreferredSize(new Dimension(500,30));
			
			TP = tp;
			TP.addMouseListener(this);
			add(TP);
		
			break;
	
		
		case "NF": 
		
			ModernJTextField nf = new ModernJTextField("Nom");
			ModernJTextField pnf = new ModernJTextField("Pernom");
			nf.setPreferredSize(new Dimension(245,30));
			pnf.setPreferredSize(new Dimension(245,30));
			nf.setEditable(false);	pnf.setEditable(false);
			TF = nf;
			TF2 = pnf;
			TF.addMouseListener(this);
			TF2.addMouseListener(this);
			add(TF);
			add(TF2);
			break;
			
		case "PRGF": 
			
			ModernJTextField prgf = new ModernJTextField("Paragraphe");

			prgf.setPreferredSize(new Dimension(500,30));
			prgf.setEditable(false);
			PRGF = prgf;

			PRGF.addMouseListener(this);

			add(PRGF);

			break;
		}
		
		addMouseListener(this);

	}
	
	public String toString() {
	
		return " "+labelName;
		
	}
	
	public void setLabelName(String c) {
		labelName=c;
		if(type!="DESC")
			label.setText( "<html><FONT SIZE=4 COLOR="+GeneralSettings.labelColor+">"+c+"</FONT> <FONT COLOR=RED>"+ (isRequired? "*" : "") +"</FONT></html>");
		else	
			label.setText( "<html><FONT SIZE=6 COLOR="+GeneralSettings.titleColor+">"+c+"</FONT>");
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	
		if(Interface.selectedElement != this)
		setBackground(new Color(245,245,245));
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

		if(Interface.selectedElement != this)
			setBackground(color.white);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		Interface.instance.rightSide.removeAll();
	
	 	Interface.instance.rightTabs.setSelectedIndex(0);
		  switch(type) {
          
          case "TF": new TF_SP(Interface.instance.rightSide,this);	break;
          case "PSWD": new PF_SP(Interface.instance.rightSide,this);	break;
          case "CB": new CB_SP(Interface.instance.rightSide,this);	break;
          case "DESC": new DF_SP(Interface.instance.rightSide,this);	break;
          case "CHB": new CHB_SP(Interface.instance.rightSide,this);	break;  
          case "RB": new RB_SP(Interface.instance.rightSide,this);	break;   
          case "FF": new F_SP(Interface.instance.rightSide,this);	break;   
          case "DP": new F_SP(Interface.instance.rightSide,this);	break;   
          case "TP": new F_SP(Interface.instance.rightSide,this);	break;   
          case "NF": new F_SP(Interface.instance.rightSide,this);	break;   
          case "PRGF": new F_SP(Interface.instance.rightSide,this);	break;   
          }
		  
		  select();
		  Interface.rightSide.revalidate();
          
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void select() {
		
		  if(Interface.selectedElement != null)
			  Interface.selectedElement.setBackground(color.white);
		  
		  setBackground(new Color(240,240,240));
		  Interface.selectedElement = this;
		
	}
	public String Name(){
		String chaine="";
		switch(type) {
		case "DESC": 
			chaine="'"+DF.getText()+"',";
			break;
			
		case "TF": 
			chaine="'"+TF.getText()+"',";
			break;
			

			
		case "CB": 
			chaine="'"+comboBoxs.getSelectedItem().toString()+"',";

			break;
			
		case "PSWD": 
			chaine="'"+PF.getText()+"',";

			break;
			
		case "RB": 
			chaine="'";
			for(int i=0;i<radioButtons.size();i++){
				if(radioButtons.elementAt(i).isSelected())chaine=chaine+radioButtons.elementAt(i).getText()+"_";

			}
			chaine=chaine+"',";
			break;
			
		case "CHB": 
			chaine="'";
			for(int i=0;i<checkButtons.size();i++){
				if(checkButtons.elementAt(i).isSelected())chaine=chaine+checkButtons.elementAt(i).getText()+"_";

			}
			chaine=chaine+"',";
			break;
			

		case "FF": 
			chaine="'"+fileName.getText()+"',";
			break;
			

		case "NF": 
			chaine="'"+TF.getText() +" " + TF2.getText() +"',";
			break;	
		
		case "PRGF": 
			chaine="'"+TF.getText() +"',";
			break;	
			
		case "DP": 
			chaine="'"+DP.getText() +"',";
			break;	
			
		case "TP": 
			chaine="'"+TP.getText() +"',";
			break;	
							
			
		}
		return chaine;
	}
	public void setEnabled(){
		
		switch(type) {
		case "DESC": 
			DF.setEditable(false);
			break;
			
		case "TF": 
			TF.setEditable(true);
			break;
			
		case "FF": 

			break;
			
		case "CB": 

			break;
			
		case "PSWD": 
			PF.setEditable(true);
			break;
			
		case "RB": 
			for(int i=0;i<radioButtons.size();i++){
				radioButtons.elementAt(i).setEnabled(true);
			}
			break;
			
		case "CHB": 
			for(int i=0;i<checkButtons.size();i++){
				checkButtons.elementAt(i).setEnabled(true);
			}
			break;
		}
	}
	


		public XmlNode getXmlNode(){

			XmlNode node =null;
			switch(type) {
			case "DESC": 
				
				node = XmlUtils.createNode("Header", DF.getText());

				return node;

				
			case "TF": 

			    node = XmlUtils.createNode("TextField", TF.getText());

				node.AddAtribute("name",labelName);
				node.AddAtribute("isRequired", ""+isRequired);

				return node;



				
			case "FF": 

				return null;
				
			case "CB": 

				return null;
				
			case "PSWD": 
				
				 node = XmlUtils.createNode("PasswordField", PF.getText());

				 node.AddAtribute("name", labelName);
				 node.AddAtribute("isRequired", ""+isRequired);
				 node.AddAtribute("minLength", ""+minlength);
				 
				 return node;


				
			case "RB": 
				
				return null;
				
			case "CHB": 
				return null;
				
			default : 		
				return null;
			}
	

		}

		public String getHtmlCode() {
			String val="";
			 switch(type) {
	          
	          case "TF": return "  <div>" + "<label >"+label.getText()+"</label>"
	  				+ "<input type=\"search\" "+( isRequired? "required":"") +" name=\""+label.getText()+"\" class=\"form-control\" style=\"margin-bottom:15px\" placeholder=\""+ TF.getText() +"\">"
					+ " </div>";
	          case "MF": return "  <div>" + "<label >"+label.getText()+"</label>"
		  				+ "<input type=\"email\" "+( isRequired? "required":"") +" name=\""+label.getText()+"\" class=\"form-control\" style=\"margin-bottom:15px\" placeholder=\""+ TF.getText() +"\">"
						+ " </div>";
	          case "PSWD": return  "  <div>" + "<label >" + label.getText() + "</label>"
	  				+ "<input type=\"password\" name=\""+label.getText()+"\" class=\"form-control\" style=\"margin-bottom:15px\">" + " </div>";
	          
	          
		      case "CB":return"";
		    			
	          case "CHB":  val = "  <div>\r\n" + 
		    			"\r\n" + 
		    			"  <label >"+label.getText()+"</label><br>\r\n";

		    			for(JCheck c:checkButtons){

		    				val+= 	"<label > <input type=\"checkbox\" "+( isRequired? "required":"") +" name=\""+label.getText()+Interface.addedItemsVector.indexOf(this)+"\" style=\"margin-right = 10px;\" >"+c.toString()+"</label><br>\r\n";

		    			}

		    			val += "</div>";
		    			return val;
		    			
	          case "RB":   val = " <div>\r\n" + 
		    			"\r\n" + 
		    			"  <label >"+label.getText()+"</label><br>\r\n";

		    			for(JRadio c:radioButtons){

		    				val+= 	"<label > <input type=\"radio\" "+( isRequired? "required":"") +" name=\""+label.getText()+Interface.addedItemsVector.indexOf(this)+"\" style=\"margin-right = 10px;\" >"+c.toString()+"</label><br>\r\n";

		    			}

		    			val += "</div>";
		    			return val;  
		    			
	          case "FF": return "  <div>" + "<label >"+label.getText()+"</label>"
	  				+ "<input type=\"file\" "+( isRequired? "required":"") +" name=\""+label.getText()+"\" class=\"form-control\" style=\"margin-bottom:15px\">"
					+ " </div>";  
	          
	          case "DP":return "  <div>" + "<label >" + label.getText() + "</label>"
	  				+ "<input type=\"date\" "+( isRequired? "required":"") +" name=\""+label.getText()+"\"  class=\"form-control\" style=\"margin-bottom:15px\">" + " </div>"; 
	          
	          case "TP": return "  <div>" + "<label >" + label.getText() + "</label>"
	  				+ "<input type=\"time\" "+( isRequired? "required":"") +" name=\""+label.getText()+"\" class=\"form-control\" style=\"margin-bottom:15px\">" + " </div>";
	         
	          case "NF":return 		"<div class=\"nameDiv\">" + "	<div style=\"width:50%; padding-right :20px\">" + "  <label >Name</label>"
	  				+ " <input   name=\"Nom"+ Interface.addedItemsVector.indexOf(this)+"\" type=\"search\" "+( isRequired? "required":"") +"  class=\"form-control\" style=\"margin-bottom:15px\">" + "</div>"
					+ "	<div style=\"width:50%; \">" + "  <label >Last Name</label>"
					+ " <input   name=\"Prenom"+ Interface.addedItemsVector.indexOf(this)+"\"  type=\"search\"  "+( isRequired? "required":"") +"  class=\"form-control\" style=\"margin-bottom:15px\">" + "</div>" + "	</div>";

	          case "PRGF": return "  <div>" + "<label >"+label.getText()+"</label>"
				+ "<textarea class=\"form-control\" name=\""+label.getText()+"\" style=\"margin-bottom:15px\" placeholder=\""+ PRGF.getText() +"\"></textarea>"
				+ " </div>";
	          }
			  
			return "";
			
		}
	
}
