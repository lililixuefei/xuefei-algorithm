package linkedlist;

import linkedlist.assist.LinkedListCreator;

import java.util.Arrays;

/**
 * @description: 翻转链表
 * @author: xuefei
 * @date: 2022/03/02 00:08
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node headNode1 = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        // 迭代翻转
        Node node1 = iterateReverseList(headNode1);
        LinkedListCreator.printList(node1);


        Node headNode2 = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        // 递归翻转
        Node node2 = recursiveReverseList(headNode2);
        LinkedListCreator.printList(node2);
    }

    /**
     * 迭代翻转
     *
     * @param head
     * @return
     */
    public static Node iterateReverseList(Node head) {
        //申请节点，pre和 cur，pre指向null
        Node pre = null;
        Node cur = head;
        Node tmp = null;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 递归翻转
     *
     * @param head
     * @return
     */
    public static Node recursiveReverseList(Node head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        Node cur = recursiveReverseList(head.next);
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

}
