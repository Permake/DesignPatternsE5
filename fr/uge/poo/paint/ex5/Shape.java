package fr.uge.poo.paint.ex5;

import java.awt.*;

public sealed interface Shape permits Rectangle, Ellipse, Line {

  void draw(Area area);

  double distance(int x, int y);
}
