import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GeneralSettings extends JPanel implements ActionListener{

	ModernJLabel LColor =new ModernJLabel("Couleur des libellés"),tColor =new ModernJLabel("Couleur du titre"),
			bgColor =new ModernJLabel("Couleur du fond"),titleL =new ModernJLabel("Titre du formulaire"),firebaseConfigL =new ModernJLabel("Code firebase");
	
	JTextField titleF= new JTextField(Interface.Form.formName);
	JTextArea firebaseConfig = new JTextArea("const fireconfig{...}");
	JComboBox<String> ComboColor,titleC,bgC;
	
	TitledBorder titleBorder;
	
	static String labelColor = "BLACK",titleColor ="black";

	public GeneralSettings() {

	
		titleBorder=new TitledBorder("Paramètres");
		titleBorder.setTitleColor(Color.gray);
		setBorder(titleBorder);
	
		ComboColor=new JComboBox<String>(Constants.COLORS);
		titleC=new JComboBox<String>(Constants.COLORS);
		bgC=new JComboBox<String>(Constants.BG_COLORS);	
		bgC.setSelectedIndex(2);
		
		LColor.setPreferredSize(Constants.EDITOR_STANDARD);
		ComboColor.setPreferredSize(Constants.EDITOR_STANDARD);	
		titleL.setPreferredSize(Constants.EDITOR_STANDARD);	
		titleF.setPreferredSize(Constants.EDITOR_STANDARD);	
		tColor.setPreferredSize(Constants.EDITOR_STANDARD);	
		titleC.setPreferredSize(Constants.EDITOR_STANDARD);		
		firebaseConfigL.setPreferredSize(Constants.EDITOR_STANDARD);		
		bgC.setPreferredSize(Constants.EDITOR_STANDARD);	
		bgColor.setPreferredSize(Constants.EDITOR_STANDARD);	
		firebaseConfig.setPreferredSize(Constants.EDITOR_STANDARD);	
		firebaseConfig.setLineWrap(true);
		titleF.getDocument().addDocumentListener(new DocumentListener() {
			
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

				 Interface.Form.SetName(titleF.getText());
				 
					if(Interface.instance.addedItemsVector.isEmpty()) return;
					
				 FormElement te =Interface.instance.addedItemsVector.get(0);

					if(te.type=="DESC") {
						//te.colorS = titleColor;
						te.setLabelName(titleF.getText());
					}
			}
			
		});
		
		
		add(titleL);
		add(titleF);
		add(new JSeparation());
		add(tColor);
		add(titleC);
		add(new JSeparation());
		add(bgColor);
		add(bgC);
		add(new JSeparation());
		add(LColor);
		add(ComboColor);
		add(new JSeparation());
		add(firebaseConfigL);
		add(firebaseConfig);
		
		ComboColor.addActionListener(this);
		titleC.addActionListener(this);
		bgC.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == ComboColor) {
			
			labelColor = (String) ComboColor.getSelectedItem();
			for(FormElement fe : Interface.instance.addedItemsVector) {
				if(fe.type=="DESC") continue;
				fe.setLabelName(fe.labelName);
			}
			
		}
		
		if(e.getSource() == titleC) {
			
			titleColor = (String)titleC.getSelectedItem();
			
			if(Interface.instance.addedItemsVector.isEmpty()) return;
			FormElement te =Interface.instance.addedItemsVector.get(0);

			if(te.type=="DESC") {
				//te.colorS = titleColor;
				te.setLabelName(Interface.Form.formName);
			}
			

					
		}
		
		if(e.getSource() == bgC) {
		
		
			Interface.Form.setBackground(Constants.colorFromString((String)bgC.getSelectedItem()));
			Interface.Form.repaint();
					
		}
		
	}
	
}
