package org.concordion.ext.demo.selenium;

import org.concordion.api.ExpectedToFail;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.ext.demo.selenium.web.GoogleResultsPage;
import org.concordion.ext.selenium.ScreenshotExtensionFactory;
import org.concordion.ext.selenium.SeleniumScreenshotTaker;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * A fixture class for the ScreenshotDemo.html specification.
 * <p>
 * This adds the Screenshot Extension to Concordion to include screenshots on error in the Concordion output.
 * By default this extension uses java.awt.Robot to take the screenshot. 
 * <p>
 * To include just the browser screen in the results, we configure the extension using the {@link ScreenshotExtensionFactory}
 * and {@link SeleniumScreenshotTaker} to take screenshots using WebDriver's TakesScreenshot interface.
 * <p>
 * This example also demonstrates the {@link TimestampFormatterExtension}, which changes the Concordion footer to show times
 * in hours, minutes and seconds. 
 * <p>
 * Run this class as a JUnit test to produce the Concordion results.  The test is expected to fail, since Google Calculator 
 * doesn't special case the answer to life, the universe and everything.
 */
@RunWith(ConcordionRunner.class)
@ExpectedToFail
public class ScreenshotDemo extends GoogleFixture {
	
    @Before
    public void loadExtensions() {
        ScreenshotExtensionFactory.setDriver(site.getDriver());
        System.setProperty("concordion.extensions", ScreenshotExtensionFactory.class.getName() + "," + TimestampFormatterExtension.class.getName()); 
    }
    
 	private GoogleResultsPage resultsPage; 

	/**
	 * Searches for the specified topic, and waits for the results page to load.
	 */
    public void searchFor(String topic) {
		resultsPage = searchPage.searchFor(topic);
	}
	
    /**
     * Returns the result from Google calculation.
     */
    public String getCalculatorResult() {
        return resultsPage.getCalculatorResult();
    }
}