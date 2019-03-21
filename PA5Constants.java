/*
 * Filename: PA5Constants.java
 * Author:   TODO
 * UserId:   TODO
 * Date:     10/25/18
 * Sources of help: None
 */

import java.awt.*;

/**
 * Contains constants for use in PA5.
 */
public abstract class PA5Constants {

  // Size of the canvas
  public static final int CANVAS_WIDTH = 735;
  public static final int CANVAS_HEIGHT = 380;

  // Used for placing the tiles
  public static final int BOARD_MARGIN_X = 25;
  public static final int BOARD_MARGIN_Y = 40;
  public static final int PUZZLE_OFFSET = 355;

  // Length of the side of the tile (inside the frame)
  public static final int TILE_SIDE = 90;
  // Length of the side of a tile frame/highlight/border
  public static final int FRAME_SIDE = 100;

  // Amount by which the tile is inset within its frame
public static final int TILE_OFFSET = 5;

// Number of tiles
public static final int MAX_NUM_OF_TILE = 9;
public static final int TILES_PER_COL = 3;
public static final int TILES_PER_ROW = 3;


// Default highlight color
public static final Color FRAME_COLOR = Color.BLACK;
// Color of the selected tile highlight
public static final Color SELECTED_COLOR = Color.GREEN;
// Highlight color of matched tiles
public static final Color MATCH_COLOR = Color.MAGENTA;

// Tile colors
public static final Color TILE_COLOR_1 = new Color(255, 179, 186);
public static final Color TILE_COLOR_2 = new Color(255, 223, 186);
public static final Color TILE_COLOR_3 = new Color(255, 255, 186);
public static final Color TILE_COLOR_4 = new Color(186, 255, 201);
public static final Color TILE_COLOR_5 = new Color(186, 225, 255);


// Maximum number of tiles that can be selected.
public static final int MAX_SELECTED = 2;

  // Length of a mouse click (in milliseconds) required to swap tiles.
  public static final int SWAP_THRESHOLD = 500;


  // Usage message for handling bad user input.
  public static final String USAGE_MSG =
      "\nUsage: TileGame seed\n\tseed: must be a valid integer\n";

  // Constants for displaying the win message
  public static final String WIN_MSG = "YOU WON!";
  public static final Color WIN_COLOR = Color.GREEN;
  public static final int FONT_SIZE = 55;
}
