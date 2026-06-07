class Solution {

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode rest = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return rest;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = findMid(head);

        ListNode second = reverseList(mid.next);
        mid.next = null;

        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}