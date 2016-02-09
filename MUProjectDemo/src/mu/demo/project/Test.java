package mu.demo.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GlobalConnection.*;
public class Test {

	/**
	 * @param args
	 */
	
	void selectUser(){
		Connection conn=Connections.getConnections();
		String sql="select * from userdetails";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	public static void main(String[] args) {
		new Test().selectUser();

	}

}
