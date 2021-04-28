public class Driver {
  public static void main (String[] args) {
    Calculator c = new Calculator();
    //c.eval("");
    System.out.println(c.eval("1 2 +"));
    System.out.println(c.eval("11 3 - 4 + 2.5 *")); //is 30.0
    System.out.println(c.eval("10 2.0 +")); //is 12.0
    System.out.println(c.eval("8 2 + 99 9 - * 2 + 9 -")); //is 893.0
    System.out.println(c.eval("1 2 3 4 5 + * - -")); //is 26.0

    System.out.println(c.eval("1 2 3 4 5 + * -"));

  }
}
