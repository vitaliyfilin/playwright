package pages.PracticeFormPage.controls;

import com.microsoft.playwright.Locator;

public class PracticeFormRadioButton extends PracticeFormControlBase {
    public PracticeFormRadioButton(Locator locator) {
        super(locator);
    }

    @Override
    public void setValue(String value) {
        var selector = String.format("//following::input[@value='%s']", value);
        locator
                .locator(selector)
                .click(new Locator
                        .ClickOptions()
                        .setForce(true));
    }

    @Override
    public void click() {
        locator.click();
    }
}
