package vik;
import java.sql.*;
import cont.Connec;

public class Admin3
{

Connection c=Connec.getConnection();
String name="name";

static String collegeold="collegeold";
String coll="coll";
String place="place";
String cph="cph";
String fax="fax";
String princ="princ";
String pno="pno";
String mail="mail";
String login="login";
String pass="pass";
String colleges="";
static String id="1";

javax.servlet.jsp.JspWriter out;


public void setName(String name)
{
if(!name.equals(null))
this.name=name;
//System.out.println("dddddd"+name);
		}

public void setColl(String coll)
{
if(!coll.equals(null))
this.coll=coll;
		}

public void setPlace(String place)
{
if(!place.equals(null))
this.place=place;
		}

public void setCph(String cph)
{
if(!cph.equals(null))
this.cph=cph;
		}

public void setFax(String fax)
{
if(!fax.equals(null))
this.fax=fax;
		}

public void setPrinc(String princ)
{
if(!princ.equals(null))
this.princ=princ;
		}

public void setPno(String pno)
{
if(!pno.equals(null))
this.pno=pno;
		}

public void setMail(String mail)
{
if(!mail.equals(null))
this.mail=mail;
		}


public void setLogin(String login)
{
if(!login.equals(null))
this.login=login;
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


public String details()
{

try{
//System.out.println("name= "+name+" colleges= "+colleges);

////****///INITIAL
if(name.equals("name")||name.equals("Home"))
{
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT Colleges.CollegeName FROM Colleges");
while(rs1.next())
{
String s=rs1.getString(1);
colleges=colleges+"<option value="+s+">"+s+"</option>";
}
out.println("<table width='341' height='119'  bordercolor='' border='1' bgcolor=''><form name='form2' method='' action='Admin3.jsp'><tr><td><div align='center' class='style1'>College Modification </div></td></tr><tr><td><div align='center' class='style2'>College in university::<select name='coll'>"+colleges+"</select></div></td></tr><tr><td><div align='center'><input type='submit' name='name' value='MODIFY'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='DELETE'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='name' value='NEW'></div></td></tr></form></table>");
}


////*****/////MODIFY

if(name.equals("MODIFY"))
{
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT Colleges.id, Colleges.CollegeName, Colldetail.add, Colldetail.ph, Colldetail.fax, Colldetail.pri, Colldetail.priph, Colldetail.mail, Login.Name, Login.password FROM (Colleges INNER JOIN Colldetail ON Colleges.id = Colldetail.id) INNER JOIN Login ON Colleges.id = Login.id where Colleges.CollegeName='"+coll+"'");
while(rs1.next())
{
id=rs1.getString(1);
collegeold=rs1.getString(2);
place=rs1.getString(3);
cph=rs1.getString(4);
fax=rs1.getString(5);
princ=rs1.getString(6);
pno=rs1.getString(7);
mail=rs1.getString(8);
login=rs1.getString(9);
pass=rs1.getString(10);

}
out.println("<table bordercolor='' border='1' bgcolor=''><form name='form1' action='Admin3.jsp'><tr><td></div></p><p><div align='right'>COLLEGE NAME:&nbsp;&nbsp;<input type='text' name='coll' value="+collegeold+"></div></p><p><div align='right'>PLACED AT: &nbsp;&nbsp;<input type='text' name='place' value="+place+"></div></p><p><div align='right'>COLLEGE CONTECT NO: &nbsp;&nbsp;<input type='text' name='cph' value="+cph+"></div></p><p><div align='right'>FAX NO: &nbsp;&nbsp;<input type='text' name='fax' value="+fax+"></div></p><p><div align='right'>PRINCIPLE NAME:&nbsp;&nbsp;&nbsp;<input type='text' name='princ' value="+princ+"></div></p><p><div align='right'>PHONE NO: &nbsp;&nbsp;&nbsp;<input type='text' name='pno' value="+pno+"></div></p><p><div align='right'>MAIL ID:&nbsp;&nbsp;&nbsp; <input type='text' name='mail' value="+mail+"></div></p><p><div align='right'>INITIAL LOGIN ID:&nbsp;&nbsp;&nbsp; <input type='text' name='login' value="+login+"></div></p><p><div align='right'>INITIAL PASSWORD:&nbsp;&nbsp;&nbsp; <input type='text' name='pass' value="+pass+"></div></p><p><div align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type='submit' name='name' value= 'CONFORM' onclick='return validationTxt()'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type='submit' name='name' value= 'Home' ></p></div></td></tr></form></TABLE>");
}


////CONFORM
if(name.equals("CONFORM"))
{
//System.out.println(id);
int id1=Integer.parseInt(id);
PreparedStatement ps1=c.prepareStatement("update Login set Name=?,password=? where id=?");
ps1.setString(1,login);
ps1.setString(2,pass);
ps1.setInt(3,id1);

int a1=ps1.executeUpdate();

PreparedStatement ps2=c.prepareStatement("update Colleges set CollegeName=? where id=?");
ps2.setString(1,coll);
ps2.setInt(2,id1);

int a2=ps2.executeUpdate();

PreparedStatement ps3=c.prepareStatement("update Colldetail set add=?,ph=?,fax=?,pri=?,priph=?,mail=? where id=?");

ps3.setString(1,place);
ps3.setString(2,cph);
ps3.setString(3,fax);
ps3.setString(4,princ);
ps3.setString(5,pno);
ps3.setString(6,mail);
ps3.setInt(7,id1);
int a3=ps3.executeUpdate();
if(a1==1&&a2==1&&a3==1)
out.println("<table BGCOLOR='' border='1'><td>COLLEGE UPDATED IN UNIVERSITY</td></table>");

}


//***COURSE DELETE****////
if(name.equals("DELETE"))
{
Statement st1=c.createStatement();
ResultSet rs1=st1.executeQuery("SELECT id FROM Colleges where CollegeName='"+coll+"'");
String s="";
while(rs1.next())
s=rs1.getString(1);

int id1=Integer.parseInt(s);

PreparedStatement ps1=c.prepareStatement("delete * from Login where id=?");
PreparedStatement ps2=c.prepareStatement("delete * from Colleges where id=?");
PreparedStatement ps3=c.prepareStatement("delete * from Colldetail where id=?");
PreparedStatement ps4=c.prepareStatement("delete * from Collcourse where id=?");
PreparedStatement ps5=c.prepareStatement("delete * from applications where id=?");

ps1.setInt(1,id1);
ps2.setInt(1,id1);
ps3.setInt(1,id1);
ps4.setInt(1,id1);
ps5.setInt(1,id1);

//System.out.println(id1);
int a1=ps1.executeUpdate();
int a2=ps2.executeUpdate();
int a3=ps3.executeUpdate();
int a4=ps4.executeUpdate();
int a5=ps5.executeUpdate();

//if(a1==1&&a2==1&&a3==1&&a4==1)
out.println("<table  border='1' BGCOLOR=''><td>COLLEGE DELETED FROM UNIVERSITY</td></table>");
 	
}

///*******NEW COLLEGE ADD*****//
if(name.equals("NEW"))
{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT CollegeName FROM Colleges");

String td="<TABLE border='1'><form name=form1 action='Admin3.jsp' method=''><tr><td BGCOLOR=''><p><div align='center'>COLLEGE IN UNIVERSITY:<select name='select'>";
while(rs.next())
{
td=td+"<option>"+rs.getString(1)+"</option>";
    }              
 td=td+"</select></div></p><p><div align='right'>NEW COLLEGE NAME:&nbsp;&nbsp;<input type='text' name='coll' ></div></p><p><div align='right'>PLACED AT: &nbsp;&nbsp;<input type='text' name='place' ></div></p><p><div align='right'>COLLEGE CONTECT NO: &nbsp;&nbsp;<input type='text' name='cph'></div></p><p><div align='right'>FAX NO: &nbsp;&nbsp;<input type='text' name='fax'></div></p><p><div align='right'>PRINCIPLE NAME:&nbsp;&nbsp;&nbsp;<input type='text' name='princ'></div></p><p><div align='right'>PHONE NO: &nbsp;&nbsp;&nbsp;<input type='text' name='pno'></div></p><p><div align='right'>MAIL ID:&nbsp;&nbsp;&nbsp; <input type='text' name='mail'></div></p><p><div align='right'>INITIAL LOGIN ID:&nbsp;&nbsp;&nbsp; <input type='text' name='login'></div></p><p><div align='right'>INITIAL PASSWORD:&nbsp;&nbsp;&nbsp; <input type='text' name='pass'></div></p><p><div align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type='submit' name='name' value= 'ADD' onclick='return validationTxt()'>&nbsp;&nbsp;&nbsp;<INPUT  type=reset value=Reset >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type='submit' name='name' value= 'Home' ></p></div></td></tr></form></TABLE>";
out.println(td);


}

if(name.equals("ADD"))
{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT id FROM Colleges");
String s="0";
while(rs.next())
{
s=rs.getString(1);
}
int id=Integer.parseInt(s);
id=id+1;
//System.out.println(id);

PreparedStatement ps1=c.prepareStatement("insert into Login Values(?,?,?)");
ps1.setInt(1,id);
ps1.setString(2,login);
ps1.setString(3,pass);
int a1=ps1.executeUpdate();

PreparedStatement ps2=c.prepareStatement("insert into Colleges Values(?,?)");
ps2.setInt(1,id);
ps2.setString(2,coll);
int a2=ps2.executeUpdate();

PreparedStatement ps3=c.prepareStatement("insert into Colldetail Values(?,?,?,?,?,?,?)");
ps3.setInt(1,id);
ps3.setString(2,place);
ps3.setString(3,cph);
ps3.setString(4,fax);
ps3.setString(5,princ);
ps3.setString(6,pno);
ps3.setString(7,mail);
int a3=ps3.executeUpdate();
if(a1==1&&a2==1&&a3==1)
out.println("<table BGCOLOR='' border='1'><td>NEW COLLEGE IS ADDED IN UNIVERSITY</td></table>");

}


}catch(Exception e){
System.out.println(e);}

return "vv";
}


    
}
