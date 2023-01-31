package Tests;

import Settings.BaseTest;
import Settings.TestBaseNoReset;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

public class CreateConference extends BaseTest {

    public CreateConference(AndroidDriver mobileDriver) {
        super(mobileDriver);
        PageFactory.initElements(mobileDriver,this);
    }

    public CreateConference clickBurgerMenu(){
        tapElement(By.xpath("//android.widget.ImageButton[@content-desc=\"PostLink\"]"));
        return this;
    }
    public CreateConference goToConference(){
        tapElement(By.xpath("//android.widget.TextView[@text='Конференции']"));
        return this;
    }
    public CreateConference clickOnOptions(){
        tapElement(By.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]"));
        return this;
    }
    public CreateConference clickOnCreateNewConference(){
        tapElement(By.xpath("//android.widget.TextView[@text='Создать конференцию']"));
        return this;
    }
    public CreateConference fillNameConference(){
        fillText(By.id("ru.messenger.android:id/conferenceNameEditText"), getRandomName());
        return this;
    }
    public CreateConference fillDescriptionName(String text){
        fillText(By.id("ru.messenger.android:id/conferenceDescriptionEditText"), getRandomName());
        return this;
    }
    public CreateConference clickButtonCreateConference(){
        tapElement(By.id("ru.messenger.android:id/menu_item_done_button"));
        return this;
    }
    public CreateConference scrollTo(){
        scrollToElement(By.id("ru.messenger.android:id/filterUserEditText"));
        return this;
    }
    public CreateConference clickOnUser(String text){
        tapElement(By.xpath("//android.widget.TextView[@text='"+text+"']"));
        return this;
    }
    public CreateConference clickOnBurgerConference(){
        tapElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Участники\"]"));
        return this;
    }

    public CreateConference getListOfUsersAndAddInConference(){
        scrollVertical();
        return this;
    }















//"id("ru.messenger.android:id/filterUserEditText"))"

    private void scrollVertical() {
        AndroidElement ele01 = (AndroidElement) mobileDriver.findElement(By.id("ru.messenger.android:id/filterUserEditText"));
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
    }

    private static final int PHONE_NUMBER_LENGTH = 4;
    public static String getRandomName() {
        String s = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnmйцукенгшщзхъфывапролджэячсмитьбю";
        StringBuffer phoneNumber = new StringBuffer();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return phoneNumber.toString();
    }

}
