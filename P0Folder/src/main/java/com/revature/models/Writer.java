package com.revature.models;

public class Writer {
	
	private int writer_id;
	private String f_name;
	private String l_name;
	
	
	
	//no args constructor
	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructor with all args
	public Writer(int writer_id, String f_name, String l_name) {
		super();
		this.writer_id = writer_id;
		this.f_name = f_name;
		this.l_name = l_name;
	}

	//all args minus writer id
	public Writer(String f_name, String l_name) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
	}

	//print out each objects fields
	@Override
	public String toString() {
		return "Writer [writer_id=" + writer_id + ", f_name=" + f_name + ", l_name=" + l_name + "]";
	}

	//assigns each object a hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + writer_id;
		return result;
	}

	//compares objects by their hashcode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Writer other = (Writer) obj;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		if (writer_id != other.writer_id)
			return false;
		return true;
	}

	//need to access private varibles
	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public int getWriter_id() {
		return writer_id;
	}
	
	
	
	
	

}
