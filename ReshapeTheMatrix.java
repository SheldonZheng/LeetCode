//LeetCode 566
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) {
            return nums;
        }
        int count = nums.length * nums[0].length;
        if (count != (r * c)) {
            return nums;
        }

        int[][] result = new int[r][c];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = queue.poll();
            }
        }
        return result;

    }
}
