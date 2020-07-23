
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (helper(root, target)) {
            return null;
        } else {
            return root;
        }
    }

    private boolean helper(TreeNode root, int target) {
        if (root == null) {
            return true;
        }

        boolean left = helper(root.left, target);
        if (left) {
            root.left = null;
        }
        boolean right = helper(root.right, target);
        if (right) {
            root.right = null;
        }

        if (left && right && root.val == target) {
            return true;
        }

        return false;
    }
}