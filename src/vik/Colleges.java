package vik;
import java.sql.*;
import cont.Connec;

public class Colleges
{

Connection c=Connec.getConnection();
static String name="name";
String name1="name1";
javax.servlet.jsp.JspWriter out;
int data=0;

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
int i=0;
int  j=0;
int k=1;
Statement st1=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
ResultSet rs=st1.executeQuery("select * from Colleges");
String s1="";
     while(rs.next())
  {
//System.out.println(rs.getString(2));
      i++;
      int a=i%5;
      if(a==1)
  {
    j++;
    
s1=s1+"&nbsp;&nbsp;<a href=Colleges.jsp?name="+j+">"+j+"</a>";

    }

  }
data=i;

ResultSet rs1=st1.executeQuery("select* from Colleges");

String s="<table>";

if(!name.equals("name"))
{
 k=Integer.parseInt(name);
}
//System.out.println("@@@= "+data);
 for(int i1=k*5-4;i1<=(k*5-4)+4;i1++)
   {
   if(i1>data)
   break;

    rs1.absolute(i1); 
    int id=rs1.getInt(1);
    s=s+"<tr><td bgcolor=''><a href=Colleges.jsp?name1="+id+">"+rs1.getString(2)+"</a><td></tr>";
   	}

s=s+"</table>";    
out.println(s);
out.println(s1);

}catch(Exception e){e.printStackTrace();}
return "return";

		}


public String linkcol()
{
try{


if(!name1.equals("name1"))
{
int n=Integer.parseInt(name1);
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT * from Colldetail where id="+n);
String s2="<table>";
String s[]=new String[6]; 
while(rs.next())
{
for(int i=2;i<=7;i++) 
{
s[i-2]=rs.getString(i);
}

for(int i=0;i<=5;i++)
{
if(i==0)
s2=s2+"<tr><th height='30' bgcolor='' colspan='3'>COLLEGE DETAILS</th></tr><tr><td bgcolor='' colspan='1'>ADDRESS</td><td bgcolor='' colspan='1'>PHONE NO.</td><td bgcolor='' colspan='1'>FAX NO.</td></tr><tr>";

if(i==3)
s2=s2+"</tr><tr><th height='10'></th></tr><tr><th height='20' bgcolor='' colspan='3'>PRINCIPAL DETAILS</th></tr><tr><td bgcolor='' colspan='1'>NAME</td><td bgcolor=''>PHONE NO.</td><td bgcolor=''colspan='1'>E-MAIL</td></tr><tr>";

s2=s2+"<td colspan='1' bgcolor=''>"+s[i]+"</td>";

if(i==5)
s2=s2+"</tr>";
}	
s2=s2+"<tr><th colspan='4' bgcolor='' height='50'><div align='center'><a href='Collcourse.jsp?name1="+n+"'>COURSE DETAILS</a></div><th></tr></table>";
out.println(s2);
}
}

}catch(Exception e){System.out.println("gggg"+e);e.printStackTrace();}
return "return";

		}


	}	



