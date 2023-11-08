package leetcode.onequestion.resolved;

/**
 * @Description 统计范围内的元音字符串数
 * @Author xuefei
 * @Date 2023/11/8 22:50
 * @Version 1.0
 */
public class VowelStrings {

    private static final String VOWEL = "aeiou";

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String s = words[i];
            if (VOWEL.indexOf(s.charAt(0)) != -1 && VOWEL.indexOf(s.charAt(s.length() - 1)) != -1) {
                ans++;
            }
        }
        return ans;
    }


    public int vowelStrings_me_r(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if ((word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u")) &&
                    (word.endsWith("a") || word.endsWith("e") || word.endsWith("i") || word.endsWith("o") || word.endsWith("u"))) {
                ans++;
            }
        }
        return ans;

    }

}
