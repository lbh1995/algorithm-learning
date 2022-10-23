package leetcode;

public class LC0002 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        int extra = (l1.val + l2.val) / 10;
        int cur = (l1.val + l2.val) % 10;
        head.val = cur;
        ListNode nextNode = head;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1 = l1.next;
                l1Val = l1 != null ? l1.val : 0;
            }
            if (l2 != null) {
                l2 = l2.next;
                l2Val = l2 != null ? l2.val : 0;
            }
            cur = (l1Val + l2Val + extra) % 10;
            extra = (l1Val + l2Val + extra) / 10;
            if (l1 != null || l2 != null || cur!=0) {
                nextNode.next = new ListNode(cur);
                nextNode = nextNode.next;
            }
        }
        return head;
    }
}
