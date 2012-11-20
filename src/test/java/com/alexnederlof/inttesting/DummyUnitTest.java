package com.alexnederlof.inttesting;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DummyUnitTest {

	@Test
	public void assertTrueIsTru() {
		assertThat(true, is(true));
	}
}
