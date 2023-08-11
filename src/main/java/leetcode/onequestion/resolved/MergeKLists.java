package leetcode.onequestion.resolved;

import labuladong.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 合并 K 个升序链
 * @author: xuefei
 * @date: 2023/08/12 00:09
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(e -> e.val));
        for (ListNode list : lists) {
            if (list == null){
                continue;
            }
            priorityQueue.add(list);
        }

        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (!priorityQueue.isEmpty()){
            ListNode listNode = priorityQueue.poll();
            temp.next = listNode;
            temp = temp.next;
            if (listNode.next != null){
                priorityQueue.add(listNode.next);
            }
        }
        return dummy.next;
    }

}
