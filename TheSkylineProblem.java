/**
 * LeetCode 218 The Skyline Problem
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildLines = new ArrayList<>();
        for (int[] building : buildings) {
            buildLines.add(new int[]{building[0],-building[2]});
            buildLines.add(new int[]{building[1],building[2]});
        }

        Collections.sort(buildLines,(x , y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y - x);
        maxHeap.add(0);
        int preMaxH = 0;
        for (int[] buildLine : buildLines) {
            if (buildLine[1] < 0) {
                maxHeap.add(-buildLine[1]);
            } else {
                maxHeap.remove(buildLine[1]);
            }
            int curMaxH = maxHeap.peek();
            if (curMaxH != preMaxH) {
                res.add(Arrays.asList(buildLine[0],curMaxH));
                preMaxH = curMaxH;
            }
        }
        return res;
    }
}
