package vik;
import java.sql.*;
import cont.Connec;
public class Validroll
{

Connection c=Connec.getConnection();
String txtRoll="txtRoll";
String txtCourseName="txtCourseName";
String txtYear="txtYear";
String txtSession="txtSession";

javax.servlet.jsp.JspWriter out;
int i=0;


public void setTxtRoll(String txtRoll)
{
this.txtRoll=txtRoll;
		}

public void setTxtCourseName(String txtCourseName)
{
this.txtCourseName=txtCourseName;
		}

public void setTxtSession(String txtSession)
{
this.txtSession=txtSession;
		}

public void setTxtYear(String txtYear)
{
this.txtYear=txtYear;
		}

public String  getName()
{
return txtRoll;
		}


public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}


public String details()
{
String sub="";
try{

//System.out.println("txtRoll= "+txtRoll+" txtCourseName= "+txtCourseName+" txtYear= "+txtYear+" txtSession= "+txtSession);
Statement st=c.createStatement();


ResultSet rs=st.executeQuery("SELECT * from Validroll where Validroll.Roll='"+txtRoll+"' and Validroll.Year='"+txtYear+"' and Validroll.Stream='"+txtCourseName+"' and Validroll.Session='"+txtSession+"'");

    int i1=0;
     while(rs.next())
   {
    i1=1;
     out.println("<table width='70%'  border='2' cellspacing='5' cellpadding='0'><tr><th width='12%' scope='col'><div align='CENTER'>Roll No.</div></th><th width='12%' scope='col'><div align='CENTER'>Name</div></th><th width='12%'scope='col'><div align='CENTER'>Result</div></th><th width='12%' scope='col'><div align='CENTER'>Year</div></th><th width='12%' scope='col'><div align='CENTER'>Division</div></th><th width='12%' scope='col'><div align='CENTER'>Course</div></th><th width='12%' scope='col'><div align='CENTER'>Session</div></th></tr>");
     out.println("<tr><td>"+rs.getString(1)+"</td>");
     for(int a=2;a<8;a++)    
     out.println("<td>"+rs.getString(a)+"</td>");
     out.println("</table>");
    
     }    
if(i1==0)
{
out.println("ROLL NUMBER IS NOT EXIST= "+txtRoll+"   NO DATA FOUND");
	}

}catch(Exception e){System.out.println(e);}
return "return";

		}


	}	


