package com.huynk.product_tn_at.admin;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManageBookTest {
    public static final String baseUrl = "http://localhost:9003/books";

    public WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\resource\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    /*@Test
    public void click_add_category() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLogoutFoward = "http://localhost:9003/categories";
        String expectedTitleLogoutFoward = "Quản lý danh mục";
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        //event
        WebElement tagElement= driver.findElement(By.xpath("//*[@id=\"page-top\"]/div/div[1]/div[1]/button"));
        tagElement.click();
        String visibility = driver.findElement(By.id("categoryModalAdd")).getCssValue("display");
        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualTitleLoginFoward = driver.getTitle();
        // compare
        assertEquals(expectedLinkLogoutFoward, actualLinkLoginFoward);
        assertEquals(expectedTitleLogoutFoward, actualTitleLoginFoward);
        assertEquals("block", driver.findElement(By.id("categoryModalAdd")).getCssValue("display"));
        //close Fire fox
        driver.close();
        driver.quit();
    }*/

//    @Test
//    public void click_add_category_success() {
//        WebDriver driver=getWebDriver();
//
//        // the expect value
//        String expectedLinkLoginFoward = "http://localhost:9003/categories";
//
//        // launch Fire fox and direct it to the Base URL
//        driver.get(baseUrl);
//
//        //event
//        WebElement categoryId=driver.findElement(By.id("categoryId"));
//        categoryId.sendKeys("");
//        WebElement categoryName=driver.findElement(By.id("categoryName"));
//        categoryName.sendKeys("book_01");
//        WebElement description=driver.findElement(By.id("description"));
//        description.sendKeys("");
//        WebElement buttonRegister = driver.findElement(By.id("saveCategory"));
//        buttonRegister.click();
//
//        // get the actual value
//        String actualLinkLoginFoward = driver.getCurrentUrl();
//
//        // compare
//        assertEquals(expectedLinkLoginFoward, actualLinkLoginFoward);
//
//        //close Fire fox
//        driver.close();
//        driver.quit();
//    }
}

