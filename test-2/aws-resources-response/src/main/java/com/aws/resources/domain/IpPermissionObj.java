package com.aws.resources.domain;

import java.io.Serializable;
import java.util.List;

public class IpPermissionObj implements Serializable{

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static  long serialVersionUID = -5020780247944968631L;

	
	private  Integer fromPort;

    private  String ipProtocol;

    private  List<IpRangeObj> ipRanges;

    private  List<PrefixListIdObj> prefixListIds;

    private  Integer toPort;

    private  List<UserIdGroupPairObj> userIdGroupPairs;

	/**
	 * @return the fromPort
	 */
	public Integer getFromPort() {
		return fromPort;
	}

	/**
	 * @param fromPort the fromPort to set
	 */
	public void setFromPort(Integer fromPort) {
		this.fromPort = fromPort;
	}

	/**
	 * @return the ipProtocol
	 */
	public String getIpProtocol() {
		return ipProtocol;
	}

	/**
	 * @param ipProtocol the ipProtocol to set
	 */
	public void setIpProtocol(String ipProtocol) {
		this.ipProtocol = ipProtocol;
	}

	/**
	 * @return the ipRanges
	 */
	public List<IpRangeObj> getIpRanges() {
		return ipRanges;
	}

	/**
	 * @param ipRanges the ipRanges to set
	 */
	public void setIpRanges(List<IpRangeObj> ipRanges) {
		this.ipRanges = ipRanges;
	}

	/**
	 * @return the prefixListIds
	 */
	public List<PrefixListIdObj> getPrefixListIds() {
		return prefixListIds;
	}

	/**
	 * @param prefixListIds the prefixListIds to set
	 */
	public void setPrefixListIds(List<PrefixListIdObj> prefixListIds) {
		this.prefixListIds = prefixListIds;
	}

	/**
	 * @return the toPort
	 */
	public Integer getToPort() {
		return toPort;
	}

	/**
	 * @param toPort the toPort to set
	 */
	public void setToPort(Integer toPort) {
		this.toPort = toPort;
	}

	/**
	 * @return the userIdGroupPairs
	 */
	public List<UserIdGroupPairObj> getUserIdGroupPairs() {
		return userIdGroupPairs;
	}

	/**
	 * @param userIdGroupPairs the userIdGroupPairs to set
	 */
	public void setUserIdGroupPairs(List<UserIdGroupPairObj> userIdGroupPairs) {
		this.userIdGroupPairs = userIdGroupPairs;
	}
    
    
	
}
