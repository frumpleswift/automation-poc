import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RDMFZipLookup {

  private WebDriver driver;
  private Actions action;
  private Actions pause;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  private void pause() {
  
    
    pause.pause(1000);
    pause.perform();
  
  }
  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {

    driver = new FirefoxDriver();
    action = new Actions(driver);
    pause  = new Actions(driver);
    baseUrl = "https://rdmfhrentals.sc.egov.usda.gov";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  

  @Test
  public void testRDMFZipLookup() throws Exception {
    driver.get(baseUrl + "/RDMFHRentals/select_state.jsp");
    WebElement anchor = driver.findElement(By.id("img5"));
    action.moveToElement(anchor);
    action.pause(2000);
    action.click(anchor);
    action.perform();
    driver.findElement(By.id("zz")).sendKeys("856");
    pause();
    // ERROR: Caught exception [ERROR: Unsupported command [addLocationStrategy | id=zz |  856]]
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    pause();
    driver.findElement(By.linkText("Del Coronado")).click();
    pause();
    driver.findElement(By.linkText("View Income Limits")).click();
  }
  
    @Test
  public void testRDMFMgmtLookup() throws Exception {
    driver.get(baseUrl + "/RDMFHRentals/select_state.jsp");
    //driver.findElement(By.id("img7")).click();
    WebElement anchor = driver.findElement(By.id("img7"));
    action.moveToElement(anchor);
    action.pause(2000);
    action.click(anchor);
    action.perform();
    
    action.perform();
    driver.findElement(By.id("M1")).clear();
    driver.findElement(By.id("M1")).sendKeys("Bosley");
    pause();
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    pause();
    driver.findElement(By.linkText("Las Vegas Apts")).click();
    pause();
    driver.findElement(By.linkText("View Income Limits")).click();
    pause();
  }
  
    @Test
  public void testRDMFPropertyLookup() throws Exception {
    driver.get(baseUrl + "/RDMFHRentals/select_state.jsp");
    //driver.findElement(By.id("img6")).click();
     WebElement anchor = driver.findElement(By.id("img6"));
    action.moveToElement(anchor);
    action.pause(2000);
    action.click(anchor);
    action.perform();
    driver.findElement(By.id("P1")).clear();
    driver.findElement(By.id("P1")).sendKeys("Orac");
    pause();
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    pause();
    driver.findElement(By.linkText("Oracle Apartments")).click();
    pause();
    driver.findElement(By.linkText("View Income Limits")).click();
    pause();
  }
  
    @Test
  public void testRDMFTownLookup() throws Exception {
    driver.get(baseUrl + "/RDMFHRentals/select_state.jsp");
    //driver.findElement(By.id("img8")).click();
     WebElement anchor = driver.findElement(By.id("img8"));
    action.moveToElement(anchor);
    action.pause(2000);
    action.click(anchor);
    action.perform();
    new Select(driver.findElement(By.id("stl"))).selectByVisibleText("Arizona");
    driver.findElement(By.id("tn")).clear();
    driver.findElement(By.id("tn")).sendKeys("Orac");
    pause();
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    pause();
    driver.findElement(By.linkText("Oracle Apartments")).click();
    pause();
    driver.findElement(By.linkText("View Income Limits")).click();
    pause();
  }


  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
