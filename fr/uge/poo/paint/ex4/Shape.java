package fr.uge.poo.paint.ex4;

import java.awt.*;

public sealed interface Shape permits Rectangle, Ellipse, Line {

  void draw(Graphics2D graphics);

  double distance(int x, int y);
}
