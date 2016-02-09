package Registration;

import java.sql.SQLException;

import GlobalConnection.Connections;
import ProBaseClass.LoginProcessBase;

public class UserRegistration extends LoginProcessBase {

	/**
	 * @param args
	 */
	String sqlquery="";
	Boolean flag=false;
	int status;
	public UserRegistration(String username)
	{
		super.UserName=username;
	}
	public UserRegistration(String uname,String upass,String usecquestion,String usecqueans)
	{
		try
		{
			super.UserName=uname;
			super.UserPassword=upass;
			super.SecuriyQuestion=usecquestion;
			super.QuestionAnswer=usecqueans;
		}
		catch(Exception exp)
		{
			System.out.print(exp.toString());
		}
	}
	public boolean validateusername()
	{
		flag=false;
		sqlquery="select username from userdetails";
		super.con=Connections.getConnections();
		try {
			super.ps=super.con.prepareStatement(sqlquery);
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
			while(rs.next())
			{
				if(super.UserName.equals(rs.getString(1)))
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
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	public int insertRegRecord()
	{
		sqlquery="insert into userdetails(username,userpassword,usersecurityque,usersecurityans) values('" + super.UserName + "', '" + super.UserPassword + "', '" + super.SecuriyQuestion + "', '" + super.QuestionAnswer + "')";
		super.con=Connections.getConnections();
		try {
			super.ps=con.prepareStatement(sqlquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			status=super.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
}
