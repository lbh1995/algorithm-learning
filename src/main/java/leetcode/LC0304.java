package leetcode;

/**
 * @author liubinghui
 * @date 2022/4/5 4:20 下午
 */
public class LC0304 {
    static class NumMatrix {
        int[][] nums;
        int h;
        int w;
        public NumMatrix(int[][] matrix) {
            h = matrix.length;
            w = h<=0 ? 0 : matrix[0].length;
            nums = new int[h][w];
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (i==0 && j==0) {
                        nums[i][j] = matrix[i][j];
                        continue;
                    }
                    int upSum = 0;
                    int leftSum = 0;
                    int upLeftSum = 0;
                    if (i-1>=0) {
                        leftSum = nums[i-1][j];
                    }
                    if (j-1>=0){
                        upSum = nums[i][j-1];
                    }
                    if (i-1>=0 && j-1>=0) {
                        upLeftSum = nums[i-1][j-1];
                    }
                    nums[i][j] = leftSum + upSum - upLeftSum + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int upSum = 0;
            int leftSum = 0;
            int upLeftSum = 0;
            if (row1 != 0) {
                upSum = nums[row1-1][col2];
            }
            if (col1 != 0) {
                leftSum = nums[row2][col1-1];
            }
            if (row1 != 0 && col1 != 0) {
                upLeftSum = nums[row1-1][col1-1];
            }
            return nums[row2][col2] - upSum - leftSum + upLeftSum;
        }
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        int a = numMatrix.sumRegion(2,1,4,3);
    }
}
