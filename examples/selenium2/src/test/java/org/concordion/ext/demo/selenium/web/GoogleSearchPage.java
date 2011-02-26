package org.concordion.ext.demo.selenium.web;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * A WebDriver Page Object corresponding to the Google Search Page.
 */
public class GoogleSearchPage {
	
    @CacheLookup
	@FindBy(name = "q") 
	private WebElement queryBox;
	
    @CacheLookup
	@FindBy(name = "btnG") 
	private WebElement submitButton;
	
    private final WebDriver driver;
    
	/**
	 * Opens the Google Search Page.
	 */
	public GoogleSearchPage(WebDriver webDriver) {
		this.driver = webDriver;
        PageFactory.initElements(driver, this);
		driver.get("http://www.google.com");
	}

    /**
     * Searches for the specified string and opens the results page, 
     * waiting for the page to fully load. 
     */
	public GoogleResultsPage searchFor(String query) {
		queryBox.sendKeys(query);
		submitButton.click();
		return new GoogleResultsPage(driver);
	}
}