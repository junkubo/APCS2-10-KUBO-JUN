public class Recursion {
  public static int counter = 0;
  public static String reverse(String s) {
    if (s.length() == 0) {
      return s;
    }
    else {
      return (reverse(s.substring(1)) + s.charAt(0));
    }
  }
  public static long countNoDoubleLetterWords(int length, String word) {

    if(length == 0) {
      counter += 1;
    }
    else{
      for (int i = 0; i < 26; i++) {
        if (word.length() > 0) {
          if (!word.substring(word.length()-1).equals(Character.toString((char)('a'+i)))) {
            countNoDoubleLetterWords(length - 1, word + (char)('a'+i));
          }

        } else {
          countNoDoubleLetterWords(length - 1, word + (char)('a'+i));
        }
      }
    }
    return counter;
  }

  public static double sqrt2(double x, double n) {
    if ((Math.abs((x*x) - n)) / n < 0.00001) {
      return x;
    } else {
      return sqrt2((n / x + x) / 2, n);
    }
  }
  public static double sqrt(double n) {
      if (n <= 0) {
        throw new IllegalArgumentException("No zero or negatives!");
      }
      double x = n/2;
      return(sqrt2(x, n));
  }

  public static void main(String[] args) {
    System.out.println(sqrt(5));
    System.out.println(reverse("thisiscool"));
    System.out.println(countNoDoubleLetterWords(3, ""));
  }

}
