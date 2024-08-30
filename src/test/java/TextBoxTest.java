import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TextBoxTest {
    public static TextBoxPage textBoxPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe"); // В данном случаи указывает путь к файлу с драйвером хрома. На моем локальном компьютере он находится на диске D.
        driver = new ChromeDriver();
        textBoxPage = new TextBoxPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box");
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
    @Test
    public void testTextBox() {
        textBoxPage.inputUserName("test");
        textBoxPage.inputUserEmail("test@test.com");
        textBoxPage.inputCurrentAddress("test current address");
        textBoxPage.inputPermanentAddress("test permanent address");
        textBoxPage.submitData();


        String userName = textBoxPage.getOutputName();
        String email = textBoxPage.getOutputEmail();
        String currentAddress = textBoxPage.getOutputCurrentAddress();
        String permanentAddress = textBoxPage.getOutputPermanentAddress();


        Assert.assertEquals("test", userName);
        Assert.assertEquals("test@test.com", email);
        Assert.assertEquals("test current address", currentAddress);
        Assert.assertEquals("test permanent address", permanentAddress);
    }

    //region Test Email Input Negative
    @Test
    public void testEmailInputNegative(){
        textBoxPage.inputUserName("test");
        textBoxPage.inputUserEmail("test.com");
        textBoxPage.inputCurrentAddress("test current address");
        textBoxPage.inputPermanentAddress("test permanent address");
        textBoxPage.submitData();


        String userName = textBoxPage.getOutputName();
        String email = textBoxPage.getOutputEmail();
        String currentAddress = textBoxPage.getOutputCurrentAddress();
        String permanentAddress = textBoxPage.getOutputPermanentAddress();


        Assert.assertNotEquals("test", userName);
        Assert.assertNotEquals("test@test.com", email);
        Assert.assertNotEquals("test current address", currentAddress);
        Assert.assertNotEquals("test permanent address", permanentAddress);

    }
    //endregion
}
