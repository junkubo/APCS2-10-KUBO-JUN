import java.util.*;

public class Driver {
  public static void main (String args[]) {
    int[] data = {1,10,15,2,54,3,66,88,12};
    int[] data2 = {1,10,15,2,54,3,66,88,12};
    int[] data3 = {1,10,15,2,54,3,66,88,12};

    int start = 3;
    int end = 7;
    Preliminary pre = new Preliminary();
    System.out.println(pre.partition(data, start, end));


    System.out.println("====  Quick Select ====");

    Quick quick2 = new Quick();
    int x = quick2.quickselect(data2, 3);
    System.out.println("Quick Select Answer is: " + x);

    System.out.println("==== QUick Sort ====");
    Quick quick3 = new Quick();

    quick3.quicksort(data3);

    quick3.show(data3);

    }

}
