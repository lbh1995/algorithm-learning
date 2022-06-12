package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o2[0]);
            }
        };
        Queue<int[]> queue = new PriorityQueue<int[]>(comparator);
        int[] pts = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < primes.length; i++) {
            queue.add(new int[]{primes[i] * dp[pts[i]], i});
        }
        int idx = 1;
        while (idx <= n - 1) {
            int[] cur = queue.poll();
            if (cur[0] == dp[idx-1]) {
                pts[cur[1]]++;
                queue.add(new int[]{dp[pts[cur[1]]] * primes[cur[1]], cur[1]});
            } else {
                pts[cur[1]]++;
                dp[idx] = cur[0];
                idx++;
                queue.add(new int[]{dp[pts[cur[1]]] * primes[cur[1]], cur[1]});
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        LC0313 lc0313 = new LC0313();
        lc0313.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
    }
}
