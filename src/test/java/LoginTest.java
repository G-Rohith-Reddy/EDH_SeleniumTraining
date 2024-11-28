import com.learnAutomation.base.BrowserFactory;
import com.learnAutomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest
{
    private WebDriver driver;
    private LoginPage loginPage;
    @BeforeTest
    public void setup()
    {
        BrowserFactory browser = new BrowserFactory();
        driver = browser.getDriver();
    }

    @Test
    public void LoginTest()
    {
        this.loginPage = new LoginPage(this.driver);
        this.loginPage.navigateToPage();
        Assert.assertTrue(this.loginPage.login());
    }
}
