package trees.traversals;

import trees.TreeHelper;
import trees.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal_Morris {

    /*
    * Morris Inorder Traversal : This is an iterative solution with no extra space.
    *
    * It builds a right skewed tree out of the input tree and then traverses it.

    // The parent node will appear after the left node's right node
    // At each node :
    // if that node has a left child, find the right most child of left child and connect it to current node.
    // otherwise move to the right child
    * */

    public static List<Integer> morrisInorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        TreeNode current = root;

        while(current != null) {

            if(current.left == null) {

                // add current node
                result.add(current.val);

                // no left so set current to right
                current = current.right;

            } else {

                // if there is a left child find the right most child until there are no more right children or
                // right child is already attached to current
                TreeNode newParentOfCurrent = current.left;
                while(newParentOfCurrent.right != null && newParentOfCurrent.right != current) {

                    newParentOfCurrent = newParentOfCurrent.right;
                }

                // if it is not attached to current attach and explore the left
                if(newParentOfCurrent.right == null) {

                    newParentOfCurrent.right = current;

                    current = current.left;

                } else {

                    // detach the connection, visit the current node
                    newParentOfCurrent.right = null;

                    // add current node
                    result.add(current.val);

                    // entire left tree and current(parent) has been visited at this point, visit right tree
                    current = current.right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeHelper.sortedArrayToBST(arr);

        TreeHelper.print("The input tree" , root);

        List<Integer> inorderList  = morrisInorderTraversal(root);

        System.out.println("Inorder traversal of tree :\n" + inorderList);

    }
}
