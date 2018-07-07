<jsp:include page="home.html"/>

<%application.setAttribute("id","0");%>
<jsp:useBean id="obj" class="vik.Admininfo"/>

<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>


<style type="text/css">
<!--
body {
	background-image: url(images/index_07-081.jpg);
}
-->
</style><body>

<TABLE WIDTH='100%' height="367" border="1">
  <TR><TD height="287" >
<DIV ALIGN="CENTER"><%obj.Info();%></DIV></TD></TR>
</TABLE>
</body>