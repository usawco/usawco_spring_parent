package FixBuilding.com.sag;

public class PackageFix {
	private String packgeName;
	private String pkgZipName;
	private String pkgZipPath;
	public String getPackgeName() {
		return packgeName;
	}
	public void setPackgeName(String packgeName) {
		this.packgeName = packgeName;
	}
	public String getPkgZipName() {
		return pkgZipName;
	}
	public void setPkgZipName(String pkgZipName) {
		this.pkgZipName = pkgZipName;
	}
	public String getPkgZipPath() {
		return pkgZipPath;
	}
	public void setPkgZipPath(String pkgZipPath) {
		this.pkgZipPath = pkgZipPath;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PackageFix) {
			if(((PackageFix) obj).getPackgeName().equals(this.packgeName)) {
				return true;
			}
		} 
		
		return false;
	}
	
}
