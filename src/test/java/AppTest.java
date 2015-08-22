import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary!");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567");
    fill("#name").with("bubble");
    submit(".btn");
    assertThat(pageSource().contains("Your word has been added"));
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567");
    fill("#name").with("bubble");
    submit(".btn");
    click("a", withText("Go back"));
    assertThat(pageSource()).contains("bubble");
  }

  @Test
  public void multipleWordsAreDisplayedTest() {
    goTo("http://localhost:4567");
    fill("#name").with("bubble");
    submit(".btn");
    click("a", withText("Go back"));
    fill("#name").with("stampede");
    submit(".btn");
    click("a", withText("Go back"));
    assertThat(pageSource()).contains("bubble");
    assertThat(pageSource()).contains("stampede");
  }

}
