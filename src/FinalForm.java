import java.util.Vector;

import javax.swing.JApplet;
import javax.swing.JFrame;


public class FinalForm extends JFrame {
	
		Formulaire finalForm;
		
	public FinalForm() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1080,1080);
		
		finalForm=Test.B.Form;
		add(finalForm);
		Test.B.setVisible(false);
	}
	
	public static void main(String[] args) {
		
		new FinalForm();
		
	}
}