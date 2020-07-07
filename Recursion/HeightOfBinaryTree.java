// Height of Binary Tree
public class HeightOfBinaryTree {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right)); 
    }
}