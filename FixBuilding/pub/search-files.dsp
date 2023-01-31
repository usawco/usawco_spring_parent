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

	<body onLoad="setNavigation('search-files.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=ABC);">
	
    <table width="100%">
		<tr>
			<td class="menusection-Settings" colspan="2"> 
				Fix Building &gt;  Upload Fix to SUM &gt; Search Fix
			</td>
		</tr>
		%ifvar saveErrorMessage%
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td class="message" colspan="2">%value saveErrorMessage%</td></tr>
		%endif%
		<tr>
			<td>
			<form name="htmlform_glConfig" action="download-files.dsp" method="POST">
			
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
								<td class="evenrow">iTrac ID<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<input name="searchItracID" id="searchItracID" type="text" value="%value searchItracID%" size="100">
								</td>
							</tr>

							<tr>
								<td class="oddrow">Target IS Version<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">

									<select size="1" name="targetVersion" id="targetVersion">
										%invoke FixBuilding.com.sag.Manager:getSupportedVersions%
											%loop supporedVersions%
												<option value="%value%">%value%</option>
											%endloop%	
										%endinvoke%
									</select>
								</td>
								</td>
							</tr>
							
							<tr>
								<td class="action" colspan=3>
									<input type="submit" name="submit1" value="Search" onclick="return validate(this.form);">
								</td>
							</tr>
						</table>
					</td>
				
				</tr>
				
			</form>
			</table>
			</td>
		</tr>
		
    </table>
	
  </body> 	
</head>
