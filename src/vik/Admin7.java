package vik;
import java.sql.*;
import cont.Connec;
public class Admin7
{

Connection c=Connec.getConnection();
javax.servlet.jsp.JspWriter out;
String name="name";
String pold="pold";
String pwold="pwold";
String pnew="pnew";
String pwnew="pwnew";

public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public void setName(String name)
{
if(!name.equals(null))
this.name=name;
	}

public void setPold(String pold)
{
if(!pold.equals(null))
this.pold=pold;
	}

public void setPwold(String pwold)
{
if(!pwold.equals(null))
this.pwold=pwold;
	}

public void setPnew(String pnew)
{
if(!pnew.equals(null))
this.pnew=pnew;
	}

public void setPwnew(String pwnew)
{
if(!pwnew.equals(null))
this.pwnew=pwnew;
	}

public String form()
{

try{

if(name.equals("name"))
{
String td="<TABLE border='1'><form name=form1 action='Admin7.jsp?name=CHANGE' method='post'><tr><td BGCOLOR=''><p><div align='center'>CHANGE  PASSWORD</div></p>";

 td=td+"<p><div align='right'>&nbsp;&nbsp;&nbsp;NAME:<input type='text' name='pold'></div></p><p><p><div align='right'>&nbsp;&nbsp;&nbsp;OLD PASSWORD:<input type='password' name='pwold'></div></p><p><div align='right'>&nbsp;&nbsp;&nbsp;NEW PASSWORD:<input type='password' name='pnew'></div></p><p><div align='right'>&nbsp;&nbsp;&nbsp;REPEAT PASSWORD:<input type='password' name='pwnew'></div></p><div align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style='FONT-WEIGHT: bold' type='submit' value= 'CHANGE' >&nbsp;&nbsp;&nbsp;<INPUT style='FONT-WEIGHT: bold' type=reset value=Reset ></p></div></td></tr></form></TABLE>";
out.println(td);
}


if(name.equals("CHANGE"))
{
int c1=0;
int id1=0;
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("select * from Login where Login.id="+id1);
if(pnew.equals(pwnew))
{
while(rs1.next())
{
String s1=rs1.getString(2);
String s2=rs1.getString(3);

if(pold.equals(s1)&&pwold.equals(s2))
{
c1=1;
PreparedStatement ps=c.prepareStatement("update Login  set Login.password=? where Login.id=?");
ps.setString(1,pwnew);
ps.setInt(2,id1);

int a=ps.executeUpdate();
if(a==1)
{
out.println("<table  bordercolor='' border='1'><tr><td bgcolor=''>CHANGED= "+pold+" "+pwold+" "+pold+" "+pwnew+"</td></tr><tr><td bgcolor=''><div align='center'><a href='Login2.jsp'>NOW TRY THIS LOGIN AGAIN</a></div></td></tr></table>");
}
if(a==0)
{
out.println("<table  bordercolor='' border='1'><tr><td bgcolor=''>PASSWORD IS MISSMATCH</td></tr></table>");
}

}
}

if(c1==0)
{
out.println("<table  bordercolor='' border='1'><tr><td bgcolor=''>NAME OR PASSWORD IS MISSMATCH</td></tr></table>");
}

}
else
{
out.println("<table  bordercolor='' border='1'><tr><td bgcolor=''>NEW PASSWORD AND CONFORM PASSWORD MISSMATCH</td></tr></table>");
}

}


}catch(Exception e){e.printStackTrace();
System.out.println(e);}


return "vv";
}
    
}
