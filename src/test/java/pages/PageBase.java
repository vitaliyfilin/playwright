package pages;

import com.microsoft.playwright.Page;

public class PageBase {
    protected final Page page;

    public PageBase(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

}
