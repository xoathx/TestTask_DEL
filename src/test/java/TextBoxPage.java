import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    public WebDriver driver;
    public TextBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /*
    Подлягел на Хабре такой интересный аттрибут FindBy.
    Помог сократить код в несколько раз
    */

    @FindBy(xpath = "//*[@id='userName']")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    private WebElement userEmail;

    @FindBy(xpath = "//*[@id=\"currentAddress\"]")
    private WebElement currentAddress;

    @FindBy(xpath = "//*[@id=\"permanentAddress\"]")
    private WebElement permanentAddress;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement submit;



    @FindBy(xpath = "//*[@id='name']")
    public WebElement outputName;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement outputEmail;

    @FindBy(xpath = "//p[@id='currentAddress']")
    public WebElement outputCurrentAddress;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    public WebElement outputPermanentAddress;


    public void inputUserName(String userName) {
        this.userName.sendKeys(userName);
    }
    public void inputUserEmail(String userEmail) {
        this.userEmail.sendKeys(userEmail);
    }
    public void inputCurrentAddress(String currentAddress) {
        this.currentAddress.sendKeys(currentAddress);
    }
    public void inputPermanentAddress(String permanentAddress) {
        this.permanentAddress.sendKeys(permanentAddress);
    }

    public void  submitData() {
        this.submit.click();
    }

    /*
    Выохдные имеют вид Property:Value.
    Решил воспользоваться сплитом, чтобы просто и быстро разделить строку на
    две подстроки и выбрать последнюю, содержащую нужное значение для сравнения
    * */

    public String getOutputName() {
        if(!outputName.isDisplayed()){ return null;}
        return outputName.getText().split(":")[1];
    }
    public String getOutputEmail() {
        if(!outputEmail.isDisplayed()){ return null;}
        return outputEmail.getText().split(":")[1];
    }
    public String getOutputCurrentAddress() {
        if(!outputCurrentAddress.isDisplayed()){ return null;}
        return outputCurrentAddress.getText().split(":")[1];
    }
    public String getOutputPermanentAddress() {
        if(!outputPermanentAddress.isDisplayed()){ return null;}
        return outputPermanentAddress.getText().split(":")[1];
    }

}
