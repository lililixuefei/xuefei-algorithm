package a.labuladong;

/**
 * @description: 两数之和 II - 输入有序数组
 * @author: xuefei
 * @date: 2022/07/12 22:34
 */
public class TwoSum {


    // 双指针
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int right = numbers.length - 1;
        int left = 0;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }


    // 暴力循序
    public int[] twoSum_violence(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 1) {
            return res;
        }

        for (int i = 0; i < numbers.length; i++) {
            int result = target - numbers[i];
            int j = i + 1;

            if (numbers[numbers.length - 1] < result) {
                continue;
            }

            for (; j < numbers.length; j++) {
                if (numbers[j] == result) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
    }


}
