package xuefei.labuladong.array;

import java.util.Arrays;

/**
 * @description: 差分数组
 * @author: xuefei
 * @date: 2023/01/30 22:38
 */
public class DiffArray {

    public static void main(String[] args) {
        DiffArray diffArray = new DiffArray(new int[]{8, 2, 6, 3, 1});
        diffArray.increment(1, 3, 3);
        Arrays.stream(diffArray.result()).forEach(System.out::println);
    }


    private int[] diffNums;

    public DiffArray(int[] nums) {
        assert nums.length > 0;
        diffNums = new int[nums.length];
        diffNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diffNums[i] = nums[i] - nums[i - 1];
        }
    }

    public void increment(int i, int j, int val) {
        diffNums[i] += val;
        if (j + 1 < diffNums.length) {
            diffNums[j + 1] -= val;
        }
    }

    public int[] result() {
        int[] result = new int[diffNums.length];
        result[0] = diffNums[0];
        for (int i = 1; i < diffNums.length; i++) {
            result[i] = result[i - 1] + diffNums[i];
        }
        return result;
    }


}
