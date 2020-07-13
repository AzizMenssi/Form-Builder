import javax.swing.JPanel;

public class F_SP extends TF_SP {

	public F_SP(JPanel parent, FormElement fe) {
		
		super(parent,fe);

	    parent.remove(LContent);
		parent.remove(elementContent);
		
		}
	
}
