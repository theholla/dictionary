import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_instantiatesCorrectly_true() {
    Word myWord = new Word("stampede");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void word_instantiatesWithName_givesName() {
    Word myWord = new Word("stampede");
    assertEquals("stampede", myWord.getName()); //Name is just a string
  }

  @Test
  public void test_addAndGetDefinition() {
    Word myWord = new Word("stampede");
    Definition myDefinition = new Definition("sudden panicked run");
    myWord.addDefinition(myDefinition); // myDefinition is an instance of class Definition
    assertEquals(myDefinition, myWord.getDefinition());
    assertEquals("sudden panicked run", myWord.getDefinition().getDescription());
    //goes from a word to a definition string
  }

  @Test
  public void addDefinition_addsDefinitionToList() {
    Word testWord = new Word("tuxedo");
    Definition testDefinition = new Definition("a dinner jacket.");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinition().equals(testDefinition));
  }

}
