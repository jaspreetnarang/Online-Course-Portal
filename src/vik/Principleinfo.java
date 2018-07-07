package vik;
import java.sql.*;
import cont.Connec;
public class Principleinfo
{

Connection c=Connec.getConnection();
static String name,pass;
String name1="dd";
String value="";
String PNAME="";
String sid="0";

public String collegeid()
{
return sid;
}

javax.servlet.jsp.JspWriter out;
int i=0;

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

public void setPass(String pass)
{
if(!pass.equals(null))
this.pass=pass;
		}

public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String valid()
{
try{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select *from Login");
int i1=0;

while(rs.next())
{
String s1=rs.getString(2);
String s2=rs.getString(3);

if(name.equals(s1)&&pass.equals(s2))
{
i=1;
PNAME=s1;
sid=rs.getString(1);
//System.out.println(sid);
}


}

if(i==1)
{
int id =Integer.parseInt(sid);
String tb="<table width='100%' background='images/index_07-081.jpg' height='100'  border='1'><tr><td background='images/index_07-081.jpg' width='20%' height=150' rowspan='2' bgcolor='' ><table background='images/index_07-081.jpg' width='100%' height='250' border='0' cellspacing='0'><tr><td width='20%' height='25%' bgcolor=''><div align='center' class='style1 style2'><strong>PRINCIPAL AUTHORITY</strong></div></td></tr><tr><td height='35%' bgcolor=''><div align='center'><a href='Principle1.jsp?name1=modify'><strong>MODIFY COURSE</strong></a></div></td></tr><tr><td height='35%' bgcolor=''><div align='center'><a href='Principle2.jsp?name1=ADD''><strong>ADD NEW COURSE </strong></a></div></td></tr><tr><td height='35%' bgcolor=''><div align='center'><a href='Principle3.jsp?name1=From'><strong>ADMISSION FORMS FOR COLLEGE</strong></a></div></td></tr></table></td><td width='70%' bgcolor=''><div align='CENTER' class='style1'><a href='Principle5.jsp?name1=Change''><strong>CHANGE PASSWORD</strong></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='Logout.jsp'><strong>LOG OUT</strong></a></div></td></tr><tr><td height='144' background='images/index_07-081.jpg' bgcolor='#000000'><div align='center'>"+value+"</div></td></tr></table>";

out.println(tb);

}

if(i==0)
out.println("<TABLE cellspacing='1' bgcolor='' border='2' bordercolor=''><TR><TH >INVALID NAME OR PASSWORD</TH></TR><TR><TH><A HREF='Login1.jsp'>TRY AGAIN</A></TH></TR></TABLE>");

if(name1.equals("Result"))
value="<table><tr><td bgcolor='#000000'>Result view</td></tr></table>";

if(name1.equals("ADD"))
value="<table><tr><td bgcolor='#000000'>ADD</td></tr></table>";

if(name1.equals("Form"))
value="<table><tr><td bgcolor='#000000'>Form</td></tr></table>";

if(name1.equals("Info"))
value="<table><tr><td bgcolor='#000000'>Info</td></tr></table>";




}catch(Exception e){System.out.println("NEW"+e);}
return "vv";

}
}




/*Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT applications.id AS applications_id,applications.student,applications.father,applications.dob,applications.sex, applications.address, applications.city, applications.state, applications.pin,applications.contect,applications.tenth,applications.twelth,applications.course,Login.id AS Login_id FROM Login INNER JOIN applications ON Login.id=applications.id WHERE applications.id="+id);

int ii=0;
String tb="<table border=3 cellSpacing=2 ><TH>STUDENT NAME</TH><TH>FATHER NAME</TH><TH>DATE OF BIRTH</TH><TH>SEX</TH><TH>ADDRESS</TH><TH>CITY</TH><TH>STATE</TH><TH>POSTAL CODE</TH><TH>CONTECT NUMBER</TH><TH>% IN TENTH</TH><TH>% IN TWELTH</TH><TH>COURSE APPLIED FOR</TH>";

while(rs1.next())
{
for(int i=2;i<=13;i++)
{
if(i==2)
tb=tb+"<tr>";

tb=tb+"<td>"+rs1.getString(i)+"</td>";

if(i==13)
tb=tb+"</tr>";
}
ii=1;
}
out.println(tb+"</table>");

if(ii==0)
out.println("<table><tr><td>NO FORM SUBMITED FOR YOUR COLLEGE</td></tr></table>");
*/