package xuefei.jdk;

/**
 * @description: 测试类
 * @author: xuefei
 * @date: 2022/03/03 01:12
 */
public class Test {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.size());
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(linkedList.get(i));
        }

    }
}
