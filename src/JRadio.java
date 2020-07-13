import java.awt.Dimension;

import javax.swing.JRadioButton;

public class JRadio extends JRadioButton {

	String content;
	public JRadio(String content) {
		super(content);
		this.content = content;
		setPreferredSize(new Dimension(500,20));
		setOpaque(false);
		setEnabled(false);
	}
	
	public String toString() {
		return content;
	}
	public void setContent(String c) {
		
		content = c;
		setText(c);
		
	}
	
}
