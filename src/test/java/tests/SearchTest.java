package tests;

import com.epam.search.BasePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SearchTest extends BasePage {

    private WebDriver driver;

    @Before
    public void setDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void suggestedSearchQueryTest() {
        driver.get("https://epam.com/");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.className("header-search__button")).click();
        driver.findElement(By.xpath("//li[text()='Automation']")).click();
        driver.findElement(By.className("header-search__submit")).click();
        assertTrue(driver.findElement(By.className("search-results__counter")).isDisplayed());
    }
}
