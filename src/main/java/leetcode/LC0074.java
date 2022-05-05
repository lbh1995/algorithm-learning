package leetcode;

public class LC0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int all = row * col;
        int left = 0;
        int right = all - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int x = mid / col;
            int y = mid % col;
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
