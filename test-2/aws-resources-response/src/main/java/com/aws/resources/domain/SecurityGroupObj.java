package com.aws.resources.domain;

import java.io.Serializable;
import java.util.List;


public class SecurityGroupObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  String description;

    private  String groupName;

    private  List<IpPermissionObj> ipPermissions;

    private  String ownerId;

    private  String groupId;

    private  List<IpPermissionObj> ipPermissionsEgress;

    private  String vpcId;

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
	 * @return the ipPermissions
	 */
	public List<IpPermissionObj> getIpPermissions() {
		return ipPermissions;
	}

	/**
	 * @param ipPermissions the ipPermissions to set
	 */
	public void setIpPermissions(List<IpPermissionObj> ipPermissions) {
		this.ipPermissions = ipPermissions;
	}

	/**
	 * @return the ownerId
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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

	/**
	 * @return the ipPermissionsEgress
	 */
	public List<IpPermissionObj> getIpPermissionsEgress() {
		return ipPermissionsEgress;
	}

	/**
	 * @param ipPermissionsEgress the ipPermissionsEgress to set
	 */
	public void setIpPermissionsEgress(List<IpPermissionObj> ipPermissionsEgress) {
		this.ipPermissionsEgress = ipPermissionsEgress;
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
    
    

}
