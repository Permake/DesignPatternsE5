package fr.uge.poo.paint.ex7;

public record ShapeBound(int width, int height) {

  public ShapeBound merge(ShapeBound sb) {
    return new ShapeBound(Math.max(width, sb.width()), Math.max(height, sb.height));
  }

}
