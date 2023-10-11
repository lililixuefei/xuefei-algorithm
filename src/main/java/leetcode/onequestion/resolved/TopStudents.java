package leetcode.onequestion.resolved;

import java.util.*;

/**
 * @Description 奖励最顶尖的 K 名学生
 * @Author xuefei
 * @Date 2023/10/11 22:15
 * @Version 1.0
 */
public class TopStudents {

    public static void main(String[] args) {
        String[] positive_feedback = {"fkeofjpc", "qq", "iio"};
        String[] negative_feedback = {"jdh", "khj", "eget", "rjstbhe", "yzyoatfyx", "wlinrrgcm"};
        String[] report = {"rjstbhe eget kctxcoub urrmkhlmi yniqafy fkeofjpc iio yzyoatfyx khj iio", "gpnhgabl qq qq fkeofjpc dflidshdb qq iio khj qq yzyoatfyx", "tizpzhlbyb eget z rjstbhe iio jdh jdh iptxh qq rjstbhe", "jtlghe wlinrrgcm jnkdbd k iio et rjstbhe iio qq jdh", "yp fkeofjpc lkhypcebox rjstbhe ewwykishv egzhne jdh y qq qq", "fu ql iio fkeofjpc jdh luspuy yzyoatfyx li qq v", "wlinrrgcm iio qq omnc sgkt tzgev iio iio qq qq", "d vhg qlj khj wlinrrgcm qq f jp zsmhkjokmb rjstbhe"};
        int[] student_id = {1, 2};
        int k = 2;

        topStudents(positive_feedback, negative_feedback, report, student_id, k);
    }

    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

        Set<String> positiveSet = new HashSet<>();
        Set<String> negativeSet = new HashSet<>();

        Collections.addAll(positiveSet, positive_feedback);
        Collections.addAll(negativeSet, negative_feedback);

        // 优先级队列
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < student_id.length; i++) {
            String[] reportArray = report[i].split(" ");

            int positiveCount = 0;
            int negativeCount = 0;
            for (String word : reportArray) {
                if (positiveSet.contains(word)) {
                    positiveCount++;
                    continue;
                }
                if (negativeSet.contains(word)) {
                    negativeCount++;
                }
            }
            // 算出成绩
            int grades = positiveCount * 3 - negativeCount;
            int[] curStudentGrades = new int[]{grades, student_id[i]};
            priorityQueue.add(curStudentGrades);
        }
        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ans.add(priorityQueue.poll()[1]);
        }
        return ans;
    }

}
