import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class ModernJTextField extends JTextField implements FocusListener{

	
	int style=0;
	Color focusedBored;
	ModernJTextField(String content){
		
		this();
		setText(content);
		setFont(Constants.TEXTFIELD);

	}
	

	ModernJTextField(){
	
		
		 setUnFocused();
		 setOpaque(false);
		addFocusListener(this);
	}

	ModernJTextField(String content, int style){
		
		this(content);
		this.style = style;
	}

	ModernJTextField(String content,int width ,int style){
		
		super(content,width);
		this.style = style;
		 setUnFocused();
		addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		
		
		if(!isEditable())
			return;
		
		 setFocused();
		 
	}


	@Override
	public void focusLost(FocusEvent arg0) {
		
		if(!isEditable())
			return;
		
		setUnFocused();
	}
	
	void setUnFocused() {
		
		if(style ==0) {
			setOpaque(false);
			setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
			setForeground(Color.lightGray);
		}else {
			setBackground(new Color(40,40,40));
			setForeground(Color.gray);
			focusedBored = Color.gray;
		}
	}
	
	void setFocused() {
		
		if(style ==0) {
			setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
			setForeground(Color.darkGray);
		}else {
			setForeground(Color.darkGray);
			setBackground(Color.white);
			focusedBored = Color.blue;
		}
		
	}
	

   
}
