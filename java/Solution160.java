/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution160 {
    
    /*
        T: O(A+B)
        S: O(1)
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA=size(headA);
        int sizeB=size(headB);
        int justifySize=Math.min(sizeA,sizeB);
        
        while(sizeA>justifySize){
            headA=headA.next;
            sizeA--;
        }
        
        while(sizeB>justifySize){
            headB=headB.next;
            sizeB--;
        }
        
        while(headA!=headB){
            headA=headA.next; 
            headB=headB.next;
        }
        
        return headA;
        
    }
    
    private int size(ListNode head){
        int s=0;
        while(head!=null){
            s++;
            head=head.next;
        }
        return s;
    }
}