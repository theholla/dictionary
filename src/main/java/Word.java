public class Word {
  //declare the member variable outside of the method
  private String mName;

  public Word(String name) {
    //inside of the constructor, we call mName
    mName = name;
  }

  public String getWord() {
    return mName;
  }
}
