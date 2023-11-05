package leetcode.top100;

import labuladong.list.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/5 20:59
 * @Version 1.0
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (ListNode listNode : list) {
            listNode.next = null;
        }
        list.sort(Comparator.comparingInt(e -> e.val));
        ListNode dummy = new ListNode();
        head = dummy;
        for (ListNode listNode : list) {
            head.next = listNode;
            head = head.next;
        }
        return dummy.next;
    }


    public ListNode sortList_me_r(ListNode head) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        while (head != null) {
            priorityQueue.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode curNode = priorityQueue.poll();
            curNode.next = null;
            temp.next = curNode;
            temp = temp.next;
        }
        return dummy.next;
    }

}
