package FixBuilding.com.sag;
import java.io.File;
import java.io.FileFilter;


public class DirFileFilter implements FileFilter{

	public boolean accept(File pathname) {
		if(pathname.isDirectory()) {
			return true;
		} 
		return false;
	}

}
