package com.springbean;

import java.time.LocalDate;

public class SessionFinder {

	private LocalDate date;

	public SessionFinder() {
		System.out.println("SessionFinder.SessionFinder()");
	}

	public void setDate(LocalDate date) {
		System.out.println("SessionFinder.setDate()");
		this.date = date;
	}

	public String findSession(String user) {
		System.out.println("SessionFinder.findSession()");
		int month = date.getMonthValue();
		int year = date.getYear();

		String sessionName;

		if (month >= 1 && month <= 4)
			sessionName = "winter session";
		else if (month >= 5 && month <= 8)
			sessionName = "summer session";
		else
			sessionName = "fall session";

		return "Hello " + user + ", you are currently in \t" + sessionName + " " + year;
	}
}

    