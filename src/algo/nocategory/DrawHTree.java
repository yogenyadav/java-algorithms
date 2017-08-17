package algo.nocategory;

/**
 * An H-tree is a geometric shape that consists of a repeating pattern resembles the letter “H”.
 *
 * It can be constructed by starting with a line segment of arbitrary length, drawing two segments of the
 * same length at right angles to the first through its endpoints, and continuing in the same vein,
 * reducing (dividing) the length of the line segments drawn at each stage by √2.
 *
 */
public class DrawHTree {

    public static void drawHTree(double x, double y, double length, double depth, double maxDepth) {
        if (depth < 0) {
            return;
        }
        if (depth >= maxDepth) {
            return;
        }
        drawLine(x - length / 2, y, x + length / 2, y); // perpendicular
        drawLine(x - length / 2, y - length / 2, x - length / 2, y + length / 2); // first horizontal
        drawLine(x + length / 2, y - length / 2, x + length / 2, y + length / 2); // second horizontal

        drawHTree(x - length / 2, y + length / 2, length / Math.sqrt(2), depth + 1, maxDepth); // left top
        drawHTree(x - length / 2, y - length / 2, length / Math.sqrt(2), depth + 1, maxDepth); // left bottom
        drawHTree(x + length / 2, y + length / 2, length / Math.sqrt(2), depth + 1, maxDepth); // right top
        drawHTree(x + length / 2, y - length / 2, length / Math.sqrt(2), depth + 1, maxDepth); // right bottom
    }

    public static void drawLine(double x1, double y1, double x2, double y2) {
        System.out.println("(" + x1 + ", " + y1 + ")" + " " + "(" + x2 + ", " + y2 + ")");
    }

    static public void main(String args[]) {
        System.out.println("Pramp practice");
        drawHTree(2, 4, 10, 0, 2);
        System.out.println("Practice makes Perfect!");
    }

}
