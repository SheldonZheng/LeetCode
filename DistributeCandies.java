/**
 * LeetCode 575 Distribute Candies
 */
class Solution {
    public int distributeCandies(int[] candyType) {
        if (candyType == null || candyType.length == 0) {
            return 0;
        }
        Set<Integer> container = new HashSet<>();
        for (int i : candyType) {
            container.add(i);
        }
        if (container.size() < candyType.length / 2) {
            return container.size();
        } else {
            return candyType.length / 2;
        }
    }
}
