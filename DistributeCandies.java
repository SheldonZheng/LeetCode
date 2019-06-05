//LeetCode 575
class Solution {
    public int distributeCandies(int[] candies) {
        if (candies == null) {
            return 0;
        }
        Set<Integer> kind = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            kind.add(candies[i]);
        }
        int half = candies.length / 2;
        if (kind.size() > half) {
            return half;
        }
        return kind.size();

    }
}
