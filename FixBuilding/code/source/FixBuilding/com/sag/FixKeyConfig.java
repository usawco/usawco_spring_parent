package FixBuilding.com.sag;

import com.softwareag.util.IDataMap;
import com.wm.data.IData;

public class FixKeyConfig {
	
	private String key;
	private String fixName;
	private String iTracID;
	private String generatedTime;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getFixName() {
		return fixName;
	}
	public void setFixName(String fixName) {
		this.fixName = fixName;
	}
	public String getiTracID() {
		return iTracID;
	}
	public void setiTracID(String iTracID) {
		this.iTracID = iTracID;
	}
	public String getGeneratedTime() {
		return generatedTime;
	}
	public void setGeneratedTime(String generatedTime) {
		this.generatedTime = generatedTime;
	}
	
	public void setIData(IData data) {
		IDataMap keyMap = new IDataMap(data);
		key = keyMap.getAsString("key");
		fixName = keyMap.getAsString("fixName");
		iTracID = keyMap.getAsString("iTracID");
		generatedTime = keyMap.getAsString("generatedTime");
	}
	
	public IData getIData() {
		IDataMap keyMap = new IDataMap();
		keyMap.put("key", key);
		keyMap.put("fixName", fixName);
		keyMap.put("iTracID", iTracID);
		keyMap.put("generatedTime", generatedTime);
		return keyMap.getIData();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FixKeyConfig) {
			FixKeyConfig o = (FixKeyConfig)obj;
			if(o.getKey().equals(this.getKey())) {
				return true;
			}
		}
		return false;
	}
}
