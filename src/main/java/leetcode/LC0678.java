package leetcode;

public class LC0678 {
    public boolean checkValidString(String s) {
        if (s.equals("")) {
            return true;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = (s.charAt(i) == '*');
        }
        for (int j = 1; j < s.length(); j++) {
            char r = s.charAt(j);
            for (int i = j - 1; i >= 0; i--) {
                char l = s.charAt(i);
                // 子串长度为2的时候需要特殊判断
                if (i == j - 1) {
                    dp[i][j] = ((l == '(' || l == '*') && (r == ')' || r == '*'));
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && ((l == '(' || l == '*') && (r == ')' || r == '*')));
                    for (int k = i; k < j; k++) {
                        dp[i][j] = (dp[i][k] && dp[k + 1][j] || dp[i][j]);
                        if (dp[i][j]) {
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        LC0678 lc0678 = new LC0678();
        lc0678.checkValidString("**)))");
    }
}
