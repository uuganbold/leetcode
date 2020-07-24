
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
import java.util.*;

class Solution1161 {
    /*
     * T: O(N) S: O(N)
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = root.val;
        int maxLevel = 1;
        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Queue<TreeNode> temp = new LinkedList<>();
            int sum = 0;
            level++;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    temp.offer(node.left);
                }
                if (node.right != null) {
                    temp.offer(node.right);
                }
            }

            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
            queue = temp;
        }

        return maxLevel;

    }
}