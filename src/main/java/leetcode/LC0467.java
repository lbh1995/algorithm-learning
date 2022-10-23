package leetcode;

public class LC0467 {
    public int findSubstringInWraproundString(String p) {
        int[] max = new int[26];
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i == 0) {
                cur = 1;
            } else if (isRound(p.charAt(i-1), p.charAt(i))) {
                cur = 1 + cur;
            } else {
                cur = 1;
            }
            max[p.charAt(i) - 'a'] = Math.max(cur, max[p.charAt(i) - 'a']);
        }
        for (int num : max) {
            ans += num;
        }
        return ans;
    }

    public boolean isRound(char c, char n) {
        if (c == 'z' && n == 'a') {
            return true;
        }
        return n == c + 1;
    }
}
