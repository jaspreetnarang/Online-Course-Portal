package vik;
import java.sql.*;
import cont.Connec;
public class Principle3
{

Connection c=Connec.getConnection();
String name1="name1";
String name="name";
String id="id";

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

public void setId(String id)
{
this.id=id;
//System.out.println(id);
		}



public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String admission()
{
try{
Statement st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
int data=0;
int i=0;
int  j=0;
int k=1;
String s1="";
int id1=Integer.parseInt(id);
ResultSet rs=st.executeQuery("SELECT * FROM applications where applications.id="+id1);
     while(rs.next())
  {
      i++;
      int a=i%5;
    
     if(a==1)
  {
      j++;
    s1=s1+"&nbsp;&nbsp;<a href=Principle3.jsp?name="+j+">"+j+"</a>";
    }

  }
data=i;

//System.out.println("name= "+name+" name1= "+name1);

ResultSet rs1=st.executeQuery("SELECT * FROM applications where applications.id="+id1);

if(!name.equals("name"))
{
 k=Integer.parseInt(name);
}

if(rs1.next()==true)
{
String s="<table><tr><th  bgcolor=''>REJECT</th><th  bgcolor=''>STUDENT</th><th bgcolor=''>FATHER'S NAME</th><th bgcolor=''>DOB</th><th bgcolor=''>SEX</th><th bgcolor=''>ADDRESS</th><th bgcolor=''>CITY</th><th bgcolor=''>STATE</th><th bgcolor=''>POSTAL CODE</th><th bgcolor=''>CONTECT</th><th bgcolor=''>% IN 10TH</th><th bgcolor=''>%IN 12TH</th><th bgcolor=''>APPLIED FOR</th></tr>";
 for(int i1=k*5-4;i1<=(k*5-4)+4;i1++)
   {

   if(i1>data)
   break;

    rs1.absolute(i1); 
    int id=rs1.getInt(15);
    
for(i=2;i<=13;i++)
{
if(i==2)
s=s+"<tr><td bgcolor=''><a href=Principle3.jsp?name1="+id+">Reject Form</a></td>";

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
out.println("NO FORM IS SUBMITED FOR YOUR COLLEGE");
}

if(!name1.equals("name1")||!name1.equals("Form"))
{
int id=Integer.parseInt(name1);
PreparedStatement ps=c.prepareStatement("delete * from applications where stid=?");
ps.setInt(1,id);
int a=ps.executeUpdate();
if(a==1)
out.println("FORM REJECTED");
}

}catch(Exception e){System.out.println("NEW"+e);}
return "vv";

}
}
