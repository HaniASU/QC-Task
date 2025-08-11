import Page_Factory.RegisterPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Map;

public class RegisterPageTestFactory {
    WebDriver driver ;
    RegisterPage registerPageObject ;

    @Parameters("browser")
    @BeforeClass
    public void setDriver(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();

                //Remove automation message when open the Chrome browser
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", java.util.Arrays.asList("enable-automation"));
                driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    @BeforeMethod
    public void openSite() {
        driver.get("https://demo.nopcommerce.com");
        registerPageObject = new RegisterPage(driver);
        registerPageObject.gotoRegisterPage();
    }


    @DataProvider(name = "jsonData", parallel = true)
    public Object[][] jsonData(Method m) throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("data/register-data.json")) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(is);
            JsonNode node = root.get(m.getName());
            Map<String, String> data = mapper.convertValue(node, new TypeReference<Map<String, String>>() {});
            return new Object[][]{{data}};
        }
    }

    @Test(groups = "regression", dataProvider = "jsonData")
    public void testRegister_regression1(Map<String, String> user) {
        Register(user);
    }

    @Test(groups = "regression", dataProvider = "jsonData")
    public void testRegister_regression2(Map<String, String> user) {
        Register(user);
    }

    @Test(groups = "smoke", dataProvider = "jsonData")
    public void testRegister_smoke(Map<String, String> user) {
        Register(user);
    }

    //Register function
    public void Register(Map<String, String> user)
    {
        registerPageObject
                .setGender(user.get("gender")).pause(1000)
                .setFirstName(user.get("firstName")).pause(1000)
                .setLastName(user.get("lastName")).pause(1000)
                .setEmail(user.get("email")).pause(1000)
                .setCompanyName(user.getOrDefault("company", "")).pause(1000)
                .setNewsletter().pause(1000)
                .setPassword(user.get("password")).pause(1000)
                .setConfirmPassword(user.get("password")).pause(1000)
                .Register();
        Assert.assertTrue(registerPageObject.checkMessage());
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        if (driver != null) driver.quit();
    }
}
