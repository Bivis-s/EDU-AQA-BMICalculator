package testTemplate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class IndependentTemplate {

    WebDriver webDriver;

    public IndependentTemplate(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String checkTitleText() {
        return webDriver.getTitle();
    }

    public String checkElementCssAttribute(By by, String cssAttribute) {
        return webDriver.findElement(by)
                .getCssValue(cssAttribute);
    }

    public String calculateKgCm(String kg, String cm) {
        // Create WebElement weightField
        WebElement weightField = webDriver.findElement(By.name("wg"));
        // Clear weightField
        weightField.clear();
        // Enter kg in Weight field
        weightField.sendKeys(kg);

        // Create WebElement heightField
        WebElement heightField = webDriver.findElement(By.name("ht"));
        // Clear heightField
        heightField.clear();
        // Enter kg in Weight field
        heightField.sendKeys(cm);

        // Click calculate button
        webDriver.findElement(By.name("cc"))
                .click();


        return webDriver.findElement(By.name("desc"))
                .getAttribute("value");
    }

    public String calculateKgFt(String kg, String ft, String inch) {

        // Create WebElement weightField
        WebElement weightField = webDriver.findElement(By.name("wg"));
        // Clear weight-field
        weightField.clear();
        // Enter kg in Weight field
        weightField.sendKeys(kg);

        Select select1 = new Select(webDriver.findElement(By.name("opt2")));
        // values in range [1-7]
        select1.selectByValue(ft);
        Select select2 = new Select(webDriver.findElement(By.name("opt3")));
        // values in range [1-11]
        select2.selectByValue(inch);

        // Click calculate button
        webDriver.findElement(By.name("cc"))
                .click();

        return webDriver.findElement(By.name("desc"))
                .getAttribute("value");
    }

    public String calculateLbFt(String lb, String ft, String inch) {

        // Set pounds in first select field
        Select select1 = new Select(webDriver.findElement(By.name("opt1")));
        select1.selectByValue("pounds");

        // Create WebElement weightField
        WebElement weightField = webDriver.findElement(By.name("wg"));
        // Clear weight-field
        weightField.clear();
        // Enter lb in Weight field
        weightField.sendKeys(lb);

        // Set ft in second select field
        Select select2 = new Select(webDriver.findElement(By.name("opt2")));
        // values in range [1-7]
        select2.selectByValue(ft);
        // Set inch in third select field
        Select select3 = new Select(webDriver.findElement(By.name("opt3")));
        // values in range [1-11]
        select3.selectByValue(inch);

        // Click calculate button
        webDriver.findElement(By.name("cc"))
                .click();

        return webDriver.findElement(By.name("desc"))
                .getAttribute("value");
    }
}
