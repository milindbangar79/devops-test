/**
 * 
 */
package com.aws.resources.domain;

import java.io.Serializable;

/**
 * @author milindsandhya
 *
 */
public class RegionObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String endpoint;

	private String regionName;

	/**
	 * @return the endpoint
	 */
	public String getEndpoint() {
		return endpoint;
	}

	/**
	 * @param endpoint the endpoint to set
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	
}
