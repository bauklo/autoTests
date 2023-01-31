package Runners;


import Settings.TestBase;
import Settings.TestBaseNoReset;
import Tests.CreateConference;
import Tests.LoginTest;
import Tests.RegistrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Runner extends TestBase {
       // 71564562132

        private static String PhoneNumber = "+70000000022";
        private static String SMSCode = "1900";

    @BeforeEach
    public void setUp(){
        this.mobileDriver = initializeDriver();
    }

    /**Тест на регистрацию нового пользователя */
    @Test
    public void startRegistrationTest() {
        String ID = "785926";   /** ← Подтверждающий пользователь */
        String SMS_Code = "1900";  /** ← Код смс */
        RegistrationTest RT = new RegistrationTest(mobileDriver);
        RT
                .pressButtonNewUser()
                .allowPermission()
                .allowPermission()
                .enableTestMode()
                .pressButtonCreateNewUser()
                .fillLastName()
                .fillFirstName()
                .fillThirdName()
                .fillPhoneNumber()
                .savePhoneNumber()
                .fillIDAccepter(ID)
                .scrollTo()
                .pressButtonRegistrationUser()
                .fillSMSCode(SMS_Code)
                .pressButtonConfirm();
    }

    /**Тест на создание нового устройства */
    @Test
    public void startLoginTest() {
        LoginTest loginTest = new LoginTest(mobileDriver);
        loginTest
//                .clickForAndroid13()
                .clickOnButton()
                .clickAllowPermission().clickAllowPermission()
                .clickTestMode()
                .fillNumber(PhoneNumber)
                .pressButtonLogin()
                .fillCodeSms(SMSCode)
                .clickConfirmSMS()
                .inputPinCode().inputPinCode()
                .chooseAuthMethod()
                .pressOkButton()
                .clickAllowPermission()
                .pressCancelButton();
    }

    /**Тест на создание новой конференции без пользователей */
    @Test
    public void startTestCreateConference(){
        CreateConference createConference = new CreateConference(mobileDriver);
        createConference
                .clickBurgerMenu()
                .goToConference()
                .clickOnOptions()
                .clickOnCreateNewConference()
                .fillNameConference()
                .fillDescriptionName("someDescription")
                .clickButtonCreateConference()
                .clickButtonCreateConference()
                .clickOnBurgerConference().clickOnBurgerConference();
    }

    /**Тест на создание новой конференции c выбранным пользователем */
    @Test
    public void startTestCreateConferenceWithUser(){
        String User = "Копатыч М.П.";
        CreateConference createConference = new CreateConference(mobileDriver);
        createConference
                .clickBurgerMenu()
                .goToConference()
                .clickOnOptions()
                .clickOnCreateNewConference()
                .fillNameConference()
                .fillDescriptionName("someDescription")
                .clickButtonCreateConference()
                .clickOnUser(User)
                .clickButtonCreateConference()
                .clickOnBurgerConference().clickOnBurgerConference();
        test(User);
    }

    public void test(String user){
        for (;;){
            String User = user;
            CreateConference createConference = new CreateConference(mobileDriver);
            createConference
                    .clickBurgerMenu()
                    .goToConference()
                    .clickOnOptions()
                    .clickOnCreateNewConference()
                    .fillNameConference()
                    .fillDescriptionName("someDescription")
                    .clickButtonCreateConference()
                    .clickOnUser(User)
                    .clickButtonCreateConference()
                    .clickOnBurgerConference().clickOnBurgerConference();
        }
        }
    }





//    @AfterEach
//    public void finish(){
//        mobileDriver.quit();
//    }