package trees;

public class IsBalanced {

    /*
    * Leetcode : 110
    *
    * Thought : A node is balanced if ABS(leftChildHeight - rightChildHeight) <= 1
    * Technique(s): recursion, Post Order Traversal
    * */
    public static boolean isBalanced(TreeNode root) {

        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode root) {

        // termination case root is null, return 0
        if(root == null) return 0;

        // calculate the left and right height if they are -1, return -1
        int leftHeight = checkBalance(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = checkBalance(root.right);
        if(rightHeight == - 1) return -1;

        // a tree is not balanced if ABS(leftHeight - rightHeight) > 1
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        // height at current level = MAX(eftHeight, rightHeight) + 1
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        TreeNode root = TreeHelper.buildTree(arr);

        System.out.println(isBalanced(root));
    }
}
