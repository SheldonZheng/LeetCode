/**
 * LeetCode 502 IPO
 */
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (profits == null || profits.length == 0 || capital == null || capital.length == 0) {
            throw new IllegalArgumentException();
        }
        List<int[]> couple = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            couple.add(new int[]{capital[i],profits[i]});
        }
        Collections.sort(couple,(a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        int p = 0;
        while (k > 0) {
            while (p < profits.length && couple.get(p)[0] <= w) {
                queue.add(couple.get(p++)[1]);
            }
            if (queue.isEmpty()) {
                break;
            }
            w += queue.poll();
            k--;
        }
        return w;
    }
}
