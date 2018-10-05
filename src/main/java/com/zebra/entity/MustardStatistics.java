/**
 * 
 */
package com.zebra.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
//µimport com.opencsv.bean.CsvBindByName;

/**
 * @author agl
 *
 */
@Entity
@JsonInclude(Include.NON_EMPTY)
@Table(name="mustard_stat")
@NamedQueries(
		@NamedQuery
		(name="MustardStatistics.FindAll", query="SELECT a FROM MustardStatistics a") 		
		)
public class MustardStatistics {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="year",length=50)
	private String year;
	@Column(name="dollar",length=30)
	private BigInteger dollar; 

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the dollar
	 */
	public BigInteger getDollar() {
		return dollar;
	}

	/**
	 * @param dollar the dollar to set
	 */
	public void setDollar(BigInteger dollar) {
		this.dollar = dollar;
	}

	/**
	 * 
	 */
	public MustardStatistics() {
		// TODO Auto-generated constructor stub
	}

}
