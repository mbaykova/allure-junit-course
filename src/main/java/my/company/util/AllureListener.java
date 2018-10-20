package my.company.util;

import my.company.steps.BaseSteps;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestIdentifier;

/**
 * Created by 777 on 08.05.2017.
 */
public class AllureListener extends AllureJunit5 {

    @Override
    public void executionFinished(final TestIdentifier testIdentifier, final TestExecutionResult testExecutionResult) {
        BaseSteps.takeScreenshot();
        super.executionFinished(testIdentifier, testExecutionResult);
    }
}
