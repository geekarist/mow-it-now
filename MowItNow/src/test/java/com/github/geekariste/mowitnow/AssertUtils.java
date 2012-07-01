package com.github.geekariste.mowitnow;

import java.util.List;

import junit.framework.Assert;

public class AssertUtils {

	public static void assertListMatches(List<?> expected, List<?> actual) {
		if (expected == null) {
			Assert.assertNull(String.format("List %s should be null", actual), actual);
		}
		Assert.assertNotNull(actual);
		String msgSize = String.format("Lists %s and %s should have same size", String.valueOf(expected),
				String.valueOf(actual));
		Assert.assertEquals(msgSize, expected.size(), actual.size());
		
		for (Object o : expected) {
			String msg = String.format("List %s should contain object %s", String.valueOf(actual), String.valueOf(o));
			Assert.assertTrue(msg, actual.contains(o));
		}
	}
}
