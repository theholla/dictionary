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

}
