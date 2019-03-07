package com.aws.resources.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author milindbangar
 * Class to create an object of data returned from AWS resources and print it as JSON
 *
 */

public class EC2OutputDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -760803557988831002L;
	
	private List<AddressObj> address;
	private List<ZoneObj> zone;
	private List<InstanceObj> instance;
	private List<KeyPairObj> keyPair;
	private List<RegionObj> region;
	private List<SecurityGroupObj> securityGrp;
	
	public EC2OutputDomain(){/*Empty Public Constructor*/}

	/**
	 * @return the address
	 */
	public List<AddressObj> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<AddressObj> address) {
		this.address = address;
	}

	/**
	 * @return the zone
	 */
	public List<ZoneObj> getZone() {
		return zone;
	}

	/**
	 * @param zone the zone to set
	 */
	public void setZone(List<ZoneObj> zone) {
		this.zone = zone;
	}

	/**
	 * @return the instance
	 */
	public List<InstanceObj> getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public void setInstance(List<InstanceObj> instance) {
		this.instance = instance;
	}

	/**
	 * @return the keyPair
	 */
	public List<KeyPairObj> getKeyPair() {
		return keyPair;
	}

	/**
	 * @param keyPair the keyPair to set
	 */
	public void setKeyPair(List<KeyPairObj> keyPair) {
		this.keyPair = keyPair;
	}

	/**
	 * @return the region
	 */
	public List<RegionObj> getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(List<RegionObj> region) {
		this.region = region;
	}

	/**
	 * @return the securityGrp
	 */
	public List<SecurityGroupObj> getSecurityGrp() {
		return securityGrp;
	}

	/**
	 * @param securityGrp the securityGrp to set
	 */
	public void setSecurityGrp(List<SecurityGroupObj> securityGrp) {
		this.securityGrp = securityGrp;
	}

}
