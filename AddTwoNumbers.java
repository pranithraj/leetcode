/* https://leetcode.com/problems/add-two-numbers */

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
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0), temp;
    temp = result;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int l1_val = (l1 != null) ? l1.val : 0;
      int l2_val = (l2 != null) ? l2.val : 0;
      int sum = l1_val + l2_val + carry;
      carry = sum / 10;
      result.next = new ListNode(sum % 10);
      result = result.next;
      l1 = (l1 == null) ? null : l1.next;
      l2 = (l2 == null) ? null : l2.next;
    }
    
    if (carry > 0) {
      result.next = new ListNode(carry);
    }
    return temp.next;
    }
}
