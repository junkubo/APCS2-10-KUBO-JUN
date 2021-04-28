public class Calculator{

  public static double eval(String s){
    if (s.equals("")) {
      throw new IllegalArgumentException("Empty String not allowed!");
    }
    Double first;
    Double second;
    String[] str = s.split(" ", 0);
    MyDeque<String> arr = new <String> MyDeque(100);
    for (int i = 0; i < str.length; i++) {
      try {
        Double.parseDouble(str[i]);
        arr.addLast(str[i]);
      } catch (NumberFormatException nfe) {
        if (arr.size() < 2) {
          throw new IllegalArgumentException("Not enough operands!");
        }
        second = Double.parseDouble(arr.removeLast());
        first = Double.parseDouble(arr.removeLast());
    
        if (str[i].equals("+")) {
          arr.addLast(Double.toString(first + second));

      } else if (str[i].equals("-")) {
          arr.addLast(Double.toString(first - second));

      } else if (str[i].equals("*")) {
          arr.addLast(Double.toString(first * second));

      } else if (str[i].equals("/")) {
          arr.addLast(Double.toString(first / second));
      } else if (str[i].equals("%")) {
          arr.addLast(Double.toString(first % second));

      } else {
        throw new IllegalArgumentException("Illegal operator!");
      }

      }
    } // end of loop

    if (arr.size() == 1) {
      return Double.parseDouble(arr.getLast());
    } else {
        throw new IllegalArgumentException("Number of operands don't work!");
    }

  }
}
