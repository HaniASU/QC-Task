package Page_Factory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage {

    //Add driver
    private WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        AjaxElementLocatorFactory ajax = new AjaxElementLocatorFactory(driver, 150);
        PageFactory.initElements(ajax, this);
    }

    //find locators of Register Page elements
    @FindBy(xpath = "//a[@href='/register?returnUrl=%2F']")
    WebElement Registerpage;

    @FindBy(id = "gender-male")
    WebElement maleGender;

    @FindBy(id = "gender-female")
    WebElement femaleGender;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='Company']")
    WebElement companyname;

    @FindBy(xpath = "//input[@id='Newsletter']")
    WebElement newsletterCheckbox;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    WebElement Message;


    public RegisterPage setGender(String gender) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("M")) {
            WebElement maleElement = wait.until(ExpectedConditions.elementToBeClickable(maleGender));
            maleElement.click();
        } else if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("F")) {
            WebElement femaleElement = wait.until(ExpectedConditions.elementToBeClickable(femaleGender));
            femaleElement.click();
        }
        return this;
    }

    public RegisterPage gotoRegisterPage ()
    {
        this.Registerpage.click();
        return this;
    }
    public RegisterPage setFirstName (String firstName)
    {
        this.firstName.sendKeys(firstName);
        return this;
    }
    public RegisterPage setLastName (String lastName)
    {
        this.lastName.sendKeys(lastName);
        return this;
    }
    public RegisterPage setEmail (String email)
    {
        this.email.sendKeys(email);
        return this;
    }
    public RegisterPage setCompanyName (String companyname)
    {
        this.companyname.sendKeys(companyname);
        return this;
    }
    public RegisterPage setNewsletter() {
        newsletterCheckbox.click();
        return this;
    }
    public RegisterPage setPassword(String password)
    {
        this.password.sendKeys(password);
        return this;
    }
    public RegisterPage setConfirmPassword (String confirmPassword)
    {
        this.confirmPassword.sendKeys(confirmPassword);
        return this;
    }
    public RegisterPage Register ()
    {
        registerButton.click();
        return this;
    }

    public RegisterPage pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    public boolean checkMessage () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(Message));

        return Message.getText()
                .trim()
                .equalsIgnoreCase("Your registration completed");
    }

}