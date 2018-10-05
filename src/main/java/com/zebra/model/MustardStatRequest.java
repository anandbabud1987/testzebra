/**
 * 
 */
package com.zebra.model;

import java.io.Serializable;

/**
 * @author agl
 *
 */
public class MustardStatRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5572584991890267236L;
	private String dollar;
	private String year;
	/**
	 * @return the dollar
	 */
	public String getDollar() {
		return dollar;
	}
	/**
	 * @param dollar the dollar to set
	 */
	public void setDollar(String dollar) {
		this.dollar = dollar;
	}
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

}
