package leetcode.daily;


import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @description: 安排工作以达到最大收益
 * @author: xuefei
 * @date: 2023/05/24 00:05
 */
public class MaxProfitAssignment {

	public static class Job {
		public int money;
		public int hard;

		public Job(int m, int h) {
			money = m;
			hard = h;
		}
	}

	public static class JobComparator implements Comparator<Job> {
		@Override
		public int compare(Job o1, Job o2) {
			return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
		}
	}

	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

		Job[] jobs = new Job[difficulty.length];
		for (int i = 0; i < difficulty.length; i++) {
			Job job = new Job(profit[i], difficulty[i]);
			jobs[i] = job;
		}
		return getMoney(jobs, worker);
	}

	public static int getMoney(Job[] job, int[] ability) {
		Arrays.sort(job, new JobComparator());
		// key : 难度   value：报酬
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(job[0].hard, job[0].money);
		// pre : 上一份进入map的工作
		Job pre = job[0];
		for (int i = 1; i < job.length; i++) {
			if (job[i].hard != pre.hard && job[i].money > pre.money) {
				pre = job[i];
				map.put(pre.hard, pre.money);
			}
		}
		int ans = 0;
		for (int i = 0; i < ability.length; i++) {
			// ability[i] 当前人的能力 <= ability[i]  且离它最近的
			Integer key = map.floorKey(ability[i]);
			ans += (key != null ? map.get(key) : 0);
		}
		return ans;
	}

}
