package leetcode.interviewgolden.unresolved;

import labuladong.list.ListNode;

/**
 * @description: 链表求和
 * @author: xuefei
 * @date: 2023/08/13 11:44
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(t % 10);
            temp = temp.next;
            t /= 10;
        }
        return ans.next;
    }

    public ListNode addTwoNumbers_me(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode();
        ListNode temp = result;

        // 进位
        int carry = 0;
        while (l1 != null && l2 != null) {
            int l1Val = l1.val;
            int l2Val = l2.val;
            int sum = l1Val + l2Val + carry;
            int curCarry = sum / 10;
            int curValue = sum % 10;
            carry = curCarry;

            result.next = new ListNode(curValue);
            result = result.next;

            l2 = l2.next;
            l1 = l1.next;
        }

        while (l1 != null) {
            int l1Val = l1.val;
            int sum = l1Val + carry;
            int curCarry = sum / 10;

            int curValue = sum % 10;
            carry = curCarry;

            result.next = new ListNode(curValue);
            result = result.next;

            l1 = l1.next;
        }
        while (l2 != null) {
            int l2Val = l2.val;

            int sum = l2Val + carry;

            int curCarry = sum / 10;

            int curValue = sum % 10;
            carry = curCarry;

            result.next = new ListNode(curValue);
            result = result.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        return temp.next;
    }

}
