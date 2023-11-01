package leetcode.basic.list;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/10/31 11:52
 */
public class FindFromEnd {

    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;

    }

}
