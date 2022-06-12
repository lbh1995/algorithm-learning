package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0526 {
    int count = 0;

    public int countArrangement(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> div = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    div.add(j);
                }
            }
            map.put(i, div);
        }
        boolean[] used = new boolean[n + 1];
        dfs(map, 0, used, n);
        return count;
    }

    private void dfs(Map<Integer, List<Integer>> map, int idx, boolean[] used, int n) {
        if (idx >= n) {
            count++;
            return;
        }
        List<Integer> posList = map.get(idx);
        for (Integer pos : posList) {
            if (!used[pos]) {
                used[pos] = true;
                dfs(map, idx+1, used, n);
                used[pos] = false;
            }
        }
    }
}
