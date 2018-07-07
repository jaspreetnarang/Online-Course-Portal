<jsp:include page="home.html"/>
<style type="text/css">
<!--
body {
	background-image: url(images/index_07-081.jpg);
}
-->
</style>

<%String id=(String)application.getAttribute("id");%>
<jsp:useBean id="obj" class="vik.Logout"/>
<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*" />
<jsp:setProperty name= "obj" property="id" value="<%=id%>"/> 

<table width="100%" height="367"  border="1">
  <tr>
    <td height="362"><div align="center">
        <%obj.details();%>
    </div></td>
  </tr>
</table>
<div align="center"></div>