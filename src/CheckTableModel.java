import java.awt.Dimension;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class CheckTableModel extends DefaultTableModel {

	DefaultListModel<String> data;
	FormElement element;
	
	public CheckTableModel(DefaultListModel<String> d ,FormElement f) {
		data = d;
		element = f;
	}
	
	@Override
	public void setValueAt(Object arg0, int l, int c) {
		
		super.setValueAt(arg0, l, c);
		
		element.checkButtons.get(l).setText((String)arg0);
		
		data.removeElementAt(l);
		data.insertElementAt((String)arg0,l);

		element.choices.removeElementAt(l);
		element.choices.insertElementAt((String)arg0,l);
		 element.revalidate();
		 
	}
	
	
	public void addValue(Object arg0) {
	
		 JCheck r = new JCheck((String)arg0);
		 element.add(new JSeparation(new Dimension(500,20)));
		 element.add(r);
		 element.checkButtons.add(r);
	     data.addElement((String)arg0);
		 addRow(new Object[] {arg0} );
		 element.choices.add((String)arg0);
	
		 element.revalidate();
		 
	}
	
	public void removeElementAt(int l) {
		
		removeRow(l);
		element.remove(element.checkButtons.get(l));
		element.checkButtons.removeElementAt(l);
		 element.revalidate();
		 
	}
	
}
