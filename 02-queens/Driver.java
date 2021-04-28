class Driver {

  public static void main(String[] args) {
    QueenBoard queenBoard = new QueenBoard(8);
    //queenBoard.addQueen(1,2);
    //queenBoard.addQueen(4,3);
    //System.out.println(queenBoard.toString());
    //queenBoard.removeQueen(1,2);
    //System.out.println(queenBoard.toString());
    System.out.println(queenBoard.solve());
    System.out.println(queenBoard.toString());
    System.out.println(queenBoard.countSolutions());
    System.out.println(queenBoard.toString());
    }

}
