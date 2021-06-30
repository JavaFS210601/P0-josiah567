package com.revature.daos;

import java.util.List;

import com.revature.models.Writer;

public interface WriterDaoInterface {
	
	//returns a list of the writers
	public List<Writer> getWriters();
	
	//makes a writer and adds it to the database
	public void addWriter(Writer wrt);
	
	//deletes a writer
	public void deleteWriter(int wrtId);
	
	//returns a list of 

}
