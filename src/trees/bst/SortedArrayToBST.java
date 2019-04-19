package trees.bst;

import trees.TreeHelper;
import trees.TreeNode;

public class SortedArrayToBST {

    /*
    * Thought : Same as binary search pass 0 and (len - 1)
    * */

    public static TreeNode sortedArrayToBST(int[] arr) {

        int left  = 0, right = (arr.length - 1);

        return treefy(arr, left, right);
    }

    private static TreeNode treefy(int[] arr, int left, int right) {

        // if left > right
        if(left > right) return null;

        int mid  = left + ((right - left ) / 2);

        TreeNode node = new TreeNode(arr[mid]);

        // call for left and right nodes with array proper array ranges
        node.left = treefy(arr, left, mid - 1);
        node.right = treefy(arr, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {

        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = sortedArrayToBST(arr);

        TreeHelper.print("The tree from sorted array " + arr , root);
    }
}
