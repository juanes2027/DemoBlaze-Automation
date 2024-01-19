package StepDefinitions;

import PageObjects.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class TestStep {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private Test testInstance;


    public TestStep() throws Exception {
        this.testInstance = Test.getInstance(Hooks.driver, Hooks.wait);

    }

    @Given("Login and sing up")
    public void loginAndSingUp() throws IOException, InterruptedException {

        testInstance.signin();
        testInstance.signinAlert();
        testInstance.signin();
        testInstance.validateExist();
    }

    @When("Use aleatory user to test the application")
    public void useAleatoryUserToTestTheApplication() throws InterruptedException, IOException {

        testInstance.noUser();

    }
    @Then("validate the alerts")
    public void validateTheAlerts() throws IOException, InterruptedException {

        testInstance.login();
    }

    @Given("Login and go to the phones")
    public void loginAndGoToThePhones()  {
        PageObjects.Test word = new PageObjects.Test(driver, wait);
        word.initializeElements();
        word.login();

    }

    @When("The user buy a phone")
    public void theUserBuyAPhone() throws InterruptedException {

        PageObjects.Test word = new PageObjects.Test(driver, wait);
        word.initializeElements();
        word.buyPhone();
    }

    @Then("Validate purchase")
    public void validatePurchase() throws IOException, InterruptedException {
        PageObjects.Test word = new PageObjects.Test(driver, wait);
        testInstance.initializeElements();
        word.login();
        word.buyPhone();
        word.validatePurchase();

    }

    @Given("Validate that main category level page contains all items from subcategories")
    public void validateThatMainCategoryLevelPageContainsAllItemsFromSubcategories() throws IOException, InterruptedException {
        PageObjects.Test word = new PageObjects.Test(driver, wait);
        testInstance.initializeElements();
        word.validateCategories();
    }

}
