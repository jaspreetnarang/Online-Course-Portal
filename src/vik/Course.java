package vik;
import cont.Connec;
import java.sql.*;

public class Course
{

Connection c=Connec.getConnection();
String name="name";
static String name1="name1";

int data=0;

javax.servlet.jsp.JspWriter out;
int i=0;

public void setName(String name)
{
this.name=name;
		}

public void  setName1(String name1)
{
this.name1=name1;		}



public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}


public String links()
{
try{
Statement st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
int i=0;
int  j=0;
int k=1;
String s1="";
ResultSet rs=st.executeQuery("SELECT * from Courses");
     while(rs.next())
  {
//System.out.println(rs.getString(2));
      i++;
      int a=i%5;
      if(a==1)
  {
    j++;
    s1=s1+"&nbsp;&nbsp;<a href=Courses.jsp?name1="+j+">"+j+"</a>";
    }

  }
data=i;

ResultSet rs1=st.executeQuery("SELECT * from Courses");
String s="<table>";
if(!name1.equals("name1"))
{
 k=Integer.parseInt(name1);
}
//System.out.println("@@@= "+data);
 for(int i1=k*5-4;i1<=(k*5-4)+4;i1++)
   {
   if(i1>data)
   break;

    rs1.absolute(i1); 
    String id=rs1.getString(1);
    s=s+"<tr><td bgcolor=''><a href=Courses.jsp?name="+id+">"+id+"</a><td></tr>";
   	}

s=s+"</table>";    
out.println(s);
out.println(s1);

}catch(Exception e){}
return "return";

		}


public String linkcol()
{
try{
//out.println(c);
if(!name.equals("name"))
{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT * from Courses where Course='"+name+"'");
String s[]={"Diploma/Degree ->","Course for ->","Duration ->","Description ->"};
   String ss="<table width='50%'  border='0' cellspacing='2' cellpadding='0'><tr><th height='40' bgcolor= '' colspan='2' scope='col'><div align='center'>COURSE DETAILS</div></th></tr>";
    while(rs.next())
   {

	 for(int i=2;i<=5;i++)
	{
	   ss=ss+"<tr><td bgcolor='' width='50%'  height='12' scope='col'><div align='right'>"+s[i-2]+"</div></td><td bgcolor='' height='12 width='50%'  scope='col'><div align='center'>"+rs.getString(i)+"</div></td></tr>";
	    }
     
 }
    
ss=ss+"</table>";
out.println(ss);
}
}catch(Exception e){e.printStackTrace();System.out.println(e);}
return "return";

		}


	}	


