import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  //declare the member variable outside of the method
  private String mName;
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public Word(String name) {
    //inside of the constructor, we call mName
    mName = name;
    instances.add(this); //what's going on with "this?"
    mId = instances.size(); //does this pull id from form?
    mDefinitions = new ArrayList<Definition>();
  }

  public String getWord() {
    return mName;
  }

  public int getId() {
    return mId;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition description) { // am I sure about desc?
    mDefinitions.add(description);
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

}
