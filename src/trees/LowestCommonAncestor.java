package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // if node is either p or q then we have found one of the nodes
        if(root == null || p == root || q == root) return root;

        // for a given node find p and q in it's left subtree and right subtree
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

        // the node where the result from both the left and right are not null is the LCA
        if(leftResult != null && rightResult != null) return root;

        // if one of the results from left or right child is not null then pass it up
        return (leftResult == null) ? rightResult : leftResult;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeHelper.sortedArrayToBST(arr);

        TreeHelper.print("The input tree" , root);

        List<TreeNode> nodes = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            nodes.add(TreeHelper.findNode(root, arr[i]));
        }

        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            int pIdx = random.nextInt(arr.length);
            int qIdx = random.nextInt(arr.length);

            TreeNode result = lowestCommonAncestor(root, nodes.get(pIdx), nodes.get(qIdx));
            System.out.println(" The Lowest Common Ancestor of " + nodes.get(pIdx).val + " and " + nodes.get(qIdx).val + " is " + result.val);
        }

    }

}
