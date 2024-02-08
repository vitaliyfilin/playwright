package steps;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import hooks.PlaywrightHooks;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class StepsBase {

    protected final BrowserContext context;
    protected final Page page;
    private final MutablePicoContainer picoContainer;

    public StepsBase(PlaywrightHooks playwrightHooks) {
        this.context = playwrightHooks.getContext();
        this.page = playwrightHooks.getPage();
        this.picoContainer = new DefaultPicoContainer();
    }

    /**
     * Adds a component to Pico container associated with the specified label.
     *
     * @param <T>   the type of the component value
     * @param label the label/name associated with the component
     * @param value the value of the component to be added
     */
    protected <T> void addComponent(String label, T value) {
        picoContainer.addComponent(label, value);
    }

    /**
     * Retrieves a component from Pico container associated with the specified label.
     *
     * @param <T>   the type of the component value
     * @param label the label/name associated with the component
     * @return the component value associated with the label
     */
    protected <T> T getComponent(String label) {
        return (T) picoContainer.getComponent(label);
    }

}
