package trees;


import java.util.Deque;
import java.util.LinkedList;

public class InvertTree {

    /*
    * Thought : Use recursion, Preorder traversal
    * Swap the left reference with right.
    * And call on left and right children
    * */
    public static void invertTree(TreeNode node) {

        if(node != null) {
            // swap the left reference with right.
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;

            // call on left and right children
            invertTree(node.left);
            invertTree(node.right);
        }
    }

    /*
    * Thought : using iterative method
    * */
    public static void invertTreeIter(TreeNode node) {

        Deque<TreeNode> q = new LinkedList<>();

        q.offer(node);

        while(!q.isEmpty()) {
            TreeNode current = q.poll();

            // swap the left reference with right.
            TreeNode tempNode = current.left;
            current.left = current.right;
            current.right = tempNode;

            // call on left and right children
            if(current.left != null) invertTree(current.left);
            if(current.right != null) invertTree(current.right);

        }
    }

    public static void main(String[] args) {
        int [] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root1 = TreeHelper.sortedArrayToBST(arr1);
        TreeHelper.print("The input tree 1 : " , root1);

        invertTree(root1);

        TreeHelper.print("The output tree 1 after inversion: " , root1);

        invertTreeIter(root1);

        TreeHelper.print("The output tree 1 after inversion: " , root1);

    }
}
