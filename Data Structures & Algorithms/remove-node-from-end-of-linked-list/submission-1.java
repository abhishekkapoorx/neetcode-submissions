class Solution {

    private int findcount(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = findcount(head);

        if (count == 1) return null;

        int pos = count - n;

        if (pos == 0) return head.next;

        ListNode temp = head;

        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}