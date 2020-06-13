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
class Solution203 {

    /*
        T: O(N)
        S: O(1)
    */
    public ListNode removeElements(ListNode head, int val) {
        ListNode fake=new ListNode();
        fake.next=head;
        head=fake;
        while(head.next!=null){
            if(head.next.val==val){
                head.next=head.next.next;
            }else{
                head=head.next;
            }
        }
        
        return fake.next;
    }
}