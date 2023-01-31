<HTML>

<HEAD>

<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<META HTTP-EQUIV="Expires" CONTENT="-1">


<LINK REL="stylesheet" TYPE="text/css" HREF="/WmRoot/webMethods.css">
    <style>
      blink {
        animation: blinker 1s linear infinite;
        color: red;
       }
      @keyframes blinker {  
        50% { opacity: 0; }
       }
       .blink-one {
         animation: blinker-one 1s linear infinite;
       }
       @keyframes blinker-one {  
         0% { opacity: 0; }
       }
       .blink-two {
         animation: blinker-two 1.4s linear infinite;
       }
       @keyframes blinker-two {  
         100% { opacity: 0; }
       }
    </style>
</HEAD>


<script>
function launchHelp() {
    if (parent.menu != null){
        window.open(parent.menu.document.forms["urlsaver"].helpURL.value, 'help', "directories=no,location=yes,menubar=yes,scrollbars=yes,status=yes,toolbar=yes,resizable=yes", true);
    }
}


function loadPage(url)
{
	window.location.replace(url);
}


%ifvar message%
  %ifvar norefresh%%else%
    setTimeout("loadPage('top.dsp')", 30000);
        %endif%
%endif%



</script>

   <BODY  class="topbar" topmargin="0" leftmargin="0" marginwidth="0" marginheight="0">


<table border=0 cellspacing=0 cellpadding=0 height=47 width=100%>
<tr>
<td>

      <TABLE height=14 width=100% CELLSPACING=0 BORDER=0>

         <TR>

            <TD nowrap class="toptitle" width="50%">

              %value $host%
              ::
              Integration Server
              ::
              Fix Building
			  
            </TD>
			<TD nowrap class="toptitle" width="50%" align="right">
				%invoke FixBuilding.com.sag.Manager:getCounter%
					<font color="blue" size="2">Total Fixes Generated -- %value counter% &nbsp;</font>
				%endinvoke%

            </TD>

         </TR>
		<TR>
	
            <TD nowrap class="toptitle" align="center" width="100%">

				<blink><font color="red" size="2">Download latest Readme templates...</font></blink>
			  
            </TD>


         </TR>
      </TABLE>
</td>
</tr>
<tr height=100%>
<td>

<TABLE width=100% height=33 CELLSPACING=0 BORDER=0>

         <TR>
         	 <TD nowrap width=100% class="topmenu"></TD>

                 <TD nowrap valign="bottom" class="topmenu">
                 
	         <A  href='javascript:window.parent.close();'>Close Window</A>
          
                
            </TD>

         </TR>
         <TR>

         </TR>
      </TABLE>

</td>
</tr>
</table></BODY>
</HTML>


