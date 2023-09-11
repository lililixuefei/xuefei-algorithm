package leetcode.onequestion.unresolved;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description 课程表 III
 * @Author xuefei
 * @Date 2023/9/11 22:29
 * @Version 1.0
 */
public class ScheduleCourse {

    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {150, 1250}, {2000, 3200}};
        scheduleCourse(courses);
    }

    public static int scheduleCourse2(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // 按照 lastDay 从小到大排序
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        int day = 0; // 已消耗时间
        for (int[] c : courses) {
            int duration = c[0], lastDay = c[1];
            if (day + duration <= lastDay) { // 没有超过 lastDay，直接学习
                day += duration;
                pq.offer(duration);
            } else if (!pq.isEmpty() && duration < pq.peek()) { // 该课程的时间比之前的最长时间要短
                // 反悔，撤销之前 duration 最长的课程，改为学习该课程
                // 节省出来的时间，能在后面上完更多的课程
                day -= pq.poll() - duration;
                pq.offer(duration);
            }
        }
        return pq.size();
    }

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int[] c : courses) {
            int duration = c[0], lastDay = c[1];
            sum += duration;
            q.add(duration);
            if (sum > lastDay) sum -= q.poll();
        }
        return q.size();
    }


}
