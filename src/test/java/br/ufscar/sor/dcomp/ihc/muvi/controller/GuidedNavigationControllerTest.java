package br.ufscar.sor.dcomp.ihc.muvi.controller;

import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author USER
 */
public class GuidedNavigationControllerTest {
	
	public GuidedNavigationControllerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of next method, of class GuidedNavigationController.
	 */
	@Test
	public void testNext() {
		System.out.println("next");
		HttpServletRequest request = null;
		GuidedNavigationController instance = new GuidedNavigationController();
		ModelAndView expResult = null;
		ModelAndView result = instance.next(request);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of back method, of class GuidedNavigationController.
	 */
	@Test
	public void testBack() {
		System.out.println("back");
		HttpServletRequest request = null;
		GuidedNavigationController instance = new GuidedNavigationController();
		ModelAndView expResult = null;
		ModelAndView result = instance.back(request);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
