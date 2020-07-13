import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class TF_SP extends SettingPanel  {
	
	JTextField elementContent;
	ModernJLabel LContent;


	public TF_SP(JPanel parent, FormElement fe) {
		
		super("Zone de text" , parent,fe);

		
		setPreferredSize(new Dimension(1000,1000));
		setLayout(null);

		//SetElements
		LContent=new ModernJLabel("Contenu");
		elementContent = new JTextField(element.elementContent);
		


		LContent.setPreferredSize(Constants.EDITOR_STANDARD);
		elementContent.setPreferredSize(Constants.EDITOR_STANDARD);

		//AddTParent
		parent.add(LName);
		parent.add(elementName);
	    parent.add(new JSeparation());
	    
	    parent.add(LContent);
		parent.add(elementContent);
		
	    parent.add(new JSeparation());
	    
	    parent.add(reqL);
	    parent.add(isRequired);
	    parent.add(new JSeparation(new Dimension(130,20)));
	    parent.add(new JSeparation());
	    
	    parent.add(delete);
		parent.revalidate();

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
				
				 element.TF.setText(elementContent.getText());
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
