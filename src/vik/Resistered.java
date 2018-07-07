package vik;
import java.sql.*;
import cont.Connec;
public class Resistered
{

Connection c=Connec.getConnection();
String select,id,student,father,dob,sex,address,city,state,pin,contect,ten,twe,course;
javax.servlet.jsp.JspWriter out;

public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public void setSelect(String select)
{
this.select=select;
		}

public void setId(String id)
{
this.id=id;
		}

public void setStudent(String student)
{
this.student=student;
		}

public void setFather(String father)
{
this.father=father;
		}

public void setDob(String dob)
{
this.dob=dob;
		}

public void setSex(String sex)
{
this.sex=sex;
		}

public void setAddress(String address)
{
this.address=address;
		}

public void setCity(String city)
{
this.city=city;
		}

public void setState(String state)
{
this.state=state;
		}

public void setPin(String pin)
{
this.pin=pin;
		}

public void setContect(String contect)
{
this.contect=contect;
		}

public void setTen(String ten)
{
this.ten=ten;
		}

public void setTwe(String twe)
{
this.twe=twe;
		}

public void setCourse(String course)
{
this.course=course;
		}


public String resis()
{
try{
Connection c=cont.Connec.getConnection();
Statement st=c.createStatement();
int id1=0;
ResultSet rs=st.executeQuery("select stid from applications");
while(rs.next())
{
id1=rs.getInt(1);
}
id1=id1+1;
PreparedStatement ps=c.prepareStatement("insert into applications Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
int i=Integer.parseInt(id);
ps.setInt(1,i);
ps.setString(2,student);
ps.setString(3,father);
ps.setString(4,dob);
ps.setString(5,sex);
ps.setString(6,address);
ps.setString(7,city);
ps.setString(8,state);
ps.setString(9,pin);
ps.setString(10,contect);
ps.setString(11,ten);
ps.setString(12,twe);
ps.setString(13,course);
ps.setString(14,select);
ps.setInt(15,id1);

int n1=ps.executeUpdate();
out.println(select);
}catch(Exception e){System.out.println(e);}
return select;
}
}