package DailyChallenges;

import Structures.TreeNode;

public class Diameter_BinaryTree {

    static int max = 0;

    public static void main(String[] args) {

    }

    public static int diameterOfBinaryTree(TreeNode root) {


        if (root == null) return 0;

        return Math.max(findMax(root.left, 1) + findMax(root.right, 1), max);


    }

    public static int findMax(TreeNode node, int height) {

        if (node == null) {
            return height - 1;
        }

        int leftHeight = findMax(node.left, height + 1) - height;
        int rightHeight = findMax(node.right, height + 1) - height;

        if (leftHeight + rightHeight > max) {
            max = leftHeight + rightHeight;
        }

        return height + Math.max(leftHeight, rightHeight);

    }

}
