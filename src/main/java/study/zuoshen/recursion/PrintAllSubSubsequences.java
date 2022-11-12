package study.zuoshen.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 打印字符串所有子序列
 * @author: xuefei
 * @date: 2022/07/20 01:05
 */
public class PrintAllSubSubsequences {


    public static void main(String[] args) {
        String str = "abcde";
        int index = 0;
        List<String> ans = new ArrayList<>();
        String path = "";
        process(str, index, ans, path);

        ans.forEach(System.out::println);
    }

    private static void process(String str, int index, List<String> ans, String path) {
        if (index == str.length()) {
            ans.add(path);
            return;
        }
        index++;
        process(str, index, ans, path);
        process(str, index, ans, path + str.charAt(index - 1));
    }

}
