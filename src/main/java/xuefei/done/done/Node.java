package xuefei.done.done;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/07/17 17:42
 */
public class Node {
   public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
