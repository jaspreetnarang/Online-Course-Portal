package vik;
import java.sql.*;
import cont.Connec;

public class Admininfo
{

Connection c=Connec.getConnection();
static String name="",pass="";
String name1="";
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

public void  setPass(String pass)
{
if(!pass.equals(null))
this.pass=pass;
		}


public void setOut(javax.servlet.jsp.JspWriter out)
{
this.out=out;
		}

public String Info()
{

try{
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select *from Login where Login.id=0");

while(rs.next())
{
String s1=rs.getString(2);
String s2=rs.getString(3);
  if(name.equals(s1)&&pass.equals(s2))
   {
       i=1; 
     name=s1;
     pass=s2;
	    }
    }              
 

if(i==0)
out.println("<table cellspacing='1' bgcolor='' border='2' bordercolor=''><tr><td >USER NAME OR PASSWORD IS NOT VALID LOGIN AGAIN</td></tr><tr><td><div align='center'><a href='Login2.jsp'>TRY AGAIN</a></div></td></tr></table>");
//System.out.println(name+name1);









if(i==1)
{
String tb="<table width='100%' background='images/index_07-081.jpg' height='100'  border='1' bordercolor='' cellspacing='1'><tr><td background='images/index_07-081.jpg' width='20%' height=150' rowspan='2'  ><table  width='100%' height='350' border='0'   cellspacing='1' bgcolor=''><tr><td width='10%' height='15%' ><div align='center' class='style1 style2'><strong>ADMIN AUTHORITY</strong></div></td></tr><tr><td height='18%' ><div align='center'><a href='Admin1.jsp'><strong>RESULT VIEW</strong></a></div></td></tr><tr><td height='18%' ><div align='center'><a href='Admin2.jsp'><strong>COURSES</strong></a></div></td></tr><tr><td height='18%' ><div align='center'><a href='Admin3.jsp'><strong>COLLEGES</strong></a></div></td></tr><tr><td height='18%' ><div align='center'><a href='Admin4.jsp'><strong>FACULTIES</strong></a></div></td></tr><tr><td height='18%' ><div align='center'><a href='Admin5.jsp'><strong>NEW RESULT UPLOAD</strong></a></div></td></tr><tr><td height='18%'><div align='center'><a href='Admin6.jsp'><strong>ADMISSION FORMS</strong></a></div></td></tr></table></td><td width='70%' bgcolor=''><div align='CENTER' class='style1'><a href='Admin7.jsp'><strong>CHANGE PASSWORD</strong></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='Logout.jsp'><strong>LOG OUT</strong></a></div></td></tr><tr><td height='144' background='images/index_07-081.jpg' bgcolor=''><div align='center'></div></td></tr></table>";

out.println(tb);



}
}catch(Exception e){
System.out.println(e);}

return "vv";
}


    
}


/*//////////////////////////////////////////////////////////////////table////////////////////////////////////////////////////////
<table width="100%" height="275"  border="1">
  <tr>
    <td width="27%" height="287" rowspan="2" bgcolor="#00FFCC"><table width="100%" height="278"  border="0" cellspacing="0">
      <tr>
        <td height="23" bgcolor="#990000"><div align="center" class="style1 style2">ADMIN AUTHORITY</div></td>
      </tr>
      <tr>
        <td height="40%" bgcolor="#0000FF"><div align="center" class="style1"><a href="Admin.jsp?name=1">RESULT VIEW</a></div></td>
      </tr>
      <tr>
        <td height="40%" bgcolor="#0000FF"><div align="center"><a href="Admin.jsp?name=2">ADD NEW COURSE </a></div></td>
      </tr>
      <tr>
        <td height="40%" bgcolor="#0000FF"><div align="center"><a href="Admin.jsp?name=3">ADD NEW COLLEGE </a></div></td>
      </tr>
      <tr>
        <td height="40%" bgcolor="#0000FF"><div align="center"><a href="Admin.jsp?name=4">NEW RESULT UPLOAD</a></div></td>
      </tr>
      <tr>
        <td height="40%" bgcolor="#0000FF"><div align="center"><a href="Admin.jsp?name=5">SEE INFORMATION</a></div></td>
      </tr>
    </table></td>
    <td width="73%" bgcolor="#00FFCC"><div align="center">BE</div></td>
  </tr>
  <tr>
    <td height="244" bgcolor="#00FFCC"><div align="center"><%=name%></div></td>
  </tr>
</table>

*/