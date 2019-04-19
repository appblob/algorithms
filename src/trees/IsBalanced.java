package trees;

public class IsBalanced {

    public static boolean isBalanced(TreeNode root) {

        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode root) {

        // tremination case root is null, return 0
        if(root == null) return 0;

        // calculate the left and right height if it's -1 return -1
        int leftHeight = checkBalance(root.left);
        if(leftHeight == -1 ) return -1;

        int rightHeight = checkBalance(root.right);
        if(rightHeight == - 1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        TreeNode root = TreeHelper.buildTree(arr);
        System.out.println(isBalanced(root));
    }
}
