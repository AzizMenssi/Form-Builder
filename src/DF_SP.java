import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class DF_SP extends SettingPanel {

	
	JTextArea elementContent;

	public DF_SP(JPanel parent, FormElement fe) {
		
		super("Description",parent,fe);


		this.setLayout(null);

		//SetElements
		
		LName.setText("Contenu");
		elementContent = new JTextArea(element.DF.getText(),1,18);
		elementContent.setBackground(Color.white);
		elementContent.setBorder(elementName.getBorder());
		elementContent.setLineWrap(true);
		elementContent.setFont(elementName.getFont());
		isRequired.setBackground(Constants.EDITOR_BACKGROUND);
		
		//SetBounds

		isRequired.setPreferredSize(Constants.EDITOR_STANDARD);
		reqL.setPreferredSize(Constants.EDITOR_STANDARD);
	
		//AddTParent

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

				 element.DF.setText(elementContent.getText());
			}
			
		});
		
	    parent.add(LName);
		parent.add(elementContent);
		
	    parent.add(new JSeparation());

	    parent.add(delete);
		parent.revalidate();
		
		parent.remove(reqL);
		parent.remove(isRequired);
			//ActionListener

	}

}
