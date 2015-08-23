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
  public void test_addAndGetDefintion() {
    Word myWord = new Word("stampede");
    Definition myDefinition = new Definition("sudden panicked run");
    myWord.addDefinition(myDefinition); // myDefinition is an instance of class Definition
    assertEquals(myDefinition, myWord.getDefinition());
  }

}
