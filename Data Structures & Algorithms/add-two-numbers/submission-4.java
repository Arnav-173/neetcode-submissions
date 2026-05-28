/**
 * Definition for singly-linked list.
 * 1
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        int carryOver = 0;
        ListNode prev = null;
        while (l1 != null && l2 != null) {
            int num = carryOver + l1.val + l2.val;
            if (num >= 10) {
                carryOver = num / 10;
                num = num % 10;          
            } else {
                carryOver = 0;
            }
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
            }
            if (prev != null) {
                prev.next = node;
            }
            prev = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                int num = carryOver + l2.val;
                if (num >= 10) {
                    carryOver = num / 10;
                    num = num % 10;
                } else {
                    carryOver = 0;
                }
                ListNode node = new ListNode(num);
                if (head == null) {
                    head = node;
                }
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                int num = carryOver + l1.val;
                if (num >= 10) {
                    carryOver = num / 10;
                    num = num % 10;
                } else {
                    carryOver = 0;
                }
                ListNode node = new ListNode(num);
                if (head == null) {
                    head = node;
                }
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                l1 = l1.next;
            }  
        }
        if (carryOver > 0) {
                ListNode node = new ListNode(carryOver);
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
        }
        return head;
    }
}
