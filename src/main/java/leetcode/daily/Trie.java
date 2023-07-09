package leetcode.daily;


/**
 * @description: 实现 Trie (前缀树)
 * @author: xuefei
 * @date: 2023/07/09 15:58
 */
public class Trie {

	private Trie.Node root;


	public Trie() {
		root = new Trie.Node();
	}

	public void insert(String word) {
		if (word == null) {
			return;
		}
		char[] str = word.toCharArray();
		Trie.Node node = root;
		node.pass++;
		int path = 0;
		for (int i = 0; i < str.length; i++) { // 从左往右遍历字符
			path = str[i] - 'a'; // 由字符，对应成走向哪条路
			if (node.nexts[path] == null) {
				node.nexts[path] = new Trie.Node();
			}
			node = node.nexts[path];
			node.pass++;
		}
		node.end++;
	}


	public boolean search(String word) {
		if (word == null) {
			return false;
		}
		char[] chs = word.toCharArray();
		Trie.Node node = root;
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if (node.nexts[index] == null) {
				return false;
			}
			node = node.nexts[index];
		}
		return node.end > 0;
	}

	public boolean startsWith(String pre) {
		if (pre == null) {
			return false;
		}
		char[] chs = pre.toCharArray();
		Trie.Node node = root;
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if (node.nexts[index] == null) {
				return false;
			}
			node = node.nexts[index];
		}
		return node.pass > 0;
	}

	class Node {
		public int pass;
		public int end;
		public Trie.Node[] nexts;

		public Node() {
			pass = 0;
			end = 0;
			nexts = new Trie.Node[26];
		}
	}

}
