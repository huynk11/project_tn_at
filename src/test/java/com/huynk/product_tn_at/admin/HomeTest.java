package com.huynk.product_tn_at.admin;

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
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeTest {
    public static final String baseUrl = "http://localhost:9003/admin";

    public WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\resource\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    @Test
    public void admin_home_display() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedTitle = "Quản trị hệ thống";
        String expectedLogout = "Đăng xuất";
        String expectedManageCategory = "Quản lý danh mục";
        String expectedManageBook = "Quản lý sách";
        String expectedManageUser = "Quản lý người dùng";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value
        String actualTitle = driver.getTitle();
        String actualTextButtonLogout = driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul[3]/li/a")).getText();
        String actualTextButtonHome = driver.findElement(By.xpath("//*[@id=\"mainNav\"]/a")).getText();
        String actualTextCategory = driver.findElement(By.xpath("//*[@id=\"exampleAccordion\"]/li[1]/a/span")).getText();
        String actualTextBook = driver.findElement(By.xpath("//*[@id=\"exampleAccordion\"]/li[2]/a/span")).getText();
        String actualTextUser = driver.findElement(By.xpath("//*[@id=\"exampleAccordion\"]/li[3]/a/span")).getText();

        // compare
        assertEquals(expectedTitle,actualTitle);
        assertEquals(expectedTitle,actualTextButtonHome);
        assertEquals(expectedManageCategory,actualTextCategory);
        assertEquals(expectedManageBook,actualTextBook);
        assertEquals(expectedManageUser,actualTextUser);
        assertEquals(expectedLogout,actualTextButtonLogout);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_admin_home() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLogoutFoward = "http://localhost:9003/admin";
        String expectedTitleLogoutFoward = "Quản trị hệ thống";
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        //event
        WebElement tagCategory= driver.findElement(By.xpath("//*[@id=\"mainNav\"]/a"));
        tagCategory.click();
        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualTitleLoginFoward = driver.getTitle();
        // compare
        assertEquals(expectedLinkLogoutFoward, actualLinkLoginFoward);
        assertEquals(expectedTitleLogoutFoward, actualTitleLoginFoward);
        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_manage_category() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLogoutFoward = "http://localhost:9003/categories";
        String expectedTitleLogoutFoward = "Quản lý danh mục";
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        //event
        WebElement tagCategory= driver.findElement(By.xpath("//*[@id=\"exampleAccordion\"]/li[1]/a"));
        tagCategory.click();
        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualTitleLoginFoward = driver.getTitle();
        // compare
        assertEquals(expectedLinkLogoutFoward, actualLinkLoginFoward);
        assertEquals(expectedTitleLogoutFoward, actualTitleLoginFoward);
        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_manage_book() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLogoutFoward = "http://localhost:9003/books";
        String expectedTitleLogoutFoward = "Quản lý sách";
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        //event
        WebElement tagCategory= driver.findElement(By.xpath("//*[@id=\"exampleAccordion\"]/li[2]/a"));
        tagCategory.click();
        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualTitleLoginFoward = driver.getTitle();
        // compare
        assertEquals(expectedLinkLogoutFoward, actualLinkLoginFoward);
        assertEquals(expectedTitleLogoutFoward, actualTitleLoginFoward);
        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_manage_user() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLogoutFoward = "http://localhost:9003/users";
        String expectedTitleLogoutFoward = "Quản lý người dùng";
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        //event
        WebElement tagCategory= driver.findElement(By.xpath("//*[@id=\"exampleAccordion\"]/li[3]/a"));
        tagCategory.click();
        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualTitleLoginFoward = driver.getTitle();
        // compare
        assertEquals(expectedLinkLogoutFoward, actualLinkLoginFoward);
        assertEquals(expectedTitleLogoutFoward, actualTitleLoginFoward);
        //close Fire fox
        driver.close();
        driver.quit();
    }

    /*@Test
    public void click_logout() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedLinkLogoutFoward = "http://localhost:9003/login";
        String expectedTitleLogoutFoward = "Đăng nhập";
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        //event
        WebElement tagLogout= driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul[3]/li/a"));
        WebElement tagFormLogout= driver.findElement(By.xpath("//*[@id=\"exampleModal\"]"));
        tagLogout.click();
        WebElement tagButtonLogout= driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/a"));
        tagButtonLogout.click();
        // get the actual value
        String actualLinkLoginFoward = driver.getCurrentUrl();
        String actualTitleLoginFoward = driver.getTitle();
        // compare
        assertEquals(expectedLinkLogoutFoward, actualLinkLoginFoward);
        assertEquals(expectedTitleLogoutFoward, actualTitleLoginFoward);
        //close Fire fox
        driver.close();
        driver.quit();
    }*/
}
