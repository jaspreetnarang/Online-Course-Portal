<jsp:include page="home.html"/>
<jsp:useBean id="obj" class="vik.Admin6"/>

<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>


<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
</style>
<body background='images/index_07-081.jpg'>
<TABLE WIDTH='100%' background='images/1.jpg'><TR><TD >
<DIV ALIGN="CENTER">
<table width='100%' background='images/index_07-081.jpg' height='100'  border='1' bordercolor='' cellspacing='1'>
<tr><td background='images/index_07-081.jpg' width='20%' height=150' rowspan='2'  >
<table  width='100%' height='350' border='0'   cellspacing='1' bgcolor=''>
<tr><td width='10%' height='15%' ><div align='center' class='style1 style2'><strong>ADMIN AUTHORITY</strong></div></td></tr>
<tr><td height='18%' ><div align='center'><a href='Admin1.jsp'><strong>RESULT VIEW</strong></a></div></td>
</tr><tr><td height='18%' ><div align='center'><a href='Admin2.jsp'><strong>COURSES</strong></a></div></td>
</tr><tr><td height='18%' ><div align='center'><a href='Admin3.jsp'><strong>COLLEGES</strong></a></div></td></tr>
<tr><td height='18%' ><div align='center'><a href='Admin4.jsp'><strong>FACULTIES</strong></a></div></td></tr>
<tr><td height='18%' ><div align='center'><a href='Admin5.jsp'><strong>NEW RESULT UPLOAD</strong></a></div></td></tr>
<tr><td height='18%'><div align='center'><a href='Admin6.jsp'><strong>ADMISSION FORMS</strong></a></div></td></tr></table>
</td><td width='70%' bgcolor=''><div align='CENTER' class='style1'><a href='Admin7.jsp'><strong>CHANGE PASSWORD</strong></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='Logout.jsp'><strong>LOG OUT</strong></a></div></td></tr>
<tr><td height='144' background='images/index_07-081.jpg' bgcolor=''><div align='center'><%obj.details();%></div></td></tr></table>
</DIV></TD></TR>
</TABLE>
</body>