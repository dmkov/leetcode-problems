/**

    1 < 2 < 3 < 4

                c   n   t
     
    t = n.next 
    n.next = c 
    c = n
    n = t


    1 < 2 < 3 < 4

    Q: Do we need to return "4" node at the end?
    Q: One element can have only one next node?


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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next; // 4
        head.next = null;
        while (next != null) {
            ListNode temp = next.next; // null
            next.next = head; // 3
            head = next; // 3
            next = temp; // null
        }
        return head;
    }
}