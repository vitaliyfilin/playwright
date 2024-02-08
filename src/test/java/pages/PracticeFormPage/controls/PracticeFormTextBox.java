package pages.PracticeFormPage.controls;

import com.microsoft.playwright.Locator;

public class PracticeFormTextBox extends PracticeFormControlBase {
    public PracticeFormTextBox(Locator locator) {
        super(locator);
    }

    @Override
    public void setValue(String value) {
        locator.fill(value);
    }

    @Override
    public void click() {
        locator.click();
    }
}
