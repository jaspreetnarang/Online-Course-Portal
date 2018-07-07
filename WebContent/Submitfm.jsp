<jsp:include page="home.html"/>

<jsp:useBean id="obj" class="vik.Forms"/>
<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>

<SCRIPT language=javascript>
function validationTxt()
{

 if ((form1.student.value == "")||(form1.student.value == null)||(!isNaN(form1.student.value)))
{
		alert("Please Enter Your Name in Words")
		form1.student.focus()
		return false
		
			}
		

 if ((form1.father.value == "")||(form1.father.value == null)||(!isNaN(form1.father.value)))
{
		alert("Please Enter Your Guardian Name in Words")
		form1.father.focus()
		return false
		}

if ((form1.dob.value == "")||(form1.dob.value == null))
{
		alert("Please Enter Your Date of birth D/M/Y")
		form1.dob.focus()
		return false
		}

if ((form1.ten.value == "")||(form1.ten.value == null)||(isNaN(form1.ten.value)))
{
		alert("Please Enter Your Tenth Marks in Numerals (%)")
		form1.ten.focus()
		return false
		}

	
if ((form1.twe.value == "")||(form1.twe.value == null)||(isNaN(form1.twe.value)))
{
		alert("Please Enter Your Twelth Marks in Numerals (%)")
		form1.twe.focus()
		return false
		}

if ((form1.address.value == "")||(form1.address.value == null)||(!isNaN(form1.address.value)))
{
		alert("Please Enter Your Address in Words")
		form1.address.focus()
		return false
		}
if ((form1.city.value == "")||(form1.city.value == null)||(!isNaN(form1.city.value)))
{
		alert("Please Enter Your City Name in Words")
		form1.city.focus()
		return false
		}
if ((form1.state.value == "")||(form1.state.value == null)||(!isNaN(form1.state.value)))
{
		alert("Please Enter Your State in Words")
		form1.state.focus()
		return false
		}
	

if ((form1.pin.value == "")||(form1.pin.value == null)||(isNaN(form1.pin.value)))
{
		alert("Please Enter Your Pin-Code in Numerals")
		form1.pin.focus()
		return false
		}
if ((form1.contect.value == "")||(form1.contect.value == null)||(isNaN(form1.contect.value)))
{
		alert("Please Enter Your Contact Number in Numerals")
		form1.contect.focus()
		return false
		}

}

</SCRIPT>

<style type="text/css">
<!--
.style6 {color: #0066FF}
.style7 {font-size: 36px}
.style11 {font-size: 18px}
.style15 {font-size: 24px; color: #0066FF; }
.style17 {
	color: #33FF99;
	font-size: 24px;
}
.style19 {
	color: #00FFFF;
	font-size: 24px;
	font-weight: bold;
}
.style20 {color: #00FFFF}
.style22 {color: #00FFFF; font-weight: bold; }
.style25 {color: #00FFCC}
.style26 {font-size: 18px; color: #00FFFF;}
-->
</style>
<body>
<table width="100%"  border="1">
  <tr>
    <td background="images/index_07-081.jpg">

<form name=form1 action='Resister.jsp?name=1'>
  <table width='91%' height='424'  border='0'>
    <tr><td height='50' colspan='2'><div align='center' class="style3 style1 style6 style7"><ul class="style20">STUDENT ADMISSION FORM</ul>
    </div></td>
  </tr><tr><td width='50%' height='10'><div align="right" class="style15">
        <%String cn=obj.coll();%><%application.setAttribute("sec",cn);
  String id=obj.id();
  application.setAttribute("id",id);%>
            
  </div></td>
  <td width='40%'></span></td>
  </tr><tr><td height='58' colspan='2'><div align='center' class="style19" >PERSONAL DETAILS</div></td>
  </tr>
  <tr><td height='27'><div align="right"><span class="style4 style2 style11  style25">APPLICANT NAME:</span>
            <input type='text' name='student' >
  </div></td>
  <td height='27'><div align="right"><span class="style4 style2  style26">PERMANENT ADDRESS:</span>        
    <input type='text' name='address'>
  </div></td>
  </tr><tr><td height='28'><div align="right"><span class="style26">FATHER/GUARDIAN NAME:</span>              
        <input type='text' name='father'>
  </div></td>
  <td height='28'><div align="right"><span class="style20 style2 style4 style11">CITY:</span><strong>&nbsp;</strong>
        <input type='text' name='city'>
  </div></td>
  </tr><tr><td height='13'><div align="right"><span class="style20 style2 style4 style11">DATE OF BIRTH (D/M/Y):</span>          
        <input type='text' name='dob'>
  </div></td>
  <td height='13'><div align="right"><span class="style20 style2 style4 style11">STATE:</span><strong>&nbsp;</strong>
      <input type='text' name='state'>
  </div></td>
  </tr><tr><td height='14'><div align="right"><span class="style20 style2 style4 style11">GENDER:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <select name='sex'>
                  <option>MALE</option>
                  <option>FEMALE</option>
              </select>
  </div>  </div></td>
  <td height='14'><div align="right"><span class="style20 style2 style4 style11">PIN CODE:</span>        
    <input type='text' name='pin'>
  </div></td>
  </tr><tr><td height='30'><div align="right"><span class="style20 style2 style4  style11">COURSE:</span><strong>&nbsp;</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <select name='course'><%obj.course();%>
          </select>  </div></td>
  <td height='30'><div align="right"><span class="style20 style2 style4 style11">CONTACT  NO:</span>        
      <input type='text' name='contect'>
  </div></td>
  </tr><tr><td height='56' colspan='2'><div align='center' class="style6 style7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="style3 style1 style6 style7">&nbsp;<span class="style17">&nbsp;<span class="style22">EDUCATION DETAILS</span></span></span> </div></td>
  </tr>
  <tr><td height='33'><div align="right"><span class="style20 style5"><strong>10TH MARKS(%):</strong></span>          
        <input type='text' name='ten'>
  </div></td>
    <td height='33'>&nbsp;</td>
  </tr><tr><td height='48'><div align="right"><span class="style20 style5"><strong>12TH MARKS(%):</strong></span>          
        <input type='text' name='twe'>
</div></td>
  <td height='18'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <div align="center">
            <input name='Submit' onclick="return validationTxt()" type='submit' class="style1" value='REGISTER'>
        </div></td></tr></table>
</form></td>
  </tr>
</table>
</body>