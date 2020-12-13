import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testTemplate.Properties;
import testTemplate.TestTemplate;
import testTemplate.expectedResults.Values;

public class BMICalculatorIndependentTests {
    public WebDriver webDriver;
    TestTemplate testTemplate;

    @BeforeClass
    public void before() {
        // Set property
        Properties.setProperties();
        // Create webDriver object
        webDriver = new ChromeDriver();
        testTemplate = new TestTemplate(webDriver);
        // Open site
        webDriver.get(Values.site);

    }

    // Calculating Kilograms and Centimeters
    @Test
    public void calculateKgCmNormal() {
        testTemplate.calculateKgCm(Values.normalKg, Values.normalCm, Values.expectedCategoryNormal);
    }

    @Test
    public void calculateKgCmObese() {
        testTemplate.calculateKgCm(Values.obeseKg, Values.obeseCm, Values.expectedCategoryObese);
    }

    @Test
    void calculateKgCmOverWeight() {
        testTemplate.calculateKgCm(Values.overweightKg, Values.overweightCm, Values.expectedCategoryOverweight);
    }

    @Test
    void calculateKgCmUnderWeight() {
        testTemplate.calculateKgCm(Values.underweightKg, Values.underweightCm, Values.expectedCategoryUnderweight);
    }

    @Test
    void calculateKgCmStarvation() {
        testTemplate.calculateKgCm(Values.starvationKg, Values.starvationCm, Values.expectedCategoryStarvation);
    }


    // Calculating Kilograms and Feet
    @Test
    void calculateKgFtNormal() {
        testTemplate.calculateKgFt(Values.normalKg, Values.normalFt, Values.normalInch, Values.expectedCategoryNormal);
    }

    @Test
    void calculateKgFtStarvation() {
        testTemplate.calculateKgFt(Values.starvationKg, Values.starvationFt, Values.starvationInch, Values.expectedCategoryStarvation);
    }

    @Test
    void calculateKgFtObese() {
        testTemplate.calculateKgFt(Values.obeseKg, Values.obeseFt, Values.obeseInch, Values.expectedCategoryObese);
    }


    // Calculating Pounds and Feet
    //Yeah, it works how it shouldn't work! There is a bug! ...right?
    @Test
    void calculateLbFtNormal() {
        testTemplate.calculateLbFt(Values.normalLb, Values.normalFt, Values.normalInch, Values.expectedCategoryNormal);
    }


    // Web Page
    @Test
    void titleText() {
        testTemplate.checkTitleText(Values.expectedTitleText);
    }

    @Test
    void bodyBackgroundColor() {
        testTemplate.checkElementCssAttribute(By.tagName("body"), "background-color", Values.expectedBGColor);
    }

    @Test
    void bodyFontSize() {
        testTemplate.checkElementCssAttribute(By.tagName("body"), "font-size", Values.expectedBodyFontSize);
    }

    @AfterClass
    public void after() throws InterruptedException {
        webDriver.close();
    }
}
