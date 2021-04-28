import java.util.*;
public class Preliminary {
  public static int partition ( int [] data, int start, int end){
    Random rand = new Random();
    int index = rand.nextInt(end-start) + start;
    int pivot = data[index];
    //System.out.println(index);
    //System.out.println(pivot);

    System.out.println("index is: " + index);
    System.out.println("random pivot is: " + data[index]);

    // swap start and index pivot
    data[index] = data[start];
    data[start] = pivot;




    int i = start;
    int j = end + 1;
    while (i < j) {
      for (i++; data[i] < pivot; i++);
      for (j--; data[j] > pivot; j--);
      if (i < j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
      }
    }

    return j;
  }
}
