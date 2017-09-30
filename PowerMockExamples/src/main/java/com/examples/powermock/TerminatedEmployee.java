package com.examples.powermock;

import java.util.Date;

public final class TerminatedEmployee extends Employee {
	private Date terminationDate;

	public TerminatedEmployee(Date terminationDate) {
		super();
		this.terminationDate = terminationDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	
}
