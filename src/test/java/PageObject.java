import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected WebDriver driver;

    By identify = By.cssSelector("#nav-link-accountList");
    By inputEmail = By.cssSelector("input#ap_email");
    By continueEmail = By.cssSelector("input#continue");
    By password = By.cssSelector("input#ap_password");
    By submitButton = By.cssSelector("input#signInSubmit");
    By searchInputOption = By.cssSelector("input#twotabsearchtextbox");
    By searchButton = By.cssSelector("span#nav-search-submit-text > .nav-input");

    By savedPrice = By.xpath("//div[5]/div[@class='sg-col-inner']//span[@class='a-price']");
    By clickSavedPrice = By.cssSelector("div.s-result-list.s-main-slot > div:nth-child(5) img");
    By detailPrice = By.cssSelector("span#price_inside_buybox");
    By addToCart = By.cssSelector("input#add-to-cart-button");
    By actualPrice = By.cssSelector("#hlb-subcart .a-color-price");

    By shopCart = By.cssSelector("span#nav-cart-count");
    By clickFirstProduct = By.cssSelector(".s-main-slot.s-result-list.s-search-results.sg-row > div:nth-of-type(1) > .sg-col-inner");

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void identifyAccount() {
        driver.findElement(identify).click();
    }
    public void enterEmail(String EMAIL) {
        driver.findElement(inputEmail).sendKeys(EMAIL);
    }
    public void pressContinueButtonEmail() {
        driver.findElement(continueEmail).click();
    }
    public void enterPassword(String PASSWORD) {
        driver.findElement(password).sendKeys(PASSWORD);
    }
    public void pressSubmitButton() {
        driver.findElement(submitButton).click();
    }
    public void searchInput(String SEARCH_PRODUCT) {
        driver.findElement(searchInputOption).sendKeys(SEARCH_PRODUCT);
    }
    public void pressSearchInputButton() {
        driver.findElement(searchButton).click();
    }
    public String savedPrice() {
       String price = driver.findElement(savedPrice).getText().replace("\n", "");
      return addChar(price,".", price.length() - 2 );
    }
    public void savedPriceClick() {
        driver.findElement(clickSavedPrice).click();
    }
    public String  detailPrice() {
        return driver.findElement(detailPrice).getText();
    }
    public void actualPriceResult() {
        driver.findElement(detailPrice).isDisplayed();
    }
    public String addChar(String str, String ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        return sb.toString();
    }
    public void addToCart() {
        driver.findElement(addToCart).click();
    }
    public String actualPrice() {
        return driver.findElement(actualPrice).getText();
    }
    public String shopCart() {
        return driver.findElement(shopCart).getText();
    }
    public void clickFirstProduct() {
        driver.findElement(clickFirstProduct).click();
    }
}
