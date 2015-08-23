import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

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

  @Test
  public void clear_removesAllInstancesFromMemory() {
    Definition myDefinition = new Definition("A long tail.");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void find_returnsDefinitionWithSameId() {
    Definition myDefinition = new Definition("A long tail.");
    assertEquals(Definition.find(myDefinition.getId()), myDefinition);
  }

}
