package leetcode.onequestion.unresolved;

import java.util.*;

/**
 * @Description 课程表 IV
 * @Author xuefei
 * @Date 2023/9/12 22:12
 * @Version 1.0
 */
public class CheckIfPrerequisite {


    public static void main(String[] args) {
        CheckIfPrerequisite checkIfPrerequisite = new CheckIfPrerequisite();
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] queries = {{0, 4}, {4, 0}, {1, 3}, {3, 0}};
        checkIfPrerequisite.checkIfPrerequisite_wrong(5, prerequisites, queries);
    }

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
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : prerequisites) {
            int w = edge[1];
            int v = edge[0];
            Set<Integer> set = map.getOrDefault(w, new HashSet<>());
            set.add(v);
            map.put(w, set);
        }
        boolean[] vi = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> set = buildGraph2(map, i,vi);
            graph[i] = set;
        }
        return graph;
    }

    private Set<Integer> buildGraph2(Map<Integer, Set<Integer>> map, int i,boolean[] vi) {
        if (vi[i]) {
            return map.get(i);
        }
        vi[i] = true;
        if (map.get(i) == null || map.get(i).size() == 0) {
            return new HashSet<>();
        }
        Set<Integer> res = new HashSet<>();
        for (Integer preCourse : map.get(i)) {
            res.add(preCourse);
            res.addAll(buildGraph2(map, preCourse,vi));
        }
        return res;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] vi = new boolean[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            graph[p[0]].add(p[1]);
        }
        for (int i = 0; i < numCourses; ++i) {
            dfs(graph, isPre, vi, i);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }

    public void dfs(List<Integer>[] graph, boolean[][] isPre, boolean[] vi, int cur) {
        if (vi[cur]) {
            return;
        }
        vi[cur] = true;
        for (int ne : graph[cur]) {
            dfs(graph, isPre, vi, ne);
            isPre[cur][ne] = true;
            for (int i = 0; i < isPre.length; ++i) {
                isPre[cur][i] = isPre[cur][i] | isPre[ne][i];
            }
        }
    }


    public List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indgree = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            ++indgree[p[1]];
            graph[p[0]].add(p[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int ne : graph[cur]) {
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
