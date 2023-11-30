package labuladong.math;

import labuladong.list.ListNode;

import java.util.Random;

/**
 * @Description 链表随机节点
 * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247490892&idx=1&sn=c1fe373edc88142cbabd383ef3c0669b
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247498181&idx=1&sn=1e015d4bae3491beb1070c1105428577&scene=21#wechat_redirect
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


    /* 返回链表中 k 个随机节点的值 */
    int[] getRandom(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;

        // 前 k 个元素先默认选上
        for (int i = 0; i < k && p != null; i++) {
            res[i] = p.val;
            p = p.next;
        }

        int i = k;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            int j = r.nextInt(i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }


//    List<Integer> list = new ArrayList<>();
//    Random random = new Random(20220116);
//    public Solution(ListNode head) {
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//    }
//    public int getRandom() {
//        int idx = random.nextInt(list.size());
//        return list.get(idx);
//    }

}
