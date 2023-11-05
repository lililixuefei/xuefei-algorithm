package leetcode.top100;

import labuladong.list.ListNode;

import java.util.PriorityQueue;

/**
 * @Description 合并 K 个升序链表
 * @Author xuefei
 * @Date 2023/11/5 23:28
 * @Version 1.0
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            priorityQueue.add(list);
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode curNode = priorityQueue.poll();
            temp.next = curNode;
            temp = temp.next;
            if (curNode.next != null) {
                priorityQueue.add(curNode.next);
            }
        }
        return dummy.next;
    }

}
