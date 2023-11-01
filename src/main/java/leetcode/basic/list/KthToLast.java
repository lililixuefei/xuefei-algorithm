package leetcode.basic.list;

import leetcode.basic.list.ListNode;

/**
 * @description: 返回倒数第 k 个节点
 * @author: xuefei
 * @date: 2023/02/23 22:18
 */
public class KthToLast {


    public int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }

        while (node != null) {
            cur = cur.next;
            node = node.next;
        }
        return cur.val;
    }


    public int kthToLast2(ListNode head, int k) {
        ListNode pre = head, cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return pre.val;
    }

}
