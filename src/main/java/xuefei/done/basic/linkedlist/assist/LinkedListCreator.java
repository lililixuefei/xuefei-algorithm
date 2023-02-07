package xuefei.done.basic.linkedlist.assist;

import xuefei.done.basic.linkedlist.node.ListNode;

import java.util.List;

/**
 * @description: 链表创建打印公用类
 * @author: xuefei
 * @date: 2022/03/02 23:48
 */
public class LinkedListCreator {


    /**
     * 构建链表
     *
     * @param list
     * @return
     */
    public static ListNode createLinkedList(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode headNode = new ListNode(list.get(0));
        ListNode tempNode = createLinkedList(list.subList(1, list.size()));
        headNode.next = tempNode;
        return headNode;
    }

    /**
     * 打印链表
     *
     * @param node
     */
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" ");
            node = node.next;
        }
        System.out.println();
    }
}
