public class Word {
  //declare the member variable outside of the method
  String mWord;

  public Word(String word) {
    //inside of the constructor, we call mWord
    mWord = word;
  }

  public String getWord() {
    return mWord;
  }
}
