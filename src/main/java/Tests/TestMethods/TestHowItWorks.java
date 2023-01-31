package Tests.TestMethods;

import Settings.BaseTest;
import Settings.TestBase;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;
import java.util.Arrays;

public class TestHowItWorks extends BaseTest {

    public TestHowItWorks(AndroidDriver mobileDriver) {
        super(mobileDriver);
    }

    public TestHowItWorks testSwipe(){
        setWait(By.id("//android.view.View[@text='']"));
        AndroidElement ele01 = (AndroidElement) mobileDriver.findElement(By.id("//android.view.View[@bounds='[0,325][1080,529]']"));
        int centerX = ele01.getRect().x + (ele01.getSize().width/2);
        double startY = ele01.getRect().y + (ele01.getSize().height * 0.7);
        double endY = ele01.getRect().y + (ele01.getSize().height * 0.5);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,(int)startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
        mobileDriver.perform(Arrays.asList(swipe));
        System.out.println("SCROLLED");
        return this;
    }

    public TestHowItWorks swipe(){
        WebElement backLog = mobileDriver.findElement(By.xpath("//android.view.View[@bounds='[0,325][1080,529]']"));
        TouchActions touchActions = new TouchActions(mobileDriver);
        int centerX = backLog.getRect().x + (backLog.getSize().width/2);
        double startY = backLog.getRect().y + (backLog.getSize().height * 0.7);
        double endY = backLog.getRect().y + (backLog.getSize().height * 0.5);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipes = new Sequence(finger, 1);
        swipes.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,(int)startY));
        swipes.addAction(finger.createPointerDown(0));
        swipes.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
        mobileDriver.perform(Arrays.asList(swipes));
        System.out.println("SCROLLED");
        return this;
    }
}
