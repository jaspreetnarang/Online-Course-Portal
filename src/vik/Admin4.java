package vik;
import java.sql.*;
import cont.Connec;

public class Admin4
{

Connection c=Connec.getConnection();
String name="name";
static String fid="fid";
static String dep="dep";

String fname="fname";
String fadd="fadd";
String fph="fph";
String fmail="fmail";
String fsex="fsex";

static String depid="depid";






javax.servlet.jsp.JspWriter out;

public void setFid(String fid)
{
if(!fid.equals(null))
this.fid=fid;

		}



public void setName(String name)
{
if(!name.equals(null))
this.name=name;

		}


public void setDep(String dep)
{
if(!dep.equals(null))
this.dep=dep;

		}

public void setFname(String fname)
{
if(!fname.equals(null))
this.fname=fname;

		}


public void setFadd(String fadd)
{
if(!fadd.equals(null))
this.fadd=fadd;

		}

public void setFph(String fph)
{
if(!fph.equals(null))
this.fph=fph;

		}

public void setFmail(String fmail)
{
if(!fmail.equals(null))
this.fmail=fmail;

		}

public void setFsex(String fsex)
{
if(!fsex.equals(null))
this.fsex=fsex;

		}

public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String details()
{

try{

////****///INITIAL

if(name.equals("name")||name.equals("Home"))
{
String departments="";
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT depname FROM Departments");
while(rs1.next())
{
String s=rs1.getString(1);
departments=departments+"<option value="+s+">"+s+"</option>";
}
out.println("<table width='341' height='119'  bordercolor='' border='1' bgcolor=''><form name='form1' method='' action='Admin4.jsp'><tr><td><div align='center' class='style1'>Faculties and Departments Modification </div></td></tr><tr><td><div align='center' class='style2'>Departments: <select name='dep'>"+departments +"</select></div></td></tr><tr><td><div align='center'><input type='submit' name='name' value='Department'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='Faculties'></div></td></tr></form></table>");
}


////*****/////CHOSE  Faculty******/////

if(name.equals("Faculties")||name.equals("BACK"))
{
//System.out.println(dep);
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT id FROM Departments where depname='"+dep+"'");
while(rs.next())
{
depid=rs.getString(1);
}


String facl="";
int id1=Integer.parseInt(depid);	
ResultSet rs1=st.executeQuery("SELECT fname,fid FROM Depdetail where id="+id1);
while(rs1.next())
{
String s=rs1.getString(1);
String s1=rs1.getString(2);

facl=facl+"<option value="+s1+" >"+s+"</option>";
 }
out.println("<table width='341' height='119'  bordercolor='' border='1' bgcolor=''><form name='form1' method='' action='Admin4.jsp?name=n'><tr><td><div align='center' class='style1'>Faculty Modification </div></td></tr><tr><td><div align='center' class='style2'>Faculties of "+dep+": <select name='fid'>"+facl+"</select></div></td></tr><tr><td><div align='center'><input type='submit' name='name' value='MODIFY'>&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='NEW'>&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='Home'></div></td></tr></form></table>");
}

//FACULTY "MODIFY"//

if(name.equals("MODIFY"))
{
Statement st1=c.createStatement();
int id1=Integer.parseInt(fid);
ResultSet rs1=st1.executeQuery("SELECT *from Depdetail where fid="+id1);
while(rs1.next())
{
fname=rs1.getString(2);
fadd=rs1.getString(3);
fph=rs1.getString(4);
fmail=rs1.getString(5);
fsex=rs1.getString(6);
}

out.println("<table bgcolor='' WIDTH='500'  bordercolor='' border='1'><td><form name='form1' method='' action='Admin4.jsp'><p><div align='CENTER'>Faculty :&nbsp;&nbsp;&nbsp; <input type='text' name='fname' value='"+fname+"'></div></p><p><div align='center'><p><div align='CENTER'>Address :&nbsp;&nbsp;&nbsp; <input type='text' name='fadd' value='"+fadd+"'></div></p><p><div align='CENTER'>Contect no. :&nbsp;&nbsp;&nbsp; <input type='text' name='fph' value='"+fph+"'></div></p><p><div align='CENTER'>Mail ID :&nbsp;&nbsp;&nbsp; <input type='text' name='fmail' value='"+fmail+"'></div></p><p><div align='CENTER'>Gender :&nbsp;&nbsp;&nbsp; <select name='fsex'><option value="+fsex+" selected>"+fsex+"</option><option>Male</option><option>Fimale</option></select></div></p><input  type='submit' name='name' value= 'CONFORM' onclick='return validationTxt()'>&nbsp;&nbsp;<input  type='submit' name='name' value= 'BACK'>&nbsp;&nbsp;<input  type='submit' name='name' value= 'DELETE'>&nbsp;&nbsp;<input type='submit' name='name' value= 'Home'></div></form></td></table>");

}

//**//CONFORM

if(name.equals("CONFORM"))
{
int id1=Integer.parseInt(fid);
PreparedStatement ps=c.prepareStatement("update Depdetail set fname=?,fadd=?,fph=?,fmail=?,fsex=?  where fid=?");
ps.setString(1,fname);
ps.setString(2,fadd);
ps.setString(3,fph);
ps.setString(4,fmail);
ps.setString(5,fsex);
ps.setInt(6,id1);
int a=ps.executeUpdate();
if(a==1)
out.println("<table bgcolor=''  bordercolor='' border='1'><td>Faculty Details Modified=> "+fname+" "+fadd+" "+fph+" "+fmail+" "+fsex+"</td></table>");

}

//***FACULTY DELETE****////
if(name.equals("DELETE"))
{
int id1=Integer.parseInt(fid);

PreparedStatement ps=c.prepareStatement("delete *from Depdetail where fid=?");

ps.setInt(1,id1);

int a=ps.executeUpdate();
if(a==1)
out.println("<table bgcolor=''  bordercolor='' border='1'><td>FACUTLY DELETED</td></table>");
}

///*******NEW FACULTY ADD*****//
if(name.equals("NEW"))
{
out.println("<table bgcolor=''  bordercolor='' border='1'><td><form name='form1' method='' action='Admin4.jsp'><p><div align='right'>Faculty :&nbsp;&nbsp;&nbsp; <input type='text' name='fname' ></div></p><p><div align='center'><p><div align='right'>Address :&nbsp;&nbsp;&nbsp; <input type='text' name='fadd'></div></p><p><div align='right'>Contect no. :&nbsp;&nbsp;&nbsp; <input type='text' name='fph' ></div></p><p><div align='right'>Mail ID :&nbsp;&nbsp;&nbsp; <input type='text' name='fmail' ></div></p><p><div align='right'>Gender :&nbsp;&nbsp;&nbsp; <select name='fsex'><option>Male</option><option>Fimale</option></select></div></p><input  type='submit' name='name' value= 'ADD' onclick='return validationTxt()'>&nbsp;&nbsp;<input type='submit' name='name' value= 'BACK'>&nbsp;&nbsp;<input type='submit' name='name' value='Home'></div></form></td></table>");
}

if(name.equals("ADD"))
{
int id1=Integer.parseInt(depid);	
Statement st1=c.createStatement();
int fid1=0;
ResultSet rs1=st1.executeQuery("SELECT fid from Depdetail");
while(rs1.next())
{
fid1=rs1.getInt(1);
}
fid1=fid1+1;

PreparedStatement ps=c.prepareStatement("INSERT into Depdetail Values(?,?,?,?,?,?,?)");
ps.setInt(1,id1);
ps.setString(2,fname);
ps.setString(3,fadd);
ps.setString(4,fph);
ps.setString(5,fmail);
ps.setString(6,fsex);
ps.setInt(7,fid1);

int ii=ps.executeUpdate();
if(ii==1)
out.println("<table   bordercolor='' border='1'><td>NEW FACULTY ADDED IN "+dep+"</td></table>");
}



/////*****  Depatments  ****/////

if(name.equals("Department"))
{
String departments="";
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT depname FROM Departments");
while(rs1.next())
{
String s=rs1.getString(1);
departments=departments+"<option value="+s+">"+s+"</option>";
}
out.println("<table width='341' height='119'  bordercolor='' border='1' bgcolor=''><form name='form1' method='' action='Admin4.jsp'><tr><td><div align='center' class='style1'>Departments Modification </div></td></tr><tr><td><div align='center' class='style2'>Departments: <select name='dep'>"+departments +"</select></div></td></tr><tr><td><div align='center'><input type='submit' name='name' value='REMOVE'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='ADD NEW' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='Home'></div></td></tr></form></table>");

}


if(name.equals("REMOVE"))
{
int id=0;
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT id FROM Departments where depname='"+dep+"'");
while(rs.next())
{
id=Integer.parseInt(rs.getString(1));
}

PreparedStatement ps=c.prepareStatement("delete *from Depdetail where id=?");
ps.setInt(1,id);
int a=ps.executeUpdate();

PreparedStatement ps1=c.prepareStatement("delete *from Departments where id=?");
ps1.setInt(1,id);
int a1=ps1.executeUpdate();

//if(a==1&&a1==1)
out.println("<table BGCOLOR=''  bordercolor='' border='1'><td>DEPARTMENT REMOVED</td></table>");
}



if(name.equals("ADD NEW"))
{
out.println("<table width='341' height='119'  bordercolor='' border='1' bgcolor=''><form name='form2' method='' action='Admin4.jsp'><tr><td><div align='center' class='style1'> New Department </div></td></tr><tr><td><div align='center' class='style2'>Department: <input type='text' name='dep'></div></td></tr><tr><td><div align='center'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='Add' onclick='return validationTxt1()'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='Home'></div></td></tr></form></table>");
}

if(name.equals("Add"))
{
String Id="0";
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT id FROM Departments");
while(rs.next())
{
Id=rs.getString(1);
}
int i=Integer.parseInt(Id);
i=i+1;
PreparedStatement ps=c.prepareStatement("INSERT  into Departments Values(?,?)");
ps.setInt(1,i);
ps.setString(2,dep);
int a=ps.executeUpdate();
if(a==1)
out.println("<table BGCOLOR=''  bordercolor='' border='1'><td>DEPARTMENT ADDED</td></table>");
}
}catch(Exception e){
System.out.println(e);e.printStackTrace();}

return "vv";
}


    
}
