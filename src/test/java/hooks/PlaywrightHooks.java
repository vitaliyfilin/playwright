package hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.*;
import model.ScenarioTag;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class PlaywrightHooks {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private final int DEFAULT_TIMEOUT = 5_000;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Starting test execution...");
    }

    @Before
    public void setUp(Scenario scenario) {
        playwright = Playwright.create();

        var scenarioTags = parseScenarioTags(scenario);

        var isHeadLess = false;
        var locale = "en-US";
        var browserType = playwright.chromium();
        var slowMo = 0;
        var devTools = false;

        if (scenarioTags != null) {
            for (ScenarioTag scenarioTag : scenarioTags) {
                switch (scenarioTag.label().toLowerCase()) {
                    case "headless" -> isHeadLess = Boolean.parseBoolean(scenarioTag.value());
                    case "locale" -> locale = scenarioTag.value();
                    case "browser" -> browserType = getBrowserType(scenarioTag.value());
                    case "slowmo" -> slowMo = Integer.parseInt(scenarioTag.value());
                    case "devtools" -> devTools = Boolean.parseBoolean(scenarioTag.value());
                    default -> throw new RuntimeException("Unknown scenario tag: " + scenarioTag) {
                    };
                }
            }
        }

        browser = browserType.launch(
                new BrowserType
                        .LaunchOptions()
                        .setHeadless(isHeadLess)
                        .setSlowMo(slowMo)
                        .setDevtools(devTools));

        context = browser.newContext(
                new Browser
                        .NewContextOptions()
                        .setAcceptDownloads(true)
                        .setBaseURL("https://demoqa.com/")
                        .setLocale(locale));

        page = context.newPage();

        page.setDefaultTimeout(DEFAULT_TIMEOUT);
        page.onConsoleMessage(consoleMessage -> System.out.println("Console: " + consoleMessage.text()));

        System.out.println("Executing scenario: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            page.screenshot(new Page
                    .ScreenshotOptions()
                    .setPath(Paths.get("screenshot.jpg")));
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (context != null)
            context.close();
        if (browser != null)
            browser.close();
        if (playwright != null)
            playwright.close();

        System.out.println("Finished scenario: " + scenario.getName());
    }

    private Collection<ScenarioTag> parseScenarioTags(Scenario scenario) {
        var tags = scenario.getSourceTagNames();
        if (!tags.isEmpty()) {
            Collection<ScenarioTag> scenarioTags = new ArrayList<>();

            for (String tag : tags) {
                String[] parts = tag.split(":");

                String label = parts[0].trim().replaceAll("@", "");
                String value = parts[1].trim();

                ScenarioTag scenarioTag = new ScenarioTag(label, value);
                scenarioTags.add(scenarioTag);
            }

            return scenarioTags;
        }
        return null;
    }

    private BrowserType getBrowserType(String label) {
        return switch (label.toLowerCase()) {
            case "firefox" -> playwright.firefox();
            case "webkit" -> playwright.webkit();
            default -> playwright.chromium();
        };
    }

    public BrowserContext getContext() {
        return context;
    }

    public Page getPage() {
        return page;
    }
}
