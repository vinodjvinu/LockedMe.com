package com.simplilearn.project1;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class FileOperations {
        String file = null;
        String fileName = null;
        int choice = 0;	
        
	Scanner scan = new Scanner(System.in);
	
	public void appDetails() {
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("       Application Name : LockedMe.com         ");
		System.out.println("-----------------------------------------------");
		System.out.println("       Developer        : Vinod Jayaprakash");
		System.out.println("-----------------------------------------------");
		System.out.println("       Date             : 16th Nov 2021");
                System.out.println("-----------------------------------------------");
                System.out.println("       Description      : Supports file operations \n\t\t\t  like Listing, Adding, Deleting and Searching");
		System.out.println("-----------------------------------------------");
		System.out.println("\n\n");				
	}	
        
	public void mainOptions() {
                System.out.println("-------------------------------------");
                System.out.println("           LockedMe.com Options         ");
                System.out.println("-------------------------------------");
                System.out.println(" Select one of the below options:    ");
                System.out.println("     1 : List all the files");
                System.out.println("     2 : More options");
                System.out.println("     3 : Exit");
                System.out.println("-------------------------------------");
                System.out.println("Enter your choice : ");
	}

	public void moreOptions() {
                System.out.println("-------------------------------------");
                System.out.println("           LockedMe.com File Operations         ");
                System.out.println("-------------------------------------");
                System.out.println(" Select any one of the below file operations to be done " + "\n" + " under the Current Directory: " );
                System.out.println("     1 : Add a new file");
                System.out.println("     2 : Delete a file");
                System.out.println("     3 : Search a file");
                System.out.println("     4 : Go back to the main menu");
                System.out.println("     5 : Exit");
                System.out.println("-------------------------------------");
                System.out.println("Enter your choice : ");
	}	
	
	public void mainOptionsOperations(String path) throws IOException {
		
		int choice = 0;
		do {
			
			mainOptions();
			
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input \nValid Input is (1-3)\n");
				mainOptionsOperations(path);
			}
			
			
			switch (choice) {
			
			case 1:
                                        listAllFiles(path);
					System.out.println("\n***********************************\n");
					break;
					
			case 2: 
                                        moreOptionsOperations(path);
					System.out.println();
					break;					
                                        
                        case 3:
                                        System.out.println("Thank You. Good Bye!");
                                        System.exit(0);
                                        
                        default:
                                        System.out.println("\nInvalid Input \nPlease enter a number between 1 and 3 \n");
                                        mainOptionsOperations(path);
				
			}
			
			
		}while(true);
		
	}

	public void moreOptionsOperations(String path) throws IOException {
		
		int choice = 0;
		do {
			
			moreOptions();
			
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input \nValid Input Integers:(1-5)\n");
				moreOptionsOperations(path);
			}
			
			
			switch (choice) {
			
			case 1:
                                        addNewFile(path);
					System.out.println();
					break;
					
			case 2: 
                                        removeFile(path);
					System.out.println();
					break;     				
                                        
                        case 3:
                                        System.out.println("Please enter a file name to Search : ");
                                        file = scan.nextLine();
                                        searchFile(path, file);
                                        System.out.println();
                                        break; 
                        
                        case 4:         
                                        mainOptionsOperations(path);
					 System.out.println();
					 break;	

                        case 5:
                                        System.out.println("Thank You. Good Bye!");
                                        System.exit(0);
                                        
                        default:
                                        System.out.println("\nInvalid Input \nPlease enter a number between 1 and 5 \n");
                                        moreOptionsOperations(path);
				
			}
			
			
		}while(true);
		
	}

        
	public void listAllFiles(String path) {
		       
		File dirPath = new File(path);
		
		if(!dirPath.exists())
		        throw new IllegalArgumentException("Path does not exist");
		
		String [] files = dirPath.list();
		Arrays.sort(files);
		
		if(files != null && files.length > 0) {
	 
		        System.out.println("\nTotal Number of files/folders: "+ files.length );	 
		        System.out.println("\n\nThe Files in "+ dirPath.getAbsolutePath() + " are: \n");
		        for(String f:files) {
		                
		                System.out.println(f);
		                
		        }
		        
		}else {
		        
		        System.out.println("Directory is Empty");
		}
		
	}

	public void addNewFile(String path) throws IOException {
		
		System.out.println("Please enter a file name : ");
		file = scan.nextLine();  

		if (file == null || file.isEmpty() || file.isBlank())
		        throw new NullPointerException("File Name cannot be Empty or null"); 
	 
		File newFile = new File(path + File.separator + file);
		
		boolean createFile = newFile.createNewFile();
		
		if (createFile) {
		        
		        System.out.println("\nFile Successfully Created: " + newFile.getAbsolutePath());
		        
		}else if(!createFile) {
		        
		        System.out.println("\nFile Already Exist.. Please try again." );
		        
		}
		        
	}

	public void removeFile(String path ) {

		System.out.println("Please enter a file name to Delete : ");
		file = scan.nextLine();

		if (file == null || file.isEmpty() || file.isBlank())
		        throw new NullPointerException("File Name cannot be Empty or null"); 
		
		File newFile = new File(path + File.separator + file);
		
		boolean deleteFile = newFile.delete();
		
		if (deleteFile) {
		        
		        System.out.println("\nFile deleted Successfully");
		        
		}else {
		        
		        System.out.println("\nFile Not Found.. Please try again." );
		        
		}
		        
	}


	public void searchFile(String path, String filename) {

		File dirPath = new File(path);            
		String [] files = dirPath.list();           

		for (String file: files) {
		        if (filename.equals(file)) {
		        System.out.println("File " + filename + " exists(found) at " + dirPath.getAbsolutePath() );
		        return;
		        }
		}
		System.out.println("File NOT found (FNF)");
	    }
			
	
}
