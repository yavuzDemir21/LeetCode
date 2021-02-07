package CTCI;

import java.util.HashSet;
import java.util.Random;

class Box {
    int width;
    int height;
    int depth;

    Box(int width, int height, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    boolean compare(Box other) {
        return this.width > other.width && this.depth > other.depth && this.height > other.height;
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}

public class Stack_of_Boxes {
    static int max = 0;

    public static void main(String[] args) {

        Box[] boxes = createBoxes(4);

        findMaxHeightOfStack(boxes);

        System.out.println(max);

    }

    private static Box[] createBoxes(int n) {
        Box[] boxes = new Box[n];
        Random rand = new Random(1);
        for (int i = 0; i < n; i++) {
            int width = rand.nextInt(10);
            int height = rand.nextInt(10);
            int depth = rand.nextInt(10);
            boxes[i] = new Box(width, height, depth);
            System.out.println(boxes[i].toString());
        }
        return boxes;
    }

    private static void findMaxHeightOfStack(Box[] boxes) {

        for (int i = 0; i < boxes.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            findMaxHeightOfStack(boxes, boxes[i], set, boxes[i].height);
        }


    }

    private static void findMaxHeightOfStack(Box[] boxes, Box b, HashSet<Integer> used, int height) {

        max = Math.max(max, height);

        if (used.size() != boxes.length) {
            for (int i = 0; i < boxes.length; i++) {
                if (!used.contains(i)) {
                    if (b.compare(boxes[i])) {
                        HashSet<Integer> set = new HashSet<>(used);
                        set.add(i);
                        findMaxHeightOfStack(boxes, boxes[i], set, height + boxes[i].height);
                    } else {
                        used.add(i);
                    }
                }

            }
        }


    }

}
