import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

/**
 * @project: JavaLearning
 * @description: 这个demo说明，Selenide不需要显示地加载设置WebDriver, 也不需要显示地关闭浏览器，
 * 这些都是Selenide自动完成的
 * github of Selenide: https://github.com/selenide/selenide
 * Official website: https://selenide.org/
 * @author: Mabel.Chen
 * @create: 2021-03-05
 **/
public class GoogleSimpleTest {

    @Test
    public void simpleTest() {
        System.out.println("Open start ......");
        open("https://www.baidu.com");
        $("#kw").shouldBe(Condition.visible).setValue("Selenide").pressEnter();
        $("#content_left").shouldBe(Condition.visible);
        SelenideElement element = $("#content_left");
        SelenideElement result = $("result c-container new-pmd");
        System.out.println(result);
        ElementsCollection results = $$(".result c-container new-pmd");
        int size = results.size();
        System.out.println(size);
    }

    @Test
    public void openTest() {
        System.out.println("Open start ......");
        open("https://www.baidu.com");
        System.out.println("Open end ......");
        $("#1");
        withText("");
    }
}