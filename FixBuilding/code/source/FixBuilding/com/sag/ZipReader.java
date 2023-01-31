package FixBuilding.com.sag;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
 
public class ZipReader
{
	
    // Expands the zip file passed as argument 1, into the
    // directory provided in argument 2
    public static InputStream getFileEntry(File zipFile, String entryName) throws Exception
    {
 
        // open the zip file stream
        InputStream theFile = new FileInputStream(zipFile);
        ZipInputStream stream = new ZipInputStream(theFile);
        try
        {
 
            // now iterate through each item in the stream. The get next
            // entry call will return a ZipEntry for each file in the
            // stream
            ZipEntry entry = null;
            while((entry = stream.getNextEntry())!=null)
            {
            	if(entry.getName().equals(entryName)) {
            		return stream;
            	}
            }
        } catch (Exception e) {
        	throw new IOException("Error in reading package zip :"+zipFile.getName()+" Error is: "+e.getMessage());
        }
        return null;
    }
}
