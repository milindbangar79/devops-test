/**
 * 
 */
package com.aws.resources.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;


/**
 * @author milindbangar
 *
 */
public class InstanceObj implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1000348272787831131L;

	private  String imageId;

    private  String instanceId;

    private  String instanceType;

    private  String kernelId;

    private  String keyName;

    private  Instant launchTime;
    
    //Map to Monitoring Object of response
    private  String monitoring; 
    
    // Map to Placement object in response
    private String availabilityZone;

    private String affinity;

    private String groupName;

    private Integer partitionNumber;

    private String hostId;

    private String tenancy;

    private String spreadDomain;
    
    private  String platform;

    private  String privateIpAddress;

    private  String publicDnsName;

    private  String publicIpAddress;

    private  String stateTransitionReason;

    private  String subnetId;

    private  String vpcId;

    private  String architecture;

    private  Boolean ebsOptimized;

    private  Boolean enaSupport;

    private  String hypervisor;
    
    private  String rootDeviceName;

    private  String rootDeviceType;

    private  List<InstanceGroupIdentifier> securityGroups;

    private  Boolean sourceDestCheck;

    private  String spotInstanceRequestId;

    private  String sriovNetSupport;

    private  String virtualizationType;

	/**
	 * @return the imageId
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

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
	 * @return the instanceType
	 */
	public String getInstanceType() {
		return instanceType;
	}

	/**
	 * @param instanceType the instanceType to set
	 */
	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}

	/**
	 * @return the kernelId
	 */
	public String getKernelId() {
		return kernelId;
	}

	/**
	 * @param kernelId the kernelId to set
	 */
	public void setKernelId(String kernelId) {
		this.kernelId = kernelId;
	}

	/**
	 * @return the keyName
	 */
	public String getKeyName() {
		return keyName;
	}

	/**
	 * @param keyName the keyName to set
	 */
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	/**
	 * @return the launchTime
	 */
	public Instant getLaunchTime() {
		return launchTime;
	}

	/**
	 * @param launchTime the launchTime to set
	 */
	public void setLaunchTime(Instant launchTime) {
		this.launchTime = launchTime;
	}

	/**
	 * @return the monitoring
	 */
	public String getMonitoring() {
		return monitoring;
	}

	/**
	 * @param monitoring the monitoring to set
	 */
	public void setMonitoring(String monitoring) {
		this.monitoring = monitoring;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
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

	/**
	 * @return the publicDnsName
	 */
	public String getPublicDnsName() {
		return publicDnsName;
	}

	/**
	 * @param publicDnsName the publicDnsName to set
	 */
	public void setPublicDnsName(String publicDnsName) {
		this.publicDnsName = publicDnsName;
	}

	/**
	 * @return the publicIpAddress
	 */
	public String getPublicIpAddress() {
		return publicIpAddress;
	}

	/**
	 * @param publicIpAddress the publicIpAddress to set
	 */
	public void setPublicIpAddress(String publicIpAddress) {
		this.publicIpAddress = publicIpAddress;
	}

	/**
	 * @return the stateTransitionReason
	 */
	public String getStateTransitionReason() {
		return stateTransitionReason;
	}

	/**
	 * @param stateTransitionReason the stateTransitionReason to set
	 */
	public void setStateTransitionReason(String stateTransitionReason) {
		this.stateTransitionReason = stateTransitionReason;
	}

	/**
	 * @return the subnetId
	 */
	public String getSubnetId() {
		return subnetId;
	}

	/**
	 * @param subnetId the subnetId to set
	 */
	public void setSubnetId(String subnetId) {
		this.subnetId = subnetId;
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
	 * @return the architecture
	 */
	public String getArchitecture() {
		return architecture;
	}

	/**
	 * @param architecture the architecture to set
	 */
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	/**
	 * @return the ebsOptimized
	 */
	public Boolean getEbsOptimized() {
		return ebsOptimized;
	}

	/**
	 * @param ebsOptimized the ebsOptimized to set
	 */
	public void setEbsOptimized(Boolean ebsOptimized) {
		this.ebsOptimized = ebsOptimized;
	}

	/**
	 * @return the enaSupport
	 */
	public Boolean getEnaSupport() {
		return enaSupport;
	}

	/**
	 * @param enaSupport the enaSupport to set
	 */
	public void setEnaSupport(Boolean enaSupport) {
		this.enaSupport = enaSupport;
	}

	/**
	 * @return the hypervisor
	 */
	public String getHypervisor() {
		return hypervisor;
	}

	/**
	 * @param hypervisor the hypervisor to set
	 */
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	/**
	 * @return the rootDeviceName
	 */
	public String getRootDeviceName() {
		return rootDeviceName;
	}

	/**
	 * @param rootDeviceName the rootDeviceName to set
	 */
	public void setRootDeviceName(String rootDeviceName) {
		this.rootDeviceName = rootDeviceName;
	}

	/**
	 * @return the rootDeviceType
	 */
	public String getRootDeviceType() {
		return rootDeviceType;
	}

	/**
	 * @param rootDeviceType the rootDeviceType to set
	 */
	public void setRootDeviceType(String rootDeviceType) {
		this.rootDeviceType = rootDeviceType;
	}

	/**
	 * @return the securityGroups
	 */
	public List<InstanceGroupIdentifier> getSecurityGroups() {
		return securityGroups;
	}

	/**
	 * @param securityGroups the securityGroups to set
	 */
	public void setSecurityGroups(List<InstanceGroupIdentifier> securityGroups) {
		this.securityGroups = securityGroups;
	}

	/**
	 * @return the sourceDestCheck
	 */
	public Boolean getSourceDestCheck() {
		return sourceDestCheck;
	}

	/**
	 * @param sourceDestCheck the sourceDestCheck to set
	 */
	public void setSourceDestCheck(Boolean sourceDestCheck) {
		this.sourceDestCheck = sourceDestCheck;
	}

	/**
	 * @return the spotInstanceRequestId
	 */
	public String getSpotInstanceRequestId() {
		return spotInstanceRequestId;
	}

	/**
	 * @param spotInstanceRequestId the spotInstanceRequestId to set
	 */
	public void setSpotInstanceRequestId(String spotInstanceRequestId) {
		this.spotInstanceRequestId = spotInstanceRequestId;
	}

	/**
	 * @return the sriovNetSupport
	 */
	public String getSriovNetSupport() {
		return sriovNetSupport;
	}

	/**
	 * @param sriovNetSupport the sriovNetSupport to set
	 */
	public void setSriovNetSupport(String sriovNetSupport) {
		this.sriovNetSupport = sriovNetSupport;
	}

	/**
	 * @return the virtualizationType
	 */
	public String getVirtualizationType() {
		return virtualizationType;
	}

	/**
	 * @param virtualizationType the virtualizationType to set
	 */
	public void setVirtualizationType(String virtualizationType) {
		this.virtualizationType = virtualizationType;
	}

	/**
	 * @return the availabilityZone
	 */
	public String getAvailabilityZone() {
		return availabilityZone;
	}

	/**
	 * @return the affinity
	 */
	public String getAffinity() {
		return affinity;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @return the partitionNumber
	 */
	public Integer getPartitionNumber() {
		return partitionNumber;
	}

	/**
	 * @return the hostId
	 */
	public String getHostId() {
		return hostId;
	}

	/**
	 * @return the tenancy
	 */
	public String getTenancy() {
		return tenancy;
	}

	/**
	 * @return the spreadDomain
	 */
	public String getSpreadDomain() {
		return spreadDomain;
	}

}
