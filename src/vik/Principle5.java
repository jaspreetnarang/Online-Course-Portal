package vik;
import java.sql.*;
import cont.Connec;
public class Principle5
{

Connection c=Connec.getConnection();
String name1="dd";
String pold="pold";
String pwold="pwold";
String pnew="pnew";
String pwnew="pwnew";
String id="id";

javax.servlet.jsp.JspWriter out;
public void setId(String id)
{
if(!id.equals(null))
this.id=id;
		}

public void setName1(String name1)
{
if(!name1.equals(null))
this.name1=name1;
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

public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String change()
{
try{
if(name1.equals("Change"))
out.println("<TABLE  bordercolor='' border='1'><TR><TD><form name=form1 action='Principle5.jsp?name1=CHANGE' method='post'><tr><td BGCOLOR=''><p><div align='center'>CHANGE  PASSWORD</div></p><p><div align='right'>&nbsp;&nbsp;&nbsp;NAME:<input type='text' name='pold'></div></p><p><p><div align='right'>&nbsp;&nbsp;&nbsp;OLD PASSWORD:<input type='password' name='pwold'></div></p><p><div align='right'>&nbsp;&nbsp;&nbsp;NEW PASSWORD:<input type='password' name='pnew'></div></p><p><div align='right'>&nbsp;&nbsp;&nbsp;CONFORM PASSWORD:<input type='password' name='pwnew'></div></p><div align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type='submit' value= 'CHANGE' >&nbsp;&nbsp;&nbsp;<INPUT  type=reset value=Reset ></p></div></td></tr></form></TD></TR></TABLE>");


if(name1.equals("CHANGE"))
{
int c1=0;
int id1=0;
id1=Integer.parseInt(id);
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
out.println("<table  bordercolor='' border='1'><tr><td bgcolor=''>CHANGED= "+pold+" "+pwold+" "+pold+" "+pwnew+"</td></tr><tr><td bgcolor=''><div align='center'><a href='Login1.jsp'>NOW TRY THIS LOGIN AGAIN</a></div></td></tr></table>");
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



}catch(Exception e){System.out.println("NEW1"+e);}
return "vv";

}
}
