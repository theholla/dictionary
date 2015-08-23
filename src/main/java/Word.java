import java.util.HashMap;

public class Word {
  private String mName;
  private Definition mDefinition;
  private static HashMap<String, Word> mDictionaryMap = new HashMap<String, Word>();
  //static so all words have the same map

  public Word(String name) {
    mName = name;
    mDictionaryMap.put(mName, this); //inside of an object, we can reference that object with [this]
  }

  public void addDefinition(Definition description) {
    mDefinition = description;
  }

  public Definition getDefinition() {
    return mDefinition;
  }

  public String getName() {
    return mName;
  }

  public static Word find(String name) {
    try {
      return mDictionaryMap.get(name);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

}
