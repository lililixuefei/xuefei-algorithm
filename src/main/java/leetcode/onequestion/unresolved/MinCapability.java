package leetcode.onequestion.unresolved;

/**
 * @description: 打家劫舍 IV
 * @author: xuefei
 * @date: 2023/09/19 17:33
 */
public class MinCapability {


    public static void main(String[] args) {
        MinCapability minCapability = new MinCapability();
        int[] nums = {2, 7, 9, 3, 1};
        minCapability.minCapability2(nums, 2);
    }


    public int minCapability2(int[] nums, int k) {
        int left = 0, right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        while (left + 1 < right) { // 开区间写法
            int mid = (left + right) >>> 1;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mx) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= mx) {
                cnt++; // 偷 nums[i]
                i++; // 跳过下一间房子
            }
        }
        return cnt >= k;
    }

    private boolean check2(int[] nums, int k, int mx) {
        int f0 = 0, f1 = 0;
        for (int x : nums) {
            if (x > mx) {
                f0 = f1;
            } else {
                int tmp = f1;
                f1 = Math.max(f1, f0 + 1);
                f0 = tmp;
            }
        }
        return f1 >= k;
    }


    int value = Integer.MAX_VALUE;

    public int minCapability(int[] nums, int k) {

        dfs(nums, k, 0, 0, false, 0);
        return value;
    }


    public void dfs(int[] nums, int k, int i, int count, boolean pre, int curValue) {
        if (count == k) {
            value = Math.min(curValue, value);
            return;
        }
        if (i >= nums.length) {
            return;
        }

        if (pre) {
            dfs(nums, k, i + 1, count, false, curValue);
        } else {
            int curValue2 = Math.max(curValue, nums[i]);
            dfs(nums, k, i + 1, count + 1, true, curValue2);
            dfs(nums, k, i + 1, count, false, curValue);
        }
    }

}
