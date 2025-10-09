package fr.uge.poo.paint.ex5;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.Objects;
import java.util.function.BiConsumer;

public final class SimpleArea implements Area{
  private final SimpleGraphics area;
  private Color color = Color.BLACK;
  private Graphics2D graphics;

  public SimpleArea(String name, int width, int height){
    area = new SimpleGraphics(name, width, height);
  }
  @Override
  public void clear(String color) {
    area.clear(getColorValue(color));
  }

  @Override
  public void waitForMouseEvents(BiConsumer<Integer, Integer> mouseCallback) {
    Objects.requireNonNull(mouseCallback);
    area.waitForMouseEvents(mouseCallback::accept);
  }

  @Override
  public void draw(Paint paint) {
    area.render(g -> {
      graphics = g;
      paint.drawShapes(this);
    });
  }

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
  public void setColor(String color) {
    this.color = getColorValue(color);
  }

  @Override
  public void drawRect(int x, int y, int width, int height) {
    graphics.drawRect(x, y ,width, height);
  }

  @Override
  public void drawOval(int x, int y, int width, int height) {
    graphics.drawOval(x, y , width, height);
  }

  @Override
  public void drawLine(int x1, int y1, int x2, int y2) {
    graphics.drawLine(x1, y1, x2, y2);
  }
}
