import java.util.*;

class Solution653 {

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
        S: O(N)
    */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> numbers = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (numbers.contains(k - node.val)) {
                return true;
            }
            numbers.add(node.val);

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        return false;
    }

    public boolean findTargetDFS(TreeNode root, int k) {
        Set<Integer> numbers = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int i = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (numbers.contains(k - node.val)) {
                return true;
            }
            numbers.add(node.val);

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return false;
    }
}