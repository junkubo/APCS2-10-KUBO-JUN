import java.util.*;
import java.io.*;

public class USACO {
  public static int bronze(String filename) throws FileNotFoundException {
    File f = new File(filename);
    Scanner s = new Scanner(f);
    int rowNum = 0;
    String text = "";
    int R = 0;
    int C = 0;
    int E = 0;
    int N = 0;

    while(s.hasNextLine()) {
      String line = s.nextLine();
      System.out.println(line);
      if (rowNum == 0) {
        String[] firstRow = line.split(" ");
        R = Integer.parseInt(firstRow[0]);
        C = Integer.parseInt(firstRow[1]);
        E = Integer.parseInt(firstRow[2]);
        N = Integer.parseInt(firstRow[3]);
      }
      rowNum += 1;
    }
    int totalRows = rowNum;
    int lake[][] = new int[R][C];
    int commands[][] = new int[totalRows - (R + 1)][3];
    f = new File(filename);
    s = new Scanner(f);
    rowNum = 0;
    while(s.hasNextLine()) {
      String line = s.nextLine();
      //System.out.println();
      if (rowNum > 0 && rowNum < R + 1) {
        String[] new_row = line.split(" ");
        for (int i = 0; i < new_row.length; i++) {
          //System.out.println(new_row[i]);
          lake[rowNum-1][i] = Integer.parseInt(new_row[i]);
        }
      }
      else {
        if (rowNum > R) {
          String[] new_row = line.split(" ");
          for (int i = 0; i < new_row.length; i++) {
            if (i < 2) {
              commands[rowNum - (R + 1)][i] = Integer.parseInt(new_row[i]) - 1;
            }
            else {
              commands[rowNum - (R + 1)][i] = Integer.parseInt(new_row[i]);
            }
          }
        }
      }
      rowNum += 1;
    }
/*
    System.out.println("Test lake:");
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        System.out.print(lake[i][j] + " ");
      }
      System.out.println("\n");
    }
    System.out.println("Test commands:");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(commands[i][j]+ " ");
      }
      System.out.println("\n");
    }
*/
// commands are already converted to zero-indexed.

  for (int comm = 0; comm < commands.length; comm++) {
    int x = commands[comm][0];
    int y = commands[comm][1];
    int depth = commands[comm][2];
    //System.out.println("x: " + x + " y: " + y + " depth: " + depth);

    //find max in submatrix
    int max = 0;
    for (int i = x; i < x+3; i++) {
      for (int j = y; j < y + 3; j++) {
        if (lake[i][j] > max) max = lake[i][j];
      }
    }
    // flatten
    for (int i = x; i < x+3; i++) {
      for (int j = y; j < y + 3; j++) {
        //System.out.println("i is: " + i + " j is: " + j);
        if (lake[i][j] == max) {
          lake[i][j] -= depth;

        } else if (lake[i][j] > max-depth) {
          lake[i][j] = max - depth;
        }
      }
    }
  }
    // calculate lake depth and total cubic feet
    int tcf = 0;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        lake[i][j] = Math.max(0, E - lake[i][j]);
        tcf += 72 * 72 * lake[i][j];
      }
    }

    //System.out.println("Answer is: " + tcf);

/*
  System.out.println("Test lake:");
  for (int i = 0; i < R; i++) {
    for (int j = 0; j < C; j++) {
      System.out.print(lake[i][j] + " ");
    }
    System.out.println("\n");
  }

  */
  return tcf;
  } // closes bronze method

  public static int silver(String filename) throws FileNotFoundException {
    File f = new File(filename);
    Scanner s = new Scanner(f);
    int rowNum = 0;
    String text = "";
    int N = 0;
    int M = 0;
    int T = 0;
    int R1 = 0;
    int C1 = 0;
    int R2 = 0;
    int C2 = 0;

    while(s.hasNextLine()) {
      String line = s.nextLine();
      System.out.println(line);
      if (rowNum == 0) {
        String[] firstRow = line.split(" ");
        N = Integer.parseInt(firstRow[0]);
        M = Integer.parseInt(firstRow[1]);
        T = Integer.parseInt(firstRow[2]);
      }
      if (rowNum == N + 1) {
        //System.out.println(rowNum + " - " + N + " -  " + M);
        String[] lastRow = line.split(" ");
        R1 = Integer.parseInt(lastRow[0]) -1;
        C1 = Integer.parseInt(lastRow[1]) -1;
        R2 = Integer.parseInt(lastRow[2]) -1;
        C2 = Integer.parseInt(lastRow[3]) -1;
      }
      rowNum += 1;
    }
    int grid[][] = new int[N][M];
    int grid2[][] = new int[N][M];

    //System.out.println("Check data, N = " + N + " M = " + M + " " + R1 + " "  + C1 + " " + R2 + " " + C2 + " T is " + T);
    f = new File(filename);
    s = new Scanner(f);
    rowNum = 0;

    while(s.hasNextLine()) {
      String line = s.nextLine();

      if (rowNum > 0 && rowNum < N) {
        String[] firstRow = line.split("");
        for (int i = 0; i < M; i++) {
          if (firstRow[i].equals(".")) {
            grid[rowNum-1][i] = 0;
          } else {
            grid[rowNum-1][i] = -1;
          }
        }
      }
    rowNum += 1;
    }

    // set first square 1.
    if (R1 - 1 >= 0 && grid[R1-1][C1] >= 0) grid[R1-1][C1] = 1;
    if (R1 + 1 < M && grid[R1+1][C1] >= 0) grid[R1+1][C1] = 1;
    if (C1 -1 >= 0 && grid[R1][C1-1] >= 0) grid[R1][C1 -1] = 1;
    if (C1 + 1 < N && grid[R1][C1+1] >= 0) grid[R1][C1+1] = 1;

    // loop T times to set values on full grid2

    for (int ttt = 0; ttt < T-1; ttt++) {
      //System.out.println("RUNNING =========  " + ttt);
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          int total = 0;
          if (grid[i][j] >= 0) {
            if (i - 1 >= 0 && grid[i-1][j] >= 0) total += grid[i-1][j];
            if (i + 1 < N && grid[i+1][j] >= 0) total += grid[i+1][j];
            if (j - 1 >= 0 && grid[i][j-1] >= 0) total += grid[i][j-1];
            if (j + 1 < M && grid[i][j+1] >= 0) total += grid[i][j+1];
            grid2[i][j] = total;
          } else {
            grid2[i][j] = -1;
          }
        }
      }

      // move grid 2 to grid, and empty it.
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            grid[i][j] = grid2[i][j];
            grid2[i][j] = 0;
          }
        }
        /*
        System.out.println("---");
        for(int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
            System.out.print(grid[i][j] + " ");
          }
          System.out.print("\n");
        }
        */
    }
    /*
    System.out.println("---");
    for(int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.print("\n");
    }

    System.out.println("---");
    for(int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(grid2[i][j] + " ");
      }
      System.out.print("\n");
    }
    */
    return grid[R2][C2];
  } // close silver method


} // closes whole class
