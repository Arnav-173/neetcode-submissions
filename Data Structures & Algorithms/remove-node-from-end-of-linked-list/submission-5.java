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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        int count = 1;
        node = head;
        while (count < length - n) {
            node = node.next;
            count++;
        }
        if (length == n) {
            head = head.next;
        } else {
            node.next = node.next.next;
        }  
        return head;
    }
}
