<html>
<head>
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta http-equiv="Expires" content="-1">
  <LINK REL="stylesheet" TYPE="text/css" HREF="/WmRoot/webMethods.css">
  <script src="/WmRoot/webMethods.js"></script>
  <script>
	function validate(form_obj) {
		return true;
	}
	function skip() {
		document.location.replace('upload-files.dsp');
	}
  </script>

	<body onLoad="setNavigation('search-files.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=ABC);">
	
    <table width="100%">
		<tr>
			<td class="menusection-Settings" colspan="2"> 
				Fix Building &gt;  Generate Fix
			</td>
		</tr>
		%ifvar saveErrorMessage%
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td class="message" colspan="2">%value saveErrorMessage%</td></tr>
		%endif%
		<tr>
			<td>
			<form name="htmlform_glConfig" action="upload-files.dsp" method="POST">
			
			<table>
				<tr>
					<td width="10px">
						<img src="/WmRoot/images/blank.gif"  border=0>
					</td>
					<td>	
						<table class="tableView" width="100%">
							<tr>
								<td class="heading" colspan="2">iTrac Info</td>
							</tr>
							<tr>
								<td class="evenrow">iTrac ID<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<input name="searchItracID" id="searchItracID" type="text" value="%value searchItracID%" size="100">
								</td>
							</tr>
							<tr>
								<td class="evenrow">&nbsp;</td>	
								<td class="evenrow-l">
									Note : Click on <b>Next</b> to retrieve iTrac details, Click on <b>Skip</b> if iTrac is down or you want to enter iTrac details manually
								</td>
							</tr>
							
							
							<tr>
								<td class="action" colspan=2>
									<input type="submit" name="submit1" value="Next" onclick="return validate(this.form);">
									&nbsp;&nbsp;<input type="button" value="Skip" onclick="skip();">
								</td>

							</tr>
						</table>
					</td>
				
				</tr>
				<input type="hidden" name="operation" value="queryItracData">
			</form>
			</table>
			</td>
		</tr>
		
    </table>
	
  </body> 	
</head>
