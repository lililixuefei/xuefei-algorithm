package leetcode.interviewgolden.resolved;

import labuladong.list.ListNode;

/**
 * @description: 返回倒数第 k 个节点
 * @author: xuefei
 * @date: 2023/08/13 11:28
 */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return -1;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

}
