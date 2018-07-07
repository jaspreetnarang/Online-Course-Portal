<jsp:include page="home.html"/>

<jsp:useBean id="obj" class="vik.Forms"/>
<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<SCRIPT language=javascript>
function validationTxt()
{

 if (form1.select.value == 0)
{
		alert("Please Select Your College Name")
		form1.select.focus()
		return false
		}
}



</SCRIPT>

<style type="text/css">
<!--
.style1 {font-size: 24px}
.style6 {font-size: 18px}
-->
</style>
<body>
<table width="100%" height="406"  border="1" cellpadding="1" cellspacing="1" background="images/index_07-081.jpg">
  <tr>
    <td height="83" colspan="2"><div align="center"><span class="style3 style1"><strong>CHOOSE OPTION FOR ADMISSION </strong></span></div></td>
  </tr>
  <tr>
    <td width="52%" height="277"><form name="form1" method="" action="Submitfm.jsp?name=coll" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="imgf" type="image" onClick="return validationTxt()" src="images/GTBIT-Delhi.jpg" width="165" height="151" border="0">      
        <select name=select><option value=0></option><%obj.option();%>
      </select> 
      <span class="style4 style6">COLLEGES</span>
                    </form></td>
    <td width="48%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="Submitfm.jsp?name=uni"><img src="images/USIT.jpg" width="188" height="150" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;<span class="style4 style6">UNIVERSITY </span></td>
  </tr>
</table>

</body>
</html>
