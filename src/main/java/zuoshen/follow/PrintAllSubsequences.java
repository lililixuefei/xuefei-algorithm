package zuoshen.follow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description: 打印字符串的全部子序列
 * @author: xuefei
 * @date: 2023/05/13 20:46
 */
public class PrintAllSubsequences {

	public static void main(String[] args) {
		PrintAllSubsequences printAllSubsequences = new PrintAllSubsequences();
		List<String> ans = new ArrayList<>();
		String str = "abc";
		printAllSubsequences.printAllSubsequences(str, ans);
		Stream.of(ans).forEach(System.out::println);
	}

	public void printAllSubsequences(String str, List<String> ans) {
		process(str.toCharArray(), 0, ans, "");
	}

	public void process(char[] str, int index, List<String> ans, String path) {
		if (index == str.length) {
			ans.add(path);
			return;
		}
		String no = path;
		process(str, index + 1, ans, no);
		String yes = path + str[index];
		process(str, index + 1, ans, yes);
	}

}
