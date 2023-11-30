package labuladong.math;

import labuladong.list.ListNode;

import java.util.Random;

/**
 * @Description 链表随机节点
 * @Author xuefei
 * @Date 2023/11/30 22:01
 * @Version 1.0
 */
public class RandomList {

    private final ListNode head;
    private final Random r = new Random();

    public RandomList(ListNode head) {
        this.head = head;
    }

    /* 返回链表中一个随机节点的值 */
    int getRandom() {
        int i = 0, res = 0;
        ListNode p = head;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (0 == r.nextInt(i)) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }

}
