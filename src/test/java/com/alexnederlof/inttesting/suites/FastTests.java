package com.alexnederlof.inttesting.suites;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.ClasspathSuite.ExcludeBaseTypeFilter;
import org.junit.runner.RunWith;

import com.alexnederlof.inttesting.SlowTest;

@RunWith(ClasspathSuite.class)
@ExcludeBaseTypeFilter(SlowTest.class)
public class FastTests {

}
