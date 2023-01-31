package Settings;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.slf4j.helpers.Util.report;

public class BaseTest extends TestBase {

    public BaseTest(AndroidDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(mobileDriver,this);
    }
    public AndroidDriver mobileDriver;

    public void setWait(By elementBy){
        WebDriverWait wait = new WebDriverWait(mobileDriver, 480);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void tapElement(By elementBy){
        setWait(elementBy);
        mobileDriver.findElement(elementBy).click();
    }
    public void fillText(By elementBy, String text){
        setWait(elementBy);
        mobileDriver.findElement(elementBy).sendKeys(text);
    }
    public void elementVisible(By elementBy){
        setWait(elementBy);
        mobileDriver.findElement(elementBy).isDisplayed();
    }
    public void pressKey(){
        mobileDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private static final int PHONE_NUMBER_LENGTH = 10;
    public static String getRandomPhone() {
        String codeRegion = "7";
        String s = "123456789";
        StringBuffer phoneNumber = new StringBuffer();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return "+" + codeRegion + phoneNumber.toString();
    }

    public void scrollToElement(By elementBy){
        WebElement scroll = mobileDriver.findElement(elementBy);
        int centerX = scroll.getRect().x + (scroll.getSize().width/2);
        double startY = scroll.getRect().y + (scroll.getSize().height * 0.7);
        double endY = scroll.getRect().y + (scroll.getSize().height * -35.5);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,(int)startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
        mobileDriver.perform(Arrays.asList(swipe));
    }

    public void phoneNumber(By elementBy){
        String phone_number = mobileDriver.findElement(elementBy).getText();
        System.out.println("Phone Number: " + phone_number);
        try(FileWriter fileWriter = new FileWriter("PhoneNumbers.txt")) {
            fileWriter.write(phone_number);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void parserFIO(){
        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("https://ciox.ru/generator-full-name");

    }

}
