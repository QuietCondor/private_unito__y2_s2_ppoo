class Point {
    private float _x;
    private float _y;

    public Point(float x, float y) {
        _x = x;
        _y = y;
    }

    public float getX() {
        return _x;
    }

    public float getY() {
        return _y;
    }

    public void transalte(float dx, float dy) {
        this._x += dx;
        this._y += dy;
    }

    public Point transalteStatic(float dx, float dy) {
        Point newPoint = new Point(this._x + dx, this._y + dy);

        return newPoint;
    }

    public double getDistance(Point p2) {
        assert p2 != null : "The second point cannot be NULL!";

        double dx = Math.pow(p2._x - this._x, 2);
        double dy = Math.pow(p2._y - this._y, 2);

        double distance = Math.sqrt(dx + dy);

        return distance;
    }
}

class Triangle {
    private Point _pointA;
    private Point _pointB;
    private Point _pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this._pointA = pointA;
        this._pointB = pointB;
        this._pointC = pointC;
    }

    public Point getPointA() {
        return this._pointA;
    }

    public Point getPointB() {
        return this._pointB;
    }

    public Point getPointC() {
        return this._pointC;
    }

    public void translate(float dx, float dy) {
        _pointA.transalte(dx, dy);
        _pointB.transalte(dx, dy);
        _pointC.transalte(dx, dy);
    }

    public double perimeter() {
        return _pointA.getDistance(_pointB) + _pointB.getDistance(_pointC) + _pointC.getDistance(_pointA);
    }
}

public class MutableTriangleDemo {
    public static void main(String args[]) {
        // Creazione dei punti
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(6, 8);

        // Creazione del triangolo
        Triangle triangle = new Triangle(p1, p2, p3);

        // Test del metodo perimeter
        double perimeter = triangle.perimeter();
        System.out.println("Perimetro del triangolo: " + perimeter);
        // Verifica che il perimetro sia corretto
        System.out.println("Perimetro atteso: 20.0");

        // Test del metodo translate
        triangle.translate(2, 3);
        System.out.println("Nuove coordinate dei punti dopo la traslazione:");
        System.out.println("Punto A: (" + triangle.getPointA().getX() + ", " + triangle.getPointA().getY() + ")");
        System.out.println("Punto B: (" + triangle.getPointB().getX() + ", " + triangle.getPointB().getY() + ")");
        System.out.println("Punto C: (" + triangle.getPointC().getX() + ", " + triangle.getPointC().getY() + ")");

        // Verifica che le coordinate siano corrette dopo la traslazione
        System.out.println("Coordinate attese dopo la traslazione:");
        System.out.println("Punto A: (2.0, 3.0)");
        System.out.println("Punto B: (5.0, 7.0)");
        System.out.println("Punto C: (8.0, 11.0)");

        // Test del metodo getDistance
        double distanceAB = p1.getDistance(p2);
        double distanceBC = p2.getDistance(p3);
        double distanceCA = p3.getDistance(p1);

        System.out.println("Distanza tra A e B: " + distanceAB);
        System.out.println("Distanza tra B e C: " + distanceBC);
        System.out.println("Distanza tra C e A: " + distanceCA);

        // Verifica che le distanze siano corrette
        System.out.println("Distanze attese:");
        System.out.println("Distanza tra A e B: 5.0");
        System.out.println("Distanza tra B e C: 5.0");
        System.out.println("Distanza tra C e A: 10.0");

    }
}
