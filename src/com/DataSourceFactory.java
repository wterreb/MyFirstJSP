package com;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
*/
import java.sql.*;



import java.util.List;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.UUID;

@Stateless
@LocalBean
public class DataSourceFactory  { 

    public void dummydbquery() throws SQLException {
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;

    	try {
    		String _sql_query = "SELECT * FROM temptable";
    		String _DB_URL = "localhost:5432/postgres";
    		connection = DriverManager.getConnection("jdbc:postgresql://" + _DB_URL);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(_sql_query);
    		
    	     List<String> fields = new ArrayList<String>();
    	     ResultSetMetaData rsmd = resultSet.getMetaData();
    	     for (int i = 1; i <= rsmd.getColumnCount(); i++) {
    	       fields.add(rsmd.getColumnName(i));
    	     }
  
    	     int rowCount = 0;
    	     while (resultSet.next()) {
    	    	 rowCount++;
    	    	 System.out.println("---------------------------------------------------");
    	     	 System.out.println("--- Rows:" + rowCount);
    	     	 System.out.println("---------------------------------------------------");

    	         for (String field : fields) {
    	        	 System.out.println(field + ":" + resultSet.getString(field));
    	         }
    	     }

    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally {
    	    	 if (resultSet != null) {
    	    		 resultSet.close();
    	    	 }
    	    	 if (statement != null) {
    	    		 statement.close();
    	    	 }
    	    	 if (connection != null) {
    	    		 connection.close();
    	    	 }
    	     }
    	     
    		/*
	    	PGConnectionPoolDataSource source = new PGConnectionPoolDataSource();
	        source.setDataSourceName(UUID.randomUUID().toString());
	        source.setServerName("localhost");
	        source.setDatabaseName("postgres");
	        source.setPortNumber(5432);
	        source.setUser("postgres");
	        source.setPassword("bea123");
	        source.setMaxConnections(10);
	        return source;
    		*/ 
    	    
    }

}