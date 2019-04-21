package trees.traversals;

import trees.TreeHelper;
import trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelorderTraversal {

    public static List<Integer> levelorderTravesal(TreeNode node) {

        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> q = new LinkedList<>();

        q.offer(node);

        while (!q.isEmpty()) {

            TreeNode current = q.poll();

            result.add(current.val);

            if(current.left != null) q.offer(current.left);
            if(current.right != null) q.offer(current.right);
        }

        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeHelper.sortedArrayToBST(arr);

        TreeHelper.print("The input tree" , root);

        List<Integer> levelorderList  = levelorderTravesal(root);

        System.out.println("Levelorder traversal of tree :\n" + levelorderList);
    }
}
