package leetcode;

public class LC0275 {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int sum = citations.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < sum - mid) {
                left = mid + 1;
            } else if (citations[mid] > sum - mid) {
                right = mid;
            } else {
                return citations[mid] == 0 ? 0 : sum - mid;
            }
        }
        return citations[left]==0 ? 0 : sum - left;
    }
}
