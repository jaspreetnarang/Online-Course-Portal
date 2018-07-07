<jsp:include page="home.html"/>

<style type="text/css">
<!--
body {
	background-image: url(images/index_07-081.jpg);
}
-->
</style>
<jsp:useBean id="obj" class="vik.Validroll"/>
<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*" />
<table width="100%" height="367"  border="1">
  <tr>
    <td height="362"><div align="center">
        <%obj.details();%>
    </div></td>
  </tr>
</table>
<div align="center"></div>
