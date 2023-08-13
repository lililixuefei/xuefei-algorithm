package leetcode.interviewgolden.resolved;

import labuladong.list.ListNode;

/**
 * @description: 删除中间节点
 * @author: xuefei
 * @date: 2023/08/13 11:31
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

}
