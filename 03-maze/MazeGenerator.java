import java.util.*;
import java.io.*;

public class MazeGenerator {
  private char[][]maze;
  int rows;
  int columns;
  int visited;
  int mazeSolved = 0;
  Random rand = new Random();
  int direction;

  public MazeGenerator(int rows1, int columns1){
    rows = rows1;
    columns = columns1;
    visited = 0;
    maze = new char[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        maze[i][j] = '#';
      }
    }

  }
  public boolean isWall(int x, int y) {
    if (x == 0 || y == 0 || x == rows - 1 || y == columns - 1) {
      return true;
    }
    else {
      return false;
    }
  }
  public boolean wall2(int x, int y) {
    int count = 0;
    if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) return false;
    if (maze[x + 1][y] == '#') count += 1;
    if (maze[x - 1][y] == '#') count += 1;
    if (maze[x][y + 1] == '#') count += 1;
    if (maze[x][y - 1] == '#') count += 1;
    return count >= 3;
  }

  public String toString(){
    String s = "";
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        s += maze[i][j];
      }
      s += "\n";
      }
      return s;
  }


  public int generate(){
          int startX = 1;
          int startY = 1;

          return generate(startX, startY);
          //start solving at the location of the s.
          //return solve(???,???);
  }

  public int generate(int x,int y) {
    //if (mazeSolved == 1) return pathLength;
    /*
    if(animate){
        gotoTop();
        System.out.println(this);
        wait(5);
    }
    */

    if (x >= 1 && x < rows && y >= 1 && y < columns && maze[x][y] == '#') {
      //System.out.println("x is: " + x + " y is: " + y);
      if (wall2(x, y)) {
          maze[x][y] = ' ';
          //System.out.println("Printed a space at: " + x + ", " + y + " - wall2() is: " + wall2(x,y));
      }
      // pick random direction
      direction = rand.nextInt(4);

      if (direction == 0) {
        if (wall2(x + 1, y) && generate(x + 1, y) == 1) return 1;
        if (wall2(x, y + 1) && generate(x, y + 1) == 1) return 1;
        if (wall2(x - 1, y) && generate(x-1, y) == 1) return 1;
        if (wall2(x, y - 1) && generate(x, y-1) == 1) return 1;

      } else if (direction == 1) {
        if (wall2(x, y + 1) && generate(x, y + 1) == 1) return 1;
        if (wall2(x - 1, y) && generate(x-1, y) == 1) return 1;
        if (wall2(x, y - 1) && generate(x, y-1) == 1) return 1;
        if (wall2(x + 1, y) && generate(x + 1, y) == 1) return 1;
      } else if (direction == 2) {
        if (wall2(x - 1, y) && generate(x-1, y) == 1) return 1;
        if (wall2(x, y - 1) && generate(x, y-1) == 1) return 1;
        if (wall2(x + 1, y) && generate(x + 1, y) == 1) return 1;
        if (wall2(x, y + 1) && generate(x, y + 1) == 1) return 1;
      } else if (direction == 3) {
        if (wall2(x, y - 1) && generate(x, y-1) == 1) return 1;
        if (wall2(x + 1, y) && generate(x + 1, y) == 1) return 1;
        if (wall2(x, y + 1) && generate(x, y + 1) == 1) return 1;
        if (wall2(x - 1, y) && generate(x-1, y) == 1) return 1;
      }

      //maze[x][y] = '';
      if (mazeSolved == 1) {
        //return pathLength;
        return 1;
      } else {
      return 0;
      }
    }
    return -1;
      }

  }
