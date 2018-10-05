/**
 * 
 */
package com.zebra.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author agl
 *
 */
public class MustardStatResponse implements Serializable{


	private static final long serialVersionUID = -3933160490152852370L;

	
	private String message;
	private Date retrivel_time;
	private List<MustardProduction> mustard_production;
	
	public MustardStatResponse(String message,Date retrivel_time,List<MustardProduction> mustard_production) {
		this.message=message;
		this.retrivel_time=retrivel_time;
		this.mustard_production=mustard_production;
	}
	public MustardStatResponse() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the retrivel_time
	 */
	public Date getRetrivel_time() {
		return retrivel_time;
	}
	/**
	 * @param retrivel_time the retrivel_time to set
	 */
	public void setRetrivel_time(Date retrivel_time) {
		this.retrivel_time = retrivel_time;
	}
	/**
	 * @return the mustard_production
	 */
	public List<MustardProduction> getMustard_production() {
		return mustard_production;
	}
	/**
	 * @param mustard_production the mustard_production to set
	 */
	public void setMustard_production(List<MustardProduction> mustard_production) {
		this.mustard_production = mustard_production;
	}
	
	
}
