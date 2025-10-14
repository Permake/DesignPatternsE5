package fr.uge.poo.paint.ex7;

import java.util.List;

public class Paint {
  private final List<Shape> shapes;
  private Shape closestShape;

  public Paint(List<Shape> shapes) {
    this.shapes = shapes;
  }

  public ShapeBound getBound() {
    return shapes.stream().map(Shape::getBound).reduce(ShapeBound::merge).get();
  }

  public void drawShapes(Area graphics) {
    for (var shape : shapes) {
      var color = Area.ColorArea.BLACK;
      if (shape.equals(closestShape)) {
        color = Area.ColorArea.ORANGE;
      }
      shape.draw(graphics, color);
    }
    graphics.render();
  }

  void callback(Area area, int x, int y) {
    findClosestShape(x, y);
    area.clear(Area.ColorArea.WHITE);
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