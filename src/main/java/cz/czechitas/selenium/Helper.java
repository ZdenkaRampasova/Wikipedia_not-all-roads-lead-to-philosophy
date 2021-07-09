package cz.czechitas.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    public static void waitUntilJavaScriptFindsElement(WebDriver browser, String cssSelector) {
        waitUntilJavaScriptReturnsNonNull(browser, "return document.querySelector('"+cssSelector+"');");
    }

    public static void waitUntilJavaScriptReturnsNonNull(WebDriver browser, String script) {
        WebDriverWait wait = new WebDriverWait(browser, 60);
        wait.until(it -> {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) it;
            Object result = javascriptExecutor.executeScript(script);
            return result != null;
        });
    }

}
