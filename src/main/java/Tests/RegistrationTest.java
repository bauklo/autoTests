package Tests;

import SelenuimFrameworks.ParserSelenium;
import Settings.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class RegistrationTest extends BaseTest {
    public RegistrationTest(AndroidDriver mobileDriver) {
        super(mobileDriver);
    }

    ParserSelenium parserSelenium = new ParserSelenium();
    public RegistrationTest pressButtonNewUser(){
        tapElement(By.id("ru.messenger.android:id/bt_new_user"));
        return this;
    }

    public RegistrationTest allowPermission(){
        tapElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
        return this;
    }
    public RegistrationTest enableTestMode(){
        String enableTestButton = "ru.messenger.android:id/testModeButton1";
        tapElement(By.id(enableTestButton));
        tapElement(By.id(enableTestButton));
        tapElement(By.id(enableTestButton));
        tapElement(By.id(enableTestButton));
        tapElement(By.id(enableTestButton));
        return this;
    }
    public RegistrationTest pressButtonCreateNewUser(){
        tapElement(By.id("ru.messenger.android:id/bt_new_user"));
        return this;
    }
//    public RegistrationTest fillFullName(){
//        fillText(By.id("ru.messenger.android:id/user_second_name"), parserSelenium.getFullName(0));
//        fillText(By.id("ru.messenger.android:id/user_first_name"), parserSelenium.getFullName(1));
//        fillText(By.id("ru.messenger.android:id/user_third_name"), parserSelenium.getFullName(2));
//        return this;
//    }
    public RegistrationTest fillLastName(){
        fillText(By.id("ru.messenger.android:id/user_second_name"), parserSelenium.getFullName(0));
        return this;
    }
    public RegistrationTest fillFirstName(){
        fillText(By.id("ru.messenger.android:id/user_first_name"), parserSelenium.getFullName(1));
        return this;
    }
    public RegistrationTest fillThirdName(){
        fillText(By.id("ru.messenger.android:id/user_third_name"), parserSelenium.getFullName(2));
        return this;
    }
    public RegistrationTest fillPhoneNumber(){
        fillText(By.id("ru.messenger.android:id/user_mobile_phone"),getRandomPhone());
        return this;
    }
    public RegistrationTest savePhoneNumber() {
        phoneNumber(By.id("ru.messenger.android:id/user_mobile_phone"));
        return this;
    }
    public RegistrationTest fillIDAccepter(String ID){
        fillText(By.id("ru.messenger.android:id/user_invitor"), ID);
        return this;
    }
    public RegistrationTest scrollTo(){
        scrollToElement(By.xpath("//android.widget.Button[@text='ЗАРЕГИСТРИРОВАТЬСЯ']"));
        return this;
    }
    public RegistrationTest pressButtonRegistrationUser(){
        tapElement(By.xpath("//android.widget.Button[@text='ЗАРЕГИСТРИРОВАТЬСЯ']"));
        return this;
    }
    public RegistrationTest fillSMSCode(String sms){
        fillText(By.xpath("//android.widget.EditText[@text='SMS-код']"), sms);
        return this;
    }
    public RegistrationTest pressButtonConfirm(){
        tapElement(By.id("ru.messenger.android:id/confirm"));
        return this;
    }
//    public RegistrationTest checkRegistration(){
//        String
//        Assertions.assertTrue();
//        return this;
//    }
//    public RegistrationTest allowPermission(){
//
//        return this;
//    }
//    public RegistrationTest allowPermission(){
//
//        return this;
//    }

}
