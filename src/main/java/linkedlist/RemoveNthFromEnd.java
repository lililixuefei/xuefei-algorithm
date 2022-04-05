package linkedlist;

import linkedlist.assist.LinkedListCreator;

import java.util.Arrays;

/**
 * @description: 删除链表的倒数第N个节点
 * @author: xuefei
 * @date: 2022/03/06 22:45
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        Node headNode1 = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));

        // 两次遍历
        Node node1 = removeNthFromEndNeedTwoTraversal(headNode1, 2);
        LinkedListCreator.printList(node1);

        Node headNode2 = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));

        // 一次遍历
        Node node2 = removeNthFromEndNeedOneTraversal(headNode2, 2);
        LinkedListCreator.printList(node2);
    }


    /**
     * 一次遍历
     * traversal : 遍历
     *
     * @param head
     * @param n
     * @return
     */
    public static Node removeNthFromEndNeedOneTraversal(Node head, int n) {
        //增加一个特殊节点方便边界判断
        Node p = new Node(-1);
        p.next = head;
        Node a = p;
        Node b = p;
        //第一个循环，b指针先往前走n步
        while (n > 0 && b != null) {
            --n;
            b = b.next;
        }
        //假设整个链表长5，n是10，那么第一次遍历完后b就等用于空了
        //于是后面的判断就不用做了，直接返回
        if (b == null) {
            return head;
        }
        //第二次，b指针走到链表最后，a指针也跟着走
        //当遍历结束时，a指针就指向要删除的节点的前一个位置
        while (b.next != null) {
            a = a.next;
            b = b.next;
        }
        //删除节点并返回
        a.next = a.next.next;
        return p.next;
    }


    /**
     * 两次遍历
     * traversal : 遍历
     *
     * @param head
     * @param n
     * @return
     */
    public static Node removeNthFromEndNeedTwoTraversal(Node head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        //增加一个特殊节点，方便边界处理
        Node p = new Node(-1);
        p.next = head;
        Node cur = p;
        int k = 0;
        //第一次遍历，计算链表总长度
        while (cur.next != null) {
            cur = cur.next;
            ++k;
        }
        //如果链表总长度小于n，那就直接返回
        if (k < n) {
            return head;
        }
        //计算第二次遍历多少个节点
        int num = k - n;
        cur = p;
        //第二次遍历，找到要删除节点的前一个节点
        while (num > 0) {
            cur = cur.next;
            --num;
        }
        //删除节点，并返回
        Node next = cur.next;
        cur.next = cur.next.next;
        next.data = null;
        next.next = null;
        return p.next;
    }
}
