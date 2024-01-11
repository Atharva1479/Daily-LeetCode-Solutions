/*143. Reorder List - Medium

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 
Constraints:
The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000 */

class Solution {

    public void reorderList(ListNode head) {

        if(head==null || head.next==null)return ;

        ListNode slow = head;
        ListNode fast= head;
        while(fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
        }
       
       ListNode newNode = reverseList(slow.next);
       slow.next=null;
       ListNode curr = head;
       ListNode dummy = newNode;
       
       while(head!=null && dummy!=null){

           ListNode temp = curr.next;
           curr.next=dummy;
           ListNode temp2=dummy.next;
           dummy.next=temp;
           curr=temp;
           dummy=temp2;
       }
    }

    public ListNode reverseList(ListNode node){

        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;

        while(curr!=null){

            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }       
        return prev;
    }
}
//Time complexity: O(n)
//Space complexity: O(1)