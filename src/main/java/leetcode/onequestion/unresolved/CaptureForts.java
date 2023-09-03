package leetcode.onequestion.unresolved;

/**
 * @description: 最多可以摧毁的敌人城堡数目
 * @author: xuefei
 * @date: 2023/09/03 21:56
 */
public class CaptureForts {

    public static void main(String[] args) {
        int[] forts = {1, 0, 0, -1, 0, 0, -1, 0, 0, 1};
        captureForts(forts);
    }

    public static int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    ans = Math.max(ans, i - pre - 1);
                }
                pre = i;
            }
        }
        return ans;
    }


    public static int captureForts_wrong(int[] forts) {
        int n = forts.length;

        int firstOne = -1;
        int firstMinusOne = -1;

        int lastOne = n;
        int lastMinusOne = n;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 && firstOne == -1) {
                firstOne = i;
            }
            if (forts[i] == -1 && firstMinusOne == -1) {
                firstMinusOne = i;
            }
            if (forts[i] == 1) {
                lastOne = i;
            }
            if (forts[i] == -1) {
                lastMinusOne = i;
            }
        }
        int count1 = 0;
        for (int i = firstOne; i <= lastMinusOne; i++) {
            if (forts[i] == 0) {
                count1++;
            }
        }
        int count2 = 0;
        for (int i = firstMinusOne; i <= lastOne; i++) {
            if (forts[i] == 0) {
                count2++;
            }
        }
        return Math.max(count1, count2);
    }

}
