package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Writer;
import com.revature.utils.ConnectionUtil;

public class WriterDao implements WriterDaoInterface {

	public List<Writer> getWriters() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//empty ResultSet that will store the results of the query
			ResultSet rs = null;
			
			//string to hold the query
			String sql = "SELECT * FROM \"journal\".writers;";
			
			//object to send the query to the DB
			Statement s = conn.createStatement();
			
			//execute the query using the statement
			rs = s.executeQuery(sql);
			
			//System.out.println(rs.getString("f_name"));
			//System.out.println("this is the rs: " + rs);
			
			List<Writer> writerList = new ArrayList<>();
			
			while(rs.next()) {
				//System.out.println(rs.getString("f_name"));
				Writer writer = new Writer(
						rs.getInt("writer_id"),
						rs.getString("f_name"),
						rs.getString("l_name"));
			
			
				//add new writer object to the arrayList
				writerList.add(writer);
				
				
			}
			
			
			return writerList;
			
		} catch (SQLException e) {
			System.out.println("There was a problem accessing with the DB");
			e.printStackTrace();
		}
		
		
		return null;
	}

	public void addWriter(Writer wrt) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			//sql statement to insert new writer
			String sql = "INSERT INTO writers (f_name, l_name) " + 
							"VALUES (?, ?);";
			
			//preparedStatement for sql with parameters
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, wrt.getF_name());
			ps.setString(2, wrt.getL_name());
			
			//execute the sql command
			ps.executeUpdate();
			
			System.out.println("Writer " + wrt.getF_name() + " " + wrt.getL_name() + " has been created :)");
			
			
		} catch(SQLException e) {
			System.out.println("Add writer failed");
			e.printStackTrace();
		}
		
	}

	public void deleteWriter(int wrtId) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "DELETE FROM writers WHERE writer_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, wrtId);
			
			ps.executeUpdate();
			
			System.out.println("Writer #" + wrtId + " has been deleted");
			
		} catch(SQLException e) {
			System.out.println("Delete Writer Failed!");
			e.printStackTrace();
		}
		
	}

}
