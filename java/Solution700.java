class Solution700 {

    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
    }
    /**
     * T: O(logN)
     * S: O(logN)
     */
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val==val) return root;
        if(val>root.val){
            return searchBSTRecursive(root.right,val);
        }else return searchBSTRecursive(root.left,val);
    }
    
    /**
     * T: O(logN)
     * S: O(1)
     */
    public TreeNode searchBST(TreeNode root, int val){
        while(root!=null){
            if(root.val==val) return root;
            if(root.val>val) root=root.left;
            else root=root.right;
        }
        
        return null;
    }
}