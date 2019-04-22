package trees;

public class UnivaluedTree {

    public static boolean univalued(TreeNode node) {
        return univalued(node, node.val);

    }

    private static boolean univalued(TreeNode node, int value) {

        // termination condition : node is null, return null
        if(node == null) return true;

        boolean left = univalued(node.left, value);
        boolean right = univalued(node.right, value);

        return (node.val == value) & left & right;

    }

    public static void main(String[] args) {
        int [] arr1 = {1, 1, 1, 1, 1, 1, 1, 1, 1};

        TreeNode root1 = TreeHelper.sortedArrayToBST(arr1);

        TreeHelper.print("The input tree" , root1);

        System.out.println("The tree is univalued : "+ univalued(root1));


        int [] arr2 = {1, 1, 1, 1, 1, 1, 1, 1, 2};

        TreeNode root2 = TreeHelper.sortedArrayToBST(arr2);

        TreeHelper.print("The input tree" , root2);

        System.out.println("The tree is univalued : "+ univalued(root2));
    }
}
