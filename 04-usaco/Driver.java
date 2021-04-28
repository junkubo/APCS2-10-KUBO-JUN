import java.util.*;
import java.io.*;


public class Driver {
  public static void main(String[] args) {
    try{
      USACO test = new USACO();
      int ans = test.bronze("lake1.input");
      System.out.println("Answer is: " + ans);

      int ans2 = test.silver("altgrid.input");
      System.out.println("Silver answer is: " + ans2);
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename");
    }

  }
}
