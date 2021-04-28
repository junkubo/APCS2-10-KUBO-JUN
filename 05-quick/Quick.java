import java.util.*;
public class Quick {
  public static int partition (int [] data, int start, int end){
    Random rand = new Random();
    //System.out.println("end and start is: " + end + " " + start);
    //show(data);
    int index = rand.nextInt(end-start) + start;
    int pivot = data[index];
    //System.out.println("index is: " + index);
    //System.out.println("random pivot is: " + data[index]);
    data[index] = data[start];
    data[start] = pivot;
    int i = start;
    int j = end;
    //System.out.println(" ======  i = " + i + " j = " + j + " data length = " + data.length);
    while (i < j) {
      //System.out.println("i = " + i + " j = " + j + "pivot: " + pivot);
      for (i++; i < data.length && data[i] < pivot; i++);
      for (j--;  j >= 0 && data[j] > pivot; j--);
      if (i < j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
      }
    }
    //System.out.println("End of partition with pivot index: " + index + " pivot: " + pivot);
    // put pivot in its place
    data[start] = data[j];
    data[j] = pivot;
    //show(data);
    return j;
  }

  public static int quickselect(int[] data, int low, int high, int k) {
      int partition = partition(data, low, high);
      if (partition == k) return data[partition];
      else if (partition < k) return quickselect(data, partition+1, high, k);
      else return quickselect(data, low, partition, k);
  }

  public static int quickselect(int[] data, int k){
    return(quickselect(data, 0, data.length, k));

  }

  public static void show(int[] data) {
    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i] + ", ");
    }
    System.out.println("");
  }

  public static void quicksort(int[] data, int start, int end) {
    if (start < end) {
        int partition = partition(data, start, end);
        quicksort(data, start, partition);
        quicksort(data, partition+1, end);
    }
    return;
  }

  public static void quicksort(int[] data){
    quicksort(data, 0, data.length);
  }

}  // end of whole class
