package fr.uge.poo.paint.ex2;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Paint {
  private static List<Line> line_shapes;

  public static List<Line> readLines(Path path) throws RuntimeException {
    var lineList = new ArrayList<Line>();
    try(Stream<String> lines = Files.lines(path)) {
      lines.forEach(line -> {
      String[] tokens = line.split(" ");
      var line_shape = new Line(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
              Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
        lineList.add(line_shape);
      });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return lineList;
  }

  public void drawShapes(Graphics2D graphics){
    graphics.setColor(Color.BLACK);
    for (var line_shape : line_shapes) {
        line_shape.draw(graphics);
        break;
    }
  }


  public static void main(String[] args){
      var paint = new Paint();
      line_shapes = readLines(Paths.get(args[0]));
      var area = new SimpleGraphics("area", 800, 600);
      area.clear(Color.WHITE);
      area.render(paint::drawShapes);
  }
}
