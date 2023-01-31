<html>
<head>
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta http-equiv="Expires" content="-1">
  <link rel="stylesheet" TYPE="text/css" href="/WmRoot/webMethods.css">
  <script src="/WmRoot/webMethods.js"></script>
  <script language="JavaScript">
	function populateForm(form , targetVersion , iTracID, fixName, fileName, fixFor, searchItracID, oper)
	{
		if('delete' == oper)
		{
			if (!confirm ("OK to delete '"+fileName+"'?")) {
				return false;
			}
			form.targetVersion.value = targetVersion;
			form.iTracID.value = iTracID;
			form.fixName.value = fixName;
			form.fileName.value = fileName;
			form.fixFor.value = fixFor;
			form.searchItracID.value = searchItracID;
			form.operation.value = oper;
		}
		if('uploadToSum' == oper || 'uploadToSumAndPromote' == oper)
		{
			if (!confirm ("OK to upload '"+fileName+"'?")) {
				return false;
			}
			form.targetVersion.value = targetVersion;
			form.iTracID.value = iTracID;
			form.fixName.value = fixName;
			form.fileName.value = fileName;
			form.searchItracID.value = searchItracID;
			form.fixFor.value = fixFor;
			form.operation.value = oper;
		}
		return true
	}
	
  </script>
  
  <body onLoad="setNavigation('download-files.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=IS_Settings_GlobalVariables');">
   
    <table width="100%">
		<tr>
			<td class="menusection-Settings" colspan="2"> Fix Building &gt;   Upload Fix to SUM</td>
		</tr>
		%ifvar operation equals('delete')%
			%invoke FixBuilding.com.sag.Manager:deleteFix%
				%ifvar message%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan="2">%value message%</td></tr>
				%endif%
				%onerror%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan=2>%value errorMessage%</td></tr>
			%endinvoke%
		%endif%	 
		%ifvar operation equals('uploadToSum')%
			%invoke FixBuilding.com.sag.Manager:uploadFixToSum%
				%ifvar message%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan="2">%value message%</td></tr>
				%endif%
				%onerror%
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td class="message" colspan=2>%value errorMessage%</td></tr>
			%endinvoke%
		%endif%	 
		%ifvar operation equals('uploadToSumAndPromote')%
			%invoke FixBuilding.com.sag.Manager:uploadToSumAndPromoteFix%
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
				<table width="70%">
					<tr>
						<td width="10px">
							<img src="/WmRoot/images/blank.gif"  border=0>
						</td>
						<td>	
							<table class="tableView" width="100%">
								<tr>
									<td class="heading" colspan="6">Fix Jars</td>
								</tr>
								<tr>					
									<td class="oddcol">Name</td>
									<td class="oddcol">iTrac ID</td>
									<td class="oddcol">Download</td>
									<td class="oddcol">Upload to SUM</td>
									<td class="oddcol">Upload to SUM and Promote</td>
									<td class="oddcol">Delete</td>
								</tr>
								%invoke FixBuilding.com.sag.Manager:listFixJars%
									%loop allFixes%
										<tr>	
											<script>writeTD("rowdata");</script>
												%value fileName%
											</td>										
											<script>writeTD("rowdata");</script>
												%value iTracID%
											</td>
											<script>writeTD("rowdata");</script>
												<a href="/invoke/FixBuilding.com.sag.Manager/downloadFilesForItrac?targetVersion=%value -urlencode ../targetVersion%&iTracID=%value -urlencode iTracID%&fixName=%value -urlencode fixName%&fileName=%value -urlencode fileName%&fixFor=%value -urlencode fixFor%">
													<img src="icons/download.png" border="no">	
												</a> 	
											</td>

											%ifvar fixType equals('sum')%
												<script>writeTD("rowdata");</script>
													<a href="javascript:document.delete_form.submit();" onClick="return populateForm(document.delete_form,'%value -urlencode ../targetVersion%','%value -urlencode iTracID%','%value -urlencode fixName%','%value -urlencode fileName%','%value -urlencode fixFor%','%value -urlencode ../searchItracID%','uploadToSum');">
														<img src="icons/upload.png" border="no">	
													</a> 	
												</td>
											%else%
												<script>writeTD("rowdata");</script>
													
												</td>
											%endif%
											%ifvar fixType equals('sum')%
												<script>writeTD("rowdata");</script>
													<a href="javascript:document.delete_form.submit();" onClick="return populateForm(document.delete_form,'%value -urlencode ../targetVersion%','%value -urlencode iTracID%','%value -urlencode fixName%','%value -urlencode fileName%','%value -urlencode fixFor%','%value -urlencode ../searchItracID%','uploadToSumAndPromote');">
														<img src="icons/upload.png" border="no">
														<img src="icons/yellow_check.gif" border="no">
													</a> 	
												</td>
											%else%
												<script>writeTD("rowdata");</script>
													
												</td>
											%endif%
											<script>writeTD("rowdata");</script>
												<a href="javascript:document.delete_form.submit();" onClick="return populateForm(document.delete_form,'%value -urlencode ../targetVersion%','%value -urlencode iTracID%','%value -urlencode fixName%','%value -urlencode fileName%','%value -urlencode fixFor%','%value -urlencode ../searchItracID%','delete');">
													<img src="icons/delete.gif" border="no">
													
												</a> 	
											</td>
										</tr>
										<script>swapRows();</script>
									%endloop%
									%onerror%
										<script>
											document.location.replace("search-files.dsp?saveErrorMessage=%value -urlencode errorMessage%");
										</script>
								%endinvoke%	
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
    </table>
	<form name="delete_form" action="download-files.dsp" method="POST">
		<input type="hidden" name="operation">
		<input type="hidden" name="targetVersion">
		<input type="hidden" name="iTracID">
		<input type="hidden" name="fixName">
		<input type="hidden" name="fileName">
		<input type="hidden" name="fixFor">
		<input type="hidden" name="searchItracID">
	</form>
  </body> 	
</head>
