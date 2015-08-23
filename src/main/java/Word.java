public class Word {
  private String mName;
  private Definition mDefinition;

  public Word(String name) {
    mName = name;
  }

  public void addDefinition(Definition definition) {
    mDefinition = definition;
  }

  public Definition getDefinition() {
    return mDefinition;
  }

  public String getName() {
    return mName;
  }

}
