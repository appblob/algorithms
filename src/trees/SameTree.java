package trees;

public class SameTree {
    public static boolean isSameTree(TreeNode n1, TreeNode n2) {

        if(n1 == null ^ n2 == null) return false;
        if(n1 == null && n2 == null) return true;

        return (n1.val == n2.val && isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right));
    }

    public static void main(String[] args) {
        int [] arr1 = {1, 2, 2, 3, 4, 4, 3};

        TreeNode root1 = TreeHelper.buildTree(arr1);
        TreeHelper.print("The input tree 1 : " , root1);

        int [] arr2 = {1, 2, 2, 3, 4, 4, 3};

        TreeNode root2 = TreeHelper.buildTree(arr2);
        TreeHelper.print("The input tree 2 : " , root2);

        System.out.println("Same tree : " + isSameTree(root1, root2));
    }
}
