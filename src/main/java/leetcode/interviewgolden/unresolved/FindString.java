package leetcode.interviewgolden.unresolved;

/**
 * @Description 稀疏数组搜索
 * @Author xuefei
 * @Date 2023/9/15 23:02
 * @Version 1.0
 */
public class FindString {

    public int findString3(String[] words, String s) {
        int l = 0, r = words.length - 1;
        while (r >= l) {
            while (l <= r && words[l].equals("")) l++;
            while (l <= r && words[r].equals("")) r--;
            int mid = (l + r) >> 1;
            while (mid < r && words[mid].equals("")) {
                mid++;
            }
            if (s.compareTo(words[mid]) == 0) {
                return mid;
            }
            if (s.compareTo(words[mid]) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int findString2(String[] words, String s) {
        int l = 0;
        int r = words.length - 1;
        while (r >= l) {
            int mid = (l + r) >> 1;
            //当前位置为""，mid前移，就这一个和普通二分不同，其他一模一样
            while (mid > l && words[mid].equals("")) {
                mid--;
            }
            if (s.compareTo(words[mid]) == 0) {
                return mid;
            }
            if (s.compareTo(words[mid]) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }


}
