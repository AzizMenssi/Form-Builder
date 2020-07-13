import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

//import javafx.scene.control.Tooltip;

public class JToolBarButton extends JButton  {


	JToolBarButton(ImageIcon icon, String tip){

		setBackground(Color.white);
		setFocusPainted(false);
		setIcon(icon);
		setFocusable(false);
		setBorder(new EmptyBorder(new Insets(10,10,10,10)));
		
		setToolTipText(tip);
	}
}