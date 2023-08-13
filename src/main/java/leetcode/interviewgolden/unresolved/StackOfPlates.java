package leetcode.interviewgolden.unresolved;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 堆盘子
 * @author: xuefei
 * @date: 2023/08/13 18:58
 */
public class StackOfPlates {

    // 每堆盘子的容量
    int capacity;

    // 盘子堆
    List<Deque<Integer>> allPlates;

    // 初始化容量及盘子堆
    public StackOfPlates(int cap) {
        this.capacity = cap;
        allPlates = new LinkedList<>();
    }

    public void push(int val) {
        // 容量为0，不需要继续放盘子
        if (capacity <= 0) {
            return;
        }
        // 没有盘子堆 或者 最后一堆的数量等于容量时，需要新开一堆盘子
        if (allPlates.isEmpty() || allPlates.get(allPlates.size() - 1).size() == capacity) {
            allPlates.add(new ArrayDeque<>());
        }
        // 放最后
        allPlates.get(allPlates.size() - 1).push(val);
    }


    public int pop() {
        // 没有盘子了 返回-1
        if (allPlates.size() == 0) {
            return -1;
        }
        // 从最后一堆盘子顶上拿一个盘子
        int result = allPlates.get(allPlates.size() - 1).pop();
        // 拿完之后，如果空了，就把这堆删掉
        if (allPlates.get(allPlates.size() - 1).size() == 0) {
            allPlates.remove(allPlates.size() - 1);
        }
        return result;
    }


    public int popAt(int index) {
        // 如果索引不合法，并且没有盘子了，就返回-1
        if (index < 0 || index >= allPlates.size()) {
            return -1;
        }
        int result = allPlates.get(index).pop();
        if (allPlates.get(index).size() == 0) {
            allPlates.remove(index);
        }
        return result;
    }

}

