import java.awt.Dimension;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class RadioTableModel extends DefaultTableModel {

	DefaultListModel<String> data;
	FormElement element;
	
	public RadioTableModel(DefaultListModel<String> d ,FormElement f) {
		data = d;
		element = f;
	}
	
	@Override
	public void setValueAt(Object arg0, int l, int c) {
		
		super.setValueAt(arg0, l, c);
		
		element.radioButtons.get(l).setText((String)arg0);
		
		data.removeElementAt(l);
		data.insertElementAt((String)arg0,l);

		element.choices.removeElementAt(l);
		element.choices.insertElementAt((String)arg0,l);
		 element.revalidate();
		 
	}
	
	
	public void addValue(Object arg0) {
	
		 JRadio r = new JRadio((String)arg0);
		 element.add(new JSeparation(new Dimension(500,20)));
		 element.add(r);
		 element.radioButtons.add(r);
	     data.addElement((String)arg0);
		 addRow(new Object[] {arg0} );
		 element.choices.add((String)arg0);
		
		 element.revalidate();
		  
		 
	}
	
	public void removeElementAt(int l) {
		
		removeRow(l);
		element.remove(element.radioButtons.get(l));
		element.radioButtons.removeElementAt(l);
		 element.revalidate();
		 
	}
	
}
