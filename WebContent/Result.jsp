<jsp:include page="home.html"/>
<jsp:useBean id="obj" class="vik.Result"/>
<jsp:setProperty name= "obj" property="out" value="<%=out%>"/>
<jsp:setProperty name= "obj" property="*"/>
<STYLE type=text/css>
P {
	FONT-SIZE: 6px; COLOR: #4a4a4a; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}
H1 {
	FONT-WEIGHT: normal; FONT-SIZE: 19pt; MARGIN: 0in 0in 0pt; LINE-HEIGHT: 200%; FONT-FAMILY: "DevLys 010"; TEXT-ALIGN: justify
}
H4 {
	FONT-SIZE: 12pt; MARGIN: 0in 0in 0pt; FONT-FAMILY: "Times New Roman"; LETTER-SPACING: 0.1pt; POSITION: relative; TOP: -1pt; TEXT-ALIGN: center; TEXT-DECORATION: underline; text-underline: single
}

UL {
	PADDING-RIGHT: 2px; PADDING-LEFT: 2px; PADDING-BOTTOM: 2px; MARGIN: 2px; PADDING-TOP: 2px; BORDER-BOTTOM: #acc0cc 1px dotted; LIST-STYLE-TYPE: none
}
LI {
	BACKGROUND-POSITION: 0px 0.4em; PADDING-LEFT: 14px; FONT-SIZE: 12px; BACKGROUND-IMAGE: url(images/1.jpg); PADDING-BOTTOM: 10px; COLOR: #475476; BACKGROUND-REPEAT: no-repeat; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}
body,td,th {
	font-size: 100%;
	color: #00FF99;
	font-style: italic;
}
body {
	background-image: url(images/index_07-081.jpg);
}
a:link {
	color: #FFFFFF;
	font-style: italic;
}
a:visited {
	color: #00FF99;
}
a:hover {
	color: #FFFFFF;
}
a:active {
	color: #FFFFFF;
}
.style9 {
	color: #FFFFFF;
	font-size: 102%;
}
.style10 {color: #FFFFFF}
.style13 {font-size: 12pt}
.style14 {font-size: 14pt}
.style15 {
	font-size: 24pt;
	color: #0000FF;
}

body {
	background-image: url(images/index_07-081.jpg);
}
<!--
body {
	background-image: url(images/index_07-081.jpg);
}
.style16 {
	color: #FF0000;
	font-weight: bold;
}
.style17 {color: #00FF99}
.style19 {font-size: 12pt; color: #00FFFF; }
.style22 {color: #00FFFF}
.style24 {color: #00FFFF; font-weight: bold; }
-->

</STYLE>
<SCRIPT language=javascript>
function validationTxt()
{

		 if (form1.txtCourseName.value == 0)
		{
		alert("Please Select Your Course Name")
		form1.txtCourseName.focus()
		return false
		}

		if (form1.txtSession.value == 0)
		{
		alert("Please Select Session")
		form1.txtSession.focus()
		return false
		}

		if (form1.txtYear.value == 0)
		{
		alert("Please Select Year ")
		form1.txtYear.focus()
		return false
		}

	
		if ((form1.txtRoll.value == "") || (form1.txtRoll.value == null))
		{
				alert("Please Enter Your Roll No.")
				form1.txtRoll.focus()
				return false
		}
	    
		if ( isNaN(form1.txtRoll.value))
		{
				alert("Please Enter Your Roll No. in Number")
				form1.txtRoll.focus()
				return false
		}
}



</SCRIPT>

<META content="MSHTML 6.00.2900.2180" name=GENERATOR></HEAD>
<BODY>
<DIV align=center>
  <table width="100%" height="100%" border="1">
  <tr>
    <td height="581"><div  align="justify" class="style9">
      <TABLE style="BORDER-COLLAPSE: collapse" borderColor=#ffffff  
cellSpacing=0 borderColorDark=#000000 cellPadding=0 width="100%"  
borderColorLight=#000000 border=0>
        <TBODY>
          <TR>
            <TD width=985 height=401><div align="center">
              <p>               
              <div align="center">
                <div align="center" class="style10 style15"><B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</B><span class="style22"><U><FONT face=Arial>University Examination Result </FONT><FONT face=Arial></FONT></U></span></div>
              </div> 
              </p>
              </div>              
              <CENTER>
                </CENTER><div  align="center">
                <FORM name=form1 action="Result1.jsp" method=post>
                  <TABLE height=211 width="101%" border=0>
                    <TBODY>
                      <TR>
                        <TD height=16 colspan="2"><div align="center">
                          <p>&nbsp;</p>
                          <p>
                          <div align="center" ><b><font face="Arial"><span class="style1 style13 style17"><span class="style22">Course Name&nbsp;&nbsp;&nbsp;&nbsp; :</span>                                  
                            <select 
            style="FONT-WEIGHT: bold" size=1 
              name=txtCourseName>
                                  <option value=0 selected>Select Course</option>
                                  <%obj.course();%>
					              </select>
                          </span></font></b></div>
                          <B><FONT face=Arial><span class="style13">&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp; </FONT></B><FONT face=Arial>
                                  
&nbsp;&nbsp;&nbsp;</FONT></p>
                          </div>                          
                        <p><FONT face=Arial>
                            </FONT></p></TD>
                        </TR>
                      <TR>
                        <TD width="51%" height=76><div align="center">
                          <p>&nbsp;</p>
                          <p><FONT face=Arial><B><span class="style1 style13 style22">Year :</span><span class="style17">&nbsp;</span> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; </B>
                                  <SELECT style="FONT-WEIGHT: bold" size=1 
            name=txtYear>
                                    <OPTION value=0 selected>YEAR</OPTION>
                                    <%obj.year();%>
                                  </SELECT>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT></p>
                        </div></TD>
                        <TD width="49%" height=76><p>&nbsp;</p>
						<p><FONT face=Arial><span class="style1"><span class="style16"><span class="style19">Session :</span><span class="style17">&nbsp;</span></span>&nbsp;</span>&nbsp;&nbsp;&nbsp;
                                <SELECT 
            style="FONT-WEIGHT: bold" size=1 name=txtSession>
	<option value=0 selected>Select Session</option>                 
                 <%obj.session();%>
</SELECT>
                          </FONT></p></TD>
                      </TR>
                    </TBODY>
                  </TABLE>
                  <P 
      align=center 
      style="MARGIN: 6px 4px; WORD-SPACING: 1px; TEXT-INDENT: 0px; LINE-HEIGHT: 150%">        
                  <div align="center"><FONT face=Arial><span class="style1"><B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</B></span><span class="style24">Roll No. &nbsp;:</span><span class="style1">&nbsp;</span>&nbsp;
                        <INPUT 
      style="FONT-WEIGHT: bold" maxLength=10 size=10 
      name=txtRoll>
                  </FONT></div>
                  <p></P>
                  <P 
      style="MARGIN: 6px 4px; WORD-SPACING: 1px; TEXT-INDENT: 0px; LINE-HEIGHT: 150%" 
      align=center><FONT face=Arial><LEFT>&nbsp;&nbsp;&nbsp;&nbsp;</FONT></P>
                  <LEFT>
                  <P 
      align=right 
      style="MARGIN: 6px 2px; WORD-SPACING: 1px; TEXT-INDENT: 0px; LINE-HEIGHT: 150%">        
                  
                  <div align="center">
                      <font face="Arial">
          <INPUT style="FONT-WEIGHT: bold" onclick="return validationTxt()" type=submit value=Submit name=B1>
&nbsp;
<INPUT style="FONT-WEIGHT: bold" type=reset value=Reset name=B2>
                      </font></div>
                </FORM>
                </div></TD>
          </TR>
        </TBODY>
      </TABLE>      
      </div></td>
  </tr>
</table>
</DIV>
</BODY></HTML>
