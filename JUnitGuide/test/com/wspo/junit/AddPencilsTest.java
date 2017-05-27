package com.wspo.junit;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class AddPencilsTest {

	FirstDayAtSchool school = new FirstDayAtSchool();

	String[] bag = { "Books", "Notebooks", "Pens", "Pencils" };

	@Test
	public void testAddPencils() {

		System.out.println("Inside testAddPencils()");
		assertArrayEquals(bag, school.addPencils());

	}
}
