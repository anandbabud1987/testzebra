package com.zebra.model;

import java.io.Serializable;

public class MustardProduction implements Serializable {

	private String year;
	private String dollars;
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the dollars
	 */
	public String getDollars() {
		return dollars;
	}
	/**
	 * @param dollars the dollars to set
	 */
	public void setDollars(String dollars) {
		this.dollars = dollars;
	}
}
