<jsp:include page="home.html"/>

<jsp:useBean id="obj" class="vik.Principleinfo"/>
<jsp:setProperty name= "obj" property="out" value="<%=out%>"/> 
<jsp:setProperty name= "obj" property="*"/>


<style type="text/css">
<!--
body {
	background-image: url(images/index_07-081.jpg);
}
-->
</style><body>
<table width="100%"  border="1">
  <tr>
    <td height="367"><div align="center"><%obj.valid();String id=obj.collegeid();application.setAttribute("id",id);%></div></td>
  </tr>
</table>

</body>
</html>
