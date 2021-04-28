
public class MyHeap {
  private static int size;
  private int[] Heap;

  public static void buildHeap(int[] data) {
    int n = data.length;
    size = n;
    int j = (n / 2) - 1;
    for (int i = j; i >= 0; i--) {
      pushDown(data, n, i);
    }
  }
  private static void remove(int[] data, int size) {
    int swap = data[0];
    data[0] = data[size - 1];
    size -= 1;
    pushDown(data, size, 0);
  }

  public static void heapsort(int[] data) {
    for (int i = size-1; i > 0; i--) {
        int temp = data[0];
        data[0] = data[i];
        data[i] = temp;
        pushDown(data, i, 0);
    }

  }

  public static void pushDown(int[] data, int size, int i) {
    int largest = i;
      int l = 2 * i + 1;
      int r = 2 * i + 2;
      if (l < size && data[l] > data[largest]) {
        largest = l;
      }
      if (r < size && data[r] > data[largest]) {
        largest = r;
      }
      if (largest != i) {
        int swap = data[i];
        data[i] = data[largest];
        data[largest] = swap;
        pushDown(data, size, largest);
      }
  }
}
