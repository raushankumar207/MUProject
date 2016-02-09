package cpassword;

import java.sql.*;

import GlobalConnection.Connections;
import ProBaseClass.LoginProcessBase;
import Registration.UserRegistration;

public class ChangePassword extends LoginProcessBase {

	/**
	 * @param args
	 */
	Boolean usrflag=false;
	Boolean ansflag=false;
	String UserName,SecurityAns,password,confirmpassword;
	String sqlQuery,strsecque;
	public ChangePassword(String uname)
	{
		super.UserName=uname;
	}
	public ChangePassword(String secQue,String secQueAns,String usrPassword,String userName)
	{
		super.SecuriyQuestion=secQue;
		super.QuestionAnswer=secQueAns;
		super.UserPassword=usrPassword;
		super.UserName=userName;
	}
	public String showsecurityques()
	{
		strsecque="";
		UserRegistration ur=new UserRegistration(super.UserName);
		if(ur.validateusername())
		{
			super.con=Connections.getConnections();
			sqlQuery="select usersecurityque from userdetails where username='" + super.UserName + "'";
			try {
				super.ps=super.con.prepareStatement(sqlQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				super.rs=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(rs.next())
				{
					strsecque=rs.getString(1);
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
		}
		else
		{
			strsecque="User Does'nt Exist";
		}
		return strsecque;
	}	
	public boolean valsecquesans()
	{
		ansflag=false;
		int status=0;
		super.con=Connections.getConnections();
		sqlQuery="select count(*) from userdetails where usersecurityque='" + super.SecuriyQuestion + "' and usersecurityans='" + super.QuestionAnswer + "'";
		try {
			super.ps=con.prepareStatement(sqlQuery);
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
				status=rs.getInt(1);
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
		if(status==1)
		{
			ansflag=true;
		}
		return ansflag;
	}
	
	public int updatepassword()
	{
		int status=0;
		super.con=Connections.getConnections();
		sqlQuery="update userdetails set userpassword='" + super.UserPassword + "' where username='" + super.UserName + "' and usersecurityque='" + super.SecuriyQuestion + "' and usersecurityans='" + super.QuestionAnswer + "'";
		try {
			super.ps=con.prepareStatement(sqlQuery);
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
