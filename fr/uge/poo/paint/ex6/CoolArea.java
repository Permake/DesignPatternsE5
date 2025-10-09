package fr.uge.poo.paint.ex6;

import com.evilcorp.coolgraphics.CoolGraphics;

import java.util.Objects;
import java.util.function.BiConsumer;

public final class CoolArea implements Area {

  private final CoolGraphics area;
  private CoolGraphics.ColorPlus colorPlus = CoolGraphics.ColorPlus.BLACK;

  public CoolArea(String name, int width, int height){
    area = new CoolGraphics(name, width, height);
  }

  @Override
  public void clear(String color) {
    area.repaint(getColorValue(color));
  }

  @Override
  public void waitForMouseEvents(BiConsumer<Integer, Integer> mouseCallback){
    Objects.requireNonNull(mouseCallback);
    area.waitForMouseEvents(mouseCallback::accept);
  }

  @Override
  public void draw(Paint paint) {
    paint.drawShapes(this);
  }

  private CoolGraphics.ColorPlus getColorValue(String color) {
    return switch (color.toLowerCase()) {
      case "black" -> CoolGraphics.ColorPlus.BLACK;
      case "blue" -> CoolGraphics.ColorPlus.BLUE;
      case "green" -> CoolGraphics.ColorPlus.GREEN;
      case "orange" -> CoolGraphics.ColorPlus.ORANGE;
      case "red" -> CoolGraphics.ColorPlus.RED;
      case "white" -> CoolGraphics.ColorPlus.WHITE;
      default -> throw new IllegalArgumentException("This color is not handled: " + color);
    };
  }

  @Override
  public void setColor(String color) {
    colorPlus = getColorValue(color);
  }

  @Override
  public void drawRect(int x, int y, int width, int height) {
    area.drawLine(x, y, x, y+height, colorPlus);
    area.drawLine(x, y, x+width, y, colorPlus);
    area.drawLine(x, y+height, x+width, y+height, colorPlus);
    area.drawLine(x+width, y, x+width, y+height, colorPlus);
  }

  @Override
  public void drawOval(int x, int y, int width, int height) {
    area.drawEllipse(x, y, width, height, colorPlus);
  }

  @Override
  public void drawLine(int x1, int y1, int x2, int y2) {
    area.drawLine(x1, y1, x2, y2, colorPlus);
  }
}
