package leetcode;

public class LC0647 {
    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] += 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - 1 < i + 1) {
                        dp[i][j] += 1;
                    }
                    if (j - 1 >= i + 1 && dp[i + 1][j - 1] != 0) {
                        dp[i][j] += 1;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                count += dp[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC0647 lc0647 = new LC0647();
        lc0647.countSubstrings("bbbab");
    }
}
