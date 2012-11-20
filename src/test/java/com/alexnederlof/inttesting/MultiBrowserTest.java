package com.alexnederlof.inttesting;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;

import com.alexnederlof.inttesting.MyWebServer;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public abstract class MultiBrowserTest implements SlowTest {

	private static final String BASE_URL = MyWebServer.BASE_URL;
	private static final String SELENIUM_HOST = "127.0.0.1";
	private static final int SELENIUM_PORT = 4443;

	@Parameters(name = "browser={0}")
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { "*firefox" },
				{ "*googlechrome" } });
	}

	private final String browser;

	private Selenium selenium;

	public MultiBrowserTest(String browser) {
		this.browser = browser;
	}

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium(SELENIUM_HOST, SELENIUM_PORT,
				getBrowser(), BASE_URL);
		selenium.start();
	}

	public String getBrowser() {
		return browser;
	}

	public Selenium getSelenium() {
		return selenium;
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
