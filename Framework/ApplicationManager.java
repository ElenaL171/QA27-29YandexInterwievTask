package com.telran.testTask.Framework;

import com.telran.testTask.Models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends HelperBase {
    WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://yandex.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void typeInSearchInputField(String itemName) {
        type(By.id("header-search"), itemName);
        click(By.cssSelector("[data-r='search-button']"));
    }

    public String getItemNameFromListBeiNumber(int number) {
        return driver.findElement(By.cssSelector("div:nth-child(" + number + ") ._2UHry")).getText();
    }

    public void selectCategoryType(String type) {
        click(By.cssSelector("[href='/catalog--" + type + "?how=dpop&glfilter=&cvredirect=3&filter-express-delivery=1&searchContext=express&track=srch_ddl']"));
    }

    public void selectCatalog(String category) {
        click(By.cssSelector("[href='/catalog--" + category + "/list?filter-express-delivery=1&searchContext=express']"));
    }

    public void selectDepartment(String department) {
        click(By.xpath("//span[text()='" + department + "']"));
    }

    public void selectMarket() {
        click(By.cssSelector("[data-id='market']"));
    }

    public void acceptCookies() {
        click(By.cssSelector("[data-id='button-all']"));
    }

    public void stop() {
        driver.quit();
    }

    public void filterItem(Item item) {
        jumpDown();
        type(By.cssSelector("._1heDd:nth-child(1) ._3qxDp"), item.getPriceForm());
        type(By.cssSelector("._1heDd:nth-child(2) ._3qxDp"), item.getPriceTo());
        click(By.xpath("//span[text()='" + item.getBrand() + "']"));
    }
    private void jumpDown(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
}
