/**
 * 
 */
package com.aws.resources.domain;

import java.io.Serializable;

/**
 * @author milindbangar
 *
 */
public class IpRangeObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8437287526291046428L;
	
	private String cidrIp;

    private String description;

	/**
	 * @return the cidrIp
	 */
	public String getCidrIp() {
		return cidrIp;
	}

	/**
	 * @param cidrIp the cidrIp to set
	 */
	public void setCidrIp(String cidrIp) {
		this.cidrIp = cidrIp;
	}

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
    
    

}
