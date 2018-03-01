

import io.qameta.allure.junit4.DisplayName;
import my.company.steps.BaseSteps;
import my.company.steps.DMSSteps;
import my.company.steps.MainPageSteps;
import my.company.steps.SendAppSteps;
import org.junit.Test;


import java.util.HashMap;

/**
 * Created by 777 on 07.05.2017.
 */
public class ExampleTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    DMSSteps dmsSteps = new DMSSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();

    HashMap<String, String> testData = new HashMap<>();


    @DisplayName("Заявка на ДМС")
    @Test
    public void Test(){
        testData.put("Имя","Иван");
        testData.put("Фамилия","Иванов");
        testData.put("Отчество","Иванович");
        testData.put("Регион","Москва");
        testData.put("Телефон","9191111112");
        testData.put("Эл. почта","teststststs");
        testData.put("Комментарии","Autotest");

        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectMenuInsurance("ДМС");
        dmsSteps.checkPageTitle("Добровольное медицинское страхование");
        dmsSteps.goToSendAppPage();
        sendAppSteps.checkPageTitle("Заявка на добровольное медицинское страхование");

        sendAppSteps.fillFields(testData);

        testData.put("Телефон","+7 (919) 111-11-11");
        sendAppSteps.checkFillFields(testData);
        sendAppSteps.checkErrorMessageField("Эл. почта", "Введите корректный email");
    }
}
