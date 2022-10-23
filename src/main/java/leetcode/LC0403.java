package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0403 {
    int[][] mem;

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        if (stones[stones.length - 1] >= 2000 * 2000) {
            return false;
        }
        mem = new int[stones.length][stones.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        return dfs(stones, map, 1, 1);
    }

    private boolean dfs(int[] stones, Map<Integer, Integer> map, int curIdx, int step) {
        if (mem[curIdx][step] != 0) {
            return mem[curIdx][step] == 1;
        }
        if (curIdx == stones.length - 1) {
            return true;
        }
        for (int nextStep = step - 1; nextStep <= step + 1; nextStep++) {
            if (nextStep == 0) {
                continue;
            }
            int pos = stones[curIdx] + nextStep;
            if (map.containsKey(pos)) {
                boolean res = dfs(stones, map, map.get(pos), nextStep);
                mem[curIdx][step] = res ? 1 : -1;
                if (res) {
                    return true;
                }
            }
        }
        mem[curIdx][step] = -1;
        return false;
    }

    public boolean canCross2(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[0][0] = true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        for (int j = 1; j < stones.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int step = stones[j] - stones[i];
                boolean left = false;
                boolean mid = false;
                boolean right = false;
                if (stones[i] - step - 1 >= 0 && stones[i] - step - 1 <= stones[i]) {
                    left = dp[map.getOrDefault(stones[i] - step - 1, stones.length - 1)][i];
                }
                if (stones[i] - step >= 0 && stones[i] - step <= stones[i]) {
                    mid = dp[map.getOrDefault(stones[i] - step, stones.length - 1)][i];
                }
                if (stones[i] - step + 1 >= 0 && stones[i] - step + 1 <= stones[i]) {
                    right = dp[map.getOrDefault(stones[i] - step + 1, stones.length - 1)][i];
                }
                dp[i][j] = left || right || mid;
            }
        }
        for (int i = stones.length - 1; i >= 0; i--) {
            if (dp[i][stones.length - 1]) {
                return true;
            }
        }
        return false;
    }


    public boolean canCross1(int[] stones) {
        int[][] dp = new int[stones.length][stones.length];
        for (int j = 1; j < stones.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (i == 0) {
                    if (j == 1 && stones[j] == 1) {
                        dp[i][j] = 1;
                    }
                } else {
                    for (int k = i - 1; k >= 0; k--) {
                        if (dp[k][i] == 1) {
                            int lastStep = stones[i] - stones[k];
                            int cur = stones[j] - stones[i];
                            if (cur <= lastStep + 1 && cur >= lastStep - 1) {
                                dp[i][j] = 1;
                            }
                        }
                    }
                }
            }
        }
        for (int i = stones.length - 1; i >= 0; i--) {
            if (dp[i][stones.length - 1] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC0403 lc0403 = new LC0403();
        lc0403.canCross(new int[]{0, 1, 3, 6, 10, 13, 14});
    }
}
