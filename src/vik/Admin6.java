package vik;
import java.sql.*;
import cont.Connec;

public class Admin6
{

Connection c=Connec.getConnection();
String name="name";
String name1="name1";

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

try{
Statement st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
int data=0;
int i=0;
int  j=0;
int k=1;
String s1="";
ResultSet rs=st.executeQuery("SELECT stid  FROM applications where college='UNIVERSITY'");

     while(rs.next())
  {
///System.out.println(rs.getString(1));
      i++;
      int a=i%5;
    
     if(a==1)
  {
      j++;
    s1=s1+"&nbsp;&nbsp;<a href=Admin6.jsp?name="+j+">"+j+"</a>";
    }

  }
data=i;

//System.out.println("name= "+name+" name1= "+name1);
ResultSet rs1=st.executeQuery("SELECT * FROM applications where college='UNIVERSITY'");
String s="<table><tr><th  bgcolor=''>REJECT</th><th  bgcolor=''>STUDENT</th><th bgcolor=''>FATHER'S NAME</th><th bgcolor=''>DOB</th><th bgcolor=''>SEX</th><th bgcolor=''>ADDRESS</th><th bgcolor=''>CITY</th><th bgcolor=''>STATE</th><th bgcolor=''>POSTAL CODE</th><th bgcolor=''>CONTECT</th><th bgcolor=''>% IN 10TH</th><th bgcolor=''>%IN 12TH</th><th bgcolor=''>APPLIED FOR</th></tr>";
if(!name.equals("name"))
{
 k=Integer.parseInt(name);
}
//System.out.println("@@@= "+data);

if(rs1.next()==true)
{

 for(int i1=k*5-4;i1<=(k*5-4)+4;i1++)
   {

   if(i1>data)
   break;

    rs1.absolute(i1); 
    int id=rs1.getInt(15);
    
     ///s=s+"<tr><td bgcolor=''><a href=Faculties.jsp?name1="+id+">"+rs1.getString(2)+"</a><td></tr>";
for(i=2;i<=13;i++)
{
if(i==2)
s=s+"<tr><td bgcolor=''><a href=Admin6.jsp?name1="+id+">Reject Form</a></td>";

String s2=rs1.getString(i);

s=s+"<td bgcolor=''>"+s2+"</td>";

if(i==14)
s=s+"</tr>";

}
   

	}

s=s+"</table>";    
out.println(s);
out.println(s1);
}
if(i==0)
{
out.println("NO FORM IS SUBMITED FOR UNIVERSITY");
}


if(!name1.equals("name1"))
{
int id=Integer.parseInt(name1);
PreparedStatement ps=c.prepareStatement("delete * from applications where stid=?");
ps.setInt(1,id);
int a=ps.executeUpdate();
if(a==1)
out.println("FORM REJECTED");
}
}catch(Exception e){
System.out.println(e);e.printStackTrace();}

return "vv";
}


    
}
