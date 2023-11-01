package leetcode.basic.list;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/10/31 16:41
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = findFromEnd(dummy, n + 1);
        node.next = node.next.next;
        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int n) {
        ListNode p0 = head;
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p0 = p0.next;
        }
        return p0;
    }


}
