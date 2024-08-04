package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC1301 {
    char barrier = 'X';
    int[][] f;
    int[][] g;
    int len;
    int[][] boardValue;

    public int[] pathsWithMaxScore(List<String> board) {
        len = board.size();
        f = new int[len][len];
        g = new int[len][len];
        f[0][0] = 0;
        g[0][0] = 1;
        int mod = 1000000007;
        boardValue = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board.get(i).charAt(j) == 'S' || board.get(i).charAt(j) == 'E') {
                    boardValue[i][j] = 0;
                } else if (board.get(i).charAt(j) == 'X') {
                    boardValue[i][j] = -1;
                } else {
                    boardValue[i][j] = board.get(i).charAt(j) - '0';
                }
            }
        }

        for (int k = 1; k <= 2 * (len - 1); k++) {
            // 斜对角遍历
            for (int i = 0; i < len; i++) {
                int j = k - i;
                if (j < 0 || j >= len) {
                    continue;
                }
                if (boardValue[i][j] == -1) {
                    f[i][j] = -1;
                    g[i][j] = 0;
                } else {
                    int[] left = getValue(i, j - 1, boardValue);
                    int[] up = getValue(i - 1, j, boardValue);
                    int[] leftUp = getValue(i - 1, j - 1, boardValue);
                    int curMax = Math.max(left[0], Math.max(up[0], leftUp[0]));
                    if (curMax == -1) {
                        f[i][j] = -1;
                        g[i][j] = 0;
                    } else {
                        f[i][j] = curMax + boardValue[i][j];
                        if (left[0] == curMax) {
                            g[i][j] = (g[i][j] + left[1]) % mod;
                        }
                        if (up[0] == curMax) {
                            g[i][j] = (g[i][j] + up[1]) % mod;
                        }
                        if (leftUp[0] == curMax) {
                            g[i][j] = (g[i][j] + leftUp[1]) % mod;
                        }
                    }
                }
            }
        }
        return new int[]{f[len - 1][len - 1] == -1 ? 0 : f[len - 1][len - 1], g[len - 1][len - 1]};
    }

    public int[] getValue(int i, int j, int[][] boardValue) {
        if (i < 0 || i >= len || j < 0 || j >= len) {
            return new int[]{-1, 0};
        }
        if (boardValue[i][j] == -1) {
            return new int[]{-1, 0};
        }
        return new int[]{f[i][j], g[i][j]};
    }

    public static void main(String[] args) {
        LC1301 lc1301 = new LC1301();
        List<String> list = new ArrayList<>();
        list.add("E11");
        list.add("XXX");
        list.add("11S");
        lc1301.pathsWithMaxScore(list);
    }
}
