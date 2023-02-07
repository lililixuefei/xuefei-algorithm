package xuefei.done.leetcode.everyday;

/**
 * @description: 最后一个单词的长度   https://leetcode.cn/problems/length-of-last-word/
 * @author: xuefei
 * @date: 2022/05/14 16:56
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    public static int lengthOfLastWord(String s){
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

    public static int lengthOfLastWord1(String s) {
        if (s == null) {
            return 0;
        }
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();

    }
}
