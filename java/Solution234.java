/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution234 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean isPalindrome(ListNode head) {
        ListNode reversed=null;
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            ListNode temp=slow;
            slow=slow.next;
            temp.next=reversed;
            reversed=temp;
        }
        
        if(fast!=null){
            slow=slow.next;
        }
        
        while(reversed!=null){
            if(reversed.val!=slow.val){
                return false;
            }
            
            reversed=reversed.next;
            slow=slow.next;
        }
        
        return true;
    }
}