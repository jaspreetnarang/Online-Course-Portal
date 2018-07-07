package vik;
import java.sql.*;
import cont.Connec;
public class Result
{

Connection c=Connec.getConnection();
String name;
javax.servlet.jsp.JspWriter out;

public void setName1(String name1)
{
this.name=name1;
		}

public String  getName()
{
return name;
		}


public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String year()
{
try{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select distinct Validroll.Year from Validroll");
while(rs.next())
{
String s=rs.getString(1);
out.println("<option value="+s+">"+s+"</option>");
}
}catch(Exception e){}
return "return";
}

public String session()
{
try{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select distinct Validroll.Session from Validroll");
while(rs.next())
{
String s=rs.getString(1);
out.println("<option value="+s+">"+s+"</option>");
}
}catch(Exception e){}
return "return";
}


public String course()
{
try{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select distinct Validroll.Stream from Validroll");
while(rs.next())
{
String s=rs.getString(1);
out.println("<option value="+s+">"+s+"</option>");
}

}catch(Exception e){System.out.println("eeee"+e);}
return "return";

}


	}	


