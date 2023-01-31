package FixBuilding.com.sag;
import java.io.File;
import java.io.FileFilter;


public class ZipFileFilter implements FileFilter{

	public boolean accept(File pathname) {
		if(!pathname.isDirectory() && pathname.getName().endsWith("zip")) {
			return true;
		}
		return false;
	}

}
