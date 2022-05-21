package leetcode;

public class LC0278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            boolean lv = false;
            if (mid - 1 > 0) {
                lv = isBadVersion(mid - 1);
            }
            if (lv != isBadVersion(mid)) {
                return mid;
            }
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public boolean isBadVersion (Integer obj) {
        return false;
    }
}
