<jsp:include page="home.html"/>
<jsp:useBean id="obj" class="vik.Admin11"/>

<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>
<body background='images/index_07-081.jpg'>
<TABLE WIDTH='100%' background='images/1.jpg'><TR><TD >
<DIV ALIGN="CENTER">
<table height="400" background="images/index_07-081.jpg" border="0" width="100%"  bgcolor="">
<tr>
  <td width="20%"><a href="Admin1.jsp"><div align="center">ADMIN HOME</div></a><%obj.details();%>  
    </td><td background="images/index_07-081.jpg"  height="200"><div align="center"><%obj.result();%></div></td></tr></table>
</DIV></TD></TR>
</TABLE>

</body>