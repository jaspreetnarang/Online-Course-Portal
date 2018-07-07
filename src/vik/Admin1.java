package vik;
import java.sql.*;
import cont.Connec;

public class Admin1
{

Connection c=Connec.getConnection();
String name="name";
String name1="name1";
int data=0;

javax.servlet.jsp.JspWriter out;


public void setName(String name)
{
if(!name.equals(null))
this.name=name;

		}

public void setName1(String name1)
{
if(!name1.equals(null))
this.name1=name1;

		}


public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String details()
{
int i=0;
int  j=0;
int k=1;
String s1="";  

try{
Statement st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
ResultSet rs=st.executeQuery("SELECT distinct Validroll.Stream FROM Validroll");

///out.println("s0="+s1+"#");
while(rs.next())
  {
String n=rs.getString(1);
if(!n.equals(null))
{
i++;
}
}
}catch(Exception e){

try{

for(int ij=1;ij<i;ij++)  
{
if(ij%5==1)
{
j++;
s1=s1+"&nbsp;&nbsp;<a href=Admin1.jsp?name="+j+">"+j+"</a>";
}
}

Statement st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
ResultSet rs1=st.executeQuery("SELECT distinct Validroll.Stream FROM Validroll");
String s="<table><tr><th colspan='2' bgcolor=''>TO SEE THE RESULT DETAILS HIT LINK</th></tr></tr>";
if(!name.equals("name"))
{
 k=Integer.parseInt(name);
}
try{

 for(int i1=k*5-4;i1<=(k*5-4)+4;i1++)
{
rs1.absolute(i1); 
String ss=rs1.getString(1);
s=s+"<tr><td bgcolor=''><a href=Admin11.jsp?name1="+ss+">"+ss+"</a></td></tr>";
   	}

}catch(Exception e1){}

s=s+"</table>";    
out.println(s);
out.println(s1);


if(i==0)
{
out.println("NO RESULT IS UPLOADED IN UNIVERSITY");
}



}catch(Exception e1){
/*System.out.println(e1);*/}
}
return "vv";
}


    
}
/*Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT distinct Validroll.Stream FROM Validroll");

String td="<table><tr><th colspan='2' bgcolor=''>TO SEE THE RESULT DETAILS HIT LINK</th></tr></tr>";
while(rs.next())
{
String s1=rs.getString(1);

td=td+"<tr><td bgcolor=''><a href=Admin11.jsp?name1="+s1+">"+s1+"</a></td></tr>";

    }              
 td=td+"</table>";
out.println(td);*/
