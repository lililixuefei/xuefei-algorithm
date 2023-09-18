package leetcode.interviewgolden.unresolved;

/**
 * @Description 生存人数
 * @Author xuefei
 * @Date 2023/9/18 23:43
 * @Version 1.0
 */
public class MaxAliveYear {

    public int maxAliveYear(int[] birth, int[] death) {
        // 先统计每年的人口数变化
        int[] change = new int[102];
        for (int i = 0; i < birth.length; i++) {
            // eg:1900年出生的人导致1900年变化人数加1，存储在change[0]
            change[birth[i] - 1900]++;
            // eg:1900年死亡的人导致1901年变化人数减1，存储在change[1]
            change[death[i] - 1899]--;
        }
        int maxAlive = 0;
        int curAlive = 0;
        int theYear = 1900;
        // 再根据每年变化人数求一个最大值
        for (int i = 0; i < 101; i++) {
            curAlive += change[i];
            if (curAlive > maxAlive) {
                maxAlive = curAlive;
                theYear = 1900 + i;
            }
        }
        return theYear;
    }


}
