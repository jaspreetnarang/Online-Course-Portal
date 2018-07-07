<jsp:include page="home.html"/>
<jsp:useBean id="obj" class="vik.Collcourse"/>

<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>

<style type="text/css">
<!--
body {
	background-image: url(images/index_07-081.jpg);
}
-->
</style>

<div id="Layer1"  style="position:absolute; width:274px; height:63px; z-index:1; left: 9px; top: 273px;">
        <h1 class="style2">
          <marquee direction="right"  behavior="slide">
          <img src="images/cour.JPG" width="263" height="48">
          </marquee>
        </h1>
</div>
<div id="Layer1" style="position:absolute; width:280px; height:37px; z-index:1; left: 7px; top: 351px;">
  <h1 align="center" class="style2"><%obj.links();%>
  </h1>
</div>								

<div id="Layer1" style="position:absolute; width:557px; height:37px; z-index:1; left: 431px; top: 353px;">
  <div align="center">
    <%obj.linkcol();%>
     </div>
</div>								

</body></body>
</html>

