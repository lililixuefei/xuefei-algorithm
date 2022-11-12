package study.wushixiong.done;

import study.wushixiong.firstweek.ListNode;

/**
 * @description: 翻转链表
 * @author: xuefei
 * @date: 2022/06/21 00:12
 */
public class ReverseList {

    /**
     * 递归翻转
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return tempNode;
    }

    /**
     * 迭代翻转
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
