<SCRIPT language=javascript>
function validationTxt()
{

		
		

	
		if ((form1.roll.value == "") || (form1.roll.value == null)||(isNaN(form1.roll.value)))
		{
				alert("Please Enter Roll No. in Number")
				form1.roll.focus()
				return false
		}
	    
		if ((form1.student.value == "")||(!isNaN(form1.student.value)))
		{
		alert("Please Enter Student Name in Words")
		form1.student.focus()
		return false
		}
}



</SCRIPT>

<jsp:include page="home.html"/>
<jsp:useBean id="obj" class="vik.Admin5"/>

<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>
<body background='images/index_07-081.jpg'>

<table border="0" width="100%" height="400" bgcolor="" background="images/1.jpg">
<tr>
  <td width="20%" background="images/index_07-081.jpg"><a href="Admin1.jsp"><div align="center">ADMIN HOME</div></a><%obj.details();%>  
    </td><td background="images/index_07-081.jpg"  height="200"><div align="center"><%obj.student();%></div></td></tr></table>
</body>