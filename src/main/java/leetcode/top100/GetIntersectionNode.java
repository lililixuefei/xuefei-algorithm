package leetcode.top100;

import labuladong.list.ListNode;

/**
 * @Description 相交链表
 * @Author xuefei
 * @Date 2023/11/2 22:37
 * @Version 1.0
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
