package DailyChallenges;

import Structures.TreeNode;


public class Construct_BST_Preorder {
    public static void main(String[] args) {

    }

    public static TreeNode bstFromPreorder(int[] preorder) {

        if(preorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);


        for(int i=1; i<preorder.length; i++){

            bst(root, preorder[i]);

        }

        return root;

    }

    public static void bst(TreeNode root, int val){

        TreeNode temp = root;

        while(true){

            if(val < temp.val){
                if(temp.left == null){
                    temp.left = new TreeNode(val);
                    return;
                }
                temp = temp.left;
            }else{
                if(temp.right == null){
                    temp.right = new TreeNode(val);
                    return;
                }
                temp = temp.right;
            }

        }

    }
}
