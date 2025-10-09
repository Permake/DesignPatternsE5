package fr.uge.poo.paint.ex5;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.Objects;

public final class SimpleArea implements Area {
  private final SimpleGraphics area;

  public SimpleArea(String name, int width, int height) {
    area = new SimpleGraphics(name, width, height);
  }

  @Override
  public void clear(String color) {
    area.clear(getColorValue(color));
  }

  @Override
  public void waitForMouseEvents(MouseClickCallback mouseCallback) {
    Objects.requireNonNull(mouseCallback);
    area.waitForMouseEvents(mouseCallback::onMouseEvent);
  }

  // @Override
  // public void draw(List<Shape> shapes) {
  // shapes.forEach(s -> s.draw(this));
  // }

  private Color getColorValue(String color) {
    return switch (color.toLowerCase()) {
      case "black" -> Color.BLACK;
      case "blue" -> Color.BLUE;
      case "green" -> Color.GREEN;
      case "orange" -> Color.ORANGE;
      case "red" -> Color.RED;
      case "white" -> Color.WHITE;
      default -> throw new IllegalArgumentException("This color is not handled: " + color);
    };
  }

  @Override
  public void drawRect(int x, int y, int width, int height, String color) {
    area.render(g -> {
      g.setColor(getColorValue(color));
      g.drawRect(x, y, width, height);
    });
  }

  @Override
  public void drawOval(int x, int y, int width, int height, String color) {
    area.render(g -> {
      g.setColor(getColorValue(color));
      g.drawOval(x, y, width, height);
    });
  }

  @Override
  public void drawLine(int x1, int y1, int x2, int y2, String color) {
    area.render(g -> {
      g.setColor(getColorValue(color));
      g.drawLine(x1, y1, x2, y2);
    });
  }
}
