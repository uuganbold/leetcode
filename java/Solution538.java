import java.util.*;

class Solution538 {
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

    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    /*
        T: O(N)
        S: O(N)
    */
    private void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        int sum = 0;
        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            node = node.left;
        }

    }

    private int recurseHelper(TreeNode root, int sumAbove) {
        if (root == null)
            return sumAbove;
        int rightSum = recurseHelper(root.right, sumAbove);
        root.val += rightSum;
        return recurseHelper(root.left, root.val);
    }
}