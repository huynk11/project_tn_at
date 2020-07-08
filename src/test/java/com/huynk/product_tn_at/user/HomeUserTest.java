package com.huynk.product_tn_at.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeUserTest {
    public static final String baseUrl = "http://localhost:9003/index_";

    public WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\resource\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    @Test
    public void user_home_display() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedTitle = "Đọc sách";
        String expectedLogout = "Đăng xuất";
        String expectedManageCategory = "Danh mục";
        String expectedTitleTable = "Sách";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value
        String actualTitle = driver.getTitle();
        String actualTextButtonLogout = driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul[3]/li[2]/a")).getText();
        String actualTextButtonHome = driver.findElement(By.xpath("//*[@id=\"mainNav\"]/a")).getText();
        String actualTextCategory = driver.findElement(By.xpath("//*[@id=\"exampleAccordion\"]/li/a/span")).getText();
        String actualTextTable = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div/div[1]/div[2]/div[1]/span")).getText();

        // compare
        assertEquals(expectedTitle,actualTitle);
        assertEquals(expectedTitle,actualTextButtonHome);
        assertEquals(expectedManageCategory,actualTextCategory);
        assertEquals(expectedTitleTable,actualTextTable);
        assertEquals(expectedLogout,actualTextButtonLogout);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_search_by_category() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedURL = "http://localhost:9003/index?categoryId=";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value
        WebElement actualTagA = driver.findElement(By.xpath("//*[@id=\"collapseExamplePages\"]/li[1]/a"));
        String idCategory = actualTagA.getAttribute("value");
        actualTagA.click();
        String actualUrl = driver.getCurrentUrl();
        // compare
        assertEquals(expectedURL + idCategory,actualUrl);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    @Test
    public void click_search_by_searchkey() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedURL = "http://localhost:9003/index/search?searchKey=huy%20khanh";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value
        WebElement buttonSearch = driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul[3]/li[1]/form/div/span/button"));
        WebElement inputSearchKey = driver.findElement(By.id("searchKey"));
        inputSearchKey.sendKeys("huy khanh");
        buttonSearch.click();
        String actualUrl = driver.getCurrentUrl();
        // compare
        assertEquals(expectedURL,actualUrl);

        //close Fire fox
        driver.close();
        driver.quit();
    }

    /*@Test
    public void click_show_detail_book() {
        WebDriver driver=getWebDriver();

        // the expect value
        String expectedURL = "http://localhost:9003/index/search?searchKey=huy%20khanh";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value
        WebElement buttonDetail = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[2]/a"));
        WebElement inputSearchKey = driver.findElement(By.id("searchKey"));
        inputSearchKey.sendKeys("huy khanh");
        buttonDetail.sendKeys();
        buttonDetail.click();
        String actualUrl = driver.getCurrentUrl();
        // compare
        assertEquals(expectedURL,actualUrl);

        //close Fire fox
        driver.close();
        driver.quit();
    }*/
}
