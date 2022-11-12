package study.wushixiong.firstweek;

/**
 * @description: 相交链表
 * @author: xuefei
 * @date: 2022/06/13 23:29
 */
public class IntersectionList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointA = headA;
        ListNode pointB = headB;

        while (pointA != pointB) {

            if (pointA == null){
                pointA = headB;
            }else {
                pointA = pointA.next;
            }

            if (pointB == null) {
                pointB = headA;
            }else {
                pointB = pointB.next;
            }
        }

        return pointA;
    }
}
