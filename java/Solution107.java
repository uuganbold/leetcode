import java.util.*;

class Solution107 {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Queue<TreeNode> temp = new LinkedList<>();
            List<Integer> level = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    temp.offer(node.left);
                if (node.right != null)
                    temp.offer(node.right);
            }

            ans.add(0, level);
            queue = temp;
        }

        return ans;
    }
}