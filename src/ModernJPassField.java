import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class ModernJPassField extends JPasswordField implements FocusListener{


	ModernJPassField(String content){
		
		this();
		setText(content);
		
	}
	

	ModernJPassField(){
		
		 setOpaque(false);
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
		
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
		setForeground(Color.lightGray);
	}
	
	void setFocused() {
		
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.blue));
		setForeground(Color.black);
	}
	
}
