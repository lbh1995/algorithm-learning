package leetcode;

public class LC0343 {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int count_3 = 0;
        int count_2 = 0;
        if (n % 3 == 1) {
            count_3 = n / 3 - 1;
        } else {
            count_3 = n / 3;
        }
        count_2 = (n - 3 * count_3) / 2;
        return (int) (Math.pow(3, count_3) * Math.pow(2, count_2));
    }
}
