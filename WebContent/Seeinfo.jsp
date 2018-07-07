<jsp:include page="home.html"/>
<jsp:useBean id="obj" class="vik.Admin5"/>

<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>
<body>

<table border="0" width="100%"  bgcolor="#0000FF">
<tr>
  <td width="20%"><a href="Admin.jsp"><div align="center">ADMIN HOME</div></a><%obj.details();%>  
    <%-- </td><td background="images/1.jpg"  height="200"><div align="center"><%obj.result();%></div></td></tr> --%></table>
</body> 