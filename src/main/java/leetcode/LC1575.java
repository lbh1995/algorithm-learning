package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC1575 {
    int mod = 1000000007;
    int[][] cache = new int[101][201];

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
//        return memoryDfs(locations, start, finish, fuel);
        return dp(locations, start, finish, fuel);
    }

    private int dp(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        for (int j = 0; j <= fuel; j++) {
            dp[finish][j] = 1;
        }
        for (int j = 0; j <= fuel; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    }
                    int cost = Math.abs(locations[i] - locations[k]);
                    if (cost <= j) {
                        dp[i][j] += dp[k][j - cost];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return dp[start][fuel];
    }

    private int memoryDfs(int[] locations, int start, int finish, int fuel) {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 201; j++) {
                cache[i][j] = -1;
            }
        }
        return dfs(locations, start, finish, fuel);
    }

    private int dfs(int[] locations, int start, int finish, int fuel) {
        if (cache[start][fuel] == -1) {
            cache[start][fuel] = 0;
        }
        if (start == finish) {
            cache[start][fuel] += 1;
            cache[start][fuel] %= mod;
        }
        for (int next = 0; next < locations.length; next++) {
            if (start == next) {
                continue;
            }
            int cost = Math.abs(locations[next] - locations[start]);
            if (cost <= fuel) {
                if (cache[next][fuel - cost] != -1) {
                    cache[start][fuel] += cache[next][fuel - cost];
                } else {
                    cache[start][fuel] += dfs(locations, next, finish, fuel - cost);
                }
                cache[start][fuel] %= mod;
            }
        }
        return cache[start][fuel];
    }

    public static void main(String[] args) {
        LC1575 lc1575 = new LC1575();
//        lc1575.countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5);
        int res = lc1575.countRoutes(new int[]{1, 2, 3}, 0, 2, 40);
        System.out.println(res);
    }
}
