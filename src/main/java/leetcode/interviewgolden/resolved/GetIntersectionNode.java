package leetcode.interviewgolden.resolved;

import leetcode.basic.list.ListNode;

/**
 * @description: 链表相交
 * @author: xuefei
 * @date: 2023/08/13 15:02
 */
public class GetIntersectionNode {

    /**
     * 双指针
     *
     * @param headA
     * @param headB
     * @return
     */
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
