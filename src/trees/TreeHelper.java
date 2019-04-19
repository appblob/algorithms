package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeHelper {

    public static TreeNode buildTree(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for(int i = 1; i < arr.length + 1; i += 2) {

            TreeNode current = q.poll();

            if(i < arr.length) {
                current.left = new TreeNode(arr[i]);
                q.offer(current.left);
            }


            if(i + 1 < arr.length) {
                current.right = new TreeNode(arr[i + 1]);
                q.offer(current.right);
            }
        }

        q.clear();

        return root;
    }

    public static TreeNode sortedArrayToBST(int[] arr) {

        int left  = 0, right = arr.length - 1;
        return treefy(arr, left, right);
    }

    private static TreeNode treefy(int[] arr, int left, int right) {

        if(left > right) return null;

        int mid  = left + ((right - left ) / 2);

        TreeNode node = new TreeNode(arr[mid]);

        node.left = treefy(arr, left, mid - 1);
        node.right = treefy(arr, mid + 1, right);

        return node;
    }

    public static void print(String msg, TreeNode node) {

        if(node == null)
            System.out.println("Empty tree.");

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        q.offer(node);

        while(!q.isEmpty()) {
            int size = q.size();

            List<Integer> levelResult = new LinkedList<>();
            for (int i = 0; i < size; i++) {

                TreeNode current = q.poll();
                levelResult.add(current.val );

                if(current.left != null)
                q.offer(current.left);

                if(current.right != null)
                q.offer(current.right);

            }

            result.add(levelResult);
        }

        System.out.println(msg + ":\n" + result.toString());
    }
}
