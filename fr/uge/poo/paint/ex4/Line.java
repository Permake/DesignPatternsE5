package fr.uge.poo.paint.ex4;

import java.awt.*;

public record Line(int x1, int y1, int x2, int y2) implements Shape {

  @Override
  public void draw(Graphics2D graphics) {
    graphics.drawLine(x1, y1, x2, y2);
  }

  private Point center() {
    return new Point((x1 + x2)/2, (y1 + y2)/2);
  }

  @Override
  public double distance(int x, int y) {
    return Point.distance(x, y, center().x, center().y);
  }
}
