import java.util.List;
import java.util.stream.Collectors;

public class Main {

  private static final char[] alphabet = "aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż".toCharArray();
  private static final List<Character> ignored = List.of(' ', '!');

  public static void main(String[] args) {
    String code = "Kqdnż oc łxb wtaż ncwc!";
    decypher(code);
  }

  static void decypher(String code) {
    for (int i = 0; i < alphabet.length; i++) {
      int finalI = i;
      String result = code.toLowerCase().chars()
          .mapToObj(el -> getChar((char)el, finalI))
          .map(String::valueOf)
          .collect(Collectors.joining());
      System.out.println(result);
    }
  }

  static char getChar(char el, int temp) {
    if(ignored.contains(el)) {
      return el;
    }
    int idx = findIndex(el) + temp;
    return alphabet[idx % (alphabet.length)];
  }

  static int findIndex( char value) {
    for (int i = 0; i < alphabet.length; i++) {
      if (alphabet[i] == value) {
        return i;
      }
    }
    return -1;
  }
}
