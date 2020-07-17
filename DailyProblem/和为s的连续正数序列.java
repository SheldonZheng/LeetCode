/**
 * LeetCode Interview 57 和为s的连续正整数列
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target <= 1) {
            return null;
        }
        int l = 1;
        int r = 2;
        int sum = 1;
        List<int[]> res = new ArrayList<>();
        while (l <= target / 2) {
            if (sum < target) {
                sum += r;
                r++;
            } else if (sum > target) {
                sum -= l;
                l++;
            } else {
                int[] arr = new int[r - l];
                for (int i = l; i < r; i++) {
                    arr[i - l] = i;
                }
                res.add(arr);
                sum -= l;
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
