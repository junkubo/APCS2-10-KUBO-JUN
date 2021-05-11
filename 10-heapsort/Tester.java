public class Tester {
  public static void main(String[] args) {
    //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] array = {8,1,3,10,4,5,6,7,9,2};
    MyHeap heap = new MyHeap();
    heap.buildHeap(array);

    for (int i=0; i < array.length; i++) {
      System.out.println(array[i]);
    }

    //int[] array = {8,1,3,10,4,5,6,7,9,2};
    //MyHeap heap = new MyHeap();
    heap.heapsort(array);
    System.out.println("After Sort: ");
    for (int i=0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }
}
