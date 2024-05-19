package leetcode.top100.linkedlist;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/2/19 22:57
 * @Version 1.0
 */
public class RemoveNthFromEnd {

    // 1 2 3 4 5
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

}
