import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class ToolTip extends JPopupMenu {


	
	ToolTip(String label){
		
		add(new ModernJLabel(label));
	
	}
	
}
