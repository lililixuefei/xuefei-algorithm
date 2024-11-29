package leetcode.top100.binarytree;

import labuladong.binarytree.TreeNode;

import java.util.*;

/**
 * @Description 路径总和 III
 * @Author xuefei
 * @Date 2023/12/22 22:37
 * @Version 1.0
 */
public class PathSum {


    // 路径总和 III
	public int pathSumIII(TreeNode root, int sum) {
		// key是前缀和, value是大小为key的前缀和出现的次数
		Map<Long, Integer> prefixSumCount = new HashMap<>();
		// 前缀和为0的一条路径
		prefixSumCount.put(0L, 1);
		// 前缀和的递归回溯思路
		return recursionPathSum(root, prefixSumCount, sum, 0L);
	}

	/**
	 * 前缀和的递归回溯思路
	 * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
	 * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
	 * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
	 *
	 * @param node           树节点
	 * @param prefixSumCount 前缀和Map
	 * @param target         目标值
	 * @param currSum        当前路径和
	 * @return 满足题意的解
	 */
	private int recursionPathSum(TreeNode node, Map<Long, Integer> prefixSumCount, int target, long currSum) {
		// 1.递归终止条件
		if (node == null) {
			return 0;
		}
		// 2.本层要做的事情
		int res = 0;
		// 当前路径上的和
		currSum += node.val;

		//---核心代码
		// 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
		// 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
		// currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
		res += prefixSumCount.getOrDefault(currSum - target, 0);
		// 更新路径上当前节点前缀和的个数
		prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
		//---核心代码

		// 3.进入下一层
		res += recursionPathSum(node.left, prefixSumCount, target, currSum);
		res += recursionPathSum(node.right, prefixSumCount, target, currSum);

		// 4.回到本层，恢复状态，去除当前节点的前缀和数量
		prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
		return res;
	}




	// 路径总和 I
	public boolean hasPathSumI(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		return hasPathSumI(root.left, sum - root.val) || hasPathSumI(root.right, sum - root.val);
	}


	// 路径总和 II
	public List<List<Integer>> pathSumII(TreeNode root, int targetSum) {
		List<List<Integer>> ans = new LinkedList<>();
		if (root == null) {
			return ans;
		}
		List<Integer> path = new LinkedList<>();
		process(root, targetSum, path, ans);
		return ans;

	}

	private void process(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
		if (root.left == null && root.right == null) {
			boolean result = sum == root.val;
			if (result) {
				path.add(root.val);
				ans.add(new ArrayList<>(path));
				path.remove(path.size() - 1);
				return;
			}
		}
		path.add(root.val);
		if (root.left != null) {
			process(root.left, sum - root.val, path, ans);
		}
		if (root.right != null) {
			process(root.right, sum - root.val, path, ans);
		}
		path.remove(path.size() - 1);
	}

}
