import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSeparator;

//import com.sun.prism.paint.Color;

public class JSeparation extends JPanel  {

	public JSeparation() {
		
		setPreferredSize(Constants.HORIZONTAL_SEPARAION);
		setOpaque(false);
		
	}
	
	public JSeparation(int direction) {
		
		setPreferredSize(direction ==0 ?Constants.HORIZONTAL_SEPARAION : Constants.VERTICAL_SEPARAION);
		setOpaque(false);
		
	}

	public JSeparation(Dimension d) {
		
		setPreferredSize(d);
		setOpaque(false);
		
	}
}
