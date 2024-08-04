package leetcode;

public class LC0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return (bs(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (nums1.length + nums2.length + 1) / 2) +
                bs(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, (nums1.length + nums2.length + 2) / 2)) / 2;
    }

    private double bs(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int count) {
        int len1 = end1 - start1;
        int len2 = end2 - start2;
        if (len1 < 0) {
            return nums2[start2 + count];
        }
        if (len2 < 0) {
            return nums1[start1 + count - 1];
        }
        int mid1 = Math.min(start1 + count / 2 - 1, start1 + len1);
        int mid2 = Math.min(start2 + count / 2 - 1, start2 + len2);
        if (count == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        if (nums1[mid1] > nums2[mid2]) {
            return bs(nums1, start1, end1, nums2, mid2 + 1, end2, count - (mid2 - start2 + 1));
        } else {
            return bs(nums1, mid1 + 1, end1, nums2, start2, end2, count - (mid1 - start1 + 1));
        }
    }

    public static void main(String[] args) {
        int m = -1%3;
        LC0004 lc0004 = new LC0004();
        lc0004.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
    }
}
