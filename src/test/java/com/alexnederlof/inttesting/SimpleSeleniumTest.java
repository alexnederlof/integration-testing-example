package com.alexnederlof.inttesting;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.thoughtworks.selenium.Selenium;

@RunWith(Parameterized.class)
public class SimpleSeleniumTest extends MultiBrowserTest {

	public SimpleSeleniumTest(String browser) {
		super(browser);
	}

	@Test
	public void testTheWebApp() throws Exception {
		Selenium selenium = getSelenium();
		selenium.open("/");
		assertThat(selenium.getText("css=h1"), is("This is the main page"));
		assertThat(selenium.getTitle(), is("Welcome"));
		selenium.click("id=otherLink");
		selenium.waitForPageToLoad("30000");
		assertThat(selenium.getTitle(), is("Other page"));
		assertThat(selenium.getText("css=h1"), is("This is the other page"));
		selenium.click("id=main");
		selenium.waitForPageToLoad("30000");
		assertThat(selenium.getTitle(), is("Welcome"));
	}

}
