package pages.PracticeFormPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pages.PageBase;
import pages.PracticeFormPage.controls.PracticeFormControlFactory;

public class PracticeFormPage extends PageBase {
    private final Locator submitButton;
    private final Locator thanksHeader;
    private final PracticeFormControlFactory practiceFormControlFactory;

    public PracticeFormPage(Page page) {
        super(page);
        this.practiceFormControlFactory = new PracticeFormControlFactory(this);
        this.submitButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
        this.thanksHeader = page.getByRole(AriaRole.COLUMNHEADER, new Page.GetByRoleOptions().setName("Thanks"));
    }

    public void navigateToPracticeFormPage() {
        String URL = "automation-practice-form";
        page.navigate(URL);
    }

    public void fillForm(String label, String value) {
        var control = practiceFormControlFactory.create(label);
        control.setValue(value);
    }

    public void navigateToMainPage() {
        page.navigate("/");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isThanksVisible() {
        return thanksHeader.isVisible();
    }
}
