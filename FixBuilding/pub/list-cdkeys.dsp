<html>
<head>
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta http-equiv="Expires" content="-1">
  <link rel="stylesheet" TYPE="text/css" href="/WmRoot/webMethods.css">
  <script src="/WmRoot/webMethods.js"></script>
  <script language="JavaScript">
	<!--add jscript here-->
	function populateForm(form , glNm ,oper)
	{

		if('delete' == oper)
		{
			if (!confirm ("OK to delete '"+glNm+"'?")) {
				return false;
			}
			form.operation.value = 'deleteKey';	
		}
		form.key.value = glNm;
		return true
	}
	
  </script>
  
  <body onLoad="setNavigation('list-cdkeys.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=IS_LIST_KEYS');">
   
    <table width="100%">
		<tr>
			<td class="menusection-Settings" colspan="2"> Fix Building &gt;  CD Keys </td>
		</tr>
		%ifvar operation equals('deleteKey')%
			%invoke FixBuilding.com.sag.Manager:deleteCDKey%
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
				<table width="100%">
					<tr>
						<td width="10px">
							<img src="/WmRoot/images/blank.gif"  border=0>
						</td>
						<td>	
							<table class="tableView" width="100%">
								<tr>
									<td class="heading" colspan="5">CD Keys</td>
								</tr>
								<tr>
									<td class="oddcol-l">iTrac ID</td>
									<td class="oddcol">Key</td>
									<td class="oddcol">Fix Name</td>
									<td class="oddcol">Created Date</td>
									<td class="oddcol">Delete</td>
								</tr>
								%invoke FixBuilding.com.sag.Manager:listCDKeys%
									%loop CDKeys%
										<tr>
											<script>writeTD("row-l");</script>	
												   %value iTracID%			
											</td>
											<script>writeTD("rowdata");</script>					
													%value key%			
											</td>						
											<script>writeTD("rowdata");</script>
												%value fixName%
											</td>
											<script>writeTD("rowdata");</script>
												%value generatedTime%
											</td>
											<script>writeTD("rowdata");</script>
												<a href="javascript:document.htmlform_gl_delete.submit();" onClick="return populateForm(document.htmlform_gl_delete,'%value key%','delete');">
													<img src="icons/delete.gif" border="no">
												</a> 	
											</td>
										</tr>
										<script>swapRows();</script>
									%endloop%
								%endinvoke%	
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
    </table>

	<form name="htmlform_gl_delete" action="list-cdkeys.dsp" method="POST">
		<input type="hidden" name="operation">
		<input type="hidden" name="key">
	</form>
  </body> 	
</head>
