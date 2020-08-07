/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution1448 {
    /*
     * T: O(N) S: O(N)
     */
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }

    private int helper(TreeNode root, int currentGreatest) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.val >= currentGreatest) {
            ans++;
            currentGreatest = root.val;
        }
        ans += helper(root.left, currentGreatest);
        ans += helper(root.right, currentGreatest);
        return ans;
    }

}