class Solution897 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode curr;

    /*
        T: O(N)
        S: O(h)
    */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode();
        curr = result;
        inorder(root);
        return result.right;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        inorder(root.right);
    }
}