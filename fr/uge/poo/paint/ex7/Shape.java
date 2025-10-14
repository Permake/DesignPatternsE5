package fr.uge.poo.paint.ex7;

public sealed interface Shape permits Rectangle, Ellipse, Line {

  void draw(Area area, Area.ColorArea color);

  double distance(int x, int y);

  ShapeBound getBound();
}
