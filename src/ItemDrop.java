import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

public class ItemDrop extends JPopupMenu {

	DropDownItem text,area,pass,number,date,time,file,url,phone,mail,name;
	JMenuItem topPadding = new JMenuItem("");
	public ItemDrop() {
	
		text= new DropDownItem("Texte");
		area= new DropDownItem("Paragraphe");
		pass= new DropDownItem("Mot de passe");
		mail= new DropDownItem("Mail");
		date= new DropDownItem("date");
		time= new DropDownItem("temps");
		file= new DropDownItem("Fichier");
		

		text.setBorder(BorderFactory.createMatteBorder(0, 15, 0, 0, new Color(0,0,0,0)));
		text.setPreferredSize(new Dimension(150,28));

		
		setOpaque(false);
		setBorder(BorderFactory.createMatteBorder(1,1, 1, 1,new Color(200,200,200)));
		topPadding.setEnabled(false);
		add(topPadding);
		
		add(text);
		add(area);
		add(pass);
		add(mail);
		add(date);
		add(time);
		add(file);
		
	}
	


}

class DropDownItem extends JMenuItem {
	
	public DropDownItem(String text) {

		super(text);

		setBorder(BorderFactory.createMatteBorder(0, 15, 0, 0, new Color(0,0,0,0)));
		setPreferredSize(new Dimension(150,28));
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				setBackground(new Color(78,115,223));
				setForeground(Color.white);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				setBackground(Color.white);
				setForeground(new Color(58,59,69));
				
			}
			
		});
	}


	
}

