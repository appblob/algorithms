package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottomUp {

    public static List<List<Integer>> levelOrderBottomUp(TreeNode root) {

        // Use LinkedList not ArrayList, because inserting at 0 is constant time.
        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {

            int levelSize = q.size();
            List<Integer> levelItems = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {

                TreeNode current = q.poll();
                levelItems.add(current.val);

                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);

            }

            result.add(0, levelItems);
        }

        return result;

    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeHelper.sortedArrayToBST(arr);

        TreeHelper.print("The input tree" , root);

        List<List<Integer>> result = levelOrderBottomUp(root);

        System.out.println("Level order bottom-up :\n" + result);
    }
}
