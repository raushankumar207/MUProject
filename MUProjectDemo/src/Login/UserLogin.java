package Login;
//import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;

import GlobalConnection.Connections;
import ProBaseClass.LoginProcessBase;
//import java.sql.PreparedStatement;
public class UserLogin extends LoginProcessBase {

	/**
	 * @param args
	 */
	
	Boolean flag=false;
	//Connection con;
	//PreparedStatement ps;
	//ResultSet rs;
	public UserLogin(String uname,String upassword)
	{
			super.UserName=uname;
			super.UserPassword=upassword;
	}
	public boolean validatelogin()
	{
		super.con=Connections.getConnections();
		String sqlqry="select username,userpassword from userdetails";
		try {
			//ps=con.prepareStatement(sqlqry);
			super.ps=super.con.prepareStatement(sqlqry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			super.rs=super.ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(super.rs.next())
			{
				if(super.UserName.equals(super.rs.getString(1)) && super.UserPassword.equals(super.rs.getString(2)))
				{
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				super.con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return flag;
	}
}
