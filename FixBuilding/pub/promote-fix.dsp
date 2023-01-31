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
  </script>

	<body onLoad="setNavigation('promote-fix.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=ABC);">
	
    <table width="100%">
		<tr>
			<td class="menusection-Settings" colspan="2"> 
				Fix Building &gt;  Promote fix
			</td>
		</tr>
		%ifvar operation equals('promote')%
			%invoke FixBuilding.com.sag.Manager:promoteFix%
				%ifvar message%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan="2">%value message%</td></tr>
				%endif%
				%onerror%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan=2>%value errorMessage%</td></tr>
			%endinvoke%
		%endif%
		<tr>
			<td>
			<form name="htmlform_glConfig" action="promote-fix.dsp" method="POST">
			
			<table>
				<tr>
					<td width="10px">
						<img src="/WmRoot/images/blank.gif"  border=0>
					</td>
					<td>	
						<table class="tableView" width="100%">
							<tr>
								<td class="heading" colspan="2">Search Properties</td>
							</tr>
							<tr>
								<td class="evenrow">Fix Key<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<input name="fixKey" id="fixKey" type="text" value="%value fixKey%" size="100">
								</td>
							</tr>

							
							
							<tr>
								<td class="action" colspan=3>
									<input type="submit" name="submit1" value="Promote" onclick="return validate(this.form);">
								</td>
							</tr>
						</table>
					</td>
				
				</tr>
				<input type="hidden" name="operation" id="operation" value="promote"/>
			</form>
			</table>
			</td>
		</tr>
		
    </table>
	
  </body> 	
</head>
