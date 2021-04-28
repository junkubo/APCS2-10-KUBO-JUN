import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, size2, start, end;
  public MyDeque(){
    int initialCapacity = 10;
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[initialCapacity];
    data = d;
    start = -1;
    end = 0;
    size = initialCapacity;
    size2 = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[initialCapacity];
    data = d;
    start = -1;
    end = 0;
    size = initialCapacity;
    size2 = 0;
  }
  public int size(){
      return size2;
  }
  public String toString(){
    String str = "{";
    if (start < 0) return "{}";

    if (start <= end) {
    for (int i = start; i <= end; i++) {
      str += data[i];
      if (i != end) str += ", ";
    }

    } else {
    for (int i = start; i < data.length; i++) {
      str += data[i];
      str += ", ";
    }
    for (int i = 0; i <= end; i++) {
      str += data[i];
      if (i != end) str += ", ";
    }

  }
    //System.out.println("start, end: " + start + ", " + end);
    str += "}";
    return str;
  }
  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException("Nulls are not allowed!");
    }
    if ((start == 0 && end == size-1) || start == end + 1) {
      System.out.println("Ran out of space!");
      return;
    }
    if (start == -1)
    {
      start = 0;
      end = 0;
    }
    else if (start == 0)
      start = size - 1 ;
    else
      start = start-1;
    //System.out.println("start: " + start + "  element: " + element);
    //System.out.println(data);
    size2 += 1;
    data[start] = element;
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException("Nulls are not allowed!");
    }
    if (start == -1)
    {
        start = 0;
        end = 0;
    }
    else if (end == size-1) end = 0;
    else end = end+1;
    size2 += 1;
    data[end] = element ;
  }
  public E removeFirst(){
    if ((start == 0 && end == size-1) || start == end+1) {
      throw new NoSuchElementException("empty list");
    }
    E temp_first = data[start];
    if (start == end)
    {
        start = -1;
        end = -1;
    }
    else if (start == size -1) start = 0;
    else start = start+1;
    size2 -= 1;
    return temp_first;
  }
  public E removeLast(){
    if ((start == 0 && end == size-1) || start == end+1) {
      throw new NoSuchElementException("empty list");
    }
    E temp_end = data[end];
    if (start == end)
    {
      start = -1;
      end = -1;
    }
    else if (end == 0)
      end = size-1;
    else
      end = end-1;

    size2 -= 1;
    return temp_end;
  }
  public E getFirst(){
    if ((start == 0 && end == size-1) || start == end+1) {
      throw new NoSuchElementException("empty list");
    }
        return data[start];
  }
  public E getLast(){
    if ((start == 0 && end == size-1) || start == end+1) {
      throw new NoSuchElementException("empty list");
    }
      return data[end];
  }


} // end of whole class
