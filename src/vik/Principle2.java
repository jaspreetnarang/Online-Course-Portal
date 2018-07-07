package vik;
import java.sql.*;
import cont.Connec;
public class Principle2
{

Connection c=Connec.getConnection();
String name1="dd";
String id="id";
String course="c";
String type="t";
String elig="e";
String duera="d";
String desc="ds";
static int i1=0;
javax.servlet.jsp.JspWriter out;


public void setId(String id)
{
this.id=id;
//System.out.println(id);
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

public void setCourse(String course)
{
if(!course.equals(null))
this.course=course;

		}

public void setType(String type)
{
if(!type.equals(null))
this.type=type;

		}
public void setDuera(String duera)
{
if(!duera.equals(null))
this.duera=duera;

		}
public void setDesc(String desc)
{
if(!desc.equals(null))
this.desc=desc;

		}


public void setElig(String elig)
{
if(!elig.equals(null))
this.elig=elig;
		}

public String course()
{
try{
i1=0;
if(name1.equals("ADD"))
{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT Collcourse.id,Collcourse.course FROM Collcourse where Collcourse.id="+id);

String td="<TABLE bordercolor='' border='1'><form name=form1 action='Principle2.jsp?name1=Add' method='post'><tr><td BGCOLOR=''><p><div align='center'>Courses available :<select name='select'>";
while(rs.next())
{
i1++;
td=td+"<option>"+rs.getString(2)+"</option>";
    }              
 td=td+"</select></div></p><p><div align='center'>&nbsp;&nbsp;&nbsp;New Course Launch: <input type='text' name='course'></div></p><p><div align='center'>Degree/Diploma:&nbsp;&nbsp;&nbsp;&nbsp; <select name='type'><option>DIPLOMA</option><option>DEGREE</option></select></div></p><p><div align='center'>Eligible for Students:&nbsp;&nbsp;&nbsp;<select name='elig'><option>10 TH PASS</option><option>12 TH PASS</option><option>GRADUATE</option></select></div></p><p><div align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Duration of Course:&nbsp;&nbsp;<select name='duera'><option>1 YEAR</option><option>2 YEAR</option><option>3 YEAR</option><option>4 YEAR</option><option>5 YEAR</option></select></div></p><p><div align='center'>&nbsp;&nbsp;&nbsp;Course Description: <input type='text' name='desc'></div></p><p><div align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style='FONT-WEIGHT: bold' type='submit' value= 'ADD' >&nbsp;&nbsp;&nbsp;<INPUT style='FONT-WEIGHT: bold' type=reset value=Reset ></p></div></td></tr></form></TABLE>";
out.println(td);
}
int a=0;

if(name1.equals("Add"))
{
if(!course.equals("c"))
{
a=1;

//System.out.println("course= "+course+" type= "+type+" dueration= "+duera+" elig= "+elig+" descp= "+desc);

PreparedStatement ps1=c.prepareStatement("INSERT into Collcourse Values(?,?,?,?,?,?)");
int id1=Integer.parseInt(id);
//System.out.println("ID"+i1);
ps1.setInt(1,id1);
ps1.setString(2,course);
ps1.setString(3,type);
ps1.setString(4,elig);
ps1.setString(5,duera);
ps1.setString(6,desc);
int ii=ps1.executeUpdate();
if(ii==1)
out.println("<table BGCOLOR=''  bordercolor='' border='1'><td>NEW COURSE IS ADDED IN COLLEGE COURSES</td></table>");
}

if(a==0)
out.println("<table BGCOLOR=''  bordercolor='' border='1'><td>PROBABLY SOME MISTAKE IS THERE . PLEASE TRY AGAIN</td></table>");

}}catch(Exception e){System.out.println("NEW"+e);}
return "vv";

}
}
