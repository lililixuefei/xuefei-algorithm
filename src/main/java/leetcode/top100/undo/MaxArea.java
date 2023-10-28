package leetcode.top100.undo;

/**
 * @Description 盛最多水的容器
 * @Author xuefei
 * @Date 2023/10/28 18:07
 * @Version 1.0
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            // [left, right] 之间的矩形面积
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur_area);
            // 双指针技巧，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

}
