package fr.uge.poo.paint.ex4;

import java.awt.*;

public final class Rectangle extends AbstractRectangleLikeShape implements Shape {
  public Rectangle(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Graphics2D graphics) {
    graphics.drawRect(x, y, width, height);
  }
}
