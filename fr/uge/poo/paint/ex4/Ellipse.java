package fr.uge.poo.paint.ex4;

import java.awt.*;

public final class Ellipse extends AbstractRectangleLikeShape implements Shape {
  public Ellipse(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Graphics2D graphics) {
    graphics.drawOval(x, y, width, height);
  }

}
