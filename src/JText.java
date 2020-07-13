import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class JText extends JTextArea {

	
	JText(String content){
		
		this();
		setText(content);
		setFont(Constants.TEXTFIELD);

	}
	

	JText(){
	
		 setUnFocused();

	}


	JText(String content,int width){
		
		super(content,1,width);

		 setUnFocused();

	}

	
	
	void setUnFocused() {
		
			setFont(Constants.DESCRIPTIONFIELD);
			setLineWrap(true);
			setOpaque(false);

			setForeground(Color.darkGray);
	
		
	}
	
	

   
}
