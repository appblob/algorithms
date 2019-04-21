package trees.traversals;

import trees.TreeHelper;
import trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {

    /*
    * Thought : Inorder traversal is LDR - Left Data Right
    * */
    public static List<Integer> inorderTravesal(TreeNode node) {

        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();


        while(node != null || !stack.isEmpty()) {

            while(node != null) {
                // store the node and
                stack.addFirst(node);

                node = node.left;
            }

            node = stack.pollFirst();

            result.add(node.val);

            node = node.right;
        }

        return result;
    }

    public static List<Integer> inorderTravesalRecursive(TreeNode node) {
        List<Integer> result = new LinkedList<>();
        inorderTravesalHelper(node, result);
        return result;
    }

    private static void inorderTravesalHelper(TreeNode node, List<Integer> result) {
        if(node != null) {
            inorderTravesalHelper(node.left, result);
            result.add(node.val);
            inorderTravesalHelper(node.right, result);
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeHelper.sortedArrayToBST(arr);

        TreeHelper.print("The input tree" , root);

        List<Integer> inorderList  = inorderTravesal(root);

        System.out.println("Inorder traversal of tree :\n" + inorderList);

        inorderList  = inorderTravesalRecursive(root);

        System.out.println("Inorder traversal of tree :\n" + inorderList);
    }
}
