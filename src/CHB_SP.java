import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



public class CHB_SP extends SettingPanel {
	JTextField elementContent;
	JLabel LContent;
	TitledBorder tTextField;
	JScrollPane scroll;
	JButton BtnAdd =new JButton("+"),BtnEdit =new JButton("Renommer"),BtnRemoveItem = new JButton("-");;


	//Vector<String> checks = new Vector<String>();
	
	JTable table;
	CheckTableModel model;
	
	public CHB_SP(JPanel parent, FormElement fe) {
		
		super("Choix unique",parent,fe);
		
		this.parent = parent;
		
		this.setLayout(null);

		
		/*for(JCheck s : fe.checkButtons) {
			
			checks.add(s.toString());
			
		}*/
		

		model = new CheckTableModel(element.rbModel,element);

		model.addColumn("Choix",element.choices);
		
		table = new JTable(model);
		

		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(150,150));
	
		//SetElements
		LContent=new JLabel("Nom Du RadioButton");
		elementContent = new JTextField(element.elementContent);
		

		table.setBorder(elementContent.getBorder());
		table.setGridColor(new Color(220,220,220));
		table.setSelectionBackground(new Color(245,245,245));
		table.setDefaultRenderer(Object.class, new ProxyCellRenderer(table.getDefaultRenderer(String.class)));
		
		 elementContent.setText("Nouvel element");
		LContent.setPreferredSize(new Dimension(150,20));
		elementContent.setPreferredSize(new Dimension(100,20));
		BtnAdd.setPreferredSize(new Dimension(50,20));	
		BtnEdit.setPreferredSize(new Dimension(110,20));
		BtnRemoveItem.setPreferredSize(new Dimension(40,20));
		//AddTParent
		parent.add(LName); 
		parent.add(elementName);
		
	    parent.add(new JSeparation());
	    
		parent.add(scroll);
		parent.add(LContent);
		parent.add(elementContent);
		parent.add(BtnAdd);

	    parent.add(new JSeparation(Constants.HORIZONTAL_WIDE_SEPARAION));		



	
	    parent.add(new JSeparation());


		parent.add(BtnRemoveItem);
		parent.add(BtnEdit);
		parent.add(new JSeparation());
		
	    parent.add(reqL);
	    parent.add(isRequired);
	    parent.add(new JSeparation(new Dimension(130,20)));
		

	    parent.add(new JSeparation());
	    parent.add(delete);		
	
	

		BtnEdit.addActionListener(this);
		
		BtnAdd.addActionListener(this);
		BtnRemoveItem.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		

		 if(e.getSource()==BtnAdd){
		
			 model.addValue(elementContent.getText());
			 elementContent.setText("Nouvel element");

		 }

		 if(e.getSource()==BtnRemoveItem){
			 
			 if(table.getRowCount()>1 && table.getSelectedRow() >=0) {
				 
				 int i =table.getSelectedRow() ;
				 model.removeElementAt(i);
		

		 }
	
		 super.actionPerformed(e);
	}
}
	
}
