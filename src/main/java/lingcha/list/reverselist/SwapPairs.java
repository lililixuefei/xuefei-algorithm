package lingcha.list.reverselist;

import labuladong.list.ListNode;

/**
 * @Description 两两交换链表中的节点
 * @Author xuefei
 * @Date 2023/10/30 22:11
 * @Version 1.0
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        // 用哨兵节点简化代码逻辑
        ListNode dummy = new ListNode(0, head);
        ListNode node0 = dummy;
        ListNode node1 = head;
        // 至少有两个节点
        while (node1 != null && node1.next != null) {
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node0.next = node2; // 0 -> 2
            node2.next = node1; // 2 -> 1
            node1.next = node3; // 1 -> 3

            node0 = node1; // 下一轮交换，0 是 1
            node1 = node3; // 下一轮交换，1 是 3
        }
        return dummy.next; // 返回新链表的头节点
    }

}
