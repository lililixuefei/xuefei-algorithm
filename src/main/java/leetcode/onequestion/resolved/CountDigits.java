package leetcode.onequestion.resolved;

/**
 * @description: 统计能整除数字的位数
 * @author: xuefei
 * @date: 2023/10/26 19:06
 */
public class CountDigits {

    public static void main(String[] args) {
        System.out.println(countDigits(121));
    }

    public static int countDigits(int num) {
        int temp = num;
        int[] nums = new int[10];
        while (temp != 0) {
            int i = temp % 10;
            nums[i]++;
            temp = temp / 10;
        }

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (num % i == 0) {
                count += nums[i];
            }
        }
        return count;
    }

}
