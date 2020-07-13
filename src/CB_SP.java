import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import javax.swing.table.TableCellRenderer;


public class CB_SP extends SettingPanel {
	
		JButton BtnAdd =new JButton("Ajouter"),BtnEdit =new JButton("Modifier"),BtnRemoveItem = new JButton("Supprimer l'element");
		JLabel LContent,LSelect;
		JScrollPane scroll;
		JTable table;
		JTextField elementContent;
		TableModel model;
		static JComboBox<String> ComboCB;

	public CB_SP(JPanel parent, FormElement fe) {
		super("Liste déroulante",parent,fe);
		this.setLayout(null);
		//SetElements
		LContent=new JLabel("Element Du ComboBox");
		elementContent = new JTextField(element.elementContent);
		LSelect=new JLabel("Elements");
		LSelect.setPreferredSize(new Dimension(150,150));
		LSelect.setVerticalAlignment(JLabel.TOP);
		//AddTParent
		parent.add(LName);
		parent.add(elementName);
		parent.add(new JSeparation());
		parent.add(LSelect);
		model = new TableModel(element.cbModel);
		model.addColumn("Choix",element.choices);
		table = new JTable(model);
		table.setBorder(elementContent.getBorder());
		table.setGridColor(new Color(220,220,220));
		table.setSelectionBackground(new Color(245,245,245));
		table.setDefaultRenderer(Object.class, new ProxyCellRenderer(table.getDefaultRenderer(String.class)));
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(150,150));
		parent.add(scroll);
		parent.add(BtnAdd);
		parent.add(BtnRemoveItem);
		parent.add(new JSeparation());
		parent.add(delete);
		parent.revalidate();
		BtnEdit.addActionListener(this);
		BtnAdd.addActionListener(this);
		BtnRemoveItem.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==BtnAdd){
			 model.addValue("Nouvel Element");
			 element.comboBoxs.revalidate();
		 }
		 if(e.getSource()==BtnRemoveItem){
			 if(table.getSelectedRow()>=0)
			 model.removeElementAt(table.getSelectedRow());
		 }
		 if(e.getSource()==BtnEdit){
			 element.comboBoxs.addItem(elementContent.getText());	
			 element.comboBoxs.removeItem(element.comboBoxs.getSelectedItem());	
		 }
		super.actionPerformed(e);
		 element.revalidate();
		// element.repaint();
		 form.revalidate();
		// form.repaint();
		 parent.revalidate();
		// parent.repaint();
	}
}
 class ProxyCellRenderer implements TableCellRenderer {

    protected static final Border DEFAULT_BORDER = new EmptyBorder(1, 1, 1, 1);
    private TableCellRenderer renderer;
    public ProxyCellRenderer(TableCellRenderer renderer) {
        this.renderer = renderer;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (comp instanceof JComponent) {
            ((JComponent)comp).setBorder(DEFAULT_BORDER);
        }
        return comp;
    }        
}