import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class PF_SP extends SettingPanel {
	
	JTextField elementContent;
	
	ModernJLabel LContent,LLength = new ModernJLabel("Longueur minimale");
	JSpinner passMinLength;

	public PF_SP(JPanel parent, FormElement fe) {
		
		super("Zone mot de passe",parent,fe);
		

		element.minlength =6;
		
		this.setLayout(null);


	
		//SetElements
		LContent=new ModernJLabel("Contenu");
		elementContent = new JTextField(element.elementContent);
		
		passMinLength =  new JSpinner(new SpinnerNumberModel(element.minlength,0, 12,1) );
		
		//SetSize
		LContent.setPreferredSize(Constants.EDITOR_STANDARD);
		elementContent.setPreferredSize(Constants.EDITOR_STANDARD);

		passMinLength.setPreferredSize(Constants.EDITOR_STANDARD);
		LLength.setPreferredSize(Constants.EDITOR_STANDARD);

		
		//AddTParent
		parent.add(LName);
		parent.add(elementName);
	    parent.add(new JSeparation());
	    
	    parent.add(LContent);
		parent.add(elementContent);
		
	    parent.add(new JSeparation());

		parent.add(LLength);
		parent.add(passMinLength);
		
	    parent.add(new JSeparation());
	    parent.add(reqL);
	    parent.add(isRequired);
	    parent.add(new JSeparation(new Dimension(130,20)));
	    
	    parent.add(new JSeparation());
	    
	    parent.add(delete);
		parent.revalidate();
	
		//ActionListener
		
		elementContent.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				UpdateForm();
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				UpdateForm();
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				UpdateForm();
			}
			
			void UpdateForm() {

				 element.PF.setText(elementContent.getText());
			}
			
		});
		elementName.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				UpdateForm();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				UpdateForm();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				UpdateForm();
			}
			
			void UpdateForm() {
				element.setLabelName(elementName.getText());
			}
		});

		
	}
	
	
}
