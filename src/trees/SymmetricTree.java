package trees;

public class SymmetricTree {

    /*
    * Leetcode : 101
    * Thought: Pre-order, recursive
    * symmetry : left should match right
    * */
    public static boolean isSymmetric(TreeNode node) {

        return symmetricHelper(node.left, node.right);
    }

    private static boolean symmetricHelper(TreeNode n1, TreeNode n2) {

        if(n1 == null ^ n2 == null) return false;
        if(n1 == null && n2 == null) return true;

        return(n1.val == n2.val && symmetricHelper(n1.left, n2.right) && symmetricHelper(n1.right, n2.left));
    }

    public static void main(String[] args) {
        int [] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root1 = TreeHelper.sortedArrayToBST(arr1);
        TreeHelper.print("The input tree 1 : " , root1);

        System.out.println("Input tree 1 is symmetric : " + isSymmetric(root1));

        int [] arr2 = {1, 2, 2, 3, 4, 4, 3};

        TreeNode root2 = TreeHelper.buildTree(arr2);
        TreeHelper.print("The input tree 2 : " , root2);

        System.out.println("Input tree 2 is symmetric : " + isSymmetric(root2));

    }
}
