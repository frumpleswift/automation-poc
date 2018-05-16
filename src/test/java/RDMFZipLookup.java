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
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    action = new Actions(driver);
    baseUrl = "https://rdmfhrentals.sc.egov.usda.gov";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  public WebElement clickLinkByHref(String href) {
        WebElement ret = null;
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();
        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) {
	         ret =anchor;
                //anchor.click();
                break;
            }
        }
        return ret;
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
    // ERROR: Caught exception [ERROR: Unsupported command [addLocationStrategy | id=zz |  856]]
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    driver.findElement(By.linkText("Del Coronado")).click();
    driver.findElement(By.linkText("View Income Limits")).click();
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
