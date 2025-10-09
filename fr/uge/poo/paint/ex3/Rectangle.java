package fr.uge.poo.paint.ex3;

import java.awt.*;

public record Rectangle(int x1, int y1, int width, int height) implements Shape {
  @Override
  public void draw(Graphics2D graphics) {
    graphics.drawRect(x1, y1, width, height);
  }
}
