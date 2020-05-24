package com.company.project.model.po;

public class StudentPo {
	
	private int Sid;
	
	private String Sname;
	
	private String Sbirthday;
	
	private String Ssex;

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSbirthday() {
		return Sbirthday;
	}

	public void setSbirthday(String sbirthday) {
		Sbirthday = sbirthday;
	}

	public String getSsex() {
		return Ssex;
	}

	public void setSsex(String ssex) {
		Ssex = ssex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Sbirthday == null) ? 0 : Sbirthday.hashCode());
		result = prime * result + Sid;
		result = prime * result + ((Sname == null) ? 0 : Sname.hashCode());
		result = prime * result + ((Ssex == null) ? 0 : Ssex.hashCode());
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
		StudentPo other = (StudentPo) obj;
		if (Sbirthday == null) {
			if (other.Sbirthday != null)
				return false;
		} else if (!Sbirthday.equals(other.Sbirthday))
			return false;
		if (Sid != other.Sid)
			return false;
		if (Sname == null) {
			if (other.Sname != null)
				return false;
		} else if (!Sname.equals(other.Sname))
			return false;
		if (Ssex == null) {
			if (other.Ssex != null)
				return false;
		} else if (!Ssex.equals(other.Ssex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentPo [Sid=" + Sid + ", Sname=" + Sname + ", Sbirthday=" + Sbirthday + ", Ssex=" + Ssex + "]";
	}
	
	
}