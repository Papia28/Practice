package webApplication.testingFramework.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import webApplication.testingFramework.base.PageObjects;

public class DatabaseConnection 
{
	public static Logger log = LogManager.getLogger(DatabaseConnection.class.getName());
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static String username = null;
	private static String password = null;
	private static String host = null;
	private static String port = null;
	private static String dbName = null;	
	private static String url = null;	

	public static Connection openConnection() throws Throwable 
	{
		try {
			log.debug("Establising database connection.");
			username = PageObjects.getConfigKeyValue("DBusername");
			password = PageObjects.getConfigKeyValue("DBpassword");
			host = PageObjects.getConfigKeyValue("host");
			port = PageObjects.getConfigKeyValue("port");
			dbName = PageObjects.getConfigKeyValue("DBname");
			
			url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			
			connection = DriverManager.getConnection(url, username, password);
			log.info("Database connection successfull!");
			
			return connection;
		} 
		catch (SQLTimeoutException t) 
		{
			t.printStackTrace();
			log.fatal("SQL Timeout error while establishing connection to database.");
			throw t;
		}
		catch (SQLException t) 
		{
			t.printStackTrace();
			log.fatal("SQL error while establishing connection to database.");
			throw t;
		}		
		catch (Throwable t) 
		{
			t.printStackTrace();
			log.fatal("Error in establishing connection to database.");
			throw t;
		}
	}

	public static void runQuery(String query) throws Throwable 
	{
		try {
			log.debug("Running given query.");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			log.info("Query run successfull!");
		} 
		catch (SQLTimeoutException t) 
		{
			t.printStackTrace();
			log.fatal("SQL Timeout error while running query in database.");
			throw t;
		}
		catch (SQLException t) 
		{
			t.printStackTrace();
			log.fatal("SQL error while running query in database.");
			throw t;
		}
		catch (Throwable t) 
		{
			t.printStackTrace();
			log.fatal("Error while running query in database!");
			throw t;
		}
	}
	
	public static String getQueryResult(String columnLabel) throws Throwable 
	{
		log.debug("Getting required data.");
		String data = null;
		try {
			while(resultSet.next())
			{
				data = resultSet.getString(columnLabel);
				break;
			}
			log.info("Data collected successfully!");			
			return data;
		} 
		catch (SQLException t) 
		{
			t.printStackTrace();
			log.fatal("SQL error in getting query result!");
			throw t;
		}
		catch (Throwable t) 
		{
			t.printStackTrace();
			log.fatal("Error in getting query result!");
			throw t;
		}
	}
	
	public static void closeConnection(String query) throws Throwable 
	{
		try {
			log.debug("Closing database connection.");
			resultSet.close();
			statement.close();
			connection.close();
			log.info("Database connection closed successfully!");
		} 
		catch (SQLException t) 
		{
			t.printStackTrace();
			log.fatal("SQL error in closing connection to database!");
			throw t;
		}
		catch (Throwable t) 
		{
			t.printStackTrace();
			log.fatal("Error in closing connection to database!");
			throw t;
		}
	}
}
