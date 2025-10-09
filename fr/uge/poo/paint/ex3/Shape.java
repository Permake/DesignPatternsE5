package fr.uge.poo.paint.ex3;

import java.awt.*;

public sealed interface Shape permits Rectangle, Line, Ellipse {

  void draw(Graphics2D graphics);
}
