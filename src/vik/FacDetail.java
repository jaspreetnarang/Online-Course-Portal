package vik;
import java.sql.*;
import cont.Connec;
public class FacDetail
{

Connection c=Connec.getConnection();
static String name="name";
static String name1="name1";
String name2="name2";


javax.servlet.jsp.JspWriter out;
int i=0;

public void setName(String name)
{
if(!name.equals(null))
this.name=name;
		}

public void  setName1(String name1)
{
if(!name1.equals(null))
this.name1=name1;

		}

public void  setName2(String name2)
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

Statement st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
int data=0;
int i=0;
int  j=0;
int k=1;
String s1="";
ResultSet rs=st.executeQuery("select* from Departments");
     while(rs.next())
  {
//System.out.println(rs.getString(2));
      i++;
      int a=i%5;
      if(a==1)
  {
    j++;
    s1=s1+"&nbsp;&nbsp;<a href=Faculties.jsp?name="+j+">"+j+"</a>";
    }

  }
data=i;


ResultSet rs1=st.executeQuery("select* from Departments");
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
    s=s+"<tr><td bgcolor=''><a href=Faculties.jsp?name1="+id+">"+rs1.getString(2)+"</a><td></tr>";
   	}

s=s+"</table>";    
out.println(s);
out.println(s1);


}catch(Exception e){}
return "return";
}

public String details()
{

int data=0;
int i=0;
int  j=0;
int k=1;
int id=0;
String s1="";

try{
if(!name1.equals("name1"))
{
//out.println(name1);
Statement st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
String dep="";
if(!name1.equals("name1"))
id=Integer.parseInt(name1);

ResultSet rs=st.executeQuery("SELECT Departments.id, Departments.depname, Depdetail.fname, Depdetail.fadd, Depdetail.fph, Depdetail.fmail, Depdetail.fsex FROM Departments INNER JOIN Depdetail ON Departments.id = Depdetail.id where Departments.id = "+id);
String s="<table align='center' width='70%'  border='0' cellspacing='0' cellpadding='0'><tr><th height='30' bgcolor= '' width='20%' scope='col'><div align='center'>DEPARTMENT</div></th><th bgcolor= '' width='20%' scope='col'><div align='center'>FACULTY</div></th><th bgcolor= '' width='20%'scope='col'><div align='center'>ADDRESS</div></th><th bgcolor= '' width='20%' scope='col'><div align='center'>CONTACT NO.</div></th><th bgcolor= '' width='20%' scope='col'><div align='center'>MAIL ID</div></th><th bgcolor= '' scope='col'><div align='center'>SEX</div></th></tr>";
     while(rs.next())
  {
dep=rs.getString(2);
      i++;
      int a=i%5;

      if(a==1)
  {
    j++;
    s1=s1+"&nbsp;&nbsp;<a href=Faculties.jsp?name2="+j+">"+j+"</a>";


    }

  }
data=i;
if(!name2.equals("name2"))
{
 k=Integer.parseInt(name2);
}


ResultSet rs1=st.executeQuery("SELECT * from Depdetail where Depdetail.id = "+id);
int ai=0;
 for(int i1=k*5-4;i1<=(k*5-4)+4;i1++)
   {
    if(i1>data)
   break;
   
rs1.absolute(i1); 
ai=1;
 
for(int ii=2;ii<7;ii++)
{
if(ii==2)
s=s+"<tr><td><div align='center'>"+dep+"</div></td>";

s=s+"<td  bgcolor=''><div align='center'>"+rs1.getString(ii)+"</div></td>";

if(ii==6)
s=s+"</tr>";
}

   	}


s=s+"</table><br><br>";    
if(ai==1)
{
out.println(s);
out.println("<div align='center'><table><tr><td colspan='1'><div align='center'>"+s1+"</div></td></tr></table>");
}
if(ai==0)
{
out.println("<div align='center'>STILL NO FACULTY IS AVAILABLE</div>");
}
}
}catch(Exception e){}
return "return";


		}


	}	


