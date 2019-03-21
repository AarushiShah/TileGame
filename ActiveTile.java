import Acme.*;
import objectdraw.*;
import java.awt.*;
public class ActiveTile implements Colorable, Highlightable, Swappable, Selectable {
  private FilledRect activeTile;
  private FilledRect border;
  private boolean swappable;


  public ActiveTile(Color color, Location x, DrawingCanvas canvas) {
    activeTile = new FilledRect(x,PA5Constants.TILE_SIDE, PA5Constants.TILE_SIDE, canvas);
    x.translate(-5,-5);
    border = new FilledRect(x,PA5Constants.FRAME_SIDE, PA5Constants.FRAME_SIDE, canvas);
    border.setColor(Color.BLACK);
    border.sendBackward();
    activeTile.setColor(color);
    swappable = true;

  }

  public Color getColor() {
    return activeTile.getColor();
  }
  public void setColor( Color color ) {
    activeTile.setColor(color);
  }
  public void showHighlight(Color color){
    border.setColor(color);
  }
  public void hideHighlight() {
    border.setColor(PA5Constants.FRAME_COLOR);
  }
  public boolean isHighlighted() {
    return border.getColor().equals(PA5Constants.MATCH_COLOR) ||
           border.getColor().equals(Color.GREEN);
  }
  public boolean contains(Location point) {
    return activeTile.contains(point);
  }
  public void swap(Colorable colorable) {
    Color x = colorable.getColor();
    colorable.setColor(activeTile.getColor());
    activeTile.setColor(x);
  }
  public boolean isSwappable() {
    return swappable;
  }
  public void setSwappable(boolean swappable) {
    this.swappable = swappable;
  }

}
