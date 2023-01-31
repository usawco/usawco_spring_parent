package FixBuilding.com.sag;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpClientParams;

public class Upload {
	public static String uploadFiles(String strBaseURL, File postFile, File readmeFile, String strRepoName, String user, String pass)
	        throws HttpException, IOException {
			String diagnoserKey = "";

	        if (!postFile.exists()) {
	            System.out.println("FixPublishTask.uploadFiles()Please provide fix file for upload");
	            return strRepoName;
	        }

	        HashMap<String, String> params = new HashMap<String, String>();
	        params.put("repoName", strRepoName);
	        params.put("functionName", "publishFix");// file1 file2
	        params.put(postFile.getName(), postFile.getName());
	        HttpMethod method = new PostMethod(strBaseURL);
	        int iFilesToUpload = 1;
	        boolean booReadMeExists = false;
	        if (readmeFile != null) {
	            booReadMeExists = readmeFile.exists();
	            params.put(readmeFile.getName(), readmeFile.getName());
	            iFilesToUpload = 2;
	        }
	        NameValuePair[] pairs = new NameValuePair[params.size()];

	        Part[] parts = new Part[params.size() + iFilesToUpload];
	        parts[0] = new FilePart(postFile.getName(), postFile);
	        if (booReadMeExists) {
	            parts[1] = new FilePart(readmeFile.getName(), readmeFile);
	        }
	        int iOffset = 1;
	        int iPartsOffset = iFilesToUpload;
	        for (Map.Entry<String, String> entry : params.entrySet()) {
	            ((PostMethod) method).addParameter(entry.getKey(), entry.getValue());
	            parts[iPartsOffset] = new StringPart(entry.getKey(), entry.getValue());
	            pairs[iOffset - 1] = new NameValuePair(entry.getKey(), entry.getValue());
	            ((PostMethod) method).addParameter(entry.getKey(), entry.getValue());
	            ++iOffset;
	            ++iPartsOffset;
	        }

	        MultipartRequestEntity entity = new MultipartRequestEntity(parts, method.getParams());
	        ((PostMethod) method).setRequestEntity(entity);
	        ((PostMethod) method).setQueryString(pairs);

	        Credentials credentials = new UsernamePasswordCredentials(user, pass);
	        HttpClient client = new HttpClient();
	        HttpClientParams paramsHttp = client.getParams();
	        paramsHttp.setAuthenticationPreemptive(true);
	        HttpState state = client.getState();
	        state.setCredentials(AuthScope.ANY, credentials);

	        int code = client.executeMethod(method);
	        String output = method.getResponseBodyAsString();
	        Header[] header = method.getResponseHeaders();
	        Header responseHeader = method.getResponseHeader("diagnoserKey");
	        if(responseHeader != null) {
	        	diagnoserKey = responseHeader.getValue();
	        }
	        if (header.equals("diagnoserKey")) {
              
	        } 
	        state = client.getState();
	        if (code != 200) {
	            String strMessage = "Failed upload of fix.errorneous HTTP CODE: " + code;
	            String strMess = strMessage + state + " is bad, at server: " + client.getHost() + ":" + client.getPort()
	                + " Params:" + paramsHttp;
	            System.out.println(strMess);
	            System.out.println(output);
	            throw new IOException("Fix publish failed. " + strMessage);
	        } else {
	        	
	        }
	       
	        return diagnoserKey;
	    }
	
	public static String getFixVersionForAFix(String strBaseURL, String queryKeyword, String user, String pass)
    throws HttpException, IOException {

		queryKeyword = queryKeyword.trim();
        Credentials credentials = new UsernamePasswordCredentials(user, pass);
        HttpClient client = new HttpClient();
        HttpClientParams paramsHttp = client.getParams();
        paramsHttp.setAuthenticationPreemptive(true);
        HttpState state = client.getState();
        state.setCredentials(AuthScope.ANY, credentials);
        GetMethod method = new GetMethod(strBaseURL);
        
        
        int code = client.executeMethod(method);
        String output = method.getResponseBodyAsString();
        state = client.getState();
        if (code != 200) {
        	throw new IOException("Failed to get fix version for: "+queryKeyword);
        } else {
        	String[] strArr = output.trim().split("\\r?\\n");
			for(String str : strArr) {
				if (str.indexOf(queryKeyword) > -1 && str.indexOf("fixVersion=") > -1 && str.indexOf("fixName=") > -1) {
					return str;
				}
			}
        }
       
        return null;
    }

	public static String promoteFix(String strBaseURL, String user, String pass)
    	throws HttpException, IOException {

        Credentials credentials = new UsernamePasswordCredentials(user, pass);
        HttpClient client = new HttpClient();
        HttpClientParams paramsHttp = client.getParams();
        paramsHttp.setAuthenticationPreemptive(true);
        HttpState state = client.getState();
        state.setCredentials(AuthScope.ANY, credentials);
        GetMethod method = new GetMethod(strBaseURL);
        
        
        int code = client.executeMethod(method);
        String output = method.getResponseBodyAsString();
        state = client.getState();
        if (code != 200) {
        	throw new IOException("Failed to promote fix.");
        } else {
        	return output;
        }
       
    }
	
	public static void main(String[] args) {
		try {
			String s = getFixVersionForAFix("http://aquarius-va.ame.ad.sag:8088/reposervice/repoadmin/listunpromotedfixes?repoName=CDRepo&fixType=diagnoser&queryKeyword=1083276_PIE-31497_1", "CDRepo", "repo", "repo");
			String[] strArr = s.trim().split("\\r?\\n");
			for(String str : strArr) {
				if (str.indexOf("fixVersion=") > -1) {
					String fixVersion = str.substring(str.indexOf("fixVersion=")+"fixVersion=".length());
					fixVersion = fixVersion.substring(0, fixVersion.indexOf("&"));
					System.out.println(fixVersion);
				}
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
