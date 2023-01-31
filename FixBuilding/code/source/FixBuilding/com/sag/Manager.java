package FixBuilding.com.sag;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-12-25 21:40:39 IST
// -----( ON-HOST: MCKAJO01.eur.ad.sag

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;

import com.softwareag.util.IDataMap;
import com.wm.app.b2b.server.Resources;
import com.wm.app.b2b.server.Server;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.ns.NSName;
import com.wm.net.HttpHeader;
import com.wm.util.Strings;
import com.wm.util.Values;
import com.wm.util.coder.IDataXMLCoder;
import com.wm.util.coder.XMLCoder;

public final class Manager

{
	private static final String README_FILE_NAME = "readmeFileName";

	private static final String TARGET_PKG_NAME = "target_pkg_name";

	private static final String INVALID_PACKAGE_ZIP = "Invalid package zip :";

	private static final String MANIFEST_REL = "manifest.rel";

	private static final String ERROR_ITRAC_SUMMARY_NULL = "iTrac Summary can not be null or empty.";

	private static final String ZERO = "0";

	private static final String ERROR_IN_GETTING_I_TRAC_DETAILS = "Error in getting iTrac Details.";

	private static final String RETURN_CODE = "returnCode";

	private static final String PIVOTAL_IDS = "pivotalIds";

	private static final String ITRAC_SUMMARY = "iTracSummary";

	private static final String ERROR_ITRAC_ID_SHOULD_START_WITH_PIE = "iTrac ID should start with PIE.";

	private static final String IS_PRODUCT_CODE_PIE = "PIE";

	private static final String SEARCH_ITRAC_ID = "searchItracID";

	private static final String PROP_PROMOTE_FIX_URL = "promoteFixUrl";

	private static final String PROP_LIST_UNPROMOTED_URL = "listUnpromotedUrl";

	private static final String ERROR_MSG_FIX_FOR_NULL = "fixFor can not be null or empty.";

	private static final String FIX_FOR = "fixFor";

	private static final String FIX_FOR_PKG = "pkg";

	private static final String FIX_FOR_JAR = "jar";

	private static final String FOLDER_PKG_TEMP_PREFIX = "temp";
	// ---( internal utility methods )---
	
	private static final String FOLDER_REPO_PKG_FIX_JAR = "repoPkgFixJar";
	//MESSAGES
	private static final String ERROR_MSG_README_NOT_SELECTED = "Select Read Me file.";
	private static final String ERROR_MSG_INVALID_VERSION_STRING = "Invalid version string.";
	private static final String ERROR_MSG_NO_FIX_FOUND = "No Fix found for target version : ";
	private static final String ERROR_MSG_README_TEMPLATE_NOT_FOUND = "Readme template not found.";
	private static final String ERROR_MSG_FILE_NAME_NULL = "fileName can not be null or empty.";
	private static final String ERROR_MSG_FIX_NAME_NULL = "fixName can not be null or empty.";
	private static final String ERROR_MSG_SUM_COMPLIENT_ZIP = "Error in generating SUM Complient zip.";
	private static final String ERROR_MSG_NO_CLASS_FILES_SELECTED = "No files selected for fix.";
	private static final String ERROR_MSG_FIX_TYPE_NULL = "Fix Type can not be null or empty.";
	private static final String ERROR_MSG_REQUIRED_CORE_FIX_ZERO = "Required Core Fix can not be zero.";
	private static final String ERROR_MSG_SUPPORT_INCIDENT_ID_ZERO = "Support Incident ID can not be zero.";
	private static final String ERROR_MSG_SUPPORT_INCIDENT_ID_NULL = "Support Incident ID can not be null or empty.";
	private static final String ERROR_MSG_TARGET_VERSION_NULL = "Target IS Version can not be null or empty.";
	private static final String ERROR_MSG_ITRAC_NULL = "iTrac ID can not be null or empty.";
	
	private static final String MSG_FIX_GENERATED_SUCCESSFULLY = "Fix Generated Successfully.";
	private static final String MSG_CONFIGURATION_SAVED_SUCCESSFULLY = "Configuration saved successfully.";
	private static final String MSG_FIX_DELETED_SUCCESSFULLY = "Fix deleted successfully.";
	
	private static final String EMPTY_STRING = "";
	
	private static final String NAME_INPUT_PARAMETER = "name";
	private static final String READ_ME_INPUT_PARAMETER = "readMe";
	private static final String FILENAME_INPUT_PARAMETER = "filename";
	private static final String CLASS_FILES_INPUT_PARAMETER = "myFile";
	
	private static final String DOT_CLASS = ".class";
	private static final String FILE_CONTENT = "fileContent";

	private static final String UPDATE_CNF_FILE_NAME = "update.cnf";
	private static final String FIXBUILDER_PROPERTIES_FILE_NAME = "fixbuilder.properties";
	private static final String INSTRUCTIONS_TXT = "instructions.txt";
	private static final String MANIFEST_MF_FILE = "manifest.mf";
	private static final String MANIFEST_MF_WITHOUT_FIX_FILE = "manifest_WCF.mf";
	private static final String MANIFEST_MF_FILE_9 = "manifest_9.mf";
	private static final String MANIFEST_MF_WITHOUT_FIX_FILE_9 = "manifest_WCF_9.mf";
	private static final String MANIFEST_MF = "MANIFEST.MF";
	
	private static final String FOLDER_REPO_FIX_JAR = "repoFixJar";
//	private static final String FOLDER_FIX_JAR = "fixJar";
	
	private static final String FIX_TYPE_DIAGNOSTICS_COLLECTOR = "Diagnostics Collector";
	private static final String FIX_TYPE_TEST_PATCH = "Test Patch";
	private static final String FIX_TYPE_PRE_QA = "Hotfix";
	
	private static final String FILE_NAME = "fileName";
	private static final String FIX_NAME = "fixName";
	private static final String MESSAGE = "message";
	
	static final String requireFix = "wMFix.integrationServer.Core;version=";
	
	private static final String PROP_SUPPORED_VERSIONS = "supporedVersions";
	private static final String PROP_REPO_NAME = "repoName";
	private static final String PROP_REPO_PASSWORD = "repoPassword";
	private static final String PROP_REPO_USERNAME = "repoUsername";
	private static final String PROP_REPO_URL = "repoUrl";
	private static final String FIX_BUILDING_PKG_NAME = "FixBuilding";
	private static final String SELECTED_FILE_CHK = "selectedFileChk";
	private static final String PRECEDE_LIST = "precedeList";
	private static final String VOID_LIST = "voidList";
	private static final String FIX_TYPE = "fixType";
	private static final String FIX_VERSION = "fixVersion";
	private static final String REQUIRE_CORE_FIX = "requireCoreFix";
	private static final String SUPPORT_INCIDENT_ID = "supportIncidentID";
	private static final String TARGET_VERSION = "targetVersion";
	private static final String ITRAC_ID = "iTracID";
	
	private static final String NO_FIX_REQUIREMENT = "None.";
	
	private static final String YES_FIX_REQUIREMENT = "This {FIX_TYPE} need {REQUIRE_CORE_FIX} and their required fixes.";
	
	private enum FIX {JAR, PKG};
	
	final static Manager _instance = new Manager();

	private static final String ZIP_FILES_INPUT_PARAMETER = "zipFile";

	static Manager _newInstance() { return new Manager(); }

	static Manager _cast(Object o) { return (Manager)o; }


	static Properties properties = new Properties();
	
	static List<FixKeyConfig> fixKeyList = null;

	private static boolean keysLoaded;
	
	// ---( server methods )---




