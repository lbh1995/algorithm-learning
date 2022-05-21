package leetcode;

public class LC0222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = (int) Math.pow(2, level);
        int high = (int) Math.pow(2, level + 1) - 1;
        int mid = low + (high - low) / 2;
        while (low < high) {
            mid = low + (high - low + 1) / 2;
            if (existTrace(mid, level, root)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean existTrace(int mid, int level, TreeNode root) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (bits>0) {
            if ((bits & mid) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits = bits >> 1;
        }
        return node != null;
    }
}
