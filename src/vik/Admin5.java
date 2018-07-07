package vik;
import java.sql.*;
import java.util.*;
import cont.Connec;

public class Admin5

{

Connection c=Connec.getConnection();

static String course="course";
static String session="session";
static String year="year";
String name="name";
String roll="roll";
String student="student";
String result="result";
String division="division";

static int i1=0;
javax.servlet.jsp.JspWriter out;

public void setName(String name)
{
if(!name.equals(null))
this.name=name;

		}

public void setCourse(String course)
{
if(!course.equals(null))
this.course=course;

		}

public void setSession(String session)
{
if(!session.equals(null))
this.session=session;

		}

public void setYear(String year)
{
if(!year.equals(null))
this.year=year;

		}

public void setRoll(String roll)
{
if(!roll.equals(null))
this.roll=roll;

		}

public void setStudent(String student)
{
if(!student.equals(null))
this.student=student;

		}

public void setResult(String result)
{
if(!result.equals(null))
this.result=result;

		}


public void setDivision(String division)
{
if(!division.equals(null))
this.division=division;

		}




public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}


public String details()
{

try{


String td="<table cellspacing='2'  bgcolor='' border='1' bordercolor=''><tr><th><div align='right'>RESULT UPLOADING FOR   "+course+ "    Session   "+session +"  Year   "+year+"</div></th></tr><p><div align='center'>RESULT UPLOADING......</div></p></table>";
if(!name.equals("name"))
out.println(td);

}catch(Exception e){
System.out.println(e);}


return "vv";
}

public String student()
{
try{
int a=0;

if(name.equals("name"))
{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT *FROM Courses");

String td="<TABLE cellspacing='2'  bgcolor='' border='1' bordercolor=''><form name=form1 action='Admin5.jsp?name=NEXT' method='post'><tr><td><div align='center'>Courses available in University :<select name='course'>";
while(rs.next())
{

td=td+"<option>"+rs.getString(1)+"</option>";
    }              
 td=td+"</select></div></tr><tr><td><div align='center'>Session: <select name='session'><option>2014</option><option>2015</option><option>2016</option><option>2017</option></select>Year: <select name='year'><option>I</option><option>II</option><option>III</option><option>IV</option><option>V</option></select></div></td></tr><tr><td><div align='center'><input style='FONT-WEIGHT: bold' type='submit' value= 'NEXT'  ></div></td></tr></form></TABLE>";
out.println(td);
}


if(name.equals("NEXT")||name.equals("UPLOAD"))
{
out.println("<TABLE width='450' cellspacing='2'  bgcolor='' border='1' bordercolor='' ><TH BGCOLOR=''>PREVIOUS "+roll+" "+student+" "+result+" "+division+" </TH></TABLE>");

String td="<TABLE width='450' cellspacing='2'  bgcolor='' border='1' bordercolor='' ><form name=form1 action='Admin5.jsp?name=UPLOAD' method='post'><tr><td><p><div align='center'>NEW RESULT UPLOAD</div></p>";
td=td+"</td></tr><tr><td><div align='center'>&nbsp;&nbsp;&nbsp;ROLL NUMBER:<input type='text' name='roll'></div></td></tr><tr><td><div align='center'>&nbsp;&nbsp;&nbsp;STUDENT NAME:<input type='text' name='student'></div></td></tr><tr><td><div align='center'>&nbsp;&nbsp;&nbsp;STUDENT RESULT:<select name='result'><option>PASS</option><option>FAIL</option></select></div></td></tr><tr><td><div align='center'>&nbsp;&nbsp;&nbsp;STUDENT DIVISION:<select name='division'><option>I</option><option>II</option><option>III</option></select></div></td></tr><tr><td><div align='center'>&nbsp;&nbsp;&nbsp;&nbsp;<input style='FONT-WEIGHT: bold' type='submit' value= 'UPLOAD' onclick='return validationTxt()'>&nbsp;&nbsp;&nbsp;<INPUT style='FONT-WEIGHT: bold' type=reset value=Reset></td></tr></div></td></tr></form></TABLE>";
out.println(td);
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select Roll from Validroll");
while(rs.next())
{

if(roll.equals(rs.getString(1)))
{
a=1;
}

}
if(a==1)
{
out.println("ROLL NUMBER ALLREADY EXIST TRY ANOTHER ROLL NUMBER");
}


if(!roll.equals("roll"))
{
if(a==0)
{
String s[]={roll,student,result,year,division,course,session};
PreparedStatement ps=c.prepareStatement("insert into Validroll Values(?,?,?,?,?,?,?)");
for(int j=1;j<8;j++)
{
ps.setString(j,s[j-1]);
}
int aa=ps.executeUpdate();
if(aa==1)
out.println("UPLOADED SUCCESSFULL");


}

}
}

}catch(Exception e){System.out.println(e);e.printStackTrace();}
return "aa";
	}
    
}
//static ArrayList list=new ArrayList();

/*Object a[]=list.toArray();
String s[]=new String[a.length];
int b=0;
for(int i=0;i<a.length;i++)
{
s[i]=(String)a[i];
int a1=(i+1)%5;

if(a1==1)
{
b=b+1;
//System.out.println("list="+b+course);
}
}
list.clear();
PreparedStatement ps=c.prepareStatement("insert into Validroll Values(?,?,?,?,?,?,?)");

for(int i=0;i<b;i++)
{
int ii=0;
int aa[]=new int[b];
for(int j=i*5;j<i*5+5;j++)
{
ii++;
ps.setString(ii,s[j]);
if(ii==5)
{
ps.setString(6,course);
ps.setString(7,session);
aa[i]=ps.executeUpdate();
if(aa[b-1]==1)
out.println("<table border='1'><th bgcolor='' border='1'>UPLOADED SUCCESSFULL</th></table>");
//System.out.println(aa+course);
}
//System.out.println(i+" "+ii+"  "+j+" "+s[j]);
}
if(!roll.equals("roll"))
{
list.add(roll);
list.add(student);
list.add(result);
list.add(year);
list.add(division);
//list.add(college);
}*/
