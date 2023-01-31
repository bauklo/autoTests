package SelenuimFrameworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ParserSelenium {

    WebDriver driver;
    public WebDriver Driver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        return this.driver = new ChromeDriver(options.setHeadless(true));
    }

    public String getFullName(int i){
        Driver();
        driver.get("https://ciox.ru/generator-full-name");
        driver.findElement(By.xpath("//input[@type='number']")).click();
        driver.findElement(By.xpath("//input[@type='number']")).clear();
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1");
        driver.findElement(By.xpath("//button[@name='enter']")).click();
        String fullName = driver.findElement(By.xpath("//textarea[@class='input_c result']")).getText();
        String[] splited = fullName.split("\\s+");
        return splited[i];
    }




}
