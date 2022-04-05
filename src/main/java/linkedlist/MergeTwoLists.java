package linkedlist;

import linkedlist.assist.LinkedListCreator;

import java.util.Arrays;

/**
 * @description: 合并两个有序链表
 * @author: xuefei
 * @date: 2022/03/06 23:04
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        Node headNode1 = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        Node headNode2 = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));

        // 迭代-合并两个有序链表
        Node node1 = iterateMergeTwoLists(headNode1, headNode2);
        LinkedListCreator.printList(node1);

        Node headNode3 = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        Node headNode4 = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        // 递归-合并两个有序链表
        Node node2 = recursiveMergeTwoLists(headNode3, headNode4);
        LinkedListCreator.printList(node2);

    }

    /**
     * 迭代版本
     *
     * @param l1
     * @param l2
     * @return
     */
    public static Node iterateMergeTwoLists(Node l1, Node l2) {
        Node p = new Node(-1);
        Node head = p;
        while (l1 != null && l2 != null) {
            //如果l1的值小于l2的值，就将p.next指向l1
            //然后l1继续往后移动一位
            if (l1.data <= l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        //如果l1和l2不一样长，等遍历完后，将p的next指向没遍历完的链表即可
        //比如l1长度是3，1->2->3，l2长度是5 1->2->3->8->9
        //等循环结束时，l1就指向8->9，只要将p.next指向8->9即可
        p.next = (l1 == null ? l2 : l1);
        return head.next;
    }

    /**
     * 递归合并
     * recursive : 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public static Node recursiveMergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.data < l2.data) {
            l1.next = recursiveMergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = recursiveMergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
