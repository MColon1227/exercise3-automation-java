import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }


    @Test(testName = "Login to amazon")
    public static void t1submitPage() {
        driver.get(Utils.BASE_URL);
        PageObject identifySection = new PageObject(driver);
        identifySection.identifyAccount();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageObject fillOut = new PageObject(driver);
        //Add Valid credentials (email)
        fillOut.enterEmail("");
        fillOut.pressContinueButtonEmail();
        //Add Valid credentials (password)
        fillOut.enterPassword("");
        fillOut.pressSubmitButton();

    }

    @Test(testName = "Search for and article")
    public static void t2searchProduct() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        PageObject searchProduct = new PageObject(driver);
        searchProduct.searchInput("Samsung Galaxy S9 64GB");
        searchProduct.pressSearchInputButton();

        String savedPrice = searchProduct.savedPrice();
        searchProduct.savedPriceClick();

        String detailPrice = searchProduct.detailPrice();
        searchProduct.actualPriceResult();
        Assert.assertEquals(savedPrice, detailPrice);

        searchProduct.addToCart();

        String savedActualPrice = searchProduct.actualPrice();
        Assert.assertEquals(detailPrice, savedActualPrice);

        String savedShopCart = searchProduct.shopCart();
        Assert.assertEquals(savedShopCart , "1");

        searchProduct.searchInput("Alienware Aw3418DW");
        searchProduct.pressSearchInputButton();

        searchProduct.clickFirstProduct();
        searchProduct.addToCart();

        String savedShopCart2 = searchProduct.shopCart();
        Assert.assertEquals(savedShopCart2 , "2");
    }
    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}