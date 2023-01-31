package FixBuilding.com.sag;
import java.io.File;
import java.io.FileFilter;


public class ClassFileFilter implements FileFilter{

	public boolean accept(File pathname) {
		if(pathname.isDirectory()) {
			return false;
		} 
		if(!pathname.getName().endsWith("class")) {
			return false;
		}
		return true;
	}

}
