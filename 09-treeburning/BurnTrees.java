import java.util.*;

public class BurnTrees{
  private ArrayDeque<int[]> frontier = new ArrayDeque<int[]>();
  private ArrayDeque<int[]> tempfrontier = new ArrayDeque<int[]>();
  private int[][]map;
  private int ticks;
  private static int TREE = 2;
  private static int FIRE = 1;
  private static int ASH = 3;
  private static int SPACE = 0;
  private static int FIRETEMP = 4;
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }
  public BurnTrees(int width, int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ )
      for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
           map[r][c]=2;
    start();
  }
  public boolean done(){
    for(int i = 0; i < map.length; i++) {
      for(int j = 0; j < map[i].length; j++) {
        if(map[i][j] == FIRE) return false;
      }
    }
    return true;
  }
  public boolean inrange(int i, int j){
    if(i >= map.length || i < 0 || j >= map[i].length || j < 0) {
      return false;
    }
    else{
      return true;
    }
  }
  public void tick() {
    tempfrontier.clear();
    while(!frontier.isEmpty()) {
      int[] loc = frontier.remove();
      //System.out.println("loc is: " + loc[0] + " " + loc[1]);
      if(map[loc[0]][loc[1]] == FIRE && inrange(loc[0], loc[1] + 1) && map[loc[0]][loc[1] + 1] == TREE) {
        map[loc[0]][loc[1] + 1] = FIRETEMP;
        int[] location = new int[] {loc[0],loc[1]+1};
        tempfrontier.add(location);
      }
      if(map[loc[0]][loc[1]] == FIRE && inrange(loc[0], loc[1] - 1) && map[loc[0]][loc[1] - 1] == TREE) {
        map[loc[0]][loc[1] - 1] = FIRETEMP;
        int[] location = new int[] {loc[0],loc[1]-1};
        tempfrontier.add(location);
      }
      if(map[loc[0]][loc[1]] == FIRE && inrange(loc[0] + 1, loc[1]) && map[loc[0] + 1][loc[1]] == TREE) {
        map[loc[0] + 1][loc[1]] = FIRETEMP;
        int[] location = new int[] {loc[0]+1,loc[1]};
        tempfrontier.add(location);
      }
      if(map[loc[0]][loc[1]] == FIRE && inrange(loc[0] - 1, loc[1]) && map[loc[0] - 1][loc[1]] == TREE) {
        map[loc[0] - 1][loc[1]] = FIRETEMP;
        int[] location = new int[] {loc[0]-1,loc[1]};
        tempfrontier.add(location);
      }
      if(map[loc[0]][loc[1]] == FIRE) map[loc[0]][loc[1]] = ASH;
    }
    //iterate through and turn tempfire into fire.
    Iterator<int[]> tempfire = tempfrontier.iterator();
    while (tempfire.hasNext()) {
      int[] tfire = tempfire.next();
      map[tfire[0]][tfire[1]] = FIRE;
      frontier.add(tfire);
    }

    ticks++;
  }
  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        int[] location = new int[] {i,0};
        frontier.add(location);
      }
    }
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }
  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }


  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


  public static void main(String[]args)  throws InterruptedException{
    int WIDTH = 20;
    int HEIGHT = 20;
    int DELAY = 200;
    double DENSITY = .7;
    if(args.length > 1){
      WIDTH = Integer.parseInt(args[0]);
      HEIGHT = Integer.parseInt(args[1]);
      DENSITY = Double.parseDouble(args[2]);
    }
    if(args.length > 3){
      DELAY = Integer.parseInt(args[3]);
    }
    BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


    System.out.println(b.animate(DELAY));//animate all screens and print the final answer
    //System.out.println(b.outputAll());//print all screens and the final answer
  }


}
