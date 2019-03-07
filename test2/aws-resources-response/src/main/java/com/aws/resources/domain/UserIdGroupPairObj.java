/**
 * 
 */
package com.aws.resources.domain;

import java.io.Serializable;

/**
 * @author milindsandhya
 *
 */
public class UserIdGroupPairObj implements Serializable{

	/**
	 * 
	 */
	private static  long serialVersionUID = 7493440341767094920L;
	
	private  String groupId;

    private  String groupName;

    private  String peeringStatus;

    private  String userId;

    private  String vpcId;

    private  String vpcPeeringConnectionId;

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
	 * @return the peeringStatus
	 */
	public String getPeeringStatus() {
		return peeringStatus;
	}

	/**
	 * @param peeringStatus the peeringStatus to set
	 */
	public void setPeeringStatus(String peeringStatus) {
		this.peeringStatus = peeringStatus;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the vpcId
	 */
	public String getVpcId() {
		return vpcId;
	}

	/**
	 * @param vpcId the vpcId to set
	 */
	public void setVpcId(String vpcId) {
		this.vpcId = vpcId;
	}

	/**
	 * @return the vpcPeeringConnectionId
	 */
	public String getVpcPeeringConnectionId() {
		return vpcPeeringConnectionId;
	}

	/**
	 * @param vpcPeeringConnectionId the vpcPeeringConnectionId to set
	 */
	public void setVpcPeeringConnectionId(String vpcPeeringConnectionId) {
		this.vpcPeeringConnectionId = vpcPeeringConnectionId;
	}
    
    

}
