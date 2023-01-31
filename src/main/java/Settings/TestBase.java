package Settings;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class TestBase {
    public String deviceName = "emulator-5554";
    public String androidVersion = "11";

    public AndroidDriver mobileDriver;
    public String appiumServer = "127.0.0.1";
    public int appiumPort = 4723;
    URL appiumURL = null;


    public AndroidDriver initializeDriver(){
        try {
            appiumURL = new URL("http://"+appiumServer+":"+appiumPort+"/wd/hub");
            this.mobileDriver = new AndroidDriver(appiumURL,SetCapAndroid());
        }catch (Exception e){
            e.printStackTrace();
        }
        return mobileDriver;
    }

    public DesiredCapabilities SetCapAndroid(){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", androidVersion);
            capabilities.setCapability("automationName","Appium");
//            capabilities.setCapability("appWaitDuration","30000");
//            capabilities.setCapability("appActivity","MainActivity");
            File file = new File("src/main/resources/", "postlink-stc-4.27.0_r844.apk");
            capabilities.setCapability("app", file.getAbsolutePath());
            return capabilities;
    }






}
