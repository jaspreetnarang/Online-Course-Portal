<SCRIPT language=javascript>
function validationTxt()
{

		
		

	
		if((form1.coll.value == "") || (form1.coll.value == null)||(!isNaN(form1.coll.value)))
		{
				alert("Please Enter College Name in Words")
				form1.coll.focus()
				return false
		}
	    
		if((form1.place.value == null)||(form1.place.value == "")||(!isNaN(form1.place.value)))
		{
		alert("Please Enter PlacedAt in Words")
		form1.place.focus()
		return false
		}
		
		if((form1.cph.value == "") || (form1.cph.value == null)||(isNaN(form1.cph.value)))
		{
				alert("Please Enter College Contect in Number")
				form1.cph.focus()
				return false
		}
	    
		if((form1.fax.value == "") || (form1.fax.value == null)||(isNaN(form1.fax.value)))
		{
				alert("Please Enter College Fax Number in Number")
				form1.fax.focus()
				return false
		}
		
		if((form1.princ.value == "") || (form1.princ.value == null)||(!isNaN(form1.princ.value)))
		{
				alert("Please Enter Principle Name in Words")
				form1.princ.focus()
				return false
		}
		
		if((form1.pno.value == "") || (form1.pno.value == null)||(isNaN(form1.pno.value)))
		{
				alert("Please Enter Principle Contect in Number")
				form1.pno.focus()
				return false
		}

		if((form1.mail.value == "") || (form1.mail.value == null)||(!isNaN(form1.mail.value)))
		{
				alert("Please Enter Principle Mail@ Id Words")
				form1.mail.focus()
				return false
		}
		
		if((form1.login.value == "") || (form1.login.value == null)||(!isNaN(form1.login.value)))
		{
				alert("Please Enter Initial Login Name in Words")
				form1.login.focus()
				return false
		}
	    
	    
		if((form1.pass.value == "") || (form1.pass.value == null))
		{
				alert("Please Enter Initial Passsword")
				form1.pass.focus()
				return false
		}
	    	    	    	    
}



</SCRIPT>

<jsp:include page="home.html"/>
<jsp:useBean id="obj" class="vik.Admin3"/>

<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>


<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
</style>
<body background='images/index_07-081.jpg'>
<TABLE WIDTH='100%' background='images/1.jpg'><TR><TD >
<DIV ALIGN="CENTER">
<table width='100%' background='images/index_07-081.jpg' height='100'  border='1' bordercolor='' cellspacing='1'>
<tr><td background='images/index_07-081.jpg' width='20%' height=150' rowspan='2'  >
<table  width='100%' height='350' border='0'   cellspacing='1' bgcolor=''>
<tr><td width='10%' height='15%' ><div align='center' class='style1 style2'><strong>ADMIN AUTHORITY</strong></div></td></tr>
<tr><td height='18%' ><div align='center'><a href='Admin1.jsp'><strong>RESULT VIEW</strong></a></div></td>
</tr><tr><td height='18%' ><div align='center'><a href='Admin2.jsp'><strong>COURSES</strong></a></div></td>
</tr><tr><td height='18%' ><div align='center'><a href='Admin3.jsp'><strong>COLLEGES</strong></a></div></td></tr>
<tr><td height='18%' ><div align='center'><a href='Admin4.jsp'><strong>FACULTIES</strong></a></div></td></tr>
<tr><td height='18%' ><div align='center'><a href='Admin5.jsp'><strong>NEW RESULT UPLOAD</strong></a></div></td></tr>
<tr><td height='18%'><div align='center'><a href='Admin6.jsp'><strong>ADMISSION FORMS</strong></a></div></td></tr></table>
</td><td width='70%' bgcolor=''><div align='CENTER' class='style1'><a href='Admin7.jsp'><strong>CHANGE PASSWORD</strong></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='Logout.jsp'><strong>LOG OUT</strong></a></div></td></tr>
<tr><td height='144' background='images/index_07-081.jpg' bgcolor=''><div align='center'><%obj.details();%></div></td></tr></table>
</DIV></TD></TR>
</TABLE>
</body>