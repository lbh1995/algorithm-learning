package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liubinghui
 * @date 2021/6/27 9:13 下午
 */
public class LC0909 {
    public static void main(String[] args) {
        //int[][] b = new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        //int[][] b = new int[][]{{1,1,-1},{1,1,1},{-1,1,1}};
        //int[][] b = new int[][]{{-1,-1,-1},{-1,9,8},{-1,8,9}};
        int[][] b = new int[][]{{-1,-1,30,14,15,-1},{23,9,-1,-1,-1,9},{12,5,7,24,-1,30},{10,-1,-1,-1,25,17},{32,-1,28,-1,-1,32},{-1,-1,23,-1,13,19}};
        System.out.println(new LC0909().snakesAndLadders(b));
        System.out.println(91*91*91*91*91%8);
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n*n+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        visited[1] = true;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            for (int i=1;i<7&&cur[0]+i<=n*n;i++){
                int num = i+cur[0];
                if (num == n*n){
                    return cur[1]+1;
                }
                if (!visited[num]){
                    int[] nxt = num2rc(num,n);
                    visited[num] = true;
                    if (board[nxt[0]][nxt[1]] != -1){
                        num = board[nxt[0]][nxt[1]];
                        if (num == n*n){
                            return cur[1]+1;
                        }
                        nxt = num2rc(num,n);
                        visited[num] = true;
                    }
                    q.add(new int[]{num,cur[1]+1});
                }
            }
        }
        return -1;
    }

    public int[] num2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
