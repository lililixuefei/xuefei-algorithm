package done;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 相交链表
 * @author: xuefei
 * @date: 2022/07/14 00:09
 */
public class GetIntersectionNode {


    // 双指针
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null){
            if (a == null){
                a = headB;
            }
            if (b == null){
                b = headA;
            }
            if (a == b){
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }


        // set
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            boolean contains = set.contains(headB);
            if (contains){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


}
