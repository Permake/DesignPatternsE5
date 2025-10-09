package fr.uge.poo.paint.ex6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class MainFileReader {

  public static List<Shape> readLines(String file_name) {
    var shapeList = new ArrayList<Shape>();
    Path path = Paths.get(file_name);
    try (Stream<String> lines = Files.lines(path)) {
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

  public static void main(String[] args) {
    var paint = new Paint(readLines(args[0]));
    Area area;
    if (args.length == 2 && Objects.equals(args[1], "--legacy")) {
      area = new SimpleArea("area", 800, 600);
    } else {
      area = new CoolArea("area", 800, 600);
    }
    area.clear("White");
    paint.drawShapes(area);
    area.waitForMouseEvents((x, y) -> paint.callback(area, x, y));
  }
}