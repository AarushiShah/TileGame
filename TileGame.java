import Acme.*;
import objectdraw.*;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
public class TileGame extends WindowController implements ActionListener {

  private static final Color[] COLORS = { PA5Constants.TILE_COLOR_1,
    PA5Constants.TILE_COLOR_2, PA5Constants.TILE_COLOR_3,
    PA5Constants.TILE_COLOR_4, PA5Constants.TILE_COLOR_5 };
  private Random randomGenerator;
  private Location[] activeLocations = new Location[9];
  private Location [] solutionLocations = new Location[9];
  private SolutionTile[] solutionTiles = new SolutionTile[9];
  private ActiveTile[] activeTiles = new ActiveTile[9];
  private boolean[] referenceArr = new boolean[9];
  private int x;
  private int y;
  private int selected;
  private Timer timer;
  private Text winningText;
  private JButton refresh;
  private int seed;
  /**
  *
  *
  */
 public static void main(String [] args) {
   if (args.length != 1) {
      System.out.println("bad input");
      System.exit(1);
   }
   String inputtedSeed = args[0];
   int seed = 0;
   try {
     seed = Integer.parseInt(inputtedSeed);
   } catch (NumberFormatException e) {
     System.exit(1);
   }

   new Acme.MainFrame(new TileGame(seed), args, 735, 380);

 }
 public TileGame( int seed) {
   randomGenerator = new Random(seed);
   this.seed = seed;
 }
 public void begin( ) {
   activeTileLocations();
      solutionTileLocations();
      createBoard();
      timer = new Timer();
      refresh = new JButton("Reset");
      this.add(refresh, BorderLayout.NORTH);
      this.validate();
      refresh.addActionListener(this);
 }
 public void actionPerformed( ActionEvent evt) {
   canvas.clear();
   randomGenerator.setSeed(seed);
   activeTileLocations();
   solutionTileLocations();
   createBoard();
   selected = 0;
 }
 public void onMouseClick(Location point) {
   boolean longClick = false;
   if ( timer.elapsedMilliseconds() >= PA5Constants.SWAP_THRESHOLD ) {
     longClick = true;
   }
   for( int i = 0; i < 9; i++) {
     if(activeTiles[i].contains(point)) {
        if(longClick && activeTiles[i].isHighlighted() && activeTiles[i].isSwappable() ) {
          swap(activeTiles[i], i);
        } else if(!activeTiles[i].isHighlighted() && selected < 2) {
          activeTiles[i].showHighlight(Color.GREEN);
          selected++;
        } else if(activeTiles[i].isHighlighted() && activeTiles[i].isSwappable()) {
          activeTiles[i].hideHighlight();
          selected--;
        }
     }

   }
 }
 public void swap(ActiveTile x, int index) {

   for( int i = 0; i < 9; i++) {
     if(activeTiles[i].isSwappable() && activeTiles[i].isHighlighted() && i != index) {
       x.swap(activeTiles[i]);
       x.hideHighlight();
       activeTiles[i].hideHighlight();
       selected-=2;
       checkBoard();
       return;
     }
   }
 }
 public void checkBoard() {
   for(int i = 0; i < 9; i++) {
     if(activeTiles[i].getColor().equals(solutionTiles[i].getColor())) {
       activeTiles[i].showHighlight(PA5Constants.MATCH_COLOR);
       activeTiles[i].setSwappable(false);
       solutionTiles[i].showHighlight(PA5Constants.MATCH_COLOR);
     }
   }
   int correct  = 0;
   for(int i = 0; i < 9; i++) {
     if(activeTiles[i].getColor().equals(solutionTiles[i].getColor())) {
       correct++;
     }
   }
   if(correct == 9) {
     winningText.show();
     winningText.setColor(PA5Constants.WIN_COLOR);
     winningText.setFontSize(PA5Constants.FONT_SIZE);
     winningText.setBold(true);

   }
 }
 public void onMousePress(Location point ) {
    timer.reset();
 }
 public void activeTileLocations() {

       for( int i = 0; i < 9; i++ ) {
          x = PA5Constants.BOARD_MARGIN_X +
              PA5Constants.FRAME_SIDE * (i % PA5Constants.TILES_PER_COL);

          y = PA5Constants.BOARD_MARGIN_Y +
              PA5Constants.FRAME_SIDE * (i / PA5Constants.TILES_PER_ROW);

          activeLocations[i] = new Location(x,y);

       }

     }
     public void solutionTileLocations() {

    for( int i = 0; i < 9; i++ ) {

      x = PA5Constants.PUZZLE_OFFSET + PA5Constants.BOARD_MARGIN_X +
          PA5Constants.FRAME_SIDE * (i % PA5Constants.TILES_PER_COL);

      y = PA5Constants.BOARD_MARGIN_Y +
          PA5Constants.FRAME_SIDE * (i / PA5Constants.TILES_PER_ROW);

      solutionLocations[i] = new Location(x,y);
    }

  }

  public void createBoard() {

     for (int i = 0; i < 9; i++ ) {
       int randomNum = randomGenerator.nextInt(5);
       solutionTiles[i] = new SolutionTile(COLORS[randomNum],solutionLocations[i],canvas);
     }

     for(int i = 0; i < 9; i++) {
       referenceArr[i] = false;
     }
     int randomNum;
     for(int i = 0; i < 9; i ++) {
       do {
         randomNum = randomGenerator.nextInt(9);
       }
       while(referenceArr[randomNum] == true);

       activeTiles[i] = new ActiveTile(solutionTiles[randomNum].getColor(), activeLocations[i], canvas);
       referenceArr[randomNum] = true;

   }

   for(int i = 0; i < 9; i++) {
     if(activeTiles[i].getColor().equals(solutionTiles[i].getColor())) {
       activeTiles[i].showHighlight(PA5Constants.MATCH_COLOR);
       activeTiles[i].setSwappable(false);
       solutionTiles[i].showHighlight(PA5Constants.MATCH_COLOR);
     }
   }
   winningText = new Text(PA5Constants.WIN_MSG, PA5Constants.PUZZLE_OFFSET, activeLocations[3].getY(), canvas);
   winningText.hide();
  }
}
