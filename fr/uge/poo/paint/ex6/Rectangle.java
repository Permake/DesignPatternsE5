package fr.uge.poo.paint.ex6;

public final class Rectangle extends AbstractRectangleLikeShape implements Shape {
  public Rectangle(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Area area) {
    area.drawRect(x, y, width, height);
  }
}
