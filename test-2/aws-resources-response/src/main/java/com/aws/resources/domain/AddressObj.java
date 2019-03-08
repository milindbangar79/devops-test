package com.aws.resources.domain;

import java.io.Serializable;

public class AddressObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8237046748599503260L;

	private String instanceId;

    private String publicIp;

    private String allocationId;

    private String associationId;

    private String domain;

    private String networkInterfaceId;

    private String networkInterfaceOwnerId;

    private String privateIpAddress;

	/**
	 * @return the instanceId
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * @return the publicIp
	 */
	public String getPublicIp() {
		return publicIp;
	}

	/**
	 * @param publicIp the publicIp to set
	 */
	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

	/**
	 * @return the allocationId
	 */
	public String getAllocationId() {
		return allocationId;
	}

	/**
	 * @param allocationId the allocationId to set
	 */
	public void setAllocationId(String allocationId) {
		this.allocationId = allocationId;
	}

	/**
	 * @return the associationId
	 */
	public String getAssociationId() {
		return associationId;
	}

	/**
	 * @param associationId the associationId to set
	 */
	public void setAssociationId(String associationId) {
		this.associationId = associationId;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the networkInterfaceId
	 */
	public String getNetworkInterfaceId() {
		return networkInterfaceId;
	}

	/**
	 * @param networkInterfaceId the networkInterfaceId to set
	 */
	public void setNetworkInterfaceId(String networkInterfaceId) {
		this.networkInterfaceId = networkInterfaceId;
	}

	/**
	 * @return the networkInterfaceOwnerId
	 */
	public String getNetworkInterfaceOwnerId() {
		return networkInterfaceOwnerId;
	}

	/**
	 * @param networkInterfaceOwnerId the networkInterfaceOwnerId to set
	 */
	public void setNetworkInterfaceOwnerId(String networkInterfaceOwnerId) {
		this.networkInterfaceOwnerId = networkInterfaceOwnerId;
	}

	/**
	 * @return the privateIpAddress
	 */
	public String getPrivateIpAddress() {
		return privateIpAddress;
	}

	/**
	 * @param privateIpAddress the privateIpAddress to set
	 */
	public void setPrivateIpAddress(String privateIpAddress) {
		this.privateIpAddress = privateIpAddress;
	}
    
    
	
}
