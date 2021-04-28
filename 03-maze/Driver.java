import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[]args){
        String filename = "data1.dat";
        try{
          Maze f;
          f = new Maze(filename);//true animates the maze.

          f.setAnimate(true);//comment this if you are using windows cmd/powershell
          //System.out.println(f.solve()+" steps");
          //System.out.println(f);
          System.out.println(f.toString());
          int answer = f.solve();
          System.out.println("Answer is: " + answer);
        }catch(FileNotFoundException e){
          System.out.println("Invalid filename: "+filename);
        }

        System.out.println("Now do Maze Generator ==== ");
        MazeGenerator g;
        g = new MazeGenerator(10,10);
        System.out.println(g.toString());
        g.generate();
        System.out.println(g.toString());
      }

}
