public class Art {

    // Takes a rectangle and "splits" it into two polygons horizontally;
    // the place where the split occurs is randomly determined but follows a
    // normal distribution centered around the middle with a standard deviation
    // of WONKINESS, and the two polygons are separted by MARGIN
    private static void hSplit(double x0, double x1, double y0, double y1) {
        double MARGIN = 0.02;
        double LINE_WIDTH = StdRandom.uniform(0.002, 0.007);
        double WONKINESS = 0.1;
        x0 += MARGIN;
        x1 -= MARGIN;
        y0 += MARGIN;
        y1 -= MARGIN;

        double topLeft = StdRandom.gaussian((y0 + y1) / 2, WONKINESS),
                botLeft = topLeft - MARGIN;
        double topRight = StdRandom.gaussian((y0 + y1) / 2, WONKINESS),
                botRight = topRight - MARGIN;

        double[] xCoords = { x0, x0, x1, x1 };
        double[] yTopPoly = { topLeft, y1, y1, topRight };
        double[] yBotPoly = { y0, botLeft, botRight, y0 };

        StdDraw.setPenRadius(LINE_WIDTH);
        StdDraw.polygon(xCoords, yTopPoly);
        StdDraw.polygon(xCoords, yBotPoly);

    }

    // Takes a rectangle and "splits" it into two polygons vertically;
    // the place where the split occurs is randomly determined but follows a
    // normal distribution centered around the middle with a standard deviation
    // of WONKINESS, and the two polygons are separted by MARGIN
    private static void vSplit(double x0, double x1, double y0, double y1) {
        double MARGIN = 0.02;
        double LINE_WIDTH = StdRandom.uniform(0.002, 0.007);
        double WONKINESS = 0.1;
        x0 += MARGIN;
        x1 -= MARGIN;
        y0 += MARGIN;
        y1 -= MARGIN;

        double leftTop = StdRandom.gaussian((x0 + x1) / 2, WONKINESS),
                rightTop = leftTop + MARGIN;
        double leftBot = StdRandom.gaussian((x0 + x1) / 2, WONKINESS),
                rightBot = leftBot + MARGIN;

        double[] xLeftPoly = { x0, x0, leftTop, leftBot };
        double[] xRightPoly = { rightBot, rightTop, x1, x1 };
        double[] yCoords = { y0, y1, y1, y0 };

        StdDraw.setPenRadius(LINE_WIDTH);
        StdDraw.polygon(xLeftPoly, yCoords);
        StdDraw.polygon(xRightPoly, yCoords);
    }

    // Draw n-levels of De Stijl-inspired "split" rectangles, randomly varying
    // the direction of the split (horizontal or vertical) and scaling down to
    // 50-90% of the previous level each time
    private static void deStilj(int n,
                                double x0, double x1, double y0, double y1) {
        if (n == 0) return;
        boolean cutHorizontal = StdRandom.bernoulli(0.5);
        double scale = StdRandom.uniform(0.5, 0.9);

        if (cutHorizontal) hSplit(x0, x1, y0, y1);
        else vSplit(x0, x1, y0, y1);

        if (n % 2 == 0) StdDraw.setPenColor(StdDraw.RED);
        else StdDraw.setPenColor(StdDraw.BLACK);

        deStilj(n - 1, x0 * scale, x1 * scale,
                y0 * scale, y1 * scale);
    }

    // Takes an integer command-line argument n and draws n-numbers of
    // De Stijl-inspired rectangles
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        // Set scale to fully display bottom-left corner
        StdDraw.setXscale(-0.15, 1.1);
        StdDraw.setYscale(-0.15, 1.1);

        // Set coordinates of first de Stijl rectangle
        deStilj(n, 0, 1, 0, 1);
        
    }
}
