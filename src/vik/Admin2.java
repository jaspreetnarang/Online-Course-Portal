package vik;
import java.sql.*;
import cont.Connec;

public class Admin2
{

Connection c=Connec.getConnection();
String name="name";
String name1="name1";
String course="course";
static String courseold="courseold";
static String type="t";
static String elig="e";
static String duera="d";
static String desc="ds";


javax.servlet.jsp.JspWriter out;

public void setType(String type)
{
if(!type.equals(null))
this.type=type;
//System.out.println(type);
		}

public void setElig(String elig)
{
if(!elig.equals(null))
this.elig=elig;
//System.out.println(elig);
		}

public void setDuera(String duera)
{
if(!duera.equals(null))
this.duera=duera;
//System.out.println(duera);

		}
public void setDesc(String desc)
{
if(!desc.equals(null))
this.desc=desc;
//System.out.println(desc);
		}

public void setCourse(String course)
{
if(!course.equals(null))
this.course=course;

		}


public void setName1(String name1)
{
if(!name1.equals(null))
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
//System.out.println("name= "+name+" course= "+course);
String courses="";

////****///INITIAL
if(name.equals("name")||name.equals("Home"))
{
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT Courses.Course FROM Courses");
while(rs1.next())
{
String s=rs1.getString(1);
courses=courses+"<option value="+s+">"+s+"</option>";
}
out.println("<table width='341' height='119'  bordercolor='' border='1' bgcolor=''><form name='form1' method='' action='Admin2.jsp'><tr><td><div align='center' class='style1'>Course Modification </div></td></tr><tr><td><div align='center' class='style2'> Courses in college: <select name='course'>"+courses+"</select></div></td></tr><tr><td><div align='center'><input type='submit' name='name' value='MODIFY'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='DELETE'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='NEW'></div></td></tr></form></table>");
}


////*****/////MODIFY

if(name.equals("MODIFY"))
{
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT *from Courses where Course='"+course+"'");
while(rs1.next())
{
courseold=rs1.getString(1);
type=rs1.getString(2);
elig=rs1.getString(3);
duera=rs1.getString(4);
desc=rs1.getString(5);
}
out.println("<table bgcolor=''  bordercolor='' border='1'><td><form name='form1' method='' action='Admin2.jsp'><p><div align='right'>COURSE:&nbsp;&nbsp;&nbsp; <input type='text' name='course' value='"+courseold+"'></div></p><p><div align='left'>&nbsp;&nbsp;&nbsp;&nbsp;Degree/Deploma: <select name='type'><option value="+type+" selected>"+type+"</option><option>DEPLOMA</option><option>DEGREE</option></select></div></p><p><div align='left'>Eligible for Students:<select name='elig'><option value="+elig+" selected>"+elig+"</option><option>10 TH PASS</option><option>12 TH PASS</option><option>GRADUATE</option></select></div></p><p><div align='left'>Dueration of Course:<select name='duera'><option value="+duera+" selected>"+duera+"</option><option>1 YEAR</option><option>2 YEAR</option><option>3 YEAR</option><option>4 YEAR</option><option>5 YEAR</option></select></div></p><p><div align='right'>Course Description: <input type='text' name='desc' value="+desc+"></div></p><p><div align='center'><input  type='submit' name='name' value= 'CONFORM' onclick='return validationTxt()'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type='submit' name='name' value= 'Home' ></div></form></td></table>");
}
//**//CONFORM

if(name.equals("CONFORM"))
{
//System.out.println("########"+courseold+" "+type+" "+elig+" "+duera+" "+desc+"   "+id);
PreparedStatement ps=c.prepareStatement("update Courses set Course=?,Type=?,Eligible=?,Deuration=?,Description=?  where Course=?");
ps.setString(1,course);
ps.setString(2,type);
ps.setString(3,elig);
ps.setString(4,duera);
ps.setString(5,desc);
ps.setString(6,courseold);
int a=ps.executeUpdate();
if(a==1)
out.println("<table bgcolor=''  bordercolor='' border='1'><td> COURSE MODIFY=> "+course+" "+type+" "+elig+" "+duera+" "+desc+"</td></table>");
}

//***COURSE DELETE****////
if(name.equals("DELETE"))
{
PreparedStatement ps=c.prepareStatement("delete *from Courses where course=?");
ps.setString(1,course);
int a=ps.executeUpdate();
//if(a==1)
out.println("<table bgcolor=''  bordercolor='' border='1'><td>COURSE DELETED</td></table>");
}

///*******NEW COURSE ADD*****//
if(name.equals("NEW"))
{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT Courses.Course from Courses");

String td="<TABLE bordercolor='' border='1'><form name=form1 action='Admin2.jsp' method='post'><tr><td BGCOLOR=''><p><div align='center'>Courses available :<select name='select'>";
while(rs.next())
{
td=td+"<option>"+rs.getString(1)+"</option>";
    }              
 td=td+"</select></div></p><p><div align='center'>&nbsp;&nbsp;&nbsp;New Course Lounch: <input type='text' name='course'></div></p><p><div align='center'>Degree/Deploma:&nbsp;&nbsp;&nbsp;&nbsp; <select name='type'><option>DEPLOMA</option><option>DEGREE</option></select></div></p><p><div align='center'>Eligible for Students:&nbsp;&nbsp;&nbsp;<select name='elig'><option>10 TH PASS</option><option>12 TH PASS</option><option>GRADUATE</option></select></div></p><p><div align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dueration of Course:&nbsp;&nbsp;<select name='duera'><option>1 YEAR</option><option>2 YEAR</option><option>3 YEAR</option><option>4 YEAR</option><option>5 YEAR</option></select></div></p><p><div align='center'>&nbsp;&nbsp;&nbsp;Course Description: <input type='text' name='desc'></div></p><p><div align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type='submit' name='name' value= 'ADD' onclick='return validationTxt()' >&nbsp;&nbsp;&nbsp;<INPUT  type=reset value=Reset >&nbsp;&nbsp;&nbsp;<input  type='submit' name='name' value= 'Home' ></p></div></td></tr></form></TABLE>";
out.println(td);

}

if(name.equals("ADD"))
{
//System.out.println("course= "+course+" type= "+type+" dueration= "+duera+" elig= "+elig+" descp= "+desc);
PreparedStatement ps=c.prepareStatement("INSERT into Courses Values(?,?,?,?,?)");
ps.setString(1,course);
ps.setString(2,type);
ps.setString(3,elig);
ps.setString(4,duera);
ps.setString(5,desc);
int ii=ps.executeUpdate();
if(ii==1)
out.println("<table BGCOLOR=''  bordercolor='' border='2'><td>NEW COURSE IS ADDED IN UNIVERSITY COURSES</td></table>");
}


}catch(Exception e){
System.out.println(e);}

return "vv";
}


    
}
