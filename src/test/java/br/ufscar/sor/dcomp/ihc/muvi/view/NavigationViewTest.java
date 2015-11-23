package br.ufscar.sor.dcomp.ihc.muvi.view;

import br.ufscar.sor.dcomp.ihc.muvi.view.util.ExpectedMap;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author USER
 */
public class NavigationViewTest {

	private final String url = "http://localhost:8080/muvi/navegar?mode=";
	private WebDriver driver;
	private static Map<String, Object> expected;

	public NavigationViewTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		expected = ExpectedMap.get();
	}

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public void isThePageLoadingCorrectly(String mode) {
		driver.get(url + mode);
		
		assertNull(null);
	}

	@Test
	public void isTheAleatoryNavigationPageLoadingCorrectly() {
		isThePageLoadingCorrectly("aleatory");
	}

	@Test
	public void isTheGuidedNavigationPageLoadingCorrectly() {
		isThePageLoadingCorrectly("guided");
	}

	@Test(expected = IllegalArgumentException.class)
	public void isThePageNotLoadingCorrectly() {
		isThePageLoadingCorrectly("");
	}
}
