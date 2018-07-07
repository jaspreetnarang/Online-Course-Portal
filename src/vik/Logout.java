package vik;
import java.sql.*;
import cont.Connec;
public class Logout
{

Connection c=Connec.getConnection();

String id="0";

javax.servlet.jsp.JspWriter out;

public void setId(String id)
{
if(!id.equals(null))
this.id=id;
		}

public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String details()
{
try{
String name="";
int id1=Integer.parseInt(id);
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select Name from Login where id="+id1);
while(rs.next())
{
name=rs.getString(1);
}

out.println("<table><tr><td><div align='center'>"+name+" LOGGED OUT SUCCESSFULL</div></td></tr><tr><td><div align='center'><a href='Login.jsp'>HOME</a></div></td></tr></table>");

}catch(Exception e){}
return "s";
}
}