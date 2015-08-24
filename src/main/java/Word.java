import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private String mName;
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public Word(String name) {
    mName = name;
    instances.add(this); //inside of an object, we can reference that object with [this]
    mId = instances.size(); //makes each object have a unique id
    mDefinitions = new ArrayList<Definition>();
    //initializes as a new empty array list whenever we have a new word
  }

  public String getName() {
    return mName;
  }

  public int getId() {
    return mId;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition description) {
    mDefinitions.add(description);
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Word find(int id) { //finds the unique instance in our array
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

}
