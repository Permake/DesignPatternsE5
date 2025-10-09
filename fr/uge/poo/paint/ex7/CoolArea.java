package fr.uge.poo.paint.ex7;

import com.evilcorp.coolgraphics.CoolGraphics;

import java.util.ArrayList;
import java.util.Objects;

public final class CoolArea implements Area {

  private final CoolGraphics area;
  private final ArrayList<Runnable> drawingActions = new ArrayList<>();

  public CoolArea(String name, int width, int height) {
    area = new CoolGraphics(name, width, height);
  }

  @Override
  public void clear(ColorArea color) {
    area.repaint(getColorValue(color));
  }

  @Override
  public void waitForMouseEvents(MouseClickCallback mouseCallback) {
    Objects.requireNonNull(mouseCallback);
    area.waitForMouseEvents(mouseCallback::onMouseEvent);
  }

  @Override
  public void render() {
    drawingActions.forEach(Runnable::run);
    drawingActions.clear();
  }

  private CoolGraphics.ColorPlus getColorValue(ColorArea color) {
    return switch (color) {
      case BLACK -> CoolGraphics.ColorPlus.BLACK;
      case BLUE-> CoolGraphics.ColorPlus.BLUE;
      case GREEN -> CoolGraphics.ColorPlus.GREEN;
      case ORANGE -> CoolGraphics.ColorPlus.ORANGE;
      case RED -> CoolGraphics.ColorPlus.RED;
      case WHITE -> CoolGraphics.ColorPlus.WHITE;
    };
  }

  @Override
  public void drawRect(int x, int y, int width, int height, ColorArea color) {
    drawingActions.add(() -> {
      area.drawLine(x, y, x, y + height, getColorValue(color));
      area.drawLine(x, y, x + width, y, getColorValue(color));
      area.drawLine(x, y + height, x + width, y + height, getColorValue(color));
      area.drawLine(x + width, y, x + width, y + height, getColorValue(color));
    });
  }

  @Override
  public void drawOval(int x, int y, int width, int height, ColorArea color) {
    drawingActions.add(() -> area.drawEllipse(x, y, width, height, getColorValue(color)));
  }

  @Override
  public void drawLine(int x1, int y1, int x2, int y2, ColorArea color) {
    drawingActions.add(() -> area.drawLine(x1, y1, x2, y2, getColorValue(color)));
  }
}
