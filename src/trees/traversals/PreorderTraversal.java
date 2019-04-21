package trees.traversals;

import trees.TreeHelper;
import trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    /*
    * Thought : Inorder traversal is DLR - Data Left Right
    * */
    public static List<Integer> preorderTravesal(TreeNode node) {

        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while(node != null || !stack.isEmpty()) {

            while(node != null) {

                result.add(node.val);

                stack.addFirst(node);

                node = node.left;
            }

            node = stack.pollFirst();

            node = node.right;

        }

        return result;
    }

    public static List<Integer> preorderTravesalRecursive(TreeNode node) {
        List<Integer> result = new LinkedList<>();
        preorderTravesalHelper(node, result);
        return result;
    }

    private static void preorderTravesalHelper(TreeNode node, List<Integer> result) {

        if(node != null) {

            result.add(node.val);

            preorderTravesalHelper(node.left, result);
            preorderTravesalHelper(node.right, result);
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeHelper.sortedArrayToBST(arr);

        TreeHelper.print("The input tree" , root);

        List<Integer> preorderList  = preorderTravesal(root);

        System.out.println("Preorder traversal of tree :\n" + preorderList);

        preorderList  = preorderTravesalRecursive(root);

        System.out.println("Preorder traversal of tree :\n" + preorderList);
    }
}
