package com.revature.models;

public class Journal {
	
	private int journal_id;
	private String journal_entry;
	private String entry_date;
	private int writer_id;
	
	//no args constructor
	public Journal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//all args constructor
	public Journal(int journal_id, String journal_entry, String entry_date, int writer_id) {
		super();
		this.journal_id = journal_id;
		this.journal_entry = journal_entry;
		this.entry_date = entry_date;
		this.writer_id = writer_id;
	}

	//constructor to create a new journal entry
	public Journal(int writer_id, String journal_entry, String entry_date) {
		super();
		this.journal_entry = journal_entry;
		this.entry_date = entry_date;
		this.writer_id = writer_id;
	}

	
	@Override
	public String toString() {
		return "Journal [journal_id=" + journal_id + ", journal_entry=" + journal_entry + ", entry_date=" + entry_date
				+ ", writer_id=" + writer_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entry_date == null) ? 0 : entry_date.hashCode());
		result = prime * result + ((journal_entry == null) ? 0 : journal_entry.hashCode());
		result = prime * result + journal_id;
		result = prime * result + writer_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Journal other = (Journal) obj;
		if (entry_date == null) {
			if (other.entry_date != null)
				return false;
		} else if (!entry_date.equals(other.entry_date))
			return false;
		if (journal_entry == null) {
			if (other.journal_entry != null)
				return false;
		} else if (!journal_entry.equals(other.journal_entry))
			return false;
		if (journal_id != other.journal_id)
			return false;
		if (writer_id != other.writer_id)
			return false;
		return true;
	}

	public String getJournal_entry() {
		return journal_entry;
	}

	public void setJournal_entry(String journal_entry) {
		this.journal_entry = journal_entry;
	}

	public String getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	public int getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(int writer_id) {
		this.writer_id = writer_id;
	}

	public int getJournal_id() {
		return journal_id;
	}
	
	
	

}
