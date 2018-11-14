package connectjavatoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JavaDbConnection 
{
    static String conUrl = "jdbc:sqlserver://localhost; databaseName=PTM_DB; user=sa; password=india@123;";
	public static String Company,Group,Prev,Curr,Change;
	public static ResultSet rs;
	
    public static void main(String[] args) 
	{
		try{  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			Connection con=DriverManager.getConnection(conUrl);  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			 rs=stmt.executeQuery("select * from TableDemo"); 
			
			while(rs.next())  
			{
				Company=rs.getString(1);
				Group=rs.getString(2);
				Curr=rs.getString(3);
				Prev= rs.getString(4);
				Change= rs.getString(5);
				System.out.println(Company+"       "+Group+"    "+Curr+"    "+Prev+"   "+Change);
			}
				con.close();  
			}
			catch(Exception e)
			{
				System.out.println(e);
			}  
	}

}


