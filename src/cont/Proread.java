package cont;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Proread extends HttpServlet
{
static String ss,ss1,ss2,ss3;
public void init()
{
try{
Properties p=new Properties();	
ServletContext ctx=getServletContext();

String ss=	ctx.getRealPath("WEB-INF\\Classes\\Property.property");

//System.out.println(ss);
FileInputStream in=new FileInputStream(ss);
p.load(in);
Enumeration e=p.propertyNames();

while(e.hasMoreElements())
{
ss=(String)e.nextElement();
ss1=(String)e.nextElement();
ss2=(String)e.nextElement();
ss3=(String)e.nextElement();
}
System.setProperty(ss,p.getProperty(ss));
System.setProperty(ss1,p.getProperty(ss1));
System.setProperty(ss2,p.getProperty(ss2));
System.setProperty(ss3,p.getProperty(ss3));
java.sql.Connection d=Connec.getConnection();

//System.out.println(d);
}catch(Exception e1){
System.out.println(e1);}
		}
	}