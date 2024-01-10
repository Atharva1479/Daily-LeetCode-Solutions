/* 148. Sort List - Medium

Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []
 
Constraints:
The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105 */

class Solution {

    public ListNode sortList(ListNode head) {

        if (head==null || head.next==null) {

            return head;
        }

        ListNode mid = Mid_Of_Head(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode t1 = sortList(head);
        ListNode t2 = sortList(head2);
        return merge(t1,t2); 
    }

    public ListNode Mid_Of_Head(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode head1, ListNode head2) {

        ListNode head;
        if (head1==null) {

            return head2;
        }
        if (head2==null) {

            return head1;
        }
        if (head1.val<head2.val) {

            head = head1;
            head1 = head1.next;
        }
        else {

            head = head2;
            head2 = head2.next;
        }

        ListNode t = head;
        while (head1!=null && head2!=null) {

            if (head1.val<head2.val) {

                t.next = head1;
                head1 = head1.next;
                t = t.next;
            }
            else {

                t.next = head2;
                head2 = head2.next;
                t = t.next;
            }
        }
        if (head1==null) {

            t.next = head2;
        }
        if (head2==null) {
            
            t.next = head1;
        }
        return head;
    }
}
//Time complexity: O(n log n)
//Space complexity: O(log n)