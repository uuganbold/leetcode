
class Solution1022 {

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

    /*
        T: O(N)
        S: O(H)
    */
    public int sumRootToLeaf(TreeNode root) {
        return sumRTLRecurse(root, 0);
    }

    private int sumRTLRecurse(TreeNode root, int sum) {
        if (root == null)
            return 0;

        sum = sum*2 + root.val;

        if (root.left == null && root.right == null)
            return sum;

        return sumRTLRecurse(root.left, sum) + sumRTLRecurse(root.right, sum);
    }
}