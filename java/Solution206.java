class Solution206 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        return reverseListIterative(head);
    }

    /*
        T: O(N)
        S: O(1)
    */
    private ListNode reverseListIterative(ListNode head) {

        ListNode reverse = null;
        while (head != null) {
            ListNode node = head.next;
            head.next = reverse;
            reverse = head;
            head = node;
        }

        return reverse;
    }

    /*
        T: O(N)
        S: O(N)
    */
    private ListNode reverseListRecurse(ListNode old, ListNode newList) {
        if (old == null)
            return newList;
        ListNode rest = old.next;
        old.next = newList;
        return reverseListRecurse(rest, old);
    }
}