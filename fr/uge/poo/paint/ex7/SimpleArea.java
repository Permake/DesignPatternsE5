package fr.uge.poo.paint.ex7;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;

public final class SimpleArea implements Area {
  private final SimpleGraphics area;
  private final ArrayList<Consumer<Graphics2D>> drawingActions = new ArrayList<>();

  public SimpleArea(String name, int width, int height) {
    area = new SimpleGraphics(name, width, height);
  }

  @Override
  public void clear(ColorArea color) {
    area.clear(getColorValue(color));
  }

  @Override
  public void waitForMouseEvents(MouseClickCallback mouseCallback) {
    Objects.requireNonNull(mouseCallback);
    area.waitForMouseEvents(mouseCallback::onMouseEvent);
  }

  @Override
  public void render() {
    var actionsToDo = List.copyOf(drawingActions);
    drawingActions.clear();
    area.render(g -> actionsToDo.forEach(action -> action.accept(g)));
  }

  private Color getColorValue(ColorArea color) {
    return switch (color) {
      case BLACK -> Color.BLACK;
      case BLUE -> Color.BLUE;
      case GREEN -> Color.GREEN;
      case ORANGE -> Color.ORANGE;
      case RED -> Color.RED;
      case WHITE -> Color.WHITE;
    };
  }

  @Override
  public void drawRect(int x, int y, int width, int height, ColorArea color) {
    drawingActions.add(g -> {
      g.setColor(getColorValue(color));
      g.drawRect(x, y, width, height);
    });
  }

  @Override
  public void drawOval(int x, int y, int width, int height, ColorArea color) {
    drawingActions.add(g -> {
      g.setColor(getColorValue(color));
      g.drawOval(x, y, width, height);
    });
  }

  @Override
  public void drawLine(int x1, int y1, int x2, int y2, ColorArea color) {
    drawingActions.add(g -> {
      g.setColor(getColorValue(color));
      g.drawLine(x1, y1, x2, y2);
    });
  }
}
