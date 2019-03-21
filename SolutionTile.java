import Acme.*;
import objectdraw.*;
import java.awt.*;
public class SolutionTile implements Colorable, Highlightable {
  private FilledRect solutionTile;
  private FilledRect border;

  public SolutionTile(Color color, Location x, DrawingCanvas canvas) {
    solutionTile = new FilledRect(x, PA5Constants.TILE_SIDE, PA5Constants.TILE_SIDE, canvas);
    x.translate(-5,-5);
    border = new FilledRect(x,PA5Constants.FRAME_SIDE, PA5Constants.FRAME_SIDE, canvas);
    border.setColor(Color.BLACK);
      border.sendBackward();
    solutionTile.setColor(color);


  }

  public Color getColor() {
    return solutionTile.getColor();
  }
  public void setColor(Color color){
    solutionTile.setColor(color);
  }
  public void showHighlight(Color color){
    border.setColor(color);
  }
  public void hideHighlight() {
    border.setColor(PA5Constants.FRAME_COLOR);
  }
  public boolean isHighlighted() {
    return border.getColor().equals(PA5Constants.MATCH_COLOR);
  }

}
