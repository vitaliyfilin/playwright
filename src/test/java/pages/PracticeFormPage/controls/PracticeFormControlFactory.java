package pages.PracticeFormPage.controls;

import com.microsoft.playwright.Page;
import pages.PracticeFormPage.PracticeFormPage;

public class PracticeFormControlFactory {
    PracticeFormPage practiceFormPage;
    Page page;

    public PracticeFormControlFactory(PracticeFormPage practiceFormPage) {
        this.practiceFormPage = practiceFormPage;
        page = practiceFormPage.getPage();
    }

    public PracticeFormControlBase create(String label) {
        return switch (label) {
            case "Subjects" -> new PracticeFormComboBox(page.locator("#subjectsInput"));
            case "Email" -> new PracticeFormTextBox(page.getByPlaceholder("name@example.com"));
            case "Date of Birth" -> new PracticeFormTextBox(page.locator("#dateOfBirthInput"));
            case "Gender" -> new PracticeFormRadioButton(page.getByText("Gender"));
            default -> new PracticeFormTextBox(page.getByPlaceholder(label));
        };
    }
}
