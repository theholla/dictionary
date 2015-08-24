import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

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
  public void getDefinitions_initiallyReturnsEmptyArrayList() {
    Word testWord = new Word("slurpee");
    assertTrue(testWord.getDefinitions() instanceof ArrayList); // PROBLEM
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("boat");
    Word secondWord = new Word("bike");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_removesAllWordInstancesFromMemory() {
    Word testWord = new Word("rainbow");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void find_returnsWordWithSameId() {
    Word testWord = new Word("fox");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void addDefinition_addsDefinitionToList() {
    Word testWord = new Word("silo");
    Definition testDefinition = new Definition("a tower to store grain");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }
}
