import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;


public class MaConnexion {
	static Connection com;
	static Connection comA;

	Statement st,stA;
	String[] titre;
	//Object[][] data;
	public void Driver()throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void Connect() throws SQLException{
		try {
			com = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYSQL","root","");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void Delete() throws SQLException{
		int b=0;
		try {
			String dataBaseName="PROJECT";
			String sql="DROP DATABASE "+dataBaseName;
			st = comA.createStatement();
			b=st.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void ConnectDataBase() throws SQLException{
		try {
			comA = DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJECT","root","");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void CreateDataBase() throws SQLException{
		int b=0;
		try {
			String dataBaseName="PROJECT";
			String sql="CREATE DATABASE IF NOT EXISTS "+dataBaseName;
			st = com.createStatement();
			b=st.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void CreateTable() throws SQLException{
		int b=0;
		try {
			String sql = "CREATE TABLE IF NOT EXISTS formulaire "
						+ "(id integer NOT NULL AUTO_INCREMENT, " ;
			for(int i=0;i<Interface.addedItems.size();i++){
				sql=sql+i+"_"+noSpace(Interface.addedItems.elementAt(i))+" VARCHAR(255), ";
			}
	                   sql=sql +
	                   " PRIMARY KEY (id))"; 
			stA = comA.createStatement();

			b=stA.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
public void Update(String contenu)throws SQLException,NullPointerException{
		
		try {
			String label="";
		//	System.out.println("2");
			for(int i=0;i<Interface.addedItems.size();i++)label=label+i+"_"+noSpace(Interface.addedItems.elementAt(i))+",";
			//System.out.println("3");
			label=label.substring(0,label.length()-1);
		//	System.out.println("label :"+label);
		//	System.out.println(contenu);
			int a=0;
			st = comA.createStatement();
			a=st.executeUpdate("INSERT INTO `formulaire` ("+label+") VALUES ("+contenu+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void UpdateCell(ResultSet rs,int l,int c,String val)throws SQLException{
		try {
			int a;
			int r=0;
			while(r<l+1){
				rs.next();
				r++;
			}
			st = com.createStatement();
			a=st.executeUpdate("UPDATE "+rs.getMetaData().getTableName(1)+" SET "+rs.getMetaData().getColumnName(c+1)+"='"+val+"' WHERE "+rs.getMetaData().getColumnName(1)+"="+rs.getString(1)+";");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet Select(String req){
		ResultSet rs = null;
		try {
			
			st = comA.createStatement();
			rs= st.executeQuery(req);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int Delete(String req){
		int a=0;
		try {
			
			st = com.createStatement();
			a= st.executeUpdate(req);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
	public void RenameColumn(String oldColumn,String newColumn) throws SQLException{
		int b=0;
		try {
			String sql = "ALTER TABLE formulaire CHANGE "+ oldColumn +" "+ newColumn+" VARCHAR(255); ";
			stA = comA.createStatement();

			b=stA.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	String noSpace(FormElement formElement){
		return formElement.labelName.replaceAll("\\s+","");
	}

}
