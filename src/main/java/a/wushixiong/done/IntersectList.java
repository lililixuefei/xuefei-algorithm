package a.wushixiong.done;

import a.wushixiong.firstweek.ListNode;

/**
 * @description: 相交链表
 * @author: xuefei
 * @date: 2022/06/21 00:33
 */
public class IntersectList {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode slow = headA;
        ListNode fast = headB;

        while (slow != fast) {

            if (slow == null) {
                slow = headB;
            }else {
                slow = slow.next;
            }

            if (fast == null) {
                fast = headA;
            }else {
                fast = fast.next;
            }
        }
        return slow;
    }
}
