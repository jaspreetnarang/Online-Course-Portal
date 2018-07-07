package vik;
import java.sql.*;
import cont.Connec;
public class Principle1
{

Connection c=Connec.getConnection();
String name1="dd";
String name="d1";
static String course="course";
static String courseold="courseold";
static String type="t";
static String elig="e";
static String duera="d";
static String desc="ds";

String id="id";
javax.servlet.jsp.JspWriter out;

public void setCourse(String course)
{
if(!course.equals(null))
this.course=course;

		}

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


public void setId(String id)
{
if(!id.equals(null))
this.id=id;
		}

public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String result()
{
try{
String courses="";
if(name1.equals("modify")||name.equals("Home"))
{
int id1=Integer.parseInt(id);
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT *FROM Collcourse where Collcourse.id="+id1);
while(rs1.next())
{
//System.out.println("iiiiiiiiiiiiiii"+id1);
String s=rs1.getString(2);
courses=courses+"<option value="+s+">"+s+"</option>";

}
out.println("<table width='341' height='119'  bordercolor='' border='1' bgcolor=''><form name='form1' method='post' action='Principle1.jsp'><tr><td><div align='center' class='style1'>Course Modification </div></td></tr><tr><td><div align='center' class='style2'> Courses in college<select name='course'>"+courses+"</select></div></td></tr><tr><td><div align='center'><input type='submit' name='name' value='Modify'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='Delete'></div></td></tr></form></table>");
}

//System.out.println("name= "+name+" course= "+course);

if(name.equals("Modify"))
{

int id1=Integer.parseInt(id);
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT * FROM Collcourse where Collcourse.course='"+course+"'"+ "and Collcourse.id="+id1);

while(rs1.next())
{
//System.out.println("iiiiiiiiiiiiiii"+id1);
courseold=rs1.getString(2);
type=rs1.getString(3);
elig=rs1.getString(4);
duera=rs1.getString(5);
desc=rs1.getString(6);
}
out.println("<table bgcolor=''  bordercolor='' border='1'><td><form name='form1' method='' action='Principle1.jsp'><p><div align='right'>COURSE:&nbsp;&nbsp;&nbsp; <input type='text' name='course' value='"+courseold+"'></div></p><p><div align='left'>&nbsp;&nbsp;&nbsp;&nbsp;Degree/Deploma: <select name='type'><option value="+type+" selected>"+type+"</option><option>DEPLOMA</option><option>DEGREE</option></select></div></p><p><div align='left'>Eligible for Students:<select name='elig'><option value="+elig+" selected>"+elig+"</option><option>10 TH PASS</option><option>12 TH PASS</option><option>GRADUATE</option></select></div></p><p><div align='left'>Dueration of Course:<select name='duera'><option value="+duera+" selected>"+duera+"</option><option>1 YEAR</option><option>2 YEAR</option><option>3 YEAR</option><option>4 YEAR</option><option>5 YEAR</option></select></div></p><p><div align='right'>Course Description: <input type='text' name='desc' value="+desc+"></div></p><p><div align='center'><input type='submit' name='name' value= 'MODIFY'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value= 'Home'</div></form></td></table>");
}
if(name.equals("MODIFY"))
{
//System.out.println("########"+courseold+" "+type+" "+elig+" "+duera+" "+desc);
PreparedStatement ps=c.prepareStatement("update Collcourse set course=?,type=?,eligible=?,duration=?,description=? where id=? and course=?");
ps.setString(1,course);
ps.setString(2,type);
ps.setString(3,elig);
ps.setString(4,duera);
ps.setString(5,desc);
ps.setString(6,id);
ps.setString(7,courseold);
int a=ps.executeUpdate();
if(a==1)
out.println("<table bgcolor=''  bordercolor='' border='1'><td> COURSE MODIFY=> "+course+" "+type+" "+elig+" "+duera+" "+desc+"</td></table>");
}
if(name.equals("Delete"))
{
PreparedStatement ps=c.prepareStatement("delete *from Collcourse where id=? and course=?");
ps.setString(1,id);
ps.setString(2,course);
int a=ps.executeUpdate();
if(a==1)
out.println("<table bgcolor=''  bordercolor='' border='1'><td>COURSE DELETED</td></table>");

}
}catch(Exception e){System.out.println("NEW"+e);}
return "vv";

}
}
/*<table width='241' height='119' border='1' bordercolor='#000000' bgcolor='#FF0000'><form name='form1' method='post' action='Principle1.jsp'><tr><td><div align='center' class='style1'>Course Modification </div></td></tr><tr><td><div align='center' class='style2'> Courses in college<select name='course'><option value='0' selected></option>+courses+</select></div></td></tr><tr><td><div align='center'><input type='submit' name='Modify' value='Modify'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='Delete' value='Delete'></div></td></tr></form></table>*/
