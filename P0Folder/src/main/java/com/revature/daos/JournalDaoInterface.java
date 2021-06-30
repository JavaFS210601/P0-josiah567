package com.revature.daos;

import java.util.List;

import com.revature.models.Journal;
import com.revature.models.Writer;

public interface JournalDaoInterface {
	
	public List<Journal> getJournalByWriter(int writer_id);
	
	public void AddJournal(Journal jrn);
	
	public void updateJournal(String journalEntry, int journal_id);
	
	public List<Journal> getJournals();
	

}
