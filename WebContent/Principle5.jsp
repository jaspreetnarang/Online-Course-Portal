<jsp:include page="home.html"/>
<%String id=(String)application.getAttribute("id");%>
<jsp:useBean id="obj" class="vik.Principle5"/>
<jsp:setProperty name= "obj" property="out" value="<%=out%>"/> 
<jsp:setProperty name= "obj" property="*"/>
<jsp:setProperty name= "obj" property="id" value="<%=id%>"/> 


<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
</style>
<body background='images/index_07-081.jpg'>
<table width="100%" background="images/1.jpg"  border="0">
  <tr>
    <td><div align="center">

<table width='100%' height='100'  border='1' cellspacing="0" background='images/index_07-081.jpg'>
<tr><td background='images/1.jpg' width='20%' height=150' rowspan='2' bgcolor='#000000' ><table background='images/index_07-081.jpg' width='100%' height='250' border='0' cellspacing='0'><tr><td width='20%' height='25%' bgcolor=''><div align='center' class='style1 style2 style1'><strong>PRINCIPAL AUTHORITY</strong></div></td>
</tr><tr><td height='35%'><div align='center'><a href='Principle1.jsp?name1=modify'><strong>MODIFY COURSE</strong></a></div></td></tr><tr><td height='35%'><div align='center'><a href='Principle2.jsp?name1=ADD''><strong>ADD NEW COURSE </strong></a></div></td></tr><tr><td height='35%'><div align='center'><a href='Principle3.jsp?name1=Form'.jsp'><strong>ADMISSION FORMS FOR COLLEGE</strong></a></div></td></tr></table></td><td width='70%'><div align='CENTER' class='style1'><a href='Principle5.jsp?name1=Change''><strong>CHANGE PASSWORD</strong></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='Logout.jsp'><strong>LOG OUT</strong></a></div></td></tr><tr><td height='144' background='images/index_07-081.jpg'><div align='center'><%obj.change();%></div></td></tr></table>
</body>
</div></td>
  </tr>
</table>
</body>
</html>
