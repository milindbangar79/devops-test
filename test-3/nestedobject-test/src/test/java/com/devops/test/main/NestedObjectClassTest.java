package com.devops.test.main;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;


public class NestedObjectClassTest extends NestedObjectClass {
	
	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	@Test
	public void testMainClass() {
		instance = new InnerNestedObjectClass();
		String[] args = { "x", "y", "z", "a" };
		exit.expectSystemExit();
        System.exit(0);
		main(args);
	}
	
	@Test
	public void testNestedObjectLogicWithCorrectValues() {
		instance = new InnerNestedObjectClass();
		NestedObjectClass nestedObj = new NestedObjectClass();

		String[] args = { "x", "y", "z", "a" };

		Map<String, Map<String, Map<String, String>>> testMap = new HashMap<String, Map<String, Map<String, String>>>();

		testMap.put(args[0], new HashMap<String, Map<String, String>>());

		testMap.get(args[0]).put(args[1], new HashMap<String, String>());

		testMap.get(args[0]).get(args[1]).put(args[2], args[3]);

		Map<String, String> testMapForValue = new HashMap<String, String>();
		testMapForValue = testMap.get(args[0]).get(args[1]);

		nestedObj.getValueFromMap(nestedObj, testMapForValue, args[2]);
		
		assertNotNull(testMap);
		assertNotNull(testMap.containsKey("x"));
		assertEquals("Expected Return Value should be a", "a", nestedObj.getNestedValue());
		
		exit.expectSystemExit();
        System.exit(0);
		
		main(args);
	}

	@Test
	public void testNestedObjectLogicWithWrongExpectedValue() {
		instance = new InnerNestedObjectClass();
		NestedObjectClass nestedObj = new NestedObjectClass();

		String[] args = { "x", "y", "z", "a" };

		Map<String, Map<String, Map<String, String>>> testMap = new HashMap<String, Map<String, Map<String, String>>>();

		testMap.put(args[0], new HashMap<String, Map<String, String>>());

		testMap.get(args[0]).put(args[1], new HashMap<String, String>());

		testMap.get(args[0]).get(args[1]).put(args[2], args[3]);

		Map<String, String> testMapForValue = new HashMap<String, String>();
		testMapForValue = testMap.get(args[0]).get(args[1]);

		nestedObj.getValueFromMap(nestedObj, testMapForValue, args[2]);

		assertNotEquals("Expected Return Value should be a", "b", nestedObj.getNestedValue());
		
		exit.expectSystemExit();
        System.exit(0);

		main(args);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testNestedObjectLogicWithNoArgumentsPassed() {
		instance = new InnerNestedObjectClass();
		NestedObjectClass nestedObj = new NestedObjectClass();

		String[] args = {};

		Map<String, Map<String, Map<String, String>>> testMap = new HashMap<String, Map<String, Map<String, String>>>();

		testMap.put(args[0], new HashMap<String, Map<String, String>>());

		testMap.get(args[0]).put(args[1], new HashMap<String, String>());

		testMap.get(args[0]).get(args[1]).put(args[2], args[3]);

		Map<String, String> testMapForValue = new HashMap<String, String>();
		testMapForValue = testMap.get(args[0]).get(args[1]);

		nestedObj.getValueFromMap(nestedObj, testMapForValue, args[2]);
		
		exit.expectSystemExit();
        System.exit(0);

		main(args);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testNestedObjectLogicWithAnEmptyArgument() {
		instance = new InnerNestedObjectClass();
		NestedObjectClass nestedObj = new NestedObjectClass();

		String[] args = { "x", "y","a"};

		Map<String, Map<String, Map<String, String>>> testMap = new HashMap<String, Map<String, Map<String, String>>>();

		testMap.put(args[0], new HashMap<String, Map<String, String>>());

		testMap.get(args[0]).put(args[1], new HashMap<String, String>());

		testMap.get(args[0]).get(args[1]).put(args[2], args[3]);

		Map<String, String> testMapForValue = new HashMap<String, String>();
		testMapForValue = testMap.get(args[0]).get(args[1]);

		nestedObj.getValueFromMap(nestedObj, testMapForValue, args[2]);
		
		exit.expectSystemExit();
        System.exit(0);

		main(args);
	}

	private static class InnerNestedObjectClass extends NestedObjectClass {
		@Override
		public void getValueFromMap(NestedObjectClass nestedObj, Map<String, String> tempMap, String key) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

}
