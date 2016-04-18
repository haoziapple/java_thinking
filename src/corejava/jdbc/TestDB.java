/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.jdbc.TestDB
 * @description:TODO
 * @date:2016-4-18 下午2:02:37
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-18     WangHao       v1.0.0        create
 *
 *
 */
package corejava.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This program tests that the database and the JDBC driver are correctly
 * configured.
 * 
 * Run the program:
 * java -classpath .:driverJar jdbc.TestDB
 */
public class TestDB
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			runTest();
		}
		catch (SQLException e)
		{
			for (Throwable t : e)
				t.printStackTrace();
		}
	}

	public static void runTest() throws SQLException, IOException
	{
		Connection conn = getConnection();
		Statement stat = conn.createStatement();
		stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
		stat.executeUpdate("INSERT INTO Greetings VALUES('Hello, World!')");

		ResultSet result = stat.executeQuery("SELECT * FROM Greetinhs");
		if (result.next())
			System.out.println(result.getString(1));
		stat.executeUpdate("DROP TABLE Greetings");
	}

	/**
	 * Gets a connection from the properties specified in the file
	 * database.properties.
	 */
	public static Connection getConnection() throws SQLException, IOException
	{
		Properties props = new Properties();
		InputStream in = Files.newInputStream(Paths.get("database.properties"));
		props.load(in);

		String drivers = props.getProperty("jdbc.drivers");
		if (drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		return DriverManager.getConnection(url, username, password);

	}

}
