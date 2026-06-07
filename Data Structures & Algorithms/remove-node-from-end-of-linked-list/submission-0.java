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

class Solution {
    private int findcount(ListNode head) {
        if (head == null) return 0;
        ListNode temp = head;

        int cnt = 0;
        while (temp!=null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        int count = findcount(head);
        int pos = count - n - 1;
        if (pos == 0) return head.next;

        ListNode temp = head;
        while (pos-- > 0) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
