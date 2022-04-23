package leetcode;

/**
 * @author liubinghui
 * @date 2022/4/17 12:19 下午
 */
public class LC1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] road = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            road[trips[i][1]] += trips[i][0];
            road[trips[i][2]] -= trips[i][0];
        }
        int sum = 0;
        for (int cur : road) {
            sum += cur;
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}
