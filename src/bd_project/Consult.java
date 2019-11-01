/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_project;
import java.sql.*;
import javax.swing.JOptionPane;
//import JOptionPane


/**
 *
 * @author Arlet
 */
public class Consult {
    Statement state;
	public Consult(Connection conn)
	{
		try{
			state = conn.createStatement();
		}catch(Exception e)
		{
			System.out.println("SQLException: " + e.getMessage());
		}
		
	}

	public ResultSet getRes(String tablename, String curvename)
	{
            //return the values of the selected curve 
		ResultSet res= null;
		try{
		String query = "SELECT * FROM " +tablename + " WHERE nombre = '"+ curvename+"'";
		res = state.executeQuery(query);
                
              
                if(!res.next()){JOptionPane.showMessageDialog(null, "La curva no existe en la base de datos","Warning",JOptionPane.WARNING_MESSAGE);}
		while (res.next()) {  System.out.println(res.getString(1));
                }
			 
		}
		catch(Exception e){
                     //JOptionPane.showMessageDialog(null, "La curva no existe en la base de datos");
                    System.out.println("GET CURVA");
                    System.out.println("SQLException: " + e.getMessage()); }
		return res;
	}
        
        public ResultSet getRes(String tablename)
	{
		ResultSet res= null;
		try{
		String query = "SELECT * FROM " +tablename;
		res = state.executeQuery(query);
		//while (res.next()) {  System.out.println(res.getString(1));  }
			 
		}
		catch(Exception e){System.out.println("SQLException: " + e.getMessage()); }
		return res;
	}
        
        public void deleteCurve(String table_name, String ID) {
        try {
            getRes(table_name,ID);
            String Query = "DELETE FROM " + table_name + " WHERE Nombre = \"" + ID + "\"";
            state.executeUpdate(Query);
 
        } catch (SQLException ex) {
            System.out.println("DELETE");
             System.out.println("The curve does not exist");
              JOptionPane.showMessageDialog(null, "La curva no existia en la base de datos","Warning",JOptionPane.WARNING_MESSAGE);
            //System.out.println(ex.getMessage());
        }}
        
        public void insertCurve(String table_name, String ID, String name,String abbr) {
        try {
           /* String query = "INSERT INTO " + table_name + " VALUES (NULL"
                    + "\"" + name + "\""
                    + "\"" + abbr +  "\")";*/
            String query = "INSERT INTO "+table_name +" VALUES(NULL," + "\""+name+"\"," + "\""+abbr +"\")";
            state.executeUpdate(query);
        } catch (SQLException e) {
           	
                
		System.out.println("SQLException: " + e.getMessage()); 

        }
    }
        
       /* public void insertByFile(String filename, String tablename){
            try{
            String query = "LOAD DATA LOCAL INFILE 'C:/Users/Arlet/Documents/ADD_BY_FILE/"+filename +"' INTO TABLE "+tablename+ " FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY ';'" ;
            state.executeUpdate(query);
             } catch (SQLException e) {
           	
		System.out.println("SQLException: " + e.getMessage()); 
            }
        }*/
         public void insertByFile(String direction_filename, String tablename){
             //This function must be improved
            try{
               direction_filename= direction_filename.replace('\\', '/');
             
                //the file must have the same format of the expected entry by the database
            String query ="LOAD DATA LOCAL INFILE '"+ direction_filename +"' INTO TABLE "+tablename+ " FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY ';'" ;
            state.executeUpdate(query);
             } catch (SQLException e) {
           	//print an error message
                
             JOptionPane.showMessageDialog(null, "No es posible insertar la curva. Error en la direccion!","Warning",JOptionPane.WARNING_MESSAGE);
		//System.out.println("SQLException: " + e.getMessage()); 
            }
        }

}
