public class Driver {
  public static void main (String[] args) {
    MyDeque<String> abc = new <String> MyDeque(10);
    //abc.addFirst("a");
    //abc.addFirst("b");
    //abc.addFirst("c");
    abc.addLast("p");
    abc.addLast("a");
    abc.addLast("d");
    abc.addLast("d");
    abc.addLast("y");
    abc.addLast("g");

    System.out.println(abc.toString());
    System.out.println("Get first: " + abc.getFirst());
    System.out.println("Get last: " + abc.getLast());
    System.out.println("Size is: " + abc.size());
    abc.removeFirst();
    abc.removeLast();
    System.out.println(abc.toString());
    System.out.println("Size is: " + abc.size());
  }
}
