/**
 * LeetCode 1744 Can You Eat Your Favorite Candy on Your Favorite Day?
 */
class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        if (candiesCount == null || candiesCount.length == 0 || queries == null || queries.length == 0) {
            return null;
        }
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] cur = queries[i];
            int type = cur[0];
            int day = cur[1];
            int dayliCap = cur[2];

            //最少吃的
            long x1 = day + 1;
            //最多吃的
            long y1 = (long) (day + 1) * dayliCap;
            //至少要吃
            long x2 = type == 0 ? 1 : sum[type - 1] + 1;
            //至多能吃
            long y2 = sum[type];

            answer[i] = !((x1 > y2) || (y1 < x2));
        }
        return answer;
    }
}
