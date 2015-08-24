import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  private String mDefinition;
  private int mId;

  public Definition(String description) {
    mDefinition = description;
    instances.add(this); // inside of an object, we can reference that object with [this]
    mId = instances.size(); // makes each object have a unique id
  }

  public String getDescription() {
    return mDefinition;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static Definition find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }

}
