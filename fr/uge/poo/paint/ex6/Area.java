package fr.uge.poo.paint.ex6;

import java.util.function.BiConsumer;

public sealed interface Area permits SimpleArea, CoolArea {
  void clear(String color);
  void waitForMouseEvents(BiConsumer<Integer, Integer> mouseCallback);
  void draw(Paint paint);
  void setColor(String color);
  void drawRect(int x, int y, int width, int height);
  void drawOval(int x, int y, int width, int height);
  void drawLine(int x1, int y1, int x2, int y2);
}
