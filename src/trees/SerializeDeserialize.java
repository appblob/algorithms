package trees;

public class SerializeDeserialize {

    /*
        THOUGHT : Use preOrder to traverse the tree.
        Output: root;left1;left2;n;n;right2;n;n;
    */
    public static String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();

        preOrder(node, sb);

        return sb.toString();
    }

    private static void preOrder(TreeNode node, StringBuilder sb) {

        if(node == null) sb.append("n;");

        else {

            sb.append(node.val + ";");

            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }


    public static TreeNode deserialize(String str) {

        String [] tokens = str.split(";");

        return build(tokens);
    }

    static int index = 0;
    private static TreeNode build(String[] tokens) {

        if(index == tokens.length) return null;

        String token = tokens[index++];

        if(token.equals("n")) return null;

        TreeNode current = new TreeNode(Integer.valueOf(token));

        current.left = build(tokens);
        current.right = build(tokens);

        return current;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeHelper.sortedArrayToBST(arr);

        TreeHelper.print("The input tree" , root);

        String str = serialize(root);

        System.out.println("Serialize : " + str);

        TreeNode node = deserialize(str);

        TreeHelper.print("The output tree" , node);
    }
}
