package fr.uge.poo.paint.ex5;

@FunctionalInterface
interface MouseClickCallback {
  void onMouseEvent(int x, int y);
}

public interface Area {
  void clear(String color);

  void waitForMouseEvents(MouseClickCallback mouseCallback);

  // void draw(List<Shape> shapes);

  void drawRect(int x, int y, int width, int height, String color);

  void drawOval(int x, int y, int width, int height, String color);

  void drawLine(int x1, int y1, int x2, int y2, String color);
}
