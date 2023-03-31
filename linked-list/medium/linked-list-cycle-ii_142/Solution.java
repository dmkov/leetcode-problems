/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode tortoise = head.next;
        ListNode hare = head.next.next;
        while (hare != null && hare.next != null && hare != tortoise) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        if (hare != tortoise) {
            return null;
        }

        while (head != hare) {
            hare = hare.next;
            head = head.next;
        }
        return head;
    }
}