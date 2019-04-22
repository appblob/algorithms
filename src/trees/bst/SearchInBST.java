package trees.bst;

import trees.TreeHelper;
import trees.TreeNode;

public class SearchInBST {

    /*
    * Leetcode : 700
    *
    * Searching BST is similar to searching a sorted array.
    *
    * At each node :
    * if (node.val == value) return node
    * if (node.val > value), search the value in the left subtree
    * if (node.val < value), search the value in the right subtree
    *
    * */
    public static TreeNode search(TreeNode node, int value) {
        if(node == null) return node;

        TreeNode iter = node;
        while(iter != null) {

            if (iter.val == value) return node;

            else if(iter.val > value) return search(iter.left, value);
            else return search(iter.right, value);
        }

        return null;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeHelper.sortedArrayToBST(arr);
        TreeHelper.print("The input tree" , root);

        for (int i = 0; i < arr.length; i++) {
            TreeNode node = search(root, arr[i]);
            TreeHelper.print("The tree with value " + arr[i] , node);
        }

    }
}
