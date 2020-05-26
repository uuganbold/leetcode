import java.util.*;

class Solution530 {

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

    int prev = -1;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getMinimumDifferenceIterative(root);
        return minDiff;
    }

    /*
        T: O(N)
        S: O(1)
    */
    private void getMinimumDifferenceMorris(TreeNode root){
        
        TreeNode node=root;
        TreeNode prevNode;
        
        while(node!=null){
            
            if(node.left!=null){
                prevNode=node.left;
                
                while(prevNode.right!=null&&prevNode.right!=node){
                    prevNode=prevNode.right;
                }
                
                if(prevNode.right==null){
                    prevNode.right=node;
                    node=node.left;
                }else{
                    prevNode.right=null;
                    traverse(node);
                    node=node.right;
                }
            }else{
                traverse(node);
                node=node.right;
                
            }
        }    
    }
    
    private void traverse(TreeNode node){
        if(prev>=0){
            int diff=node.val-prev;
            if(diff<minDiff) minDiff=diff;
        }
        prev=node.val;
    }

    /*
        T:O(N)
        S:O(H)
    */
    private void getMinimumDifferenceIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (prev >= 0) {
                int diff = node.val - prev;
                if (diff < minDiff)
                    minDiff = diff;
            }
            prev = node.val;

            node = node.right;

        }

    }

    /*
        T: O(N)
        S: O(H)
    */
    private void getMinimumDifferenceRecurse(TreeNode root) {
        if (root == null)
            return;
        getMinimumDifferenceRecurse(root.left);

        if (prev >= 0) {
            int diff = root.val - prev;
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        prev = root.val;
        getMinimumDifferenceRecurse(root.right);
    }
}