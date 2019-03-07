/**
 * 
 */
package com.aws.resources.domain;

import java.io.Serializable;

/**
 * @author milindsandhya
 *
 */
public class InstanceGroupIdentifier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7491316231135139863L;
	
	private String groupName;

    private String groupId;

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
    
  

}
