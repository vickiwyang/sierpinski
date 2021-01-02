public class Sierpinski {

    //  Height of an equilateral triangle whose sides are of the specified
    //  length.
    public static double height(double length) {
        double height = (length * Math.sqrt(3)) / 2;
        return height;
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        double xLeft = x - (length / 2); // top-left x-coord
        double xRight = x + (length / 2); // top-right x-coord
        // y-coords for top vertices
        double yTop = y + height(length);
        double[] xCoords = { x, xLeft, xRight };
        double[] yCoords = { y, yTop, yTop };

        StdDraw.filledPolygon(xCoords, yCoords);

    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) return;
        // Calculate x- and y-coords for bottom vertices of the 3 recursively
        // called triangles
        double xLeft = x - (length / 2), xTop = x, xRight = x + (length / 2);
        double yLeft = y, yTop = y + height(length), yRight = y;
        filledTriangle(x, y, length);
        sierpinski(n - 1, xTop, yTop, length / 2);
        sierpinski(n - 1, xLeft, yLeft, length / 2);
        sierpinski(n - 1, xRight, yRight, length / 2);
    }

    // Takes an integer command-line argument n; draws the outline of an
    // equilateral triangle (pointed upwards) of length 1; whose bottom-left
    // vertex is (0, 0) and bottom-right vertex is (1, 0); and draws a
    // Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        double[] x = { 0, 0.5, 1 };
        double[] y = { 0, height(1), 0 };

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.polygon(x, y);

        // Call sierpinski();
        // set bottom vertex coords and length of order 1 triangle
        sierpinski(n, 0.5, 0, 0.5);

    }

}
