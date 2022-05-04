package linkedlist;

import linkedlist.assist.LinkedListCreator;

import java.util.Arrays;

/**
 * @description: 链表的中间节点   https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author: xuefei
 * @date: 2022/03/03 00:07
 */
public class MiddleNode {

    public static void main(String[] args) {
        // 奇数节点数
        Node oddNode = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        // 偶数节点数
        Node evenNode = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6));

        Node node = middleNode(oddNode);
        assert node != null;
        System.out.println(node.data);


        Node node1 = middleNode(evenNode);
        assert node1 != null;
        System.out.println(node1.data);


    }

    /**
     * 中间节点-双指针法
     *
     * @param head
     * @return
     */
    public static Node middleNode(Node head) {
        //边界条件不用忘记处理了
        if (head == null || head.next == null) {
            return head;
        }
        //定义慢指针，快指针
        Node low = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            //慢指针每次走一步，快指针每次走两步
            low = low.next;
            fast = fast.next.next;
        }
        //根据快指针是否为空判断边界条件
        if (fast != null) {
            return low.next;
        }
        return low;
    }
}
