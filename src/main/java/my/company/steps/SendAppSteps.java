package my.company.steps;


import my.company.pages.SendAppPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Created by Maria on 06.05.2017.
 */
public class SendAppSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new SendAppPage().fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SendAppPage().getFillField(field);
        assertTrue(actual.equals(value), String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value));
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void checkErrorMessageField(String field, String value){
        new SendAppPage().checkFieldErrorMessage(field, value);
    }

    @Step("заголовок страницы - Отправить заявку равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new SendAppPage().title.getText();
        assertTrue( actualTitle.contains(expectedTitle), String.format("Заголовок равен [%s]. Ожидалось - [%s]",
            actualTitle, expectedTitle));
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }
}
