package vik;
import java.sql.*;
import cont.Connec;
public class Forms
{

Connection c=Connec.getConnection();
String name="name";
String name1="name1";
String coln="UNIVERSITY";
javax.servlet.jsp.JspWriter out;
int i=0;

public void setName(String name)
{
if(!name.equals(null))
this.name=name;
		}

public void setSelect(String select)
{
if(!select.equals(null))
this.name1=select;
		}


public String  getName()
{
return name1;
		}


public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String id()
{
return name1;
}

public String coll()
{

try{


if(name.equals("uni"))
{
name1="0";
out.println("<table><th bgcolor=''>UNIVERSITY</th></table>");
}
int i=Integer.parseInt(name1);

Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select* from Colleges where Colleges.id="+i);


if(name.equals("name"))
{
while(rs.next())
{
coln=rs.getString(2);
out.println("<table><th bgcolor=''>COLLEGE NAME:"+coln+"</th></table>");
}
}

}catch(Exception ee){}

return coln;

}



public String option()
{
try{

Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select* from Colleges");
int col=0;
String collg="";

while(rs.next())
{
col=rs.getInt(1);
String collg1=rs.getString(2);
collg=collg+"<option value="+col+">"+collg1+"</option>";
}

out.println(collg);
}catch(Exception ee){}
return "col";
}


public String course()
{
try{

if(name.equals("name"))
{
//System.out.println(coln);
Statement st=c.createStatement();
i=Integer.parseInt(name1);
ResultSet rs=st.executeQuery("SELECT Collcourse.course,Collcourse.id FROM Collcourse where Collcourse.id="+i);

String s="";
while(rs.next())
{
s="<option>"+rs.getString(1)+"</option>"+s;
}
out.println(s);
}

if(name.equals("uni"))
{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT *FROM Courses");

String s="";
while(rs.next())
{
    
    s=s+"<option>"+rs.getString(1)+"</option>";
    
}
out.println(s);
}
}catch(Exception ee){ee.printStackTrace();}
return "return";

	}	
}

//SELECT Collcourse.id AS Collcourse_id, Collcourse.co1, Collcourse.co2, Collcourse.co3, //Collcourse.co4, Collcourse.co5, Colleges.id AS Colleges_id, Colleges.CollageName
//FROM Colleges INNER JOIN Collcourse ON Colleges.id = Collcourse.id;



//of university/SELECT Colleges.CollageName, Collcourse.co1, Collcourse.co2, //Collcourse.co3, Collcourse.co4, Collcourse.co5
//FROM Colleges INNER JOIN Collcourse ON Colleges.id = Collcourse.id;


