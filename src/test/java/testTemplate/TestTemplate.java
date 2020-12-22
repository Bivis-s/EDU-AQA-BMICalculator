package testTemplate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestTemplate {
    WebDriver webDriver;
    IndependentTemplate independentTemplate;

    public TestTemplate(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.independentTemplate = new IndependentTemplate(webDriver);
    }

    /*
            1. Open site
            2. Chek title text is displayed
         */
    public void checkTitleText(String expectedTitleText){
        // Create actual title text
        String actualTitleText = independentTemplate.checkTitleText();

        // Chek text "BMI Calculator" is displayed
        Assert.assertEquals(actualTitleText, expectedTitleText, "checkTitleText");
    }

    /*
        1. Open site
        2. Chek cssAttribute
     */
    public void checkElementCssAttribute(By by, String cssAttribute, String expectedColor){
        // Get cssAttribute
        String actualColor = independentTemplate.checkElementCssAttribute(by, cssAttribute);

        // Chek body background color
        Assert.assertEquals(actualColor, expectedColor, "checkElementCssAttribute");

    }

    /*
        1. Open site
        2. Enter kg in Weight field
        3. Enter cm in Height field
        4. Click calculate button
        5. Chek text expectedResult is displayed
     */
    public void calculateKgCm(String kg, String cm, String expectedResult){
        // Create actual category text
        String actualCategoryText = independentTemplate.calculateKgCm(kg, cm);

        // Chek text expectedResult is displayed
        Assert.assertEquals(actualCategoryText, expectedResult, "calculateKgCm");
    }

    /*
        1. Open site
        2. Enter kg in Weight field
        3. Enter value1 in first ft-field
        4. Enter value2 in second inches-field
        5. Click calculate button
        6. Chek text expectedResult is displayed
     */
    public void calculateKgFt(String kg, String ft, String inch, String expectedResult){
        // Create actual category text
        String actualCategoryText = independentTemplate.calculateKgFt(kg, ft, inch);

        // Chek text expectedResult is displayed
        Assert.assertEquals(actualCategoryText, expectedResult, "calculateKgFt");
    }

    /*
        1. Open site
        2. Choose pounds in weight-field
        3. Enter lb in Weight field
        4. Choose value1 in first ft-field
        5. Choose value2 in second inches-field
        6. Click calculate button
        7. Chek text expectedResult is displayed
     */
    public void calculateLbFt(String lb, String ft, String inch, String expectedResult){
        // Create actual category text and expected category text
        String actualCategoryText = independentTemplate.calculateLbFt(lb, ft, inch);

        // Chek text expectedResult is displayed
        Assert.assertEquals(actualCategoryText, expectedResult, "calculateLbFt");
    }

}
