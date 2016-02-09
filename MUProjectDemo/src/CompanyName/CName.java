package CompanyName;

import java.sql.SQLException;
import java.io.*;

import GlobalConnection.Connections;
import ProBaseClass.*;
public class CName extends LoginProcessBase {
	String cid,cname;
	String strcid="";
	int status=0;
	String query="";
	Boolean flag;
	public CName()
	{
	}
	public CName(String cid)
	{
		this.cid=cid;
	}
	public CName(String cmpid,String cmpname)
	{
		this.cid=cmpid;
		this.cname=cmpname;
	}
	public int getnoofrow()
	{
		super.con=Connections.getConnections();
		int row=0;
		query="select count(*) from company_name";
		try {
			super.ps=super.con.prepareStatement(query);
			super.rs=super.ps.executeQuery();
			if(rs.next())
			{
				row=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	public String genCId()
	{
		super.con=Connections.getConnections();
		int row=getnoofrow();
		query="select CID from company_name";
		try {
			super.ps=super.con.prepareStatement(query);
			super.rs=super.ps.executeQuery();
			if(row>0)
			{
				while(rs.next())
				{
					strcid=rs.getString(1);
					String c=strcid.substring(1, strcid.length());
					int id=Integer.parseInt(c)+1;
					strcid="C"+Integer.toString(id);
				}
			}
			else
			{
				strcid="C1";
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
		
		return strcid;
	}
	public int inscname()
	{
		super.con=Connections.getConnections();
		query="insert into company_name values(?,?)";
		try {
			super.ps=con.prepareStatement(query);
			super.ps.setString(1, cid);
			super.ps.setString(2, cname);
			status=super.ps.executeUpdate();
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
		return status;
	}
	public Boolean valcname()
	{
		flag=true;
		super.con=Connections.getConnections();
		query="select cname from company_name";
		try {
			super.ps=super.con.prepareStatement(query);
			super.rs=super.ps.executeQuery();
			while(rs.next())
			{
				if(this.cname.equals(rs.getString(1)))
				{
					flag=false;
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
	public String[] getComapnyName()
	{
		super.con=Connections.getConnections();
		int row=getnoofrow(),index=0;
		String[] cpname=new String[row];
		query="select cname from company_name";
		try {
			super.ps=con.prepareStatement(query);
			super.rs=super.ps.executeQuery();
			while(rs.next())
			{
				cpname[index]=rs.getString(1);
				index++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpname;
	}
	public int updatecname()
	{
		super.con=Connections.getConnections();
		status=0;
		query="update company_name set CNAME=? where CID=?";
		try {
			super.ps=super.con.prepareStatement(query);
			super.ps.setString(1, this.cname);
			super.ps.setString(2, this.cid);
			status=super.ps.executeUpdate();
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
		return status;
	}
	public String getcmpname()
	{
		super.con=Connections.getConnections();
		String cname="";
		query="select CNAME from company_name where CID=?";
		try {
			super.ps=super.con.prepareStatement(query);
			super.ps.setString(1, this.cid);
			super.rs=super.ps.executeQuery();
			if(rs.next())
			{
				cname=rs.getString(1);
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
		return cname;
	}
	public static void main(String args[])
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice=0;
		String cid,cname;
		cid=cname=null;
		System.out.println("Enter your choice:-");
		System.out.println("1.Add Company Name\n2.Search Company Name By Cid\n3.Display All Company Name\n4.Update Company Name By Cid");
		System.out.print("Enter your choice:-");
		try {
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1:
				System.out.println("Company Id");
				CName cn=new CName();
				System.out.println(cn.genCId());
				cid=cn.genCId();
				System.out.println("Enter Company Name:-");
				cname=br.readLine();
				CName cmpname=new CName(cid,cname);
				if(cmpname.valcname())
				{
					if(cmpname.inscname()==1)
					{
						System.out.println("Record Inserted");
					}
				}
				else
				{
					System.out.println("Company Name Already Exist");
				}
				break;
			case 2:
				System.out.println("Enter Company Name Id");
				cid=br.readLine();
				CName cpname=new CName(cid);
				System.out.println("Company Name is -" + cpname.getcmpname());
				break;
			case 3:
				int index=1;
				CName getallcpname=new CName();
				System.out.println("All Mobile Comapny Brand Name List");
				System.out.print("CID\tCName\n....\t...........\n");
				for(String discpname:getallcpname.getComapnyName())
				{
					System.out.println("C" + index + "\t" + discpname);
					System.out.println("....\t...........");
					index++;
				}
				break;
			case 4:
				System.out.println("Enter Company Name Id");
				cid=br.readLine();
				CName cpnm=new CName(cid);
				if(cpnm.getcmpname().equals(""))
				{
					System.out.println("Company Name Does't Exist");
				}
				else
				{
					System.out.println("Company Name is -" + cpnm.getcmpname());
					System.out.println("Enter Correct Company name");
					cname=br.readLine();
					CName cmpupdate=new CName(cid,cname);
					if(cmpupdate.updatecname()==1)
					{
						System.out.println("Company Name Update Successfully");
					}
					else
					{
						System.out.println("Company Name Not Update Successfully");
					}
				}
				break;
				default:
					System.out.println("Invlid choice");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
