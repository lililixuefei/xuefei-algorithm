package xuefei.done.leetcode.linkedlist;

/**
 * @description: 链表求和  https://leetcode.cn/problems/sum-lists-lcci/
 * @author: xuefei
 * @date: 2022/08/21 21:23
 */
public class SumLists {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        if (carry != 0){
            result.next = new ListNode(carry);
        }
        return temp.next;
    }
}
