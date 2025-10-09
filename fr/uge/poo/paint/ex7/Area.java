package fr.uge.poo.paint.ex7;

public interface Area {
  enum ColorArea {
    BLACK, ORANGE, WHITE, RED, BLUE, GREEN
  }

  @FunctionalInterface
  interface MouseClickCallback {
    void onMouseEvent(int x, int y);
  }

  void clear(ColorArea color);

  void waitForMouseEvents(MouseClickCallback mouseCallback);

  void render();

  void drawRect(int x, int y, int width, int height, ColorArea color);

  void drawOval(int x, int y, int width, int height, ColorArea color);

  void drawLine(int x1, int y1, int x2, int y2, ColorArea color);
}