	public static final void getItracInfo (IData pipeline)
    throws ServiceException
    {
		// --- <<IS-START(getItracInfo)>> ---
		// @sigtype java 3.5

		IDataCursor pipelineCursor = pipeline.getCursor();
		try {
			String iTracID = IDataUtil.getString(pipelineCursor, SEARCH_ITRAC_ID);
			if(Strings.isEmpty(iTracID)) {
				throw new IllegalArgumentException(ERROR_MSG_ITRAC_NULL);
			}

			iTracID = iTracID.toUpperCase().trim();
			if(!iTracID.toUpperCase().startsWith(IS_PRODUCT_CODE_PIE)) {
				throw new IllegalArgumentException(ERROR_ITRAC_ID_SHOULD_START_WITH_PIE);
			}

			IDataMap httpAuth = new IDataMap();
			httpAuth.put("user", "itracsust");
			httpAuth.put("pass", "tsuscarti");
			
			IDataMap httpHdr = new IDataMap();
			httpHdr.put("Content-Type", "application/json");
			
			IDataMap httpInput = new IDataMap();
			httpInput.put("url", "https://itrac.eur.ad.sag/rest/api/latest/issue/"+iTracID);
			httpInput.put("method", "get");
			httpInput.put("loadAs", "stream");
			httpInput.put("auth", httpAuth.getIData());
			httpInput.put("headers", httpHdr.getIData());

			NSName httpSvc = NSName.create("pub.client:http");
			IData httpOut = Service.doInvoke(httpSvc, httpInput.getIData());
			
			IDataMap outMap = new IDataMap(httpOut);
			httpHdr = new IDataMap(outMap.getAsIData("header"));
			if(!"200".equals(httpHdr.getAsString("status"))) {
				throw new ServiceException(ERROR_IN_GETTING_I_TRAC_DETAILS+" "+httpHdr.getAsString("statusMessage"));
			}
			
			IData bodyAsData = outMap.getAsIData("body");
			if(bodyAsData == null) {
				throw new ServiceException(ERROR_IN_GETTING_I_TRAC_DETAILS);
			}
			IDataMap body = new IDataMap(bodyAsData);
			Object stream = body.get("stream");
			
			if(stream == null) {
				throw new ServiceException(ERROR_IN_GETTING_I_TRAC_DETAILS);
			}
			
			IDataMap streamToDocInput = new IDataMap();
			streamToDocInput.put("jsonStream", stream);
			
			NSName jsonStreamToDocumentSvc = NSName.create("pub.json:jsonStreamToDocument");
			IData jsonStreamToDocumentSvcOut = Service.doInvoke(jsonStreamToDocumentSvc, streamToDocInput.getIData());
					
			IDataMap jsonOutMap = new IDataMap(jsonStreamToDocumentSvcOut);
			IData doc = jsonOutMap.getAsIData("document");
			
			if(doc == null) {
				throw new ServiceException(ERROR_IN_GETTING_I_TRAC_DETAILS);
			}
			
			IDataMap docMap = new IDataMap(doc);
			IData fieldsAsIData = docMap.getAsIData("fields");
			if(fieldsAsIData == null) {
				throw new ServiceException(ERROR_IN_GETTING_I_TRAC_DETAILS);
			}
			IDataMap fieldsMap = new IDataMap(fieldsAsIData);
			
			
			String summary = fieldsMap.getAsString("summary");
			
			String environment = fieldsMap.getAsString("environment");
			if(environment != null) {
				String[] ee = environment.split("\n");
				for(String e : ee) {
					e = e.trim();
					if(e.contains("Reported Version:")) {
						String[] vv = e.split(":");
						IDataUtil.put(pipelineCursor, "reportedVersion", vv[1].trim());
						break;
					}
				}
			}
			
			IDataUtil.put(pipelineCursor, ITRAC_SUMMARY, summary);
			IDataUtil.put(pipelineCursor, ITRAC_ID, iTracID);
			
			String pivotalID = fieldsMap.getAsString("customfield_10431");
			if(!Strings.isEmpty(pivotalID)) {
				String[] pivotalIDs1 = pivotalID.split("\\r?\\n");
				String[] pivotalIDs2 = pivotalID.split(",");
				String[] pivotalIDs3 = pivotalID.split(";");
				int len1 = 0;
				int len2 = 0;
				int len3 = 0;

				if(pivotalIDs1 != null) {
					len1 = pivotalIDs1.length;
				}
				if(pivotalIDs2 != null) {
					len2 = pivotalIDs2.length;
				}
				if(pivotalIDs3 != null) {
					len3 = pivotalIDs3.length;
				}

				if(len1 !=0 && (len1 == len2 && len1 == len3)) {
					IDataUtil.put(pipelineCursor, PIVOTAL_IDS, pivotalIDs1);
				} else if (len1 > len2 && len1 > len3) {
					IDataUtil.put(pipelineCursor, PIVOTAL_IDS, pivotalIDs1);
				} else if (len2 > len1 && len2 > len3) {
					IDataUtil.put(pipelineCursor, PIVOTAL_IDS, pivotalIDs2);
				} else if (len3 > len2 && len3 > len1) {
					IDataUtil.put(pipelineCursor, PIVOTAL_IDS, pivotalIDs3);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
			
		}

		// --- <<IS-END>> ---


    }
	
	public static final void listCDKeys (IData pipeline)
		    throws ServiceException
	{
				// --- <<IS-START(listCDKeys)>> ---
				// @sigtype java 3.5

				IDataCursor pipelineCursor = pipeline.getCursor();
				try {
					IData keyData = getKeyData();
					IDataUtil.put(pipelineCursor, "CDKeys", IDataUtil.get(keyData.getCursor(), "CDKeys"));
				} catch (Exception e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
					
				}

				// --- <<IS-END>> ---


	}
	
	public static final void deleteCDKey (IData pipeline)
		    throws ServiceException
	{
				// --- <<IS-START(deleteCDKey)>> ---
				// @sigtype java 3.5

				IDataCursor pipelineCursor = pipeline.getCursor();
				try {
					String key = IDataUtil.getString(pipelineCursor, "key");
					FixKeyConfig config = new FixKeyConfig();
					config.setKey(key);
					int i = fixKeyList.indexOf(config);
					fixKeyList.remove(i);
					IDataUtil.put(pipelineCursor, MESSAGE, "CDKey deleted successfully.");
				} catch (Exception e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
					
				}

				// --- <<IS-END>> ---


	}
	
	public static final void getCounter (IData pipeline)
		    throws ServiceException
	{
				// --- <<IS-START(getCounter)>> ---
				// @sigtype java 3.5
		try {
			int counter = 0;
		IDataXMLCoder coder = new IDataXMLCoder();
		Resources resources = new Resources(Server.getHomeDir(), false);
		File configDir = resources.getPackageConfigDir(FIX_BUILDING_PKG_NAME);
		File configFile = new File(configDir, "stats.cnf");
		if (configFile.length() != 0 && configFile.exists()) {
			IData data = coder.readFromFile(configFile);
			if (data != null) {
				IDataMap map = new IDataMap(data);
				counter = map.getAsInteger("counter", 0);
			}
		}
		IDataMap map = new IDataMap(pipeline);
		map.put("counter", counter);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
				// --- <<IS-END>> ---


	}
	
	private static String getSimpleReportedVersion(String reportedVersion) {
		reportedVersion = reportedVersion.toUpperCase();
		reportedVersion = reportedVersion.replace(".SP", ".");
		reportedVersion = reportedVersion.replace("_SP", ".");
		return reportedVersion;
	}

	public static final void uploadFilesForItrac (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(uploadFilesForItrac)>> ---
		// @sigtype java 3.5
		
		
		IDataCursor pipelineCursor = pipeline.getCursor();
		String timeStamp = ""+System.currentTimeMillis();
		SUMFix fixInfo = new SUMFix();
		try {
			getPipelineData(pipeline);
			
			String iTracID = IDataUtil.getString(pipelineCursor, ITRAC_ID);
			if(Strings.isEmpty(iTracID)) {
				throw new IllegalArgumentException(ERROR_MSG_ITRAC_NULL);
			}
			
			iTracID = iTracID.toUpperCase();
			
			fixInfo.setiTracID(iTracID);
			
			String iTracSummary = IDataUtil.getString(pipelineCursor, ITRAC_SUMMARY);
			if(Strings.isEmpty(iTracSummary)) {
				throw new IllegalArgumentException(ERROR_ITRAC_SUMMARY_NULL);
			}
			fixInfo.setiTracSummary(iTracSummary);
			
			String targetVersion = IDataUtil.getString(pipelineCursor, TARGET_VERSION);
			if(Strings.isEmpty(targetVersion)) {
				throw new IllegalArgumentException(ERROR_MSG_TARGET_VERSION_NULL);
			}
			fixInfo.setTargetVersion(targetVersion);
			
			String supportIncidentID = IDataUtil.getString(pipelineCursor, SUPPORT_INCIDENT_ID);
			if(Strings.isEmpty(supportIncidentID)) {
				throw new IllegalArgumentException(ERROR_MSG_SUPPORT_INCIDENT_ID_NULL);
			}
			if(supportIncidentID.matches("^0+$")){
				throw new IllegalArgumentException(ERROR_MSG_SUPPORT_INCIDENT_ID_ZERO);
			}
			fixInfo.setSupportIncidentID(supportIncidentID);

			String requireCoreFix = IDataUtil.getString(pipelineCursor, REQUIRE_CORE_FIX);
			if(Strings.isEmpty(requireCoreFix)) {
				fixInfo.setRequireCoreFix(0);
			} else {
				fixInfo.setRequireCoreFix(getNonNegativeIntegerValue(requireCoreFix, REQUIRE_CORE_FIX));
				if(fixInfo.getRequireCoreFix() == 0){
					throw new IllegalArgumentException(ERROR_MSG_REQUIRED_CORE_FIX_ZERO);
				}
			}
			
			String fixVersion = IDataUtil.getString(pipelineCursor, FIX_VERSION);
			if(Strings.isEmpty(fixVersion)) {
				fixVersion = EMPTY_STRING;
			}
			fixInfo.setFixVersion(fixVersion);
			
			String fixType = IDataUtil.getString(pipelineCursor, FIX_TYPE);
			if(Strings.isEmpty(fixType)) {
				throw new IllegalArgumentException(ERROR_MSG_FIX_TYPE_NULL);
			}
			fixInfo.setFixType(fixType);
			
			String voidList = IDataUtil.getString(pipelineCursor, VOID_LIST);
			if(Strings.isEmpty(voidList)) {
				voidList = EMPTY_STRING;
			} else {
				voidList = getCommaSeperatedList(voidList);
			}
			fixInfo.setVoidList(voidList);
			
			String precedeList = IDataUtil.getString(pipelineCursor, PRECEDE_LIST);
			if(Strings.isEmpty(precedeList)) {
				precedeList = EMPTY_STRING;
			} else {
				precedeList = getCommaSeperatedList(precedeList);
			}
			fixInfo.setPrecedeList(precedeList);
			
			Object selectedFileChk = IDataUtil.get(pipelineCursor, SELECTED_FILE_CHK);
			List<String> selectedFilesToUpload = new ArrayList<String>();
			if(selectedFileChk != null) {
				if(selectedFileChk instanceof String) {
					selectedFilesToUpload.add((String)selectedFileChk);
				} else if(selectedFileChk instanceof List) {
					selectedFilesToUpload = (List<String>)selectedFileChk;
				}
			} else {
				throw new IllegalArgumentException(ERROR_MSG_NO_CLASS_FILES_SELECTED);
			}
			fixInfo.setSelectedFilesToUpload(selectedFilesToUpload);

			List<IData> attachedClasses = getAttachedClassList(pipeline);
			
			List<IData> attachedPackageZips = getAttachedPackageList(pipeline);
			
			boolean isClassesAttached = attachedClasses != null && attachedClasses.size() > 0;
			boolean isPkgZipAttached = attachedPackageZips != null && attachedPackageZips.size() > 0;
			
			if(!isClassesAttached && !isPkgZipAttached) {
				throw new IllegalArgumentException(ERROR_MSG_NO_CLASS_FILES_SELECTED);
			}
			
			Resources resources = new Resources(Server.getHomeDir(), false);
			File pkgResDir = resources.getPackageResourceDir(FIX_BUILDING_PKG_NAME);
			File targetVersionFolder = new File(pkgResDir, targetVersion);
			if(!targetVersionFolder.exists()) {
				targetVersionFolder.mkdir();
			}
			File iTracIDFolder = new File(targetVersionFolder, iTracID);
			if(!iTracIDFolder.exists()) {
				iTracIDFolder.mkdir();
			}
			
			cleanUP(fixInfo);
			
			File tempFolder = getTempFolder(iTracIDFolder, fixInfo, timeStamp);
			
			if(isClassesAttached)
				copyClassFiles(attachedClasses, tempFolder, fixInfo, timeStamp);
			if(isPkgZipAttached)
				copyPackageFiles(attachedPackageZips, tempFolder, fixInfo, timeStamp);
			
			copyReadmeFile(pipeline, tempFolder, fixInfo, timeStamp);
			
			setResponseContentType();
			
			Map<String, ClassEntry> classToPathMap = new HashMap<String, ClassEntry>();
			
			processClassFiles(tempFolder, classToPathMap);
			
			setFixNameInFixInfo(fixInfo);
			
			createJAR(classToPathMap, tempFolder, fixInfo);
			
			File repoFixJarFolder = new File(iTracIDFolder, FOLDER_REPO_FIX_JAR);
			
			createSUMCompliantZip(fixInfo, repoFixJarFolder, FIX.JAR, fixInfo.getFixName());
			
			String successMsg = MSG_FIX_GENERATED_SUCCESSFULLY;
			
			Service.setResponse(successMsg.getBytes());
			
			increaseCounter();
		} catch (Exception e) {
			try {
				setResponseContentType();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			Service.setResponse(e.getMessage().getBytes());
		} finally {
			cleanUPTempFolder(fixInfo);
		}
		
		// --- <<IS-END>> ---

                
	}

	private static void increaseCounter() throws IOException {
		IDataXMLCoder coder = new IDataXMLCoder();
		Resources resources = new Resources(Server.getHomeDir(), false);
		File configDir = resources.getPackageConfigDir(FIX_BUILDING_PKG_NAME);
		File configFile = new File(configDir, "stats.cnf");
		if (configFile.length() != 0 && configFile.exists()) {
			IData data = coder.readFromFile(configFile);
			if (data != null) {
				IDataMap map = new IDataMap(data);
				int counter = map.getAsInteger("counter", 0);
				counter++;
				map.put("counter", counter);
				coder.writeToFile(configFile, map.getIData());
			}
		} else {
			configFile.createNewFile();
			IDataMap map = new IDataMap();
			map.put("counter", 1);
			coder.writeToFile(configFile, map.getIData());
		}
	}

	private static void setFixNameInFixInfo(SUMFix fixInfo) {
		String fixName = getFixName(fixInfo);
		fixInfo.setFixName(fixName);
	}

	
	private static List<IData> getAttachedPackageList(IData pipeline) {
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object filesData = IDataUtil.get(pipelineCursor, ZIP_FILES_INPUT_PARAMETER);
		List<IData> allZipFiles = new ArrayList<IData>();
		if(filesData instanceof IData) {
			allZipFiles.add((IData)filesData);
		} else if(filesData instanceof List) {
			allZipFiles = (List<IData>)filesData;
		}
		return allZipFiles;
	}

	private static List<IData> getAttachedClassList(IData pipeline) {
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object filesData = IDataUtil.get(pipelineCursor, CLASS_FILES_INPUT_PARAMETER);
		List<IData> allClassFiles = new ArrayList<IData>();
		if(filesData instanceof IData) {
			allClassFiles.add((IData)filesData);
		} else if(filesData instanceof List) {
			allClassFiles = (List<IData>)filesData;
		}
		return allClassFiles;
	}

	private static void setTargetPackageName(PackageFix fix) throws Exception {
		File zip = new File(fix.getPkgZipPath());
		if(zip.exists()) {
			InputStream stream = ZipReader.getFileEntry(zip, MANIFEST_REL);
			if(stream == null) {
				throw new IllegalArgumentException(INVALID_PACKAGE_ZIP+zip.getName());
			}
			XMLCoder coder = new XMLCoder();
			Values values = coder.decode(stream);
			String targetPkgName = values.getString(TARGET_PKG_NAME);
			fix.setPackgeName(targetPkgName);
			try {
				stream.close();
			} catch (Exception e) {
				
			}
		}
	}
	
	private static void cleanUPTempFolder(SUMFix fixInfo) {
		String tempFolderPath = fixInfo.getTempFolderPath();
		if(tempFolderPath != null) {
			File temp = new File(tempFolderPath);
			if(temp.exists()) {
				deleteFilesRecursively(temp);
			}
		}
	}

	private static void copyPackageFiles(List<IData> allZipFiles, File temp, SUMFix fixInfo, String timeStamp) throws IOException, Exception {
		
		List<PackageFix> packageFixes = fixInfo.getPackageFixes();
		for(IData data : allZipFiles) {
			PackageFix packageFix = new PackageFix();
			if(packageFixes == null) {
				packageFixes = new ArrayList<PackageFix>();
			}
			File f = copyFileContent(temp, fixInfo, data, true, false);
			if(f != null ) {
				if (f.exists()) {
					packageFix.setPkgZipName(f.getName());
					packageFix.setPkgZipPath(f.getAbsolutePath());
					setTargetPackageName(packageFix);
					if(!packageFixes.contains(packageFix)) {
						packageFixes.add(packageFix);
					}
				}
			}
		}
		fixInfo.setPackageFixes(packageFixes);
	}

	public static final void getCommonProperties (IData pipeline)
	throws ServiceException
	{
		// --- <<IS-START(getCommonProperties)>> ---
		// @sigtype java 3.5

		try {
			IDataCursor cursor = pipeline.getCursor();
			loadPropertiesFile();
			IDataUtil.put(cursor, PROP_REPO_URL, properties.getProperty(PROP_REPO_URL));
			IDataUtil.put(cursor, PROP_REPO_USERNAME, properties.getProperty(PROP_REPO_USERNAME));
			IDataUtil.put(cursor, PROP_REPO_PASSWORD, properties.getProperty(PROP_REPO_PASSWORD));
			IDataUtil.put(cursor, PROP_REPO_NAME, properties.getProperty(PROP_REPO_NAME));
			IDataUtil.put(cursor, PROP_SUPPORED_VERSIONS, properties.getProperty(PROP_SUPPORED_VERSIONS));
			IDataUtil.put(cursor, PROP_PROMOTE_FIX_URL, properties.getProperty(PROP_PROMOTE_FIX_URL));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

		// --- <<IS-END>> ---

	}

	private static File loadPropertiesFile() throws IOException, FileNotFoundException {
		Resources r = new Resources(Server.getHomeDir(), false);
		File ConfDir = r.getPackageConfigDir(FIX_BUILDING_PKG_NAME);
		File propFile = new File(ConfDir, FIXBUILDER_PROPERTIES_FILE_NAME);
		properties.load(new FileInputStream(propFile.getAbsoluteFile()));
		return propFile;
	}
	
	public static final void setCommonProperties (IData pipeline)
	throws ServiceException
	{
		// --- <<IS-START(setCommonProperties)>> ---
		// @sigtype java 3.5

		try {
			IDataCursor cursor = pipeline.getCursor();
			File propFile = loadPropertiesFile();
			
			String repoURL = IDataUtil.getString(cursor, PROP_REPO_URL);
			if(Strings.isEmpty(repoURL)) {
				throw new IllegalArgumentException("Repo URL can not be null or empty.");
			}
			properties.put(PROP_REPO_URL ,repoURL);
			
			String repoUsername = IDataUtil.getString(cursor, PROP_REPO_USERNAME);
			if(Strings.isEmpty(repoUsername)) {
				throw new IllegalArgumentException("Repo User Name can not be null or empty.");
			}
			properties.put(PROP_REPO_USERNAME ,repoUsername);
			
			String repoPassword = IDataUtil.getString(cursor, PROP_REPO_PASSWORD);
			if(Strings.isEmpty(repoPassword)) {
				throw new IllegalArgumentException("Repo Password can not be null or empty.");
			}
			properties.put(PROP_REPO_PASSWORD ,repoPassword);
			
			String repoName = IDataUtil.getString(cursor, PROP_REPO_NAME);
			if(Strings.isEmpty(repoName)) {
				throw new IllegalArgumentException("Repo Name can not be null or empty.");
			}
			properties.put(PROP_REPO_NAME ,repoName);
			
			String promoteFixURL = IDataUtil.getString(cursor, PROP_PROMOTE_FIX_URL);
			if(Strings.isEmpty(promoteFixURL)) {
				throw new IllegalArgumentException("Promote Fix URL can not be null or empty.");
			}
			properties.put(PROP_PROMOTE_FIX_URL ,promoteFixURL);
			
			String supportedVersions = IDataUtil.getString(cursor, PROP_SUPPORED_VERSIONS);
			if(Strings.isEmpty(supportedVersions)) {
				throw new IllegalArgumentException("Promote Fix URL can not be null or empty.");
			}
			properties.put(PROP_SUPPORED_VERSIONS, getCommaSeperatedVersionList(supportedVersions));
			
			properties.store(new FileOutputStream(propFile.getAbsoluteFile()), null);
			IDataUtil.put(cursor, MESSAGE, MSG_CONFIGURATION_SAVED_SUCCESSFULLY);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

		// --- <<IS-END>> ---

	}
	
	public static final void getSupportedVersions (IData pipeline)
	throws ServiceException
	{
		// --- <<IS-START(getSupportedVersions)>> ---
		// @sigtype java 3.5

		try {
			IDataCursor cursor = pipeline.getCursor();
		    try {
		    	loadPropertiesFile();
		        IDataUtil.put(cursor, PROP_SUPPORED_VERSIONS, getSupportedVersionList(properties.getProperty(PROP_SUPPORED_VERSIONS)));
		    } catch (IOException e) {
		    	
		    }
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

		// --- <<IS-END>> ---

	}
	
	private static String getCommaSeperatedVersionList(String property) {
		String result = EMPTY_STRING;
		property = property.trim();
		String[] allVersions = property.split(";");
		for(String version : allVersions) {
			version = version.trim();
			if(!Strings.isEmpty(version)) {
				result = result + version+";";
			}
		}
		return result;
	}

	private static String[] getSupportedVersionList(String property) {
		property = property.trim();
		String[] allVersions = property.split(";");
		List<String> list = new ArrayList<String>();
		for(String version : allVersions) {
			version = version.trim();
			if(!Strings.isEmpty(version)) {
				list.add(version);
			}
		}
		return list.toArray(new String[0]);
	}

	private static int getNonNegativeIntegerValue(String value, String name) {
		int result = getIntegerValue(value, name);
		if(result < 0) {
			throw new IllegalArgumentException("Invalid integer value "+value+" for "+name);
		}
		return result;
	}

	private static int getIntegerValue(String value, String name) {
		int result = -1;
		try {
			result =  Integer.parseInt(value);
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid integer value "+value+" for "+name);
		}
		return result;
	}

	private static void createSUMCompliantZip(SUMFix fixInfo, File repoFixJarFolder, FIX fix, String repoZipName) throws Exception {
		
	    
		if(!repoFixJarFolder.exists()) {
			repoFixJarFolder.mkdir();
		} else {
			File[] files = repoFixJarFolder.listFiles();
			for(File file : files) {
				deleteFilesRecursively(file);
			}
		}
		
		File fixFolder = new File(repoFixJarFolder, repoZipName);
		
		if(!fixFolder.exists()) {
			fixFolder.mkdir();
		} else {
			File[] files = fixFolder.listFiles();
			for(File file : files) {
				file.delete();
			}
		}
		
		Resources resources = new Resources(Server.getHomeDir(), false);
		File templateDir = resources.getPackageTemplateDir(FIX_BUILDING_PKG_NAME);
		
		File manifestMF = generateManifestMF(fixInfo, fixFolder, templateDir);
		
		File InstructionsTXT = null;
			InstructionsTXT = generateInstructionsTXT(fixInfo, fixFolder, templateDir);
		
		String zipName = repoZipName+".zip";
		
		try {
			FileOutputStream fos = new FileOutputStream(fixFolder.getAbsolutePath()+File.separator+zipName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			addToZipFile(manifestMF, "META-INF/"+manifestMF.getName(), zos);
			addToZipFile(InstructionsTXT, "META-INF/"+InstructionsTXT.getName(), zos);
			if(fixInfo.getFixJarName() != null) {
				addToZipFile(new File(fixInfo.getFixJarLocalPath()), "IntegrationServer/updates/"+fixInfo.getFixJarName(), zos);
			} 

			List<PackageFix> packageFixes = fixInfo.getPackageFixes();
			if(packageFixes != null && packageFixes.size() > 0) {
				for(PackageFix packageFix : packageFixes) {
					addToZipFile(new File(packageFix.getPkgZipPath()), "IntegrationServer/replicate/inbound/"+packageFix.getPkgZipName(), zos);
				}
			}

			zos.flush();
			zos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File readME = new File(fixInfo.getReadMeLocalPath());
		String readMEStr = read(readME);
		
		readMEStr = populateReadMe(fixInfo, readMEStr);
		
		String readMEFileNameForSum  = repoZipName+"_readme.txt";
		
		File readMeFileForSum = new File(fixFolder, readMEFileNameForSum);
		save(readMeFileForSum, readMEStr);
		
		readME.delete();
		manifestMF.delete();
		InstructionsTXT.delete();

	}

	private static String populateReadMe(SUMFix fixInfo, String readMEStr) {
		String formattedTargetVersion = getFormattedTargetVersion(fixInfo.getTargetVersion());
		if(fixInfo.getRequireCoreFix() > 0) {
			readMEStr = readMEStr.replaceAll("\\{FIX_REQUIREMENT_TEXT\\}", YES_FIX_REQUIREMENT);
			readMEStr = readMEStr.replaceAll("\\{REQUIRE_CORE_FIX\\}", getFormattedVersion(formattedTargetVersion, fixInfo.getRequireCoreFix()));
		} else {
			readMEStr = readMEStr.replaceAll("\\{FIX_REQUIREMENT_TEXT\\}", NO_FIX_REQUIREMENT);
		}
		
		readMEStr = readMEStr.replaceAll("\\{TARGET_VERSION\\}", formattedTargetVersion);
		readMEStr = readMEStr.replaceAll("\\{ITRAC_ID\\}", fixInfo.getiTracID());
		readMEStr = readMEStr.replaceAll("\\{FIX_TYPE\\}", fixInfo.getFixType());
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat month_date = new SimpleDateFormat("MMM yyyy");
		String month_year = month_date.format(cal.getTime());
		SimpleDateFormat copyrightYear = new SimpleDateFormat("yyyy");
		String copyrightYearStr = copyrightYear.format(cal.getTime());
		readMEStr = readMEStr.replaceAll("\\{MONTH_YEAR\\}", month_year);
		readMEStr = readMEStr.replaceAll("\\{COPYRIGHT_YEAR\\}", copyrightYearStr);
		if(!Strings.isEmpty(fixInfo.getFixVersion())) {
			readMEStr = readMEStr.replaceAll("\\{FIX_VERSION\\}", "_v"+fixInfo.getFixVersion());
		} else { 
			readMEStr = readMEStr.replaceAll("\\{FIX_VERSION\\}",EMPTY_STRING);
		}
		
		readMEStr = readMEStr.replaceAll("\\{FIX_NAME\\}", fixInfo.getFixName());
		if(fixInfo.getiTracSummary() != null) {
			readMEStr = readMEStr.replaceAll("\\{SUMMARY\\}", fixInfo.getiTracSummary());
		} 
		
		return readMEStr;
	}

	private static void deleteFilesRecursively(File file) {
		if(file.isDirectory()) {
			File[] kids = file.listFiles();
			for(File kid : kids) {
				deleteFilesRecursively(kid);
			}
			file.delete();
		} else {
			file.delete();
		}
		
	}

	private static File generateInstructionsTXT(SUMFix fixInfo, File repoFixJarFoler, File templateDir) throws IOException {
		
		File instructionsTXT = new File(templateDir, INSTRUCTIONS_TXT);
		String instructionsTXTStr = read(instructionsTXT);
		String result = "";
		if(fixInfo.getFixJarName() != null) {
			result = result+Instruction.getJarFirstInstruction(fixInfo);
			result = result+System.getProperty("line.separator");
		}
		List<PackageFix> packageFixs = fixInfo.getPackageFixes();
		if(packageFixs != null && packageFixs.size() > 0) { 
			for(PackageFix packageFix : packageFixs) {
				if(result.trim().length() == 0) {
					result = result+Instruction.getPackageFirstInstruction(packageFix);
				} else {
					result = result+Instruction.getPackageInstruction(packageFix);
				}
				result = result+System.getProperty("line.separator");
				result = result+Instruction.getPackageInstallInstruction(packageFix);
				result = result+System.getProperty("line.separator");
			}
		}
		File outputInstructionsFile = new File(repoFixJarFoler, INSTRUCTIONS_TXT);
		instructionsTXTStr = instructionsTXTStr.replace("INSTRUCTIONS", result);
		save(outputInstructionsFile, instructionsTXTStr);
		return outputInstructionsFile;
	}
	

	private static File generateManifestMF(SUMFix fixInfo, File repoFixJarFoler, File templateDir) throws IOException {
		String manifestFileName = getManifestFileForVersion(fixInfo);
		File manifestMF = new File(templateDir, manifestFileName);
		String manifestMFStr = read(manifestMF);
		manifestMFStr = manifestMFStr.replaceAll("_DISPLAY_FIX_NAME_", fixInfo.getFixName());
		manifestMFStr = manifestMFStr.replaceAll("_PRODUCT_VERSION_", getFormatedRequireProduct(fixInfo));
		if(fixInfo.getRequireCoreFix() > 0) {
			String requireCoreFixFormatted = getRequireCoreFix(fixInfo);
			if(requireCoreFixFormatted.length() != 0) {
				manifestMFStr = manifestMFStr.replaceAll("_REQUIRE_FIX_", requireFix+requireCoreFixFormatted);
			}
		}
		manifestMFStr = manifestMFStr.replaceAll("_SUPPORT_INCIDENT_", EMPTY_STRING+fixInfo.getSupportIncidentID());
		manifestMFStr = manifestMFStr.replaceAll("_ITRAC_NO_", fixInfo.getiTracID());
		manifestMFStr = manifestMFStr.replaceAll("_FIX_TYPE_", fixInfo.getFixType());
		File outputManifestFile = new File(repoFixJarFoler, MANIFEST_MF);
		save(outputManifestFile, manifestMFStr);
		return outputManifestFile;
	}

	private static String getManifestFileForVersion(SUMFix fixInfo) {
		String manifestFileName =  MANIFEST_MF_FILE_9;
		if(fixInfo.getRequireCoreFix() <= 0) {
			manifestFileName =  MANIFEST_MF_WITHOUT_FIX_FILE_9;	
		}
		String fx = getFormatedRequireProduct(fixInfo);
		String[] fxAry = fx.split("\\.");
		if(fxAry.length >= 2) {
			try {
				int majorVersion = Integer.parseInt(fxAry[0]);
				int minorVersion = Integer.parseInt(fxAry[1]);
				if(majorVersion == 10 && minorVersion == 0) {
					//no change same as version 9.*
				} else if(majorVersion >= 10) {
					manifestFileName =  MANIFEST_MF_FILE;
					if(fixInfo.getRequireCoreFix() <= 0) {
						manifestFileName =  MANIFEST_MF_WITHOUT_FIX_FILE;	
					}
				}
			} catch (Exception e) {
				//no action
			}
		}
		return manifestFileName;
	}

	private static String getFormatedRequireProduct(SUMFix fixInfo) {
		String targetVersion = fixInfo.getTargetVersion();
		String[] targetVerionArray = targetVersion.split("\\.");
		if(targetVerionArray.length == 2) {
			return targetVersion+".0";
		} else {
			return targetVersion;
		}
		
	}

	private static String getRequireCoreFix(SUMFix fixInfo) {
		String targetVersion = fixInfo.getTargetVersion();
		String[] targetVerionArray = targetVersion.split("\\.");
		if(targetVerionArray.length == 2) {
			return targetVersion+".0."+getFormatedFixNumber(fixInfo.getRequireCoreFix()+EMPTY_STRING);
		} else if(targetVerionArray.length == 3) {
			return targetVersion+"."+getFormatedFixNumber(fixInfo.getRequireCoreFix()+EMPTY_STRING);
		} else {
			throw new IllegalArgumentException(ERROR_MSG_SUM_COMPLIENT_ZIP);
		}
		
	}

	private static String getFormatedFixNumber(String requireCoreFix) {
		if(requireCoreFix.length() == 0 || requireCoreFix.length() == 4) {
			return requireCoreFix;
		}
		else if(requireCoreFix.length() ==  1) {
			return "000"+requireCoreFix;
		}
		else if(requireCoreFix.length() ==  2) {
			return "00"+requireCoreFix;
		}
		else if(requireCoreFix.length() ==  3) {
			return ZERO+requireCoreFix;
		} else {
			throw new IllegalArgumentException(ERROR_MSG_SUM_COMPLIENT_ZIP);
		}
	}

	private static void cleanUP(SUMFix fixInfo) {

		try {
			Resources resources = new Resources(Server.getHomeDir(), false);
			File pkgResDir = resources.getPackageResourceDir(FIX_BUILDING_PKG_NAME);
			File targetVersionFolder = new File(pkgResDir, fixInfo.getTargetVersion());
			if(!targetVersionFolder.exists()) {
				return;
			}
			File iTracIDFolder = new File(targetVersionFolder, fixInfo.getiTracID());
			if(!iTracIDFolder.exists()) {
				return;
			}
			File[] fList = iTracIDFolder.listFiles(new NonDirFileFilter());
			for(File file : fList) {
				file.delete();
			}
		} catch (Exception e ) 
		{
			//ignore
		}
	}

	public static final void downloadFilesForItrac (IData pipeline)
		throws ServiceException
		{
		// --- <<IS-START(downloadFilesForItrac)>> ---
		// @sigtype java 3.5

		IDataCursor cursor = pipeline.getCursor();
		String iTracID = IDataUtil.getString(cursor, ITRAC_ID);
		if(Strings.isEmpty(iTracID)) {
			throw new IllegalArgumentException(ERROR_MSG_ITRAC_NULL);
		}

		iTracID = iTracID.toUpperCase();
		
		String targetVersion = IDataUtil.getString(cursor, TARGET_VERSION);
		if(Strings.isEmpty(targetVersion)) {
			throw new IllegalArgumentException(ERROR_MSG_TARGET_VERSION_NULL);
		}

		String fixName = IDataUtil.getString(cursor, FIX_NAME);
		if(Strings.isEmpty(fixName)) {
			throw new IllegalArgumentException(ERROR_MSG_FIX_NAME_NULL);
		}
		
		String fileName = IDataUtil.getString(cursor, FILE_NAME);
		if(Strings.isEmpty(fileName)) {
			throw new IllegalArgumentException(ERROR_MSG_FILE_NAME_NULL);
		}
		
		String fixFor = IDataUtil.getString(cursor, FIX_FOR);
		if(Strings.isEmpty(fixFor)) {
			throw new IllegalArgumentException(ERROR_MSG_FIX_FOR_NULL);
		}
		
		Resources resources = new Resources(Server.getHomeDir(), false);
		File pkgResDir = resources.getPackageResourceDir(FIX_BUILDING_PKG_NAME);
		File targetVersionFolder = new File(pkgResDir, targetVersion);
		if(!targetVersionFolder.exists()) {
			throw new IllegalArgumentException(fileName+" not found.");
		}
		File iTracIDFolder = new File(targetVersionFolder, iTracID);
		if(!iTracIDFolder.exists()) {
			throw new IllegalArgumentException(fileName+" not found.");
		}

		File fixJarFolder = new File(iTracIDFolder, FOLDER_REPO_FIX_JAR);
		if(FIX_FOR_PKG.equals(fixFor)) {
			fixJarFolder = new File(iTracIDFolder, FOLDER_REPO_PKG_FIX_JAR);
		}
		if(!fixJarFolder.exists()) {
			// no fixes.
		}

		File fix = new File(fixJarFolder, fixName);
		if(!fix.exists()) {
			throw new IllegalArgumentException(fileName+" not found.");
		}
		
		File fixFile = new File(fix, fileName);
		if(!fixFile.exists()) {
			throw new IllegalArgumentException(fileName+" not found.");
		}
		IData getFileIn = IDataFactory.create();
		IDataUtil.put(getFileIn.getCursor(), FILENAME_INPUT_PARAMETER, fixFile.getAbsolutePath());
		IDataUtil.put(getFileIn.getCursor(), "loadAs", "bytes");
		try {
			IData getFileOut = Service.doInvoke(NSName.create("pub.file:getFile"), getFileIn);
			IData body = IDataUtil.getIData(getFileOut.getCursor(), "body");
			byte[] fileBytes = (byte[])IDataUtil.get(body.getCursor(), "bytes");

			//Content-Type : application/java-archive; ; name=IS_8.2_SP1_TestPatch_PIE-1234.jar
			//Content-Disposition : attachment; filename=IS_8.2_SP1_TestPatch_PIE-1234.jar

			HttpHeader hdr = Service.getHttpResponseHeader();
			hdr.addField("Content-Type", "application/octet-stream");
			hdr.addField("Content-Disposition", "attachment; filename="+fixFile.getName());

			Service.setResponse(fileBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// --- <<IS-END>> ---

		}

	public static final void downloadReadme (IData pipeline)
	throws ServiceException
	{
		// --- <<IS-START(downloadReadme)>> ---
		// @sigtype java 3.5
		
		try {
			IDataCursor cursor = pipeline.getCursor();
			String readmeFileName = IDataUtil.getString(cursor, README_FILE_NAME);
			if(Strings.isEmpty(readmeFileName)) {
				return;
			}
			Resources r = new Resources(Server.getHomeDir(), false);
			File f = r.getPackageTemplateDir(FIX_BUILDING_PKG_NAME);
			File readme = new File (f, readmeFileName);
			if(!readme.exists()) {
				throw new IllegalAccessError(ERROR_MSG_README_TEMPLATE_NOT_FOUND);
			}
			IData getFileIn = IDataFactory.create();
			IDataUtil.put(getFileIn.getCursor(), FILENAME_INPUT_PARAMETER, readme.getAbsolutePath());
			IDataUtil.put(getFileIn.getCursor(), "loadAs", "bytes");

			IData getFileOut = Service.doInvoke(NSName.create("pub.file:getFile"), getFileIn);
			IData body = IDataUtil.getIData(getFileOut.getCursor(), "body");
			byte[] fileBytes = (byte[])IDataUtil.get(body.getCursor(), "bytes");

			//Content-Type : application/java-archive; ; name=IS_8.2_SP1_TestPatch_PIE-1234.jar
			//Content-Disposition : attachment; filename=IS_8.2_SP1_TestPatch_PIE-1234.jar

			HttpHeader hdr = Service.getHttpResponseHeader();
			hdr.addField("Content-Type", "application/octet-stream");
			hdr.addField("Content-Disposition", "attachment; filename="+readme.getName());

			Service.setResponse(fileBytes);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		// --- <<IS-END>> ---

	}

	
	public static final void deleteFix (IData pipeline)
	throws ServiceException
	{
		// --- <<IS-START(deleteFix)>> ---
		// @sigtype java 3.5

		try {
			IDataCursor cursor = pipeline.getCursor();
			String iTracID = IDataUtil.getString(cursor, ITRAC_ID);
			if(Strings.isEmpty(iTracID)) {
				throw new IllegalArgumentException(ERROR_MSG_ITRAC_NULL);
			}

			iTracID = iTracID.toUpperCase();
			
			String targetVersion = IDataUtil.getString(cursor, TARGET_VERSION);
			if(Strings.isEmpty(targetVersion)) {
				throw new IllegalArgumentException(ERROR_MSG_TARGET_VERSION_NULL);
			}

			String fixName = IDataUtil.getString(cursor, FIX_NAME);
			if(Strings.isEmpty(fixName)) {
				throw new IllegalArgumentException(ERROR_MSG_FIX_NAME_NULL);
			}
			String fileName = IDataUtil.getString(cursor, FILE_NAME);
			if(Strings.isEmpty(fileName)) {
				throw new IllegalArgumentException(ERROR_MSG_FILE_NAME_NULL);
			}
			String fixFor = IDataUtil.getString(cursor, FIX_FOR);
			if(Strings.isEmpty(fixFor)) {
				throw new IllegalArgumentException(ERROR_MSG_FIX_FOR_NULL);
			}
			Resources resources = new Resources(Server.getHomeDir(), false);
			File pkgResDir = resources.getPackageResourceDir(FIX_BUILDING_PKG_NAME);
			File targetVersionFolder = new File(pkgResDir, targetVersion);
			if(!targetVersionFolder.exists()) {
				throw new IllegalArgumentException(fileName+" not found.");
			}
			File iTracIDFolder = new File(targetVersionFolder, iTracID);
			if(!iTracIDFolder.exists()) {
				throw new IllegalArgumentException(fileName+" not found.");
			}

			File fixJarFolder = new File(iTracIDFolder, FOLDER_REPO_FIX_JAR);
			if(FIX_FOR_PKG.equals(fixFor)) {
				fixJarFolder = new File(iTracIDFolder, FOLDER_REPO_PKG_FIX_JAR);
			}
			if(fixJarFolder.exists()) {
				File fix = new File(fixJarFolder, fixName);
				if(!fix.exists()) {
					throw new IllegalArgumentException(fileName+" not found.");
				}
				
				File fixFile = new File(fix, fileName);
				if(!fixFile.exists()) {
					throw new IllegalArgumentException(fileName+" not found.");
				}
				fixFile.delete();
				IDataUtil.put(cursor, MESSAGE, MSG_FIX_DELETED_SUCCESSFULLY);
			}  else {
				throw new IllegalArgumentException(fileName+" not found.");
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		// --- <<IS-END>> ---

	}

	public static final void uploadFixToSum (IData pipeline)
	throws ServiceException
	{
		// --- <<IS-START(uploadFixToSum)>> ---
		// @sigtype java 3.5

		try {
			IDataCursor cursor = pipeline.getCursor();
			String iTracID = IDataUtil.getString(cursor, ITRAC_ID);
			if(Strings.isEmpty(iTracID)) {
				throw new IllegalArgumentException(ERROR_MSG_ITRAC_NULL);
			}
			
			iTracID = iTracID.toUpperCase();
			
			String targetVersion = IDataUtil.getString(cursor, TARGET_VERSION);
			if(Strings.isEmpty(targetVersion)) {
				throw new IllegalArgumentException(ERROR_MSG_TARGET_VERSION_NULL);
			}

			String fixName = IDataUtil.getString(cursor, FIX_NAME);
			if(Strings.isEmpty(fixName)) {
				throw new IllegalArgumentException(ERROR_MSG_FIX_NAME_NULL);
			}
			String fileName = IDataUtil.getString(cursor, FILE_NAME);
			if(Strings.isEmpty(fileName)) {
				throw new IllegalArgumentException(ERROR_MSG_FILE_NAME_NULL);
			}
			String fixFor = IDataUtil.getString(cursor, FIX_FOR);
			if(Strings.isEmpty(fixFor)) {
				throw new IllegalArgumentException(ERROR_MSG_FIX_FOR_NULL);
			}
			
			Resources resources = new Resources(Server.getHomeDir(), false);
			File pkgResDir = resources.getPackageResourceDir(FIX_BUILDING_PKG_NAME);
			File targetVersionFolder = new File(pkgResDir, targetVersion);
			if(!targetVersionFolder.exists()) {
				throw new IllegalArgumentException(fileName+" not found.");
			}
			File iTracIDFolder = new File(targetVersionFolder, iTracID);
			if(!iTracIDFolder.exists()) {
				throw new IllegalArgumentException(fileName+" not found.");
			}

			File fixJarFolder = new File(iTracIDFolder, FOLDER_REPO_FIX_JAR);
			if(FIX_FOR_PKG.equals(fixFor)) {
				fixJarFolder = new File(iTracIDFolder, FOLDER_REPO_PKG_FIX_JAR);
			}
			if(fixJarFolder.exists()) {
				
				File fix = new File(fixJarFolder, fixName);
				if(!fix.exists()) {
					throw new IllegalArgumentException(fileName+" not found.");
				}
				
				File fixFile = new File(fix, fileName);
				if(!fixFile.exists()) {
					throw new IllegalArgumentException(fileName+" not found.");
				}
				
				loadPropertiesFile();
				File readMe = new File(fix, fixName+"_readme.txt");
				String key = Upload.uploadFiles(properties.getProperty(PROP_REPO_URL), 
						fixFile, readMe, properties.getProperty(PROP_REPO_NAME), properties.getProperty(PROP_REPO_USERNAME), properties.getProperty(PROP_REPO_PASSWORD) );
				if(Strings.isEmpty(key)) {
					throw new ServiceException("Error in uploading fix to SUM");
				}
				IDataUtil.put(cursor, "fixKey", key.trim());
				
				if(!keysLoaded && fixKeyList == null) {
					loadKeyFile();
				} 
				
				addCDKeyEntry(iTracID, fixFile, key);
				
				IDataUtil.put(cursor, MESSAGE, "Fix uploaded successfully. Key is : "+key);
			}  else {
				throw new IllegalArgumentException(fileName+" not found.");
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		// --- <<IS-END>> ---

	}

	private static void addCDKeyEntry(String iTracID, File fixFile, String key) throws IOException {
		FixKeyConfig config = new FixKeyConfig();
		config.setiTracID(iTracID);
		config.setKey(key.trim());
		config.setFixName(fixFile.getName());
		String dateStr = getCurrentFormattedDate();
		config.setGeneratedTime(dateStr);
		fixKeyList.add(config);
		saveKeysToFile();
	}


	private static String getCurrentFormattedDate() {
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss z");
		String dateStr = format.format(curDate);
		return dateStr;
	}
	
	public static final void promoteFix (IData pipeline)
	throws ServiceException
	{
		// --- <<IS-START(promoteFix)>> ---
		// @sigtype java 3.5

		
		IDataCursor cursor = pipeline.getCursor();
		
		try {
			String fixKey = IDataUtil.getString(cursor, "fixKey");
			if(Strings.isEmpty(fixKey)) {
				throw new IllegalArgumentException("Fix key can not be null or empty.");
			}
			fixKey = fixKey.trim();
			loadPropertiesFile();
			String result = Upload.getFixVersionForAFix(properties.getProperty(PROP_LIST_UNPROMOTED_URL),
					fixKey, properties.getProperty(PROP_REPO_USERNAME), properties.getProperty(PROP_REPO_PASSWORD));
			if(!Strings.isEmpty(result)) {
				String fixVersion = getFixVersionFromResultStr(result);
				String fixName = getFixNameFromResultStr(result);
				if(!Strings.isEmpty(fixVersion) && !Strings.isEmpty(fixName) ) {
					Upload.promoteFix(properties.getProperty(PROP_PROMOTE_FIX_URL)+"?fixVersion="+fixVersion.trim()+"&fixName="+fixName.trim()+"&repoName=CDRepo",
							properties.getProperty(PROP_REPO_USERNAME), properties.getProperty(PROP_REPO_PASSWORD));
					
					IDataUtil.put(cursor, "message", "Fix promoted successfully.");
				} else {
					IDataUtil.put(cursor, "message", "Fix not found in un-promoted fix list.");
				}
			} else {
				IDataUtil.put(cursor, "message", "Fix not found in un-promoted fix list.");
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}

    	// --- <<IS-END>> ---

    }	
	
	public static final void uploadToSumAndPromoteFix (IData pipeline)
	throws ServiceException
	{
		// --- <<IS-START(uploadToSumAndPromoteFix)>> ---
		// @sigtype java 3.5
		try {
			uploadFixToSum(pipeline);
			String uploadMessage = IDataUtil.getString(pipeline.getCursor(), MESSAGE);
			promoteFix(pipeline);
			String promoteFixMessage = IDataUtil.getString(pipeline.getCursor(), MESSAGE);
			IDataUtil.put(pipeline.getCursor(), MESSAGE, uploadMessage + ", "+ promoteFixMessage);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}


		// --- <<IS-END>> ---

	}
	private static String getFixNameFromResultStr(String result) {
		String prefix = "fixName=";
		String fixVersion = result.substring(result.indexOf(prefix)+prefix.length());
		fixVersion = fixVersion.substring(0, fixVersion.indexOf("&"));
		return fixVersion;
	}

	private static String getFixVersionFromResultStr(String result) {
		String prefix = "fixVersion=";
		String fixVersion = result.substring(result.indexOf(prefix)+prefix.length(), result.indexOf(">")-1);
		return fixVersion;
	}

	public static final void listFixJars (IData pipeline)
	throws ServiceException
	{
		// --- <<IS-START(listFixJars)>> ---
		// @sigtype java 3.5

		IDataCursor cursor = pipeline.getCursor();
		try {
			String iTracID = IDataUtil.getString(cursor, SEARCH_ITRAC_ID);
			if(Strings.isEmpty(iTracID)) {
				iTracID = null;//throw new IllegalArgumentException(ERROR_MSG_ITRAC_NULL);
			}
			if(iTracID != null) {
				iTracID = iTracID.toUpperCase();
			}
			String targetVersion = IDataUtil.getString(cursor, TARGET_VERSION);
			if(Strings.isEmpty(targetVersion)) {
				throw new IllegalArgumentException(ERROR_MSG_TARGET_VERSION_NULL);
			}

			Resources resources = new Resources(Server.getHomeDir(), false);
			File pkgResDir = resources.getPackageResourceDir(FIX_BUILDING_PKG_NAME);
			File targetVersionFolder = new File(pkgResDir, targetVersion);
			if(!targetVersionFolder.exists()) {
				throw new IllegalStateException(ERROR_MSG_NO_FIX_FOUND+targetVersion+".");
			}
			List<IData> fixesData = new ArrayList<IData>();
			if(iTracID == null) {
				File[] itracFolders = targetVersionFolder.listFiles(new DirFileFilter());
				for(File iTracIDFolder : itracFolders) {
					String fixFolder = FOLDER_REPO_FIX_JAR;
					String fixFor = FIX_FOR_JAR;
					addFixesList(fixesData, iTracIDFolder, fixFolder, fixFor);

					fixFolder = FOLDER_REPO_PKG_FIX_JAR;
					fixFor = FIX_FOR_PKG;
					addFixesList(fixesData, iTracIDFolder, fixFolder, fixFor);
				}
			} else {
				File iTracIDFolder = new File(targetVersionFolder, iTracID);
				if(!iTracIDFolder.exists()) {
					throw new IllegalStateException(ERROR_MSG_NO_FIX_FOUND+targetVersion+".");
				}

				String fixFolder = FOLDER_REPO_FIX_JAR;
				String fixFor = FIX_FOR_JAR;
				addFixesList(fixesData, iTracIDFolder, fixFolder, fixFor);

				fixFolder = FOLDER_REPO_PKG_FIX_JAR;
				fixFor = FIX_FOR_PKG;
				addFixesList(fixesData, iTracIDFolder, fixFolder, fixFor);
				
			}
			IDataUtil.put(cursor, "allFixes", fixesData.toArray(new IData[0]));
		}
		catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

		// --- <<IS-END>> ---

	}

	private static void addFixesList(List<IData> fixesData, File iTracIDFolder, String fixFolder, String fixFor) {
		File repoFixJar = new File(iTracIDFolder, fixFolder);
		addFixesToList(fixesData, repoFixJar, fixFor, iTracIDFolder.getName());
	}

	private static void addFixesToList(List<IData> fixesData, File repoFixJar, String fixFor, String itracID) {
		if(repoFixJar.exists()) {
			File[] sumFixDir = repoFixJar.listFiles(new DirFileFilter());
			for(File outer : sumFixDir) {
				File[] fixes = outer.listFiles();
				IData temp = null;
				for(File f : fixes) {
					temp = IDataFactory.create();
					IDataUtil.put(temp.getCursor(), FILE_NAME, f.getName());
					IDataUtil.put(temp.getCursor(), FIX_NAME, outer.getName());
					IDataUtil.put(temp.getCursor(), ITRAC_ID, itracID);
					if(f.getName().endsWith("txt") && f.getName().contains("readme")) {
						IDataUtil.put(temp.getCursor(), FIX_TYPE, "local");
						IDataUtil.put(temp.getCursor(), "fileType", "readme");
						IDataUtil.put(temp.getCursor(), FIX_FOR, fixFor);
					} else if(f.getName().endsWith("zip")) {
						IDataUtil.put(temp.getCursor(), FIX_TYPE, "sum");
						IDataUtil.put(temp.getCursor(), "fileType", fixFor);
						IDataUtil.put(temp.getCursor(), FIX_FOR, fixFor);
					}

					fixesData.add(temp);
				}
			}
		}
	}
	private static String getCommaSeperatedList(String voidList) {
		voidList = voidList.trim();
		String[] list = voidList.split(";");
		String result = EMPTY_STRING;
		for(String l : list) {
			l = l.trim();
			if(l.length() > 0) {
				result = result+l+";";
			}
		}
		return result;
	}

	private static void createJAR(Map<String, ClassEntry> classToPathMap, File temp, SUMFix fixInfo) throws FileNotFoundException, IOException {
		if(classToPathMap.size() <= 0) {
			return;
		}
		String fixName = fixInfo.getFixName();
		fixInfo.setFixJarName(fixName+".jar");
		
		Manifest manifest = new Manifest();
		File jar = new File(temp, fixInfo.getFixJarName());
		fixInfo.setFixJarLocalPath(jar.getAbsolutePath());
		JarOutputStream target = new JarOutputStream(new FileOutputStream(jar.getAbsolutePath()), manifest);
		
		addClassessToJar(classToPathMap, target);
		
		addUpdateCNFTOJAR(target, fixName, fixInfo, temp);
		
		if(target != null) {
			target.close();
		}
	}

	private static String getFixName(SUMFix fixInfo) {
		//"IS_9.7_TestPatch_PIE-34946_v1.jar"
		//IS_8.2_SP2_TestPatch_PIE-34577_v1
		String targetVersion = fixInfo.getTargetVersion();
		String iTracID = fixInfo.getiTracID();
		String result=EMPTY_STRING;
		String version = getFormattedTargetVersion(targetVersion);
		if(fixInfo.getFixType().equalsIgnoreCase(FIX_TYPE_DIAGNOSTICS_COLLECTOR)) {
			result =  "IS_"+version+"_Core_Diagnostics_Collector_"+iTracID;
		} else if(fixInfo.getFixType().equalsIgnoreCase(FIX_TYPE_TEST_PATCH)) {
			result =  "IS_"+version+"_Core_TestPatch_"+iTracID;
		} else if(fixInfo.getFixType().equalsIgnoreCase(FIX_TYPE_PRE_QA)) {
			result =  "IS_"+version+"_Core_HotFix_"+iTracID;
		}
		if(!Strings.isEmpty(fixInfo.getFixVersion())) {
			result = result+"_v"+fixInfo.getFixVersion();
		}
		return result;
	}

	private static String getFormattedTargetVersion(String targetVersion) {
		if(targetVersion.startsWith("7.")) {
			return targetVersion;
		}
		targetVersion = targetVersion.trim();
		String[] vL = targetVersion.split("\\.");
		String version = null;
		if(vL.length == 2) {
			version = vL[0].trim()+"."+vL[1].trim();;
		} 
		if(vL.length == 3) {
			version = vL[0].trim()+"."+vL[1].trim()+"_SP"+vL[2].trim();
		} 
		if(vL.length < 1 && vL.length > 3) {
			throw new IllegalArgumentException(ERROR_MSG_INVALID_VERSION_STRING);
		}
		return version;
	}

	private static void addUpdateCNFTOJAR(JarOutputStream target, String fixName, SUMFix fixInfo, File temp) throws IOException {
		Resources resources = new Resources(Server.getHomeDir(), false);
		File templateDir = resources.getPackageTemplateDir(FIX_BUILDING_PKG_NAME);
		File updateFile = new File(templateDir, UPDATE_CNF_FILE_NAME);
		String updateStr = read(updateFile);
		updateStr = updateStr.replaceAll("_UPDATENAME_", fixName);
		updateStr = updateStr.replaceAll("_PRODUCTVERSION_", getVersionForCnf(fixInfo.getTargetVersion()));
		updateStr = updateStr.replaceAll("_VOIDLIST_", fixInfo.getVoidList());
		updateStr = updateStr.replaceAll("_PRECEDELIST_", fixInfo.getPrecedeList());
		
		File outputUpdateFile = new File(temp, UPDATE_CNF_FILE_NAME);
		save(outputUpdateFile, updateStr.trim());
		addJarEntry(target, UPDATE_CNF_FILE_NAME, outputUpdateFile);
		
	}

	private static String getVersionForCnf(String targetVersion) {
		String version = EMPTY_STRING;
		targetVersion = targetVersion.trim();
		String[] vL = targetVersion.split("\\.");
		if(vL.length == 2 || vL.length == 3) {
			version = vL[0].trim()+"."+vL[1].trim();;
		}
		if(vL.length < 1 && vL.length > 3) {
			throw new IllegalArgumentException(ERROR_MSG_INVALID_VERSION_STRING);
		}
		return version;
	}

	private static void addClassessToJar(Map<String, ClassEntry> classToPathMap, JarOutputStream target) throws IOException, FileNotFoundException {
		Set<String> allClasses = classToPathMap.keySet();
		for(String clazz : allClasses) {
			ClassEntry classEntry = classToPathMap.get(clazz);

			addJarEntry(target, classEntry.classPath, classEntry.classFile);
		}
	}

	private static void addJarEntry(JarOutputStream target, String classPath, File classFile ) throws IOException, FileNotFoundException {
		BufferedInputStream in = null;
		try {
			JarEntry entry = new JarEntry(classPath);
			entry.setTime(classFile.lastModified());
			target.putNextEntry(entry);
			in = new BufferedInputStream(new FileInputStream(classFile));

			byte[] buffer = new byte[1024];
			while (true) {
				int count = in.read(buffer);
				if (count == -1) {
					break;
				}
				target.write(buffer, 0, count);
			}
			target.flush();
			target.closeEntry();
		}
		finally {
			if (in != null)
				in.close();
		}
	}

	private static Map<String, ClassEntry> processClassFiles(File iTracIDFolder, Map<String, ClassEntry> classToPathMap) throws IOException {
		File[] allClasses = iTracIDFolder.listFiles(new ClassFileFilter());
		ClassEntry classEntry = null;
		for(File file : allClasses) {
			ClassParser parser = new ClassParser(file.getAbsolutePath());
			JavaClass cls = parser.parse(); 
			classEntry = new ClassEntry(file , getClassPath(cls.getClassName()));
			classToPathMap.put(cls.getClassName(), classEntry);
		}
		
		File[] listFolders = iTracIDFolder.listFiles(new DirFileFilter());
		for(File f : listFolders) {
			processClassFiles(f, classToPathMap);
		}
		return classToPathMap;
	}

	private static String getClassPath(String className) {
		String path = EMPTY_STRING;
		className = className.trim();
		String[] qPath = className.split("\\.");
		if(qPath.length == 1) {
			path = qPath[0];
		}
		for(int i=0 ; i < qPath.length; i++) {
			if( i == qPath.length -1 ) {
				path = path + qPath[i];
			} else {
				path = path + qPath[i]+ "/";
			}
		}
		return path+DOT_CLASS;
	}
	private static void setResponseContentType() throws Exception {
		IData inRespHeader = IDataFactory.create();
		IDataUtil.put(inRespHeader.getCursor(), "fieldName", "Content-Type");
		IDataUtil.put(inRespHeader.getCursor(), "fieldValue", "text/plain");
		
		Service.doInvoke(NSName.create("pub.flow:setResponseHeader"), inRespHeader);
	}



	private static void copyClassFiles(List<IData> allClassFiles, File temp, SUMFix fixInfo, String timeStamp) throws Exception, IOException {
		
		String filename = null;
		if(allClassFiles.size() == 1) {
			filename = IDataUtil.getString(allClassFiles.get(0).getCursor(), FILENAME_INPUT_PARAMETER);
			if(Strings.isEmpty(filename)) {
				throw new IllegalArgumentException(ERROR_MSG_NO_CLASS_FILES_SELECTED);
			}
		}
		
		for(IData data : allClassFiles) {
			copyFileContent(temp, fixInfo, data, true, true);
		}
		
	}

	private static void copyReadmeFile(IData pipeline, File temp, SUMFix fixInfo, String timeStamp) throws Exception, IOException {
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData readMe = IDataUtil.getIData(pipelineCursor, READ_ME_INPUT_PARAMETER);
		if(readMe == null) {
			throw new IllegalArgumentException(ERROR_MSG_README_NOT_SELECTED);
		}
		String filename = IDataUtil.getString(readMe.getCursor(), FILENAME_INPUT_PARAMETER);
		if(Strings.isEmpty(filename)) {
			throw new IllegalArgumentException(ERROR_MSG_README_NOT_SELECTED);
		}
		copyFileContent(temp, fixInfo, readMe, false, false);
		fixInfo.setReadMeLocalPath((new File(temp, IDataUtil.getString(readMe.getCursor(), FILENAME_INPUT_PARAMETER))).getAbsolutePath());
	}
	
	private static File getTempFolder(File iTracIDFolder, SUMFix fixInfo, String timeStamp) {
		String tempFolderName = FOLDER_PKG_TEMP_PREFIX+timeStamp;
		
		File temp = new File(iTracIDFolder, tempFolderName);
		if(!temp.exists()) {
			temp.mkdir();
		}
		fixInfo.setTempFolderPath(temp.getAbsolutePath());
		return temp;
	}

	private static File copyFileContent(File iTracIDFolder, SUMFix fixInfo, IData data, boolean checkInSelectedFiles, boolean isClassFile) throws Exception, IOException {
		String filename;
		byte[] fileContent = null;
		filename = IDataUtil.getString(data.getCursor(), FILENAME_INPUT_PARAMETER);
		if(Strings.isEmpty(filename)) {
			return null;
		}
		if(checkInSelectedFiles && !fixInfo.getSelectedFilesToUpload().contains(filename)) {
			return null;
		}
		if(checkInSelectedFiles && !filename.endsWith(DOT_CLASS) && isClassFile) {
			throw new IllegalArgumentException("Only class files can be uploaded, Invalid file "+filename);
		}
		fileContent = (byte[])IDataUtil.get(data.getCursor(), FILE_CONTENT);
		File f = new File(iTracIDFolder,filename);
		if(f.exists()) {
			File subf = new File(iTracIDFolder, System.currentTimeMillis()+"");
			subf.mkdir();
			f = new File(subf, filename);
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			fos.write(fileContent);
			fos.flush();
			fos.close();
		} catch(Exception e) {
			throw e;
		} finally {
			if(fos != null) {
				fos.close();
			}
		}
		return f;
	}

	private static void getPipelineData(IData pipeline) throws Exception {
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData getTransportInfoOut = Service.doInvoke(NSName.create("pub.flow:getTransportInfo"), IDataFactory.create());
		IDataCursor svcOutCursor = getTransportInfoOut.getCursor();
		IData transport = IDataUtil.getIData(svcOutCursor, "transport");
		IData http = IDataUtil.getIData(transport.getCursor(), "http");
		IData requestHeaders = IDataUtil.getIData(http.getCursor(), "requestHdrs");

		IData svcIn = IDataFactory.create();
		IData body = IDataFactory.create();
		IDataUtil.put(body.getCursor(), "stream", IDataUtil.get(pipelineCursor, "contentStream"));
		IDataUtil.remove(pipelineCursor, "contentStream");

		IDataUtil.put(svcIn.getCursor(), "headerLines" , requestHeaders);
		IDataUtil.put(svcIn.getCursor() ,"body", body);

		IData mergeHeaderAndBodyOut = Service.doInvoke(NSName.create("pub.mime:mergeHeaderAndBody"), svcIn);
		Object stream = IDataUtil.get(mergeHeaderAndBodyOut.getCursor(), "stream");

		svcIn = IDataFactory.create();
		IDataUtil.put(svcIn.getCursor(), "input", stream);
		IData createMimeDataOut = Service.doInvoke(NSName.create("pub.mime:createMimeData"), svcIn);
		IData getNumPartsOut = Service.doInvoke(NSName.create("pub.mime:getNumParts"), createMimeDataOut);

		int numberOfParts = IDataUtil.getInt(getNumPartsOut.getCursor(), "numParts", -1);
		if(numberOfParts > 0) {
			IData in = null;
			for(int i=0; i<numberOfParts;i++){
				in = IDataFactory.create();
				IDataUtil.put(in.getCursor(), "mimeData", IDataUtil.get(createMimeDataOut.getCursor(),"mimeData"));
				IDataUtil.put(in.getCursor(), "index", i);
				IData getBodyPartHeader = Service.doInvoke(NSName.create("pub.mime:getBodyPartHeader"), in);
				IData mimeHeader = IDataUtil.getIData(getBodyPartHeader.getCursor(),"mimeHeader");
				String contentDisposition = IDataUtil.getString(mimeHeader.getCursor(), "Content-Disposition");
				String[] list = contentDisposition.split(";");
				String paramName = null;
				String fileName = null;
				for(String s : list) {
					s = s.trim();
					if(s.indexOf("=") > 0) {
						if(s.startsWith(NAME_INPUT_PARAMETER)) {
							paramName = s.split("=")[1];
							paramName = paramName.replace("\"", EMPTY_STRING);
						}
						if(s.startsWith(FILENAME_INPUT_PARAMETER)) {
							fileName = s.split("=")[1];
							fileName = fileName.replace("\"", EMPTY_STRING);
						}
					}
				}
				byte[] bytes = getContentBytes(in);
				if(!Strings.isEmpty(fileName)) {
					if(paramName.startsWith(CLASS_FILES_INPUT_PARAMETER)) {
						paramName = CLASS_FILES_INPUT_PARAMETER;
					}
					if(paramName.startsWith(ZIP_FILES_INPUT_PARAMETER)) {
						paramName = ZIP_FILES_INPUT_PARAMETER;
					}
					File receivedFile = new File(fileName);
					Object o = IDataUtil.get(pipelineCursor, paramName);
					if(o != null && o instanceof IData) {
						List<IData> l = new ArrayList<IData>();
						l.add((IData)o);
						
						IData fileData = getFileData(bytes, receivedFile);
						l.add(fileData);
						
						IDataUtil.put(pipelineCursor, paramName, l);
					} else if(o != null && o instanceof List) {
						IData fileData = getFileData(bytes, receivedFile);
						((List)o).add(fileData);
						
						IDataUtil.put(pipelineCursor, paramName, o);
					} else {
						IData fileData = getFileData(bytes, receivedFile);
						IDataUtil.put(pipelineCursor, paramName, fileData);
					}
					
				} else {
					Object o = IDataUtil.get(pipelineCursor, paramName);
					if(o != null && o instanceof String) {
						List<String> l = new ArrayList<String>();
						l.add((String)o);
						l.add(new String(bytes));
						IDataUtil.put(pipelineCursor, paramName, l);
					} else if(o != null && o instanceof List) {
						((List)o).add(new String(bytes));
						IDataUtil.put(pipelineCursor, paramName, o);
					} else {
						IDataUtil.put(pipelineCursor, paramName, new String(bytes));
					}
					
					
				}

			}
		}
	}

	private static IData getFileData(byte[] bytes, File receivedFile) {
		IData fileData = IDataFactory.create();
		IDataUtil.put(fileData.getCursor(), FILENAME_INPUT_PARAMETER, receivedFile.getName());
		IDataUtil.put(fileData.getCursor(), FILE_CONTENT, bytes);
		return fileData;
	}
	
	private static byte[] getContentBytes(IData in) throws Exception {
		IData getBodyPartContent = Service.doInvoke(NSName.create("pub.mime:getBodyPartContent"), in);
		Object content = IDataUtil.get(getBodyPartContent.getCursor(), "content");
		
		IData streamToBytesIn = IDataFactory.create();
		IDataUtil.put(streamToBytesIn.getCursor(), "stream", content);
		IData streamToBytesOut = Service.doInvoke(NSName.create("pub.io:streamToBytes"), streamToBytesIn);
		byte[] bytes = (byte[])IDataUtil.get(streamToBytesOut.getCursor(), "bytes");
		return bytes;
	}
	
	static class ClassEntry {
		File classFile;
		String classPath;
		public ClassEntry (File classFile, String classPath) {
			this.classFile = classFile;
			this.classPath = classPath;
		}
	}
	
//	static class FixInfo {
//		public String tempFolderPath;
//		public String targetPackage;
//		public String readMeLocalPath;
//		public String fixType;
//		public String fixJarName;
//		public List<String> selectedFilesToUpload;
//		String iTracID;
//		int supportIncidentID;
//		String targetVersion;
//		String fixVersion;
//		String voidList;
//		String precedeList; 
//		String fixName;
//		String fixJarLocalPath;
//		
//		int requireCoreFix;
//	}
	
	private static String read(File file) throws IOException {
		String contents = null;

		if (file != null) {
			FileInputStream   fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "UTF8");
			BufferedReader    bin = new BufferedReader(isr);
			StringBuffer      buf = new StringBuffer();
			String            sep = "\n";

			String in;
			while ((in = bin.readLine()) != null) {
				buf.append(in);
				buf.append(sep);
			}

			contents = buf.toString();
			bin.close();
		}

		return contents;
	}
	private static void save(File file, String contents) throws IOException {
		File dir = file.getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}

		if (file != null) {
			FileOutputStream fos = new FileOutputStream(file);
			Writer           out = new OutputStreamWriter(fos, "UTF8");
			BufferedWriter   bw  = new BufferedWriter(out);
			bw.write(contents);
			bw.flush();
			bw.close();
		}
	}

	public static void addToZipFile(File file, String entry, ZipOutputStream zos) throws FileNotFoundException, IOException {

		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(entry);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}
	
	private static String getFormattedVersion(String version, int requiredFixNumber) {
		return "IS_"+version+"_Core_Fix"+requiredFixNumber;
	}
	
	private static void loadKeyFile() throws IOException {
		Resources resources = new Resources(Server.getHomeDir(), false);
		File configDir = resources.getPackageConfigDir(FIX_BUILDING_PKG_NAME);
		fixKeyList = new ArrayList<FixKeyConfig>();
		File configFile = new File(configDir, "CDKeyList.cnf");
		if (configFile.length() != 0 && configFile.exists()) {
			IDataXMLCoder coder = new IDataXMLCoder();
			IData data = coder.readFromFile(configFile);
			if (data != null) {
				populateKeys(data);
			}
		} else {
			configFile.createNewFile();
		}
		
		keysLoaded = true;
	}
	
	public static void populateKeys(IData idata) {
		IDataMap idataMap = new IDataMap(idata); 
		IData[] cdKeys = idataMap.getAsIDataArray("CDKeys");
		FixKeyConfig fixKeyConfig = null;
		if (cdKeys != null) {
	    	for(IData data : cdKeys) {
	    		fixKeyConfig = new FixKeyConfig();
	    		fixKeyConfig.setIData(data);
	    		fixKeyList.add(fixKeyConfig);
	    	}
		}
	}
	
	private static void saveKeysToFile() throws IOException {
		IDataXMLCoder coder = new IDataXMLCoder();
		Resources resources = new Resources(Server.getHomeDir(), false);
		File configDir = resources.getPackageConfigDir(FIX_BUILDING_PKG_NAME);
		File configFile = new File(configDir, "CDKeyList.cnf");
		coder.writeToFile(configFile, getKeyData());
		
	}
	
	private static IData getKeyData() throws IOException {
		if(fixKeyList == null ) {
			loadKeyFile();
		}
		List<IData> data = new ArrayList<IData>();
		for (FixKeyConfig config : fixKeyList) {
			data.add(config.getIData());
		}
		IDataMap dataMap = new IDataMap();
    	dataMap.put("CDKeys", data.toArray(new IData[0]));
        return dataMap.getIData();
	}
}

