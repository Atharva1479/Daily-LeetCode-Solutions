/* 234. Palindrome Linked List - Easy

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false
 
Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9 */

class Solution {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfStart = reverse(slow);
        slow.next = null;

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;

        while(p1!=null && p2!=null){

            if(p1.val != p2.val){

                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node){

        ListNode prev = null;
        ListNode current = node;

        while(current!=null){

            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
//Time complexity: O(n)
//Space complexity: O(1)