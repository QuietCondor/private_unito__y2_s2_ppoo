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

public class PointRunner {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        assert p.getX() == 1 : "X argument GET failed";
        assert p.getY() == 2 : "Y argument GET failed";

        Point p2 = p.transalteStatic(1, 2);
        assert p2.getX() == 2 : "X argument GET failed after translate static";
        assert p2.getY() == 4 : "Y argument GET failed after translate static";
        assert p.getX() == 1 : "Original p point X argument GET failed";
        assert p.getY() == 2 : "Original p point Y argument GET failed";

        double distance = p.getDistance(p2);
        // System.out.println("Distance: " + distance);
        assert distance == 2.23606797749979 : "The distance between the two points was wrong!";

        p.transalte(1, 2);
        assert p.getX() == 2 : "X argument GET failed after translate";
        assert p.getY() == 4 : "Y argument GET failed after translate";

        distance = p.getDistance(p2);
        assert distance == 0 : "The distance between the two points was wrong!";
    }
}