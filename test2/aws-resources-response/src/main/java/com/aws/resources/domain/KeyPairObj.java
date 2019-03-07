/**
 * 
 */
package com.aws.resources.domain;

import java.io.Serializable;

/**
 * @author milindbangar
 *
 */
public class KeyPairObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String keyFingerprint;

    private String keyName;

	/**
	 * @return the keyFingerprint
	 */
	public String getKeyFingerprint() {
		return keyFingerprint;
	}

	/**
	 * @param keyFingerprint the keyFingerprint to set
	 */
	public void setKeyFingerprint(String keyFingerprint) {
		this.keyFingerprint = keyFingerprint;
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
    
    

}
