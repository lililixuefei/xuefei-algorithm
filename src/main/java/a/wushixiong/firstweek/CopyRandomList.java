package a.wushixiong.firstweek;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 复制带随机指针的链表
 * @author: xuefei
 * @date: 2022/06/16 23:00
 */
public class CopyRandomList {

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null){
            return null;
        }
        RandomNode cur = head;

        Map<RandomNode,RandomNode> map = new HashMap<>();

        while (cur != null){
            RandomNode node = new RandomNode(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;

        while (cur != null){

            RandomNode node = map.get(cur);
            RandomNode nextNode = map.get(cur.next);
            node.next = nextNode;

            RandomNode randomNode = map.get(cur.random);
            node.random = randomNode;

            cur = cur.next;
        }
        return map.get(head);
    }
}
