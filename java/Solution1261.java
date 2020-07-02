import java.util.*;
public class Solution1261 {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class FindElements1 {

    private TreeNode root;
    public FindElements1(TreeNode root) {
        this.root=root;
        fix(this.root, 0);
    }
    
    private void fix(TreeNode node, int val){
        if(node==null){
            return;
        }
        node.val=val;
        fix(node.left,2*val+1);
        fix(node.right, 2*val+2);
    }
    
    
    /*
        T: O(logN)
        S: O(1)
    */
    public boolean find(int target) {
        int leftMost=0;
        while(target>=leftMost){
            leftMost=leftMost*2+1;
        }
        
        int half=(leftMost+1)/4;
        leftMost=(leftMost+1)/2-1;
        
        TreeNode node=this.root;
        while(half>0&&node!=null){
            
            if(target>=leftMost+half){
                node=node.right;
                leftMost=leftMost+half;
            }else{
                node=node.left;
            }
            half=half/2;
        }
        
        return node!=null;
    
    }
    
    /*
        T: O((logN)^2)
        S: O(logN)
    */
    private boolean find1(int target, TreeNode root){
         if(root==null) return false;
         if(target==root.val) return true;
         int leftMost=root.val;
         int rightMost=root.val;
         while(target>rightMost){
             leftMost=leftMost*2+1;
             rightMost=rightMost*2+2;
         }
         
         if(target>(rightMost+leftMost)/2){
             return find1(target,root.right);
         }else return find1(target,root.left);
    }
}

class FindElements {

    private TreeNode root;
    private Set<Integer> numbers;
    public FindElements(TreeNode root) {
        this.root=root;
        this.numbers=new HashSet<>();
        fix(this.root, 0);
    }
    
    /*
        T: O(N)
        S: O(logN)
    */
    private void fix(TreeNode node, int val){
        if(node==null){
            return;
        }
        node.val=val;
        this.numbers.add(val);
        fix(node.left,2*val+1);
        fix(node.right, 2*val+2);
    }
    /*
        T: O(1)
        S: O(N)
    */
    public boolean find(int target){
        return this.numbers.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}