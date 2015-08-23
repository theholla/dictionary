import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @rulespublic ClearRule clearRule = new ClearRule();

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("A sudden panicked rush of animals.");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void definition_returnsDefinition_givesDescription() {
    Definition myDefinition = new Definition("A sudden panicked rush of animals.");
    assertEquals("A sudden panicked rush of animals.", myDefinition.getDescription());
  }

}
