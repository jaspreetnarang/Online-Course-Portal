package cont;
import java.sql.*;
public class Connec
{
static String driver;
static String dsn;
static String user;
static String pass;
static Connection c;
public static Connection getConnection()
{
try{
if(c==null)
{
//System.out.println("Connect enter="+c);
driver=System.getProperty("driver");
dsn=System.getProperty("dsn");
user=System.getProperty("user");
pass=System.getProperty("pass");
//System.out.println("driver="+driver);
Class.forName(driver);
c=DriverManager.getConnection(dsn,user,pass);
//System.out.println("Connection stablished="+c);
			}		
}catch(Exception e){System.out.println(e);}
return c;
	
 	 	} 	
	}