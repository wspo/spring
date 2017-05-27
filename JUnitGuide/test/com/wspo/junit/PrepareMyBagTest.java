package com.wspo.junit;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PrepareMyBagTest {
	
	FirstDayAtSchool school = new FirstDayAtSchool();

	String[] bag = { "Books", "Notebooks", "Pens" };

	@Test
	public void testPrepareMyBag() {

		System.out.println("Inside testPrepareMyBag()");
		assertArrayEquals(bag, school.prepareMyBag());

	}
}
