package leetcode.daily;

/**
 * @Description 判断是否可以赢得数字游戏
 * @Author xuefei
 * @Date 2024/11/30 1:52
 * @Version 1.0
 */
public class CanAliceWin {

    public boolean canAliceWin(int[] nums) {
        int singleSum = 0;
        int doubleSum = 0;
        for (int num : nums) {
            if (num < 10) {
                singleSum += num;
            } else {
                doubleSum += num;
            }
        }
        return singleSum != doubleSum;
    }

    public boolean canAliceWin_linca(int[] nums) {
        int s = 0;
        for (int x : nums) {
            s += x < 10 ? x : -x;
        }
        return s != 0;
    }


}
