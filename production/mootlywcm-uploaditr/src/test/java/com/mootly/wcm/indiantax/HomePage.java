package com.mootly.wcm.indiantax;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage extends GoGreenTest {

	@Test
    public void HomePage() throws Exception {
		System.out.println("YESS");
        selenium.setTimeout("60000");
		selenium.open("/e-Filing/UserLogin/LoginHome.html?nextPage=efile");
		
		selenium.runScript("document.getElementById('Login_userName').setAttribute('value','ATEPA7799P');document.getElementById('Login_password').setAttribute('value','megha_13');document.getElementById('dateField').setAttribute('value','13/03/1989');");
		selenium.runScript("document.getElementById('Login_userName').blur();");
		
		selenium.fireEvent("Login_userName", "onblur");
		selenium.fireEvent("Login_userName", "onchange");
		
		selenium.fireEvent("Login_userName", "blur");
		selenium.fireEvent("Login_userName", "change");
		
		selenium.fireEvent("Login_password", "blur");
		//selenium.fireEvent("Login_password", "onchange");
		selenium.click("xpath=//input[@value='Login' and @type='submit']");
		Thread.currentThread().sleep(3000);
		//boolean isForcedLogin = selenium.isTextPresent("Forced Login");
		
		//<input name="buttonType" type="submit" class="btnOrange" value="Forced Login">
		boolean isForcedLogin = selenium.isElementPresent("xpath=//input[@name='buttonType' and @type='submit' and @value='Forced Login']");
		System.out.println("isForcedLogin:" + isForcedLogin);
		
		selenium.click("xpath=//input[@name='buttonType' and @type='submit' and @value='Forced Login']");
		Thread.currentThread().sleep(10000);
		
		
		assertEquals("Mootly WCM - Home", selenium.getTitle());
		assertTrue(selenium.isElementPresent("link=Home"));
		assertTrue(selenium.isElementPresent("link=News & Events"));
		assertTrue(selenium.isElementPresent("link=Jobs"));
		assertTrue(selenium.isElementPresent("link=Products"));
		assertTrue(selenium.isElementPresent("link=About"));
		assertTrue(selenium.isElementPresent("doc-1"));
		assertEquals(selenium.getText("text-size"), "Text size: A A A");
		assertTrue(selenium.isTextPresent("Text size: A A A \n \n \n Edition: United States France Nederland Home News & Events Jobs Products About"));
		assertTrue(selenium.isElementPresent("//img[@alt='onehippo.com']"));
		assertTrue(selenium.isElementPresent("link=Terms & Conditions"));
		assertTrue(selenium.isTextPresent("Hippo © 2010-2012"));
		assertEquals(selenium.getText("//div[@id='ft-nav']/div[1]/h3"), "SERVICE");
		assertTrue(selenium.isElementPresent("link=Contact"));
		assertTrue(selenium.isElementPresent("link=FAQ"));
		assertTrue(selenium.isElementPresent("link=RSS"));
		assertTrue(selenium.isElementPresent("link=Sitemap"));
		assertTrue(selenium.isElementPresent("link=API"));
		assertTrue(selenium.isElementPresent("link=Contact"));
		assertEquals(selenium.getText("//div[@id='ft-nav']/div[2]/h3"), "SECTIONS");
		assertTrue(selenium.isElementPresent("link=News & Events"));
		assertTrue(selenium.isElementPresent("link=Jobs"));
		assertTrue(selenium.isElementPresent("link=Products"));
		assertTrue(selenium.isElementPresent("link=About"));
		assertTrue(selenium.isElementPresent("link=Mobile"));
		assertTrue(selenium.isElementPresent("ft-disclaimer"));
		
	} 
}
