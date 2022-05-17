package leetcode.study_plan.binary_search;

/**
 * @description: 寻找比目标字母大的最小字母   https://leetcode.cn/problems/find-smallest-letter-greater-than-target/
 * @author: xuefei
 * @date: 2022/05/17 23:36
 */
public class NextGreatestLetter {

    public static void main(String[] args) {

    }

    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        if (target >= letters[length - 1]) {
            return letters[0];
        }
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }
}
