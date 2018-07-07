<jsp:include page="home.html"/>
<%String name=request.getParameter("name");
String name1=request.getParameter("select");
out.println(name1);
%>


<jsp:useBean id="obj" class="vik.Forms"/>
<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="name" value="<%=name%>"/>

<LINK 
href="images/stylesheet.css" 
type=text/css rel=stylesheet>
<STYLE type=text/css>


<!--
body {
	background-image:  url(images/index_07-081.jpg);
}
.style1 {color: #FFFFFF}
H1 {
	FONT-WEIGHT: normal; FONT-SIZE: 19pt; MARGIN: 0in 0in 0pt; LINE-HEIGHT: 200%; FONT-FAMILY: "DevLys 010"; TEXT-ALIGN: justify
}
H4 {
	FONT-SIZE: 12pt; MARGIN: 0in 0in 0pt; FONT-FAMILY: "Times New Roman"; LETTER-SPACING: 0.1pt; POSITION: relative; TOP: -1pt; TEXT-ALIGN: center; TEXT-DECORATION: underline; text-underline: single
}

a:link {
	color: #FFFFFF;
}
a:visited {
	color: #FFFFFF;
}
a:hover {
	color: #FFFFFF;
}
a:active {
	color: #FFFFFF;
}
body,td,th {
	color: #FFFFFF;
}
-->
</style>
<table width="100%"  border="2">
  <tr>
    <td>

<form action='Resister.jsp?name=1'>
  <table width='100%' height='445'  border='0'><tr><td height='50' colspan='2'><div align='center'>STUDENT ADMISSION FORM</div></td></tr><tr><td width='50%' height='10'><div align="right">COLLEGE NAME:
            <select name='college' size='1' >
              "+coll+"
            </select>
  </div></td><td width='50%'>Affileted University My University</td></tr><tr><td height='111' colspan='2'><div align='center'>PERSONAL DETAILS</div></td></tr><tr><td height='27'><div align="right">APPLICENT NAME:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type='text' name='student'>
  </div></td><td height='27'><div align="right">PARMANENT ADDRESS: 
        <input type='text' name='address'>
  </div></td></tr><tr><td height='28'><div align="right">FATHER/GUARDIAN NAME:
              <input type='text' name='father'>
  </div></td>
  <td height='28'><div align="right">CITY:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type='text' name='city'>
  </div></td></tr><tr><td height='13'><div align="right">DATE OF BIRTH:(D-M-S)
          <input type='text' name='dob'>
  </div></td><td height='13'><div align="right">STATE:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type='text' name='state'>
  </div></td></tr><tr><td height='14'><div align="right">GENDER:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <select name='sex'>
            <option>MALE</option>
            <option>FIMALE</option>
          </select>
  </div></td><td height='14'><div align="right">PIN CODE:
        <input type='text' name='pin'>
  </div></td></tr><tr><td height='29'><div align="right">COURSE:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <select name='course'>
            <OPTION>COURSE</OPTION>
          </select>
  </div></td><td height='29'><div align="right">CONTECT  NO.
        <input type='text' name='contect'>
  </div></td></tr><tr><td height='29' colspan='2'><div align='center'>EDUCATION DETAILS </div></td></tr><tr><td height='13'><div align="right">TENTH MARKS(%):
          <input type='text' name='10%'>
  </div></td>
    <td height='13'>&nbsp;</td>
  </tr><tr><td height='47'><div align="right">TWELTH MARKS(%):
          <input type='text' name='12%'> 
        </div></td><td height='47'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <div align="center">
            <input type='submit' name='Submit' value='RESISTER'>
        </div></td></tr></table>
</form>
</td>
  </tr>
</table>