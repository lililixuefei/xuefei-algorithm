package leetcode.basic.prefixand.done;

/**
 * @description: 找到最高海拔
 * @author: xuefei
 * @date: 2023/02/21 22:26
 */
public class LargestAltitude {

    public int largestAltitude(int[] gain) {

        int pre = 0;
        int value = 0;
        for (int i = 1; i <= gain.length; i++) {
            pre = pre + gain[i - 1];
            value = Math.max(value, pre);
        }
        return value;
    }

}
