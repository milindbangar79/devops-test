/**
 * 
 */
package com.aws.resources.domain;

import java.io.Serializable;

/**
 * @author milindbangar
 *
 */
public class PrefixListIdObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String description;

    private String prefixListId;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the prefixListId
	 */
	public String getPrefixListId() {
		return prefixListId;
	}

	/**
	 * @param prefixListId the prefixListId to set
	 */
	public void setPrefixListId(String prefixListId) {
		this.prefixListId = prefixListId;
	}
    
    

}
