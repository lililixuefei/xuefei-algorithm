package leetcode.everyday;

/**
 * @description: 去掉最低工资和最高工资后的工资平均值  https://leetcode.cn/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * @author: xuefei
 * @date: 2022/05/14 18:15
 */
public class AverageSalary {

    public double average(int[] salary) {

        int minSalary = salary[0];
        int maxSalary = salary[0];
        int sumSalary = salary[0];
        for (int i = 1; i < salary.length; i++) {
            if (minSalary > salary[i]) {
                minSalary = salary[i];
            }

            if (maxSalary < salary[i]) {
                maxSalary = salary[i];
            }
            sumSalary += salary[i];
        }

        return (double)(sumSalary - minSalary - maxSalary) / (salary.length - 2);

    }
}
