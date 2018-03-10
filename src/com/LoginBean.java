package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;



@Stateless
@LocalBean
public class LoginBean {
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String dbpassword;
	private String email;
	private String isadmin;
	private String isValidated = "false";

	
	public void setFirstname(String fname) {
		firstname = fname;		
	}
	
	public String getFirstname() {
		return firstname;		
	}
	
	public void setLastname(String lname) {
		lastname = lname;		
	}
	
	public String getLastname() {
		return lastname;		
	}
	
	public void setUsername(String uname) {
		username = uname;		
	}
	
	public String getUsername() {
		return username;		
	}
	
	private void setActualPassword(String pword) {
		dbpassword = pword;		
	}
	
	private String getActualPassword() {
		return dbpassword;		
	}
	
	public void setPassword(String pword) {
		password = pword;		
	}
	
	public String getPassword() {
		return password;		
	}
	
	public void setEmail(String mail) {
		email = mail;		
	}
	
	public String getEmail() {
		return email;		
	}
	
	public void setIsAdmin(String iadmin) {
		isadmin = iadmin;		
	}
	
	public String getIsAdmin() {
		return isadmin;		
	}
	
	public String getIsValidated() {
	    return isValidated;
    }
	
	private void setIsValidated(String val) {
		isValidated = val;
	}

	
	
	
	public void lookup() throws SQLException {
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;

    	try {
    		String _sql_query = "SELECT * FROM users WHERE username LIKE '" + getUsername() + "'";
    		String _DB_URL = "localhost:5432/postgres";
    		connection = DriverManager.getConnection("jdbc:postgresql://" + _DB_URL);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(_sql_query);
    		
            while (resultSet.next()) {
	    	     setUsername(resultSet.getString("username"));
	    	     setFirstname(resultSet.getString("firstname"));
	    	     setLastname(resultSet.getString("lastname"));
	    	     setActualPassword(resultSet.getString("password"));
	    	    // setEmail(resultSet.getString(email));      //  Add this to the database!
	    	     setIsAdmin(resultSet.getString("isadmin"));
	    	     
	    	     if ( String(password).equals(dbpassword) )
	    	  //   if ( password == dbpassword )
	    	     {
	    	    	 setIsValidated("true");
	    	    	 System.out.println("VALIDATED");
	    	     }
	    	     else {
	    	    	 System.out.println("Given passwd = '" + getPassword() + "'");
	    	    	 System.out.println("Actual passwd = '" + getActualPassword() + "'");
	    	     }
	    	     
	    	     System.out.println(getUsername());
	    	     System.out.println(getFirstname());
	    	     System.out.println(getLastname());
	    	     System.out.println(getPassword());
	    	     System.out.println(getEmail());
	    	     System.out.println(getIsAdmin());
            }
    	     
/*
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
*/
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
