
class Solution108 {

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
        S: O(logN)
    */
    public TreeNode sortedArrayToBST(int[] nums) {
         return makeTreeRecurse(nums,0,nums.length);
    }

    private TreeNode makeTreeRecurse(int[] nums, int left, int right){
        if(left>=right) return null;
        int mid=(left+right)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=makeTreeRecurse(nums,left,mid);
        node.right=makeTreeRecurse(nums,mid+1,right);
        return node;
    }
}