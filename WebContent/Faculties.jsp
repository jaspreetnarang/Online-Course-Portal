<jsp:include page="home.html"/>

<style type="text/css">
<!--
body {
	background-image: url(images/index_07-081.jpg);
}
-->
</style>
<jsp:useBean id="obj" class="vik.FacDetail"/>

<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>

<div id="Layer1"  style="position:absolute; width:274px; height:63px; z-index:1; left: 9px; top: 273px;">
        <h1 class="style2">
          <marquee direction="right"  behavior="slide">
          <img src="images/fac.JPG" width="263" height="48">
          </marquee>
        </h1>
</div>
<div id="Layer1" style="position:absolute; width:280px; height:37px; z-index:1; left: 7px; top: 351px;">
  <h1 align="center" class="style2"><%obj.links();%>
  </h1>
</div>								

<div id="Layer1" style="position:absolute; width:954px; height:37px; z-index:1; left: 291px; top: 372px;">
													   <div align="left">
													     <%obj.details();%>
													   </div>
</div>								

</body>
</html>

