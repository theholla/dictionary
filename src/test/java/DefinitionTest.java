import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("A sudden panicked rush of animals.");
    assertEquals(true, myDefinition instanceof Definition);
  }

}
