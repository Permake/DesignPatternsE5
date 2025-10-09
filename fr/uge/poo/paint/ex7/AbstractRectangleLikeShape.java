package fr.uge.poo.paint.ex7;

import java.awt.*;

public class AbstractRectangleLikeShape {
  final int x;
  final int y;
  final int width;
  final int height;

  public AbstractRectangleLikeShape(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  private Point center() {
    return new Point(x + width / 2, y + height / 2);
  }

  public double distance(int x, int y) {
    return Point.distance(x, y, center().x, center().y);
  }

  public ShapeBound getBound() {
    return new ShapeBound(x + width, y + height);
  }
}
