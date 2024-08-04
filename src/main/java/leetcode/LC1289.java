package leetcode;

public class LC1289 {
    //    public int minFallingPathSum(int[][] grid) {
//        int[][] dp = new int[2][2];
//        if (grid[0][0] < grid[0][1]) {
//            dp[0][0] = grid[0][0];
//            dp[1][0] = 0;
//            dp[0][1] = grid[0][1];
//            dp[1][1] = 1;
//        } else {
//            dp[0][0] = grid[0][1];
//            dp[1][0] = 1;
//            dp[0][1] = grid[0][0];
//            dp[1][1] = 0;
//        }
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int[][] epoch = new int[2][2];
//        epoch[0][0] =Integer.MAX_VALUE;
//        epoch[0][1] =Integer.MAX_VALUE;
//        epoch[1][0] = cols;
//        epoch[1][1] = cols;
//        for (int i = 1;i<rows;i++) {
//            for (int j=0;j<cols;j++) {
//                if (grid[i][j] < epoch[0][0]) {
//                    epoch[0][1] = epoch[0][0];
//                    epoch[1][1] = epoch[1][0];
//                    epoch[0][0] = grid[i][j];
//                    epoch[1][0] = j;
//                } else if (grid[i][j] < epoch[0][1]) {
//                    epoch[0][1] = grid[i][j];
//                    epoch[1][1] = j;
//                }
//            }
//            update(dp, epoch);
//        }
//    }
//
//    private void update(int[][] dp, int[][] epoch) {
//        int m1 = Integer.MAX_VALUE;
//        int m2 = Integer.MAX_VALUE;
//        int i1;
//        int i2;
//        if (dp[1][0] != epoch[1][0]) {
//            dp[0][0] += epoch[0][0];
//            dp[1][0] = epoch[1][0];
//            if (dp[1][0] != epoch[1][1]) {
//                dp[1][0] += epoch[0][0];
//                dp[1][1] = epoch[1][1];
//            } else {
//                dp[1][0]
//            }
//            return;
//        }
//    }
    public int minFallingPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (cols == 1) {
            return grid[0][0];
        }
        int lastMin1 = 0;
        int lastMin2 = 0;
        int lastMin1Idx = cols;
        int lastMin2Idx = cols;
        for (int i = 0; i < rows; i++) {
            int curMin1 = Integer.MAX_VALUE;
            int curMin2 = Integer.MAX_VALUE;
            int curMin1Idx = cols;
            int curMin2Idx = cols;
            for (int j = 0; j < cols; j++) {
                if (j != lastMin1Idx) {
                    grid[i][j] += lastMin1;
                } else {
                    grid[i][j] += lastMin2;
                }
                if (grid[i][j] < curMin1) {
                    curMin2 = curMin1;
                    curMin2Idx = curMin1Idx;
                    curMin1 = grid[i][j];
                    curMin1Idx = j;
                } else if (grid[i][j] < curMin2) {
                    curMin2 = grid[i][j];
                    curMin2Idx = j;
                }
            }
            lastMin1 = curMin1;
            lastMin1Idx = curMin1Idx;
            lastMin2 = curMin2;
            lastMin2Idx = curMin2Idx;
        }
        return lastMin1;
    }
}
