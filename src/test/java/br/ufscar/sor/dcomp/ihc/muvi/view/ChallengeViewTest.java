/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.sor.dcomp.ihc.muvi.view;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author USER
 */
public class ChallengeViewTest {
	
	private String url;
	private WebDriver driver;
	private ScreenshotHelper screenshotHelper;
	
	public ChallengeViewTest() {
	}
	/*
	@Before
	public void openBrowser() {
		url = System.getProperty("webdriver.base.url");
		driver = new ChromeDriver();
		driver.get(url);
		screenshotHelper = new ScreenshotHelper();
	}
	
	@After
	public void saveScreenshotAndCloseBrowser() throws IOException {
		screenshotHelper.saveScreenshot("screenshor.png");
		driver.quit();
	}

    @Test
	public void test(){
		Assert.assertNotNull(this);
	}
	*/
	private class ScreenshotHelper {
  
    public void saveScreenshot(String screenshotFileName) throws IOException {
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot, new File(screenshotFileName));
    }
  }
}
