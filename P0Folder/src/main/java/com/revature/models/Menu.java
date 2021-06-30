package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.JournalDao;
import com.revature.daos.WriterDao;

public class Menu {
	
	//instantiate the dao classes to use their methods
	WriterDao wd = new WriterDao();
	JournalDao jd = new JournalDao();
	
	//creating the display method to show the options to the user and get input
	public void display() {
		
		//Variable to track the user input
		//boolean displayMenu = true;
		int display = 0;
		//scanner to get user input
		Scanner scan = new Scanner(System.in);
		final Logger log = LogManager.getLogger(Menu.class);
		
		//start of the menu
		System.out.println("Welcome to the Personal Journal\n");
		
		
		//while loop to loop through the menu
		while(display != 7) {
			
			System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
			System.out.println("   Select a number to Continue");
			System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
			
			//menu options
			System.out.println("1) View all the writers");
			System.out.println("2) Add a new writer");
			System.out.println("3) Delete a writer");
			System.out.println("4) View journals");
			System.out.println("5) Add a new journal");
			System.out.println("6) Change a journal");
			System.out.println("7) Quit");
			
			//get the user input 
			//int userInput = scan.nextInt();
			
			switch(display = scan.nextInt()) {
				case 1: {
					System.out.println("Gathering all writers...\n");
					
					//list of writers gets populated by getWriters\
					List<Writer> writers = wd.getWriters();
					
					//print out the Employee
					for(Writer w : writers) {
						System.out.println(w.getWriter_id() + ") " + w.getF_name() + " " + w.getL_name());
					}
				
					break;
				}
				case 2: {
					//to eat up the nextInt in the switch
					scan.nextLine();
					
					//get the first and last name form the user
					System.out.println("Enter the New Writer's First Name");
					String f_name = scan.nextLine();
					
					
					System.out.println("Enter the New Writer's Last Name");
					String l_name = scan.nextLine();
					
					
					//use the constructor to make a new writer object
					Writer newWriter = new Writer(f_name, l_name);
					
					//put the new writer in the .addWriter method
					wd.addWriter(newWriter);
					
					log.info("User created a new writer");
				
					break;
				}
				case 3: {
					System.out.println("Here is the writer list");
					
					List<Writer> writers = wd.getWriters();
					
					for(Writer w : writers) {
						System.out.println(w.getWriter_id() + ") " + w.getF_name() + " " + w.getL_name());
					}
					
					scan.nextLine();
					System.out.println("\nEnter in the writer Id from the list:");
					int idInput = scan.nextInt();
					scan.nextLine();
					
					wd.deleteWriter(idInput);
					
				
					
				
					break;
				}
				case 4: {
					System.out.println("Here is the writer list");
					
					List<Writer> writers = wd.getWriters();
					
					for(Writer w : writers) {
						System.out.println(w.getWriter_id() + ") " + w.getF_name() + " " + w.getL_name());
					}
					
					scan.nextLine();					
					System.out.println("Enter writer Id to see journals");
					int writer_id = scan.nextInt();
					
					List<Journal> returnedJournal = jd.getJournalByWriter(writer_id);
					
					for (Journal j : returnedJournal) {
						System.out.println("Date: " + j.getEntry_date() + " | Journal entry: " + j.getJournal_entry());
					}
								
					break;
				}
				case 5: {
					System.out.println("Here is the writer list");
					
					List<Writer> writers = wd.getWriters();
					
					for(Writer w : writers) {
						System.out.println(w.getWriter_id() + ") " + w.getF_name() + " " + w.getL_name());
					}
					
					scan.nextLine();
					System.out.println("Enter writer Id to make a new journal");
					int writerId = scan.nextInt();
					
					scan.nextLine();
					System.out.println("Enter journal");
					String journal_entry = scan.nextLine();
					
					System.out.println("Enter date for journal (Format: MM/DD/YYYY)");
					String journal_date = scan.nextLine();
					
					Journal newJournal = new Journal(writerId, journal_entry, journal_date);
					
					jd.AddJournal(newJournal);
					
					log.info("Created new journal entry");
					break;
				}
				case 6: {
					System.out.println("Here is the writer list");
					
					List<Writer> writers = wd.getWriters();
					
					for(Writer w : writers) {
						System.out.println(w.getWriter_id() + ") " + w.getF_name() + " " + w.getL_name());
					}
					
					scan.nextLine();
					System.out.println("Enter writer Id to see journals");
					int writer_id = scan.nextInt();
					
					List<Journal> returnedJournal = jd.getJournalByWriter(writer_id);
					
					for (Journal j : returnedJournal) {
						
						System.out.println("Journal ID: "+ j.getJournal_id() + " | Journal entry: " + j.getJournal_entry() + " | Date: " + j.getEntry_date());
					}
					
					scan.nextLine();
					System.out.println("Enter journal Id to change it");
					int journal_id = scan.nextInt();
					
					scan.nextLine();
					System.out.println("Enter new journal");
					String journal_entry = scan.nextLine();
					
					jd.updateJournal(journal_entry,journal_id);
					
					System.out.println("Updated journal for writer #" + writer_id + " has been created");
					
					break;
				}
				case 7: {
					System.out.println("You have exited the Personal Journal");
					scan.close();
					break;
				}
				default: {
					System.out.println("Please enter a valid input!");
					log.warn("The user typed an invalid input");
					break;
				}
				
				
				
			}
			
		}
		
	}

}
