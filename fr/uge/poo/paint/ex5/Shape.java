package fr.uge.poo.paint.ex5;

public sealed interface Shape permits Rectangle, Ellipse, Line {

  void draw(Area area, String color);

  double distance(int x, int y);
}
