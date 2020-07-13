import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar implements ActionListener , MouseListener{

	static JToolBarButton description, text, pass, combo , radio , check,image,mail,file,date,time,name,paragraph;
	
	void SetUpButtons() {

		setOrientation(JToolBar.VERTICAL);
		description = new JToolBarButton(new ImageIcon("Images/Icons/Desc.png"),"Description");
		text = new JToolBarButton(new ImageIcon("Images/Icons/Text.png"),"Zone Text");
		pass = new JToolBarButton(new ImageIcon("Images/Icons/pass.png"),"Zone mot de passe");
		combo = new JToolBarButton(new ImageIcon("Images/Icons/combo.png"),"Choix multiple");
		radio= new JToolBarButton(new ImageIcon("Images/Icons/radio.png"),"Choix unique");
		check= new JToolBarButton(new ImageIcon("Images/Icons/check.png"),"Choix multiple");
		mail= new JToolBarButton(new ImageIcon("Images/Icons/mail.png"),"Zone mail");
		image= new JToolBarButton(new ImageIcon("Images/Icons/img.png"),"Image");
		file= new JToolBarButton(new ImageIcon("Images/Icons/file.png"),"Fichier");
		date= new JToolBarButton(new ImageIcon("Images/Icons/date.png"),"Date");
		time= new JToolBarButton(new ImageIcon("Images/Icons/time.png"),"Temps");
		name= new JToolBarButton(new ImageIcon("Images/Icons/name.png"),"Nom");
		paragraph= new JToolBarButton(new ImageIcon("Images/Icons/paragraph.png"),"Paragraphe");
				
		
		description.setPreferredSize(new Dimension(40,40));

		
		description.addActionListener(this);
		text.addActionListener(this);
		pass.addActionListener(this);
		combo.addActionListener(this);
		radio.addActionListener(this);
		check.addActionListener(this);
		mail.addActionListener(this);
		file.addActionListener(this);
		date.addActionListener(this);		
		time.addActionListener(this);	
		name.addActionListener(this);	
		paragraph.addActionListener(this);	
	
		paragraph.addMouseListener(this);
		name.addMouseListener(this);
		description.addMouseListener(this);
		text.addMouseListener(this);
		pass.addMouseListener(this);
		combo.addMouseListener(this);
		radio.addMouseListener(this);
		check.addMouseListener(this);
		mail.addMouseListener(this);
		file.addMouseListener(this);		
		date.addMouseListener(this);		
		time.addMouseListener(this);		
	}
	
	public ToolBar() {
		
		setPreferredSize(new Dimension(50,1080));
		//setBackground(Constants.EDITOR_BACKGROUND);
		SetUpButtons();
		add(description);
		add(text);
		add(paragraph);
		add(pass);
		add(name);
		add(mail);
		add(combo);
		add(radio);
		add(check);
	//	add(image);
		add(file);
		add(date);
		add(time);

	}

	@Override
	public void actionPerformed(ActionEvent e) {



	 	Interface.instance.rightTabs.setSelectedIndex(0);
	 	
          if(e.getSource() == description ) {
          	
          	FormElement fe = new FormElement("DESC", "TITRE", "");
      
          	Interface.instance.addedDescription=true;
          	
          	if(Interface.instance.addedItemsVector.size() > 0)
          		Interface.instance.Form.wrapper.removeAll();
          	
          	Interface.instance.Form.wrapper.add(fe);
          	

          	if(Interface.instance.addedItemsVector.size() > 0)
	            	for(FormElement el : Interface.instance.addedItemsVector) {
	            		
	            		Interface.instance.Form.wrapper.add(el);				
	            	}
          	
	         description.setEnabled(false);   	
          	Interface.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.rightSide.removeAll(); 
          	DF_SP T =new DF_SP(Interface.instance.rightSide,fe);	
          	Interface.rightSide.revalidate(); // to update the setting panel
          	fe.select();

          }	
          

          
          if(e.getSource() == text ) {
          	
          	FormElement fe = new FormElement("TF", "Zone de texte", "");
          	Interface.instance.Form.wrapper.add(fe);
          	Interface.instance.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.rightSide.removeAll(); 
          	TF_SP T =new TF_SP(Interface.instance.rightSide,fe);	
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.instance.rightSide.revalidate(); // to update the setting panel
         	fe.select();
          }	
          

          if(e.getSource() == pass) {
          	
          	FormElement fe = new FormElement("PSWD", "Mot de passe", "000000");
          	Interface.instance.Form.wrapper.add(fe);
          	Interface.instance.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.instance.rightSide.removeAll(); 
          	PF_SP T =new PF_SP(Interface.instance.rightSide,fe);	
          	Interface.instance.rightSide.revalidate(); // to update the setting panel
         	fe.select();
          }	
          
          if(e.getSource() == combo) {
          	
          	FormElement fe = new FormElement("CB", "Combo box", "");
          	Interface.instance.Form.wrapper.add(fe);
          	Interface.instance.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.instance.rightSide.removeAll(); 
          	CB_SP T =new CB_SP(Interface.instance.rightSide,fe);	
          	Interface.instance.rightSide.revalidate(); // to update the setting panel
         	fe.select();
          }
          if(e.getSource() == radio) {
          	
          	FormElement fe = new FormElement("RB", "Choix unique", "");
          	Interface.instance.Form.wrapper.add(fe);
          	Interface.instance.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.instance.rightSide.removeAll(); 
          	RB_SP T =new RB_SP(Interface.instance.rightSide,fe);	
          	Interface.instance.rightSide.revalidate(); // to update the setting panel
         	fe.select();
          }
          if(e.getSource() == check) {
            	
            	FormElement fe = new FormElement("CHB", "Choix multiple", "");
            	Interface.instance.Form.wrapper.add(fe);
            	Interface.instance.Form.revalidate(); // to update the form
            	Interface.instance.addedItems.addElement(fe);
            	Interface.instance.addedItemsVector.add(fe);
            	Interface.instance.rightSide.removeAll(); 
            	CHB_SP  T =new CHB_SP(Interface.instance.rightSide,fe);	
            	Interface.instance.rightSide.revalidate(); // to update the setting panel
             	fe.select();
            	
            }
          
          if(e.getSource() == image) {
          	
          	FormElement fe = new FormElement("IMG", "Image", "");
          	Interface.instance.Form.wrapper.add(fe);
          	Interface.instance.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.instance.rightSide.removeAll(); 
          	CHB_SP  T =new CHB_SP(Interface.instance.rightSide,fe);	
          	Interface.instance.rightSide.revalidate(); // to update the setting panel
           	fe.select();
          	
          }
          
          
          if(e.getSource() == mail ) {
          	
          	FormElement fe = new FormElement("MF", "Adresse mail", "");
          	Interface.instance.Form.wrapper.add(fe);
          	Interface.instance.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.rightSide.removeAll(); 
          	TF_SP T =new TF_SP(Interface.instance.rightSide,fe);	
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.instance.rightSide.revalidate(); // to update the setting panel
         	fe.select();
         	
          }	
          
          
          if(e.getSource() == file ) {
          	
          	FormElement fe = new FormElement("FF", "Fichier", "");
          	Interface.instance.Form.wrapper.add(fe);
          	Interface.instance.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.rightSide.removeAll(); 
          	F_SP T =new F_SP(Interface.instance.rightSide,fe);	
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.instance.rightSide.revalidate(); // to update the setting panel
         	fe.select();
         	
          }	
          
          if(e.getSource() == date ) {
            	
            	FormElement fe = new FormElement("DP", "Date", "");
            	Interface.instance.Form.wrapper.add(fe);
            	Interface.instance.Form.revalidate(); // to update the form
            	Interface.instance.addedItems.addElement(fe);
            	Interface.instance.rightSide.removeAll(); 
            	F_SP T =new F_SP(Interface.instance.rightSide,fe);	
            	Interface.instance.addedItemsVector.add(fe);
            	Interface.instance.rightSide.revalidate(); // to update the setting panel
           	fe.select();
           	
            }	
          
          if(e.getSource() == time ) {
          	
          	FormElement fe = new FormElement("TP", "Temps", "");
          	Interface.instance.Form.wrapper.add(fe);
          	Interface.instance.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.rightSide.removeAll(); 
          	F_SP T =new F_SP(Interface.instance.rightSide,fe);	
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.instance.rightSide.revalidate(); // to update the setting panel
         	fe.select();
         	
          }	
          

          if(e.getSource() == name ) {
            	
            	FormElement fe = new FormElement("NF", "Nom et Prenom", "");
            	Interface.instance.Form.wrapper.add(fe);
            	Interface.instance.Form.revalidate(); // to update the form
            	Interface.instance.addedItems.addElement(fe);
            	Interface.instance.rightSide.removeAll(); 
            	F_SP T =new F_SP(Interface.instance.rightSide,fe);	
            	Interface.instance.addedItemsVector.add(fe);
            	Interface.instance.rightSide.revalidate(); // to update the setting panel
           	fe.select();
           	
            }	
          
          
          if(e.getSource() == paragraph ) {
          	
          	FormElement fe = new FormElement("PRGF", "Paragraphe", "");
          	Interface.instance.Form.wrapper.add(fe);
          	Interface.instance.Form.revalidate(); // to update the form
          	Interface.instance.addedItems.addElement(fe);
          	Interface.instance.rightSide.removeAll(); 
          	F_SP T =new F_SP(Interface.instance.rightSide,fe);	
          	Interface.instance.addedItemsVector.add(fe);
          	Interface.instance.rightSide.revalidate(); // to update the setting panel
         	fe.select();
         	
          }	
        
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		JButton b = ((JButton) e.getSource());
		
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
	
}
