import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.BrowserEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.DriverUtil;

import static com.codeborne.selenide.Selenide.*;

/**
 * @project: Dao
 * @description: use Selenide to do Google search
 * {@link }
 * @author: Mabel.Chen
 * @create: 2021-03-05 15:05
 **/
public class GoogleTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (null != driver) {
            driver.quit();
        }
    }

    @Test
    public void googleSearch() {
        /***
         * since cannot reach google, the below codes will fail, so I just comment them.
         * **/
//        open("http://google.com");
//        $(By.name("q")).shouldBe(Condition.visible).setValue("Selenide").pressEnter();
//        $$("#ires li.g").shouldHave(CollectionCondition.size(10));
//        $("#ires li.g").shouldHave(Condition.text("Selenide: concise UI tests in Java"));

        open("https://www.baidu.com");
        $("#kw").shouldBe(Condition.visible).setValue("Selenide").pressEnter();
        $("#content_left").shouldBe(Condition.visible);
        SelenideElement first = $$(".result c-container new-pmd").first(); // fail
        first.pressEnter();
    }

    @Test
    public void openChrome() {
        WebDriver driver = DriverUtil.getDriver(BrowserEnum.CHROME);
        driver.get("https://www.baidu.com");
        $("#kw").shouldBe(Condition.visible).setValue("Selenide").pressEnter();
        $("#content_left").shouldBe(Condition.visible);
        SelenideElement first = $$(".result c-container new-pmd").first(); // fail
        first.pressEnter();
    }

    @Test
    public void openEdge() {
        WebDriver driver = DriverUtil.getDriver(BrowserEnum.EDGE);
        driver.get("https://www.baidu.com");
        $("#kw").shouldBe(Condition.visible).setValue("Selenide").pressEnter();
        $("#content_left").shouldBe(Condition.visible);
        SelenideElement first = $$(".result c-container new-pmd").first(); // fail
        first.pressEnter();
    }
}