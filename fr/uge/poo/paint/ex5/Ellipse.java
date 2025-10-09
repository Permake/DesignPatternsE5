package fr.uge.poo.paint.ex5;

public final class Ellipse extends AbstractRectangleLikeShape implements Shape {
  public Ellipse(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Area area, String color) {
    area.drawOval(x, y, width, height, color);
  }
}
