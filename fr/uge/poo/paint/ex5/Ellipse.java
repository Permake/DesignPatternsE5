package fr.uge.poo.paint.ex5;

import java.awt.*;

public final class Ellipse extends AbstractRectangleLikeShape implements Shape {
  public Ellipse(int x, int y, int width, int height) {
    super(x, y, width, height);
  }
  @Override
  public void draw(Area area) {
    area.drawOval(x, y, width, height);
  }
}
