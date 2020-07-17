/**
 * LeetCode 1103 Distribute Candies to People
 */
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        if (candies <= 0 || num_people <= 0) {
            return new int[]{};
        }
        int[] result = new int[num_people];
        int i = 0;
        while (candies != 0) {
            int cur = Math.min(candies,i + 1);
            result[i % num_people] += cur;
            candies -= cur;
            i++;
        }
        return result;
    }
}
