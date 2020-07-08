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
public class RegisterATTest {
    public static final String baseUrl = "http://localhost:9003/registration";

    public WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\resource\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    //Kiem tra xem tieu de cua trang web, form dang ki, text cua button dang ki va dang nhap
    @Test
    public void register_display() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedTitle = "Đăng kí";
        String expectedTextLogin = "Đăng nhập";
        String expectedTitleFormRegister = "Đăng kí tài khoản";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value
        String actualTitle = driver.getTitle();
        String actualTitleFormRegister = driver.findElement(By.id("title_form_register")).getText();
        String actualTextButtonRegister = driver.findElement(By.id("saveUser")).getText();
        String actualTextLinkLogin = driver.findElement(By.cssSelector("a[class='d-block small mt-3']")).getText();

        // compare
        assertEquals(expectedTitle,actualTitle);
        assertEquals(expectedTitleFormRegister,actualTitleFormRegister);
        assertEquals(expectedTitle,actualTextButtonRegister);
        assertEquals(expectedTextLogin,actualTextLinkLogin);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    // Kiem tra du cac truong tren form, va kiem tra cac truong bat buoc phai nhap la 4
    @Test
    public void register_form_fields() {
        WebDriver driver=getWebDriver();

        // the expect value
        List<String> expectedFields = new ArrayList<>();
        expectedFields.add("Họ và tên (*)");
        expectedFields.add("Địa chỉ email");
        expectedFields.add("Số điện thoại");
        expectedFields.add("Tên người dùng (*)");
        expectedFields.add("Mật khẩu (*)");
        int expectedNumFieldRequireds = 4;

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value
        List<String> actualFields = new ArrayList<>();
        WebElement label_full_name = driver.findElement(By.xpath("//*[@id=\"addUser\"]/div[1]/label"));
        WebElement label_email = driver.findElement(By.xpath("//*[@id=\"addUser\"]/div[2]/label"));
        WebElement label_phone = driver.findElement(By.xpath("//*[@id=\"addUser\"]/div[3]/label"));
        WebElement label_user_name = driver.findElement(By.xpath("//*[@id=\"addUser\"]/div[4]/div/div/label"));
        WebElement label_password = driver.findElement(By.xpath("//*[@id=\"addUser\"]/div[5]/div/div[1]/label"));
        actualFields.add(label_full_name.getText());
        actualFields.add(label_email.getText());
        actualFields.add(label_phone.getText());
        actualFields.add(label_user_name.getText());
        actualFields.add(label_password.getText());

        int actualNumFieldRequireds = driver.findElements(By.cssSelector("input[required]")).size();

        // compare
        assertEquals(expectedFields, actualFields);
        assertEquals(expectedNumFieldRequireds, actualNumFieldRequireds);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_login() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/login";
        String expectedTitleLoginFoward = "Đăng nhập";

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
    public void click_register_empty_full_name() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/registration";
        String expectedInValidForm = "needs-validation was-validated";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement fullName=driver.findElement(By.id("fullName"));
        fullName.sendKeys("");
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("huynk@gmail.com");
        WebElement phone=driver.findElement(By.id("phone"));
        phone.sendKeys("0365833107");
        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("account_test");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement password_repeat=driver.findElement(By.id("password_repeat"));
        password_repeat.sendKeys("123456");
        WebElement buttonRegister = driver.findElement(By.id("saveUser"));
        buttonRegister.click();
        WebElement form = driver.findElements(By.id("addUser")).get(0);


        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualInValidForm = form.getAttribute("class");

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);
        assertEquals(expectedInValidForm, actualInValidForm);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_register_empty_user_name() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/registration";
        String expectedInValidForm = "needs-validation was-validated";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement fullName=driver.findElement(By.id("fullName"));
        fullName.sendKeys("Nguyễn Khánh Huy");
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("huynk@gmail.com");
        WebElement phone=driver.findElement(By.id("phone"));
        phone.sendKeys("0365833107");
        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement password_repeat=driver.findElement(By.id("password_repeat"));
        password_repeat.sendKeys("123456");
        WebElement buttonRegister = driver.findElement(By.id("saveUser"));
        buttonRegister.click();
        WebElement form = driver.findElements(By.id("addUser")).get(0);

        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualInValidForm = form.getAttribute("class");

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);
        assertEquals(expectedInValidForm, actualInValidForm);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_register_empty_password() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/registration";
        String expectedInValidForm = "needs-validation was-validated";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement fullName=driver.findElement(By.id("fullName"));
        fullName.sendKeys("Nguyễn Khánh Huy");
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("huynk@gmail.com");
        WebElement phone=driver.findElement(By.id("phone"));
        phone.sendKeys("0365833107");
        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("account_test");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("");
        WebElement password_repeat=driver.findElement(By.id("password_repeat"));
        password_repeat.sendKeys("");
        WebElement buttonRegister = driver.findElement(By.id("saveUser"));
        buttonRegister.click();
        WebElement form = driver.findElements(By.id("addUser")).get(0);

        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualInValidForm = form.getAttribute("class");

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);
        assertEquals(expectedInValidForm, actualInValidForm);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_register_not_match_password() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/registration";
        String expectedDisplayInValid = "block";
        String expectedInValidForm = "needs-validation was-validated";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement fullName=driver.findElement(By.id("fullName"));
        fullName.sendKeys("Nguyễn Khánh Huy");
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("huynk@gmail.com");
        WebElement phone=driver.findElement(By.id("phone"));
        phone.sendKeys("0365833107");
        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("account_test");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement password_repeat=driver.findElement(By.id("password_repeat"));
        password_repeat.sendKeys("1234567");
        WebElement buttonRegister = driver.findElement(By.id("saveUser"));
        buttonRegister.click();
        String actualDisplayInValid = driver.findElement(By.id("message_match_password")).getCssValue("display");
        WebElement form = driver.findElements(By.id("addUser")).get(0);

        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualInValidForm = form.getAttribute("class");

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);
        assertEquals(expectedDisplayInValid, actualDisplayInValid);
        assertEquals(expectedInValidForm, actualInValidForm);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    // neu cac truong thoa man dieu kien ==> them moi nguoi dung thanh cong
/*    @Test
    public void click_register_success() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLoginFoward = "http://localhost:9003/login";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        //event
        WebElement fullName=driver.findElement(By.id("fullName"));
        fullName.sendKeys("Nguyễn Khánh Huy");
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("huynk@gmail.com");
        WebElement phone=driver.findElement(By.id("phone"));
        phone.sendKeys("0365833107");
        WebElement userName=driver.findElement(By.id("userName"));
        userName.sendKeys("account_test");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement password_repeat=driver.findElement(By.id("password_repeat"));
        password_repeat.sendKeys("123456");
        WebElement buttonRegister = driver.findElement(By.id("saveUser"));
        buttonRegister.click();

        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();

        // compare
        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);

        //close Fire fox
        driver.close();
        driver.quit();
    }*/

    // thieu kiem tra user_name da ton tai

}
