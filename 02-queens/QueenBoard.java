class QueenBoard {
  private int[][] board;
  int bsize;
  int counter;

  public QueenBoard(int size){
    bsize = size;
    board = new int[size][size];
      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          board[i][j] = 0;
        }
      }
  }

  //change to private later... do public for testing...
  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for (int i = 0; i < bsize; i++) {
        if (board[i][c] != -1) {
          board[i][c] += 1;
        }
        if (board[r][i] != -1) {
          board[r][i] += 1;
        }
      }
      for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] != -1) {
          board[i][j] += 1;
        }
      }
      for (int i = r, j = c; i >= 0 && j < bsize; i--, j++) {
        if (board[i][j] != -1) {
          board[i][j] += 1;
        }
      }
      for (int i = r, j = c; i < bsize && j >= 0; i++, j--) {
        if (board[i][j] != -1) {
          board[i][j] += 1;
        }
      }
      for (int i = r, j = c; i < bsize && j < bsize; i++, j++) {
        if (board[i][j] != -1) {
          board[i][j] += 1;
        }
      }
    return true;
  } else {
    return false;
  }
  }
  // change to private later, public for testing
  public void removeQueen(int r, int c) {
    if (board[r][c] == -1) {
      for (int i = 0; i < bsize; i++) {
        if (board[i][c] != -1) {
          board[i][c] -= 1;
        }
        if (board[r][i] != -1) {
          board[r][i] -= 1;
        }
      }
      for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] != -1) {
          board[i][j] -= 1;
        }
      }
      for (int i = r, j = c; i >= 0 && j < bsize; i--, j++) {
        if (board[i][j] != -1) {
          board[i][j] -= 1;
        }
      }
      for (int i = r, j = c; i < bsize && j >= 0; i++, j--) {
        if (board[i][j] != -1) {
          board[i][j] -= 1;
        }
      }
      for (int i = r, j = c; i < bsize && j < bsize; i++, j++) {
        if (board[i][j] != -1) {
          board[i][j] -= 1;
        }
      }
      board[r][c] = 0;
    } else {

    }
  }

  public String toString(){
    String board_str = "";
      for (int i = 0; i < bsize; i++) {
      for (int j = 0; j < bsize; j++) {
        if (board[i][j] == -1) {
          board_str += "Q ";
          //board_str += board[i][j] + " ";
        } else {
          board_str += "_ ";
          //board_str += board[i][j] + " ";
        }
      }
      board_str += "\n";
    }
    return board_str;
  }
  public boolean solve(int c){
    if (c == 0) {
      for (int i = 0; i < bsize; i++) {
        for (int j = 0; j < bsize;
         j++) {
          if (board[i][j] != 0) {
            throw new IllegalArgumentException("Board has non-zero value");
          }
        }
      }
    }
    if (c >= bsize) {
        counter += 1;
        return true;
    }
    boolean done = false;
    for (int i = 0; i < bsize; i++) {
      if (board[i][c] == 0) {
        addQueen(i, c);
        //if (solve(c + 1) == true) return true;
        done = solve(c+1) || done;
        removeQueen(i, c);
      }
    }
    return done;

  }

  public boolean solve() {
    solve(0);
    return true;
  }

  public int countSolutions(){
      for (int i = 0; i < bsize; i++) {
        for (int j = 0; j < bsize;
         j++) {
          if (board[i][j] != 0) {
            throw new IllegalArgumentException("Board has non-zero value");
          }
        }
      }
    counter = 0;
    solve();
    return counter;
  }

}
