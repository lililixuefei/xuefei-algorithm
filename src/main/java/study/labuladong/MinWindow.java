package study.labuladong;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: 最小覆盖子串
 * @author: xuefei
 * @date: 2022/07/12 00:25
 */
public class MinWindow {

    public static void main(String[] args) {

        String s = "ttezcfpdcjpgrzlpmyboveznllxilqogluhocxteiimzhzrtxujuyiikwfsjyjpjdyzfxslfdzhmzygysrtqabayithgeyshwtpumcbpcibbijbabutdxtbgoiosggcectaovcfxkiatucvxyoawkdeanstvbxzdqatneylqinlcrhzqxzmheqirkdmlaoqsqjfujsksgwuzfwpcxdkcvuvgxktzymtovykhtubbsvaxrqarvmtrgozfyugygzoezylsvmtnjundmnuhbpyjdzqeuweavtewtrpofieperuqgoyjfysiyiosgtudmbzhsqwybcpftlwbbwkgwequmfouyjxmkyvepreqtvxogvphrbnofektlznlimzuluacmfuhcryjnpseriuwmfqzgfkqsjmfdmhrtbbwszhhozofhievpuuxzgntpzyvohmhkpffommfmamvlqtcmnaowphnriifpxoamufdgtiuuwqhpljbylpwbzkshszyr";
        String t = "nyehfhqzrkvncccnngoz";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        //维护s串中滑动窗口中各个字符出现次数
        Map<Character, Integer> hs = new HashMap<>();
        //维护t串中各个字符出现次数
        Map<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        //cnt维护s串[left,right]中满足t串的元素的个数，记录相对应字符的总数
        int len = Integer.MAX_VALUE, cnt = 0;
        //区间[left,right]表示当前滑动窗口
        for (int left = 0, right = 0; right < s.length(); right++) {
            hs.put(s.charAt(right), hs.getOrDefault(s.charAt(right), 0) + 1);
            //如果ht表中也包含当前字符
            if (ht.containsKey(s.charAt(right))) {
                //并且hs表中的字符个数<=ht表中的字符个数,说明该字符是必须的，并且还未到达字符串t所要求的数量
                if (hs.get(s.charAt(right)) <= ht.get(s.charAt(right))) {
                    cnt++;
                }
            }
            //收缩滑动窗口
            //如果左边界的值不在ht表中 或者 它在hs表中的出现次数多于ht表中的出现次数
            while (left < right && (!ht.containsKey(s.charAt(left)) || hs.get(s.charAt(left)) > ht.get(s.charAt(left)))) {
                hs.put(s.charAt(left), hs.get(s.charAt(left)) - 1);
                left++;
            }
            //此时滑动窗口包含符串 t 的全部字符
            if (cnt == t.length() && right - left + 1 < len) {
                len = right - left + 1;
                ans = s.substring(left, right + 1);
            }
        }
        return ans;
    }


    public static String minWindow1(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int left = -1;
        int right = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                int[] count = new int[256];
                for (int k = 0; k < substring.length(); k++) {
                    count[substring.charAt(k)]++;
                }
                boolean contains = true;
                for (int m = 0; m < t.length(); m++) {
                    if (count[t.charAt(m)] > 0) {
                        count[t.charAt(m)]--;
                    } else {
                        contains = false;
                        break;
                    }
                }
                if (contains) {
                    if (min > (j - i)) {
                        left = i;
                        right = j;
                        min = Math.min(min, right - left);
                    }
                }
            }
        }
        if (right == -1) {
            return "";
        } else {
            return s.substring(left, right + 1);
        }
    }
}


