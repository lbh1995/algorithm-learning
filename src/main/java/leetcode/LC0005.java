package leetcode;

public class LC0005 {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int left = 0;
        int right = 0;
        int max = 1;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + len - 1;
                if (j >= s.length()) {
                    break;
                }
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    int sub_i = i + 1;
                    int sub_j = j - 1;
                    int sub = 1;
                    if (sub_i <= sub_j) {
                        sub = dp[sub_i][sub_j];
                    }
                    if (sub == 1 && s.charAt(i) == s.charAt(j)) {
                        if (j - i + 1 > max) {
                            max = j - i + 1;
                            left = i;
                            right = j;
                        }
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
