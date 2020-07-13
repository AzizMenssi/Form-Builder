import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Test extends Applet {
	
	public static MaConnexion connexion = new MaConnexion();
	static Interface B;
	public static void main(String[] args) {
		
			try {
	    	
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");    
            
            UIDefaults ui = UIManager.getLookAndFeel().getDefaults();
      
         
            
            /////////////////////////////////////////////////FONTS
           /* Font font = new Font("Segoe UI", Font.PLAIN, 15);
            Font fontSmall = new Font("Segoe UI", Font.PLAIN, 12);
            UIManager.put("Label.font",font);
            UIManager.put("TextField.font",fontSmall);
            UIManager.put("ComboBox.font",fontSmall);
            UIManager.put("TabbedPane.font",fontSmall);
            UIManager.put("Menu.font",fontSmall);
            UIManager.put("MenuItem.font",fontSmall);
            UIManager.put("Button.font",fontSmall);
            UIManager.put("TextArea.font",font);
            UIManager.put("CheckBox.font",fontSmall);
            UIManager.put("RadioButton.font",fontSmall);
            
            
            
    		UIManager.put("TextArea.border", Color.black);
    		UIManager.put("ToolBar.background", Color.white);
    		UIManager.put("TabbedPane.background", Color.white);
    		UIManager.put("ToolBar.border", Color.white);
    		UIManager.put("PopupMenu.background", Color.white);
    		UIManager.put("Panel.background", Color.white);
    		UIManager.put("PopupMenu.border", Color.white);
    		UIManager.put("MenuItem.background", Color.white);
    		UIManager.put("MenuItem.foreground", new Color(58,59,69));
    		UIManager.put("MenuItem.selectionBackground", new Color(250,250,250));
    		UIManager.put("MenuItem.border", Color.white);
    		UIManager.put("Button.background", new Color(78,115,223));
    		UIManager.put("Button.foreground",Color.white);
    		UIManager.put("Button.select", new Color(38,83,212));
    		*/

            } catch (Exception e) {
              System.err.println("Look and feel not set.");
            }

		B =new Interface();
		B.setVisible(true);
		
	

	
	
	}
	
}
