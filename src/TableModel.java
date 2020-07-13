import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	DefaultComboBoxModel<String> data;
	
	public TableModel(DefaultComboBoxModel<String> d) {
		data = d;
	}
	
	@Override
	public void setValueAt(Object arg0, int l, int c) {
		
		super.setValueAt(arg0, l, c);
		
		data.removeElementAt(l);
		data.insertElementAt((String)arg0,l);
		data.setSelectedItem(arg0);
		
	}
	
	
	public void addValue(Object arg0) {
	
	     data.addElement((String)arg0);
		 addRow(new Object[] {arg0} );
		 
	}
	
	public void removeElementAt(int l) {
		
		removeRow(l);
		data.removeElementAt(l);
		
	}
	
}
