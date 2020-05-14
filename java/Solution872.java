import java.util.*;
class Solution872 {

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = leafSequence(root1);
        List<Integer> leafs2 = leafSequence(root2);

        return leafs1.equals(leafs2);
    }

    private List<Integer> leafSequence(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> leafs) {
        if (root.left == null && root.right == null)
            leafs.add(root.val);
        if (root.left != null)
            helper(root.left, leafs);
        if (root.right != null)
            helper(root.right, leafs);
    }
}