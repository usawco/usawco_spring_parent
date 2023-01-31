<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta http-equiv="Expires" content="-1">
  <LINK REL="stylesheet" TYPE="text/css" HREF="/WmRoot/webMethods.css">
  <script src="/WmRoot/webMethods.js"></script>
<script language="Javascript">
	function validate(fm) {
		return true;
	}
</script>

	<body onLoad="setNavigation('common-properties.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=ABC);">
	
    <table width="100%">
		<tr>
			<td class="menusection-Settings" colspan="2"> 
				Fix Building &gt;  Configuration
			</td>
		</tr>
			%ifvar operation equals('setCommonProperties')%
			%invoke FixBuilding.com.sag.Manager:setCommonProperties%
				%ifvar message%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan="2">%value message%</td></tr>
				%endif%
				%onerror%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan=2>%value errorMessage%</td></tr>
			%endinvoke%
		%endif%	
	     %invoke FixBuilding.com.sag.Manager:getCommonProperties%
				%ifvar message%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan="2">%value message%</td></tr>
				%endif%
				%onerror%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan=2>%value errorMessage%</td></tr>
			%endinvoke%
		 
 
	</table>	
		<div id="upload" style="display:none"></div>
		 <table width="100%">
		<tr>
			<td>
			<form name="htmlform_a"action="common-properties.dsp" method="POST">
			
			<table>
				<tr>
					<td width="10px">
						<img src="/WmRoot/images/blank.gif"  border=0>
					</td>
					<td>	
						<table class="tableView" width="100%">
							<tr>
								<td class="heading" colspan="2">Properties</td>
							</tr>
							<tr>
								<td class="oddrow">Repo Url<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<input name="repoUrl" id="repoUrl" type="text" value="%value repoUrl%" size="100">
								</td>
							</tr>
							<tr>
								<td class="evenrow">Promote Fix Url<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<input name="promoteFixUrl" id="promoteFixUrl" type="text" value="%value promoteFixUrl%" size="100">
								</td>
							</tr>
							<tr>
								<td class="oddrow">Repo Username<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<input name="repoUsername" id="repoUsername" type="text" value="%value repoUsername%" size="100">
								</td>
							</tr>
							
							<tr>
								<td class="evenrow">Repo Password<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<input name="repoPassword" id="repoPassword" type="password" value="%value repoPassword%" size="100">
								</td>
							</tr>
							
							<tr>
								<td class="oddrow">Repo Name<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<input name="repoName" id="repoName" type="text" value="%value repoName%" size="100">
								</td>
							</tr>

							<tr>
								<td class="evenrow">Supported Versions<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<textarea name="supporedVersions" id="supporedVersions"  rows="3" cols="100">%value supporedVersions%</textarea>
								</td>
							</tr>
						  <input type="hidden" name="operation" id="operation" value="setCommonProperties"/>
							<tr>
								<td class="action" colspan=3>
									<input type="submit" name="submit" value="Save Changes" onclick="return validate(this.form);">
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
