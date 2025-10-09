package fr.uge.poo.paint.ex3;

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
  private static List<Shape> shapes;

  public static List<Shape> readLines(String file_name) {
    var shapeList = new ArrayList<Shape>();
    Path path = Paths.get(file_name);
    try(Stream<String> lines = Files.lines(path)) {
      lines.forEach(line -> {
        String[] tokens = line.split(" ");
        Shape shape;
        switch (tokens[0]) {
          case "line":
            shape = new Line(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
            shapeList.add(shape);
            break;
          case "rectangle":
            shape = new Rectangle(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
            shapeList.add(shape);
            break;
          case "ellipse":
            shape = new Ellipse(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
            shapeList.add(shape);
            break;
        }
      });
    } catch (IOException e) {
      throw new RuntimeException();
    }
    return shapeList;
  }

  public void drawShapes(Graphics2D graphics){
    graphics.setColor(Color.BLACK);
    for (var shape : shapes) {
      shape.draw(graphics);
    }
  }


  public static void main(String[] args){
    var paint = new Paint();
    shapes = readLines(args[0]);
    var area = new SimpleGraphics("area", 800, 600);
    area.clear(Color.WHITE);
    area.render(paint::drawShapes);
  }
}
