package leetcode.interviewgolden.resolved;

import labuladong.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 移除重复节点
 * @author: xuefei
 * @date: 2023/08/13 11:21
 */
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        set.add(temp.val);
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                set.add(temp.next.val);
                temp = temp.next;
            }
        }
        return head;
    }

}
