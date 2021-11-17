package com.simplilearn.project1;

import java.io.File;
import java.io.IOException;

public class FileOperationsRunner {
	 	   
	public static void main(String[] args) throws IOException {
		
		String userDirPath = System.getProperty("user.dir") + File.separator + "Main";

		File folderName = new File(userDirPath);
		
	    if (!folderName.exists())
	    	folderName.mkdir();	      
	      
		FileOperations fo = new FileOperations();
		fo.appDetails();
		System.out.println("DIRECTORY is : "+ folderName.getAbsolutePath());
		fo.mainOptionsOperations(userDirPath);
	}
	
}