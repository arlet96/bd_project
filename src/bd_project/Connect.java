/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_project;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Arlet
 */
public class Connect {
    Connection connection;
	String dbname;

	private void displaySQLErrors(Exception e) 
	{ 
		System.out.println("SQLException: " + e.getMessage()); 
		//System.out.println("SQLState:     " + e.getSQLState());
		//System.out.println("VendorError:  " + e.getErrorCode());
	}
	public Connect(String database)
	{//podria pasar el usuario y la contrasennatambien
		//JDBC
		try { 			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url ="jdbc:mysql://localhost:3306/"+ database;
	        String user ="root";
	        String pass ="apa";//database's password
                connection = DriverManager.getConnection(url,user,pass);
		} 
		catch (Exception e){ 
                    JOptionPane.showMessageDialog(null, "Error with the conection");
			System.err.println("Unable to find and load driver of JDBC"); 
			System.exit(1); 
		} 
	}

	
	public Connection GetCon()
	{
		return connection;
	}

	 public void closeCon() {
             try {
                 connection.close();
             } 
             catch (Exception e) {
           System.out.println("SQLException: " + e.getMessage());}
         }
}
