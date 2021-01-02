public class Transform2D {

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] copy = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= alpha;
            y[i] *= alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] += dx;
            y[i] += dy;
        }
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        for (int i = 0; i < x.length; i++) {
            double xtemp = x[i]; // original val of x[i] for y[i] calculation
            x[i] = x[i] * Math.cos(Math.toRadians(theta)) -
                    y[i] * Math.sin(Math.toRadians(theta));
            y[i] = y[i] * Math.cos(Math.toRadians(theta)) +
                    xtemp * Math.sin(Math.toRadians(theta));
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {

        // Draw original polygon in red
        StdDraw.setScale(-5.0, +5.0);
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.polygon(x, y);

        // Create copy of x and y arrays and print coordinate pairs
        double[] xCopy = copy(x);
        double[] yCopy = copy(y);

        for (int i = 0; i < xCopy.length; i++) {
            StdOut.println("(" + xCopy[i] + ", " + yCopy[i] + ")");
        }

        // Scales polygon by the factor 2
        double alpha = 2.0;

        scale(x, y, alpha);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);

        // Translates polygon by (2, 1)
        double dx = 2.0, dy = 1.0;
        for (int i = 0; i < x.length; i++) { // Reset original coordinates
            x[i] = xCopy[i];
            y[i] = yCopy[i];
        }
        translate(x, y, dx, dy);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);

        // Rotates polygon 45 degrees
        double theta = 45.0;
        for (int i = 0; i < x.length; i++) { // Reset original coordinates
            x[i] = xCopy[i];
            y[i] = yCopy[i];
        }
        rotate(x, y, theta);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.polygon(x, y);

    }

}
