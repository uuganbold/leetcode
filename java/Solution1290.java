class Solution1290 {

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

    /**
     * T: O(n)
     * S: O(1)
     */
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result << 1 | head.val;
            head = head.next;
        }
        return result;
    }
}