/**
 * LeetCode 1512 Number of Good Pairs
 */
class Solution {
    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer,Integer> container = new HashMap<>();
        for (int num : nums) {
            container.put(num,container.getOrDefault(num,0) + 1);
        }

        AtomicInteger res = new AtomicInteger();
        container.forEach((k,v) -> res.addAndGet(v * (v - 1) / 2));
        return res.get();
    }
}
