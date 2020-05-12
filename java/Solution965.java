class Solution965 {

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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        return isUnivalTree(root,root.val);
    }

    public boolean isUnivalTree(TreeNode root, int val){
        if(root==null) return true;
        return root.val==val&&isUnivalTree(root.left,val)&&isUnivalTree(root.right,val);
    }

}