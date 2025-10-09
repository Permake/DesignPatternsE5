package fr.uge.poo.paint.ex4;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Paint {
  private final List<Shape> shapes;
  private Shape closestShape;


  public Paint(List<Shape> shapes) {
    this.shapes = shapes;
  }

  public void drawShapes(Graphics2D graphics) {
    for (var shape : shapes) {
      graphics.setColor(Color.BLACK);
      if (shape.equals(closestShape)) {
        graphics.setColor(Color.orange);
      }
      shape.draw(graphics);
    }
  }

  void callback(SimpleGraphics area, int x, int y) {
    findClosestShape(x, y);
    area.clear(Color.WHITE);
    area.render(this::drawShapes);
  }

  private void findClosestShape(int x, int y) {
    var min_distance = Double.MAX_VALUE;
    Shape tmp_closest_shape = null;
    for (var shape : shapes) {
      var distanceToCenter = shape.distance(x, y);
      if (distanceToCenter <= min_distance) {
        min_distance = distanceToCenter;
        tmp_closest_shape = shape;
      }
    }
    if (tmp_closest_shape != null) {
      closestShape = tmp_closest_shape;
    }
  }
}