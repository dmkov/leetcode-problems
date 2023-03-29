/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *

    Q: We are given start nodes of the LinkedList, so every element points to the next?
    Q: I need to relink existing nodes?

    1->2->5->7
             |
    1->3->6
             |

    sorted = res
    last = res->1->1->2->3->5->6


 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sorted = new ListNode();
        ListNode last = sorted;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                last.next = list2;
                list2 = list2.next;
            } else {
                last.next = list1;
                list1 = list1.next;
            }
            last = last.next;
        }
        if (list1 != null) {
            last.next = list1;
        } else if (list2 != null) {
            last.next = list2;
        }
        return sorted.next;
    }
}