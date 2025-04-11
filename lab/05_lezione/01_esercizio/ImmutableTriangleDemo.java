class ImmutablePoint {
  // coordinate cartesiane
  private double x;
  private double y;

  public ImmutablePoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  // ritorna un nuovo punto traslato di (+dx, +dy) sul piano
  public ImmutablePoint translate(double dx, double dy) {
    return new ImmutablePoint(x + dx, y + dy);
  }

  // distanza Euclidea tra questo punto e il punto p
  public double distance(ImmutablePoint p) {
    assert p != null;
    return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
  }

  public String toString() {
    return String.format("(%s,%s)", this.x, this.y);
  }
}

class ImmutableTriangle {
  private ImmutablePoint a;
  private ImmutablePoint b;
  private ImmutablePoint c;

  public ImmutableTriangle(ImmutablePoint a, ImmutablePoint b, ImmutablePoint c) {
    assert (a != null) && (b != null) && (c != null) : "at least one point is null";
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public ImmutablePoint getA() {
    return a;
  }

  public ImmutablePoint getB() {
    return b;
  }

  public ImmutablePoint getC() {
    return c;
  }

  public ImmutableTriangle translate(double dx, double dy) {
    ImmutableTriangle translatedTriangle = new ImmutableTriangle(
        this.a.translate(dx, dy),
        this.b.translate(dx, dy),
        this.c.translate(dx, dy));

    return translatedTriangle;
  }

  public double perimeter() {
    return (a.distance(b) + b.distance(c) + c.distance(a));
  }
}

public class ImmutableTriangleDemo {
  public static void main(String[] args) {
    ImmutablePoint p1 = new ImmutablePoint(0, 0);
    ImmutablePoint p2 = new ImmutablePoint(3, 0);
    ImmutablePoint p3 = new ImmutablePoint(0, 4);

    assert p1 != null : "ImmutablePoint p1 cannot be null!";
    assert p2 != null : "ImmutablePoint p2 cannot be null!";
    assert p3 != null : "ImmutablePoint p3 cannot be null!";

    // Create triangle
    ImmutableTriangle triangle = new ImmutableTriangle(p1, p2, p3);
    assert triangle != null : "ImmutableTriangle cannot be null!";

    // Test perimeter
    double expectedPerimeter = 12.0; // 3 + 4 + 5
    double actualPerimeter = triangle.perimeter();
    System.out.println("Expected Perimeter: " + expectedPerimeter);
    System.out.println("Actual Perimeter: " + actualPerimeter);
    System.out.println("Perimeter Test Passed: " + (expectedPerimeter == actualPerimeter));

    // Test translate
    ImmutableTriangle translatedTriangle = triangle.translate(1, 1);
    System.out.println(
        String.format(
            "ORIGINAL triangle data: [A: %s, B: %s, C: %s]", triangle.getA(), triangle.getB(), triangle.getC()));

    System.out.println(
        String.format(
            "TRANSLATED triangle data: [A: %s, B: %s, C: %s]", translatedTriangle.getA(), translatedTriangle.getB(),
            translatedTriangle.getC()));

    System.out.println("Translation Test Passed: " +
        (translatedTriangle.getA().getX() == triangle.getA().getX() + 1 &&
            translatedTriangle.getA().getY() == triangle.getA().getY() + 1 &&
            translatedTriangle.getB().getX() == triangle.getB().getX() + 1 &&
            translatedTriangle.getB().getY() == triangle.getB().getY() + 1 &&
            translatedTriangle.getC().getX() == triangle.getC().getX() + 1 &&
            translatedTriangle.getC().getY() == triangle.getC().getY() + 1));

    // Ensure immutability
    System.out.println("Original Triangle Unchanged: " +
        (triangle.getA().getX() == p1.getX() && triangle.getA().getY() == p1.getY() &&
            triangle.getB().getX() == p2.getX() && triangle.getB().getY() == p2.getY() &&
            triangle.getC().getX() == p3.getX() && triangle.getC().getY() == p3.getY()));
  }
}