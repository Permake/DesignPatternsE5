package fr.uge.poo.paint.ex5;

import java.util.List;

public class Paint {
  private final List<Shape> shapes;
  private Shape closestShape;

  public Paint(List<Shape> shapes) {
    this.shapes = shapes;
  }

  public void drawShapes(Area graphics) {
    for (var shape : shapes) {
      var color = "Black";
      if (shape.equals(closestShape)) {
        color = "Orange";
      }
      shape.draw(graphics, color);
    }
  }

  void callback(Area area, int x, int y) {
    findClosestShape(x, y);
    area.clear("White");
    drawShapes(area);
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