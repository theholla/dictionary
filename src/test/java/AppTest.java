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
  public void definitionIsCreatedTest() {
    goTo("http://localhost:4567");
    click("a", withText("a new ")); //PROBLEM IS HERE
    fill("#description").with("an air-filled sphere");
    submit(".btn");
    assertThat(pageSource().contains("Your definition has been added"));
  }

  @Test
  public void definitionIsDisplayedTest() {
    goTo("http://localhost:4567/definitions/new");
    fill("#description").with("an air-filled sphere");
    submit(".btn");
    click("a", withText("View all definitions"));  //PROBLEM IS HERE
    assertThat(pageSource()).contains("an air-filled sphere");
  }

  @Test
  public void multipleDefinitionsAreDisplayedTest() {
    goTo("http://localhost:4567/definitions/new");
    fill("#description").with("an air-filled sphere");
    submit(".btn");
    goTo("http://localhost:4567/definitions/new");
    fill("#description").with("a sudden panicked rush");
    submit(".btn");
    click("a", withText("View all definitions"));  //PROBLEM IS HERE
    assertThat(pageSource()).contains("an air-filled sphere");
    assertThat(pageSource()).contains("a sudden panicked rush");
  }

  @Test
  public void definitionShowPageDisplaysDescription() {
    goTo("http://localhost:4567/definitions/new");
    fill("#description").with("an air-filled sphere");
    submit(".btn");
    click("a", withText("View all definitions"));  //PROBLEM IS HERE
    click("a", withText("an air-filled sphere"));
    assertThat(pageSource()).contains("an air-filled sphere");
  }

  @Test
  public void definitionNotFoundMessageShown() {
    goTo("http://localhost:4567/definitions/999");
    assertThat(pageSource()).contains("Definition not found");
  }

}
