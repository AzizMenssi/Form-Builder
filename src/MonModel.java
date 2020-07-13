import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.UpdatableResultSet;


public class MonModel extends AbstractTableModel {
	static ArrayList<Object[]> data;
	ResultSetMetaData rsmd;
	int NbLignes,NbCol;
	Object titre[];
	ResultSet RS;
		public MonModel(ResultSet rs)throws ClassNotFoundException,SQLException {
			RS=rs;
			data=new ArrayList<Object[]>();
			rsmd=rs.getMetaData();
			NbCol=rsmd.getColumnCount();
			while(rs.next()){
				NbLignes++;

			titre=new Object[NbCol];
			for(int i=0;i<NbCol;i++) {
				titre[i]=rs.getObject(i+1);
			}
		
				data.add(titre);
			}
		}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return NbCol;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return NbLignes;
	}

	@Override
	public Object getValueAt(int l, int c) {
		
		//System.out.println("l = "+ l + " c= "+c);
		System.out.println(" data c= "+ data.get(l).length);

		
	
			return data.get(l)[c];
	

	}
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		if(arg1==0)return false;
		else return true;
	}
	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		String t="";
		try {
			t=rsmd.getColumnName(arg0+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		Object[]t=data.get(arg1);
		t[arg2]=arg0;
		data.set(arg1,t);
		
		try {
			while(RS.previous());
			Interface.CON.UpdateCell(RS,arg1,arg2,arg0.toString());
			this.fireTableChanged(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ajouter(Object[] t){

		System.out.println("Contenu: "+Formulaire.finalContenu);
		try {
			Interface.CON.Update(Formulaire.finalContenu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t[0] = data.size()+1;
		data.add(t);
		NbLignes++;
		fireTableChanged(new TableModelEvent(this));
	//	System.out.println("pp");

	}
public void supprimer(int l,int c){
	NbLignes--;
	try {
		Interface.CON.Delete("DELETE FROM Etudiant WHERE "+RS.getMetaData().getColumnName(1)+"='"+data.get(l)[0]+"';");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	data.remove(l);
	fireTableChanged(new TableModelEvent(this));

}
}
