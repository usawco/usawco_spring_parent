package FixBuilding.com.sag;
import java.io.File;
import java.io.FileFilter;


public class JarFileFilter implements FileFilter{

	public boolean accept(File pathname) {
		if(!pathname.isDirectory() && pathname.getName().endsWith("jar")) {
			return true;
		}
		return false;
	}

}
