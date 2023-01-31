package Tests;

import Settings.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginTest extends BaseTest {
    public LoginTest(AndroidDriver mobileDriver) {
        super(mobileDriver);
        PageFactory.initElements(mobileDriver,this);
    }
    //Добавить этот медот в Runner если запускается на 13-м андроиде
    public LoginTest clickForAndroid13(){
        String idAllowButton = "com.android.permissioncontroller:id/permission_allow_button";
        elementVisible(By.id(idAllowButton));
        tapElement(By.id(idAllowButton));
        return this;
    }

    public LoginTest clickOnButton(){
        tapElement(By.id("ru.messenger.android:id/bt_new_user"));
        return this;
    }
    public LoginTest clickAllowPermission(){
        tapElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
        return this;
    }
    public LoginTest clickTestMode(){
        String idTestMode = "ru.messenger.android:id/testModeButton1";
        tapElement(By.id(idTestMode));
        tapElement(By.id(idTestMode));
        tapElement(By.id(idTestMode));
        tapElement(By.id(idTestMode));
        tapElement(By.id(idTestMode));
        return this;
    }
    public LoginTest fillNumber(String phoneNumber){
        fillText(By.id("ru.messenger.android:id/device_phone"), phoneNumber);
        return this;
    }
    public LoginTest pressButtonLogin(){
        tapElement(By.id("ru.messenger.android:id/bt_have_account"));
        return this;
    }
    public LoginTest fillCodeSms(String sms){
        fillText(By.xpath("//android.widget.EditText[@text='SMS-код']"), sms);
        return this;
    }
    public LoginTest clickConfirmSMS(){
        tapElement(By.id("ru.messenger.android:id/confirm"));
        return this;
    }
    public LoginTest inputPinCode(){
        String idInputCode = "ru.messenger.android:id/button1";
        tapElement(By.id(idInputCode));
        tapElement(By.id(idInputCode));
        tapElement(By.id(idInputCode));
        tapElement(By.id(idInputCode));
        return this;
    }
    public LoginTest chooseAuthMethod(){
        tapElement(By.id("ru.messenger.android:id/buttonUseOnlyPinCode"));
        return this;
    }
    public LoginTest pressOkButton(){
        tapElement(By.id("android:id/button1"));
        return this;
    }
    public LoginTest pressCancelButton(){
        tapElement(By.id("android:id/button2"));
        return this;
    }
}
