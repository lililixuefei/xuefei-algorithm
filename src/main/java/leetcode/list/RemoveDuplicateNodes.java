package leetcode.list;

import java.util.LinkedHashSet;

/**
 * @description: 移除重复节点
 * @author: xuefei
 * @date: 2023/02/23 23:08
 */
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        while (head != null){
            linkedHashSet.add(head.val);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (Integer val : linkedHashSet) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }

}
