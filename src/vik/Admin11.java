package vik;
import java.sql.*;
import cont.Connec;

public class Admin11
{

Connection c=Connec.getConnection();
static String name1="name1";
static String course="";
String name="";
static int i1=0;
javax.servlet.jsp.JspWriter out;


public void setName1(String name1)
{
if(!name.equals(null))
this.name1=name1;

		}

public void setName(String name)
{
if(!name.equals(null))
this.name=name;

		}



public void setOut(javax.servlet.jsp.JspWriter out)
	{
this.out=out;
		}

public String details()
{

try{

Statement st=c.createStatement();

String td="<table  width='100%' height='100%'><div align='center'><br><tr><th bgcolor=''>RESULT OUT</th><th bgcolor=''>STUDENTS<th></tr>";
course=name1;
td=td+"<tr><td bgcolor=''>"+course+"</td>"+"<td bgcolor=''><a href=Admin11.jsp?name=1>STUDENTS</a></td>";
td=td+"<div></table>";
out.println(td);
}catch(Exception e){
System.out.println(e);}

return "vv";
}

public String result()
{

try{
//System.out.println(course+"dddddd"+name);
if(!name.equals(""))
{
Statement st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
int i=0;
int  j=0;
int k=1;
int data=0; 
String s1="";

ResultSet rs=st.executeQuery("select Stream from Validroll  where  Stream='"+course+"'");
     while(rs.next())
  {
      i++;
      int a=i%5;
      if(a==1)
  {
    j++;
    s1=s1+"&nbsp;&nbsp;<a href=Admin11.jsp?name="+j+">"+j+"</a>";
 }

  }

data=i;
if(!name.equals("name"))
{
 k=Integer.parseInt(name);
}

ResultSet rs1=st.executeQuery("select * from Validroll  where  Stream='"+course+"'");
String s="<table border='0' background='' cellspacing='1'><tr><th colspan='8' bgcolor=''>Students Details</th></tr><tr><th bgcolor=''>Roll Number</th><th bgcolor=''>Name</th><th bgcolor=''>Result</th><th bgcolor=''>Year</th><th bgcolor=''>Division</th><th bgcolor=''>Course</th><th bgcolor=''>Session</th></tr>";
try{

 for(int i1=k*5-4;i1<=(k*5-4)+4;i1++)
   {
   if(i1>data)
   break;
    rs1.absolute(i1); 

s=s+"<tr>";
for(int ii=1;ii<8;ii++)
s=s+"<td bgcolor=''><div align='center'>"+rs1.getString(ii)+"</div></td>";
s=s+"</tr>";

   	}
s=s+"</table>";    
out.println(s);
out.println(s1);
}catch(Exception e1){out.println(e1);}
}


}catch(Exception e){System.out.println(e);}
return "aa";
	}
    
}
