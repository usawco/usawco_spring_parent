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
	var counter1 = 0;
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
	function addFileElemetInForm() {
		//var innerHML = document.getElementById('fileSpan').innerHTML;
		var fileControl = document.createElement("input");
		fileControl.setAttribute("type", "file");
		fileControl.setAttribute("id", "myFile"+counter);	
		fileControl.setAttribute("name", "myFile"+counter+"[]");
		fileControl.setAttribute("multiple", "multiple");
		fileControl.setAttribute("onChange", "updateSelectedFile()");
		fileControl.setAttribute("style", "display:block");
		document.getElementById('fileSpan').appendChild(fileControl);

	}
	function updateSelectedFile() {
		var innerHTM = '';
		 var x = document.getElementById("myFile"+counter).files;
			for(var i=0; i<x.length ;i++) {
				innerHTM = innerHTM+'<input type="checkbox" name="selectedFileChk" checked id="selectedFileChk" value="'+x[i].name+'" />'+x[i].name+'<br/>';
			}
		var selectedSpanInnerHML = document.getElementById('selectedSpan').innerHTML;
		document.getElementById('selectedSpan').innerHTML = selectedSpanInnerHML+innerHTM;

		document.getElementById("myFile"+counter).style.display = 'none';
		counter = counter + 1;
		addFileElemetInForm();
	}
	
	function addFileElemetInForm1() {

		var fileControl = document.createElement("input");
		fileControl.setAttribute("type", "file");
		fileControl.setAttribute("id", "zipFile"+counter1);	
		fileControl.setAttribute("name", "zipFile"+counter1+"[]");
		fileControl.setAttribute("multiple", "multiple");
		fileControl.setAttribute("onChange", "updateSelectedFile1()");
		fileControl.setAttribute("style", "display:block");
		document.getElementById('zipSpan').appendChild(fileControl);
		

	}
	function updateSelectedFile1() {
		var innerHTM = '';
		 var x = document.getElementById("zipFile"+counter1).files;
			for(var i=0; i<x.length ;i++) {
				innerHTM = innerHTM+'<input type="checkbox" name="selectedFileChk" checked id="selectedFileChk" value="'+x[i].name+'" />'+x[i].name+'<br/>';
			}
		var selectedSpanInnerHML = document.getElementById('zipSelectedSpan').innerHTML;
		document.getElementById('zipSelectedSpan').innerHTML = selectedSpanInnerHML+innerHTM;

		document.getElementById("zipFile"+counter1).style.display = 'none';
		counter1 = counter1 + 1;
		addFileElemetInForm1();
	}

	function changeFixVersion() {
		var selectObj = document.getElementById('fixType');
		var idx = selectObj.selectedIndex; 

		var which = selectObj.options[idx].value; 
		var fixVersionTextObj = document.getElementById('fixVersionText');
		fixVersionTextObj.innerHTML = which+" Version";
	}
	
</script>

	<body onLoad="setNavigation('upload-files.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=ABC);">
	
    <table width="100%">
		<tr>
			<td class="menusection-Settings" colspan="2"> 
				Fix Building &gt;  Generate Fix
			</td>
		</tr>
	</table>
		%ifvar operation equals('queryItracData')%
			%invoke FixBuilding.com.sag.Manager:getItracInfo%
				%ifvar message%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan="2">%value message%</td></tr>
				%endif%
				%onerror%
					<script>
						document.location.replace("advanced-home.dsp?saveErrorMessage=%value -urlencode errorMessage%");
					</script>
					
			%endinvoke%
		%endif%	 	
		<div id="upload" style="display:none"></div>
		 <table width="100%">
		 <tr>
		   <td colspan="2">
				<ul>
					<li><a href="/invoke/FixBuilding.com.sag.Manager/downloadReadme?readmeFileName=readme.txt">Download Readme Template</a></li>
					
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
								<td class="oddrow">iTrac ID<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<input name="iTracID" id="iTracID" type="text" value="%value iTracID%" size="100">
								</td>
							</tr>
							<tr>
								<td class="evenrow">Support Incident ID<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									%ifvar pivotalIds%
										<select size="1" name="supportIncidentID" id="supportIncidentID">
											%loop pivotalIds%
												<option value="%value%">%value%</option>
											%endloop%	
										</select>
									%else%
										<input name="supportIncidentID" id="supportIncidentID" type="text" value="%value supportIncidentID%" size="100">
									%endif%
								</td>
							</tr>
							
							<tr>
								<td class="oddrow">iTrac Summary<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<input name="iTracSummary" id="iTracSummary" type="text" value="%value iTracSummary%" size="100">
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
									<select size="1" name="fixType" id="fixType" onChange="changeFixVersion()">
										<option value="Test Patch">Test Patch</option>
										<option value="Diagnostics Collector" %ifvar fixType equals('Diagnostics Collector')%selected%endif%>Diagnostics Collector</option>
										<option value="Hotfix" %ifvar fixType equals('Hotfix')%selected%endif%>Hotfix</option>
									</select>
									
								</td>
							</tr>
							
							<tr>
								<td class="evenrow" id="fixVersionText" name="fixVersionText">Test Patch Version</td>	
								<td class="evenrow-l">
									<input name="fixVersion" id="fixVersion" type="text" value="%value fixVersion%" size="100">
								</td>
							</tr>
							<tr>
								<td class="evenrow">&nbsp;</td>	
								<td class="evenrow-l">
									e.g. IS_8.2_SP1_TestPatch_PIE-12345_v1, here 1 is for v1.
								</td>
							</tr>
							<tr>
								<td class="oddrow">Void Fix List</td>	
								<td class="oddrow-l">
									<textarea name="voidList" id="voidList"  rows="3" cols="100">%value voidList%</textarea>
								</td>
							</tr>
						    
							<tr>
								<td class="evenrow">Precede Fix List</td>	
								<td class="evenrow-l">
									<textarea name="precedeList" id="precedeList"  rows="3" cols="100">%value precedeList%</textarea>
								</td>
							</tr>
							<tr>
								<td class="oddrow">Select Class Files<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
										<span id="fileSpan" name="fileSpan"></span>
										<script>addFileElemetInForm()</script>
								</td>
							</tr>
							<tr>
								<td class="oddrow">Selected Class Files<b><font color="red">*</font></b></td>	
								<td class="oddrow-l">
									<span id="selectedSpan" name="selectedSpan"></span>							
									<span id="fileControlSpan" name="fileControlSpan" style="display:none"></span>
								</td>
							</tr>
							<tr>
								<td class="evenrow">Select Package Zips<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
										<span id="zipSpan" name="zipSpan"></span>
										<script>addFileElemetInForm1()</script>
								</td>
							</tr>
							<tr>
								<td class="evenrow">Selected Package Zips<b><font color="red">*</font></b></td>	
								<td class="evenrow-l">
									<span id="zipSelectedSpan" name="zipSelectedSpan"></span>							
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
										onclick="fileUpload(this.form,'/invoke/FixBuilding.com.sag.Manager:uploadFilesForItrac','upload'); return false;"
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
