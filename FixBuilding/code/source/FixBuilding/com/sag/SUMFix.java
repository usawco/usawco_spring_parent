package FixBuilding.com.sag;

import java.util.List;

public class SUMFix {
	private String tempFolderPath;
	private String readMeLocalPath;
	private String fixType;
	private String fixJarName;
	private List<String> selectedFilesToUpload;
	private String iTracID;
	private String supportIncidentID;
	private String targetVersion;
	private String fixVersion;
	private String voidList;
	private String precedeList; 
	private String fixName;
	private String fixJarLocalPath;
	private int requireCoreFix;
	private String iTracSummary;
	private List<PackageFix> packageFixes;
	
	public String getiTracSummary() {
		return iTracSummary;
	}
	public void setiTracSummary(String iTracSummary) {
		this.iTracSummary = iTracSummary;
	}
	
	public String getTempFolderPath() {
		return tempFolderPath;
	}
	public void setTempFolderPath(String tempFolderPath) {
		this.tempFolderPath = tempFolderPath;
	}

	public String getReadMeLocalPath() {
		return readMeLocalPath;
	}
	public void setReadMeLocalPath(String readMeLocalPath) {
		this.readMeLocalPath = readMeLocalPath;
	}
	public String getFixType() {
		return fixType;
	}
	public void setFixType(String fixType) {
		this.fixType = fixType;
	}
	public String getFixJarName() {
		return fixJarName;
	}
	public void setFixJarName(String fixJarName) {
		this.fixJarName = fixJarName;
	}
	public List<String> getSelectedFilesToUpload() {
		return selectedFilesToUpload;
	}
	public void setSelectedFilesToUpload(List<String> selectedFilesToUpload) {
		this.selectedFilesToUpload = selectedFilesToUpload;
	}
	public String getiTracID() {
		return iTracID;
	}
	public void setiTracID(String iTracID) {
		this.iTracID = iTracID;
	}
	public String getSupportIncidentID() {
		return supportIncidentID;
	}
	public void setSupportIncidentID(String supportIncidentID) {
		this.supportIncidentID = supportIncidentID;
	}
	public String getTargetVersion() {
		return targetVersion;
	}
	public void setTargetVersion(String targetVersion) {
		this.targetVersion = targetVersion;
	}
	public String getFixVersion() {
		return fixVersion;
	}
	public void setFixVersion(String fixVersion) {
		this.fixVersion = fixVersion;
	}
	public String getVoidList() {
		return voidList;
	}
	public void setVoidList(String voidList) {
		this.voidList = voidList;
	}
	public String getPrecedeList() {
		return precedeList;
	}
	public void setPrecedeList(String precedeList) {
		this.precedeList = precedeList;
	}
	public String getFixName() {
		return fixName;
	}
	public void setFixName(String fixName) {
		this.fixName = fixName;
	}
	public String getFixJarLocalPath() {
		return fixJarLocalPath;
	}
	public void setFixJarLocalPath(String fixJarLocalPath) {
		this.fixJarLocalPath = fixJarLocalPath;
	}
	public int getRequireCoreFix() {
		return requireCoreFix;
	}
	public void setRequireCoreFix(int requireCoreFix) {
		this.requireCoreFix = requireCoreFix;
	}
	public List<PackageFix> getPackageFixes() {
		return packageFixes;
	}
	public void setPackageFixes(List<PackageFix> packageFixes) {
		this.packageFixes = packageFixes;
	} 
	
	
}
