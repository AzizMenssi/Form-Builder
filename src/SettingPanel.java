import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public abstract class SettingPanel extends JPanel implements ActionListener {

	JTextField elementName;
	TitledBorder titleBorder;
	JButton delete = new JButton("Supprimer");
	Formulaire form;
	JPanel parent;
	FormElement element;
	
	ModernJLabel reqL = new ModernJLabel("Obligatoire"),
				 LColor=new ModernJLabel("Couleur"),
				 LName=new ModernJLabel("Titre");
			
	JToggleButton  isRequired = new JToggleButton();

    JComboBox<String> ComboColor;
	
	public SettingPanel(String title , JPanel parent,FormElement element) {
		
		this.element = element;
		this.parent = parent;
		form=Interface.Form;
		parent.setLayout(new WrapLayout());
		
	
		isRequired.setSelected(element.isRequired);
		titleBorder=new TitledBorder(title);
		titleBorder.setTitleColor(Color.gray);
		parent.setBorder(titleBorder);
		

		

		delete.setPreferredSize(Constants.EDITOR_LARGE);
		
		ComboColor=new JComboBox<String>(Constants.COLORS);
	
		elementName = new JTextField(element.labelName);
		
		LName.setPreferredSize(Constants.EDITOR_STANDARD);
		elementName.setPreferredSize(Constants.EDITOR_STANDARD);
		
		LColor.setPreferredSize(Constants.EDITOR_STANDARD);
		ComboColor.setPreferredSize(Constants.EDITOR_STANDARD);	
		isRequired.setPreferredSize(new Dimension(20,20));
		isRequired.setBackground(Constants.EDITOR_BACKGROUND);
		reqL.setPreferredSize(Constants.EDITOR_STANDARD);

		isRequired.setFocusPainted(false);
		
		
		ComboColor.addActionListener(this);
		delete.addActionListener(this);
		isRequired.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==delete){
			 if(element.type =="DESC") {
				 Interface.instance.addedItemsVector.remove(0);
				 ToolBar.description.setEnabled(true);
				 }
			 form.wrapper.remove(element);
			 form.wrapper.repaint();
			 Interface.rightSide.removeAll();
			 Interface.rightSide.revalidate();
			 Interface.rightSide.repaint();
			 Interface.rightSide.setBorder(BorderFactory.createEmptyBorder());
			 Interface.instance.addedItems.removeElement(element);
		 }else
		 if(e.getSource()==ComboColor){
			 
			// element.colorS = ComboColor.getSelectedItem().toString().toUpperCase();
			// element.setLabelName(element.labelName);

		}else
		 if(e.getSource()==isRequired) {

			 element.isRequired = isRequired.isSelected();
			 element.setLabelName(elementName.getText());
			 isRequired.setFocusable(false);
		 }
		 
		 element.revalidate();
		 form.revalidate();
	
	}
	
}
