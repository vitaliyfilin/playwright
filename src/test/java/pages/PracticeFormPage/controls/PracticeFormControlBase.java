package pages.PracticeFormPage.controls;

import com.microsoft.playwright.Locator;

public abstract class PracticeFormControlBase {
    protected Locator locator;

    public PracticeFormControlBase(Locator locator) {
        this.locator = locator;
    }

    public abstract void setValue(String value);

    public abstract void click();
}
