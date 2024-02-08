package steps.PracticeFormSteps;

import hooks.PlaywrightHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PracticeFormPage.PracticeFormPage;
import steps.StepsBase;

import static com.google.common.truth.Truth.assertThat;

public class PracticeFormSteps extends StepsBase {
    private final PracticeFormPage practiceFormPage;

    public PracticeFormSteps(PlaywrightHooks playwrightHooks) {
        super(playwrightHooks);
        practiceFormPage = new PracticeFormPage(page);
    }

    @Given("I navigate to the main page")
    public void navigateToMainPage() {
        practiceFormPage.navigateToMainPage();
    }

    @Given("I navigate to practice form page")
    public void navigateToPracticeFormPage() {
        practiceFormPage.navigateToPracticeFormPage();
    }

    @When("I fill practice form fields with the following data")
    public void fillPracticeFormFields(DataTable dataTable) {
        var data = dataTable.asMap();
        data.forEach(practiceFormPage::fillForm);
    }

    @When("I click submit button")
    public void clickSubmitButton() {
        practiceFormPage.clickSubmitButton();
    }

    @Then("thanks message should be visible")
    public void thanksMessageShouldBeVisible() {
        var isMessageVisible = practiceFormPage.isThanksVisible();
        assertThat(isMessageVisible).isTrue();
    }

}
