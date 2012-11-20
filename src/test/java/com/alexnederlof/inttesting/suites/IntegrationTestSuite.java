package com.alexnederlof.inttesting.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.ClasspathSuite.BaseTypeFilter;
import org.junit.runner.RunWith;

import com.alexnederlof.inttesting.MultiBrowserTest;
import com.alexnederlof.inttesting.MyWebServer;

/**
 * A suite that starts the server beforehand, and closes the server after the
 * tests have run.
 */
@RunWith(ClasspathSuite.class)
@BaseTypeFilter(MultiBrowserTest.class)
public class IntegrationTestSuite {

	private static MyWebServer server;

	@BeforeClass
	public static void startServer() throws Exception {
		server = new MyWebServer();
		server.start();
	}

	@AfterClass
	public static void shutDownServer() throws Exception {
		server.stop();
	}
}
