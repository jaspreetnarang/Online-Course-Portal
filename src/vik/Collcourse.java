package vik;
import cont.Connec;
import java.sql.*;

public class Collcourse
{

Connection c=Connec.getConnection();
static String name1="name1";
String name="name";
static String name2="name2";
int data=0;


javax.servlet.jsp.JspWriter out;
int i=0;

public void setName1(String name1)
{
if(!name1.equals(null))
this.name1=name1;
//System.out.println(name1);
		}

public void setName(String name)
{
if(!name.equals(null))
this.name=name;
		}

public void setName2(String name2)
{
if(!name2.equals(null))
this.name2=name2;
		}




public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}


public String links()
{
try{

int i=0;
int  j=0;
int k=1;
String s2="";
Statement st1=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

if(!name2.equals("name2"))
{
 k=Integer.parseInt(name2);
}
int id=Integer.parseInt(name1);

ResultSet rs=st1.executeQuery("select* from Collcourse where id="+id);
    while(rs.next())
  {
//System.out.println(rs.getString(2));
      i++;
      int a=i%5;
      if(a==1)
  {
    j++;
    s2=s2+"<a href=Collcourse.jsp?name2="+j+">"+j+"</a>&nbsp;&nbsp;";
    }
  }
data=i;

ResultSet rs1=st1.executeQuery("select* from Collcourse where id="+id);
String s="<table width='50%'>";

if(rs1.next()==false)
out.println("<TABLE width '100%'><TH BGCOLOR='#000000'><div align='center'>STILL NO COURSE IS AVAILABLE</div></TH></TABLE>");


    
 for(int i1=k*5-4;i1<=(k*5-4)+4;i1++)
   {
   if(i1>data)
   break;

    rs1.absolute(i1); 
    String s1=rs1.getString(2);
    s=s+"<tr><td bgcolor=''><a href=Collcourse.jsp?name="+s1+">"+s1+"</a></td></tr>";
}
	
s=s+"</table>";    
out.println(s);
out.println(s2);

}catch(Exception e){System.out.println(e);e.printStackTrace();}
return "return";

		}


public String linkcol()
{
try{
//out.println(c);
int id=Integer.parseInt(name1);
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select* from Collcourse where id="+id+" and course='"+name+"'");
String s[]={"Diploma/Degree ->","Courses for ->","Duration ->","Description ->"};
   String ss="<table width='50%'  border='0' cellspacing='2' cellpadding='0'><tr><th height='40' bgcolor= '' colspan='2' scope='col'><div align='center'>COURSE DETAILS</div></th></tr>";
    while(rs.next())
   {

	 for(int i=3;i<=6;i++)
	{
	   ss=ss+"<tr><td bgcolor='' width='55%'  height='12' scope='col'><div align='right'>"+s[i-3]+"</div></td><td bgcolor='' height='12 width='50%'  scope='col'><div align='right'>"+rs.getString(i)+"</div></td></tr>";
	    }
     
 }
    
ss=ss+"</table>";
out.println(ss);

}catch(Exception e){e.printStackTrace();System.out.println(e);}
return "return";

		}


	}	


