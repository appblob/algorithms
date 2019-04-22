package trees;

public class AddTwoTrees {

    /*
    * Leetcode : 617
    * Thought : Preorder
    * */
    public static TreeNode addTrees(TreeNode t1, TreeNode t2) {
        // termination case : when both are null return null
        if(t1 == null && t2 == null) return null;

        TreeNode mergedTree;

        // compute sum
        int sum = 0;
        if(t1 != null) sum += t1.val;
        if(t2 != null) sum += t2.val;

        mergedTree = new TreeNode(sum);

        // handle case when t1 or t2 is null
        mergedTree.left = addTrees((t1 == null) ? null : t1.left, (t2 == null) ? null : t2.left);
        mergedTree.right = addTrees((t1 == null) ? null : t1.right, (t2 == null) ? null : t2.right);

        return mergedTree;
    }

    public static void main(String[] args) {
        int [] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root1 = TreeHelper.sortedArrayToBST(arr1);
        TreeHelper.print("The input tree 1 : " , root1);

        int [] arr2 = {10, 11, 12, 13, 14, 15};
        TreeNode root2 = TreeHelper.sortedArrayToBST(arr2);
        TreeHelper.print("The input tree 2 : " , root2);

        TreeNode merged = addTrees(root1, root2);
        TreeHelper.print("Merged : " , merged);

    }
}
