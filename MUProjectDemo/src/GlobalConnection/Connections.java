package GlobalConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

	/**
	 * @param args
	 */
	public static Connection getConnections() {
		//String url="jdbc:oracle:thin:@localhost:1521:xe";
		String url="jdbc:odbc:DBCon";
		//String userName="system";
		//String password="manager";
		Connection conn=null;
		try {
			String driver="sun.jdbc.odbc.JdbcOdbcDriver";
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(driver);
			//System.out.println("Driver Registered...");
			conn=DriverManager.getConnection(url);
			//System.out.println("Connection created...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}
}
