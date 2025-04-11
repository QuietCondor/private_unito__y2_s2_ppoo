class MutablePoint {
  // coordinate cartesiane
  private double x;
  private double y;

  public MutablePoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  // sposta il punto di (+dx, +dy) sul piano
  public void translate(double dx, double dy) {
    x += dx;
    y += dy;
  }

  // distanza Euclidea tra questo punto e il punto p
  public double distance(MutablePoint p) {
    assert p != null;
    return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
  }
}

public class MutableTriangle {
  private MutablePoint a;
  private MutablePoint b;
  private MutablePoint c;

  public MutableTriangle(MutablePoint a, MutablePoint b, MutablePoint c) {
    assert (a != null) && (b != null) && (c != null) : "at least one point is null";
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public MutablePoint getA() {
    return a;
  }

  public MutablePoint getB() {
    return b;
  }

  public MutablePoint getC() {
    return c;
  }

  public void translate(double dx, double dy) {
    a.translate(dx, dy);
    b.translate(dx, dy);
    c.translate(dx, dy);
  }

  public double perimeter() {
    return (a.distance(b) + b.distance(c) + c.distance(a));
  }
}