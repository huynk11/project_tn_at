package com.huynk.product_tn_at;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginATTest {
    public static final String baseUrl = "http://localhost:9003/login";

    public WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\resource\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    @Test
    public void login_display() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedTitle = "Đăng nhập";
        String expectedTextRegister = "Đăng kí";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value
        String actualTitle = driver.getTitle();
        String actualTextButtonLogin = driver.findElement(By.id("loginByUserButton")).getText();
        String actualTitleFormLogin = driver.findElement(By.id("title_form_login")).getText();
        String actualTextLinkRegister = driver.findElement(By.cssSelector("a[class='d-block small mt-3']")).getText();

        // compare
        assertEquals(expectedTitle,actualTitle);
        assertEquals(expectedTitle,actualTitleFormLogin);
        assertEquals(expectedTitle,actualTextButtonLogin);
        assertEquals(expectedTextRegister,actualTextLinkRegister);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    // Kiem tra du cac truong tren form, va kiem tra cac truong bat buoc phai nhap la 4
    @Test
    public void login_form_fields() {
        WebDriver driver=getWebDriver();

        // the expect value
        List<String> expectedFields = new ArrayList<>();
        expectedFields.add("Tên người dùng (*)");
        expectedFields.add("Mật khẩu (*)");
        expectedFields.add("Quản trị hệ thống");
        int expectedNumFieldRequireds = 2;

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value
        List<String> actualFields = new ArrayList<>();
        WebElement label_user_name = driver.findElement(By.xpath("//*[@id=\"loginByUserForm\"]/div[2]/label"));
        WebElement label_password = driver.findElement(By.xpath("//*[@id=\"loginByUserForm\"]/div[3]/label"));
        WebElement label_select_role = driver.findElement(By.xpath("//*[@id=\"loginByUserForm\"]/div[4]/label"));
        actualFields.add(label_user_name.getText());
        actualFields.add(label_password.getText());
        actualFields.add(label_select_role.getText());

        int actualNumFieldRequireds = driver.findElements(By.cssSelector("input[required]")).size();

        // compare
        assertEquals(expectedFields, actualFields);
        assertEquals(expectedNumFieldRequireds, actualNumFieldRequireds);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_register() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/registration";
        String expectedTitleLoginFoward = "Đăng kí";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement tagLogin = driver.findElement(By.cssSelector("a[class='d-block small mt-3']"));
        tagLogin.click();

        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualTitleLoginFoward = driver.getTitle();

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);
        assertEquals(expectedTitleLoginFoward, actualTitleLoginFoward);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_login_empty_user_name() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/login";
        String expectedInValidForm = "needs-validation was-validated";
        String expectedInValidFields = "Trường này không bỏ trống";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("");
        WebElement buttonRegister = driver.findElement(By.id("loginByUserButton"));
        buttonRegister.click();
        WebElement form = driver.findElements(By.id("loginByUserForm")).get(0);
        WebElement div_invalid_username = driver.findElement(By.xpath("//*[@id=\"loginByUserForm\"]/div[2]/div"));
        WebElement div_invalid_password = driver.findElement(By.xpath("//*[@id=\"loginByUserForm\"]/div[3]/div"));

        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualInValidForm = form.getAttribute("class");

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);
        assertEquals(expectedInValidForm, actualInValidForm);
        assertEquals(expectedInValidFields, div_invalid_password.getText());
        assertEquals(expectedInValidFields, div_invalid_password.getText());

        //close Fire fox
        driver.close();
        driver.quit();
    }

/*    @Test
    public void click_login_empty_password() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:8091/login";
        String expectedInValidForm = "needs-validation was-validated";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("account_test");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("");
        WebElement buttonRegister = driver.findElement(By.id("loginByUserButton"));
        buttonRegister.click();
        WebElement form = driver.findElements(By.id("loginByUserForm")).get(0);

        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualInValidForm = form.getAttribute("class");

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);
        assertEquals(expectedInValidForm, actualInValidForm);

        //close Fire fox
        driver.close();
        driver.quit();
    }*/

    // login admin success
    @Test
    public void click_login_admin_success() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/admin";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("admin");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement checkbox=driver.findElement(By.id("roleId"));
        checkbox.click();
        WebElement buttonRegister = driver.findElement(By.id("loginByUserButton"));
        buttonRegister.click();

        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_login_user_success() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/index_";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("user_01");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement buttonRegister = driver.findElement(By.id("loginByUserButton"));
        buttonRegister.click();

        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);

        //close Fire fox
        driver.close();
        driver.quit();
    }
}
