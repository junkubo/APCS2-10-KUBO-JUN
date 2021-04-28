public class Merge {
  public static void merge(int[]data, int lo, int mid, int hi) {
    int lSize = mid - lo + 1;
    int hSize = hi - mid;
    int a1[] = new int[lSize];
    int a2[] = new int[hSize];
    for (int i = 0; i < lSize; i++) {
      a1[i] = data[lo + i];
    }
    for (int i = 0; i < hSize; i++) {
      a2[i] = data[mid +1 + i];
    }
    // merge arrays
    int i = 0;
    int j = 0;

    int k = lo;
        while (i < lSize && j < hSize) {
            if (a1[i] <= a2[j]) {
                data[k] = a1[i];
                i++;
            }
            else {
                data[k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < lSize) {
            data[k] = a1[i];
            i++;
            k++;
        }
        while (j < hSize) {
            data[k] = a2[j];
            j++;
            k++;
        }
  }

  public void show(int[] data) {
    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i] + ", ");
    }
    System.out.println("");
  }
  public static void mergesort(int[] data, int lo, int hi) {
    if (lo < hi) {
      int mid = lo + (hi - lo)/2;
      mergesort(data, lo, mid);
      mergesort(data, mid+1, hi);

      merge(data, lo, mid, hi);
    }
  }
  public static void mergesort(int[]data) {
    int lo = 0;
    int hi = data.length -1;
    int mid = hi / 2;
    mergesort(data, lo, hi);

  }
}
