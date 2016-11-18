package com.sites;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sites.controllers.HomeController;


public class AppTest 
{
	@Test
    public void testApp()
    {
		HomeController hc = new HomeController();
		String result = hc.Home();
		assertEquals(result, "Project Sites, reporting for duty!");        
    }
}
