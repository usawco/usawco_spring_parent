<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta http-equiv="Expires" content="-1">
  <LINK REL="stylesheet" TYPE="text/css" HREF="/WmRoot/webMethods.css">
  <script src="/WmRoot/webMethods.js"></script>
<script language="Javascript">
	var counter = 0;
	function fileUpload(form, action_url, div_id) {

		var iframe = document.createElement("iframe");
		iframe.setAttribute("id", "upload_iframe");
		iframe.setAttribute("name", "upload_iframe");
		iframe.setAttribute("width", "0");
		iframe.setAttribute("height", "0");
		iframe.setAttribute("border", "0");
		iframe.setAttribute("style", "width: 0; height: 0; border: none;");
		form.parentNode.appendChild(iframe);
		window.frames['upload_iframe'].name = "upload_iframe";
		iframeId = document.getElementById("upload_iframe");
		var eventHandler = function() {
			if (iframeId.detachEvent)
				iframeId.detachEvent("onload", eventHandler);
			else
				iframeId.removeEventListener("load", eventHandler, false);
			if (iframeId.contentDocument) {
				content = iframeId.contentDocument.body.innerHTML;
			} else if (iframeId.contentWindow) {
				content = iframeId.contentWindow.document.body.innerHTML;
			} else if (iframeId.document) {
				content = iframeId.document.body.innerHTML;
			}
			if (content != null) {
			
				document.getElementById(div_id).style.display='block';
				//if (content.indexOf("success") > 0) {
					document.getElementById(div_id).innerHTML = '<table width="100%"><tr><td colspan="2">&nbsp;</td></tr><tr><td class="message" colspan="2">'+content+'</td></tr></table>';
				//} else {
					//document.getElementById(div_id).innerHTML = '<table width="100%"><tr><td colspan="2">&nbsp;</td></tr><tr><td class="message" colspan="2">'+content+'</td></tr></table>';
			
			}
			setTimeout('iframeId.parentNode.removeChild(iframeId)', 250);
		}
		if (iframeId.addEventListener)
			iframeId.addEventListener("load", eventHandler, true);
		if (iframeId.attachEvent)
			iframeId.attachEvent("onload", eventHandler);
		form.setAttribute("target", "upload_iframe");
		form.setAttribute("action", action_url);
		form.setAttribute("method", "post");
		form.setAttribute("enctype", "multipart/form-data");
		form.setAttribute("encoding", "multipart/form-data");
		form.submit();
		//document.getElementById(div_id).innerHTML = "Uploading...";
	}

</script>

	<body onLoad="setNavigation('generate-fix-package.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=ABC);">
	
    <table width="100%">
		<tr>
			<td class="menusection-Settings" colspan="2"> 
				Fix Building &gt;  Generate Package Fix
			</td>
		</tr>
	</table>	
		<div id="upload" style="display:none"></div>
		 <table width="100%">
		 <tr>
		   <td colspan="2">
				<ul>
					<li><a href="/invoke/FixBuilding.com.sag.Manager/downloadReadme?readmeFileName=readme_pkg.txt">Download Readme Template</a></li>
					
				</ul>
			</td>
		</tr>
		<tr>
			<td>
			<form name="htmlform_a">
			
			<table>
				<tr>
					<td width="10px">
						<img src="/WmRoot/images/blank.gif"  border=0>
					</td>
					<td>	
						<table class="tableView" width="100%">
							<tr>
								<td class="heading" colspan="2">Fix Properties</td>
							</tr>
							<tr>
								<td class="evenrow">iTrac ID<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<input name="iTracID" id="iTracID" type="text" value="%value iTracID%" size="100">
								</td>
							</tr>
							<tr>
								<td class="oddrow">Support Incident ID<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<input name="supportIncidentID" id="supportIncidentID" type="text" value="%value supportIncidentID%" size="100">
								</td>
							</tr>
							
							<tr>
								<td class="evenrow">Target IS Version<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<select size="1" name="targetVersion" id="targetVersion">
									%invoke FixBuilding.com.sag.Manager:getSupportedVersions%
									%loop supporedVersions%
										<option value="%value%">%value%</option>
									%endloop%	
									%endinvoke%
									</select>
									
								</td>
							</tr>
							
							<tr>
								<td class="oddrow">Target Package<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<input type="text" name="targetPackage" id="targetPackage" value="%value voidList%">
								</td>
							</tr>
							<tr>
								<td class="evenrow">Required Core Fix Number</td>	
								<td class="evenrow-l">
									<input name="requireCoreFix" id="requireCoreFix" type="text" value="%value requireCoreFix%" size="100">
								</td>
							</tr>
							
							<tr>
								<td class="oddrow">Fix Type<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<select size="1" name="fixType" id="fixType">
										<option value="Test Patch">Test Patch</option>
										<option value="Diagnostics Collector" %ifvar fixType equals('Diagnostics Collector')%selected%endif%>Diagnostics Collector</option>
										<option value="Hotfix" %ifvar fixType equals('Hotfix')%selected%endif%>Hotfix</option>

									</select>
									
								</td>
							</tr>
							<tr>
								<td class="evenrow">Package Zip<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<input type="file" name="packageZip" id="packageZip">
								</td>
							</tr>
							<tr>
								<td class="oddrow">Read Me<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<input type="file" name="readMe" id="readMe">
								</td>
							</tr>
							<tr>
								<td class="action" colspan=3>
									<input
										value="Generate"
										onclick="fileUpload(this.form,'/invoke/FixBuilding.com.sag.Manager:generatePackageFix','upload'); return false;"
										type="button">
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
