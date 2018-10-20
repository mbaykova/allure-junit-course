package my.company.steps;



import io.qameta.allure.Step;
import my.company.pages.DMSPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Created by Maria on 06.05.2017.
 */
public class DMSSteps {

    @Step("выполнено нажатие на Отправить заявку")
    public void goToSendAppPage(){
        new DMSPage().sendAppBtn.click();
    }


    @Step("заголовок страницы - ДМС равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new DMSPage().title.getText();
        assertTrue( actualTitle.contains(expectedTitle), String.format("Заголовок равен [%s]. Ожидалось - [%s]",actualTitle, expectedTitle));
    }

}
