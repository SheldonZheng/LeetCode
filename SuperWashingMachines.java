/**
 * LeetCode 517 Super Washing Machines
 */
class Solution {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) {
            throw new IllegalArgumentException();
        }
        int total = Arrays.stream(machines).sum();
        if (total % machines.length != 0) {
            return -1;
        }
        int avg = total / machines.length;
        int res = 0;
        int sum = 0;
        for (int cur : machines) {
            cur -= avg;
            sum += cur;
            res = Math.max(res,Math.max(Math.abs(sum),cur));
        }
        return res;
    }
}
