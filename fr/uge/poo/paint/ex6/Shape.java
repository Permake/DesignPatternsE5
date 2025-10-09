package fr.uge.poo.paint.ex6;

public sealed interface Shape permits Rectangle, Ellipse, Line {

  void draw(Area area);

  double distance(int x, int y);
}
