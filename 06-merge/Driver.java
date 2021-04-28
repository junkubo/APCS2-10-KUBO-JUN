class Driver {
  public static void main (String[] args) {
    int[] test = new int[]{5, 20, -2, 8, 1, 4, 3, 2,200};
    Merge merge = new Merge();
    merge.mergesort(test);
    merge.show(test);
  }
}
