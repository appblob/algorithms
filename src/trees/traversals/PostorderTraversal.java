package trees.traversals;

import trees.TreeHelper;
import trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {

    /*
     * Thought : Postorder traversal is LRD -  Left Right Data
     * */

    public static List<Integer> postorderTraversalRecursive(TreeNode node) {

        List<Integer> result = new LinkedList<>();

        postorderTraversalHelper(node, result);

        return result;
    }

    private static void postorderTraversalHelper(TreeNode node, List<Integer> result) {
        if(node != null) {

            postorderTraversalHelper(node.left, result);
            postorderTraversalHelper(node.right, result);

            result.add(node.val);
        }
    }

    public static List<Integer> postorderTravesal(TreeNode node) {

        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while(node != null || !stack.isEmpty()) {

            while(node != null) {
                // copy the content of node at 0 because we want to have LRD
                // but we are approaching from behind ie DRL
                result.add(0, node.val);

                stack.addFirst(node);

                node = node.right;
            }

            node = stack.pollFirst();

            node = node.left;
        }

        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeHelper.sortedArrayToBST(arr);

        TreeHelper.print("The input tree" , root);

        List<Integer> postorderList  = postorderTravesal(root);

        System.out.println("Postorder traversal of tree :\n" + postorderList);

        postorderList  = postorderTraversalRecursive(root);

        System.out.println("Postorder traversal of tree :\n" + postorderList);
    }


}
