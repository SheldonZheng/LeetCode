/**
 * LeetCode 313 Super Ugly Number
 */
class Solution {
    public int nthSuperUglyNumber(int n,int[] primes) {
        if (primes == null || primes.length == 0) {
            return -1;
        }
        Set<Long> contains = new HashSet<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        contains.add(1L);
        minHeap.offer(1L);
        long ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = minHeap.poll();
            ugly = cur;
            for (int prime : primes) {
                long next = cur * prime;
                if (contains.add(next)) {
                    minHeap.offer(next);
                }
            }
        }
        return (int) ugly;
    }
}
