package leetcode.onequestion.unresolved;

import java.util.*;

/**
 * @Description 课程表 IV
 * @Author xuefei
 * @Date 2023/9/12 22:12
 * @Version 1.0
 */
public class CheckIfPrerequisite {

    public List<Boolean> checkIfPrerequisite_wrong(int numCourses, int[][] prerequisites, int[][] queries) {
        // 建图
        Set<Integer>[] graph = buildGraph(numCourses, prerequisites);

        List<Boolean> res = new ArrayList<>(prerequisites.length);
        int index = 0;
        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];
            boolean flag = graph[j].contains(i);
            res.add(index, flag);
        }
        return res;
    }

    private Set<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        Set<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : prerequisites) {
            int v = edge[1];
            int w = edge[0];
            graph[v].add(w);
        }
        return graph;
    }


    public List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
        }
        int[] indgree = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            ++indgree[p[1]];
            g[p[0]].add(p[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int ne : g[cur]) {
                isPre[cur][ne] = true;
                for (int i = 0; i < numCourses; ++i) {
                    isPre[i][ne] = isPre[i][ne] | isPre[i][cur];
                }
                --indgree[ne];
                if (indgree[ne] == 0) {
                    queue.offer(ne);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }

}
