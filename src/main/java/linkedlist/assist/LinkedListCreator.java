package linkedlist.assist;

import linkedlist.Node;

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
    public static Node createLinkedList(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        Node headNode = new Node(list.get(0));
        Node tempNode = createLinkedList(list.subList(1, list.size()));
        headNode.setNext(tempNode);
        return headNode;
    }

    /**
     * 打印链表
     *
     * @param node
     */
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.getData());
            System.out.print(" ");
            node = node.getNext();
        }
        System.out.println();
    }
}
