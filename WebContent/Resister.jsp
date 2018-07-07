<jsp:include page="home.html"/>
<%String select=(String)application.getAttribute("sec");
String id=(String)application.getAttribute("id");%>
<jsp:useBean id="obj" class="vik.Resistered"/>
<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="select" value="<%=select%>"/>
<jsp:setProperty name= "obj" property="id" value="<%=id%>"/> 
<jsp:setProperty name= "obj" property="*"/>
<style type="text/css">
<!--
.style1 {
	font-size: 24px;
	font-weight: bold;
}
-->
</style>
<body>
<table width="100%"  height='400' border="1">
  <tr>
    <td background="images/index_07-081.jpg"><div align="center" class="style1">YOUR FORM HAS BEEN SUBMITTED TO THE
        <%obj.resis();%></div></td>
  </tr>
</table>
</body>
</html>