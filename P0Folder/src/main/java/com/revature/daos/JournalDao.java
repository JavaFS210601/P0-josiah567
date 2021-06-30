package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Journal;
import com.revature.models.Writer;
import com.revature.utils.ConnectionUtil;

public class JournalDao implements JournalDaoInterface {

	@Override
	public List<Journal> getJournalByWriter(int writer_id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT * FROM journals where writer_id_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, writer_id);
			
			rs = ps.executeQuery();
			
			List<Journal> returnedJournal = new ArrayList<>();
			
			while(rs.next()) {
				
				Journal journal = new Journal(
						rs.getInt("journal_id"),
						rs.getString("journal_entry"),
						rs.getString("entry_date"),
						rs.getInt("writer_id_fk")
						);
				
				returnedJournal.add(journal);
			}
			
			return returnedJournal;
			
		} catch(SQLException e) {
			System.out.println("Get journal by writer failed");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void AddJournal(Journal jrn) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			//sql statement to insert new writer
			String sql = "INSERT INTO journals (writer_id_fk, journal_entry, entry_date) " + 
							"VALUES (?, ?, ?);";
			
			//preparedStatement for sql with parameters
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, jrn.getWriter_id());
			ps.setString(2, jrn.getJournal_entry());
			ps.setString(3, jrn.getEntry_date());
			
			//execute the sql command
			ps.executeUpdate();
			
			System.out.println("Journal for writer #" + jrn.getWriter_id() + " has been created :)");
			
			
		} catch(SQLException e) {
			System.out.println("Add journal failed");
			e.printStackTrace();
		}
			
		
		}

	@Override
	public void updateJournal(String journalEntry, int journal_id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE journals SET journal_entry = ? WHERE journal_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, journalEntry);
			ps.setInt(2, journal_id);
			ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Updating the journal failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Journal> getJournals() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//empty ResultSet that will store the results of the query
			ResultSet rs = null;
			
			//string to hold the query
			String sql = "SELECT * FROM \"journal\".journals;";
			
			//object to send the query to the DB
			Statement s = conn.createStatement();
			
			//execute the query using the statement
			rs = s.executeQuery(sql);
			
			//System.out.println(rs.getString("f_name"));
			//System.out.println("this is the rs: " + rs);
			
			List<Journal> journalList = new ArrayList<>();
			
			while(rs.next()) {
				//System.out.println(rs.getString("f_name"));
				Journal journal = new Journal(
						rs.getInt("journal_id"),
						rs.getString("journal_entry"),
						rs.getString("entry_date"),
						rs.getInt("writer_id_fk"));
			
			
				//add new writer object to the arrayList
				journalList.add(journal);
				
				
			}
			
			
			return journalList;
			
		} catch (SQLException e) {
			System.out.println("There was a problem accessing with the DB");
			e.printStackTrace();
		}
		
		
		return null;
	
	}

}
