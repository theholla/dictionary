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
    click("a", withText("Add a new word!"));
    fill("#name").with("peach");
    submit(".btn");
    assertThat(pageSource()).contains("word has been added");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("peach");
    submit(".btn");
    click("a", withText("View all words."));
    assertThat(pageSource()).contains("peach");
  }

  @Test
  public void wordDefinitionFormIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("pear");
    submit(".btn");
    click("a", withText("View all words."));
    click("a", withText("pear"));
    click("a", withText("Add a new definition!"));
    assertThat(pageSource()).contains("Add a definition to pear");
  }

  @Test
  public void definitionIsAddedAndDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("plum");
    submit(".btn");
    click("a", withText("View all words."));
    click("a", withText("plum"));
    click("a", withText("Add a new definition!"));
    fill("#description").with("a tree fruit");
    submit(".btn");
    assertThat(pageSource()).contains("a tree fruit");
  }

}
