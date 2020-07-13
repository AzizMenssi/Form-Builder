import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

//import javafx.scene.layout.Border;


public class Formulaire extends JPanel implements MouseListener,ActionListener{
	
	static String formName = "New Form";
	JLabel formNameL = new JLabel(formName);
	
	JPanel wrapper = new JPanel();
	JScrollPane scroll ;
	static JButton accept = new JButton("Valider"),reset = new JButton("Réinitialiser");
	static JTable jt;
	static MonModel model;
	static String finalContenu="";
	static Object[]M;
	static DefaultListModel<FormElement> finalElements;

		public Formulaire() {
			
			
	
			setLayout(new BorderLayout());
			wrapper.setLayout(new WrapLayout(1,0,0));
			
		    wrapper.setOpaque(false);
		    wrapper.setBackground(Color.white);
		    
		   // MatteBorder topB = BorderFactory.createMatteBorder(5, 0, 0, 0, Color.blue);

		   // MatteBorder shadow = BorderFactory.createMatteBorder(0, 0, 2, 2, Color.lightGray);
		   // CompoundBorder border = BorderFactory.createCompoundBorder(topB,shadow);
		    
		  //  wrapper.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, Color.lightGray));
	
			scroll = new JScrollPane(wrapper);
			scroll.setPreferredSize(new Dimension(820,800));
			scroll.setHorizontalScrollBar(null);
			scroll.setOpaque(false);
			scroll.getViewport().setOpaque(false);
			scroll.setBorder(BorderFactory.createEmptyBorder());
			setBackground(Color.gray);
			formNameL.setPreferredSize(new Dimension(1920,200));
			
			Font f = new Font(formNameL.getFont().getFontName(),Font.BOLD,40);
			formNameL.setForeground(Color.white);
			formNameL.setFont(f);
			formNameL.setHorizontalAlignment(JLabel.CENTER);
			

			ImageIcon icon = new ImageIcon("C:\\\\Users\\\\eveme\\\\OneDrive\\\\Desktop\\\\Projet\\\\Images\\\\TS.jpg");
			
			formNameL.setIcon(icon);
			
			JPanel separation = new JPanel();
			separation.setPreferredSize(new Dimension(800,60));
			separation.setOpaque(false);
	
			//add(separation);
			
			add(new JSeparation(Constants.HORIZONTAL_WIDE_SEPARAION));
			
			add(scroll);
			
			JPanel marginRight = new JPanel();
			marginRight.setOpaque(false);
			marginRight.setPreferredSize(new Dimension(300,2000));
			
			//add(marginRight,BorderLayout.EAST);
		
			JPanel marginLeft = new JPanel();
			marginLeft.setOpaque(false);
			marginLeft.setPreferredSize(new Dimension(300,2000));
			
			//add(marginLeft,BorderLayout.WEST);
			
		
			accept.setPreferredSize(new Dimension(150,30));
			reset.setPreferredSize(new Dimension(150,30));
			reset.setEnabled(false);
			JPanel south = new JPanel();
			south.setLayout(new WrapLayout());
			south.setOpaque(false);
			south.add(new JSeparation(Constants.HORIZONTAL_WIDE_SEPARAION));
			south.add(accept);
			south.add(reset);

			add(south,BorderLayout.SOUTH);
			
			scroll.addMouseListener(this);
			addMouseListener(this);
			accept.addActionListener(this);
			accept.setEnabled(false);
			
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
	
		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			if(Interface.selectedElement == null)
				return;
			
			System.out.print("entered");Interface.selectedElement.setBackground(Color.white);	
			Interface.selectedElement=null;	
			Interface.rightSide.removeAll();
			Interface.rightSide.revalidate();
			Interface.rightSide.repaint();
			 Interface.rightSide.setBorder(BorderFactory.createEmptyBorder());
			 
			 }

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void SetName(String c) {
			
			formName = c;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==accept){
				JFrame A=new JFrame();
				
			//	System.out.println(Interface.addedItems.getSize());
				
				A.setSize(500,500);
				A.setLayout(new BorderLayout());
				A.setVisible(true);
				
				
					A.add(new JScrollPane(jt),BorderLayout.CENTER);
					JButton btnDeleteDB=new JButton("Supprimer la base de données");
					btnDeleteDB.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								Interface.CON.Delete();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					A.add(btnDeleteDB,BorderLayout.SOUTH);
				//	System.out.println("0");
					finalElements=Interface.addedItems;
					M=new Object[finalElements.size()+1];
					System.out.println("M.length = "+M.length);
					String chaine="";
					finalContenu = "";
					M[0] = "";
					for(int i=1;i<M.length;i++){
						
						chaine=finalElements.elementAt(i-1).Name();
						System.out.println(chaine);
						if(i==M.length-1)chaine=chaine.substring(0,chaine.length()-1);
						System.out.println(chaine);	
						finalContenu=finalContenu+chaine;
						if(i!=M.length-1)chaine=chaine.substring(0,chaine.length()-1);
						M[i]=chaine;
			
				}
					
						System.out.println("finalContenu= "+finalContenu);
						
				//	System.out.println("done");
					model.ajouter(M);
				//	System.out.println("1");
				
			}
		}
	
}
