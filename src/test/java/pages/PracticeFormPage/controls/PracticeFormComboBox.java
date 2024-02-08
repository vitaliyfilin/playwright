package pages.PracticeFormPage.controls;

import com.microsoft.playwright.Locator;

public class PracticeFormComboBox extends PracticeFormControlBase {
    public PracticeFormComboBox(Locator locator) {
        super(locator);
    }

    @Override
    public void setValue(String value) {
        var singleOption = "#react-select-2-option-0";
        var defaultTimeout = 1_000;

        locator.click(new Locator.ClickOptions().setForce(true));

        var values = value.split(",");

        for (var v : values) {
            locator.fill(v.trim());

            var option = locator.page().locator(singleOption);
            option.waitFor(new Locator.WaitForOptions().setTimeout(defaultTimeout));

            option.click();
        }
    }

    @Override
    public void click() {
        locator.click();
    }
}

