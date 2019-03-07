package com.devops.test.main;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author milindbangar 
 * Sample Object Structure: {"x":{"y":"{"z":"a"}"}}
 * Class to create the object and get the nested value from nested Map object 
 *
 */
public class NestedObjectClass {
	
	private String nestedValue;

	public static void main(String[] args) {

		Map<String, Map<String, Map<String, String>>> customMap = new HashMap<String, Map<String, Map<String, String>>>();
		
		
		NestedObjectClass nestedObj = new NestedObjectClass();
		
		if (args.length < 1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		// Create the object as per requirement
		customMap.put(args[0], new HashMap<String, Map<String, String>>());

		customMap.get(args[0]).put(args[1], new HashMap<String, String>());

		customMap.get(args[0]).get(args[1]).put(args[2], args[3]);

		// Extract the resulting map of <String,String> corresponding to
		// {"z","a"}
		Map<String, String> mapFromPrimaryAndSecondaryKeys = new HashMap<String, String>();
		mapFromPrimaryAndSecondaryKeys = customMap.get(args[0]).get(args[1]);

		nestedObj.getValueFromMap(nestedObj,mapFromPrimaryAndSecondaryKeys,args[2]);

	}

	protected void getValueFromMap(NestedObjectClass nestedObj, Map<String, String> mapFromPrimaryAndSecondaryKeys, String key) {

		String valueFromMap = null;

		// Check for null value. If not check possible NullPointerException will
		// be thrown
		if (mapFromPrimaryAndSecondaryKeys.containsKey(key)) {
			valueFromMap = mapFromPrimaryAndSecondaryKeys.get(key);
			nestedObj.setNestedValue(valueFromMap);
		}else{
			System.exit(1);
		}
		
		PrintWriter resourceOutput = new PrintWriter(System.out, true);

		String format = "%s\n";

		resourceOutput.printf(format, valueFromMap);

	}
	
    public String getNestedValue() {
		return nestedValue;
	}

	public void setNestedValue(String nestedValue) {
		this.nestedValue = nestedValue;
	}

	// Added a protected static property that could be used to store an instance
	protected static NestedObjectClass instance = null;

}
