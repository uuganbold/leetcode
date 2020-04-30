import java.util.Stack;

class Solution938 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        }

    /**
    Time:O(N)
    Space:O(H-height of the tree)
    */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) return 0;
        int sum=0;
        if(root.val>=L&&root.val<=R) sum+=root.val;
        if(root.val>L) sum+=rangeSumBST(root.left,L,R);
        if(root.val<R) sum+=rangeSumBST(root.right,L,R);
        return sum;
    }

    public int rangeSumBSTIterative(TreeNode root, int L, int R) {
        int sum=0;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()s){
            TreeNode node=stack.pop();
            if(node.val>=L&&root.val<=R) sum+=node.val;
            if(root.val>L) stack.push(root.left);
            if(root.val<R) stack.push(root.right);
        }
        return sum;
    }
}