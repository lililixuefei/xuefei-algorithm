package a.wushixiong.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 相交链表   https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author: xuefei
 * @date: 2022/05/03 23:05
 */
public class IntersectionNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointA = headA;
        ListNode pointB = headB;

        while (pointA != pointB) {
            if (pointA == null) {
                pointA = headB;
            } else {
                pointA = pointA.next;
            }

            if (pointB == null) {
                pointB = headA;
            } else {
                pointB = pointB.next;
            }
        }
        return pointA;
    }

    public ListNode getIntersectionNodeWay2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
