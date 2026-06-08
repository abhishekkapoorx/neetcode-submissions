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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> pq= new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node: lists) {
            if (node != null) pq.offer(node);
        }

        ListNode ans = new ListNode(-1);
        ListNode ansHead = ans;
        while (!pq.isEmpty()) {
            ListNode sm = pq.poll();
            System.out.println(sm.val);
            ans.next = sm;
            ans = ans.next;
            if (sm.next != null) pq.offer(sm.next);
        }
        return ansHead.next;
    }
}
